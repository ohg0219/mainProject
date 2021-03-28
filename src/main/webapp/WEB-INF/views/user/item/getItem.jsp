<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> ${category }</title>
<link rel="stylesheet" href="/resources/user/css/common.css">
<link rel="stylesheet" href="/resources/user/css/item_list.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/user/js/common.js"></script>
<style type="text/css">
	.side-bar ul>li{
		margin-bottom: 5px;
	}
	.size_selection {
		float: left; 
		display: inline-block; 
		margin: 0 6px 6px 0;
	}
	.size_selection a{
		border: 1px solid #ddd;
		width: 36px;
    	height: 36px;
    	line-height: 36px;
    	text-align: center;
    	font-size: 10px;
    	color: #111;
    	display:inline-block;
    	font-weight: 700;
	}
	.size_selection a:hover{
		text-decoration: none;
		border: 1px solid black;
	}
	.image_box li{
		width:50%; 
		display: inline-block; 
		float: left; 
		padding: 5px; 
		box-sizing: border-box; 
		min-width: 200px;
	}
	.image_box li img{
		width: 100%;
		cursor: crosshair;
	}
	.empty a{
		color: #ddd;
		cursor: default;
	}
	.empty a:hover{
		text-decoration: none;
		border: 1px solid #ddd;
	}
	.size_info{
		height: 60px;
	}
	.bigPictureWrapper {
		position: fixed;
		display: none;
		justify-content: center;
		align-items: center;
		top:0%;
		width:100%;
		height:100%;
		background-color: gray; 
		z-index: 9999;
		background:rgba(255,255,255,0.5);
		cursor: crosshair;
	}
	.bigPicture {
		position: relative;
		display:flex;
		justify-content: center;
		align-items: center;
	}
	
	.bigPicture img {
		height: 100%;
	}
	.productBtn{
		all : unset;
		border: 1px solid black;
		width: 16px;
		height : 16px;
		text-align: center;
		cursor: pointer;
		margin-left: 5px;
		margin-right: 5px;
	}
	.choose_cancel{
		text-decoration: none;
		color: black;
	}
	.select_count{
		font-weight: 700;
	}
	.payBtn{
		all : unset;
		width:124px;
		box-sizing:border-box;
		border: 1px solid black;
		float:left;
		height: 38px;
		text-align: center;
	}
	.payBtn:hover{
		color: white;
		background-color: black;
		cursor: pointer;
	}
	#sizeGuideBtn,#questionBtn,#deliveryBtn{
		font-weight:700;
		cursor: pointer;
	}
	.noneSize{
		display: none;
	}
	#sizeGuideTable tr td:first-child{
		font-weight: 700;
	}
