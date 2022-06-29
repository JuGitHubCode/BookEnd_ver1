package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import bean.SendMail;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/userMember.do")
public class UserMemberServlet extends HttpServlet{
	RequestDispatcher rd;
	SimpleDateFormat sdf;
	UserMemberDao dao;
	String memberBase = "user/member/user_member_";
	//희찬
	String memberurl = "index_main.jsp?inc=user/member/user_member_";
	
	String url="";
	String job="";
	Date today;
	
	public UserMemberServlet() {
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		dao = new UserMemberDao();
		today = new Date();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		job = req.getParameter("job");
		
		switch(job) {
			case "memberLogin" :
				memberLogin(req, resp);
				break;
				
			case "memberLogout" :
				memberLogout(req, resp);
				break;

			case "memberJoin" :
				memberJoin(req, resp);
				break;
			
			case "memberUidValidation" :
				memberUidValidation(req, resp);
				break;
			
			case "memberEmailValidation" :
				memberEmailValidation(req, resp);
				break;
				
			case "memberPhoneValidation" :
				memberPhoneValidation(req, resp);
				break;
				
			case "memberFindPhone" :
				memberFindPhone(req, resp);
				break;			

			case "memberFindEmail" :
				memberFindEmail(req, resp);
				break;
			
			case "memberTempPwd" :
				memberTempPwd(req, resp);
				break;
				
			default :
				
		}
	}	
	
	public void memberLogin(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		UserMemberVo vo = new UserMemberVo();
		HttpSession session = req.getSession();
		vo.setuId(req.getParameter("uId"));
		vo.setPwd(req.getParameter("pwd"));
		
		vo = dao.userMemberLogin(vo);
		
		if(vo.getuId() == "" || vo.getuId() == null) {
			session.setAttribute("uId", null);
			session.setAttribute("job", null);
			session.setAttribute("uName", null);
			req.setAttribute("msg", "아이디 혹은 비밀번호를 확인해주세요.");
		} else {
			session.setAttribute("uId", vo.getuId());	// session에 아이디 저장
			session.setAttribute("job", vo.getJob());
			session.setAttribute("uName", vo.getuName());
			req.setAttribute("uId", vo.getuId());
			req.setAttribute("msg", vo.getuName() + "님 환영합니다.");
		}
		
		url = memberBase + "login.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	public void memberLogout(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.setAttribute("uId", null);
		
		url = "index_main.jsp?inc=./temp.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	public void memberJoin(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException, NumberFormatException {
		UserMemberVo vo = new UserMemberVo();
		
		vo.setuId(req.getParameter("uId"));
		vo.setPwd(req.getParameter("pwd"));
		vo.setuName(req.getParameter("uName"));
		vo.setBirth(req.getParameter("birth"));
		vo.setPhone(req.getParameter("phone"));
		vo.setEmail(req.getParameter("email"));
		vo.setZipCode(req.getParameter("zipCode"));
		vo.setAddress1(req.getParameter("address1"));
		vo.setAddress2(req.getParameter("address2"));
		vo.setGender(req.getParameter("gender"));
		vo.setJoinDate(sdf.format(today)); // 현재날짜
		vo.setJob("");
				
		if(dao.userMemberJoin(vo)) {
			req.setAttribute("msg", "회원가입 되었습니다.");
			url = memberurl + "login.jsp";
		} 
		
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	public void memberUidValidation(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String uId = req.getParameter("uId");		
		boolean uIdValidation = dao.userMemberUidValdation(uId);
		
		resp.setContentType("text/plain;charset=euc-kr");
		PrintWriter out = resp.getWriter();
	
		if(uIdValidation) {
			out.print("validation");
		} else {
			out.print("ok");
		}

	}
	
	public void memberEmailValidation(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String email = req.getParameter("email");	
		boolean emailValidation = dao.userMemberEmailValdation(email);
		resp.setContentType("text/plain;charset=euc-kr");
		PrintWriter out = resp.getWriter();

		if(emailValidation) {
			out.print("validation");
		} else {
			out.print("ok");
		}
	}
	
	public void memberPhoneValidation(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String phone = req.getParameter("phone");		
		boolean phoneValidation = dao.userMemberPhoneValdation(phone);
		resp.setContentType("text/plain;charset=euc-kr");
		PrintWriter out = resp.getWriter();
		
		if(phoneValidation) {
			out.print("validation");
		} else {
			out.print("ok");
		}
	}
	
	public void memberFindPhone(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		UserMemberVo vo = new UserMemberVo();		
			
		vo.setuName(req.getParameter("uName"));
		vo.setPhone(req.getParameter("phone"));
		
		String uId = dao.userMemberFindPhone(vo);
		
		if(uId == "" || uId == null) {
			req.setAttribute("msg", "이름이나 휴대폰 번호를 확인해주세요.");
			url = memberBase + "find_uId.jsp";			
		} else {
			req.setAttribute("uId", uId);
			url = memberBase + "find_result.jsp";
		}
		
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	public void memberFindEmail(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		UserMemberVo vo = new UserMemberVo();
		
		vo.setuName(req.getParameter("uName"));
		vo.setEmail(req.getParameter("email"));
		
		String uId = dao.userMemberFindEmail(vo);
		
		if(uId == "" || uId == null) {
			req.setAttribute("msg", "이름이나 이메일을 확인해주세요.");
			url = memberBase + "find_uId.jsp";			
		} else {
			req.setAttribute("uId", uId);
			url = memberBase + "find_result.jsp";
		}
		
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	public void memberTempPwd(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		UserMemberVo vo = new UserMemberVo();
		String tempPwd;
		SendMail sm = new SendMail();
		String email = req.getParameter("email");
		
		vo.setuId(req.getParameter("uId"));
		vo.setEmail(email);
		
		tempPwd = dao.userMemberTempPwd(vo);
		
		if(tempPwd == "" || tempPwd == null) {
			req.setAttribute("msg", "아이디나 이메일을 확인해주세요.");
			url = memberBase + "find_pwd.jsp";	
		} else {
			req.setAttribute("uId", "");
			req.setAttribute("isEmail", "send");
			if(!sm.sendMail(email, tempPwd)) {
				req.setAttribute("msg", "메일 발송 중 오류가 발생했습니다. 다시 시도해주세요.");
			} 
			url = memberurl + "find_result.jsp";
		}
		
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
}
