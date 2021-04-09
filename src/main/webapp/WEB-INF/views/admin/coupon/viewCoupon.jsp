<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<%@include file="../include/css.jsp"%>
<title>thisisthat - 쿠폰 등록</title>
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
					<form action="updateCoupon.mdo" method="post">
					<input type="hidden" name="coupon_no" value="${article.coupon_no}">
						 <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            	<tr>
									<button type="submit" class="btn-check:checked pull-right" >
										<i class="fa fa-pencil fa-fw mr-2 text-dark-400 "></i>
										수정하기
									</button>
									<button type="button" class="btn-check:checked pull-right" id="deleteCoupon" >
										<i class="fa fa-pencil fa-fw mr-2 text-dark-400 "></i>
										삭제하기
									</button>
									<button type="button" class="btn-check:checked pull-right" id="CouponList" >
										<i class="fa fa-pencil fa-fw mr-2 text-dark-400 "></i>
										목록으로
									</button>
                            		<td colspan="2">
										<div class="form-group">
										<tr>
											<td>쿠폰 명</td>
											<td>${article.coupon_name }</td>
										</tr>
										<tr>
											<td>쿠폰 금액</td>
											<td><fmt:formatNumber maxFractionDigits="3" value="${article.coupon_price }"/> 원</td>
										</tr>
										<tr>
											<td>시작 일자</td>
											<td><fmt:formatDate pattern="yyyy-MM-dd" value="${article.coupon_first}"/></td>
										</tr>
										<tr>
											<td>종료 일자</td>
											<td><fmt:formatDate pattern="yyyy-MM-dd" value="${article.coupon_last}"/></td>
										</tr>
										</div>
									</td>
                            	</tr>
                         	</table>
                         </div>
					</form>
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