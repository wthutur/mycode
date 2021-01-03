package cn.huaguang.pojo;
/**
 * 
 * @功能：学生实现类
 * @author yangxin
 * @date 2020年8月15日
 * @version jdk 1.8
 */
public class Student {
	private String number;
	private String name;
	private String sex;
	private String phone;
	private String birthday;
	private String address;
	private String chinese;
	private String math;
	private String english;
	public Student() {
		super();
	}
	public Student(String number, String name, String sex, String phone, String birthday, String address, String chinese,
			String math, String english) {
		super();
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.phone = phone;
		this.birthday = birthday;
		this.address = address;
		this.chinese = chinese;
		this.math = math;
		this.english = english;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		this.chinese = chinese;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getMath() {
		return math;
	}
	public void setMath(String math) {
		this.math = math;
	}
	@Override
	public String toString() {
		return "学号=" + number + ", 姓名=" + name + ", 性别=" + sex + ", 手机号码=" + phone + ", 出生日期=" + birthday
				+ ", 家庭地址=" + address + ", 语文成绩=" + chinese  + ", 数学成绩=" + math+ ", 英语成绩=" + english;
	}
	
	

}
