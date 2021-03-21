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
		border-bottom: 1px solid #D5DBDB;
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
	td{
		float: left;
	}
	th{
		float: left;
	}
</style>
</head>
<body>
	<div class="wrap">
		<%@include file="../include/header.jsp" %>
		<div class="content">
			<div class="contentWrap">
				<h3>공지사항</h3>
				<table class="noticeTable">
					<tr>
						<th>${answer.boardTitle}</th>
					</tr>
					<tr>
						<td>${answer.boardWriter} </td><td style="padding-left: 40px">Date : <fmt:formatDate value="${answer.regDate}" pattern="yyyy-MM-dd "/></td>
					</tr>
					
					<tr>
						<td align="left"><textarea style='resize: none; border: 1px solid white;' cols="50" rows="20" readonly="readonly">${answer.boardContent}</textarea></td>
					</tr>
					<tr>
						<td>
							<a href="notice.do"><strong>List</strong></a>
						</td>
					</tr>
				</table>
			</div>
		</div><!-- end Content -->
		<%@include file="../include/footer.jsp" %>
		<div class="don"></div>
	</div>
</body>
</html>