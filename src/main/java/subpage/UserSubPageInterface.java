package subpage;

import java.util.List;
import bean.pageMain;
import cart.UserCartVo;
import member.UserMemberVo;

public interface UserSubPageInterface {
	List<UserSubPageVo> select(pageMain p);				//검색
	List<UserSubPageVo> CategorySelect(pageMain p);		//카테고리
	UserSubPageVo DetailSelect(String bookCode);		//상세페이지
	public UserMemberVo selectJob(String userID);		//유저 정보 찾기
	public boolean insertCart(UserCartVo vo);		//장바구니 정보 넣기
}
