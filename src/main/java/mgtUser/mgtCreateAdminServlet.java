package mgtUser;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/mgt/mgt_create_user.do")
public class mgtCreateAdminServlet extends HttpServlet {
	
	mgtAdminDao dao;
	RequestDispatcher rd;
	
    
    public mgtCreateAdminServlet() {
    	System.out.println("ser Start===================================================");
    	dao = new mgtAdminDao();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost ser Start===================================================");
		String base="";
		String job="";
		if(req.getParameter("job")!=null) {
			job=req.getParameter("job");
			System.out.println(job);
		}
		switch (job) {
		case "insert": 
			
			insert(req,resp);
			break;
		case "select": 
			select(req,resp);
			break;
		case "selectOne": 
			selectOne(req,resp);
			break;
		case "update": 
			update(req,resp);
			break;
		default:
			select(req,resp);
		}
		
		
	}

	public void insert(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("insert methd ser Start===================================================");
		System.out.println("insert ser : ");
		mgtAdminVo vo=new mgtAdminVo();
		String msg="";
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String today = now.format(formatter);
		System.out.println("date today : "+today);
		System.out.println("insert ser req uId : "+req.getParameter("uId"));
		System.out.println("insert ser req uId : "+req.getParameter("gender"));
		System.out.println("insert ser req uId : "+req.getParameter("zipCode"));
		String uId=req.getParameter("uId");
		String uuId=req.getParameter("uuId");
		String pwd=req.getParameter("pwd");
		String uName=req.getParameter("uName");
		String birth=req.getParameter("birth");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		String address1=req.getParameter("address1");
		String address2=req.getParameter("address2");
		String zipCode=req.getParameter("zipCode");
		String gender=req.getParameter("gender");
		String joinDate=today;
		String job="a";
		
		vo.setuId(uId);		
		vo.setUuId(uuId);
		vo.setPwd(pwd);
		vo.setuName(uName);
		vo.setBirth(birth);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setAddress1(address1);
		vo.setAddress2(address2);
		vo.setGender(gender);
		vo.setZipCode(zipCode);
		vo.setJoinDate(joinDate);
		vo.setJob(job);
		System.out.println("insert ser vo uId : "+vo.getuId());
		System.out.println("insert ser vo getGender : "+vo.getGender());
		System.out.println("insert ser vo : "+vo.getJoinDate());
		boolean b = dao.insert(vo);
		System.out.println(b);
		
		if(b) {
			msg="저장 완료";
		}else {
			msg="저장 오류";
		}
		System.out.println("msg"+msg);
		req.setAttribute("msg", msg);
		
		String url="mgt/logInOut/mgtCreate_user.jsp";
		rd=req.getRequestDispatcher(url);
		
		try {
			rd.forward(req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void select(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("select methd ser Start===================================================");
		System.out.println("select ser : ");
		String uId=req.getParameter("uId");
		String job=req.getParameter("job");
		System.out.println("select ser uId : "+uId);
		System.out.println("select ser job : "+job);
		
		List<mgtAdminVo> list=null;
		
		list = dao.select(uId);
		System.out.println("select ser list : "+list);
		
		
		req.setAttribute("list", list);
		
		//localhost:5555/BookEnd_ver1/mgt/logInOut/user_search.jsp
		String url="logInOut/user_search.jsp";
		rd=req.getRequestDispatcher(url);
		System.out.println("select ser test : "+ rd);
		System.out.println("select ser resp : "+ resp);
		try {
			rd.forward(req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	public void selectOne(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("selectOne methd ser Start===================================================");
		System.out.println("selectOne ser : ");
		String uId=req.getParameter("uId");
		System.out.println("selectOne ser uId : "+uId);
		List<mgtAdminVo> list=null;
		
		list = dao.select(uId);
		System.out.println("selectOne ser list : "+list);
		
		
		req.setAttribute("list", list);
		
		//localhost:5555/BookEnd_ver1/mgt/logInOut/user_search.jsp
		String url="./mgt/logInOut/user_search.jsp";
		rd=req.getRequestDispatcher(url);
		
		try {
			rd.forward(req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("update methd ser Start===================================================");
		System.out.println("update ser : ");
		mgtAdminVo vo=new mgtAdminVo();
		String msg="";
		
		
		System.out.println("update ser req uId : "+req.getParameter("uId"));
		
		
		String uuId=req.getParameter("uuId");
		
		String job="a";
		
		
		vo.setUuId(uuId);
		vo.setJob(job);
		System.out.println("update ser vo getUuId : "+vo.getUuId());
		System.out.println("update ser vo getJob : "+vo.getJob());
		boolean b = dao.update(vo);
		System.out.println("update reslut : "+b);
		
		if(b) {
			msg="저장 완료";
		}else {
			msg="저장 오류";
		}
		System.out.println("msg"+msg);
		req.setAttribute("msg", msg);
		
		String url="/mgt/logInOut/mgt_reate_user.jsp";
		rd=req.getRequestDispatcher(url);
		
		try {
			rd.forward(req,resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
