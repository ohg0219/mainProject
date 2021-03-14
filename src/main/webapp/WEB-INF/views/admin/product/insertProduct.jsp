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

<title>thisisthat</title>

<%@include file="../include/css.jsp"%>
<%@include file="../include/js.jsp"%>
<!-- Custom fonts for this template-->
    <link href="/resources/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/admin/css/sb-admin-2.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style type="text/css">
 a:link { color: red; text-decoration: none;}
 a:visited { color: blue; text-decoration: none;}
 a:hover { color: red; text-decoration: underline;}
 a {color:black;}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$("#insert").on("click",function(){
			if($("input[name=categoryName]").val().trim()==''){
				$("input[name=categoryName]").focus();
				alert("카테고리명을 입력하세요");
				return false;
			}
		});
	});
	$(document).ready(function (e){
		$("#mainUploadFile").change(function(e){
			//div 내용 비워주기
			$('#main-preview').empty();
			var files = e.target.files;
			var arr =Array.prototype.slice.call(files);
			//업로드 가능 파일인지 체크
			for(var i=0;i<files.length;i++){
				if(!checkExtension(files[i].name,files[i].size)){
					return false;
				}
			}
			preview(arr);
	    });//file change
	    function checkExtension(fileName,fileSize){
	      var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	      var maxSize = 20971520;  //20MB
	      if(fileSize >= maxSize){
	        alert('파일 사이즈 초과');
	        $("mainUploadFile").val("");  //파일 초기화
	        return false;
	      }
	      if(regex.test(fileName)){
	        alert('업로드 불가능한 파일이 있습니다.');
	        $("mainUploadFile").val("");  //파일 초기화
	        return false;
	      }
	      return true;
	    }
	    function preview(arr){
	      arr.forEach(function(f){
	        //파일명이 길면 파일명...으로 처리
	        var fileName = f.name;
	        if(fileName.length > 10){
	          fileName = fileName.substring(0,7)+"...";
	        }
	        //div에 이미지 추가
	        var str = '<div style="display: inline-flex; padding: 10px;"><li>';
	        str += '<span>'+fileName+'</span><br>';
	        //이미지 파일 미리보기
	        if(f.type.match('image.*')){
	          var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
	          reader.onload = function (e) { //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
	            str += '<img src="'+e.target.result+'" title="'+f.name+'" width=100 height=100 />';
	            str += '</li></div>';
	            $(str).appendTo('#main-preview');
	          } 
	          reader.readAsDataURL(f);
	        }
	      });//arr.forEach
	    }
	    
	    
	});
	
	$(document).ready(function (e){
		$("#subUploadFile").change(function(e){
			//div 내용 비워주기
			$('#sub-preview').empty();
			var files = e.target.files;
			var arr =Array.prototype.slice.call(files);
			//업로드 가능 파일인지 체크
			for(var i=0;i<files.length;i++){
				if(!checkExtension(files[i].name,files[i].size)){
					return false;
				}
			}
			preview(arr);
	    });//file change
	    function checkExtension(fileName,fileSize){
	      var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	      var maxSize = 20971520;  //20MB
	      if(fileSize >= maxSize){
	        alert('파일 사이즈 초과');
	        $("subUploadFile").val("");  //파일 초기화
	        return false;
	      }
	      if(regex.test(fileName)){
	        alert('업로드 불가능한 파일이 있습니다.');
	        $("subUploadFile").val("");  //파일 초기화
	        return false;
	      }
	      return true;
	    }
	    function preview(arr){
	      arr.forEach(function(f){
	        //파일명이 길면 파일명...으로 처리
	        var fileName = f.name;
	        if(fileName.length > 10){
	          fileName = fileName.substring(0,7)+"...";
	        }
	        //div에 이미지 추가
	        var str = '<div style="display: inline-flex; padding: 10px;"><li>';
	        str += '<span>'+fileName+'</span><br>';
	        //이미지 파일 미리보기
	        if(f.type.match('image.*')){
	          var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
	          reader.onload = function (e) { //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
	            str += '<img src="'+e.target.result+'" title="'+f.name+'" width=100 height=100 />';
	            str += '</li></div>';
	            $(str).appendTo('#sub-preview');
	          } 
	          reader.readAsDataURL(f);
	        }
	      });//arr.forEach
	    }
	});
	
	
</script>
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
                    <h1 class="h3 mb-2 text-gray-800">상품등록</h1>
                    <p class="mb-4"><!-- 쓸 말 있으면 쓰는 곳 --></p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                       
                        <div class="card-body">
                            <form action="insertProduct.mdo" method="post" enctype="multipart/form-data">
							 	<div class="table-responsive">
	                           		<table class="table table-bordered" id="dataTable">
                    					<tr>
                    						<td>카테고리</td>
                    						<td>
                    							<select>
                    								<option>----카테고리 선택----</option>
	                    							<c:forEach items="${categoryList }" var="category">
	                    								<option>${category.categoryName }</option>
	                    							</c:forEach>
                    							</select>
                    						</td>
                    					</tr>
                    					<tr>
                    						<td width="150px">상품명</td>
                    						<td><input style="width: 100%" type="text" name="productName"></td>
                    					</tr>
                    					<tr>
                    						<td>소비자가</td>
                    						<td><input type="text" name="productPrice"></td>
                    					</tr>
                    					<tr>
                    						<td>소재정보</td>
                    						<td><textarea style="width: 100%"></textarea></td>
                    					</tr>
                    					<tr>
                    						<td>원산지</td>
                    						<td><input style="width: 100%" type="text" name="materialInfo"></td>
                    					</tr>
                    					<tr>
                    						<td>상품설명</td>
                    						<td><textarea style="width: 100%"></textarea></td>
                    					</tr>
                    					<tr>
                    						<td>적립포인트</td>
                    						<td>
												
											</td>
                    					</tr>
                    					<tr>
                    						<td colspan="2">
    	                						<p>메인이미지</p>
                    							<div class="col-lg-12">
                    								<input type="file" name="mainUploadFile" id="mainUploadFile">
                    							</div>
                    							<div id="main-preview">
                    							
                    							</div>
                    						</td>
                    					</tr>
                    					<tr>
                    						<td colspan="2">
    	                						<p>상세이미지</p>
                    							<div class="col-lg-12">
                    								<input type="file" name="subUploadFile" id="subUploadFile" multiple>
                    							</div>
                    							<div id="sub-preview">
                    							
                    							</div>
                    						</td>
                    					</tr>
                    					<tr>
                    						<td colspan="2" align="center">
                    							<input value="목록" type="button" class="btn btn-dark" onclick="location.href='/categoryList.mdo'">
                    							<input id="insert" type="submit" class="btn btn-dark" value="등록">
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

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">로그아웃하시겠습니까?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.mdo">Logout</a>
                </div>
            </div>
        </div>
    </div>

   


</body>
</html>