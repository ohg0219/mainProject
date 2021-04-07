<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../admin/include/css.jsp"%>
<%@include file="../admin/include/js.jsp"%>
</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->

		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				<!-- Topbar -->
				<div class="container-fluid">

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-body">
							<div class="container-fluid">
								<div class="text-center">
									<c:if test="${requestScope['javax.servlet.error.status_code'] == 400 }">
										<div class="error mx-auto" data-text="400">400</div>
										<p class="lead text-gray-800 mb-5">잘못 된 요청입니다.</p>   
									</c:if>	
									
									<c:if test="${requestScope['javax.servlet.error.status_code'] == 404}">
										<div class="error mx-auto" data-text="404">404</div>
										<p class="lead text-gray-800 mb-5">요청하신 페이지를 찾을 수 없습니다.</p>     
									</c:if>
									
									<c:if test="${requestScope['javax.servlet.error.status_code'] == 405}">
										<div class="error mx-auto" data-text="404">404</div>
										<p class="lead text-gray-800 mb-5">잘못 된 요청입니다.</p>    
									</c:if>
									
									<c:if test="${requestScope['javax.servlet.error.status_code'] == 500}">
										<div class="error mx-auto" data-text="500">500</div>
										<p class="lead text-gray-800 mb-5">서버에 오류가 발생하여 요청을 수행할 수 없습니다.</p>
									</c:if>
									
									<c:if test="${requestScope['javax.servlet.error.status_code'] == 503}">
										<div class="error mx-auto" data-text="503">503</div>
										<p class="lead text-gray-800 mb-5">서비스를 사용할 수 없습니다.</p>
									</c:if>
									<!--  p class="text-gray-500 mb-0">It looks like you found a
										glitch in the matrix...</p-->
									<a onclick="history.back()" style="cursor: pointer;">&larr; 뒤로가기</a>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>