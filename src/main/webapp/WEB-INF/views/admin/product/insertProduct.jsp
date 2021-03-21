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

<title>thisisthat - 상품 등록</title>

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
 #size_used{
 	text-align: center;
 }
 .sizeGuide{
 	text-align: center;
 }
.sizeInfo1,.sizeInfo2,.sizeInfo3,.sizeInfo4 {
	width: 190px;
 }
 .bottomSize{
 	display: none;
 }
 .in{
 	background-color: white;
 	width: 80px;
 }
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$("#insert").on("click",function(){
			if($("#category").val()=='----카테고리 선택----'){
				alert("카테고리를 선택하세요");
				$("#category").focus();
				return false;
			}
			if($("#productName").val()==''){
				alert("상품명을 입력하세요");
				$("#productName").focus();
				return false;
			}
			var priceType = /^[1-9]{1}[0-9]*$/g;
			if(!priceType.test($("#productPrice").val())){
				alert("소비자가는 숫자만 입력가능합니다.");
				$("#productPrice").focus();
				return false;
			}
			if($("#materialInfo").val()==''){
				alert("소재정보를 입력하세요");
				$("#materialInfo").focus();
				return false;
			}
			if($("#origin").val()==''){
				alert("원산지를 입력하세요");
				$("#origin").focus();
				return false;
			}
			if(!$("#mainUploadFile").val()){
				alert("메인 이미지를 등록해주세요.");
				return false;
			}
			if(!$("#subUploadFile").val()){
				alert("상세 이미지를 등록해주세요.");
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
	            str += '<img src="'+e.target.result+'" title="'+f.name+'" width=100 />';
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
                    <h1 class="h3 mb-2 text-gray-800">상품 등록</h1>
                    <p class="mb-4"><!-- 쓸 말 있으면 쓰는 곳 --></p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                       
                        <div class="card-body">
                            <form action="insertProduct.mdo" method="post" enctype="multipart/form-data">
							 	<div class="table-responsive">
	                           		<table class="table table-bordered" id="dataTable">
                    					<tr>
                    						<td>카테고리</td>
                    						<td colspan="6">
                    							<select id="category" name="product_category">
                    								<option>----카테고리 선택----</option>
	                    							<c:forEach items="${categoryList }" var="category">
	                    								<option>${category.categoryName }</option>
	                    							</c:forEach>
                    							</select>
                    						</td>
                    					</tr>
                    					<tr>
                    						<td width="150px">상품명</td>
                    						<td colspan="6"><input style="width: 100%" type="text" id="productName" name="product_name"></td>
                    					</tr>
                    					<tr>
                    						<td>소비자가</td>
                    						<td colspan="6"><input type="text" id="productPrice" name="product_price"></td>
                    					</tr>
                    					<tr>
                    						<td>소재정보</td>
                    						<td colspan="6"><textarea style="width: 100%" id="materialInfo" name="material_info"></textarea></td>
                    					</tr>
                    					<tr>
                    						<td>원산지</td>
                    						<td colspan="6"><input style="width: 100%" type="text" id="origin" name="origin"></td>
                    					</tr>
                    					<tr>
                    						<td>상품설명</td>
                    						<td colspan="6"><textarea style="width: 100%" id="productInfo" name="product_info"></textarea></td>
                    					</tr>
                    					<tr>
                    						<td>적립율</td>
                    						<td colspan="6">
												<input type="number" value="product_point">
											</td>
                    					</tr>
                    					<tr>
                    						<td rowspan="2" colspan="2" style="vertical-align: middle; text-align: center;">사이즈 사용유무</td>
                    						<td align="center">XS</td>
                    						<td align="center">S</td>
                    						<td align="center">M</td>
                    						<td align="center">L</td>
                    						<td align="center">XL</td>
                    					</tr>
                    					<tr id="size_used">
                    						<td>
                    							<select id="xs" name="xs_used">
                    								<option value="1">사용</option>
                    								<option value="0">미사용</option>
                    							</select>
                    						</td>
                    						<td>
                    							<select id="s" name="s_used">
                    								<option value="1">사용</option>
                    								<option value="0">미사용</option>
                    							</select>
                    						</td>
                    						<td>
                    							<select id="m" name="m_used">
                    								<option value="1">사용</option>
                    								<option value="0">미사용</option>
                    							</select>
                    						</td>
                    						<td>
                    							<select id="l" name="l_used">
                    								<option value="1">사용</option>
                    								<option value="0">미사용</option>
                    							</select>
                    						</td>
                    						<td>
                    							<select id="xl" name="xl_used">
                    								<option value="1">사용</option>
                    								<option value="0">미사용</option>
                    							</select>
                    						</td>
                    						<script type="text/javascript">
                    							$("#xs").change(function(){
                    								if($("#xs option:selected").val() == 1){$(".xs").attr("readonly",false);$(".xs").css("background-color","white");
                    								}else{$(".xs").attr("readonly",true); $(".xs").val(null); $(".xs").css("background-color","red");
                    								}
                    							});
                    							$("#s").change(function(){
                    								if($("#s option:selected").val() == 1){$(".s").attr("readonly",false);$(".s").css("background-color","white");
                    								}else{$(".s").attr("readonly",true); $(".s").val(null);$(".s").css("background-color","red");}
                    							});
                    							$("#m").change(function(){
                    								if($("#m option:selected").val() == 1){$(".m").attr("readonly",false);$(".m").css("background-color","white");
                    								}else{$(".m").attr("readonly",true); $(".m").val(null);$(".m").css("background-color","red");}
                    							});
                    							$("#l").change(function(){
                    								if($("#l option:selected").val() == 1){$(".l").attr("readonly",false);$(".l").css("background-color","white");
                    								}else{$(".l").attr("readonly",true); $(".l").val(null);$(".l").css("background-color","red");}
                    							});
                    							$("#xl").change(function(){
                    								if($("#xl option:selected").val() == 1){$(".xl").attr("readonly",false);$(".xl").css("background-color","white");
                    								}else{$(".xl").attr("readonly",true); $(".xl").val(null);$(".xl").css("background-color","red");}
                    							});
                    						</script>
                    					</tr>
                    					<tr>
                    						<td align="center" colspan="7">사이즈 가이드
                    							<select id="guideSelector" name="guideSelector">
                    								<option value="top">상의류</option>
                    								<option value="bottom">하의류</option>
                    							</select>
                    							<script type="text/javascript">
                    								$("#guideSelector").change(function(){
                    									var con= $("#guideSelector option:selected").val();
														if(con == 'top'){
															$("#sizeGuideTitle").text("상의류");
															$("#sizeInfo1").text("LENGTH(총길이)");
															$("#sizeInfo2").text("CHEST(가슴)");
															$("#sizeInfo3").text("ARM(팔)");
															$("#sizeInfo4").text("SHOULDER(어깨)");
														}else if(con == 'bottom'){
															$("#sizeGuideTitle").text("하의류");
															$("#sizeInfo1").text("LENGTH(총길이)");
															$("#sizeInfo2").text("WAIST(허리)");
															$("#sizeInfo3").text("THIGH(허벅지)");
															$("#sizeInfo4").text("HEM(밑단)");
														}
                    								});
                    							</script>
                    						</td>
                    					</tr>
                    					<tr class="sizeGuide">
                    						<td id="sizeGuideTitle"rowspan="4" style="vertical-align: middle;">상의류</td>
                    						<td id="sizeInfo1">LENGTH(총길이)</td>
                    						<td><input class="xs in" type="number" step="0.01" name="size1" size="5"></td>
                    						<td><input class="s in"  type="number" step="0.01" name="size1" size="5"></td>
                    						<td><input class="m in"  type="number" step="0.01" name="size1" size="5"></td>
                    						<td><input class="l in"  type="number" step="0.01" name="size1" size="5"></td>
                    						<td><input class="xl in" type="number" step="0.01" name="size1" size="5"></td>
                    					</tr>
                    					<tr class="sizeGuide">
                    						<td id="sizeInfo2">CHEST(가슴)</td>
                    						<td><input class="xs in"  type="number" step="0.01" name="size2" size="5"></td>
                    						<td><input class="s in" type="number" step="0.01" name="size2" size="5"></td>
                    						<td><input class="m in"  type="number" step="0.01" name="size2" size="5"></td>
                    						<td><input class="l in"  type="number" step="0.01" name="size2" size="5"></td>
                    						<td><input class="xl in"  type="number" step="0.01" name="size2" size="5"></td>
                    					</tr>
                    					<tr class="sizeGuide">
                    						<td id="sizeInfo3">ARM(팔)</td>
                    						<td><input class="xs in"  type="number" step="0.01" name="size3" size="5"></td>
                    						<td><input class="s in"  type="number" step="0.01" name="size3" size="5"></td>
                    						<td><input class="m in"  type="number" step="0.01" name="size3" size="5"></td>
                    						<td><input class="l in"  type="number" step="0.01" name="size3" size="5"></td>
                    						<td><input class="xl in" type="number" step="0.01" name="size3" size="5"></td>
                    					</tr>
                    					<tr class="sizeGuide">
                    						<td id="sizeInfo4">SHOULDER(어깨)</td>
                    						<td><input class="xs in" type="number" step="0.01" name="size4" size="5"></td>
                    						<td><input class="s in" type="number" step="0.01" name="size4" size="5"></td>
                    						<td><input class="m in"  type="number" step="0.01" name="size4" size="5"></td>
                    						<td><input class="l in" type="number" step="0.01" name="size4" size="5"></td>
                    						<td><input class="xl in"  type="number" step="0.01" name="size4" size="5"></td>
                    					</tr>
                    					<tr>
                    						<td colspan="7">
    	                						<p>메인이미지</p>
                    							<div class="col-lg-12">
                    								<input type="file" name="mainUploadFile" id="mainUploadFile">
                    							</div>
                    							<div id="main-preview">
                    							
                    							</div>
                    						</td>
                    					</tr>
                    					<tr>
                    						<td colspan="7">
    	                						<p>상세이미지</p>
                    							<div class="col-lg-12">
                    								<input type="file" name="subUploadFile" id="subUploadFile" multiple>
                    							</div>
                    							<div id="sub-preview">
                    							
                    							</div>
                    						</td>
                    					</tr>
                    					<tr>
                    						<td colspan="7" align="center">
                    							<input value="목록" type="button" class="btn btn-dark" onclick="location.href='/admin/productList.mdo'">
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