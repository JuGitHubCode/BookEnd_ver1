package item;

import java.util.List;

import bean.PageItem;
import item.MgtItemVo;


public interface MgtItemInterface {
	// C
	public String input(MgtItemVo vo);
	// R
	public List<MgtItemVo> select(PageItem page);
	public List<MgtItemVo> selectEa(PageItem page);
	public List<MgtItemVo> selectCode(PageItem page);
	public MgtItemVo selectOne(String code);
	
	// U
	public String modifyR(MgtItemVo vo);
	
	// D
	public String delete(String code);
	
	// C : 이미지
	public boolean inputAtt(MgtItemAtt att);

}


