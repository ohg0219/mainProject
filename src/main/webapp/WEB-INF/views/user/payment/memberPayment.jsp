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
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style type="text/css">
	.leftItem{
		float: left;
		width: 100px;
	}
	.rightItem{
		float: right;
		width: 180px;
		text-align: right;
	}
	.payment li{
		height: 30px;
	}
	.subTitle{
		font-weight: 700;
		margin-top: 30px;
	}
	.inputTitle{
		margin-top: 10px;
	}
	.input{
		all:unset;
		width: 100%;
		margin-bottom: 8px;
		border: 1px solid black;
	    border-collapse: collapse;
	    box-shadow: none;
	    border-radius: 0;
	    overflow: visible;
	    font-weight: normal;
	    padding: 7px 8px;
	}
	.otherInput{
		all:unset;
		margin-bottom: 3px;
		border: 1px solid black;
	    border-collapse: collapse;
	    box-shadow: none;
	    border-radius: 0;
	    overflow: visible;
	    font-weight: normal;
	    padding: 7px 8px;
	}
	label{
		height: 13px;
	}
	label>input{
		margin: 0;  vertical-align: middle;
		margin-right: 3px;
	}
	#addressBookBtn,#zipcodeBtn,#paymentBtn{
		all:unset;
		border: 1px solid black;
		background-color: black;
		color: white;
		padding: 7px;
		cursor: pointer;
		text-align: center;
	}
	#paymentBtn{
		padding: 7px 0px;
		width: 100%;
	}
	.input_tel {
	    border: none;
	    font-size: 11px;
	    width: 60px;
	    height: 22px;
	}
	#usePoint{
		all:unset;
		border: 1px solid black;
	    border-collapse: collapse;
	    box-shadow: none;
	    border-radius: 0;
		width:100px; 
		margin-left: 80px;
	}
	#selectPayment{
		text-decoration: underline;
		font-weight: 700;
	}
	.passbookName{
		all:unset;
		border: 1px solid black;
	    border-collapse: collapse;
	    box-shadow: none;
	    border-radius: 0;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		IMP.init('imp80941170');  // 가맹점 식별 코드
		var total = $("#totalPrice").text();
		var userPoint = $("#userPoint").val();
		$("#usePoint").on("blur",function(){
			var use = $("#usePoint").val();
			if(parseInt(use) > parseInt(userPoint)){
				$("#usePoint").val(0);
				alert("사용가능포인트보다 많은 포인트는 입력할 수 없습니다.");
				return false;
			}else{
				if(parseInt(use) > parseInt(total)){
					$("#usePoint").val(0);
					alert("결제금액보다 많은 포인트는 입력할 수 없습니다.");
					return false;
				}else{
					$("#totalPrice").text(total-use);
				}
			}
		});
		var form = document.payform;
		var product = $("#productList").val();
		var email = $("input[name=orderEmail]").val();
		var receiveName = $("input[name=receiveName]").val();
		var receiveZipcode = $("input[name=receiveZipcode]").val();
		var receiveFirstAddress =  $("input[name=receiveFirstAddress]").val();
		var receiveLastAddress = $("input[name=receiveLastAddress]").val();
		var phone1 = $("#phone1 option:selected").val();
		var phone2 = $("input[name=phone2]").val();
		var phone3 = $("input[name=phone3]").val();
		$("#newAddress").on("click",function(){
			$("input[name=receiveName]").val("");
			$("input[name=receiveZipcode]").val("");
			$("input[name=receiveFirstAddress]").val("");
			$("input[name=receiveLastAddress]").val("");
			$("input[name=phone2]").val("");
			$("input[name=phone3]").val("");
			$("#orderMessage").val("");
		});
		$("#beforeAddress").on("click",function(){
			$("input[name=receiveName]").val(receiveName);
			$("input[name=receiveZipcode]").val(receiveZipcode);
			$("input[name=receiveFirstAddress]").val(receiveFirstAddress);
			$("input[name=receiveLastAddress]").val(receiveLastAddress);
			$("input[name=phone2]").val(phone2);
			$("input[name=phone3]").val(phone3);
		});		
		
		$("#kakao").on("click",function(){
			$("#nonPassbookInfo").css("display","none");
		});
		$("#nonPassbook").on("click",function(){
			$("#nonPassbookInfo").css("display","block");
		});
		
		$("#paymentBtn").on("click",function(){
			
			
			if($("input[name=receiveName]").val()==''){
				alert("이름을 입력하세요."); return false;
			}
			if($("input[name=receiveZipcode]").val()==''||$("input[name=receiveFirstAddress]").val()==''||$("input[name=receiveLastAddress]").val()==''){
				alert("배송지를 입력하세요."); return false;
			}
			if($("input[name=phone2]").val()==''||$("input[name=phone3]").val()==''){
				alert("휴대전화를 입력하세요."); return false;
			}
			if($("input[name='orderSelect']:checked").val()=='무통장'){
				if($(".passbookName").val()==''){
					alert("입금자명을 입력하세요");
					return false;
				}else{
					$(".waiting").css("display","block");
				    form.submit();
				}
			}
			if($("#paymentAgree").is(":checked")==false){
				alert("결제정보 확인 및 구매진행에 동의하셔야 주문이 가능합니다.");
				return false;
			}
			if($("input[name='orderSelect']:checked").val()=='카카오페이'){
				IMP.request_pay({
				    pg : 'kakao', // 결제방식
				    pay_method : 'card',	// 결제 수단
				    merchant_uid : 'merchant_' + new Date().getTime(),
				    name : product,	// order 테이블에 들어갈 주문명 혹은 주문 번호
				    amount : total,	// 결제 금액
				    buyer_email : email,	// 구매자 email
				    buyer_name :  receiveName,	// 구매자 이름
				    buyer_tel :  phone1+phone2+phone3,	// 구매자 전화번호
				    buyer_addr :  receiveFirstAddress+receiveLastAddress,	// 구매자 주소
				    buyer_postcode :  receiveZipcode// 구매자 우편번호
				}, function(rsp) {
					if ( rsp.success ) { // 성공시
						var msg = '결제가 완료되었습니다.';
						msg += '고유ID : ' + rsp.imp_uid;
						msg += '상점 거래ID : ' + rsp.merchant_uid;
						msg += '결제 금액 : ' + rsp.paid_amount;
						msg += '카드 승인번호 : ' + rsp.apply_num;
						$(".waiting").css("display","block");
					    form.submit();
					} else { // 실패시
						var msg = '결제에 실패하였습니다.';
						msg += '에러내용 : ' + rsp.error_msg;
						$(".waiting").css("display","none");
					}
				});	
			}
		});
		$(".address_btn").on("click",function(e){
			e.preventDefault();
			DaumPostcode();
		});
		$("#addressBookBtn").on("click",function(){
			var userId = $("#userId").val();
			window.open("/addressBook.do?userId="+userId, "childForm", "width=800, height=350, resizable = no, scrollbars = no");
		});
		
	});
	function DaumPostcode() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            var addr = '';
	            var extraAddr = '';
	            if (data.userSelectedType === 'R') {
	                addr = data.roadAddress;
	            } else {
	                addr = data.jibunAddress;
	            }
	            if(data.userSelectedType === 'R'){
	                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                    extraAddr += data.bname;
	                }
	                if(data.buildingName !== '' && data.apartment === 'Y'){
	                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                }
	                if(extraAddr !== ''){
	                    extraAddr = ' (' + extraAddr + ')';
	                }
	            }
	            document.getElementById('zipcode').value = data.zonecode;
	            document.getElementById("address1").value = addr + extraAddr;
	            document.getElementById("address2").focus();
	        }
	    }).open();
	}//end postcode function
