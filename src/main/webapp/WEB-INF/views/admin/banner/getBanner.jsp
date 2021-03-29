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
<title>thisisthat - 배너 관리</title>
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
 a:visited { color: white; text-decoration: none;}
 a {color:black;}
 .table td{
 	vertical-align: middle;
 }
 .table th{
 	text-align: center;
 }
</style>
</head>
<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <%@include file="../include/sideMenu.jsp" %>

        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
               <%@include file="../include/navbar.jsp" %>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">
                    	배너 관리
                    </h1>
                    	<div>
                    	
	                    	<a class="btn btn-dark" href="/admin/insertBanner.mdo">배너 추가</a>
                    	</div> 

                    <!-- Content Row -->
               			<div class="card shadow mb-4">
                       <!--   <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">공지사항</h6>
                        </div>
                        -->
                        <div class="card-body">
                            <div class="table-responsive">
                            <form action="/admin/bannerOrder.mdo">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>배너이름</th>
                                            <th>이미지</th>
                                            <th>재생순서</th>
                                            <th>비고</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                   	<c:if test="${not empty bannerList}">
	                                    <c:forEach items="${bannerList}" var="banner">
	                                   	    <tr>
		                                        <td style="text-transform: uppercase;">${banner.bannerName }
		                                        <input type="hidden" value=${banner.bannerUri } name="bannerUri"></td>
		                                        <td align="center"><img style="width: 70px" alt="" src="${banner.bannerUri }"> </td>
		                                        <td><input type="text" name="bannerOrder" value="${banner.bannerOrder}"></td>
		                                       <td><a href="/admin/deleteBanner.mdo?bannerOrder=${banner.bannerOrder}" class="btn btn-dark">삭제</a></td>
		                                        
		                                    </tr>
	                                    </c:forEach>
	                                </c:if>
	                                <c:if test="${empty bannerList}">
	                                       	<tr>
	                                       		<td colspan="4" align="center">
	                                       		<h3>등록된 배너가 없습니다.</h3>
	                                       		</td>
	                                       	</tr>
	                                </c:if>
	                                	<tr>
	                                	
	                                	<td colspan="4" align="right"><input type="submit" class="btn btn-dark" value="순서바꾸기">
	                                	</td>
	                                	</tr>
                                    </tbody>
                                </table>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

 

    
 
</body>
<script type="text/javascript">
	var msg = '${msg}';
	if(msg == 'fail'){
		alert('재생 순서가 같을 수 없습니다.')
	}
	if(msg == 'success'){
		alert('성공')
	}
</script>
</html>