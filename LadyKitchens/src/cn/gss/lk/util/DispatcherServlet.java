package cn.gss.lk.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@SuppressWarnings("serial")
public abstract class DispatcherServlet extends HttpServlet {
	private static final String PAGES_BASENAME = "Pages";
	private static final String MSGS_BASENAME = "Messages";
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	private ResourceBundle pagesResource;
	private ResourceBundle msgsResource;
	private SmartUpload smart = null;
	private Integer currentPage;
	private Integer lineSize;
	private String column;
	private String keyword;

	public void init() {
		this.pagesResource = ResourceBundle.getBundle(PAGES_BASENAME, Locale.getDefault());
		this.msgsResource = ResourceBundle.getBundle(MSGS_BASENAME, Locale.getDefault());
	}

	// 获取Pages.properties中的内容
	public String getPath(String key) {
		if(key == null)
			return null;
		return pagesResource.getString(key);
	}

	// 获取Messages.properties中的内容
	public String getMsg(String key, Object... args) {
		if (args.length == 0) {
			return MessageFormat.format(msgsResource.getString(key), getSubTitle());
		} else {
			return MessageFormat.format(msgsResource.getString(key), args);
		}
	}

	// 处理分页
	public void handleSplit() {
		try {
			currentPage = Integer.parseInt(request.getParameter("cp") == null ? "1" : request.getParameter("cp"));
		} catch (Exception e) {
		}
		try {
			lineSize = Integer.parseInt(request.getParameter("ls") == null ? "5" : request.getParameter("ls"));
		} catch (Exception e) {
		}
		try {
			keyword = request.getParameter("kw") == null ? "" : request.getParameter("kw");
		} catch (Exception e) {
		}
		try {
			column = request.getParameter("col") == null ? this.getDefaultColumn() : request.getParameter("col");
		} catch (Exception e) {
		}
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lineSize", lineSize);
		request.setAttribute("column", column);
		request.setAttribute("keyword", keyword);
		request.setAttribute("columnData", this.getColumnData());
//		System.out.println("currPage="+currentPage+",lineSize="+lineSize+",column="+column+",keyword="+keyword);
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		this.request = request;
		this.response = response;
		String path = "/pages/errors.jsp";
//		System.out.println(request.getRequestURI());
		String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/") + 1);
		if (status != null && status.length() > 0) {
			if (this.request.getContentType() != null
					&& this.request.getContentType().contains("multipart/form-data")) {
				this.smart = new SmartUpload();
				this.smart.initialize(super.getServletConfig(), this.request, this.response);
				try {
					this.smart.upload();
				} catch (SmartUploadException e1) {
					e1.printStackTrace();
				}
			}
			if (validateRequest(status)) { // 进行请求参数的验证
				try {
					requestHandler();
					Method met = this.getClass().getMethod(status);
//					System.out.println("Method Name:"+met.getName()+",Obj Class:"+this.getClass().getSimpleName());
					Object res = met.invoke(this);
					if(res == null)
						return;
					path = getPath((String) res);
				} catch (Exception e) {
					if (!(e instanceof NullPointerException))
						e.printStackTrace();
				}
			} else {
				// String referer = request.getHeader("referer");
			}

		}
		this.request.getRequestDispatcher(path).forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	// 处理参数（分析、设置参数）
	private void requestHandler() throws Exception {
//		System.out.println(this.request.getContentType());
		if (this.request.getContentType() != null && this.request.getContentType().contains("multipart/form-data")) {
			@SuppressWarnings("unchecked")
			Enumeration<String> enu = this.smart.getRequest().getParameterNames();
//			System.out.println(enu.hasMoreElements());
			while (enu.hasMoreElements()) {
				String paramName = enu.nextElement();
//				System.out.println(paramName + "*****");
				if (paramName.contains(".")) {
					BeanOperate bo = new BeanOperate(this, paramName);
					if (bo.getFieldType().contains("[]")) {
						bo = new BeanOperate(this, paramName, this.smart.getRequest().getParameterValues(paramName));
					} else {
						bo = new BeanOperate(this, paramName, this.smart.getRequest().getParameter(paramName));
					}
				}
			}
		} else {
			Enumeration<String> enu = this.request.getParameterNames();
			while (enu.hasMoreElements()) {
				String paramName = enu.nextElement();
				if (paramName.contains(".")) {
					BeanOperate bo = new BeanOperate(this, paramName);
					if (bo.getFieldType().contains("[]")) {
						bo = new BeanOperate(this, paramName, this.request.getParameterValues(paramName));
					} else {
						bo = new BeanOperate(this, paramName, this.request.getParameter(paramName));
					}
				}
			}
		}
	}

	public Set<Integer> getIds() {
		Set<Integer> ids = new HashSet<>();
		for (String idstr : request.getParameter("ids").split("\\|")) {
			ids.add(Integer.parseInt(idstr));
		}
		return ids;
	}

	public boolean validateRequest(String status) {
		String rule = null;
		try {
			Field field = this.getClass().getDeclaredField(status + "Validate");
			field.setAccessible(true);
			rule = (String) field.get(this);
		} catch (Exception e) {
			return true;
		}
		if (ValidateUtil.validateEmpty(rule)) {
			ValidateParam vp = null;
			if (this.request.getContentType() != null && this.request.getContentType().contains("multipart/form-data"))
				vp = new ValidateParam(this.smart.getRequest(), this, rule, msgsResource);
			else
				vp = new ValidateParam(request, this, rule, msgsResource);
			boolean flag = vp.validate();
			request.setAttribute("errors", vp.getErrorMsgs());
//			System.out.println(vp.getErrorMsgs());
			return flag;
		} else {
			return true;
		}
	}

	// 进行验证码的验证
	public boolean checkCode() {
		String code = request.getParameter("code");
		String rand = (String) request.getSession().getAttribute("rand");
		if (code == null || rand == null)
			return false;
		return rand.equalsIgnoreCase(code);
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public Integer getLineSize() {
		return lineSize;
	}

	public String getColumn() {
		return column;
	}

	public String getKeyword() {
		return keyword;
	}

	public SmartUpload getSmart() {
		return this.smart;
	}

	public boolean isUpload() throws IOException {
		return this.smart.getFiles().getSize() > 0;
	}

	public boolean isImage(int... index) {
		return this.smart.getFiles().getFile(index.length == 0 ? 0 : index[0]).getContentType().contains("image");
	}

	public int getUploadCount() {
		return this.smart.getFiles().getCount();
	}

	public String createSingleFileName(int... index) throws Exception {
		if (isUpload() && isImage()) {
			return UUID.randomUUID() + "."
					+ this.smart.getFiles().getFile(index.length == 0 ? 0 : index[0]).getFileExt();
		}
		return null;
	}

	public List<String> createMultiFileName() throws Exception {
		List<String> list = null;
		if (isUpload()) {
			list = new ArrayList<>();
			for (int x = 0; x < getUploadCount(); x++) {
				if (isImage(x)) {
					list.add(createSingleFileName(x));
				}
			}
		}
		return list;
	}

	public String getUploadDir() {
		return super.getServletContext().getRealPath(this.getSubUploadDir());
	}

	public void saveFile(String fileName, int... index) throws Exception {
		String filePath = getUploadDir() + fileName;
		File file = new File(filePath);
		if (!file.getParentFile().exists())
			file.getParentFile().mkdirs();
		this.smart.getFiles().getFile(index.length == 0 ? 0 : index[0]).saveAs(filePath);
	}

	public void saveFiles(List<String> list) throws Exception {
		Iterator<String> iter = list.iterator();
		for (int x = 0; iter.hasNext(); x++) {
			saveFile(iter.next(), x);
		}
	}

	public void deleteFile(String fileName) throws Exception {
		File file = new File(getUploadDir() + fileName);
		if (file.exists()) {
			file.delete();
		}
	}

	public void deleteFiles(Set<String> all) throws Exception {
		Iterator<String> iter = all.iterator();
		while (iter.hasNext()) {
			deleteFile(iter.next());
		}
	}

	public void setMsgAndUrl(String msgKey, String urlKey) {
		this.request.setAttribute("msg", this.getMsg(msgKey));
		this.request.setAttribute("url", this.getPath(urlKey));
	}

	public void print(Object msg) {
		try {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 用于子类覆写
	public abstract String getSubTitle();

	public abstract String getSubUploadDir();

	public abstract String getDefaultColumn();

	public abstract String getColumnData();
}
