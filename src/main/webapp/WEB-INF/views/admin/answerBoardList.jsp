<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>thisisthat - Q&A</title>

<%@include file="include/css.jsp"%>
<%@include file="include/js.jsp"%>
<style type="text/css">
a:link {
	
	text-decoration: none;
}

a:visited {
	color: blue;
	text-decoration: none;
}

a:hover {
	color: red;
	text-decoration: underline;
	font-size: 17px;
}

a {
	color: green;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="include/sideMenu.jsp"%>

		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				<!-- Topbar -->
				<%@include file="include/navbar.jsp"%>
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Q&A게시판</h1>
					<div style="float: right;">
						<select id="cntPerPage" name="sel" onchange="selChange()">
							<option value="5"
								<c:if test="${paging.cntPerPage == 5}">selected</c:if>>5줄 보기</option>
							<option value="10"
								<c:if test="${paging.cntPerPage == 10}">selected</c:if>>10줄 보기</option>
							<option value="15"
								<c:if test="${paging.cntPerPage == 15}">selected</c:if>>15줄 보기</option>
							<option value="20"
								<c:if test="${paging.cntPerPage == 20}">selected</c:if>>20줄 보기</option>
						</select>
					</div>
						<p class="mb-4">
						<!-- 쓸 말 있으면 쓰는 곳 -->
					</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<!--   <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">공지사항</h6>
                        </div>
                        -->
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>번호</th>
											<th>질문타입</th>
											<th>이미지</th>
											<th align="center">제목</th>
											<th>작성자</th>
											<th>등록일</th>
											<th>처리날짜</th>
											<th>상태</th>
											
										</tr>
									</thead>
									<tbody>

										<!-- 모든 변수명은 상황에 따라서 바꿔도 됩니당  ex)aritcle, articleList-->
										<c:if test="${not empty answerList}">
											<c:forEach var="answer" items="${answerList}">
												<tr>
													<td width="20">${answer.boardNo}</td>
													<td width="20">${answer.boardType }</td>
													<td width="50">													
													<!-- 이미지 Start -->
													<c:if test="${not empty answer.boardImg1 }">
														<img alt="이미지를 불러오지 못했습니다" width="50" height="50"
													src="${answer.boardImg1 }"
													class="img-circle img-responsive">													
													
													</c:if>
													<c:if test="${empty answer.boardImg1 }">
														<a href="/admin/getAnswer.mdo?no=${answer.boardNo}">
															<img alt="이미지를 불러오지 못했습니다" width="50" height="50"
														src="/resources/admin/img/noimg.jpg"
														class="img-circle img-responsive">
														</a>													
													</c:if>
													</td>
													<!-- 이미지 end -->
													<td width="160"><a href=""/admin/getAnswer.mdo?no=${answer.boardNo}">${answer.boardTitle}</a>
														<c:if test="${answer.boardSecret}">
															<img alt="이미지를 불러오지 못했습니다" width="50" height="50"
															src="/resources/admin/icon/lock.png"
															class="img-circle img-responsive">
														</c:if>
														<c:if test="${not empty adminAnswerList }">
															<c:forEach var="ans" items="${adminAnswerList}">
																<c:if test="${answer.boardNo == ans.resultNo }">
																 <br>&nbsp;&nbsp;&nbsp;└<a href="/admin/getAnswer.mdo?no=${ans.boardNo}">${ans.boardTitle }</a>
																</c:if>
															</c:forEach>
														</c:if>
													</td>
													<td width="85">${answer.boardWriter}</td>
													<td width="100" ><fmt:formatDate value="${answer.regDate}"
															pattern="yyyy-MM-dd" /><br>
															<fmt:formatDate value="${answer.regDate}"
															pattern="HH:mm" />
															</td>
													<c:if test="${not empty answer.updateDate}">
														<td width="75">
															<fmt:formatDate value="${answer.updateDate}"
															pattern="yyyy-MM-dd" /><br>
															<fmt:formatDate value="${answer.updateDate}"
															pattern="HH:mm" />
														</td>
													</c:if>
													<c:if test="${empty answer.updateDate}">
														<td width="75">처리중 입니다</td>
													</c:if>
													<td width="50">${answer.boardState }</td>
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${empty answerList}">
											<tr>
												<td colspan="6" align="center">
													<h3>등록된 글이 없습니다.</h3>
												</td>
											</tr>
										</c:if>
									</tbody>
								</table>

								<div>
									<select name="example_length" aria-controls="example" class="">
										<option value="all">전체</option>
										<option value="id">아이디</option>
										<option value="name">이름</option>
										<option value="nickname">닉네임</option>
									</select> <input type="text" id="search">

									<button type="button" class="btn btn-dark" id="searchBtn">
										<i class="fa fa-pencil fa-fw mr-2 text-gray-400"></i> 검색버튼
									</button>

									<br>
									
									<div style="display: block; text-align: center;">		
		<c:if test="${paging.startPage != 1 }">
			<a href="/admin/answerBoardList.mdo?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="/admin/answerBoardList.mdo?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="/admin/answerBoardList.mdo?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
	</div>	

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<ul class="navbar-nav ml-auto">
		<!-- Nav Item - User Information -->
		<li class="nav-item dropdown no-arrow">
			<button type="button" class="btn btn-dark" data-toggle="modal"
				data-target="#getUserModal">
				<i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
				Logout
			</button>
		</li>
	</ul>
	<form action="/admin/pwCheck.mdo" method="post">
	<div class="modal fade" id="getUserModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">비밀번호를 입력해 주세요</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-content">
					<input type="password" name="userPw" placeholder="비밀번호">
					
				</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<input type="submit" class="btn btn-primary" id="modalInput" value="확인">					
					<input type="hidden" id="userId" name="userId">
				</div>
			</div>
		</div>
	</div>
	</form>

	<script>
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href="/admin/answerBoardList.mdo?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}
	
	//--------------------검색하는 함수
	var msg = '${msg}';
	var failId = '${failId}';
	if(msg==='fail'){
		console.log(failId);
		document.getElementById(failId).click();
		alert('비밀번호를 확인해 주세요');
	}
		$(function(){
			$("#searchBtn").click(function(){
				var search = $('#search').val();
				location.href="/notice.mdo?search="+search;
				console.log(search);
			});
			
			//--getUser전 비밀번호 체크
			$('.who').click(function(){
				document.getElementById("userId").value = $(this).attr('id'); 
			})	
		});
		
	</script>
</body>
</html>