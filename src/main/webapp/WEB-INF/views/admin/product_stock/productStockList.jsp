<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>thisisthat - 재고관리</title>

<%@include file="../include/css.jsp"%>
<%@include file="../include/js.jsp"%>
<style type="text/css">
a:link {
	color: red;
	text-decoration: none;
}

a:visited {
	color: blue;
	text-decoration: none;
}

a:hover {
	color: red;
	text-decoration: underline;
}

a {
	color: black;
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

					<select name="searchOption" aria-controls="example" class="">
						<option value="all">ALL</option>
						<option value="board_writer">SHIRT</option>
						<option value="board_title">TOPS</option>
						<option value="board_content">PANTS</option>
						<option value="board_content">JACKETS</option>
						<option value="board_content">TEES</option>
						<option value="board_content">LONGSLEEVETEES</option>
						<option value="board_content">SWEATSHIRTS</option>
					</select>


					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<!--   <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">공지사항</h6>
                        </div>
                        -->
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>상품번호</th>
											<th>카테고리</th>
											<th>상품명</th>
											<th>XS</th>
											<th>S</th>
											<th>M</th>
											<th>L</th>
											<th>XL</th>
										</tr>
									</thead>
									<tbody>
									
										<!-- 모든 변수명은 상황에 따라서 바꿔도 됩니당  ex)aritcle, articleList-->
										
											<c:forEach var="article" items="${prodcutStockList}">
												<tr>
													<td width="45">${article.product_no}</td>
													<td width="100">${article.product_category}</td>
													<td width="300"><a href="getProductStock.mdo?product_no=${article.product_no }" value="${article.product_no }">${article.product_name}</a></td>
													<td width="45">${article.xs }</td>
													<td width="45">${article.s }</td>
													<td width="45">${article.m}</td>
													<td width="45">${article.l }</td>
													<td width="45">${article.xl }</td>
												</tr>
											</c:forEach>
										
										
									</tbody>
								</table>
								<div>
									<br>
									<div align="center">
										<a href="#">1</a> <a href="#">2</a> <a href="#">3</a> <a
											href="#">4</a> <a href="#">5</a> <a href="#">6</a> <a
											href="#">7</a> <a href="#">8</a> <a href="#">9</a> <a
											href="#">10</a>
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
		$(function() {

			//-------------------검색하는 함수end			
			$("#insertArticle").click(function() {
				location.href = "/admin/insertArticle.mdo"
			});
		});
	</script>



</body>
</html>