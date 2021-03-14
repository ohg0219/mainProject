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

    <title>This is that</title>

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
                    	상품목록
                    </h1>
                    	<div>
                    		<span>카테고리 선택 : </span>
	                    	<select>
	                    		<option>전체</option>
	                    		<c:forEach items="${categoryList }" var="category">
	                    			<option>
	                    				${category.categoryName }
	                    			</option>
	                    		</c:forEach>
	                    	</select>
                    	</div>

                    <!-- Content Row -->
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
                                            <th>상품번호</th>
                                            <th>카테고리</th>
                                            <th>상품명</th>
                                            <th>메인이미지</th>
                                            <th>소비자가</th>
                                            <th>총재고</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <!-- 모든 변수명은 상황에 따라서 바꿔도 됩니당  ex)aritcle, articleList-->
                                   	<c:if test="${productList ne null }">
	                                    <c:forEach items="${productList}" var="product">
	                                   	    <tr>
		                                        <td>${product.product_no }</td>
		                                        <td>${product.product_category }</td>
		                                        <td><a href="/admin/getProduct.mdo?productNo=${product.product_no }">${product.product_name }</a></td>
		                                        <td align="center"><img style="width: 70px" alt="" src="${product.upload_path }"> </td>
		                                        <td align="right">${product.product_price }</td>
		                                        <td align="right">${product.product_stock_total }</td>
		                                    </tr>
	                                    </c:forEach>
	                                </c:if>
	                                <c:if test="${productList eq null }">
	                                       	<tr>
	                                       		<td colspan="6" align="center">
	                                       		<h3> 상품이 없어요</h3>
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
										검색
									</button>
									<button type="button" class="btn btn-dark" onclick="location.href='/admin/insertProduct.mdo'">
										<i class="fa fa-pencil fa-fw mr-2 text-gray-400"></i>
										등록
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

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">로그아웃하시겠습니까?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.mdo">Logout</a>
                </div>
            </div>
        </div>
    </div>

 
</body>
</html>