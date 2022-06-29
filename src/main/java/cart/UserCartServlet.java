package cart;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/cart.do")
public class UserCartServlet extends HttpServlet{
	UserCartDao dao;
	RequestDispatcher rd;
	String url = "index_main.jsp?inc=user/cart/user_cart.jsp";
	String job = "";
	
	public UserCartServlet(){
		dao = new UserCartDao();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		job = req.getParameter("job");
		
		if(job == null) {
			job = "";
		}
		
		switch(job) {
			case "":
			case "select":
				select(req, resp);
				break;
			case "minusItem" :
				minusItem(req, resp);
				break;
			case "plusItem" :
				plusItem(req, resp);
				break;
			case "deleteItem" : 
				deleteItem(req, resp);
				break;
			case "deleteAllItem" :
				deleteAllItem(req, resp);
				break;
		}
	}

	public void select(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		String uId = req.getParameter("userID");
		
		String address1 = "";
		String address2 = "";
		List<UserCartVo> list = null;
		list = dao.select(uId);
		try {
			address1 = list.get(0).getAddress1();
			address2 = list.get(0).getAddress2();
		} catch(Exception e) {
			address1 = "";
			address2 = "";
		}
		
		req.setAttribute("list", list);
		req.setAttribute("address1", address1);
		req.setAttribute("address2", address2);

		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	public void minusItem(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		UserCartVo vo = null;
		
		try {
			vo = new UserCartVo();
			int orderEa = Integer.parseInt(req.getParameter("ea"));
			String code = req.getParameter("code");
			String uId = req.getParameter("uId");
			vo.setOrderEa(orderEa);
			vo.setCode(code);
			vo.setuId(uId);
			
			dao.minusItem(vo);
			
			
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	public void plusItem(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		UserCartVo vo = null;
		
		try {
			vo = new UserCartVo();
			int orderEa = Integer.parseInt(req.getParameter("ea"));
			String code = req.getParameter("code");
			String uId = req.getParameter("uId");
			vo.setOrderEa(orderEa);
			vo.setCode(code);
			vo.setuId(uId);
			
			dao.plusItem(vo);
			
			
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteItem(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		UserCartVo vo = new UserCartVo();
		String code = req.getParameter("code");
		String uId = req.getParameter("uId");
		vo.setCode(code);
		vo.setuId(uId);
		
		dao.deleteItem(vo);			
	}
	
	public void deleteAllItem(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		String uId = req.getParameter("uId");
		
		dao.deleteAllItem(uId);			
	}
}
