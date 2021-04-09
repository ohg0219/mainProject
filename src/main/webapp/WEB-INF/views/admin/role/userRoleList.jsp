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

<title>thisisthat - 직원목록</title>

<%@include file="../include/css.jsp"%>
<%@include file="../include/js.jsp"%>
<style type="text/css">
a:link {
	color: red;
	text-decoration: none;
}

a:visited {
	color: blue;
	text-decoration: none;
}

a:hover {
	color: red;
	text-decoration: underline;
	cursor: pointer;
}

a {
	color: black;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="../include/sideMenu.jsp"%>

		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				<!-- Topbar -->
				<%@include file="../include/navbar.jsp"%>
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">권한관리</h1>
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
											<th width="100">아이디</th>
											<th width="100">성명</th>
											<th width="100">닉네임</th>
											<th width="100">휴대폰</th>
											<th width="100">입사일</th>
											<th width="100">권한</th>
										</tr>
									</thead>
									<tbody>

										<!-- 모든 변수명은 상황에 따라서 바꿔도 됩니당  ex)aritcle, articleList-->
										<c:if test="${not empty userList}">
											<c:forEach var="user" items="${userList}">
												<tr>
													<td width="85">${user.userId}</td>
													<td width="95"><a id="${user.userId }" class="who"
														data-target="#getUserModal" data-toggle="modal">${user.userName}</a></td>
													<td width="85">${user.nickName}</td>
													<td width="160">${user.userPhone}</td>
													<td width="95"><fmt:formatDate value="${user.inDate}"
															pattern="yyyy-MM-dd" /></td>
													<td><select id="${user.userId}" name="role">
															<option value="5"
																<c:if test="${user.userRole == 1 }">selected</c:if>>최고관리자</option>
															<option value="20"
																<c:if test="${user.userRole == 20 }">selected</c:if>>관리자</option>
															<option value="100"
																<c:if test="${user.userRole == 100 }">selected</c:if>>일반회원</option>
													</select></td>
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${empty userList}">
											<tr>
												<td colspan="6" align="center">
													<h3>회원이 없어요</h3>
												</td>
											</tr>
										</c:if>
									</tbody>
								</table>

								<div>
									<select name="example_length" id="select"
										aria-controls="example" class="">
										<option value="all">전체</option>
										<option value="id">아이디</option>
										<option value="nickname">닉네임</option>
									</select> <input type="text" id="search">

									<button type="button" class="btn btn-dark" id="searchBtn">
										<i class="fas fa-search fa-sm mr-2 text-gray-400"></i> 검색
									</button>

									<br>
									<div align="center">
										<c:if test="${paging.startPage != 1 }">
											<a
												href="/admin/userRoleList.mdo?nowPage=${paging.startPage - 1 }&parameter=${search.parameter}&searchType=${search.searchType}">&lt;</a>
										</c:if>
										<c:forEach begin="${paging.startPage }"
											end="${paging.endPage }" var="p">
											<c:choose>
												<c:when test="${p == paging.nowPage }">
													<b>${p }</b>
												</c:when>
												<c:when test="${p != paging.nowPage }">
													<a
														href="/admin/userRoleList.mdo?nowPage=${p }&parameter=${search.parameter}&searchType=${search.searchType}">${p }</a>
												</c:when>
											</c:choose>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</c:forEach>
										<c:if test="${paging.endPage != paging.lastPage}">
											<a id=""
												href="/admin/userRoleList.mdo?nowPage=${paging.endPage+1 }&parameter=${search.parameter}&searchType=${search.searchType}">&gt;</a>
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
		var msg = '${msg}';
		if (msg === 'msg') {
			alert('수정 성공!');
		}

		function Change() {
			var sel = $(this).attr('id');
			console.log(name);
			console.log(sel);

		}

		//--------------------검색하는 함수
		$(function() {
			$("#searchBtn").click(
					function() {
						var search = $('#search').val();
						var select = $('#select').val();

						location.href = "/admin/userRoleList.mdo?parameter="
								+ search + "&searchType=" + select
								+ "&nowPage=${paging.nowPage}";
					});
			$('#search').keypress(function(event) {
				if (event.which == 13) {
					$('#searchBtn').click();
					return false;
				}
			});
			$(document)
					.ready(
							function() {

								$('select[name=role]')
										.change(
												function() {

													var id = $(this).attr('id');
													var role = $(this).val();
													location.href = "/admin/updateRole.mdo?id="
															+ id
															+ "&role="
															+ role
															+ "&parameter=${search.parameter}&searchType=${search.searchType}&nowPage=${paging.nowPage}";
												});

							});

			//--getUser전 비밀번호 체크
			$('.who').click(function() {
				console.log("들어옴")
				document.getElementById("userId").value = $(this).attr('id');
			});
		});
	</script>
</body>
</html>