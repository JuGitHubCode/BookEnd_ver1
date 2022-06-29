package mypage;

public class UserMypageVo {
	// 여기는 ORDERS
	String orderNo;			 // 주문번호
	String uId;				 // 구매자 아이디
	String code; 			 // 구매한 도서코드
	int orderEa; 			 // 수량
	int amt;				 // 총 금액
	String orderDate; 		 // 구매일자
	String rName; 			 // 수령인 이름
	String rPhone; 			 // 전화번호
	String rZipcode; 		 // 배송지 우편번호
	String rAddress; 		 // 배송지 주소
	String paymentType; 	 // 결제 방식
	String remark;			 // 메모
	
	int etc;
	
	int totalAmt;			 // 최종 금액
	
	// 여기는 ITEM
	String codeName; 		 // 구매한 도서명
	int price; 				 // 도서 판매가
	String img; 			 // 도서 이미지

	// 여기는 USER (uId 제외하고)
	String pwd;
	String uName;
	String birth;
	String phone;
	String email;
	String address1;
	String address2;
	String zipCode;
	String gender;
	String date;
	String job;
	
	
	public UserMypageVo() {}
	public UserMypageVo(String orderNo, String uId, String code, int orderEa, int amt, String orderDate, 
						String rName, String rPhone, String rZipcode, String rAddress, String paymentType,
						String codeName, int price, String img, String pwd, String uName, String birth,
						String phone, String email, String address1, String address2, String zipCode, String gender, String date, 
						String job, int totalAmt, String remark, int etc) {
		this.orderNo = orderNo;
		this.uId = uId;
		this.code = code;
		this.orderEa = orderEa;
		this.amt = amt;
		this.orderDate = orderDate; 
		this.rName = rName;
		this.rPhone = rPhone; 
		this.rZipcode = rZipcode;
		this.rAddress = rAddress; 
		this.paymentType = paymentType;
		this.remark = remark;
		
		this.codeName = codeName;
		this.price = price; 
		this.img = img; 

		this.pwd = pwd;
		this.uName = uName;
		this.birth = birth;
		this.phone = phone;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.zipCode = zipCode;
		this.gender = gender;
		this.date = date;
		this.job = job;
		
		this.totalAmt = totalAmt;
		this.etc = etc;
	}
	
	/* GETTERS AND SETTERS */
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getOrderEa() {
		return orderEa;
	}
	public void setOrderEa(int orderEa) {
		this.orderEa = orderEa;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrPhone() {
		return rPhone;
	}
	public void setrPhone(String rPhone) {
		this.rPhone = rPhone;
	}
	public String getrZipcode() {
		return rZipcode;
	}
	public void setrZipcode(String rZipcode) {
		this.rZipcode = rZipcode;
	}
	public String getrAddress() {
		return rAddress;
	}
	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(int totalAmt) {
		this.totalAmt = totalAmt;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getEtc() {
		return etc;
	}
	public void setEtc(int etc) {
		this.etc = etc;
	}
	
}
