package org.member.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.member.mybatis.vo.MemberVO;

public interface MemberDAO {
	
	//전체보기
	List<MemberVO>getMemberList();
	
	//추가
	void insert(MemberVO user);
	
	//수정
	void update(MemberVO user);
	
	//삭제
	void delete(String id);
	
	//상세보기
	MemberVO findById(String id);
	
	//검색
	List<MemberVO>search(HashMap<String, String> map);
	
	//검색개수
	int searchCount(HashMap<String, String> map);

}
