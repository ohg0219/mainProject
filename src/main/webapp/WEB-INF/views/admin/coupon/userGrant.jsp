<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>thisisthat 쿠폰</title>

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
                    <h1 class="h3 mb-2 text-gray-800">쿠폰 부여</h1>
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
                                    		<th>쿠폰 부여</th>
                                    	</tr>
                                    </thead>
                                   <!--  <tbody>
                                    	<c:forEach var="userIdList" items="${userIdList }">
                          					<tr>
                          						<td width="100">${userIdList.userId }</td>
                          					</tr>
                                    	</c:forEach>
                                    </tbody>
                                     -->
                                </table>
                                
                                    	<form action="userGrant.mdo" method="post">
                                    		<select name="userId">
                                    			<option value="all">all</option>
                                    		<c:forEach var="userIdList" items="${userIdList }">
                                    			<option value="${userIdList.userId }">${userIdList.userId }</option>
                                    		</c:forEach>
                                    		</select>
                                    		
                                    		<select name="coupon">
                                    		<c:forEach items="${selectCoupon }" var="selectCoupon">
                                    			<option value="${selectCoupon.coupon_no}">${selectCoupon.coupon_no},${selectCoupon.coupon_name },${selectCoupon.coupon_price }</option>
                                    		</c:forEach>
                                    		</select>
                                    		
                                    		<button type="submit" class="btn btn-dark">쿠폰부여실행</button>
                                    	</form>
                                    	
                                    	<br>
                                    	<input class="btn btn-dark" type="button" value="목록으로" onclick="history.back(-1);">
                                    	
                                <div>
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
		
			//-------------------검색하는 함수end			
			$("#insertCoupon").click(function(){
				location.href="/admin/insertCoupon.mdo"
			});
		});
	
	</script>
				
	

</body>
</html>