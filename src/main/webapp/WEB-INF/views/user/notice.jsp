<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<table class="noticeTable">
					<tr>
						<th width="60px">번호</th>
						<th width="250px">제목</th>
						<th width="60px">작성자</th>
						<th width="100px">날짜</th>
						<th width="60px">조회수</th>
					</tr>
					<tr>
						<td>10</td>
						<td><a href="#">더미 제목</a></td>
						<td>관리자</td>
						<td>2021-03-07</td>
						<td>0</td>
					</tr>
					<tr>
						<td>9</td>
						<td><a href="#">더미 제목</a></td>
						<td>관리자</td>
						<td>2021-03-07</td>
						<td>0</td>
					</tr>
					<tr>
						<td>8</td>
						<td><a href="#">더미 제목</a></td>
						<td>관리자</td>
						<td>2021-03-07</td>
						<td>0</td>
					</tr>
					<tr>
						<td>7</td>
						<td><a href="#">더미 제목</a></td>
						<td>관리자</td>
						<td>2021-03-07</td>
						<td>0</td>
					</tr>
					<tr>
						<td>6</td>
						<td><a href="#">더미 제목</a></td>
						<td>관리자</td>
						<td>2021-03-07</td>
						<td>0</td>
					</tr>
					<tr>
						<td>5</td>
						<td><a href="#">더미 제목</a></td>
						<td>관리자</td>
						<td>2021-03-07</td>
						<td>0</td>
					</tr>
					<tr>
						<td>4</td>
						<td><a href="#">더미 제목</a></td>
						<td>관리자</td>
						<td>2021-03-07</td>
						<td>0</td>
					</tr>
					<tr>
						<td>3</td>
						<td><a href="#">더미 제목</a></td>
						<td>관리자</td>
						<td>2021-03-07</td>
						<td>0</td>
					</tr>
					<tr>
						<td>2</td>
						<td><a href="#">더미 제목</a></td>
						<td>관리자</td>
						<td>2021-03-07</td>
						<td>0</td>
					</tr>
					<tr>
						<td>1</td>
						<td><a href="#">더미 제목</a></td>
						<td>관리자</td>
						<td>2021-03-07</td>
						<td>0</td>
					</tr>
				</table>
			</div>
		</div><!-- end Content -->
		<%@include file="include/footer.jsp" %>
		<div class="don"></div>
	</div>
</body>
</html>