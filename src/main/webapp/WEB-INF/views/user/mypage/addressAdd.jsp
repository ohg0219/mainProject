<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thisisthat® 디스이즈댓</title>
<link rel="stylesheet" href="/resources/user/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/user/js/common.js"></script>
<script src="/resources/user/js/address.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style type="text/css">
.wrap {
	position: relative;
    width: 100%;
    margin: 0 auto;
}

#container {
	width: 100%;
    max-width: 100%;
    min-height: 360px;
    margin: 0 auto;
}

#contents {
	position: relative;
    display: block;
    box-sizing: border-box;
    width: 100%;
    top: 100px;
    min-height: 480px;
}

.inr {
	position: relative;
    display: block;
    box-sizing: border-box;
    width: 100%;
    height: auto;
    padding: 0 20px;
}

.w-1 {
	margin: 0 auto;
}

.titleArea {
    margin: 0 0;
    position: fixed;
    top: 92px;
    z-index: 99;
    left: 20px;
    width: 25%;
    display: none;
}

.inx {
    position: relative;
    padding: 0 20px !important;
}

.addressInput {
	width: 320px;
	margin: 0 auto;
}

.addressTop {
	width: 100%;
	margin-top: 60px;
}

table {
	border: 0;
}

.addressTop th{
	border-top: 0;
}

.addressTop th {
	width: 80px;
	text-align: left;
	padding: 4px 0 12px;
	padding-right: 20px;
	vertical-align: middle;
	font-size: 11px;
	font-weight: 400 !important;
}

th {
	border: 0;
}

td {
	border: 0;
	width: auto;
	border-top: 0;
	padding: 4px 0 12px;	
}

.addressTop input {
	border: 0;
	border-bottom: 1px solid #111;
	margin-bottom: 4px;
	padding: 2px 6px
}

.inputTypeText {
	width: 100%;
}

table {
	table-layout: fixed;
}

#zipcode {
	width : 60px;
}

.address_btn {
    display: inline-block;
    cursor: pointer;
    width: auto;
    height: auto;
    border-radius: 1px;
    margin-top: 0;
    margin-left: 4px;
    background: transparent;
    color: #111;
    background: #ccc;
    border: 1px solid #eee;
    text-align: center;
    padding: 1px 8px;
    font-size: 10px;
}

option {
	font-weight: normal;
    display: block;
    white-space: nowrap;
    min-height: 1.2em;
    padding: 0px 2px 1px;
    border: 0;
    font-size: 10px;
}

#user_phone1 {
	width: 50px;
	margin: 0 2px;
}


 #user_phone2, #user_phone3 {
	width: 48px;
	margin: 0 2px;
}

.btnArea {
	margin-top: 20px; 
	text-align: center;
}

.btnArea a{
	display: inline-block;
    float: right;
    cursor: pointer;
    width: auto;
    height: auto;
    margin: 0 0 0;
    border-radius: 3px;
    box-sizing: border-box;
    background: #fff;
    color: #111;
    left: 0 !important;
    border: 1px solid #111;
    text-align: center;
    padding: 0 40px;
    font-size: 10px;
    line-height: 16px;
    letter-spacing: 0.05em;
}
.btn-1{
	all:unset;
	padding:8px;
	border: 1px solid black;
	cursor: pointer;
}
.btn-1:hover{
	background-color: black;
	color: white;
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
						<div class="w-1">
							<div class="inx">
								<form action="/addressInsert.do" id="" method="post">
									<div class="addressInput">
										<div class="addressTop">
											<table border="1">
												<tbody>
													<tr>
														<td>
															<input type="hidden" id="address_no" name="address_no" value="${address.addressNo}">
														</td>
													</tr>
													<tr>
														<th scope="row">배송지</th>
														<td>
															<input id="address_name" name="addressName" type="text" >							
														</td>
													</tr>
													<tr>
														<th scope="row">이름</th>
														<td>
															<input id="user_name" name="receiveName" type="text">							
														</td>
													</tr>
													<tr>
														<th scope="row">주소</th>
														<td>
															<input id="zipcode" name="zipCode" id="zipcode" type="text" maxlength="14">
																<button class="address_btn">우편번호</button>	
															<input id="address1" name="firstAddress" id="address1" type="text" class="inputTypeText" >	
															<input id="address2" name="lastAddress" id="address2" type="text" class="inputTypeText" >																						
														</td>
													</tr>
													<tr>
														<th scope="row">휴대전화</th>
														<td>
															<select id="user_phone1" name="userPhone1" style="border:0;">	
																<option>010</option>
																<option>011</option>
																<option>016</option>
																<option>017</option>
																<option>018</option>
																<option>019</option>
															</select>				
															 -		
															<input id="user_phone2" name="userPhone2" type="text">							
															 -
															<input id="user_phone3" name="userPhone3" type="text">							
														</td>														
													</tr>
												</tbody>											
											</table>
										</div>
										<div class="btnArea">
											<input type="submit" class="btn-1" value="save">
										</div>
									</div>
								</form>	
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