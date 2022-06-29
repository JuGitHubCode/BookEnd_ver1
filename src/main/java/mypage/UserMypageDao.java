package mypage;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.apache.ibatis.session.SqlSession;

import bean.AES;
import bean.PageMypage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mybatis.MybaFactory;

public class UserMypageDao implements UserMypageInterface {
	SqlSession session;
	HttpSession s;
	PageMypage page;
	AES aes;
		
	public UserMypageDao() {
		session = MybaFactory.getFactory().openSession();
		aes = new AES();
		page = new PageMypage();
	}


	@Override
	public List<UserMypageVo> selectOrder(String uId) {
		List<UserMypageVo> orderNoList = new ArrayList<UserMypageVo>();
		List<UserMypageVo> list = null;
		try {
			list = session.selectList("mypage.selectFirstOrder",uId);
			
			if(list.size()>0) {
				orderNoList.add(list.get(0));
				int index = 0;
			
				for(int i=0; i<list.size(); i++) {
					if(!orderNoList.get(index).getOrderNo().equals(list.get(i).getOrderNo())) {
						orderNoList.add(list.get(i));
						index++;
					}
					orderNoList.get(index).etc++;
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return orderNoList;
	}

	@Override
	public List<UserMypageVo> selectOrderDetail(PageMypage page) {
		List<UserMypageVo> list = null;
		try {
			int totSize = session.selectOne("mypage.tot_size", page);
			page.setTotSize(totSize);
			page.compute();
			page.setStartNo(page.getStartNo()-1);
			this.page = page;
			
			list = session.selectList("mypage.viewOrderDetail", page);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}
	
	@Override
	public UserMypageVo selectOneInfo(String uId) {
		UserMypageVo vo = null;
		try {
			vo = session.selectOne("mypage.selectOneInfo", uId);
			
			// Date 형식으로 출력되는 생년월일에서 "-"를 없애줌.
			String birth = vo.getBirth();
			birth = birth.replaceAll("[-]", "");
			vo.setBirth(birth);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return vo;
	}

	// 회원정보 수정
	@Override
	public boolean updateInfo(UserMypageVo vo) {
		boolean b = false;
		int cnt = session.update("mypage.updateInfo", vo);
		if(cnt > 0) {
			b = true;
			session.commit();
		}else {
			session.rollback();
		}
		return b;
	}
	
	public String phoneValidation(String phone) {
		String chkPhone = "";
		
		try {
			chkPhone = session.selectOne("mypage.phone_validation", phone);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return chkPhone;
	}
	
	public String emailValidation(String email) {
		String chkEmail = "";
		
		try {
			chkEmail = session.selectOne("mypage.email_validation", email);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return chkEmail;
	}
	
	// 마이페이지 메인화면에서 비밀번호 변경 클릭시 id 넘겨서 비밀번호 값 받아오기
	@Override
	public UserMypageVo selectOnePwd(String uId) {
		UserMypageVo vo = null;
		try {
			vo = session.selectOne("mypage.selectOnePwd", uId);
			//String pwd = aes.dec(vo.getPwd());
			//vo.setPwd(pwd);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return vo;
	}

	// 비밀번호 변경
	@Override
	public boolean updatePwd(UserMypageVo vo) {
		boolean b = false;
		System.out.println("dao : " + vo.getPwd());
		String pwd = aes.enc(vo.getPwd());
		
		vo.setPwd(pwd);
		int cnt = session.update("mypage.updatePwd", vo);
		if(cnt > 0) {
			b = true;
			session.commit();
		}else {
			session.rollback();
		}
		return b;
	}
	
	public String pwdValidation(String pwd) {
		String chkPwd = aes.enc(pwd);
		return chkPwd;
	}
	
	public PageMypage getPage() {
		return page;
	}
	
}
