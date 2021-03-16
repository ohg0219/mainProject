<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${category }</title>
<link rel="stylesheet" href="/resources/user/css/common.css">
<link rel="stylesheet" href="/resources/user/css/item_list.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/user/js/common.js"></script>
<style type="text/css">
	.side-bar ul>li{
		margin-bottom: 5px;
	}
</style>
</head>
<body>
	<div class="wrap">
		<%@include file="include/header.jsp"%>
		<div class="content">
			
			
			<div class="side-bar" style="width: 15%; display: inline-block; float: left; margin-top:50px">
				<div style="margin-left: 20px;">
					<ul>
						<!-- 여기를 메뉴  -->
						<li>
							<c:choose>
								<c:when test="${'all' eq category }">
									<a href="/itemList/category/all.do" style="text-decoration: underline; font-weight: 700;"><p>ALL</p></a>	
								</c:when>
								<c:otherwise>
									<a href="/itemList/category/all.do"><p>ALL</p></a>
								</c:otherwise>
							</c:choose>
						</li>
						<li>
							<c:choose>
								<c:when test="${'new' eq category }">
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
			
			<div class="item-list" style="width: 85%; display: inline-block; float: left; min-height: 400px;" >
			<h2 align="center" style="text-transform: uppercase;">${category }</h2>
				<ul>
					<c:if test="${empty itemList}">
						<h4 style="text-align: center; left: -15%">등록된 상품이 없습니다.</h4>
					</c:if>
					<c:if test="${itemList != null }">
						<c:forEach items="${itemList }" var="item">
							<li>
								<a href="/itemList/getItem.do?productNo=${item.productNo}&productCategory=${item.productCategory}" class="item">
									<ul>
										<li><img alt="" src="${item.uploadPath }"></li>
										<li><p>${item.productName }</p></li>
										<li><p><fmt:formatNumber maxFractionDigits="3" value="${item.productPrice }"></fmt:formatNumber>원</p></li>
										<li><p>Status</p></li>
									</ul>
								</a>
							</li>
						</c:forEach>
					</c:if>
				</ul>
			</div><!-- end item-list -->
		</div><!-- end Content -->
		<%@include file="include/footer.jsp"%>
	</div>
</body>
</html>