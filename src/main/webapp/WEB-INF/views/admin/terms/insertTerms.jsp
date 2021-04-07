<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>thisisthat - Q&A</title>

<%@include file="../include/css.jsp"%>
<%@include file="../include/js.jsp"%>
<!-- Custom fonts for this template-->
    <link href="/resources/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/admin/css/sb-admin-2.min.css" rel="stylesheet">
<style type="text/css">
 a:link { color: red; text-decoration: none;}
 a:visited { color: blue; text-decoration: none;}
 a:hover { color: red; text-decoration: underline;}
 a {color:black;}
</style>
<style type="text/css">
.thumbnail-wrappper { width: 25%; } img { max-width: 100%; height: auto; }


</style>
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
                    <h1 class="h3 mb-2 text-gray-800"></h1>
                    <p class="mb-4"><c:if test="${state == 'information'}">개인정보 수집 및 이용</c:if>
                    <c:if test="${state == 'utilization'}">이용 약관</c:if>
                    </p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                       <!--   <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">공지사항</h6>
                        </div>
                        -->
                        <div class="card-body">
                            <form action="/admin/insertTerms.mdo" method="post">
                            	<input type="hidden" name="state" value="${state}">
							 	<div class="table-responsive">
	                           		<table class="table table-bordered" id="dataTable" >
                    					
                    					
                    					<tr>
                    						<td align="center" colspan="500"><strong>내용</strong></td>
                    					</tr>
                    					<tr>
                    						<td colspan="2" height="300"><textarea name="content" rows="30px" style="resize: none; width: 100%;" required="required"></textarea></td>
                    					
                    					</tr>
                    					<tr>
                    						<td align="center" colspan="500"><strong>수정사항</strong></td>
                    					</tr>
                    					<tr>
                    						<td colspan="2" height="300"><textarea name="corrections" rows="10px" style="resize: none; width: 100%;" required="required"></textarea></td>
                    					
                    					</tr>
                    					
                    					
                    					<tr>
                    						<td colspan="2" align="center">
                    							
	                    						<input value="작성" type="submit" class="btn btn-dark" >
	                    						<input value="목록" type="button" class="btn btn-dark" onclick="location.href='/admin/getTermsList.mdo'">
	                    				
                    						</td>
                    					</tr>
                    				</table>
                    				
                    			</div>
                    		</form>
                        </div>
                    </div>
				</div>
			</div>
		</div>
	</div>
	<!-- End of Page Wrapper -->
	<script type="text/javascript">
		var msg = '${msg}';
		console.log(msg);
		if(msg === 'msg'){
			
			alert('답글이 이미 있습니다.');
		}
		
		
	</script>
    <!-- Bootstrap core JavaScript-->
    <script src="/resources/admin/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/admin/js/sb-admin-2.min.js"></script>


    <!-- Page level custom scripts -->
    <script src="/resources/admin/js/demo/chart-area-demo.js"></script>
    <script src="/resources/admin/js/demo/chart-pie-demo.js"></script>
	

</body>
</html>