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
	margin-left: 30%;
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
.pageBtn{
padding: 8px;
border: 1px solid black;
text-decoration: none;
}
.pageBtn:hover{
	background-color: black;
	color: white;
}
.nowpageBtn{
	padding: 8px;
	border: 1px solid black;
	text-decoration: none;
	background-color: black;
	color: white;
}
</style>
</head>
<body>
	<div class="wrap">
		<%@include file="../include/header.jsp" %>
		<div class="content">
			<div class="contentWrap">
				<h4>EVENT</h4>
				<table class="noticeTable">
					<tr>
						<th width="60px">NO.</th>
						<th width="200px">SUBJECT</th>
						<th width="100px">이름</th>
						<th width="80px">DATE</th>
						<th width="50px">HIT</th>
					</tr>
					<c:if test="${not empty eventList}">
						<c:forEach var="event" items="${eventList}">
							<tr>
								<td>${event.board_no}</td>
								<td align="center"><a href="eventView.do?board_no=${event.board_no}"><strong>${event.board_title}</strong></a></td>
								<td>${event.board_writer}</td>
								<td><fmt:formatDate value="${event.reg_date}"  pattern="yyyy-MM-dd"/><br>
								<td>${event.board_cnt}</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty eventList}">
						<tr>
							<td colspan="5" align="center">
								<h1>게시글이 없습니다.</h1>
							</td>
						</tr>
					</c:if>
				</table>
				<br>
				<div style="width:490px; display: block; text-align: center;">
					<c:if test="${paging.startPage != 1 }">
						<a class="pageBtn" href="/event.do?nowPage=${paging.startPage - 1 }&keyword=${keyword}&searchOption=${searchOption}">&lt;</a>
					</c:if>
					<c:forEach begin="${paging.startPage }"
						end="${paging.endPage }" var="p">
						<c:choose>
							<c:when test="${p == paging.nowPage }">
								<b class="nowpageBtn">${p }</b>
							</c:when>
							<c:when test="${p != paging.nowPage }">
								<a class="pageBtn" href="/event.do?nowPage=${p }&keyword=${keyword}&searchOption=${searchOption}">${p }</a>
							</c:when>
						</c:choose>
					</c:forEach>
					<c:if test="${paging.endPage != paging.lastPage}">
						<a class="pageBtn" href="/event.do?nowPage=${paging.endPage+1 }&keyword=${keyword}&searchOption=${searchOption}">&gt;</a>
					</c:if>
				</div>
				<form action="/event.do" method="get">
				<table class="noticeTable">
					<tr>
						<td align="right">
							<select name="searchOption">
								<option value="all">전체
								<option value="board_title">제목
								<option value="board_writer">작성자
								<option value="board_content">내용
							</select>
							<input type="text" name="keyword"/>
							<input type="submit" value="검색"/>
						</td>
					</tr>
				</table>
				</form>
				
			</div>
		</div><!-- end Content -->
		<%@include file="../include/footer.jsp" %>
		<div class="don"></div>
	</div>
</body>
</html>