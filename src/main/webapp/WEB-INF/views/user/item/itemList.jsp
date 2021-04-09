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
	.soldout{
		opacity: 0.5;
	}
	.orderSelect{
		all:unset;
		border: 1px solid black;
		padding: 10px;
		cursor: pointer;
	}
	.orderSelect:hover{
		color: white;
		background-color: black;
	}
	.orderSelected{
		color: white;
		background-color: black;
	}
	.search{
		border: 1px solid black;
		padding: 12px;
	}
	#keyword{
		all : unset;
		border: 1px solid black;
		padding: 4px;
	}
	#searchBtn{
		all:unset;
		border: 1px solid black;
		padding : 4px;
		cursor: pointer;
	}
	#searchBtn:hover{
		color: white;
		background-color: black;
	}
	.pageBtn{
		padding: 8px;
		border: 1px solid black;
		text-decoration: none;
	}
	.pageBtn:hover{
		background-color: black;
		color: white;
	}
	.nowpageBtn{
		padding: 8px;
		border: 1px solid black;
		text-decoration: none;
		background-color: black;
		color: white;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		var category = $("#category").text();
		$("#new").on("click",function(){
			var keyword = $("#keyword").val();
			location.href="/itemList/category/"+category+".do?select=new&keyword="+keyword;
		});
		$("#sales").on("click",function(){
			var keyword = $("#keyword").val();
			location.href="/itemList/category/"+category+".do?select=sales&keyword="+keyword;
		});
		$("#keyword").keydown(function(key) {
	        if (key.keyCode == 13) {
	        	var select = $("#select").val();
				var keyword = $("#keyword").val();
				if(keyword == ''){
					return false;
				}
				location.href="/itemList/category/searchItem.do?select="+select+"&keyword="+keyword;
	        }
		});
		$("#searchBtn").on("click",function(){
			var select = $("#select").val();
			var keyword = $("#keyword").val();
			if(keyword == ''){
				return false;
			}
			location.href="/itemList/category/searchItem.do?select="+select+"&keyword="+keyword;
		});
	});
</script>
</head>
<body>
	<div class="wrap">
		<%@include file="../include/header.jsp"%>
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
			<div>
				<h2 align="center" id="category" style="text-transform: uppercase;">${category }</h2>
				<div style="display:<c:if test="${category == 'new' }">none;</c:if>">
					<input class="orderSelect <c:if test="${select == 'new' }">orderSelected</c:if> " id="new" type="button" value="최신순" >
					<input class="orderSelect <c:if test="${select == 'sales' }">orderSelected</c:if>" id="sales" type="button" value="판매순">
					<input id="select" type="hidden" value="${select }">
					<span class="search">
						<input id="keyword" type="text" name="search" placeholder="상품명" value="${keyword }">&nbsp;<input id="searchBtn" type="button" value="검색">
					</span>
				</div>
			</div>
				<ul>
					<c:if test="${empty itemList}">
						<h4 style="text-align: center; left: -15%">등록된 상품이 없습니다.</h4>
					</c:if>
					<c:if test="${itemList != null }">
						<c:forEach items="${itemList }" var="item">
							<li class="<c:if test='${item.productStockTotal == 0 }'>soldout</c:if>">
								<a href="/itemList/getItem.do?productNo=${item.productNo}&productCategory=${item.productCategory}" class="item">
									<ul>
										<li><img alt="" src="${item.uploadPath }"></li>
										<li><p>${item.productName }</p></li>
										<li><p>&#8361; <fmt:formatNumber maxFractionDigits="3" value="${item.productPrice }"></fmt:formatNumber>원</p></li>
										<li>
											<c:choose>
												<c:when test="${item.productStockTotal == 0 }">
													<p style="color: red;">품절</p>
												</c:when>
												<c:otherwise>
													&nbsp;
												</c:otherwise>
											</c:choose>
										</li>
									</ul>
								</a>
							</li>
						</c:forEach>
					</c:if>
				</ul>
				<c:if test="${category != 'new'}">
				<div align="center" style="clear:both; padding-top:40px;">
					<c:if test="${paging.startPage != 1 }">
						<a class="pageBtn" href="/itemList/category/${category}.do?nowPage=${paging.startPage - 1 }&select=${select}">&lt;</a>
					</c:if>
					<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
						<c:choose>
							<c:when test="${p == paging.nowPage }">
								<b class="nowpageBtn">${p }</b>
							</c:when>
							<c:when test="${p != paging.nowPage }">
								<a class="pageBtn" href="/itemList/category/${category}.do?nowPage=${p }&select=${select}">${p }</a>
							</c:when>
						</c:choose>
					</c:forEach>
					<c:if test="${paging.endPage != paging.lastPage}">
						<a class="pageBtn" href="/itemList/category/${category}.do?nowPage=${paging.endPage+1 }&select=${select}">&gt;</a>
					</c:if>
				</div>
				</c:if>
			</div><!-- end item-list -->
		</div><!-- end Content -->
		<%@include file="../include/footer.jsp"%>
	</div>
</body>
</html>