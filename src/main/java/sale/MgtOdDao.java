package sale;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.PageMgtView;
import mybatis.MybaFactory;

public class MgtOdDao implements MgtOdInterface {
	SqlSession session;
	PageMgtView page;
	public MgtOdDao() {
		session=MybaFactory.getFactory().openSession();
	}
	@Override
	public List<MgtOdVo> select(PageMgtView page) {
		System.out.println("select page dao ====================================: ");
		System.out.println("select page dao  : "+page);
		List<MgtOdVo> list=null;
		System.out.println("select page dao  getStd : "+page.getStd());
		System.out.println("select page dao  getEdd : "+page.getEdd());
		System.out.println("select page dao  getFindStr : "+page.getFindStr());
		System.out.println("select page dao getSortType : "+page.getSortType());
		System.out.println("select page dao getType : "+page.getType());
		
		try {
			int totSize=session.selectOne("mgtorder.tot_size",page);
			System.out.println("select page dao totSize : "+totSize);
			page.setTotSize(totSize);
			page.compute();
			page.setStartNo(page.getStartNo()-1);
			System.out.println("select page dao pagecompute : "+page.getTotSize());
			System.out.println("select page dao getStartNo : "+page.getStartNo());
			System.out.println("select page dao getTotPage : "+page.getTotPage());
			System.out.println("select page dao getEndNo : "+page.getEndNo());
			list=session.selectList("mgtorder.select",page);
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
