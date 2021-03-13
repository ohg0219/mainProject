package com.thisisthat.admin.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.board.dao.BoardDAO;
import com.thisisthat.admin.board.vo.AnswerBoardVO;
import com.thisisthat.util.PagingVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO dao;
	
	@Override
	public List<AnswerBoardVO> getAnswerList(PagingVO vo) {
		
		return dao.getAnswerList(vo);
	}

	@Override
	public AnswerBoardVO getAnswer(int boardNo) {
	
		return dao.getAnswer(boardNo);
	}

	@Override
	public void updateAnswer(AnswerBoardVO board) {
		// TODO Auto-generated method stub

	}

	@Override
	public int countAnswer() {
		return dao.getCount();
	}

}
