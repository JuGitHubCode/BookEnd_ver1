package customer;

import java.io.IOException;
import java.util.List;

import com.oracle.wls.shaded.org.apache.xalan.xsltc.compiler.Parser;

import bean.PageMgtView;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns ="/mgt/customer.do")
public class MgtCsServlet extends HttpServlet {
	
	RequestDispatcher rd;
	String base="customer/mgt_customer.jsp";
	MgtCsDao dao;

   
    public MgtCsServlet() {
    	
    	System.out.println(" MgtCsServlet serv: ");
    	dao=new MgtCsDao(); 
    }


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" doGet serv: "+req);
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(" doPost serv: "+req);
		
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
		System.out.println(" select method serv: "+req);
		System.out.println(" select serv sort : "+req.getParameter("sort"));
		System.out.println(" select serv type : "+req.getParameter("type"));
		String url=base;
		System.out.println(" select url serv: "+url);
		PageMgtView p=new PageMgtView();
		
		String sort=req.getParameter("sort");
		String sortType=req.getParameter("sortType");
		String type=req.getParameter("type");

		System.out.println(" select serv sort : "+req.getParameter("sort"));
		System.out.println(" select serv sortType : "+req.getParameter("sortType"));
		System.out.println(" select serv type : "+req.getParameter("type"));
		if(sortType==null){
			sortType="asc";
		}
		if(type==null){
			type="uId";
		}

		System.out.println(" ========================================== ");
		System.out.println(" select serv sortType 2: "+sortType);
		System.out.println(" select serv type 2: "+type);
		if(sort==null) {
			sort="birth";
		}
		String temp=req.getParameter("nowPage");
		int nowPage=1;
		try {
			nowPage=Integer.parseInt(temp);
		} catch (Exception e) {
			nowPage=1;
		}
		p.setNowPage(nowPage);
		p.setSort(sort);
		p.setSortType(sortType);
		p.setType(type);
		String findStr=req.getParameter("findStr");
		if(findStr==null) {
			p.setFindStr("");
		}else {
			p.setFindStr(findStr);
		}
		System.out.println(" p serv: "+p.getFindStr());
		List<MgtCsVo> list=dao.select(p);
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
