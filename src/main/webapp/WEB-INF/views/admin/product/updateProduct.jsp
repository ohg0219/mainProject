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

<title>thisisthat - 상품 정보수정</title>

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
                    <h1 class="h3 mb-2 text-gray-800">상품 정보수정</h1>
                    <p class="mb-4"><!-- 쓸 말 있으면 쓰는 곳 --></p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                       
                        <div class="card-body">
                            <form action="updateProduct.mdo" method="post" enctype="multipart/form-data">
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
                    						<td  colspan="6"><input style="width: 100%" type="text" id="productName" name="product_name" value="${productInfo.product_name }"></td>
                    					</tr>
                    					<tr>
                    						<td>소비자가</td>
                    						<td  colspan="6"><input type="text" id="productPrice" name="product_price" value="${productInfo.product_price }"></td>
                    					</tr>
                    					<tr>
                    						<td>소재정보</td>
                    						<td  colspan="6"><textarea style="width: 100%" id="materialInfo" name="material_info" >${productInfo.material_info }</textarea></td>
                    					</tr>
                    					<tr>
                    						<td>원산지</td>
                    						<td  colspan="6"><input style="width: 100%" type="text" id="origin" name="origin" value="${productInfo.origin }"></td>
                    					</tr>
                    					<tr>
                    						<td>상품설명</td>
                    						<td  colspan="6"><textarea style="width: 100%" id="productInfo" name="product_info">${productInfo.product_info }</textarea></td>
                    					</tr>
                    					<tr>
                    						<td>적립율</td>
                    						<td  colspan="6">
												<input type="number" name="product_point" value="${productInfo.product_point }">%
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
                    								<option value="top" <c:if test="${selectSizeGuideGroup == top}">selected</c:if>>상의류</option>
                    								<option value="bottom" <c:if test="${selectSizeGuideGroup == bottom}">selected</c:if>>하의류</option>
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
                    						<td id="sizeGuideTitle"rowspan="4" style="vertical-align: middle;">
                   								<c:if test="${selectSizeGuideGroup == top}">상의류</c:if>
                   								<c:if test="${selectSizeGuideGroup == bottom}">하의류</c:if>
                    						</td>
                    						<td id="sizeInfo1">LENGTH(총길이)</td>
                    						<td><input class="xs" type="text" name="size1" size="5"></td>
                    						<td><input class="s" type="text" name="size1" size="5"></td>
                    						<td><input class="m" type="text" name="size1" size="5"></td>
                    						<td><input class="l" type="text" name="size1" size="5"></td>
                    						<td><input class="xl" type="text" name="size1" size="5"></td>
                    					</tr>
                    					<tr class="sizeGuide">
                    						<td id="sizeInfo2">
 		                   						<c:if test="${selectSizeGuideGroup == top}">CHEST(가슴)</c:if>
                   								<c:if test="${selectSizeGuideGroup == bottom}">WAIST(허리)</c:if>
                    						</td>
                    						<td><input class="xs" type="text" name="size2" size="5"></td>
                    						<td><input class="s" type="text" name="size2" size="5"></td>
                    						<td><input class="m" type="text" name="size2" size="5"></td>
                    						<td><input class="l" type="text" name="size2" size="5"></td>
                    						<td><input class="xl" type="text" name="size2" size="5"></td>
                    					</tr>
                    					<tr class="sizeGuide">
                    						<td id="sizeInfo3">
                    							<c:choose>
                    								<c:when test="${selectSizeGuideGroup == top}">ARM(팔)</c:when>
                    								<c:otherwise>THIGH(허벅지)</c:otherwise>
                    							</c:choose>
                    						</td>
                    						<td><input class="xs" type="text" name="size3" size="5"></td>
                    						<td><input class="s" type="text" name="size3" size="5"></td>
                    						<td><input class="m" type="text" name="size3" size="5"></td>
                    						<td><input class="l" type="text" name="size3" size="5"></td>
                    						<td><input class="xl" type="text" name="size3" size="5"></td>
                    					</tr>
                    					<tr class="sizeGuide">
                    						<td id="sizeInfo4">
                    							<c:choose>
                    								<c:when test="${selectSizeGuideGroup == top}">SHOULDER(어깨)</c:when>
                    								<c:otherwise>HEM(밑단)</c:otherwise>
                    							</c:choose>
                    						</td>
                    						<td><input class="xs" type="text" name="size4" size="5"></td>
                    						<td><input class="s" type="text" name="size4" size="5"></td>
                    						<td><input class="m" type="text" name="size4" size="5"></td>
                    						<td><input class="l" type="text" name="size4" size="5"></td>
                    						<td><input class="xl" type="text" name="size4" size="5"></td>
                    					</tr>
                    					<tr>
                    						<td>상품노출유무</td>
                    						<td  colspan="6">
                    							<c:if test="${productInfo.product_used == 1 }">
                    								<select name="product_used">
	                    								<option value="1" selected="selected">노출</option>
	                    								<option value="0">미노출</option>
	                    							</select>
                    							</c:if>
                    							<c:if test="${productInfo.product_used == 0 }">
                    								<select name="product_used">
	                    								<option value="1" >노출</option>
	                    								<option value="0" selected="selected">미노출</option>
	                    							</select>
                    							</c:if>
                    						</td>
                    					</tr>
                    					<tr>
                    						<td colspan="7">
    	                						<span>메인이미지</span>
                    							<div id="main-preview">
                    								<div style="display: inline-flex; padding: 10px;">
                    									<li>
		                    								<span>${mainImage.image_name }</span><br>
		                    								<img src="${mainImage.upload_path }" width=100  />
	                    								</li>
                    								</div>
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