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
					<form action="insertCoupon.mdo" method="post">
						 <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            	<tr>
                            		<td colspan="2">
										<button type="submit" class="btn-check:checked pull-right" id="insertCoupon" >
											<i class="fa fa-pencil fa-fw mr-2 text-dark-400 "></i>
											작성하기
										</button>
										<input type="text" name="coupon_name" class="form-control mt-4 mb-2"
											placeholder="쿠폰 명" required>
										<div class="form-group">
											<input type="text" name="coupon_price" class="form-control mt-4 mb-2"
											placeholder="쿠폰 금액" required>
											<input type="date" name="first" class="form-control mt-4 mb-2"
											placeholder="시작일자" required>
											<input type="date" name="last"  class="form-control mt-4 mb-2"
											placeholder="종료 일자" required>
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

</script>
<%@include file="../include/js.jsp"%>

</body>
</html>