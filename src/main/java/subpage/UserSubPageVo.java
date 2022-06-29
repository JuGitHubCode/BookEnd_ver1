package subpage;

public class UserSubPageVo {
	String code;			//상품코드(도서코드)
	String codeName;		//상품명(도서명)
	String writer;			//저자
	String company;			//출판사
	int category;			//장르
	
	String list;			//목차
	String contents;		//내용
	String nal;				//출간일
	int price;				//단가
	int ea;					//수량
	String img;				//이미지 경로
	
	String viewCategory;	//한글로 변형한 장르
	
	public UserSubPageVo() {}
	
	public UserSubPageVo(String code, String codeName, String writer, String company,
				int category, String list, String contents, String nal,
				int price, int ea, String img) {
		this.code = code;
		this.codeName = codeName;
		this.writer = writer;
		this.company = company;
		this.category = category;
		this.list = list;
		this.contents = contents;
		this.nal = nal;
		this.price = price;
		this.ea = ea;
		this.img = img;
	}
	

	public String getViewCategory() {
		return viewCategory;
	}

	public void setViewCategory(String viewCategory) {
		this.viewCategory = viewCategory;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getNal() {
		return nal;
	}

	public void setNal(String nal) {
		this.nal = nal;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
		this.ea = ea;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
}
