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

<title>thisisthat - 회원목록</title>

<%@include file="../include/css.jsp"%>
<%@include file="../include/js.jsp"%>
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
	cursor: pointer;
}

a {
	color: green;
}
</style>
<!-- Custom fonts for this template-->
    <link href="/resources/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/admin/css/sb-admin-2.min.css" rel="stylesheet">

<meta charset="UTF-8">
<title>배너 관리</title>
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
					<h1 class="h3 mb-2 text-gray-800">회원목록</h1>
					<p class="mb-4">
						<!-- 쓸 말 있으면 쓰는 곳 -->
					</p>
					
					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<!--   <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">공지사항</h6>
                        </div>
                        -->
					<a id="${user.userId }" class="btn btn-dark pointbt" data-target="#insertUsersPointModal" data-toggle="modal">전체 포인트부여</a>
					
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th width="200px">아이디</th>
											<th width="200px">이름</th>
											<th width="200px">닉네임</th>
											<th width="50px">포인트</th>
											<th width="50px">포인트부여</th>
										</tr>
									</thead>
									<tbody>

										
										<c:if test="${not empty userList}">
											<c:forEach var="user" items="${userList}">
												<tr>
												<td><a href="/admin/getUserPoint.mdo?userId=${user.userId}">${user.userId}</a></td>
												<td>${user.userName }</td>
												<td>${user.nickName}</td>
												<td>
												<c:if test="${not empty userList}">
													<c:forEach var="point" items="${pointList}">
														<c:if test="${user.userId == point.userId }">
															<fmt:formatNumber value="${point.point }" pattern="#,###"/>


														</c:if>
													</c:forEach>
												</c:if>
												</td>
												<td>
													<a id="${user.userId }" class="btn btn-dark pointbt" data-target="#insertUserPointModal" data-toggle="modal">포인트부여</a>
												</td>
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
								<form action="/admin/pointUserList.mdo" method="get">
									<select name="searchType" id="search_select" aria-controls="example">
										<option value="all">전체</option>
										<option value="id">아이디</option>
										<option value="nick">닉네임</option>
									</select>

									 <input type="search" name="parameter" placeholder="검색어를 입력해 주세요">
		
									<input type="submit" value = "검색" class="btn btn-dark pointbt">
									</form>
									<br>
									<div align="center">
										<c:if test="${paging.startPage != 1 }">
							<a
								href="/admin/pointUserList.mdo?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}
								&searchType=${searchType}&parameter=${parameter}">&lt;</a>
						</c:if>
						<c:forEach begin="${paging.startPage }" end="${paging.endPage }"
							var="p">
							<c:choose>
								<c:when test="${p == paging.nowPage }">
									<b>${p }</b>
								</c:when>
								<c:when test="${p != paging.nowPage }">
									<a
										href="/admin/pointUserList.mdo?nowPage=${p }&cntPerPage=${paging.cntPerPage}
												&searchType=${searchType}&parameter=${parameter}">${p }</a>
								</c:when>
							</c:choose>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</c:forEach>
						<c:if test="${paging.endPage != paging.lastPage}">
							<a id=""
								href="/admin/pointUserList.mdo?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}
										&searchType=${searchType}&parameter=${parameter}">&gt;</a>
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
	
	<form action="/admin/insertPoint.mdo" method="get">
	<div class="modal fade" id="insertUserPointModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">포인트 부여</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-content">
					<input type="text" name="pointContent" placeholder="포인트 내용" required="required">
					<br>
					<input type="number" name="point" placeholder="포인트" required="required">
					
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
	<form action="/admin/insertPoints.mdo" method="get">
	<div class="modal fade" id="insertUsersPointModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">포인트 부여</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-content">
					<input type="text" name="pointContent" placeholder="포인트 내용" required="required">
					<br>
					<input type="number" name="point" placeholder="포인트" required="required">
					
				</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<input type="submit" class="btn btn-primary" id="modalInput" value="확인">		
				</div>
			</div>
		</div>
	</div>
	</form>

	<script>
	var msg = '${msg}';
	if(msg==='insert'){		
		alert('포인트 부여 성공!');
	}
	
		$(function(){
			$("#searchBtn").click(function(){
				var search = $('#search').val();
				var select = document.getElementById("search_select");
				var val;

				for(i=0; i<select.options.length; i++) {
				    if(select.options[i].selected == true) {
				        val = select.options[i].value;
				        break;
				    }
				}location.href="userList.mdo?search="+search+"&select="+val;
			});
			
			$('#search').keypress(function(event){
			     if ( event.which == 13 ) {
			         $('#searchBtn').click();
			         return false;
			     }
			});
			$('.pointbt').click(function(){
				document.getElementById("userId").value = $(this).attr('id'); 
			})	
		});
		

			
		

	</script>
</body>
</html>