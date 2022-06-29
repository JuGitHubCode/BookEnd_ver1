package order;

public class UserOrderVo {
	String uId;
	String uName;
	String phone;
	String img;
	String codeName;
	int orderEa;
	int price;
	int amt;
	String rName;
	String rPhone;
	String rAddress;
	String address1;
	String address2;
	String zipCode;
	String rZipcode;
	String orderNo;
	
	String pay;
	String remark;
	String email;
	String orderDate;
	String code;
	
	

	public UserOrderVo() {}
	
	/*
	public UserOrderVo(String uId, String uName, String phone, String img, String codeName,
					   int orderEa, int price, int amt, String rName, String rPhone, 
					   String rAddress,	String rZipcode, String orderNo, String remark, String email) {
		this.uId = uId;
		this.uName = uName;
		this.phone = phone;
		this.img = img;
		this.codeName = codeName;
		this.orderEa = orderEa;
		this.price = price;
		this.amt = amt;
		this.rName = rName;
		this.rPhone = rPhone;
		this.rAddress = rAddress;
		this.rZipcode = rZipcode;
		this.orderNo = orderNo;
		this.remark = remark;
		this.email = email;
		
	}
	*/
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public int getOrderEa() {
		return orderEa;
	}
	public void setOrderEa(int orderEa) {
		this.orderEa = orderEa;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
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
	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public void setrPhone(String rPhone) {
		this.rPhone = rPhone;
	}
	public String getrAddress() {
		return rAddress;
	}
	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}
	public String getrZipcode() {
		return rZipcode;
	}
	public void setrZipcode(String rZipcode) {
		this.rZipcode = rZipcode;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	
	

}
