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
</style>
</head>
<body>
	<div class="wrap">
		<%@include file="include/header.jsp" %>
		<div class="content">
			<div class="contentWrap">
				<h3>EVENT</h3>
				<table align="left" class="noticeTable">
					<tr>
						<th>  ${event.board_no}</th>
						<th>  ${event.board_title}</th>
					</tr>
					<tr>
						<th>  ${event.board_writer}</th>
						<th>HIT &nbsp; ${event.board_cnt}</th>
					</tr>
					<tr>
						<th>DATE &nbsp; <fmt:formatDate value="${event.reg_date}" pattern="yyyy-MM-dd "/><br>
					</tr>
					<tr>
						<td align="left"><textarea style='resize: none; border: 1px solid white;' cols="50" rows="30" readonly="readonly">${notice.board_content}</textarea></td>
					</tr>
					<tr>
						<td>
							<a href="event.do"><strong>List</strong></a>
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