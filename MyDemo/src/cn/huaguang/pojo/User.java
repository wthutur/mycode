package cn.huaguang.pojo;
/**
 * 
 * @功能：管理员实现类
 * @author yangxin
 * @date 2020年8月15日
 * @version jdk 1.8
 */
public class User {
	private String name;
	private String username;
	private String password;
	public String getName() {
		return name;
	}
	public void setId(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String name, String username, String password) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "姓名=" + name + ", 用户名=" + username + ", 密码=" + password;
	}
	

}
