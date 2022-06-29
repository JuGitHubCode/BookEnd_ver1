package subpage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.swing.JOptionPane;

import bean.pageMain;
import cart.UserCartVo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import member.UserMemberVo;

@WebServlet(urlPatterns = "/userSubPage.do")
public class UserSubPageServlet extends HttpServlet{
	RequestDispatcher rd;
	String PageBase = "user/subpage/user_subPage_";
	String memberBase = "user/member/user_member_";
	UserSubPageDao dao;
	
	int ea = 0;				//detail의 상품 수량
	String job="";			//페이지 타입
	String bookCode ="";	//detail의 상품 코드
	String findStr = "";	//검색어
	int categoryType = 0;
	String url = "";
	List<UserSubPageVo> list = null;
	int nowPage = 0;
	pageMain page = null;
	
	//idCheck시 필요
	String UserId = "";
	
	//카테고리 숫자 -> 문자
	public String Category(int number){
		String str = "";
		switch(number) {
		case 0:
			str = "소설";
			break;
		case 1:
			str = "시/에세이";
			break;
		case 2:
			str = "인문";
			break;
		case 3:
			str = "자기계발";
			break;
		case 4:
			str = "교재/참고서";
			break;
		}
		return str;
	}
	
	//카테고리 숫자를 한글로 바꿔주는 코드
	public List<UserSubPageVo> ChangeCategoryList(List<UserSubPageVo> list){
		for(int i=0;i<list.size();i++) {
			UserSubPageVo vo = list.get(i);
			String temp = Category(list.get(i).category);
			vo.viewCategory = temp;
			list.set(i, vo);
		}
		return list;
	}
	public UserSubPageVo ChangeCategoryVo(UserSubPageVo vo) {
		String temp = Category(vo.category);
		vo.viewCategory = temp;
		return vo;
	}

		
	
	public UserSubPageServlet() {
		dao = new UserSubPageDao();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		if(req.getParameter("job") != null) {
			job = req.getParameter("job");
		}
		
		try {
			nowPage = Integer.parseInt(req.getParameter("nowPage"));
			System.out.println("[nowPage = (" + nowPage + ") 로 Setting]");
		}catch(Exception ex) {
			nowPage = 1;
			System.out.println("[nowPage = 1 로 Setting]");
		}
		
		switch(job) {
		case "category":		//카테고리
			Category(req,resp);
			break;
		case "search":			//검색
			Search(req,resp);
			break;
		case "details":			//상세
			Details(req,resp);
			break;
		case "login":			//로그인
			Login(req,resp);
			break;
		case "cart":			//장바구니 이동
			Cart(req,resp);
			break;
		case "cartR":			//장바구니에 추가
			CartR(req,resp);
			break;
		case "myPage":			//마이페이지
			MyPage(req,resp);
			break;
		case "AD":				//광고
			AD(req,resp);
			break;
		default:				//메인
			Index(req,resp);
			break;
		}
	}
	//카테고리 페이지
	public void Category(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		findStr = req.getParameter("findStr");
		String str = req.getParameter("cate");
		
		try {
			categoryType = Integer.parseInt(str);
			
			page = new pageMain();
			page.setFindStr(findStr);
			page.setNowPage(nowPage);
			page.setCategoryType(categoryType);
			
			list = dao.CategorySelect(page);
			
			//카테고리 숫자를 한글로 바꿔주는 코드
			list = ChangeCategoryList(list);
			
			page = dao.getPage();
			
			
			
		}catch(Exception ex) {
			System.out.println("[Error]UserSubPageServlet_Category");
			ex.printStackTrace();
		}
		
		
		req.setAttribute("list", list);
		req.setAttribute("page", page);
		
		url = PageBase + "category.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req,resp);
	}
	//검색 페이지
	public void Search(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		findStr = req.getParameter("findStr");
		System.out.println("findStr : " + findStr);
		try {
			page = new pageMain();
			page.setFindStr(findStr);
			page.setNowPage(nowPage);
			
			list = dao.select(page);
			
			//카테고리 숫자를 한글로 바꿔주는 코드
			list = ChangeCategoryList(list);
			
			page = dao.getPage();
			
		}catch(Exception ex) {
			System.out.println("[Error]UsersubPageServlet_Search");
			ex.printStackTrace();
		}
		
		req.setAttribute("list", list);
		req.setAttribute("page", page);
		
		url = PageBase + "search.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req,resp);
	}
	//상세 페이지
	public void Details(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		UserSubPageVo vo = null;
		//code 입력
		bookCode = req.getParameter("book");
		findStr = req.getParameter("findStr");
		
		try {
			vo = dao.DetailSelect(bookCode);
			
			//카테고리 숫자를 한글로 바꿔주는 코드
			vo = ChangeCategoryVo(vo);
			
		}catch(Exception ex) {
			System.out.println("[Error]UserSubPageServlet_Details");
			ex.printStackTrace();
		}
		
		req.setAttribute("vo", vo);
		req.setAttribute("findStr", findStr);
		
		url = PageBase + "details.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req,resp);
	}
	
	
	
	
	
	//로그인
	public void Login(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		url = memberBase + "login.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req,resp);
	}
	//장바구니
	public void Cart(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		url = memberBase + "cart.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req,resp);
	}
	//장바구니에 추가
	public void CartR(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		UserCartVo vo = new UserCartVo();
		boolean b = false;
		try {
			vo.setuId(req.getParameter("userID"));
			vo.setCode(req.getParameter("bookCode"));
			vo.setOrderEa(Integer.parseInt(req.getParameter("bookEaStatus")));
			
			b = dao.insertCart(vo);
		}catch(Exception ex) {
			System.out.println("[Error]UserSubPageServlet_CartR");
			ex.printStackTrace();
		}
		
		PrintWriter out = resp.getWriter();
		out.print(b);
	}
		
	//마이 페이지
	public void MyPage(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		String userid = "";
		UserMemberVo vo = null;
		try {
			userid = req.getParameter("userID");
			vo = dao.selectJob(userid);
			
		}catch(Exception ex) {
			System.out.println("[Error]UserSubPageServlet_MyPage");
			ex.printStackTrace();
		}
		
		
		req.setAttribute("vo", vo);					//받을 때 ${vo.job}, ${vo.uId}, ${vo.uName}
		url = "index_main.jsp?inc=./user/mypage/" + "user_mypage_main.jsp";		
		rd = req.getRequestDispatcher(url);
		rd.forward(req,resp);
	}
	
	//temp.jsp의 광고 선택시
	public void AD(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		boolean b = false;
		UserSubPageVo vo = null;
		bookCode = req.getParameter("bookcode");
		
		try {
			vo = dao.DetailSelect(bookCode);
			
			if(vo == null) {
				b = false;
			}else {
				b = true;
			}
			
		}catch(Exception ex) {
			System.out.println("[Error]UserSubPageServlet_AD");
			//JOptionPane.showMessageDialog(null,"해당 아이템이 존재하지 않습니다, 관리자에게 문의하세요.");
			ex.printStackTrace();
			b = false;
		}
		System.out.println("servelt b : " + b);
		PrintWriter out = resp.getWriter();
		out.print(b);
	}
	
	//메인 페이지
	public void Index(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		url = "index_main.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req,resp);
	}
	
	
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	
}
