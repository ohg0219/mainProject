package com.thisisthat.admin.board.service;

import java.util.List;

import com.thisisthat.admin.board.vo.AnswerBoardVO;
import com.thisisthat.admin.board.vo.SearchVO;
import com.thisisthat.util.PagingVO;

public interface BoardService {
	
	public List<AnswerBoardVO> getAnswerList(PagingVO vo,SearchVO search);
	public AnswerBoardVO getAnswer(int boardNo);
	//답글작성시 질문글의 처리날짜와 상태를 바꿔주는 기능
	public void updateAnswer(AnswerBoardVO board);
	public int countAnswer(SearchVO search);
	public void viewCheck(AnswerBoardVO board);
	public void replyInsert(AnswerBoardVO board);
	public AnswerBoardVO getReply(int boardNo);
	public void updateReply(AnswerBoardVO board);
	public void deleteReply(int boardNo);
	public void deleteAnswer(int boardNo);
	public void deleteAnswerReply(int boardNo);
}
