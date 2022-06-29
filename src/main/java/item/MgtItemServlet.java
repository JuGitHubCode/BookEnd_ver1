package item;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import bean.PageItem;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import item.MgtItemVo;

@WebServlet(urlPatterns = "/mgt/item.do")
public class MgtItemServlet extends HttpServlet{

	/* String base = "index_main.jsp?inc=mgt/item/mgt_item_"; */
	String base = "item/mgt_item_"; 
	RequestDispatcher rd;
	MgtItemDao dao;
	
	public MgtItemServlet(){	
		System.out.println("fileser");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("dopostok");
		dao = new MgtItemDao();
		String job="";
	
		if(req.getParameter("job") != null) {
			job = req.getParameter("job");
		}
		
		switch(job) {
		case "" :
		case "select" : 
			select(req,resp);
			break;	
		case "selectEa" :
			selectEa(req,resp);
			break;
		case "selectCode" :
			selectCode(req,resp);
			break;
		case "input" : 
			input(req,resp);
			break;
		case "inputR" : 
			inputR(req,resp);
			break;
		case "modify" : 
			modify(req,resp);
			break;
		case "modifyR" : 
			modifyR(req,resp);
			break;
		case "delete" : 
			delete(req,resp);
			break;
		default :
			select(req,resp);
			}
		} 
	
	public void select(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	

		PageItem p = new PageItem();
		String findStr = req.getParameter("findStr");
		int nowPage = 1;
		
		if(findStr == null) {
			findStr = "";
		}

		try {
			nowPage=Integer.parseInt(req.getParameter("nowPage"));
		}catch(Exception ex) {
			nowPage=1;
		}
		p.setNowPage(nowPage);
		p.setFindStr(findStr);
	
		List<MgtItemVo> list = dao.select(p);
		p=dao.getPage();
		
		req.setAttribute("list", list);
		req.setAttribute("page", p);
		
		String url = base + "list.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req,resp);
	}
	
	public void selectEa(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	

		PageItem p = new PageItem();
		String findStr = req.getParameter("findStr");
		int nowPage = 1;
		
		if(findStr == null) {
			findStr = "";
		}
		try {
			nowPage=Integer.parseInt(req.getParameter("nowPage"));;
		}catch(Exception ex) {
			nowPage=1;
		}
		p.setNowPage(nowPage);
		p.setFindStr(findStr);
	

		List<MgtItemVo> list = dao.selectEa(p);
		p=dao.getPage();
		
		req.setAttribute("list", list);
		req.setAttribute("page", p);
		
		String url = base + "list.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req,resp);
	}
	
	public void selectCode(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	

		PageItem p = new PageItem();
		String findStr = req.getParameter("findStr");
		int nowPage = 1;
		
		if(findStr == null) {
			findStr = "";
		}
		try {
			nowPage=Integer.parseInt(req.getParameter("nowPage"));;
		}catch(Exception ex) {
			nowPage=1;
		}
		p.setNowPage(nowPage);
		p.setFindStr(findStr);
	

		List<MgtItemVo> list = dao.selectCode(p);
		p=dao.getPage();
		
		req.setAttribute("list", list);
		req.setAttribute("page", p);
		
		String url = base + "list.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req,resp);
	}
	
	public void input(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		String url = base + "input.jsp";
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	public void inputR(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	

		MgtItemVo vo = new MgtItemVo();
		vo.setCode(req.getParameter("code"));
		vo.setCodeName(req.getParameter("codeName"));
		vo.setWriter(req.getParameter("writer"));
		vo.setCompany(req.getParameter("company"));
		vo.setCategory(Integer.parseInt(req.getParameter("category")));
		vo.setList(req.getParameter("list"));
		vo.setContents(req.getParameter("contents"));
		vo.setNal(req.getParameter("nal"));
		vo.setPrice(Integer.parseInt(req.getParameter("price")));
		vo.setEa(Integer.parseInt(req.getParameter("ea")));
		
		dao.input(vo);
		
	}
	public void modify(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		
		System.out.println("modify");
		
		String code = req.getParameter("code");
		System.out.println("getparm"+code);
		
		MgtItemVo vo = dao.selectOne(code);
		
		req.setAttribute("vo", vo);
		
		String url = base + "modify.jsp";
		
		System.out.println("수정입력시" + code);
		rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	}
	
	public void modifyR(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		
		MgtItemVo vo = new MgtItemVo();
		vo.setCode(req.getParameter("code"));
		vo.setCodeName(req.getParameter("codeName"));
		vo.setWriter(req.getParameter("writer"));
		vo.setCompany(req.getParameter("company"));
		vo.setCategory(Integer.parseInt(req.getParameter("category")));
		vo.setList(req.getParameter("list"));
		vo.setContents(req.getParameter("contents"));
		vo.setNal(req.getParameter("nal"));
		vo.setPrice(Integer.parseInt(req.getParameter("price")));
		vo.setEa(Integer.parseInt(req.getParameter("ea")));
		
		dao.modifyR(vo);
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		
		String code = req.getParameter("code");
		dao.delete(code);
		
	}
}