</style>
<script type="text/javascript">
$(document).ready(function (e){
	$(document).on("click","img",function(){
		var path = $(this).attr('src')
		showImage(path);
	});//end click event
	function showImage(fileCallPath){
	    $(".bigPictureWrapper").css("display","flex").show();
	    $(".bigPicture")
	    .html("<img src='"+fileCallPath+"' >")
	    .animate({width:'100%', height: '100%'}, 0);
	  }//end fileCallPath
	$(".bigPictureWrapper").on("click", function(e){
	    $(".bigPicture").animate({width:'0%', height: '0%'}, 0);
	    setTimeout(function(){
	      $('.bigPictureWrapper').hide();
	    }, 0);
	  });//end bigWrapperClick event
});
$(document).ready(function(){
	var productName = $(".product_name").text();
	var size = "";
	$(".empty").on("click",function(e){
		e.preventDefault();
	});
	$(".full").on("click",function(e){
		e.preventDefault();
		size = $(this).children().text();
		console.log($("."+size).text())
		if($("."+size).text() == size){
			return false;
		}
		var str ="";
		str += "<tr>";
		str += "<td class='select_info'>";
		str += "<span class='productName'>"+productName + "</span><br> - <strong class='selectSize "+size+"'>" + size + "</strong>";
		str += "</td>";
		str += "<td>";
		str += "<input class='sizeType' type='hidden' value='"+size+"'>"
		str += "<input class='productBtn' type='button' id='plus' value='+' >";
		str += "</td>";
		str += "<td>";
		str += "<div class='select_count' id='"+size+"'>1</div>";
		str += "</td>";
		str += "<td>";
		str += "<input class='sizeType' type='hidden' value='"+size+"'>"
		str += "<input class='productBtn' type='button' id='minus' value='-' >";
		str += "</td>";
		str += "<td><a href='#' class='choose_cancel' >X</a></td>";
		str += "</tr>";
		$(".choose").append(str);
	});
	$(document).on("click","#basket",function(){
		var grpl = $(".selectSize").length;
		//배열 생성
		var selectSize = new Array(grpl);
		var selectCount = new Array(grpl);
		//배열에 값 주입
		var selectItem = "";
		var productNo = $("#productNo").val();
		var productPrice = $("#productPrice").val();
		for(var i=0; i<grpl; i++){                          
			selectSize[i] = $(".selectSize").eq(i).text();
			selectCount[i] = $(".select_count").eq(i).text();
			selectItem += selectSize[i] + ":"+selectCount[i] + "/";
	    }
		if(selectItem == ''){
			alert("구매하실 상품을 선택해주세요.");
			return false;
		}
		$.ajax({
			url : "/insertBasket.do?productNo="+productNo+"&selectItem="+selectItem,
			type: 'GET',
			success : function(data){
				if(data=='fail'){
					alert("장바구니에 중복된 상품이 있습니다.");
					return false;
				}else{
					location.href="/basket.do";
				}
			}
		});
	});
	$(document).on("click",".choose_cancel",function(){
		$(this).closest("tr").remove();
	});
	$(document).on("click",".productBtn",function(){
		var type = $(this).val();
		var sizeType = $(this).siblings(".sizeType").val();
		const resultElement = document.getElementById(sizeType);
		  let number = resultElement.innerText;
		  if(type == '+') {
		    number = parseInt(number) + 1;
		  }else if(type === '-')  {
		  	if(number == '1'){ return false; }
			number = parseInt(number) - 1;
		  }
		  resultElement.innerText = number;
	});
});	
$(document).ready(function(){
	$("#sizeGuideBtn").click(function(){
		$(this).next("#sizeGuide").slideToggle(300);
		$("#deliveryGuide").hide();
		$("#questionGuide").hide();
	});
	$("#deliveryBtn").click(function(){
		$(this).next("#deliveryGuide").slideToggle(300);
		$("#sizeGuide").hide();
		$("#questionGuide").hide();
	});
	$("#questionBtn").click(function(){
		$(this).next("#questionGuide").slideToggle(300);
		$("#sizeGuide").hide();
		$("#deliveryGuide").hide();
	});
});			
</script>
</head>
<body>
	<div class='bigPictureWrapper'>
		<div class='bigPicture'></div>
	</div>
	<div class="wrap">
		<%@include file="../include/header.jsp"%>
		<div class="content">
			<div class="side-bar" style="width:15%; display: inline-block; float: left; margin-top:50px">
				<div style="margin-left: 20px;">
					<ul>
						<li>
							<c:choose>
								<c:when test="${'ALL' eq category }">
									<a href="/itemList/category/all.do" style="text-decoration: underline; font-weight: 700;">select_countALL</p></a>	
								</c:when>
								<c:otherwise>
									<a href="/itemList/category/all.do"><p>ALL</p></a>
								</c:otherwise>
							</c:choose>
						</li>
						<li>
							<c:choose>
								<c:when test="${'NEW' eq category }">
									<a href="/itemList/category/new.do" style="text-decoration: underline; font-weight: 700;"><p>NEW</p></a>	
								</c:when>
								<c:otherwise>
									<a href="/itemList/category/new.do"><p>NEW</p></a>
								</c:otherwise>
							</c:choose>
						</li>
						<c:forEach items="${menu }" var="menus">
							<li style="text-transform: uppercase;">
								<c:choose>
									<c:when test="${menus eq category }">
										<a href="/itemList/category/${menus }.do" style="text-decoration: underline; font-weight: 700;"><p>${menus}</p></a>
									</c:when>
									<c:otherwise>
										<a href="/itemList/category/${menus }.do"><p>${menus}</p></a>	
									</c:otherwise>
								</c:choose>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
			<h2 align="center" style="text-transform: uppercase;">${category }</h2>
			
			<!-- 이미지  -->
			<div style="float: left; width:calc(75% - 210px);">
				<ul class="image_box">
					<c:forEach items="${itemImage }" var="image">
						<li>
							<img class="image" src="${image.uploadPath }">
						</li>	
					</c:forEach>
				</ul>
			</div>
			<!-- 상품정보 및 주문 -->
			<div style=" width:calc(10% + 210px); float:left; ">
				<div class="item_info" style="margin-left: 20px;">
					<input id="productNo" type="hidden" value="${itemInfo.productNo }">
					<input id="productPrice" type="hidden" value="${itemInfo.productPrice }">
					<ul>
						<li><strong class="product_name" style="font-size: 12px;">${itemInfo.productName }</strong><br><br></li>
						
						<li>&#8361;<fmt:formatNumber maxFractionDigits="3"  value="${itemInfo.productPrice }"/>원<br><br></li>
						<li>${itemInfo.materialInfo }</li>
						<li>${itemInfo.origin }</li>
					</ul>
					<div class="size_info">
						<ul>
							<li class="size_selection <c:choose><c:when test="${itemInfo.xs < 1}">empty</c:when><c:otherwise>full</c:otherwise></c:choose> <c:if test="${sizeUsed.xs_used == 0 }">noneSize</c:if>" ><a href="#">XS</a></li>
							<li class="size_selection <c:choose><c:when test="${itemInfo.s < 1}">empty</c:when><c:otherwise>full</c:otherwise></c:choose> <c:if test="${sizeUsed.s_used == 0 }">noneSize</c:if>" ><a href="#">S</a></li>
							<li class="size_selection <c:choose><c:when test="${itemInfo.m < 1}">empty</c:when><c:otherwise>full</c:otherwise></c:choose> <c:if test="${sizeUsed.m_used == 0 }">noneSize</c:if>" ><a href="#">M</a></li>
							<li class="size_selection <c:choose><c:when test="${itemInfo.l < 1}">empty</c:when><c:otherwise>full</c:otherwise></c:choose> <c:if test="${sizeUsed.l_used == 0 }">noneSize</c:if>" ><a href="#">L</a></li>
							<li class="size_selection <c:choose><c:when test="${itemInfo.xl < 1}">empty</c:when><c:otherwise>full</c:otherwise></c:choose> <c:if test="${sizeUsed.xl_used == 0 }">noneSize</c:if>" ><a href="#">XL</a></li>
						</ul>
					</div>
					<div class="choose_products" style="display: inline-block;">
						<table class="choose" style="width: 214px;">
							
						</table>
					</div>
					<div style="width: 250px;margin-bottom: 70px;">
						<input id="basket" class="payBtn" type="button" style="border-right-style: hidden;" value="장바구니 담기">
						<input class="payBtn" type="button" value="바로 구매하기">
					</div>
					<p id="sizeGuideBtn">SIZE GUIDE</p>
					<div style="width: 250px; display: none;" id="sizeGuide">
						<!-- 사이즈 가이드 추가 -->
						<div>
							<table id="sizeGuideTable" >
								<tr style="font-weight: 700">
									<td width="80px"></td>
									<td width="40px" height="" class="<c:if test="${sizeUsed.xs_used == 0 }">noneSize</c:if>">XS</td>
									<td width="40px" class="<c:if test="${sizeUsed.s_used == 0 }">noneSize</c:if>">S</td>
									<td width="40px" class="<c:if test="${sizeUsed.m_used == 0 }">noneSize</c:if>">M</td>
									<td width="40px" class="<c:if test="${sizeUsed.l_used == 0 }">noneSize</c:if>">L</td>
									<td width="40px" class="<c:if test="${sizeUsed.xl_used == 0 }">noneSize</c:if>">XL</td>
								</tr>
								<c:if test="${selectSizeGuideGroup eq 'top' }">
								<tr>
									<td>LENGTH</td>
									<td class="<c:if test="${sizeUsed.xs_used == 0 }">noneSize</c:if>">${length.xs_size}</td>
									<td class="<c:if test="${sizeUsed.s_used == 0 }">noneSize</c:if>">${length.s_size}</td>
									<td class="<c:if test="${sizeUsed.m_used == 0 }">noneSize</c:if>">${length.m_size}</td>
									<td class="<c:if test="${sizeUsed.l_used == 0 }">noneSize</c:if>">${length.l_size}</td>
									<td class="<c:if test="${sizeUsed.xl_used == 0 }">noneSize</c:if>">${length.xl_size}</td>
								</tr>
								<tr>
									<td>CHEST</td>
									<td class="<c:if test="${sizeUsed.xs_used == 0 }">noneSize</c:if>">${chest.xs_size}</td>
									<td class="<c:if test="${sizeUsed.s_used == 0 }">noneSize</c:if>">${chest.s_size}</td>
									<td class="<c:if test="${sizeUsed.m_used == 0 }">noneSize</c:if>">${chest.m_size}</td>
									<td class="<c:if test="${sizeUsed.l_used == 0 }">noneSize</c:if>">${chest.l_size}</td>
									<td class="<c:if test="${sizeUsed.xl_used == 0 }">noneSize</c:if>">${chest.xl_size}</td>
								</tr>
								<tr>
									<td>ARM</td>
									<td class="<c:if test="${sizeUsed.xs_used == 0 }">noneSize</c:if>">${arm.xs_size}</td>
									<td class="<c:if test="${sizeUsed.s_used == 0 }">noneSize</c:if>">${arm.s_size}</td>
									<td class="<c:if test="${sizeUsed.m_used == 0 }">noneSize</c:if>">${arm.m_size}</td>
									<td class="<c:if test="${sizeUsed.l_used == 0 }">noneSize</c:if>">${arm.l_size}</td>
									<td class="<c:if test="${sizeUsed.xl_used == 0 }">noneSize</c:if>">${arm.xl_size}</td>
								</tr>
								<tr>
									<td>SHOULDER</td>
									<td class="<c:if test="${sizeUsed.xs_used == 0 }">noneSize</c:if>">${shoulder.xs_size}</td>
									<td class="<c:if test="${sizeUsed.s_used == 0 }">noneSize</c:if>">${shoulder.s_size}</td>
									<td class="<c:if test="${sizeUsed.m_used == 0 }">noneSize</c:if>">${shoulder.m_size}</td>
									<td class="<c:if test="${sizeUsed.l_used == 0 }">noneSize</c:if>">${shoulder.l_size}</td>
									<td class="<c:if test="${sizeUsed.xl_used == 0 }">noneSize</c:if>">${shoulder.xl_size}</td>
								</tr>
								</c:if>
								<c:if test="${selectSizeGuideGroup eq 'bottom' }">
								<tr>
									<td>LENGTH</td>
									<td class="<c:if test="${sizeUsed.xs_used == 0 }">noneSize</c:if>">${length.xs_size}</td>
									<td class="<c:if test="${sizeUsed.s_used == 0 }">noneSize</c:if>">${length.s_size}</td>
									<td class="<c:if test="${sizeUsed.m_used == 0 }">noneSize</c:if>">${length.m_size}</td>
									<td class="<c:if test="${sizeUsed.l_used == 0 }">noneSize</c:if>">${length.l_size}</td>
									<td class="<c:if test="${sizeUsed.xl_used == 0 }">noneSize</c:if>">${length.xl_size}</td>
								</tr>
								<tr>
									<td>WAIST</td>
									<td class="<c:if test="${sizeUsed.xs_used == 0 }">noneSize</c:if>">${waist.xs_size}</td>
									<td class="<c:if test="${sizeUsed.s_used == 0 }">noneSize</c:if>">${waist.s_size}</td>
									<td class="<c:if test="${sizeUsed.m_used == 0 }">noneSize</c:if>">${waist.m_size}</td>
									<td class="<c:if test="${sizeUsed.l_used == 0 }">noneSize</c:if>">${waist.l_size}</td>
									<td class="<c:if test="${sizeUsed.xl_used == 0 }">noneSize</c:if>">${waist.xl_size}</td>
								</tr>
								<tr>
									<td>THIGH</td>
									<td class="<c:if test="${sizeUsed.xs_used == 0 }">noneSize</c:if>">${thigh.xs_size}</td>
									<td class="<c:if test="${sizeUsed.s_used == 0 }">noneSize</c:if>">${thigh.s_size}</td>
									<td class="<c:if test="${sizeUsed.m_used == 0 }">noneSize</c:if>">${thigh.m_size}</td>
									<td class="<c:if test="${sizeUsed.l_used == 0 }">noneSize</c:if>">${thigh.l_size}</td>
									<td class="<c:if test="${sizeUsed.xl_used == 0 }">noneSize</c:if>">${thigh.xl_size}</td>
								</tr>
								<tr>
									<td>HEM</td>
									<td class="<c:if test="${sizeUsed.xs_used == 0 }">noneSize</c:if>">${hem.xs_size}</td>
									<td class="<c:if test="${sizeUsed.s_used == 0 }">noneSize</c:if>">${hem.s_size}</td>
									<td class="<c:if test="${sizeUsed.m_used == 0 }">noneSize</c:if>">${hem.m_size}</td>
									<td class="<c:if test="${sizeUsed.l_used == 0 }">noneSize</c:if>">${hem.l_size}</td>
									<td class="<c:if test="${sizeUsed.xl_used == 0 }">noneSize</c:if>">${hem.xl_size}</td>
								</tr>
								</c:if>
							</table>
						</div>
						<br>
						<div>
							제품 이미지 색상은 사용하시는 컴퓨터 해상도에 <br>
							따라 어둡거나 밝게 보일 수 있습니다.<br><br>
							
							상세 사이즈 치수는 측정 방법과 위치에 따라 <br>
							약간의 오차가 발생할 수 있습니다.<br><br>
							지퍼 폴리 백의 특성상 소량의 슬립제 가루가 <br>
							제품에 묻어 나올 수 있습니다.<br><br>
							표백제나 표백 성분 세제는 사용하지 마십시오.<br><br>
							세탁 시 탈색 또는 이염될 우려가 있으므로<br> 
							타 의류와 함께 세탁하지 마시고 반드시 단독 세탁 하십시오.<br><br>
							착용 중 마찰로 인해 다른 제품에 이염될<br> 
							우려가 있으므로 주의하시기 바랍니다.
						</div>
					</div>
					<p id="deliveryBtn">배송 &#38; 반품</p>
					<div style="width: 250px; display: none;" id="deliveryGuide">
						택배<br>
						배송 지역 전국지역<br>
						비용 2,500<br><br>
						영업일 기준 2일 ~ 4일 소요됩니다.<br><br>
						반품은 출고 완료 이메일을 받은 날짜로부터 7일 이내에 가능합니다.<br><br>
						<a href="#" style="text-decoration: none; border-bottom: 1px solid #ddd; color: black">주문 조회</a>
					</div>
					<p id="questionBtn">문의</p>
					<div style="width: 250px; display: none;" id="questionGuide">
						<a style="text-decoration: none; border-bottom: 1px solid #ddd; color: black" href="mailto:thisisthat.official@gmail.com">thisisthat.official@gmail.com</a>
						<br>+82 (0)10 1234 4567
					</div>
				</div>
			</div>
			
		</div><!-- end Content -->
		<%@include file="../include/footer.jsp"%>
	</div>
</body>
</html>