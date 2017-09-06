package cn.gss.lk.servlet.back;

import cn.gss.lk.pojo.Notice;
import cn.gss.lk.pojo.Type;
import cn.gss.lk.service.back.NoticeServiceBack;
import cn.gss.lk.service.back.TypeService;
import cn.gss.lk.service.back.impl.NoticeServiceBackImpl;
import cn.gss.lk.service.back.impl.TypeServiceImpl;
import cn.gss.lk.util.DispatcherServlet;

import javax.servlet.annotation.WebServlet;
import java.util.Set;

@WebServlet(name = "NoticeServlet", urlPatterns = "/pages/back/notice/NoticeServlet/*")
public class NoticeServlet extends DispatcherServlet {
	private final String insertValidate = "notice.name|notice.content";
	private NoticeServiceBack noticeService = new NoticeServiceBackImpl();
	private Notice notice = new Notice();

	public Notice getNotice() {
		return notice;
	}

	public String insert() {
		if (noticeService.insert(notice)) {
			setMsgAndUrl("vo.insert.success", "notice.list.servlet");
		} else {
			setMsgAndUrl("vo.insert.failure", "notice.insert.page");
		}
		return "forward.page";
	}
	public String update(){
		if (noticeService.update(notice)) {
			setMsgAndUrl("vo.update.success","notice.list.servlet");
		}else {
			setMsgAndUrl("vo.update.failure","notice.list.servlet");
		}
		return "forward.page";
	}
	public String list(){
		request.setAttribute("allNotice",noticeService.findAll());

		return "notice.list.page";
	}

	public String delete(){
		if (noticeService.delete(getIds())) {
			setMsgAndUrl("vo.delete.success","notice.list.servlet");
		}else {
			setMsgAndUrl("vo.delete.failure","notice.list.servlet");
		}
		return "forward.page";
	}



	@Override
	public String getSubTitle() {
		return "公告";
	}

	@Override
	public String getSubUploadDir() {
		return null;
	}

	@Override
	public String getDefaultColumn() {
		return null;
	}

	@Override
	public String getColumnData() {
		return null;
	}
}
