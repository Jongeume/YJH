package kr.yjh.lecture.service;

import java.util.HashMap;
import java.util.Random;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import kr.yjh.lecture.dao.L_memberDAO;
import kr.yjh.lecture.vo.L_memberVO;

@Service
public class L_memberService {
	
	@Autowired
	private L_memberDAO ldao;
	@Autowired
	private JavaMailSender mailSender;
	
	public int getCount(){
		return ldao.getCount();
	}
	
	public void insert(L_memberVO lvo) {
		// 1. 데이터 검증
		if(lvo==null || lvo.getID()==null) return;
		// 2. DB에 저장
		ldao.insert(lvo);
		// 3. 회원가입 축하 메일 발송
		sendEmail(lvo);
	}
	
	public void sendEmail(L_memberVO lvo) {
        MimeMessagePreparator preparator = getMessagePreparator(lvo);
        try {
            mailSender.send(preparator);
            System.out.println("메일 보내기 성공 ***************************************************");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
 
    private MimeMessagePreparator getMessagePreparator(final L_memberVO lvo) {
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
 
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom("jongeume@gmail.com");
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(lvo.getID()));
                mimeMessage.setText("반갑습니다. " + lvo.getNAME() + "님!!!<br>"
                        + "회원 가입을 축하드립니다.<br> "
                		+ "회원 가입을 완료하려면 다음의 링크를 클릭해서 인증하시기 바랍니다.<br>"
                        + "<a href='http://localhost:8080/member/member/confirm?userid="+lvo.getID()+"'>인증</a><br>");
                mimeMessage.setSubject("회원 가입을 축하드립니다.");
            }
        };
        return preparator;
    }
    
    public void confirm(String ID) {
    	HashMap<String, String> map = new HashMap<String, String>();
    	map.put("ID", ID);
    	L_memberVO lvo = ldao.selectByUserId(map);
    	//DB변경
    	if(lvo!=null) {
    		HashMap<String, String> map2 = new HashMap<String, String>();
    		map2.put("ID", ID);
    		map2.put("USE", "2");
    		ldao.updateUse(map2);
    	}
    }
    // 아이디 중복 검사
    public String idCheck(String ID) {
    	HashMap<String, String> map = new HashMap<String, String>();
    	map.put("ID", ID);
    	L_memberVO lvo = ldao.selectByUserId(map);
    	return lvo==null ? "0" : "1";
    }
    
    // 로그인 처리
    public L_memberVO loginOk(L_memberVO lvo) {
    	L_memberVO vo = null;
    	HashMap<String, String> map = new HashMap<String, String>();
    	map.put("ID", lvo.getID());
    	vo = ldao.selectByUserId(map);
    	if(vo!=null) {
    		if(!vo.getPASSWORD().equals(lvo.getPASSWORD())) {
    			vo = null;
    		}
    	}
    	return vo;
    }
    
	public L_memberVO idSearch(L_memberVO lvo) {
		L_memberVO vo = null;
    	HashMap<String, String> map = new HashMap<String, String>();
    	map.put("NAME", lvo.getNAME());
    	map.put("PHONE", lvo.getPHONE());
		vo = ldao.selectByUserName(map);
		return vo;
	}
    
	public L_memberVO passwordSearch(L_memberVO lvo) {
		L_memberVO vo = null;
	 	HashMap<String, String> map = new HashMap<String, String>();
		map.put("ID",lvo.getID());
		vo = ldao.selectByUserId(map);
		if(!(vo!=null && vo.getNAME().equals(lvo.getNAME()) && vo.getPHONE().equals(lvo.getPHONE()))) {
			vo = null; 
		}else {
			// 임시 비밀번호를 만들어서 사용자에게 메일을 발송한다.
			// 1. 임시 비번 생성
			StringBuilder sb = new StringBuilder();
			Random rnd = new Random();
			for(int i=0;i<4;i++) {
				sb.append((char)(rnd.nextInt(26)+'A') + ""); // 대문자
				sb.append((char)(rnd.nextInt(26)+'a') + ""); // 소문자
				sb.append((char)(rnd.nextInt(10)+'0') + ""); // 숫자
			}
			final String password = sb.toString();
			
			// 2. 임시 비번으로 DB를 업데이트
		 	HashMap<String, String> map2 = new HashMap<String, String>();
			map2.put("ID",lvo.getID());
			map2.put("PASSWORD", password);
			ldao.updatePassword(map2);
			
			// 3. 메일 발송
			  final L_memberVO vo2 = vo;
			  MimeMessagePreparator preparator = new MimeMessagePreparator() {
				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					 mimeMessage.setFrom("jongeume@gmail.com");
					 mimeMessage.setRecipient(Message.RecipientType.TO,
							 new InternetAddress(vo2.getID()));
					 mimeMessage.setText("반갑습니다. " + vo2.getNAME() + "님!!!\n"
		                        + "임시 비밀번호 입니다.\n"
		                        + password + "\n");
					 mimeMessage.setSubject("임시 비밀번호 입니다.!!");
				}
			};
		        try {
		            mailSender.send(preparator);
		            System.out.println("메일 보내기 성공 ***************************************************");
		        } catch (MailException ex) {
		            System.err.println(ex.getMessage());
		        }
			
			
		}
		return vo;
	}
}
