<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thisisthat® 디스이즈댓</title>
<link rel="stylesheet" href="/resources/user/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/user/js/common.js"></script>
<style type="text/css">
	.leftItem{
		float: left;
		width: 100px;
		text-align: left;
		height: 30px;
	}
	.rightItem{
		float: right;
		width: 150px;
		text-align: left;
		height: 30px;	
		font-weight: 700;
	}
	.title{
		height: 50px;
		text-align: left;
	}
	#shopping{
		all:unset;
		border: 1px solid black;
		background-color: black;
		color: white;
		padding:7px 0px;
		cursor: pointer;
		text-align: center;
		width: 100%;
	}
</style>
<script type="text/javascript">

</script>
</head>
<body>
	<div class="wrap">
		<%@include file="../include/header.jsp" %>
		<div class="content">
			<div class="result" align="center" style="margin-top: 100px;">
				<div class="result_item" style="width: 250px;">
					<ul>
						<li class="title">주문이 완료되었습니다.</li>
						<li>
							<span class="leftItem">주문 번호</span>
							<span class="rightItem">${orderNo }</span>
						</li>
						<li>
							<span class="leftItem">주문 날짜</span>
							<span class="rightItem"><fmt:formatDate value="${orderDate}" pattern="yyyy-MM-dd HH:mm:ss"/> </span>
						</li>
					</ul>
					<hr>
					<p>
					주문내역 및 배송에 관한 안내는<br>주문조회를 통하여 확인 가능합니다.
					</p>
					<input id="shopping" type="button" onclick="location.href='/itemList/category/all.do'" value="계속 쇼핑하기">
				</div>
			</div>
		</div><!-- end Content -->
		<%@include file="../include/footer.jsp" %>
	</div>
</body>
</html>