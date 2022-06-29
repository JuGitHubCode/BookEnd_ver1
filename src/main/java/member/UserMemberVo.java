package member;

public class UserMemberVo {
	String uId;
	String pwd;
	String uName;
	String birth;
	String phone;
	String email;
	String zipCode;
	String address1;
	String address2;
	String gender;
	String joinDate;
	String job;
	
	public UserMemberVo() {}
	public UserMemberVo(String uId, String pwd, String uName, String birth,
			String phone, String email, String zipCode, String address1, String address2, 
			String gender, String joinDate, String job) {
		this.uId = uId;
		this.pwd = pwd;
		this.uName = uName;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
		this.zipCode = zipCode;
		this.address1 = address1;
		this.address2 = address2;
		this.gender = gender;
		this.joinDate = joinDate;
		this.job = job;
	}
	
	//setter, getter
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String zender) {
		this.gender = zender;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	
}
