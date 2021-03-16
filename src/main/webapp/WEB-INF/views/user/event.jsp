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
				<h3>이벤트</h3>
				<form action="event.jsp" method="post">
				<table class="noticeTable">
					<tr>
						<td align="right">
							<select name="searchCondition">
								<option value="board_title">제목
								<option value="board_content">내용
								<option value="board_all">제목+내용
							</select>
							<input type="text" name="searchKeyword"/>
							<input type="submit" value="검색"/>
						</td>
					</tr>
				</table>
				</form>
				<table class="noticeTable">
					<tr>
						<th width="60px">번호</th>
						<th width="250px">제목</th>
						<th width="60px">작성자</th>
						<th width="100px">날짜</th>
						<th width="60px">조회수</th>
					</tr>
					<c:forEach var="event" items="${eventList}">
					<tr>
						<td>${event.board_no}</td>
						<td align="center"><a href="eventView.do?board_no=${event.board_no}"><strong>${event.board_title}</strong></a></td>
						<td>${event.board_writer}</td>
						<td><fmt:formatDate value="${event.reg_date}" pattern="yyyy-MM-dd "/><br>
						<fmt:formatDate value="${event.reg_date}" pattern=" mm:ss "/></td>
						<td>${event.board_cnt}</td>
					</tr>
					</c:forEach>
				</table>
			</div>
		</div><!-- end Content -->
		<%@include file="include/footer.jsp" %>
		<div class="don"></div>
	</div>
</body>
</html>