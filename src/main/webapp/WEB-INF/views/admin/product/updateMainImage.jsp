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

<title>thisisthat - 상품 메인이미지 수정</title>

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
$(document).ready(function (e){
	$("#update").on("click",function(){
		if(!$("#mainUploadFile").val()){
			alert("메인 이미지를 등록해주세요.");
			return false;
		}
	});
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
            str += '<img src="'+e.target.result+'" title="'+f.name+'" width=100 />';
            str += '</li></div>';
            $(str).appendTo('#main-preview');
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
                    <h1 class="h3 mb-2 text-gray-800">상품 메인이미지 수정</h1>
                    <p class="mb-4"><!-- 쓸 말 있으면 쓰는 곳 --></p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                       
                        <div class="card-body">
                            <form action="updateMainImage.mdo" method="post" enctype="multipart/form-data">
							 	<div class="table-responsive">
							 		<input type="hidden" name="product_no" value="${productInfo.product_no }">
	                           		<table class="table table-bordered" id="dataTable">
                    					<tr>
                    						<td>카테고리</td>
                    						<td colspan="6">
                    							${productInfo.product_category }
                    						</td>
                    					</tr>
                    					<tr>
                    						<td width="150px">상품명</td>
                    						<td colspan="6">
                    							${productInfo.product_name }
                    						</td>
                    					</tr>
                    					<tr>
                    						<td>소비자가</td>
                    						<td colspan="6">
                    							<fmt:formatNumber maxFractionDigits="3" value="${productInfo.product_price }"></fmt:formatNumber>원
                    						</td>
                    					</tr>
                    					<tr>
                    						<td>소재정보</td>
                    						<td colspan="6">
                    							${productInfo.material_info }
                    						</td>
                    					</tr>
                    					<tr>
                    						<td>원산지</td>
                    						<td colspan="6">
                    							${productInfo.origin }
                    						</td>
                    					</tr>
                    					<tr>
                    						<td>상품설명</td>
                    						<td colspan="6">
                    							${productInfo.product_info }
                    						</td>
                    					</tr>
                    					<tr>
                    						<td>적립율</td>
                    						<td colspan="6">
												${productInfo.product_point }%
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
                    							<c:choose>
                    								<c:when test="${sizeUsed.xs_used == 1}">사용</c:when>
                    								<c:otherwise>미사용</c:otherwise>
                    							</c:choose>
                    						</td>
                    						<td>
                    							<c:choose>
                    								<c:when test="${sizeUsed.s_used == 1}">사용</c:when>
                    								<c:otherwise>미사용</c:otherwise>
                    							</c:choose>
                    						</td>
                    						<td>
                    							<c:choose>
                    								<c:when test="${sizeUsed.m_used == 1}">사용</c:when>
                    								<c:otherwise>미사용</c:otherwise>
                    							</c:choose>
                    						</td>
                    						<td>
                    							<c:choose>
                    								<c:when test="${sizeUsed.l_used == 1}">사용</c:when>
                    								<c:otherwise>미사용</c:otherwise>
                    							</c:choose>
                    						</td>
                    						<td>
                    							<c:choose>
                    								<c:when test="${sizeUsed.xl_used == 1}">사용</c:when>
                    								<c:otherwise>미사용</c:otherwise>
                    							</c:choose>
                    						</td>
                    					</tr>
                    					<tr>
                    						<td align="center" colspan="7">사이즈 가이드
                    								<c:if test="${selectSizeGuideGroup eq 'top'}">(상의류)</c:if>
                    								<c:if test="${selectSizeGuideGroup eq 'bottom'}">(하의류)</c:if>
                    						</td>
                    					</tr>
                    					<tr class="sizeGuide">
                    						<td id="sizeGuideTitle"rowspan="4" style="vertical-align: middle;">
                   								<c:if test="${selectSizeGuideGroup eq 'top'}">상의류</c:if>
                   								<c:if test="${selectSizeGuideGroup eq 'bottom'}">하의류</c:if>
                    						</td>
                    						<td id="sizeInfo1">LENGTH(총길이)</td>
                    						<td style="<c:if test='${sizeUsed.xs_used == 0}'>background-color: gray;</c:if>">${length.xs_size}</td>
                    						<td style="<c:if test='${sizeUsed.s_used == 0}'>background-color: gray;</c:if>">${length.s_size}</td>
                    						<td style="<c:if test='${sizeUsed.m_used == 0}'>background-color: gray;</c:if>">${length.m_size}</td>
                    						<td style="<c:if test='${sizeUsed.l_used == 0}'>background-color: gray;</c:if>">${length.l_size}</td>
                    						<td style="<c:if test='${sizeUsed.xl_used == 0}'>background-color: gray;</c:if>">${length.xl_size}</td>
                    					</tr>
                    					<tr class="sizeGuide">
                    						<td id="sizeInfo2">
 		                   						<c:choose>
                    								<c:when test="${selectSizeGuideGroup eq 'top'}">CHEST(가슴)</c:when>
                    								<c:otherwise>WAIST(허리)</c:otherwise>
                    							</c:choose>
                    						</td>
                							<c:if test="${selectSizeGuideGroup eq 'top'}">
                 								<td style="<c:if test='${sizeUsed.xs_used == 0}'>background-color: gray;</c:if>">${chest.xs_size }</td>		
                 								<td style="<c:if test='${sizeUsed.s_used == 0}'>background-color: gray;</c:if>">${chest.s_size }</td>		
                 			 					<td style="<c:if test='${sizeUsed.m_used == 0}'>background-color: gray;</c:if>">${chest.m_size }</td>		
                 								<td style="<c:if test='${sizeUsed.l_used == 0}'>background-color: gray;</c:if>">${chest.l_size }</td>		
                 								<td style="<c:if test='${sizeUsed.xl_used == 0}'>background-color: gray;</c:if>">${chest.xl_size }</td>		
                 							</c:if>
                							<c:if test="${selectSizeGuideGroup eq 'bottom'}">
                 								<td style="<c:if test='${sizeUsed.xs_used == 0}'>background-color: gray;</c:if>">${waist.xs_size }</td>		
                 								<td style="<c:if test='${sizeUsed.s_used == 0}'>background-color: gray;</c:if>">${waist.s_size }</td>		
                 								<td style="<c:if test='${sizeUsed.m_used == 0}'>background-color: gray;</c:if>">${waist.m_size }</td>		
                 								<td style="<c:if test='${sizeUsed.l_used == 0}'>background-color: gray;</c:if>">${waist.l_size }</td>		
                 								<td style="<c:if test='${sizeUsed.xl_used == 0}'>background-color: gray;</c:if>">${waist.xl_size }</td>		
                 							</c:if>
                    					</tr>
                    					<tr class="sizeGuide">
                    						<td id="sizeInfo3">
                    							<c:choose>
                    								<c:when test="${selectSizeGuideGroup eq 'top'}">ARM(팔)</c:when>
                    								<c:otherwise>THIGH(허벅지)</c:otherwise>
                    							</c:choose>
                    						</td>
                    						<c:if test="${selectSizeGuideGroup eq 'top'}">
                 								<td style="<c:if test='${sizeUsed.xs_used == 0}'>background-color: gray;</c:if>">${arm.xs_size }</td>		
                 								<td style="<c:if test='${sizeUsed.s_used == 0}'>background-color: gray;</c:if>">${arm.s_size }</td>		
                 								<td style="<c:if test='${sizeUsed.m_used == 0}'>background-color: gray;</c:if>">${arm.m_size }</td>		
                 								<td style="<c:if test='${sizeUsed.l_used == 0}'>background-color: gray;</c:if>">${arm.l_size }</td>		
                 								<td style="<c:if test='${sizeUsed.xl_used == 0}'>background-color: gray;</c:if>">${arm.xl_size }</td>		
                 							</c:if>
                							<c:if test="${selectSizeGuideGroup eq 'bottom'}">
                 								<td style="<c:if test='${sizeUsed.xs_used == 0}'>background-color: gray;</c:if>">${thigh.xs_size }</td>		
                 								<td style="<c:if test='${sizeUsed.s_used == 0}'>background-color: gray;</c:if>">${thigh.s_size }</td>		
                 								<td style="<c:if test='${sizeUsed.m_used == 0}'>background-color: gray;</c:if>">${thigh.m_size }</td>		
                 								<td style="<c:if test='${sizeUsed.l_used == 0}'>background-color: gray;</c:if>">${thigh.l_size }</td>		
                 								<td style="<c:if test='${sizeUsed.xl_used == 0}'>background-color: gray;</c:if>">${thigh.xl_size }</td>		
                 							</c:if>
                    					</tr>
                    					<tr class="sizeGuide">
                    						<td id="sizeInfo4">
                    							<c:choose>
                    								<c:when test="${selectSizeGuideGroup eq 'top'}">SHOULDER(어깨)</c:when>
                    								<c:otherwise>HEM(밑단)</c:otherwise>
                    							</c:choose>
                    						</td>
                    						<c:if test="${selectSizeGuideGroup eq 'top'}">
                 								<td style="<c:if test='${sizeUsed.xs_used == 0}'>background-color: gray;</c:if>">${shoulder.xs_size }</td>		
                 								<td style="<c:if test='${sizeUsed.s_used == 0}'>background-color: gray;</c:if>">${shoulder.s_size }</td>		
                 								<td style="<c:if test='${sizeUsed.m_used == 0}'>background-color: gray;</c:if>">${shoulder.m_size }</td>		
                 								<td style="<c:if test='${sizeUsed.l_used == 0}'>background-color: gray;</c:if>">${shoulder.l_size }</td>		
                 								<td style="<c:if test='${sizeUsed.xl_used == 0}'>background-color: gray;</c:if>">${shoulder.xl_size }</td>		
                 							</c:if>
                							<c:if test="${selectSizeGuideGroup eq 'bottom'}">
                 								<td style="<c:if test='${sizeUsed.xs_used == 0}'>background-color: gray;</c:if>">${hem.xs_size }</td>		
                 								<td style="<c:if test='${sizeUsed.s_used == 0}'>background-color: gray;</c:if>">${hem.s_size }</td>		
                 								<td style="<c:if test='${sizeUsed.m_used == 0}'>background-color: gray;</c:if>">${hem.m_size }</td>		
                 								<td style="<c:if test='${sizeUsed.l_used == 0}'>background-color: gray;</c:if>">${hem.l_size }</td>		
                 								<td style="<c:if test='${sizeUsed.xl_used == 0}'>background-color: gray;</c:if>">${hem.xl_size }</td>		
                 							</c:if>
                    					</tr>
                    					
                    					<tr>
                    						<td>상품노출유무</td>
                    						<td colspan="6">
												<c:if test="${productInfo.product_used == 1 }">
													노출												
												</c:if>
												<c:if test="${productInfo.product_used == 0 }">
													미노출
												</c:if>
											</td>
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
    	                						<span>상세이미지</span>
                    							<div id="sub-preview">
                    								<c:forEach items="${subImage }" var="image">
                    								<div style="display: inline-flex; padding: 10px;">
	                    								<li>
		                    								<span>${image.image_name }</span><br>
		                    								<img src="${image.upload_path }" width=100  />
	                    								</li>
                    								</div>
                    								</c:forEach>
                    							</div>
                    						</td>
                    					</tr>
                    					<tr>
                    						<td colspan="7" align="center">
                    							<input value="목록" type="button" class="btn btn-dark" onclick="location.href='/admin/productList.mdo'">
                    							<input id="update" type="submit" class="btn btn-dark" value="수정">
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