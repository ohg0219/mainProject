<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
										</botton>
										<button type="button" class="btn-check:checked pull-right" id="CouponList" >
											<i class="fa fa-pencil fa-fw mr-2 text-dark-400 "></i>
											목록으로
										</botton>
                            		<td colspan="2">
										<div class="form-group">
										<input type="text" value="${article.coupon_name }" class="form-control mt-4 mb-2"
											placeholder="쿠폰 명" disabled>
											<input type="text" value="${article.coupon_price }" class="form-control mt-4 mb-2"
											placeholder="쿠폰 금액" disabled>
											<input type="text" value="${article.coupon_first}" class="form-control mt-4 mb-2"
											placeholder="시작일자" disabled>
											<input type="text" value="${article.coupon_last}" class="form-control mt-4 mb-2"
											placeholder="종료 일자" disabled>
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