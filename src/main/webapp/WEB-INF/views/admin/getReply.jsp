<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
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

<title>thisisthat - Q&A</title>

<%@include file="include/css.jsp"%>
<%@include file="include/js.jsp"%>
<!-- Custom fonts for this template-->
    <link href="/resources/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/admin/css/sb-admin-2.min.css" rel="stylesheet">
<style type="text/css">
textarea {
	resize: none;
}
</style>

<style type="text/css">
.thumbnail-wrappper { width: 25%; } img { max-width: 100%; height: auto; }


</style>
</head>
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

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800"></h1>
                    <p class="mb-4"><!-- 쓸 말 있으면 쓰는 곳 --></p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                       <!--   <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">공지사항</h6>
                        </div>
                        -->
                        <div class="card-body">
                            <form action="/admin/updateReply.mdo" method="gete">
                            <input type="hidden" name="boardNo" value="${reply.boardNo}"> 
							 	<div class="table-responsive">
	                           		<table class="table table-bordered" id="dataTable" >
	                           			<tr>
	                           				<td colspan="2">
	                           					<input type="button" id="updateBt" class="btn btn-dark" value="수정하기">
	                           					<input value="확인" id="submit" type="submit" class="btn btn-dark">
	                           				</td> 
	                           			</tr>
                    					<tr>
                    						<td width="200" align="right">제목</td>
                    						<td><input type="text"  required="required" class="form-control" name="boardTitle" size="100%"
                    						id="boardTitle" value="${reply.boardTitle }" readonly="readonly"></td>
                    					</tr>
                    					<tr>
                    						<td align="center" colspan="500"><strong>내용</strong></td>
                    					</tr>
                    					<tr>
                    						<td colspan="2"><textarea name="boardContent" cols="193" rows="30" required="required"
                    						id = "boardContent" readonly="readonly">${reply.boardContent }</textarea></td>
                    					
                    					</tr>
                    					
                    					<tr>
                    						<td colspan="2" align="center">
	                    						<input value="목록" type="button" class="btn btn-dark" onclick="location.href='/admin/answerBoardList.mdo'">
	                    						<input value="삭제" id="deleteBt" type="button" class="btn btn-dark" >	                    						
                    						</td>
                    					</tr>
                    				</table>
                    				
                    			</div>
                    		</form>
                        </div>
                    </div>
				</div>
			</div>
		</div>
	</div>
	<!-- End of Page Wrapper -->
	
	<script type="text/javascript">
	$("#submit").hide();
	$(function(){
		$("#updateBt").click(function(){
			
			if(document.getElementById('updateBt').value == '수정하기'){
				document.getElementById('updateBt').value = "수정취소";
				document.getElementById('boardContent').readOnly = false;
				document.getElementById('boardTitle').readOnly = false;
				$("#submit").show();
			}else if(document.getElementById('updateBt').value == "수정취소"){
				var title = '${reply.boardTitle}';
				var content = '${reply.boardContent}';
				document.getElementById('updateBt').value = "수정하기";
				document.getElementById('boardContent').readOnly = true;
				document.getElementById('boardTitle').readOnly = true;
				document.getElementById('boardContent').value = content;
				document.getElementById('boardTitle').value = title;
				$("#submit").hide();
			}

		});
		$("#deleteBt").click(function(){
			if(confirm('정말로 삭제할까요?')){
				location.href="/admin/deleteReply.mdo?boardNo="+'${reply.boardNo}';
			}
		});
	});
	</script>
	
    <!-- Bootstrap core JavaScript-->
    <script src="/resources/admin/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/admin/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="/resources/admin/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/resources/admin/js/demo/chart-area-demo.js"></script>
    <script src="/resources/admin/js/demo/chart-pie-demo.js"></script>
	

</body>
</html>