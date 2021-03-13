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
<!-- Custom fonts for this template-->
    <link href="/resources/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/admin/css/sb-admin-2.min.css" rel="stylesheet">

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
<<<<<<< HEAD
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>아이디</th>
											<th align="center">성명</th>
											<th>닉네임</th>
											<th>휴대폰</th>
											<th>가입일</th>
											<th>계정관리</th>
										</tr>
									</thead>
									<tbody>

										<!-- 모든 변수명은 상황에 따라서 바꿔도 됩니당  ex)aritcle, articleList-->
										<c:if test="${not empty userInfo}">
											<c:forEach var="user" items="${userInfo}">
												<tr>
													<td width="85">${user.userId}</td>
													<td width="95"><a
														id = "${user.userId }" class="who"
														data-toggle="modal" data-target="#getUserModal">${user.userName}</a></td>
													<td width="85">${user.nickName}</td>
													<td width="160">${user.userPhone}</td>
													<td width="95"><fmt:formatDate value="${user.inDate}"
															pattern="yyyy-MM-dd" /></td>
													<c:if test="${not empty user.outDate}">
														<td width="75">탈퇴</td>
													</c:if>
													<c:if test="${empty user.outDate }">
														<td width="75">회원</td>
													</c:if>
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${empty userInfo}">
											<tr>
												<td colspan="6" align="center">
													<h3>회원이 없어요</h3>
												</td>
											</tr>
										</c:if>
									</tbody>
								</table>

								<div>
									<select name="example_length" aria-controls="example" class="">
										<option value="all">전체</option>
=======
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>아이디</th>
                                            <th align="center">성명</th>
                                            <th>닉네임</th>
                                            <th>휴대폰</th>
                                            <th>가입일</th>
                                            <th>계정관리</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                    <!-- 모든 변수명은 상황에 따라서 바꿔도 됩니당  ex)aritcle, articleList-->
                                    	<c:if test="${not empty userInfo}" >
	                                        <c:forEach var="user" items="${userInfo}">
		                                        <tr>
			                                        <td width="85">${user.userId}</td>
			                                        <td width="95"><a href="getUser.mdo?userId=${user.userId}">${user.userName}</a></td>
			                                        <td width="85">${user.nickName}</td>
			                                        <td width="160">${user.userPhone}</td>
			                                        <td width="95"><fmt:formatDate value="${user.inDate}" pattern="yyyy-MM-dd"/></td>
			                                        	<c:if test="${not empty user.outDate}">
			                                        		<td width="75">탈퇴</td>
			                                        	</c:if>
			                                        	<c:if test="${empty user.outDate }">
			                                        		<td width="75">회원</td>
			                                        	</c:if>
			                                    </tr>
	                                        </c:forEach>
                                        </c:if>
                                        <c:if test="${empty userInfo}">
                                        	<tr>
                                        		<td colspan="5" align="center">
                                        		<h3> 회원이 없어요</h3>
                                        		</td>
                                        	</tr>
                                        </c:if>
                                    </tbody>
                                </table>
                                		
                                <div>
									<select id="search_select" aria-controls="example" class="">
>>>>>>> d1a315cd3c3063ffbff02384c039f35455a71263
										<option value="id">아이디</option>
										<option value="nickname">닉네임</option>
<<<<<<< HEAD
									</select> <input type="text" id="search">
=======
									</select>
									<input type="text" id="search">
>>>>>>> d1a315cd3c3063ffbff02384c039f35455a71263

									<button type="button" class="btn btn-dark" id="searchBtn">
										<i class="fa fa-pencil fa-fw mr-2 text-gray-400"></i> 검색버튼
									</button>
									<br>
									<div align="center">
										<a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a
											href="#">4</a> <a href="#">5</a> <a href="#">6</a> <a
											href="#">7</a> <a href="#">8</a> <a href="#">9</a> <a
											href="#">10</a>
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
				var select = document.getElementById("search_select");
				var val;

				for(i=0; i<select.options.length; i++) {
				    if(select.options[i].selected == true) {
				        val = select.options[i].value;
				        break;
				    }
				}location.href="userList.mdo?search="+search+"&select="+val;
				console.log(search);
				console.log(select);
				console.log(val);
			});
			$('#search').keypress(function(event){
			     if ( event.which == 13 ) {
			         $('#searchBtn').click();
			         return false;
			     }
			});
			
<<<<<<< HEAD
			//--getUser전 비밀번호 체크
			$('.who').click(function(){
				document.getElementById("userId").value = $(this).attr('id'); 
			})	
		});
		
=======
			
		});
>>>>>>> d1a315cd3c3063ffbff02384c039f35455a71263
	</script>
</body>
</html>