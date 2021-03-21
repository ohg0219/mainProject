package com.thisisthat.user.answer.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.jmx.snmp.Timestamp;
import com.thisisthat.admin.board.vo.AnswerBoardVO;
import com.thisisthat.user.answer.vo.SearchVO;
import com.thisisthat.util.PagingVO;

@Repository
public class AnswerDAO {
	@Autowired
	SqlSessionTemplate template;

	public List<AnswerBoardVO> getAnswerList(PagingVO pagingvo, SearchVO searchvo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("type", pagingvo.getType());
		map.put("cntPerPage",pagingvo.getCntPerPage());
		map.put("start", pagingvo.getStart());
		map.put("searchType", searchvo.getSearchType());
		map.put("searchKeyword", searchvo.getSearchKeyword());
		map.put("searchDate", searchvo.getSearchDate());
		if(!searchvo.getSearchDate().equals("all")) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, -(Integer.parseInt(searchvo.getSearchDate())));
			Date date = cal.getTime();
			map.put("now", date);
		}


		return template.selectList("answerDAO.getAnswerList",map);
	}


	public int total(SearchVO searchvo) {
		System.out.println((Integer)template.selectOne("answerDAO.getCount",searchvo));
		if(!searchvo.getSearchDate().equals("all")) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, -(Integer.parseInt(searchvo.getSearchDate())));
			Date date = cal.getTime();
			searchvo.setNowDate(date);

		}else {

		}
		return template.selectOne("answerDAO.getCount",searchvo);
	}

	public AnswerBoardVO getReply(int boardNo) {

		return null;
	}
	public void insertAnswer(AnswerBoardVO vo) {
		template.insert("answerDAO.insertAnswer",vo);
	}
	public int getSeq() {
		return template.selectOne("answerDAO.seq");
	}
	public AnswerBoardVO getAnswer(int boardNo) {

		return template.selectOne("answerBoardDAO.getAnswer",boardNo);
	}
}
