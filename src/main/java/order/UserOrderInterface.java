package order;

import java.util.List;

public interface UserOrderInterface {
	public UserOrderVo selectUId(String uId); // id로 user에서 주문고객 정보 가져오기 
	public List<UserOrderVo> selectCart(String uId); //cart에서 uId로 장바구니 가져오기 
	public boolean insertOrder(List<UserOrderVo> vo); //결제하기 눌렀을 때 orders에 insert
	public String deleteCart(String uId); //결제하기 눌렀을 때 cart에서 uId로 삭제
	public boolean updateItem(List<UserOrderVo> list); //결제하기 눌렀을 때 item에서 code로 수량 변경
	public UserOrderVo selectOrderNo(String orderNo); // 결제상세페이지에서 orders에서 orderNo로 정보
	public UserOrderVo setD(String uId);
}
