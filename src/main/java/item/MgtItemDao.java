package item;

import java.io.File;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.PageItem;
import mybatis.MybaFactory;
import item.MgtItemVo;

public class MgtItemDao implements MgtItemInterface{

	SqlSession session;
	PageItem page;
	
	public MgtItemDao() {
		session = MybaFactory.getFactory().openSession();
	}
		
	@Override
	public String input(MgtItemVo vo) {
		
		session = MybaFactory.getFactory().openSession();
		String code ="";
		try {
			int cnt = session.insert("item.input", vo);
			if(cnt>0) {
				session.commit();
			}else {
				session.rollback();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		session.close();
		return code;
	}

	@Override
	public List<MgtItemVo> select(PageItem p) {
		session = MybaFactory.getFactory().openSession();
		List<MgtItemVo> list = null;
		
		try {
			int totSize = session.selectOne("item.tot_size",p);
			p.setTotSize(totSize);
			p.compute();
			this.page = p;
			p.setStartNo(p.getStartNo()-1);
			list = session.selectList("item.select",p);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		session.close();
		return list;
	}
	
	@Override
	public List<MgtItemVo> selectEa(PageItem p) {
		session = MybaFactory.getFactory().openSession();
		List<MgtItemVo> list = null;
		
		try {
			int totSize = session.selectOne("item.tot_size",p);
			p.setTotSize(totSize);
			p.compute();
			this.page = p;
			p.setStartNo(p.getStartNo()-1);
			list = session.selectList("item.selectEa",p);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		session.close();
		return list;
	}
	
	@Override
	public List<MgtItemVo> selectCode(PageItem p) {
		session = MybaFactory.getFactory().openSession();
		List<MgtItemVo> list = null;
		try {
			int totSize = session.selectOne("item.tot_size",p);
			p.setTotSize(totSize);
			p.compute();
			this.page = p;
			p.setStartNo(p.getStartNo()-1);
			list = session.selectList("item.selectCode",p);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		session.close();
		return list;
	}

	@Override								
	public MgtItemVo selectOne(String code) { 
		session = MybaFactory.getFactory().openSession();
		MgtItemVo vo = null;
		try {						
			vo = session.selectOne("item.modify", code);
		}catch(Exception ex) { 
			ex.printStackTrace();
		}			
		session.close();
		return vo;
	}

	@Override
	public String modifyR(MgtItemVo vo) {
		session = MybaFactory.getFactory().openSession();
		String msg ="";
		try {
			int cnt = session.update("item.modifyR", vo);
			if(cnt>0) {
				session.commit(); 				
			}else {
				session.rollback();
			}
		}catch(Exception ex) {
			//ex.printStackTrace();
		}
		session.close();
		return msg;
	}

	@Override
	public String delete(String code) {
		session = MybaFactory.getFactory().openSession();
		String msg ="";
		try {
			int cnt = session.delete("item.delete",code);
			if(cnt>0) {
				session.commit();
				//System.out.println("삭제 완료");
			}else {
				msg = "삭제중 오류가 발생되었습니다.";
				session.rollback();
				System.out.println("삭제 오류");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		session.close();
		return msg;
	}
	
	@Override			
	public boolean inputAtt(MgtItemAtt att) {
		session = MybaFactory.getFactory().openSession();
		boolean b = true;
		try {
			int cnt = session.update("item.inputAtt", att);
			if(cnt>0) {
				session.commit();
			}else {
				session.rollback();
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			b=false;
		}
		session.close();
		return b;
	}
	//page
	public PageItem getPage() {
		return this.page;
	}

}
