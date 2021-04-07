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
                    <h1 class="h3 mb-2 text-gray-800">쿠폰 부여 현황</h1>
                    <p class="mb-4"><!-- 쓸 말 있으면 쓰는 곳 --></p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                       <!--   <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">공지사항</h6>
                        </div>
                        -->
                        <div class="card-body">
                            <div class="table-responsive">
                                    <form action="userGrant.mdo" method="get">
                                    	<button type="submit" class="btn btn-dark" id="userGrant">
                                    	회원 쿠폰 부여
                                    	</button>
                                    </form>
                                    <br>
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <strong>회원쿠폰 지급 목록</strong>
                                    <thead>
                                        <tr>
                                            <th>사용자 아이디</th>
                                            <th>쿠폰넘버</th>
                                            <th>쿠폰 이름</th>
                                            <th>쿠폰 적용 금액</th>
                                            <th>발급일</th>
                                            <th>만료일</th>
                                            <th>사용 유무</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                    	 
                                    <!-- 모든 변수명은 상황에 따라서 바꿔도 됩니당  ex)aritcle, articleList-->
                                    	<c:if test="${not empty userCouponList}" >
	                                        <c:forEach var="couponlist" items="${userCouponList}">
		                                        <tr>
			                                        <td width="100"><a href="couponUserList.mdo?user_id=${couponlist.user_id }">${couponlist.user_id }</a></td>
			                                        <td width="80">${couponlist.coupon_no }</td>
			                                        <td width="140"><a href="grantCouponView.mdo?coupon_no=${couponlist.coupon_no }">${couponlist.coupon_name }</a></td>
			                                        <td width="115">${couponlist.coupon_price }</td>
			                                        <td width="45"><fmt:formatDate value="${couponlist.coupon_first }" pattern="yyyy-MM-dd "/></td>
			                                        <td width="45"><fmt:formatDate value="${couponlist.coupon_last }" pattern="yyyy-MM-dd "/></td>
			                                        <td width="45">${couponlist.used }</td>
			                                    </tr>
	                                        </c:forEach>
                                        

                                        </c:if>
                                        <c:if test="${empty userCouponList }">
                                        	<tr>
                                        		<td colspan="5" align="center">
                                        		<h1> 내역이 없습니다. </h1>
                                        		</td>
                                        	</tr>
                                        </c:if>
                                    </tbody>
                                    
                                </table>
                                
                                	<form action="userCouponSearch.mdo" method="get">
										<table class="noticeTable">
											<tr>
												<td align="right">
													<select name="searchOption">
														<option value="user_id">회원ID
														<option value="coupon_name">쿠폰이름
													</select>
													<input type="text" name="keyword"/>
													<input type="submit" value="검색"/>
											</td>
										</tr>
									</table>
									</form>
                                    <br>
                                    
                    
                                    <button class="btn btn-dark" type="button" onclick="location.href='/admin/main.mdo' ">메인으로</button>
                    				            
                                <div>	
                                
								</div>
                                </div>
                            </div>
                        </div>
                    </div>

                
				</div>
			</div>
		</div>
		
		    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
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