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

<title>thisisthat - 회원관리</title>

<%@include file="include/css.jsp"%>
<%@include file="include/js.jsp"%>
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
}

a {
	color: black;
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
<title>회원관리 페이지</title>
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
					<h1 class="h3 mb-2 text-gray-800">회원정보</h1>
					<p class="mb-4">
						<!-- 쓸 말 있으면 쓰는 곳 -->
					</p>

					<!-- DataTales Example -->
				
					<div class="card shadow mb-4">

						<div class="card-body">
							<div class="table-responsive">
								<div class="panel panel-info">
									<div class="panel-heading">
										<h3 class="panel-title">[${user.userId}]님의 프로필 정보</h3>
									</div>
									<div class="panel-body">
									
										<div class="row">
											<!-- 사진 -->
											<div class="col-md-3 col-lg-3 " align="center">
												<img alt="User Picture" width="250" height="200"
													src="/resources/admin/img/apeach.jpeg"
													class="img-circle img-responsive">
												
											</div>
											<!-- 정보 -->
											<div class=" col-md-9 col-lg-9 ">
												<table class="table table-user-information" >
													<tbody>
														<tr>
															<td>아이디:</td>
															<td id="userId">${user.userId}</td>
														</tr>
														<tr>
															<td>성명:</td>
															<td>${user.userName}</td>
														</tr>
														<tr>
															<td>닉네임:</td>
															<td>${user.nickName}</td>
														</tr>
														<tr>
															<td>번호:</td>
															<td>${user.userPhone}</td>
														</tr>
														<tr>
															<td>가입일:</td>
															<td><fmt:formatDate value="${user.inDate}" pattern="yyyy-MM-dd"/></td>
														</tr>
														<tr>
															<td>이메일:</td>
															<td>${user.userEmail}</td>
														</tr>	
														<tr>
															<td>회원상태:</td>
															<td>
															<c:if test="${user.userRole == 100}">
																<label><input type="radio" name="state" value="100" checked="checked">일반회원</label>&nbsp;&nbsp;
																<label><input type="radio" name="state" value="110">정지회원</label>&nbsp;&nbsp;
																<label><input type="radio" name="state" value="120" disabled="disabled">탈퇴회원</label>
															</c:if>
															<c:if test="${user.userRole == 110 }">
																<label><input type="radio" name="state" value="100">일반회원</label>&nbsp;&nbsp;
																<label><input type="radio" name="state" value="110" checked="checked">정지회원</label>&nbsp;&nbsp;
																<label><input type="radio" name="state" value="120" disabled="disabled">탈퇴회원</label>
															</c:if>
															<c:if test="${user.userRole == 120 }">
																<label><input type="radio" name="state" value="100" disabled="disabled">일반회원</label>&nbsp;&nbsp;
																<label><input type="radio" name="state" value="110" disabled="disabled">정지회원</label>&nbsp;&nbsp;
																<label><input type="radio" name="state" value="120" checked="checked">탈퇴회원</label>
															</c:if>
															</td>
														</tr>
													</tbody>
												</table>
											</div>
												<div align="center">
													<button type="button" class="btn btn-warning" id="modifyBtn" style="margin-right: 20px;">
													<i class="fa fa-pencil fa-fw mr-2 text-white-400"></i>
													수정
												</button>
												<button type="button" onclick="location.href='userList.mdo'" class="btn btn-dark" id="listBtn">
													<i class="fa fa-pencil fa-fw mr-2 text-white-400"></i>
													목록가기
												</button>
												</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
		$(function() {
			$("#modifyBtn").click(function(){
				 var state = $("input[name=state]:checked").val();
				 var userId = $("#userId").text();
				 window.location.href="/getUserUpdate.mdo?state="+state+"&userId="+userId;
				 alert("수정되었습니다.")
				 
			});
		});
	});
	</script>
</body>
</html>