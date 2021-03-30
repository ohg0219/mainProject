<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link href="/resources/admin/img/noimg.jpg" rel="shortcut icon" type="image/x-icon">
<meta charset="UTF-8">
<title>thisisthat® 디스이즈댓</title>
<link rel="stylesheet" href="/resources/user/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/user/js/common.js"></script>
<style type="text/css">
.contentWrap {
	margin-top: 50px;
	margin-left: 20px;
}

.noticeTable {
	border-collapse: collapse;
}

.noticeTable tr {
	
}

.noticeTable td {
	padding: 5px;
	padding-top: 16px;
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
</style>
</head>
<body>
	<div class="wrap">
		<%@include file="../include/header.jsp"%>
		<div class="content">
			<div class="contentWrap">
				<h3>Q&A</h3>
				<form action="/answerList.do" method="get">
					<select name="searchDate">
						<option value="7">일주일
						<option value="30">한달
						<option value="90">세달
						<option value="all">전체
					</select> <select name="searchType">
						<option value="all">전체</option>
						<option value="title">제목</option>
						<option value="content">내용</option>
						<option value="id">아이디</option>
					</select> <input type="text" name="searchKeyword" /> <input type="submit"
						value="검색" />

					<table class="noticeTable">
						<tr>
							<th width="60px">번호</th>
							<th width="250px">제목</th>
							<th width="60px">작성자</th>
							<th width="100px">날짜</th>
						</tr>
						<c:if test="${not empty answerList}">
							<c:forEach var="answer" items="${answerList}">
								<tr>
									<td>${answer.boardNo}</td>
									<td align="center"><strong><a id="${answer.boardWriter }" class="img-circle" onclick="userCheck()"
											href="getAnswer.do?boardNo=${answer.boardNo}">${answer.boardTitle}
										<c:if test="${answer.boardSecret }" >
											<img alt="이미지를 불러오지 못했습니다" width="10" height="10"
																id="img" name="true"
																src="/resources/admin/icon/lock.png"
																class="img-circle img-responsive">
											<input type="hidden" id="img" class="${boardWriter}">
										</c:if>
										<c:if test="${!answer.boardSecret }" >
											<input type="hidden" id="img" class="${boardWriter}">
										</c:if>
									
									</a></strong></td>
									<td>${answer.boardWriter}</td>
									<td><fmt:formatDate value="${answer.regDate}"
											pattern="yyyy-MM-dd " /><br>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${empty answerList }">
							<tr>
								<td colspan="4"><h1>게시글이 없어요</h1></td>
							</tr>
						</c:if>
					</table>
					
					<div style="display: block; text-align: left; margin-left: 70px;">
						<c:if test="${paging.startPage != 1 }">
							<a
								href="/answerList.do?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}
								&searchType=${searchType}&searchKeyword=${searchKeyword}&
												searchDate=${searchDate}">&lt;</a>
						</c:if>
						<c:forEach begin="${paging.startPage }" end="${paging.endPage }"
							var="p">
							<c:choose>
								<c:when test="${p == paging.nowPage }">
									<b>${p }</b>
								</c:when>
								<c:when test="${p != paging.nowPage }">
									<a
										href="/answerList.do?nowPage=${p }&cntPerPage=${paging.cntPerPage}
												&searchType=${searchType}&searchKeyword=${searchKeyword}&
												searchDate=${searchDate}">${p }</a>
								</c:when>
							</c:choose>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</c:forEach>
						<c:if test="${paging.endPage != paging.lastPage}">
							<a id=""
								href="/answerList.do?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}
										&searchType=${searchType}&searchKeyword=${searchKeyword}&
												searchDate=${searchDate}">&gt;</a>
						</c:if>
						<br>
						<a href="/insertAnswer.do" id="insertBt" style="    display: inline-block;
    
    cursor: pointer;
    width: auto;
    height: auto;
    border-radius: 3px;
    box-sizing: border-box;
    font-size: 11px;
    text-align: center;
    background: #fff;
    color: #111;
    margin-top: 20px;
    margin-left: 230px;
    border: 1px solid #111;
    text-decoration: none;
    padding: 0px 80px;">글쓰기</a> <a class="img-circle">qweqwe</a>
					</div>
				</form>
			</div>
		</div>
		<!-- end Content -->
		<%@include file="../include/footer.jsp"%>
		<div class="don"></div>
	</div>
</body>
<script type="text/javascript">
	var userId = '${userId}';
	if(userId === 'noId'){
		$('#insertBt').hide();
	}
	var msg = '${msg}';
	if(msg === 'msg'){
		alert('비밀글 입니다');
	}
</script>
</html>