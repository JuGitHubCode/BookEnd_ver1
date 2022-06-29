package member;

import org.apache.ibatis.session.SqlSession;

import bean.AES;
import bean.RandomPwd;
import bean.SendMail;
import jakarta.servlet.http.HttpSession;
import mybatis.MybaFactory;


public class UserMemberDao {
	SqlSession session;
	HttpSession s;	// id 저장용
	
	AES aes;
	
	public UserMemberDao() {
		session = MybaFactory.getFactory().openSession();
		aes = new AES();
		
	}
	
	public UserMemberVo userMemberLogin(UserMemberVo vo) {
		String pwd = aes.enc(vo.getPwd());
		vo.setPwd(pwd);
		
		vo = session.selectOne("user_member.member_login", vo);
	
		return vo;
	}
	
	public String userMemberFindPhone(UserMemberVo vo) {
		String uId = session.selectOne("user_member.member_find_phone", vo);
		
		return uId;
	}
	
	public String userMemberFindEmail(UserMemberVo vo) {
		String uId = session.selectOne("user_member.member_find_email", vo);
		
		return uId;
	}
	
	public String userMemberTempPwd(UserMemberVo vo) {
		String tempPwd = RandomPwd.getRamdomPassword(12); // 랜덤 비밀번호 생성
		String encTempPwd = aes.enc(tempPwd);	
		vo.setPwd(encTempPwd);	// 암호화 하여 DB에 저장

		int cnt = session.update("user_member.member_temp_pwd", vo);
		
		if(cnt > 0) {
			session.commit();
		} else {
			session.rollback();
			tempPwd = "";
		}
		
		return tempPwd; 	// 메일로 보내줄 비밀번호는 암호화 전
	}
	
	public boolean userMemberJoin(UserMemberVo vo) {
		boolean b = false;
		int cnt = 0;
		String pwd = aes.enc(vo.getPwd());
		vo.setPwd(pwd);
		
		// 아이디, 이메일, 휴대폰 번호가 중복이 아닐 때 실행
		if(!userMemberUidValdation(vo.getuId()) && !userMemberEmailValdation(vo.getEmail()) &&
		   !userMemberPhoneValdation(vo.getPhone())) {
			cnt = session.insert("user_member.member_insert", vo);
		}
		
		if(cnt > 0) {
			b = true;
			session.commit();
		} else {
			session.rollback();
		}
		
		return b;
	}
	
	// 중복이면 true
	public boolean userMemberUidValdation(String uId) {
		boolean b = true;
		String result = session.selectOne("user_member.member_uId_validation", uId);
		
		if(result == "" || result == null) {
			b = false;
		}
		
		return b;
	}
	
	public boolean userMemberEmailValdation(String email) {
		boolean b = true;
		String result = session.selectOne("user_member.member_email_validation", email);

		if(result == "" || result == null) {
			b = false;
		}

		return b;
	}
	
	public boolean userMemberPhoneValdation(String phone) {
		boolean b = true;
		String result = session.selectOne("user_member.member_phone_validation", phone);	
		
		if(result == "" || result == null) {
			b = false;
		}
		
		return b;
	}
}

