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
}

a {
	color: green;
}
</style>

<meta charset="UTF-8">
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

							<div style="float: right;">
								<select id="cntPerPage" name="sel" onchange="selChange()">
									<option value="5"
										<c:if test="${paging.cntPerPage == 5}">selected</c:if>>5줄
										보기</option>
									<option value="10"
										<c:if test="${paging.cntPerPage == 10}">selected</c:if>>10줄
										보기</option>
									<option value="15"
										<c:if test="${paging.cntPerPage == 15}">selected</c:if>>15줄
										보기</option>
									<option value="20"
										<c:if test="${paging.cntPerPage == 20}">selected</c:if>>20줄
										보기</option>
								</select>
							</div>
							<div class="table-responsive">

								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>번호</th>
											<th><select id="type" name="sel" onchange="Change()">
													<option value="all"
														<c:if test="${type == 'all'}">selected</c:if>>질문타입</option>
													<option value="product"
														<c:if test="${type == 'product'}">selected</c:if>>상품문의</option>
													<option value="delivery"
														<c:if test="${type == 'delivery'}">selected</c:if>>배송문의</option>
													<option value="other"
														<c:if test="${type == other}">selected</c:if>>기타문의</option>
											</select></th>
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
														<!-- 이미지 Start --> <c:if
															test="${not empty answer.boardImg1 }">
															<a href="/admin/getAnswer.mdo?no=${answer.boardNo}">
																<img alt="이미지를 불러오지 못했습니다" width="50" height="50"
																src="${answer.boardImg1 }"
																class="img-circle img-responsive">
															</a>
														</c:if> <c:if test="${empty answer.boardImg1 }">
															<a href="/admin/getAnswer.mdo?no=${answer.boardNo}">
																<img alt="이미지를 불러오지 못했습니다" width="50" height="50"
																src="/resources/admin/img/noimg.jpg"
																class="img-circle img-responsive">
															</a>
														</c:if>
													</td>
													<!-- 이미지 end -->
													<td width="160"><a
														href="/admin/getAnswer.mdo?no=${answer.boardNo}">${answer.boardTitle}</a>
														<c:if test="${answer.boardSecret}">
															<img alt="이미지를 불러오지 못했습니다" width="50" height="50"
																src="/resources/admin/icon/lock.png"
																class="img-circle img-responsive">
														</c:if> <c:if test="${not empty replyList}">
															<c:forEach var="ans" items="${replyList}">
																<c:if test="${ans.resultNo == answer.boardNo}">
																	<br>&nbsp;&nbsp;&nbsp;<a
																		href="/admin/getReply.mdo?no=${ans.boardNo}">└${ans.boardTitle }</a>
																</c:if>
															</c:forEach>
														</c:if></td>
													<td width="85">${answer.boardWriter}</td>
													<td width="100"><fmt:formatDate
															value="${answer.regDate}" pattern="yyyy-MM-dd" /><br>
														<fmt:formatDate value="${answer.regDate}" pattern="HH:mm" />
													</td>
													<c:if test="${not empty answer.updateDate}">
														<td width="75"><fmt:formatDate
																value="${answer.updateDate}" pattern="yyyy-MM-dd" /><br>
															<fmt:formatDate value="${answer.updateDate}"
																pattern="HH:mm" /></td>
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
												<td colspan="8" align="center">
													<h3>등록된 글이 없습니다.</h3>
												</td>
											</tr>
										</c:if>
									</tbody>
								</table>

								<div>
									<select id="searchSelect" aria-controls="example" class="">
										<option value="아이디">아이디</option>
										<option value="이름">이름</option>
									</select> <input type="text" id="search">

									<button type="button" class="btn btn-dark" id="searchBtn">
										<i class="fas fa-search fa-sm mr-2 text-gray-400"></i> 검색
									</button>

									<br>

									<div style="display: block; text-align: center;">
										<c:if test="${paging.startPage != 1 }">
											<a
												href="/admin/answerBoardList.mdo?nowPage=${paging.startPage - 1 }
												&searchType=${search.searchType}&parameter=${search.parameter}">&lt;</a>
										</c:if>
										<c:forEach begin="${paging.startPage }"
											end="${paging.endPage }" var="p">
											<c:choose>
												<c:when test="${p == paging.nowPage }">
													<b>${p }</b>
												</c:when>
												<c:when test="${p != paging.nowPage }">
													<a
														href="/admin/answerBoardList.mdo?nowPage=${p }
												&searchType=${search.searchType}&parameter=${search.parameter}">${p }</a>
												</c:when>
											</c:choose>
										</c:forEach>
										<c:if test="${paging.endPage != paging.lastPage}">
											<a
												href="/admin/answerBoardList.mdo?nowPage=${paging.endPage+1 }
										&searchType=${search.searchType}&parameter=${search.parameter}">&gt;</a>
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


	<script>
		function selChange() {
			var sel = document.getElementById('cntPerPage').value;
			var type = document.getElementById('type').value;
			location.href = "/admin/answerBoardList.mdo?nowPage=${paging.nowPage}&cntPerPage="
					+ sel + "&type=" + type;

		}
		function Change() {
			var sel = document.getElementById('cntPerPage').value;
			var type = document.getElementById('type').value;
			location.href = "/admin/answerBoardList.mdo?type=" + type;

		}

		//--------------------검색하는 함수
		var msg = '${msg}';

		if (msg === '잘못된 요청입니다') {
			alert(msg);
		}

		$(function() {
			$("#searchBtn")
					.click(
							function() {
								var sel = document.getElementById('cntPerPage').value;
								var type = document.getElementById('type').value;
								var parameter = $('#search').val();
								var searchType = document
										.getElementById('searchSelect').value;
								location.href = "/admin/answerBoardList.mdo?cntPerPage="
										+ sel
										+ "&type="
										+ type
										+ "&searchType="
										+ searchType
										+ "&parameter=" + parameter;
								console.log(search);
							});

			//--getUser전 비밀번호 체크
			$('.who').click(function() {
				document.getElementById("userId").value = $(this).attr('id');
			})
		});
	</script>
</body>
</html>