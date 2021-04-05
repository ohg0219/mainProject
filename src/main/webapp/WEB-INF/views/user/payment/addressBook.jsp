<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/resources/user/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/user/js/common.js"></script>
<style type="text/css">
	input{
		all:unset;
		border: 1px solid black;
		background-color: black;
		color: white;
		padding: 7px;
		cursor: pointer;
		text-align: center;
	}
</style>
<title>주소록</title>
</head>
<body>
	<div align="right">
		<input type="button" value="창 닫기" onclick="window.close()">
	</div>
	<h3 align="center">내 배송지 목록</h3>
	<table style="width: 90%;margin:0 auto; border-collapse: collapse;" border="1">
		<tr align="center">
			<td>배송지</td>
			<td>이름</td>
			<td>우편번호</td>
			<td>주소</td>
			<td>상세주소</td>
			<td colspan="3">핸드폰</td>
			<td>선택</td>
		</tr>
		<c:forEach items="${addressList}" var="address">
		<tr align="center">
			<td class="addressName">${address.addressName }</td>
			<td class="receiveName">${address.receiveName }</td>
			<td class="zipcode">${address.zipcode }</td>
			<td class="firstAddress">${address.firstAddress}</td>
			<td class="lastAddress">${address.lastAddress}</td>
			<td class="phone1">${address.phone1 }</td>
			<td class="phone2">${address.phone2 }</td>
			<td class="phone3">${address.phone3 }</td>
			<td>
				<input type="button" value="선택" class="addressSelect" >
			</td>
		</tr>
		</c:forEach>
	</table>
	<script type="text/javascript">
		$(".addressSelect").on("click", function(){
			var addressName = $(this).closest('tr').find('.addressName').html();
			var receiveName = $(this).closest('tr').find('.receiveName').html();
			var zipcode = $(this).closest('tr').find('.zipcode').html();
			var firstAddress = $(this).closest('tr').find('.firstAddress').html();
			var lastAddress = $(this).closest('tr').find('.lastAddress').html();
			var phone1 = $(this).closest('tr').find('.phone1').html();
			var phone2 = $(this).closest('tr').find('.phone2').html();
			var phone3 = $(this).closest('tr').find('.phone3').html();
			$(opener.document).find("input[name=receiveName]").val(receiveName);
			$(opener.document).find("input[name=receiveZipcode]").val(zipcode);
			$(opener.document).find("input[name=receiveFirstAddress]").val(firstAddress);
			$(opener.document).find("input[name=receiveLastAddress]").val(lastAddress);
			$(opener.document).find("#phone1").val(phone1).prop("selected", true);
			$(opener.document).find("input[name=phone2]").val(phone2);
			$(opener.document).find("input[name=phone3]").val(phone3);
			window.close();
	    });
	</script>

</body>
</html>