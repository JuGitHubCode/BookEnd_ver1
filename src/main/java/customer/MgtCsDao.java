package customer;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import bean.PageMgtView;
import jakarta.websocket.Session;
import mybatis.MybaFactory;

public class MgtCsDao implements MgtCsInterface {
SqlSession session;
PageMgtView page;

	public MgtCsDao() {
		MgtCsVo vo=null;
		session=MybaFactory.getFactory().openSession();
	}
	@Override
	public List<MgtCsVo> select(PageMgtView page) {
		System.out.println("select page dao  : "+page);
		List<MgtCsVo> list=null;
		System.out.println("select page dao  getFindStr : "+page.getFindStr());
		System.out.println("select page dao getSort : "+page.getSort());
		System.out.println("select page dao getSortType : "+page.getSortType());
		System.out.println("select page dao getType : "+page.getType());
		
		try {
			System.out.println("select page dao  getNowPage : "+page.getNowPage());
			int totSize=session.selectOne("mgtcustomer.tot_size",page);
			System.out.println("select page dao totSize : "+totSize);
			page.setTotSize(totSize);
			page.compute();
			page.setStartNo(page.getStartNo()-1);
			System.out.println("select page dao pagecompute : "+page.getTotSize());
			System.out.println("select page dao getStartNo : "+page.getStartNo());
			System.out.println("select page dao getTotPage : "+page.getTotPage());
			System.out.println("select page dao getEndNo : "+page.getEndNo());
			list=session.selectList("mgtcustomer.select",page);
			this.page=page;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("select dao error : ");
		}
		
		return list;
	}
	
	public PageMgtView getpage() {
		return page;
	}

}
