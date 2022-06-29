package sale;

import java.util.List;

import bean.PageMgtView;
import customer.MgtCsVo;

public interface MgtOdInterface {
	public List<MgtOdVo> select(PageMgtView page);

}
