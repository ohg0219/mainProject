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
<title>thisisthat - 게시글</title>
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
					<form action="updateGate.mdo?board_no=${article.board_no }" method="get">
					<input type="hidden" name="board_no" value="${article.board_no }" >
					<input type="hidden" name="board_group" value="${article.board_group }">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<tr>
									<td colspan="2">
										 <h1 class="h3 mb-2 text-gray-800">${article.board_group}</h1>
										<button type="submit" class="btn-check:checked pull-right"
											id="updateArticle">
											
											<i class="fa fa-pencil fa-fw mr-2 text-dark-400 "></i> 수정하기
										</button> 
										<a href="deleteGate.mdo?board_no=${board_no}&board_group=${article.board_group}"><button type="button" class="btn-check:checked pull-right" ><input type="hidden" name="board_group" value="${articel.board_group }"/>삭제하기</button></a>
										<input type="text" value="${article.board_title }" name="board_title"  class="form-control mt-4 mb-2" disabled></input>
										
										<div class="form-group">
											<textarea class="form-control" rows="20" name="board_content" disabled>${article.board_content }</textarea>
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