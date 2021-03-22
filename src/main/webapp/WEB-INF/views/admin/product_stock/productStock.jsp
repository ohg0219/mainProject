<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<%@include file="../include/css.jsp"%>
<title>thisisthat - 재고관리</title>
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
					<form action="updateGate.mdo?board_no=${article.product_no }"
						method="get">

						<input type="hidden" name="product_no"
							value="${article.product_no }">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<tr>
									<td colspan="5">

										<button type="submit" class="btn-check:checked pull-right"
											id="updateArticle">

											<i class="fa fa-pencil fa-fw mr-2 text-dark-400 "></i> 수정하기
										</button>
								<tr>
									<td colspan="2"><h3>상품번호</h3></td>
									<td colspan="3"><h3>상품명</h3></td>
								</tr>
								<tr>
									<td colspan="2"><input type="text"
										value="${article.product_no }" name="product_category"
										class="form-control mt-4 mb-2" disabled /></td>
									<td colspan="3"><input type="text"
										value="${article.product_name }" name="product_name"
										class="form-control mt-4 mb-2" disabled></input></td>
								</tr>
								<tr>
									<td width="45"><h3>xs</h3></td>
									<td width="45"><h3>s</h3></td>
									<td width="45"><h3>m</h3></td>
									<td width="45"><h3>l</h3></td>
									<td width="45"><h3>xl</h3></td>
								</tr>
								<td><input type="text" value="${article.xs }"
									name="product_xs" class="form-control mt-4 mb-2" width="45" />
								</td>
								<td><input type="text" value="${article.s }"
									name="product_s" class="form-control mt-4 mb-2" /></td>
								<td><input type="text" value="${article.m }"
									name="product_m" class="form-control mt-4 mb-2" /></td>
								<td><input type="text" value="${article.l }"
									name="product_l" class="form-control mt-4 mb-2" /></td>
								<td><input type="text" value="${article.xl }"
									name="product_xl" class="form-control mt-4 mb-2" /></td>
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