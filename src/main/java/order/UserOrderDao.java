package order;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.MybaFactory;

public class UserOrderDao implements UserOrderInterface {
	SqlSession session;
	
	public UserOrderDao() {
		session = MybaFactory.getFactory().openSession();
	}
	
	@Override
	public UserOrderVo selectUId(String uId) {
		UserOrderVo vo = null;
		try {
			vo = session.selectOne("user_order.select_uId",uId);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return vo;
	}
	
	@Override
	public List<UserOrderVo> selectCart(String uId) {
		List<UserOrderVo> list = null;
		try {
			list = session.selectList("user_order.select_cart",uId);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean insertOrder(List<UserOrderVo> list) {
		boolean b = true;
		try {
			int cnt = session.insert("user_order.insertOrder",list);
			if(cnt>0) {
				session.commit();
			}else {
				session.rollback();
			}
		}catch (Exception ex) {
			ex.printStackTrace();
			b = false;
		}
		
		return false;
	}

	@Override
	public String deleteCart(String uId) {
		String msg = "";
		try {
			int cnt = session.delete("user_order.deleteCart",uId);
			if(cnt>0) {
				session.commit();
			}else {
				session.rollback();
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return msg;
	}

	@Override
	public boolean updateItem(List<UserOrderVo> list) {
		boolean b = true;
		try {
			int cnt = session.update("user_order.updateItem",list);
			if(cnt>0) {
				session.commit();
			}else {
				session.rollback();
			}
		}catch (Exception ex) {
			ex.printStackTrace();
			b = false;
		}
		
		return false;
	}

	@Override
	public UserOrderVo selectOrderNo(String orderNo) {
		UserOrderVo vo = null;
		try {
			vo = session.selectOne("user_order.selectOrderNo",orderNo);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return vo;
	}

	@Override
	public UserOrderVo setD(String uId) {
		UserOrderVo vo = null;
		try {
			vo = session.selectOne("user_order.setD",uId);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return vo;
	}

}
