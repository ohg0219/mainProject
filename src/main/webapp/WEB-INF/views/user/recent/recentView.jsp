<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thisisthat® 디스이즈댓</title>
<link rel="stylesheet" href="/resources/user/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/user/js/common.js"></script>
<style type="text/css">

#wrap {
	position: relative;
    width: 100%;
    margin: 0 auto;
    height: 750px;
}

.content {
	magin: 0 auto;
}

.title {
	height : 120px;
}

.title h1{
	text-align: center;
	font-size: 19px;
	padding : 40px 0 20px 0;	
	font-weight: normal;
}

th{
	padding: 13px 10px 13px 10px;
	background: #f5f5f5;
	color: #777;
	font-weight: normal;
}

td {
	border-top: 1px solid #f0f0f0;
}

.container{
	height: auto;
	
}

.inner{
	width: 83%;
	margin: 0 auto;
}

.inner table{
	border: 1px solid #f5f5f5;
}

.product {
	font-size: 12px;
}

.optl{
	color : #999;
	font-size: 11px;
	padding: 0 10px;
    letter-spacing: 0.02em;
}

.select {
	position: relative;
	left: 20px;
	padding: 0 5px 0 5px;
	height: 30px;
	background: #f5f5f5;
	border: 0;
	font-size: 10px;
	color : #666;
	border-radius: 5px;
}

.price_box{
	text-align: center;
	font-size: 12px;
    letter-spacing: 0.03em;
}

.price_box strong{
	font-weight: normal;

}

.basket {
	margin: 0 auto;
	margin-bottom: 1px;
	width: 50px;
	display: block;
	background: #333;
	color: #fff;
	text-align: center;
	border: 1px solid #999;
	text-decoration: none;
	top: 30%;
	padding: 4px 1px 4px 1px;
}

.delete{
	margin: 0 auto;
	width: 50px;
	display: block;
	background: #fff;
	color: #333;
	text-align: center;
	border: 1px solid #999;
	text-decoration: none;
	top: 30%;
	padding: 4px 1px 4px 1px;

}

</style>
</head>
<body>
	<div class="wraped">
		<%@include file="../include/header.jsp"%>
		<div id="wrap">
			<div class="content">
				<div class="title">
					<h1>RECENTLY VIEW</h1>
				</div>
				<div class="container">
					<div class="inner">
						<table border="0">
							<thead>
								<tr>
									<th width="110">이미지</th>
									<th width="830">상품명</th>
									<th width="270">옵션정보</th>
									<th width="150">판매가</th>
									<th width="100">주문</th>
								</tr>
							</thead>
							<tbody>
							<c:if test="${empty imgView }">
								<tr>
									<td colspan="5" align="center">
										<h3>최근 본 상품이 없습니다.</h3>
									</td>
								</tr>
							</c:if>
							
							<c:if test="${not empty imgView}">
								<c:forEach items="${imgView}" var="recent">
								
								<tr> 
									<td width="110" class="image" align="center">
										<a href="/itemList/getItem.do?productNo=${recent.productNo}&productCategory=${recent.productCategory}">
											<img alt="이미지를 불러올 수 없습니다." src="${recent.uploadPath}" width="100" >
										</a>
									</td>
									<td class="product" width="830" align="center">
										<a href="/itemList/getItem.do?productNo=${recent.productNo}&productCategory=${recent.productCategory}" style="text-decoration: none;">
											${recent.productName }
										</a>
									</td>
									<td class="option" width="270">
										<ul>
											<li>
												<span class="optl">SIZE</span>
												<select id="selectSize" class="select">
													<option value="*">- [필수] 옵션을 선택해 주세요 -</option>
													<c:if test="${recent.sizeXS == 1}">
														<option value="XS">XS</option>
													</c:if>
													<c:if test="${recent.sizeS == 1}">
														<option value="S">S</option>
													</c:if>
													<c:if test="${recent.sizeM == 1}">
														<option value="M">M</option>
													</c:if>
													<c:if test="${recent.sizeL == 1}">
														<option value="L">L</option>
													</c:if>
													<c:if test="${recent.sizeXL == 1}">	
														<option value="XL">XL</option>
													</c:if>
												</select>
											</li>
										</ul>
									</td>
									<td class="price_box" width="150">
										<strong><fmt:formatNumber type="number" maxFractionDigits="3" value="${recent.productPrice}"/>원</strong>   
									</td>									
									<td class="order_box" width="100">
										<input type="hidden" id="productNo" value="${recent.productNo}">
										<input type="hidden" id="price" value="${recent.productPrice}">
										<p class="order">
											<a id="basket" class="basket">담기</a>
											<a href="/deleteRecent.do?productNo=${recent.productNo}" class="delete">삭제</a>
										</p>
									</td>
								</tr>
								</c:forEach>
							</c:if>
							</tbody>
						</table>
				
					</div>
				</div>
			</div>
			<%@include file="../include/footer.jsp"%>
		</div>
	</div>
<script type="text/javascript">
	$(".basket").on("click",function(){
		var productNo = $(this).closest("td").find("#productNo").val();
		var productPrice = $(this).closest("td").find("#price").val();
		var size = $(this).closest("tr").find("#selectSize option:selected").val();
		
		location.href="/insertRecentBasket.do?productNo="+productNo+"&size="+size+"&productPrice="+productPrice;
	});
</script>
</body>
</html>