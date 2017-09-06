package cn.gss.lk.util;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;

import com.jspsmart.upload.Request;
/**
 * 进行参数的验证
 */
public class ValidateParam {
	private Object request;
	private Object obj;
	private String rule;
	private ResourceBundle msgResource;
	// 保存所有的错误信息，其中key为参数名称，value为对应的错误信息
	private Map<String, String> map = new HashMap<>();

	public ValidateParam(Object request, Object obj, String rule, ResourceBundle msgResource) {
		this.obj = obj;
		this.request = request;
		this.rule = rule;
		this.msgResource = msgResource;
	}

	public Map<String, String> getErrorMsgs() {
		return map;
	}

	public boolean validate() {
		String res[] = this.rule.split("\\|");
		for (int x = 0; x < res.length; x++) {
			BeanOperate bo = new BeanOperate(this.obj, res[x]);
			String type = bo.getFieldType();
			String msgKey = null;
			if (type.contains("[]")) {
				String value[] = null;
				if (request instanceof HttpServletRequest)
					value = ((HttpServletRequest) request).getParameterValues(res[x]);
				else
					value = ((Request) request).getParameterValues(res[x]);
				if (value == null || value.length == 0)
					msgKey = "validate.string";
				else {
					for (int y = 0; y < value.length; y++) {
						if (!ValidateUtil.validateEmpty(value[y]))
							msgKey = "validate.string";
						else {
							if ((type.equals("int[]") || type.equals("Integer[]")) && !value[y].matches("\\d+"))
								msgKey = "validate.int";
							else if (type.equalsIgnoreCase("double[]") && !value[y].matches("\\d+(\\.\\d+)?"))
								msgKey = "validate.double";
						}
					}
				}
			} else {
				String value = null;
				if (request instanceof HttpServletRequest)
					value = ((HttpServletRequest) request).getParameter(res[x]);
				else
					value = ((Request) request).getParameter(res[x]);
				if (!ValidateUtil.validateEmpty(value))
					msgKey = "validate.string";
				else {
					if ((type.equals("int") || type.equals("Integer")) && !value.matches("\\d+"))
						msgKey = "validate.int";
					else if (type.equalsIgnoreCase("double") && !value.matches("\\d+(\\.\\d+)?"))
						msgKey = "validate.double";
					else if (type.equals("date") && !value.matches("\\d{4}-\\d{2}-\\d{2}( \\d{2}:\\d{2}:\\d{2})?"))
						msgKey = "validate.date";
				}
			}
			if (msgKey != null)
				map.put(res[x], msgResource.getString(msgKey));
		}
		if (map.size() > 0)
			return false;
		return true;
	}
}