</script>
</head>
<body>
	<div class="waiting" style="display:none;position:fixed; z-index:99999; width: 100%;height: 100%;opacity:0.7; background-color: black">
		<div style="text-align: center; margin-top:200px;">
			<span style="background-color: white;padding: 10px;color:black;font-size: 20px; font-weight: 700">결제가 진행중입니다. 잠시만 기다려주세요.</span>
		</div>
	</div>
	<div class="wrap">
		<%@include file="../include/header.jsp" %>
		<div class="content" style="margin-top: 100px; ">
			<form style="width: 100%;display: flex;" action="/memberPayment.do" method="post" name="payform">
				<input type="hidden" value="${productList}" id="productList">
				<input type="hidden" value="${sessionScope.userId}" id="userId">
				<div class="divide" style="flex: 1; vertical-align: middle;">
					<div class="shipping" style=" width: 250px; float: right; margin-right: 60px;">
						<ul>
							<li class="subTitle">주문자정보</li>
							<li class="inputTitle">E-MAIL</li>
							<li class="inputContent">
								<input class="input" type="email" name="orderEmail" value="${userInfo.userEmail}">
							</li>
							
						</ul>
						<ul>
							<li class="subTitle">배송정보</li>
							<li>&nbsp;</li>
							<li>
								<label><input type="radio" id="beforeAddress" name="addressSelect" value="beforeAddress">기본 주소</label>
								<label><input type="radio" id="newAddress" name="addressSelect" value="newAddress">새로 입력</label>
								&nbsp;&nbsp;&nbsp;<input id="addressBookBtn" type="button" value="주소록" name="addressBook">
							</li>
							<li class="inputTitle">이름</li>
							<li class="inputContent">
								<input class="input" type="text" name="receiveName" value="${userInfo.userName }">
							</li>
							<li class="inputTitle">주소</li>
							<li class="inputContent">
								<input size="6" class="zipcode otherInput" type="text" name="receiveZipcode" id="zipcode" readonly="readonly" value="${userInfo.zipCode }">
								<input type="button" id="zipcodeBtn" class="address_btn" value="우편번호">	
							</li>
							<li>
								<input class="address_ input" type="text" name="receiveFirstAddress" id="address1" value="${userInfo.firstAddress}">
							</li>
							<li>
								<input class="address_ input" type="text" name="receiveLastAddress" id="address2" value="${userInfo.lastAddress}">
							</li>
							<li class="inputTitle">휴대전화</li>
							<li class="input_li z" >
								<select class="input_tel" name="phone1" id="phone1">
									<option <c:if test="${userInfo.phone1=='010' }">selected</c:if>>010</option>
									<option <c:if test="${userInfo.phone1=='011' }">selected</c:if>>011</option>
									<option <c:if test="${userInfo.phone1=='016' }">selected</c:if>>016</option>
									<option <c:if test="${userInfo.phone1=='017' }">selected</c:if>>017</option>
									<option <c:if test="${userInfo.phone1=='018' }">selected</c:if>>018</option>
									<option <c:if test="${userInfo.phone1=='019' }">selected</c:if>>019</option>
								</select>
								<span>-</span>
								<input class="input_phone otherInput" type="tel" name="phone2" size="4" value="${userInfo.phone2 }">
								<span>-</span>
								<input class="input_phone otherInput" type="tel" name="phone3" size="4" value="${userInfo.phone3 }">
								<span id="phoneCheck" style="display: block;"></span>
							</li>
							<li class="inputTitle">배송메시지</li>
							<li class="inputContent">
								<textarea class="input" id="orderMessage" name="orderMessage"></textarea>
							</li>
						</ul>
					</div>
				</div>
				<div class="divide" style="flex: 1;vertical-align: middle;">
					<div class="payment" style="width: 280px; float: left;margin-left: 60px;">
						<ul>
							<li class="subTitle">결제정보</li>
							<li>
								<span class="leftItem">배송비</span>
								<span class="rightItem">&#8361;<span>0</span></span>
							</li>
							<li>
								<span class="leftItem">할인 금액</span>
								<span class="rightItem">&#8361;<span>0</span></span>
							</li>
							<li>
								<span class="leftItem">포인트</span>
								<div class="rightItem">
								<c:if test="${userPoint != null }">
									<input type="text" id="usePoint"  name="usePoint" value="0" >
								</c:if>
								<span>사용가능 포인트 : ₩ <fmt:formatNumber maxFractionDigits="3" value="${userPoint }"/></span>
								<input type="hidden" id="userPoint" value="${userPoint }">
								</div>
							</li>
						</ul>
						<hr>
						<ul>
							<li>
								<span class="leftItem">적립예정포인트</span>
								<span class="rightItem"><span><fmt:formatNumber maxFractionDigits="3" value="${basketPoint }"/></span>P</span>
							</li>
						</ul>
						<hr>
						<ul>
							<li>
								<span class="leftItem">SUBTOTAL</span>
								<span class="rightItem">&#8361;
									<c:if test="${subTotal != null }">
									<span><fmt:formatNumber maxFractionDigits="3" value="${subTotal }"/></span>
									</c:if>
									<c:if test="${subTotal == null }">
										
									</c:if>
								</span>
							</li>
							<li>
								<span class="leftItem">할인 금액</span>
								<span class="rightItem">&#8361;<span>0</span></span>
							</li>
							<li>
								<span class="leftItem">TOTAL</span>
								<span class="rightItem">&#8361; <span><fmt:formatNumber maxFractionDigits="3" value="${subTotal }"/></span></span>
							</li>
						</ul>
						<hr>
						<ul>
							<li style="font-weight: 700">결제수단</li>
							<li>
								<label><input type="radio" id="kakao" name="orderSelect" checked="checked" value="카카오페이">카카오페이</label>
								<label><input type="radio" id="nonPassbook" name="orderSelect" value="무통장">무통장 입금</label>
							</li>
							<!-- 무통장입금 선택시 보이기 -->
							<li id="nonPassbookInfo" style="height: 50px; display: none;">
								<span class="leftItem" style="height: 25px;">입금자명</span>
								<span class="rightItem" style="height: 25px;"><input class="passbookName" type="text" name="passbookName"></span>
								<span class="leftItem" style="height: 25px">입금은행</span>
								<span class="rightItem"><select><option>XX은행:123-123456-1234</option></select></span>
							</li>
							<!-- end 무통장 -->
						</ul>
						<hr>
						<ul>
							<li>
								<span class="leftItem">TOTAL</span>
								<span class="rightItem">&#8361; <span id="totalPrice">${subTotal }</span></span>
							</li>
						</ul>
						<hr>
						<label><input id="paymentAgree" type="checkbox">결제정보를 확인하였으며, 구매진행에 동의합니다.</label>
						<br><br>
						<input id="paymentBtn" type="button" value="결제 진행">
					</div>
				</div>
				
				<input type="hidden" name="originalPrice" value="${subTotal }">
			</form>
		</div><!-- end Content -->
		<%@include file="../include/footer.jsp" %>
	</div>
</body>
</html>