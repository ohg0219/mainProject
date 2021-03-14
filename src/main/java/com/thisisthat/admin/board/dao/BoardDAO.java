package com.thisisthat.admin.board.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.board.vo.AnswerBoardVO;
import com.thisisthat.admin.board.vo.SearchVO;
import com.thisisthat.util.PagingVO;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSessionTemplate answerTemplate;
	
	
	public List<AnswerBoardVO> getAnswerList(PagingVO vo,SearchVO search) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("type", vo.getType());
		map.put("cntPerPage",vo.getCntPerPage());
		map.put("start", vo.getStart());
		map.put("searchType", search.getSearchType());
		
		map.put("parameter", search.getParameter());
		
	
		return answerTemplate.selectList("answerBoardDAO.getAnswerList",map);
	}

	
	public AnswerBoardVO getAnswer(int boardNo) {
		return answerTemplate.selectOne("answerBoardDAO.getAnswer", boardNo);
	}

	
	public void updateAnswer(AnswerBoardVO board) {
	

	}
	public int getCount(SearchVO search) {
		
		System.out.println("DAO : "+search.getParameter());
		System.out.println("DAP : "+(int)answerTemplate.selectOne("answerBoardDAO.getCount", search));
		return answerTemplate.selectOne("answerBoardDAO.getCount", search);
	}
	
}
