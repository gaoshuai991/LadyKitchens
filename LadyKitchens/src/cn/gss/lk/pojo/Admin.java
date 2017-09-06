package cn.gss.lk.pojo;

public class Admin {
	private int id;
	private String name;
	private String pwd;
	private String authority;

	public Admin() {
	}

	public Admin(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}

	public Admin(int id, String name, String pwd, String authority) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.authority = authority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
