package customer;

import java.util.List;

import bean.PageMgtView;

public interface MgtCsInterface {
	public List<MgtCsVo> select(PageMgtView page);
}
