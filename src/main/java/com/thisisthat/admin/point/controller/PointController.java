package com.thisisthat.admin.point.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thisisthat.admin.board.vo.SearchVO;
import com.thisisthat.admin.point.service.PointService;
import com.thisisthat.admin.point.vo.PointVO;
import com.thisisthat.admin.usermanagement.vo.UserVO;
import com.thisisthat.util.PagingVO;

@Controller
@RequestMapping("/admin")
public class PointController {

	@Autowired
	PointService pointService;

	@GetMapping("/pointUserList.mdo")
	public String pointUserList(Model model,
			@RequestParam(value="msg", required = false)String msg,
			@RequestParam(value="nowPage", required = false)String nowPage,
			@RequestParam(value="searchType", required = false)String searchType,
			@RequestParam(value="parameter", required = false)String parameter) {
		//--페이징--

		SearchVO search = new SearchVO();
		if (nowPage == null) nowPage = "1";
		if (searchType == null) searchType="all";
		if (parameter == null) parameter = "";
		
		search.setSearchType(searchType);
		search.setParameter(parameter);
		
		PagingVO paging = new PagingVO(pointService.getTotal(search), Integer.parseInt(nowPage), 15);
		List<UserVO> userList = pointService.getUserList(paging,search);

		//--페이징end--
		List<PointVO> pointList = new ArrayList<PointVO>();
		for(UserVO user : userList) {
			PointVO point = pointService.getPoint(user.getUserId());
			if(point !=null) {
				pointList.add(point);
			}
			if(user.getUserName().length() == 2) {
				StringBuffer temp = new StringBuffer();
				temp.append(user.getUserName().substring(0, 1));
				temp.append("*");
				user.setUserName(temp.toString());
			}else if(user.getUserName().length()>2) {
				StringBuffer temp = new StringBuffer();
				temp.append(user.getUserName().substring(0, 1));
				for(int i =0; i<user.getUserName().length()-2; i++) {
					temp.append("*");
				}
				temp.append(user.getUserName().substring(user.getUserName().length()-1, user.getUserName().length()));
				user.setUserName(temp.toString());
			}
		}
		if(msg !=null) model.addAttribute("msg","insert");
		model.addAttribute("paging",paging);
		model.addAttribute("searchType",searchType);
		model.addAttribute("parameter",parameter);
		model.addAttribute("userList",userList);
		model.addAttribute("pointList",pointList);


		return "/admin/point/pointUserList";
	}
	@GetMapping("/getUserPoint.mdo")
	public String getUserPoint(@RequestParam(value="userId", required = false)String userId, Model model,
			@RequestParam(value="nowPage", required = false)String nowPage) {
		if(nowPage == null)nowPage = "1";
		
		PointVO point = pointService.getPoint(userId);// 총 포인트
		
		PagingVO paging = new PagingVO(pointService.getPointCount(userId), Integer.parseInt(nowPage), 15);
		List<PointVO> pointList=pointService.getPoints(userId, paging);
		model.addAttribute("paging",paging);
		model.addAttribute("userId",userId);
		model.addAttribute("totalPoint",point.getPoint());
		model.addAttribute("pointList",pointList);
		
		return "/admin/point/getUserPoint";
	}
	@GetMapping("/insertPoint.mdo")
	public String insertPoint(PointVO vo,RedirectAttributes attr) {
		vo.setPointDate(new Date());
		attr.addFlashAttribute("msg","msg");
		pointService.insertOnePoint(vo);
		return "redirect:/admin/pointUserList.mdo";
	}
	@GetMapping("/deletePoint.mdo")
	public String deletePoint(PointVO vo) {
		pointService.deletePoint(vo);
		return "redirect:/admin/getUserPoint.mdo?userId="+vo.getUserId();
	}
	@GetMapping("/insertPoints.mdo")
	public String insertPoints(PointVO vo, RedirectAttributes attr) {
		vo.setPointDate(new Date());
		pointService.insertPoints(vo);
		attr.addFlashAttribute("msg","msg");
		return "redirect:/admin/pointUserList.mdo";
	}
}
