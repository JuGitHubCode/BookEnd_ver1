package bean;

public class PageMypage {
	int startNo;		// 목록의 시작 위치				// endNo - listSize + 1 (MySQL는 제로베이스이기 때문에 +1은 불필요함.)
	int endNo;			// 목록의 끝 위치 				// listSize * nowPage
													// if(endNo > totSize) endNo = totSize;
	int listSize = 10;	// 목록의 행수
	int totSize;		// 검색된 전체 건수
	int blockSize = 5;	// 표시될 페이지의 수
	int totPage;		// 전체 페이지 수 				// (int)Math.ceil(totSize / (double)listSize) 
													// (건수에 따라 페이지수가 맞아 떨어지지 않을 수 있어 절상함.)
													// (예를 들어, 페이지 당 30건씩 넣는다면 마지막 페이지에는 20건 밖에 못 넣음. 
													//  30건을 채우지 못 한다고 그 페이지를 없애는 것이 아니라 남은 건수들까지 
													// 모두 마지막 페이지에 보여줘야 하기 때문에 절상함.)
	int startPage;		// 페이지의 시작 위치 			// endPage - blockSize + 1 (startNo 구하는 공식과 동일함.)
	int endPage;		// 페이지의 끝 위치 			// (int)Math.ceil(nowPage / (double)blockSize) * blockSize
													// if(endPage > totPage) endPage = totPage;
	int nowPage;		// 사용자가 보고있는 현재 페이지
	String findStr; 	// 검색창
	String uId;
	String orderNo;
	
	public PageMypage() {
		compute();
	}
	public PageMypage(int totSize, int nowPage) {
		this.totSize = totSize;
		this.nowPage = nowPage;
		compute();
	}
	public void compute() {
		totPage = (int)Math.ceil(totSize/(double)listSize);
		endNo = listSize*nowPage;
		startNo = endNo-listSize+1;
		if(endNo>totSize) endNo = totSize;
		
		endPage = (int)Math.ceil(nowPage/(double)blockSize)*blockSize;
		startPage = endPage-blockSize+1;
		if(endPage>totPage) endPage = totPage;
	}
	
	public static void main(String[] args) {
		PageMypage p = new PageMypage();
		p.setTotSize(564);
		p.setNowPage(8);
		p.compute();
		System.out.println("totPage: " + p.getTotPage());
		System.out.println("startNo: " + p.getStartNo());
		System.out.println("endNo: " + p.getEndNo());
		System.out.println("startPage: " + p.getStartPage());
		System.out.println("endPage: " + p.getEndPage());
	}
	
	// GETTER & SETTER SECTION
	public int getStartNo() {
		return startNo;
	}
	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}
	public int getEndNo() {
		return endNo;
	}
	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	public int getTotSize() {
		return totSize;
	}
	public void setTotSize(int totSize) {
		this.totSize = totSize;
	}
	public int getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}
	public int getTotPage() {
		return totPage;
	}
	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public String getFindStr() {
		return findStr;
	}
	public void setFindStr(String findStr) {
		this.findStr = findStr;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
}
