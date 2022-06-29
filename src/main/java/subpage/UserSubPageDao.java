package subpage;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.pageMain;
import cart.UserCartVo;
import member.UserMemberVo;
import mybatis.MybaFactory;

public class UserSubPageDao implements UserSubPageInterface{
	SqlSession session;
	pageMain page;
	
	
	public UserSubPageDao() {
		session = MybaFactory.getFactory().openSession();
	}
	
	
	@Override
	public List<UserSubPageVo> select(pageMain p) {
		List<UserSubPageVo> list = null;
		
		try {
			int totSize = session.selectOne("user_subPage.tot_size", p);
			p.setTotSize(totSize);
			p.compute();
			p.setStartNo(p.getStartNo()-1);
			this.page = p;
			
			list = session.selectList("user_subPage.select", page);
			
		}catch(Exception ex) {
			System.out.println("[Error]UserSubPageDao_select");
			ex.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<UserSubPageVo> CategorySelect(pageMain p) {
		List<UserSubPageVo> list = null;
		
		try {
			int totSize = session.selectOne("user_subPage.tot_size_category", p.getCategoryType());
			p.setTotSize(totSize);
			p.compute();
			p.setStartNo(p.getStartNo()-1);
			this.page = p;
			
			list = session.selectList("user_subPage.categorySelect", page);
			
		}catch(Exception ex) {
			System.out.println("[Error]UserSubPageDao_CategorySelect");
			ex.printStackTrace();
		}
		return list;
	}
	
	@Override
	public UserSubPageVo DetailSelect(String bookCode) {
		UserSubPageVo vo = null;
		try {
			vo = session.selectOne("user_subPage.detailSelect", bookCode);
		}catch(Exception ex) {
			System.out.println("[Error]UserSubPageDao_DetailSelect");
			ex.printStackTrace();
		}
		return vo;
	}
	
	
	@Override
	public UserMemberVo selectJob(String userID) {
		UserMemberVo vo = null;
		try {
			vo = session.selectOne("user_subPage.jobSelect", userID);
		}catch(Exception ex) {
			System.out.println("[Error]UserSubPageDao_selectJob");
			ex.printStackTrace();
		}
		
		return vo;
	}


	@Override
	public boolean insertCart(UserCartVo vo) {
		boolean b = false;
		try {
			int cnt = session.insert("user_subPage.cartInsert", vo);
			System.out.println("cnt : " + cnt);
			if(cnt>0) {
				
				session.commit();
				b = true;
			}else {
				session.rollback();
			}
		}catch(Exception ex) {
			System.out.println("[Error]UserSubPageDao_insertCart");
			ex.printStackTrace();
		}
		return b;
	}


	public pageMain getPage() {
		return page;
	}
}
