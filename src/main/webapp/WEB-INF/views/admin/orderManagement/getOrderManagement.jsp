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

<title>thisisthat - ${where }</title>

<%@include file="../include/css.jsp"%>
<%@include file="../include/js.jsp"%>
<style type="text/css">
 a:link { color: red; text-decoration: none;}
 a:visited { color: blue; text-decoration: none;}
 a:hover { color: red; text-decoration: underline;}
 a {color:black;}
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
                    <h1 class="h3 mb-2 text-gray-800">${where}</h1>
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
                                        <tr align="center">
                                            <th>주문 번호</th>
                                            <th>주문일</th>
                                            <th>상품 번호</th>
                                            <th>상품 명</th>
                                            <th>사이즈</th>
                                            <th>수량</th>
                                            <th>현재 상태</th>
                                            <th>송장 번호</th>
                                            <th>취소 유무</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                    	 
                                    <!-- 모든 변수명은 상황에 따라서 바꿔도 됩니당  ex)aritcle, articleList-->
                                    	<c:if test="${not empty getorder}" >
	                                        <c:forEach var="article" items="${getorder}">
		                                        <tr align="center">
			                                        <td>${article.order_no}</td>
			                                        <td><fmt:formatDate value="${article.order_date}" pattern="yyyy-MM-dd"/></td>
			                                        <td>${article.product_no }</td>
			                                        <td>${article.product_name }</td>
			                                        <td>${article.order_size }</td>
			                                        <td>${article.select_count }</td>
			                                        <td>${article.order_state }</td>
			                                        <td>${article.invoice_no }</td>
			                                        <td>${article.order_cancel}</td>
			                                        
			                                    </tr>
	                                        </c:forEach>
                                        

                                        </c:if>
                                        <c:if test="${empty getorder }">
                                        	<tr>
                                        		<td colspan="5" align="center">
                                        		<h1> 받은 주문이 없어요</h1>
                                        		</td>
                                        	</tr>
                                        </c:if>
                                    </tbody>
                                </table>
                                <div>	
                                <form action="noticesearch.mdo?board_group=${article.board_group }" method="get">
                                    <input type="hidden" name="board_group" value="${where}">
									

										                                    		
									<input type="text" name="keyword">

									<button type="submit" class="btn btn-dark" id="searchBtn">
										<i class="fa fa-pencil fa-fw mr-2 text-gray-400"></i>
										검색버튼
									</button>

									<button type="button" class="btn btn-dark"  id="insertArticle">
										<i class="fa fa-pencil fa-fw mr-2 text-gray-400"></i>
										글쓰기
									</button>
                                </form>
									<br>
									
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