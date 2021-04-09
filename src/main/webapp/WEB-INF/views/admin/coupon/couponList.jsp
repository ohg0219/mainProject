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

<title>thisisthat 쿠폰</title>

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
	cursor: pointer;
}
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
                    <h1 class="h3 mb-2 text-gray-800">쿠폰 생성 목록</h1>
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
                                            <th>쿠폰 번호</th>
                                            <th>쿠폰 명</th>
                                            <th>할인 금액(단위 원)</th>
                                            <th>시작 일자</th>
                                            <th>종료 일자</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                    	 
                                    <!-- 모든 변수명은 상황에 따라서 바꿔도 됩니당  ex)aritcle, articleList-->
                                    	<c:if test="${not empty couponList}" >
	                                        <c:forEach var="article" items="${couponList}">
		                                        <tr>
			                                        <td width="45">${article.coupon_no }</td>
			                                        <td width="295"><a href="viewCoupon.mdo?coupon_no=${article.coupon_no }">${article.coupon_name }</a></td>
			                                        <td width="140">${article.coupon_price }</td>
			                                        <td width="115"><fmt:formatDate value="${article.coupon_first }" pattern="yyyy-MM-dd "/></td>
			                                        <td width="45"><fmt:formatDate value="${article.coupon_last }" pattern="yyyy-MM-dd "/></td>
			                                    </tr>
	                                        </c:forEach>
                                        

                                        </c:if>
                                        <c:if test="${empty couponList }">
                                        	<tr>
                                        		<td colspan="5" align="center">
                                        		<h1> 게시글이 없어요</h1>
                                        		</td>
                                        	</tr>
                                        </c:if>
                                    </tbody>
                                </table>
                                <div>	
                                <form action="getCouponList.mdo" method="get">
                                    
									<select name="searchOption" aria-controls="example" class="">
										<option value="coupon_name">쿠폰 명</option>
									</select>
                              		
									<input type="text" name="keyword">

									<button type="submit" class="btn btn-dark" id="searchBtn">
										<i class="fas fa-search fa-sm mr-2 text-gray-400"></i>
										쿠폰 검색 
									</button>

									<button type="button" class="btn btn-dark"  id="insertCoupon">
										<i class="fa fa-pencil fa-fw mr-2 text-gray-400"></i>
										쿠폰 생성
									</button>
                                	</form>
									<br>
									
									
									<div align="center">
										<c:if test="${paging.startPage != 1} ">
											<a href="getCouponList.mdo?nowPage=${paging.startPage - 1}
												&search=${coupon.search}">&lt;</a>
										</c:if>
										<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
											<c:if test="${paging.nowPage == p }">
													<b>${p}</b>
											</c:if>
											<c:if test="${paging.nowPage != p }">
												<a href="getCouponList.mdo?nowPage=${p}
													&search=${coupon.search}">${p}</a>
											</c:if>									
										</c:forEach>
										<c:if test="${paging.endPage != paging.lastPage}">
											<a href="getCouponList.mdo?nowPage=${paging.endPage + 1 }
												&search=${coupon.search}">&gt;</a>
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