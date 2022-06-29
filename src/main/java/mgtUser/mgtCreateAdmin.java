package mgtUser;

import java.util.List;

public interface mgtCreateAdmin {
	public boolean insert(mgtAdminVo vo);
	public List<mgtAdminVo> select(String uId);
	public List<mgtAdminVo> selectOne(String uId);
	public boolean update(mgtAdminVo vo);
	
}
