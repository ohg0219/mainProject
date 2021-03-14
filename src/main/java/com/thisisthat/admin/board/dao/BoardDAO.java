package com.thisisthat.admin.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.thisisthat.admin.board.vo.AnswerBoardVO;
import com.thisisthat.util.PagingVO;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSessionTemplate answerTemplate;
	
	
	public List<AnswerBoardVO> getAnswerList(PagingVO vo) {
	
		return answerTemplate.selectList("answerBoardDAO.getAnswerList",vo);
	}

	
	public AnswerBoardVO getAnswer(int boardNo) {
		return answerTemplate.selectOne("answerBoardDAO.getAnswer", boardNo);
	}

	
	public void updateAnswer(AnswerBoardVO board) {
	

	}
	public int getCount() {
		
		return answerTemplate.selectOne("answerBoardDAO.getCount");
	}
	
}
