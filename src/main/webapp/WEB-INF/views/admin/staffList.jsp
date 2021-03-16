<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>thisisthat - 직원목록</title>

<%@include file="include/css.jsp"%>
<%@include file="include/js.jsp"%>
<style type="text/css">
 a:link { color: red; text-decoration: none;}
 a:visited { color: blue; text-decoration: none;}
 a:hover { color: red; text-decoration: underline;}
 a {color:black;}
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
                    <h1 class="h3 mb-2 text-gray-800">직원목록</h1>
                    <p class="mb-4"><!-- 쓸 말 있으면 쓰는 곳 --></p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                       <!--   <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">공지사항</h6>
                        </div>
                        -->
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>아이디</th>
                                            <th>성명</th>
                                            <th>닉네임</th>
                                            <th>휴대폰</th>
                                            <th>입사일</th>
                                            <th>계정관리</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                    <!-- 모든 변수명은 상황에 따라서 바꿔도 됩니당  ex)aritcle, articleList-->
                                    	<c:if test="${not empty staffInfo}" >
	                                        <c:forEach var="user" items="${staffInfo}">
		                                        <tr>
			                                        <td width="85">${user.userId}</td>
			                                        <td width="95"><a href="getStaff.mdo?userId=${user.userId}">${user.userName}</a></td>
			                                        <td width="85">${user.nickName}</td>
			                                        <td width="160">${user.userPhone}</td>
			                                        <td width="95"><fmt:formatDate value="${user.inDate}" pattern="yyyy-MM-dd"/></td>
			                                        	<c:if test="${not empty user.outDate}">
			                                        		<td width="75">퇴사</td>
			                                        	</c:if>
			                                        	<c:if test="${empty user.outDate }">
			                                        		<td width="75">회원</td>
			                                        	</c:if>
			                                    </tr>
	                                        </c:forEach>
                                        </c:if>
                                        <c:if test="${empty staffInfo}">
                                        	<tr>
                                        		<td colspan="6" align="center">
                                        		<h3> 직원이 없어요</h3>
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
									</select>
										                                    		
									<input type="text" id="search">

									<button type="button" class="btn btn-dark" id="searchBtn">
										<i class="fa fa-pencil fa-fw mr-2 text-gray-400"></i>
										검색버튼
									</button>

									<br>
									<div align="center">
									<a href="#">1</a>
									<a href="#">2</a>
									<a href="#">3</a>
									<a href="#">4</a>
									<a href="#">5</a>
									<a href="#">6</a>
									<a href="#">7</a>
									<a href="#">8</a>
									<a href="#">9</a>
									<a href="#">10</a>
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
	//--------------------검색하는 함수
		$(function(){
			$("#searchBtn").click(function() {
				var search = $('#search').val();
				location.href="/notice.mdo?search="+search;
				console.log(search);
			});
		});
	
	</script>
</body>
</html>