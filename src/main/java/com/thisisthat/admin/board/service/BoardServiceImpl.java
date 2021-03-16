package com.thisisthat.admin.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.board.dao.BoardDAO;
import com.thisisthat.admin.board.vo.AnswerBoardVO;
import com.thisisthat.admin.board.vo.SearchVO;
import com.thisisthat.util.PagingVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO dao;
	
	@Override
	public List<AnswerBoardVO> getAnswerList(PagingVO vo,SearchVO search) {
		
		return dao.getAnswerList(vo, search);
	}

	@Override
	public AnswerBoardVO getAnswer(int boardNo) {
	
		return dao.getAnswer(boardNo);
	}

	@Override
	public void updateAnswer(AnswerBoardVO board) {
		dao.updateAnswer(board);

	}

	@Override
	public int countAnswer(SearchVO search) {
		return dao.getCount(search);
	}

	@Override
	public void viewCheck(AnswerBoardVO board) {
		dao.viewCheck(board);
	}

	@Override
	public void replyInsert(AnswerBoardVO board) {
		dao.replyInsert(board);
		
	}

	@Override
	public AnswerBoardVO getReply(int boardNo) {
		
		return dao.getReply(boardNo);
	}

	@Override
	public void updateReply(AnswerBoardVO board) {
		dao.updateReply(board);
		
	}

	@Override
	public void deleteReply(int boardNo) {
		dao.deleteReply(boardNo);
		
	}

	@Override
	public void deleteAnswer(int boardNo) {
		dao.deleteAnswer(boardNo);
		
	}

	@Override
	public void deleteAnswerReply(int boardNo) {
		dao.deleteAnswerReply(boardNo);
	}

}
