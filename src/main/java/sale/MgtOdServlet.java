package sale;

import java.io.IOException;
import java.util.List;

import bean.PageMgtView;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/mgt/order.do")
public class MgtOdServlet extends HttpServlet {
	RequestDispatcher rd;
	String base="sale/mgt_order.jsp";
	MgtOdDao dao;
    
    public MgtOdServlet() {
        dao=new MgtOdDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" doGet serv: "+req);
		doPost(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("order doPost serv: "+req);
		String url="";
		String job="";
		if(req.getParameter("job")!=null) {
			job=req.getParameter("job");
			System.out.println(" job serv: "+job);
		}
		switch (job) {
		case "select":
			System.out.println(" select serv: ");
			select(req, resp);
			break;
		default:
			System.out.println(" select serv: ");
			select(req, resp);
			break;
		}
		
	}
	
	public void select(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println(" =====select start========= ");
		System.out.println(" order select method serv: "+req);
		System.out.println(" select serv std : "+req.getParameter("std"));
		System.out.println(" select serv edd : "+req.getParameter("edd"));
		System.out.println(" select serv type : "+req.getParameter("type"));
		System.out.println(" select serv findStr : "+req.getParameter("findStr"));
		System.out.println(" select serv sort : "+req.getParameter("sort"));
		System.out.println(" select serv sortType : "+req.getParameter("sortType"));
		System.out.println(" select serv nowPage : "+req.getParameter("nowPage"));
		String url=base;
		System.out.println(" select url serv: "+url);
		PageMgtView p=new PageMgtView();
		
		String std=req.getParameter("std");
		String edd=req.getParameter("edd");
		String type=req.getParameter("type");
		String sortType=req.getParameter("sortType");
		
		System.out.println(" select serv sort : "+req.getParameter("sort"));
		System.out.println(" select serv sortType : "+req.getParameter("sortType"));
		System.out.println(" select serv type : "+req.getParameter("type"));
		if(sortType==null){
			sortType="asc";
		}
		if(type==null){
			type="o.orderNo";
		}

		System.out.println(" ========================================== ");
		System.out.println(" select serv sortType 2: "+sortType);
		System.out.println(" select serv type 2: "+type);
		
		String temp=req.getParameter("nowPage");
		int nowPage=1;
		try {
			nowPage=Integer.parseInt(temp);
		} catch (Exception e) {
			nowPage=1;
		}
		System.out.println(" select serv nowPage null : "+nowPage);

		
		p.setStd(std);
		p.setEdd(edd);
		p.setType(type);
		p.setSortType(sortType);
		p.setNowPage(nowPage);
		
		
		String findStr=req.getParameter("findStr");
		if(findStr==null) {
			p.setFindStr("");
		}else {
			p.setFindStr(findStr);
		}
		System.out.println(" p serv: "+p.getFindStr());
		
		List<MgtOdVo> list=dao.select(p);
		req.setAttribute("list", list);
		p=dao.getpage();
		req.setAttribute("Page", p);
		
		rd=req.getRequestDispatcher(url);
		System.out.println(" list serv: "+list);
		
		try {
			rd.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(" forward forward error: "+req);
		}
		
	}
}
