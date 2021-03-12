<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thisisthat® 디스이즈댓</title>
<link rel="stylesheet" href="/resources/user/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/user/js/common.js"></script>
<style type="text/css">
	.contentWrap{
		margin-top: 50px;
		margin-left: 20px;
	}
	.noticeTable{
    	border-collapse: collapse;
	}
	.noticeTable tr{
		border-bottom: 1px solid #D5DBDB
	}
	.noticeTable td{
		padding: 5px;
		padding-top: 16px;
		padding-bottom: 16px;
	}
	.noticeTable th{
		padding-bottom: 10px;
	}
	.noticeTable a{
		text-decoration: none;
		color: black;
	}
	.noticeTable a:hover{
		text-decoration: underline;
		font-weight: 600;
	}
	.noticeTable td{
		text-align: center;
	}
	.noticeTable td:nth-child(2) {
		text-align: left;
	}
</style>
</head>
<body>
	<div class="wrap">
		<%@include file="include/header.jsp" %>
		<div class="content">
			<div class="contentWrap">
				<h6>공지사항</h6>
				<table align="left" class="noticeTable">
					<tr>
						<th>글번호 : ${event.board_no}</th>
						<th>글제목 : ${event.board_title}</th>
					</tr>
					<tr>
						<th>작성자 : ${event.board_writer}</th>
						<th>조회수 : ${event.board_cnt}</th>
					</tr>
					<tr>
						<th>날짜 : <fmt:formatDate value="${event.reg_date}" pattern="yyyy-MM-dd "/><br>
						<fmt:formatDate value="${event.reg_date}" pattern=" hh:mm:ss "/></th>
					</tr>
					<tr>
						<td align="left"><textarea style='resize: none; border: 1px solid white;' cols="50" rows="50" readonly="readonly">${notice.board_content}</textarea></td>
					</tr>
					<tr>
						<td>
							<a href="notice.do"><strong>목록으로</strong></a>
						</td>
					</tr>
				</table>
			</div>
		</div><!-- end Content -->
		<%@include file="include/footer.jsp" %>
		<div class="don"></div>
	</div>
</body>
</html>