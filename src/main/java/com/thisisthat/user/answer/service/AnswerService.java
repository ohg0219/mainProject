package com.thisisthat.user.answer.service;

import java.util.List;

import com.thisisthat.admin.board.vo.AnswerBoardVO;
import com.thisisthat.user.answer.vo.SearchVO;
import com.thisisthat.util.PagingVO;

public interface AnswerService {
	List<AnswerBoardVO> getAnswerList(PagingVO pagingvo, SearchVO searchvo);
	int total(SearchVO searchvo);
	AnswerBoardVO getReply(int boardNo);
	void insertAnswer(AnswerBoardVO vo);
	int getSeq();
	AnswerBoardVO getAnswer(int boardNo);
}
