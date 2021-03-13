package com.thisisthat.admin.board.service;

import java.util.List;

import com.thisisthat.admin.board.vo.AnswerBoardVO;
import com.thisisthat.util.PagingVO;

public interface BoardService {
	
	public List<AnswerBoardVO> getAnswerList(PagingVO vo);
	public AnswerBoardVO getAnswer(int boardNo);
	public void updateAnswer(AnswerBoardVO board);
	public int countAnswer();
	
}
