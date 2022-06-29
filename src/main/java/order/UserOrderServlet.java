package order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/order")
public class UserOrderServlet extends HttpServlet{
	String job="/";
	UserOrderDao dao;
	RequestDispatcher rd;
	String base = "./user/order/user_order";
	String url = "";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("job") != null) {
			job = req.getParameter("job");
		}
		switch(job) {
		case "/" :
		case "selectUId" :
			selectUId(req,resp);
			break;
		case "orderPay" :
			orderPay(req,resp);
			break;
		}
	}
	

	
	public void orderPay(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, NumberFormatException {
		url = "index_main.jsp?inc=" + base + "_detail.jsp";
		List<UserOrderVo> list = new ArrayList<UserOrderVo>();
		UserOrderVo vo = null;
		String rAddress = req.getParameter("rAddress") +" " + req.getParameter("rAddressD");
		boolean b = false;
		String uId = req.getParameter("uId");
		String orderNo = req.getParameter("orderNo");
		int listSize = Integer.parseInt(req.getParameter("listSize"));
		//String[] orderEa = req.getParameterValues("orderEa");
		//String[] price = req.getParameterValues("price");
		//String[] img = req.getParameterValues("img");
		//String[] code = req.getParameterValues("code");	
		
		/*
		 * String orderEa = req.getParameterValues("orderEa")[1];
		 * System.out.println(Integer.parseInt(orderEa));
		 */
		
		System.out.println(uId);
		for(int i = 0; i < listSize; i++) {
			System.out.println(req.getParameterValues("code")[i]);
		}
		
		for(int i = 0; i < listSize; i++) {
			vo = new UserOrderVo();
			vo.setOrderEa(Integer.parseInt(req.getParameterValues("orderEa")[i]));
			vo.setPrice(Integer.parseInt(req.getParameterValues("price")[i]));
			vo.setAmt(Integer.parseInt(req.getParameter("amt")));
			vo.setuId(uId);
			vo.setuName(req.getParameter("uName"));
			vo.setPhone(req.getParameter("phone"));
			vo.setEmail(req.getParameter("email"));
			vo.setOrderDate(req.getParameter("orderDate"));
			vo.setImg(req.getParameterValues("img")[i]);
			vo.setCode(req.getParameterValues("code")[i]);
			vo.setOrderNo(req.getParameter("orderNo"));
		
			vo.setrName(req.getParameter("rName"));
			vo.setrPhone(req.getParameter("rPhone"));
			vo.setrZipcode(req.getParameter("rZipcode"));
			vo.setrAddress(rAddress);
			vo.setRemark(req.getParameter("remark"));
			vo.setPay(req.getParameter("pay"));
			list.add(vo);
		}
		
		System.out.println(req.getParameter("pay"));
		
		for(UserOrderVo vo1 : list) {
			System.out.println(vo1.getCode());
		}
		
		UserOrderDao dao = new UserOrderDao();
		
		
		b = dao.insertOrder(list);
		b = dao.updateItem(list);
		String msg = dao.deleteCart(uId);
		vo = dao.selectOrderNo(orderNo);
		req.setAttribute("vo", vo);
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}

	public void selectUId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		url = "index_main.jsp?inc=" + base + ".jsp";
		UserOrderVo vo = null;
		String uId = req.getParameter("uId");
		//System.out.println(uId);
		UserOrderDao dao = new UserOrderDao();
		vo = dao.selectUId(uId);
		List<UserOrderVo> list = dao.selectCart(uId);
		System.out.println(uId);
		int listSize = list.size();
		
		req.setAttribute("listSize", listSize);
		req.setAttribute("vo", vo);
		req.setAttribute("list", list);
		rd = req.getRequestDispatcher(url);
		
		rd.forward(req, resp);
		
	}

}
