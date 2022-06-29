package bean;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail {
	
	public boolean sendMail(String email, String tempPwd){
		boolean b = false;
		//SMTP 서버 정보를 설정
		Properties props = new Properties();
		//발송 STMP 서버
		props.put("mail.smtp.host", "smtp.naver.com");
		//SMTP 서버의 포트
		props.put("mail.smtp.port" , 465);
		props.put("mail.smtp.auth" , "true");
		//SSL 활성화
		props.put("mail.smtp.ssl.enable" , "true");
		props.put("mail.smtp.ssl.trust" , "smtp.naver.com");

		//STMP 서버 정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스를 생성
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
			return new javax.mail.PasswordAuthentication("kimtahwn@naver.com", "WBZT9TTMPCHG"); //네이버 이메일 계정 및 비밀번호
			}
		});
		
		//메일 발신자와 수신자, 제목 그리고 내용 작성을 위한 MimeMessage객체 생성
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("kimtahwn@naver.com","BookEnd")); //발신자 설정 
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email, "임시 비밀번호 발급")); //수신자 설정
			
			message.setSubject("Book End" +  "님의 임시 비밀번호입니다."); // 제목
			//메일 내용 설정
			message.setContent(
					"<h4>고객님의 비밀번호를 임시 비밀번호로 변경했습니다.</h4>" +
					"<span>비밀번호 확인 후 복사하여 로그인해주세요.</span><br/>" +
					"<span>로그인 후 비밀번호를 꼭 변경해주세요.</span> <br/>" + 
					"<span> 비밀번호 : </span>" + tempPwd +
					"<span style='font-weight: bold'>" + "</span>",
					"text/html;charset=utf-8"); //HTML형태
			Transport.send(message); //이메일 보내기
			
			b = true;
		} catch (MessagingException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return b;
	}
}	

