package item;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(
		location = "c:/temp",
		maxFileSize = -1,
		maxRequestSize = -1,
		fileSizeThreshold = 2000 
		)

@WebServlet(urlPatterns = "/mgt/fileUpload")
public class MgtItemUploadServlet extends HttpServlet{

	RequestDispatcher rd;
	MgtItemDao dao;
	
	public MgtItemUploadServlet(){	
		System.out.println("dao전");
		dao = new MgtItemDao();
		
	}

	public static String uploadPath = "C:/2022-02/BookEnd_ver3/src/main/webapp/mgt/itemImg/";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("Upload.. doPost...");
		
		String flag="";
		String img = "";
		String code = "";
		MgtItemAtt att = null;
		
		if(req.getParameter("flag") != null ) {
			flag = req.getParameter("flag");
		}

		if(flag.equals("delete")) {
			String delFile = req.getParameter("delFile");
			File file = new File(uploadPath + delFile);
			if(file.exists()) file.delete();
			
		}else if(flag.equals("input")) {
			//System.out.println("UploadServlet...");
			
			Part p = req.getPart("attFile");
			att = new MgtItemAtt();
			
			if(req.getParameter("code") != null){
				code = req.getParameter("code");
			}
			
			if(p.getHeader("Content-Disposition").contains("filename=")) {
				if(p.getSize()<=0) return;
				
				img = p.getSubmittedFileName();
				p.write(uploadPath + img);
				p.delete();
				
				att.setCode(code);
				att.setOriFile(img);
				dao.inputAtt(att);
				
				} 
		}else { // 수정
			String modifyFile = req.getParameter("modifyFile");

			if(modifyFile == null || modifyFile == "") return;

			File file = new File(uploadPath + modifyFile);
			if(file.exists()) file.delete();

			Part p = req.getPart("attFile");
			att = new MgtItemAtt();
			code = req.getParameter("code");		
			img = p.getSubmittedFileName();
			p.write(uploadPath + img);
			p.delete();
			
			att.setCode(code);
			att.setOriFile(img);
			dao.inputAtt(att);	
		}
	}
}


