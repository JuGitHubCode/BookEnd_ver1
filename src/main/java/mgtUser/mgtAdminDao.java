package mgtUser;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybaFactory;

public class mgtAdminDao implements mgtCreateAdmin{

	SqlSession session;
	
	public mgtAdminDao() {
		session=MybaFactory.getFactory().openSession();
	}
	
	@Override
	public boolean insert(mgtAdminVo vo) {
		System.out.println("mgtAdminDao insert : ");
		
		boolean b=false;
		
		try {
			int cnt=session.insert("mgtcreateuser.insert",vo);
			System.out.println("mgtAdminDao insert cnt: "+cnt);
			if(cnt>0) {
				b=true;
				session.commit();
			}else {
				session.rollback();
				System.out.println("mgtAdminDao insert else: "+cnt);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mgtAdminDao insert catch: ");
		}
		return b;
	}

	@Override
	public List<mgtAdminVo> select(String uId) {
		System.out.println("mgtAdminDao select : ");
		List<mgtAdminVo> list=null;
		
		try {
			list=session.selectList("mgtcreateuser.select",uId);
			System.out.println("mgtAdminDao select cnt: "+list);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mgtAdminDao select err: "+uId);
		}
		
		return list;
	}

	@Override
	public List<mgtAdminVo> selectOne(String uId) {
		System.out.println("mgtAdminDao select : ");
		List<mgtAdminVo> list=null;
		
		try {
			list=session.selectOne("mgtcreateuser.selectOne",uId);
			System.out.println("mgtAdminDao insert cnt: "+list);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mgtAdminDao select err: "+uId);
		}
		
		return list;
	}

	@Override
	public boolean update(mgtAdminVo vo) {
		System.out.println("mgtAdminDao update : ");
		
		boolean b=false;
		
		try {
			int cnt=session.update("mgtcreateuser.update",vo);
			System.out.println("mgtAdminDao update cnt: "+cnt);
			if(cnt>0) {
				b=true;
				session.commit();
			}else {
				session.rollback();
				System.out.println("mgtAdminDao update else: "+cnt);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("mgtAdminDao update catch: ");
		}
		return b;
	}

	
	
}
