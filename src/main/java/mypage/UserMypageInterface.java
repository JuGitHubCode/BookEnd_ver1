package mypage;

import java.util.List;

import bean.PageMypage;

public interface UserMypageInterface {
	public List<UserMypageVo> selectOrder(String uId);
	public UserMypageVo selectOneInfo(String uId);
	public UserMypageVo selectOnePwd(String uId);
	public List<UserMypageVo> selectOrderDetail(PageMypage page);
	public boolean updateInfo(UserMypageVo vo);
	public boolean updatePwd(UserMypageVo vo);
}
