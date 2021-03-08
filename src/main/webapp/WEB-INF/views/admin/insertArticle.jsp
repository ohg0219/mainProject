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
<%@include file="include/css.jsp"%>
<title>Insert title here</title>
</head>
<body>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="include/sideMenu.jsp"%>

		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				<!-- Topbar -->
				<%@include file="include/navbar.jsp"%>
				<div class="container-fluid">
					<form action="insertArticle.mdo" method="post">
						 <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            	<tr>
                            		<td colspan="2">
	                            		<select name="example_length" aria-controls="example" class="">
											<option value="noSelect">---선택---</option>
											<option value="event">이벤트</option>
											<option value="notice">공지사항</option>
											<option value="">100</option>
										</select>
										<button type="button" class="btn-check:checked pull-right" id="searchBtn" >
											<i class="fa fa-pencil fa-fw mr-2 text-dark-400 "></i>
											작성하기
										</button>
										<input type="text" name="title" class="form-control mt-4 mb-2"
											placeholder="제목을 입력해주세요." required
										>
										<div class="form-group">
											<textarea class="form-control" rows="20" name="content"
												placeholder="내용을 입력해주세요" required
											></textarea>
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
				

<%@include file="include/js.jsp"%>
</body>
</html>