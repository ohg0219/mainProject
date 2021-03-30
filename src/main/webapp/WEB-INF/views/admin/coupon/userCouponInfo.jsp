<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<%@include file="../include/css.jsp"%>
<title>thisisthat - 쿠폰 정보</title>
</head>
<body>


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
						 <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            	<strong>Thisisthat 쿠폰</strong>
                            	
                            	<tr>
                            		<td colspan="2">
                            			쿠폰번호 : [${grantVo.coupon_no}]
									</td>
                            	</tr>
                            	<tr>
                            		<td>
                            			쿠폰명 : [${grantVo.coupon_name }]
                            		</td>
                            	</tr>
                            	<tr>
                            		<td>
                            			할인금액 : [${grantVo.coupon_price }]
                            		</td>
                            	</tr>
                            	<tr>
                            		<td>
                            			발급일자 : [<fmt:formatDate value="${grantVo.coupon_first }"  pattern="yyyy-MM-dd "/>]
                            		</td>
                            	</tr>
                            	<tr>
                            		<td>
                            			만료일자 : [<fmt:formatDate value="${grantVo.coupon_last }"  pattern="yyyy-MM-dd "/>]
                            		</td>
                            	</tr>
                         	</table>
                         	<br>
                         	<button class="btn btn-dark" type="button" onclick="location.href='grantCoupon.mdo' ">목록으로</button>
                         </div>
				</div>
			</div>
		</div>
	</div>
<script>
$(function(){//삭제 페이지로 가는 함수
	$("#deleteCoupon").click(function(){
		location.href="/admin/deleteCoupon.mdo?coupon_no="+${article.coupon_no}
	});
	$("#CouponList").click(function(){
		location.href="/admin/getCouponList.mdo"
	});
});
</script>
<%@include file="../include/js.jsp"%>

</body>
</html>