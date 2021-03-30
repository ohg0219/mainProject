<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="/resources/admin/img/noimg.jpg" rel="shortcut icon"
	type="image/x-icon">
<meta charset="UTF-8">
<title>thisisthat® 디스이즈댓</title>
<link rel="stylesheet" href="/resources/user/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/user/js/common.js"></script>
<style type="text/css">
.contentWrap {
	margin-top: 20px;
	margin-left: 20px;
}

.noticeTable {
	border-collapse: collapse;
}

.noticeTable tr {
	
}

.noticeTable td {
	padding: 5px;
	
	padding-bottom: 16px;
}

.noticeTable th {
	padding-bottom: 10px;
}

.noticeTable a {
	text-decoration: none;
	color: black;
}

.noticeTable a:hover {
	text-decoration: underline;
	font-weight: 600;
}

.noticeTable td {
	text-align: center;
}

.noticeTable td:nth-child(2) {
	text-align: left;
}
a {
	    font-size: 11px;
    line-height: 1.5;
    padding-bottom: 4px;
    letter-spacing: 0.075em;
    color: #111;
    border-bottom: 2px solid #111;
}
</style>
</head>
<body>
	<div class="wrap" align="center">
		<%@include file="../include/header.jsp"%>
		<div class="content">
			<div class="contentWrap">
				<form action="/insertAnswer.do" method="post" enctype="multipart/form-data">
					<table class="noticeTable">
						<h1>Q&A</h1>
						<br><br><br><br><br><br><br><br>
						
						
						
						<tr>
							<td><input required="required" type="text" name="boardTitle" placeholder="제목"
							style="width: 418px;"></td>
						</tr>
						<tr>
							<td><textarea required="required" name="boardContent" style="width: 418px; height: 480px; resize: none;" ></textarea></td>
						
						</tr>
						<tr>
							<td style="float: left;">file 1 &nbsp;&nbsp;&nbsp;&nbsp;<input multiple id="boardImg1" name="img" type="file"></td>
						</tr>
						<tr>
							<td style="float: left;">file 2 &nbsp;&nbsp;&nbsp;&nbsp;<input onclick="seqClick1()" id="boardImg2" name="img" type="file"></td>
						</tr>
						<tr>
							<td style="float: left;">file 3 &nbsp;&nbsp;&nbsp;&nbsp;<input onclick="seqClick2()" id="boardImg3" name="img" type="file"></td>
						</tr>
						<tr>
							<td style="float: left;">file 4 &nbsp;&nbsp;&nbsp;&nbsp;<input onclick="seqClick3()" id="boardImg4" name="img" type="file"></td>
						</tr>
						<tr>
							<td style="float: left;">secret &nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="boardSecret" checked="checked" value="false">&nbsp;&nbsp;공개글
							&nbsp; <input type="radio" name="boardSecret" value="true">&nbsp;&nbsp;비밀글
							</td>
						</tr>
						
						<tr>
							<td><a href="/answerList.do" style="float: left;" class="btn btn-dark">list</a><input value="등록" type="submit" class="btn btn-dark" 
							style="border-radius: 3px; cursor:pointer; line-height: 16px; background: #fff; color: #111; border: 1px solid #111; padding: 0px 40px;
							 float: right;"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<!-- end Content -->

	</div>
	<%@include file="../include/footer.jsp"%>
</body>
<script type="text/javascript">
$(function(){
	$("#boardImg2").click(function(){
		if(document.getElementById('boardImg1').value == ''){
			alert('1번 이미지를 넣은 후 시도해 주세요');
			return false;
		}
	});
	$("#boardImg3").click(function(){
		if(document.getElementById('boardImg2').value == ''){
			alert('2번 이미지를 넣은 후 시도해 주세요');
		return false;
		}
	});
	$("#boardImg4").click(function(){
		if(document.getElementById('boardImg3').value == ''){
			alert('3번 이미지를 넣은 후 시도해 주세요');
		return false;
		}
	});
});

</script>
</html>