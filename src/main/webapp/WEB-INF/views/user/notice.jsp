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
				<h3>NOTICE</h3>
				<script type="text/javascript">
					$(function(){
						$()
					});
				</script>
				<table class="noticeTable">
					<tr>
						<th width="60px">NO.</th>
						<th width="250px">SUBJECT</th>
						<th width="60px">이름</th>
						<th width="100px">DATE</th>
						<th width="60px">HIT</th>
					</tr>
					<c:if test="${not empty noticeList}">
						<c:forEach var="notice" items="${noticeList}">
						<tr>
							<td>${notice.board_no}</td>
							<td align="center"><strong><a href="/noticeView.do?board_no=${notice.board_no}">${notice.board_title}</a></strong></td>
							<td>${notice.board_writer}</td>
							<td><fmt:formatDate value="${notice.reg_date}" pattern="yyyy-MM-dd "/><br>
							<td>${notice.board_cnt}</td>
						</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty noticeList}">
						<tr>
							<td colspan="5" align="center">
								<h1>게시글이 없습니다.</h1>
							</td>
						</tr>
					</c:if>
				</table>
				
				<form action="/noticesearch.do" method="get">
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
		<%@include file="include/footer.jsp" %>
		<div class="don"></div>
	</div>
</body>
</html>