package cn.gss.lk.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

public class BeanOperate {
	private Object obj;
	private String attribute;
	private String value[];
	private Field field;

	public BeanOperate(Object obj, String attribute, String... value) {
		this.obj = obj;
		this.attribute = attribute;
		try {
			paramHandler();
			if (value != null && value.length != 0) {
				this.value = value;
				paramSetter();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void paramHandler() throws Exception {
		String res[] = this.attribute.split("\\.");
		for (int x = 0; x < res.length; x++) {
			if (x != res.length - 1) {
				Method getMet = this.obj.getClass().getMethod("get" + StringUtil.initCap(res[x]));
				this.field = this.obj.getClass().getDeclaredField(res[x]);
				this.obj = getMet.invoke(this.obj);
			} else {
				this.field = this.obj.getClass().getDeclaredField(res[x]);
			}
		}
	}

	public void paramSetter() throws Exception {
		Method setMet = this.obj.getClass().getMethod("set" + StringUtil.initCap(this.field.getName()),
				this.field.getType());
		String type = getFieldType();
		if (this.value.length == 1) {
			if (type.equals("String")) {
				setMet.invoke(this.obj, value[0]);
			} else if (type.equals("Integer") || type.equals("int")) {
				setMet.invoke(this.obj, Integer.parseInt(value[0]));
			} else if (type.equalsIgnoreCase("double")) {
				setMet.invoke(this.obj, Double.parseDouble(value[0]));
			} else if (type.equals("Date")) {
				if (this.value[0].matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}"))
					setMet.invoke(this.obj, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(value[0]));
				else if (this.value[0].matches("\\d{4}-\\d{2}-\\d{2}"))
					setMet.invoke(this.obj, new SimpleDateFormat("yyyy-MM-dd").parse(value[0]));
			}
		} else if (this.value.length > 1) {
			if (type.equals("String[]")) {
				setMet.invoke(this.obj, (Object) value);
			} else if (type.equals("Integer[]") || type.equals("int[]")) {
				Integer[] numValue = new Integer[value.length];
				for (int x = 0; x < value.length; x++) {
					numValue[x] = Integer.parseInt(value[x]);
				}
				setMet.invoke(this.obj, (Object) numValue);
			} else if (type.equalsIgnoreCase("double[]")) {
				Double[] numValue = new Double[value.length];
				for (int x = 0; x < value.length; x++) {
					numValue[x] = Double.parseDouble(value[x]);
				}
				setMet.invoke(this.obj, (Object) numValue);
			}
		}
	}

	public Field getField() {
		return this.field;
	}

	public String getFieldType() {
		return this.field.getType().getSimpleName();
	}

}
