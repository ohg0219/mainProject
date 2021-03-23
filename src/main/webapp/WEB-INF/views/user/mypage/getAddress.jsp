
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thisisthat® 디스이즈댓</title>
<link rel="stylesheet" href="/resources/user/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/user/js/common.js"></script>
<style type="text/css">
.wrap {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: transparent;
	margin-top: 50px;
}

#container {
	width: 100%;
	max-width: 100%;
	margin: 0 auto;
}

#contents {
	position: relative;
	display: block;
	box-sizing: border-box;
	width: 100%;
}

.inr {
	position: relative;
	display: block;
	box-sizing: border-box;
	width: 100%;
	height: auto;
	padding: 0 20px;
}

#myshopMain {
	display: block;
	position: relative;
	width: 50%;
	max-width: 720px;
	min-width: 560px;
	margin: 80px auto 40px;
	box-sizing: border-box;
	padding: 0 20px;
}

#myshopMain #boxsize {
	margin: 0 0;
	width: 100%;
	border-bottom: 1px solid #eee;
	overflow: auto;
	padding: 0 0 20px;
}

#myshopMain a {
	display: inline-block;
	cursor: pointer;
	width: auto;
	padding: 0 0;
	border-radius: 0px;
	background: transparent;
	color: #111;
	text-transform: uppercase;
	text-align: center;
	font-size: 10px;
	float: left;
	margin-right: 20px;
	margin-bottom: 8px;
	text-decoration: none;
}

.w-1 {
	margin: 0 auto;
	width: 50%;
	max-width: 720px;
	min-width: 560px;
	min-height: 500px;
	padding: 0 20px !important;
}

.w-1 .w-2 {
	padding: 0 20px !important;
}

.w-1 .w-2 .addressList {
	margin-top: 20px;
}
.w-1 .w-2 .addressList p{
    font-size: 11px;
    line-height: 1.5;
    letter-spacing: 0.05em;
    color: #111;
    margin-bottom: 40px;
}

.boardList {
	border: 0;
}

.table {
	width: 100%;
    border: 0;
    border-spacing: 0;
    border-collapse: collapse;
}

tbody {
    display: table-row-group;
    vertical-align: middle;
    border-color: inherit;
}

.boardList tr {
    display: inline-block;
    float: left;
    width: 50%;
    margin-bottom: 12px;
    height: 228px;
}

.boardList td.empty {
    padding: 40px 0;
    text-align: center;
    font-size: 11px;
    line-height: 1.5;
    letter-spacing: 0.05em;
    color: #999;
}

.boardList td{
    width: 440px;
}

.btnAdd {
    overflow: hidden;
    padding: 0;
    margin-top: 20px;
}

.btn-1 {
    display: inline-block;
    float: right;
    cursor: pointer;
    width: auto;
    height: auto;
    border-radius: 3px;
    box-sizing: border-box;
    font-size: 11px;
    line-height: 16px;
    letter-spacing: 0.05em;
    text-align: center;
    background: #fff;
    color: #111;
    margin-top: 0px;
    clear: none;
    border: 1px solid #111;
    padding: 1px 48px;
}


</style>
</head>
<body>
	<div class="wraped">
		<%@include file="../include/header.jsp"%>
		<div id="wrap">
			<div id="container">
				<div id="contents">
					<div class="inr">
						<div id="myshopMain"
							class="xans-element- xans-myshop xans-myshop-main ">
							<div id="boxsize">
								<a href="/mypage/mypage.do" class="sltd">my</a>
								<a href="/mypage/modify.do">profile</a> 
								<a href="/mypage/address.do"><strong>address book</strong></a> 
								<a href="/mypage/orderlist.do">orders</a>
								<a href="/mypage/point.do">point</a> <a href="/mypage/coupon.do">coupon</a>
							</div>
						</div>
						<div class="w-1">
							<div class="w-2">
								<div class="addressList">
									<p>자주 쓰는 배송지를 관리하실 수 있습니다.</p>
									<div class="boardList">
										<table border="0">
											<thead class>
											</thead>
											<tbody class>
												<tr>
													<td colspan="1" class="empty">등록된 주소가 없습니다.</td>
												</tr>
											</tbody>
										</table> 
									</div>
									<div class="btnAdd">
										
										<a href="#" class="btn-1">새 주소 추가</a>
									
									</div>
									
									
								</div>
								




							</div>
						</div>
					</div>
				</div>
			</div>
			<%@include file="../include/footer.jsp"%>
		</div>
	</div>
</body>
</html>