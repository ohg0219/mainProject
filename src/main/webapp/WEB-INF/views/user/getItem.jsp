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
</style>
</head>
<body>
	<div class="wrap">
		<%@include file="include/header.jsp"%>
		<div class="content">
			<div class="side-bar" style="width:15%; display: inline-block; float: left; margin-top:50px">
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
			
				<h2 align="center" style="text-transform: uppercase;">${category }</h2>
				
				<div style="float: left; width:calc(75% - 210px);">
					<ul>
						<li style="width:50%; display: inline-block; float: left; padding: 5px; box-sizing: border-box; min-width: 200px;">
							<img width="100%" src="/resources/user/image/jackets_ex.jpg">
						</li>
						<li style="width:50%; display: inline-block; float: left; padding: 5px; box-sizing: border-box; min-width: 200px;">
							<img width="100%" src="/resources/user/image/pants_ex.jpg">
						</li>
						<li style="width:50%; display: inline-block; float: left; padding: 5px; box-sizing: border-box; min-width: 200px;">
							<img width="100%" src="/resources/user/image/pants_ex.jpg">
						</li>
						<li style="width:50%; display: inline-block; float: left; padding: 5px; box-sizing: border-box; min-width: 200px;">
							<img width="100%" src="/resources/user/image/pants_ex.jpg">
						</li>
					</ul>
				</div>
				<div style="position:relative; width:calc(10% + 210px); float:left; ">
					<div class="item_info" style="margin-left: 20px;">
						<ul>
							<li><strong style="font-size: 12px;">상품명</strong><br><br></li>
							
							<li>가격<br><br></li>
							<li>소재정보</li>
							<li>원산지</li>
						</ul>
						<div>
							<ul>
								<li class="size_selection"><a href="#">XS</a></li>
								<li class="size_selection"><a href="#">S</a></li>
								<li class="size_selection"><a href="#">M</a></li>
								<li class="size_selection"><a href="#">L</a></li>
								<li class="size_selection"><a href="#">XL</a></li>
								
							</ul>
						</div>
					</div>
				</div>
			
		</div><!-- end Content -->
		<%@include file="include/footer.jsp"%>
	</div>
</body>
</html>