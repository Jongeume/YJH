package kr.yjh.lecture.dao;

import java.util.HashMap;
import java.util.List;

import kr.yjh.lecture.vo.L_memberVO;

public interface L_memberDAO {
	
	// 1. 저장
	void insert(L_memberVO lvo);
	// 2. 1개 읽기(idx로 얻기)
	L_memberVO selectByIdx(int M_NO);
	// 3. 수정
	void update(L_memberVO lvo);
	// 4. 삭제
	void delete(int M_NO);
	// 5. 모두 읽기
	List<L_memberVO> selectList();
	// 6. 개수 얻기
	int getCount();
	// 7. 1개 읽기(userid로 얻기) : 로그인, 비번 찾기 --> 이메일로 비번 전송
	L_memberVO selectByUserId(HashMap<String, String> map);
	// 8. 1개 읽기(이름과 전화번호) : 아이디 찾기 --> 화면 표시
	L_memberVO selectByUserName(HashMap<String, String> map);
	// 9. use값 변경하기(0은 가입, 1은 휴면계정, 2는 가입하고 인증, 3은 강제탈퇴)
	void updateUse(HashMap<String, String> map);
	// 10. 비밀번호 변경하기
	void updatePassword(HashMap<String, String> map); 
}
