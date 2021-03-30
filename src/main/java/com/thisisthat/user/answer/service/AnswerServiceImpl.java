package com.thisisthat.user.answer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thisisthat.admin.board.vo.AnswerBoardVO;
import com.thisisthat.user.answer.dao.AnswerDAO;
import com.thisisthat.user.answer.vo.SearchVO;
import com.thisisthat.util.PagingVO;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	AnswerDAO dao;
	
	@Override
	public List<AnswerBoardVO> getAnswerList(PagingVO pagingvo, SearchVO searchvo) {
		
		return dao.getAnswerList(pagingvo, searchvo);
	}

	@Override
	public int total(SearchVO searchvo) {
		return dao.total(searchvo);
	}

	@Override
	public AnswerBoardVO getReply(int boardNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertAnswer(AnswerBoardVO vo) {
		dao.insertAnswer(vo);
	}

	@Override
	public int getSeq() {
		return dao.getSeq();
	}

	@Override
	public AnswerBoardVO getAnswer(int boardNo) {
		
		return dao.getAnswer(boardNo);
	}

}
