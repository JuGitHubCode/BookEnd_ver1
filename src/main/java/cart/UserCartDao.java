package cart;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybaFactory;

public class UserCartDao {
	SqlSession session;
	
	public UserCartDao() {
		session = MybaFactory.getFactory().openSession();
	}
	
	public List<UserCartVo> select(String uId){
		List<UserCartVo> list = null;
		
		try {
			list = session.selectList("user_cart.select", uId);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void minusItem(UserCartVo vo) {
		try {
			int n = session.update("user_cart.minusItem", vo);
			
			if(n > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void plusItem(UserCartVo vo) {
		try {
			int n = session.update("user_cart.plusItem", vo);
			
			if(n > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteItem(UserCartVo vo) {
		try {
			int n = session.delete("user_cart.deleteItem", vo);
			
			if(n > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAllItem(String uId) {
		try {
			int n = session.delete("user_cart.deleteAllItem", uId);
			
			if(n > 0) {
				session.commit();
			} else {
				session.rollback();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
