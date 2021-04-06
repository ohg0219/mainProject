<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thisisthat® MyPage</title>
<link rel="stylesheet" href="/resources/user/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/resources/user/js/common.js"></script>
<style type="text/css">
#m19 {
    position: absolute;
    top: 0;
    left: 0;
    display: block;
    width: 100%;
    height: 100%;
    background: transparent;
}

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
#myshopMain .xans-layout-statelogon a.btnlogin {
    position: relative;
    display: inline-block;
    font-size: 10px !important;
    background: transparent !important;
    border-radius: 0px;
    padding: 0 0 2px;
    height: auto !important;
    color: #111;
    margin: 0 0;
    text-decoration: none;
    border-bottom: 1px solid #111;
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
}

#myshopMain .xans-layout-statelogon {
    vertical-align: top;
}

#myshopMain .xans-layout-statelogon {
    position: absolute;
    top: 0;
    right: 20px;
    margin: 0 0;
    z-index: 299;
    width: auto;
}

.w-2 {
    margin: 0 auto;
    *zoom: 1;
    width: 50%;
    max-width: 720px;
    min-width: 560px;
    padding: 0 20px !important;
}
.w-1, .w-2, .w-3 {
    box-sizing: border-box;
    display: block;
}
.xans-myshop-benefit {
    margin: 0 0 40px;
}

.xans-myshop-benefit .infoWrap {
    overflow: hidden;
    padding: 0;
    color: #111;
}

.xans-myshop-benefit .myInfo {
    padding: 0;
    font-size: 11px;
}	
.xans-myshop-bankbook {
    overflow: hidden;
    padding: 0;
    border: 0;
    background: transparent;
    width: 100%;
    margin: 0 auto 0;
    display: ;
    margin-top: 20px;
}

.xans-myshop-bankbook li .use {
    color: #111;
    font-size: 10px;
}
.xans-myshop-bankbook li .data {
    float: right;
    width: 35%;
    text-align: right;
    margin-right: 52px;
    font-size: 11px;
    font-weight: 400;
}
.xans-myshop-bankbook li strong {
    font-size: 11px;
}

.xans-myshop-bankbook li {
    display: inline-block;
    position: relative;
    overflow: auto;
    width: 40%;
    margin-right: 10%;
    line-height: 1.7;
    float: left;
    vertical-align: top;
    *display: inline;
    *zoom: 1;
    padding: 5px 0;
    font-size: 11px;
}

.xans-myshop-bankbook li .title {
    float: left;
    width: 40%;
    font-weight: normal;
    color: #111;
    font-size: 11px;
    font-weight: 400;
    padding-bottom: 4px;
    border-bottom: 1px solid #eee;
}

.xans-myshop-benefit .infoWrap {
    overflow: hidden;
    padding: 0;
    color: #111;
}

ul li {
    list-style: none;
    margin: 0 0;
}

li a.dual {
    width: auto;
    background: #fff;
    border-color: #111;
    font-weight: 400;
    line-height: 1.3;
}

.xans-myshop-bankbook li {
    display: inline-block;
    position: relative;
    overflow: auto;
    width: 40%;
    margin-right: 10%;
    line-height: 1.7;
    float: left;
    vertical-align: top;
    *display: inline;
    *zoom: 1;
    padding: 5px 0;
    font-size: 11px;
}
.xans-myshop-bankbook li a {
    position: absolute;
    right: 4px;
}

a.dual {
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
.info {
	float: center;
	width: 250px;
}
#boxsize a{
	text-decoration: none;
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
					<div id="myshopMain" class="xans-element- xans-myshop xans-myshop-main ">
						<div class="loginstate">
            			    <p class="xans-element- xans-layout xans-layout-statelogon ">
            			    	<a href="/exec/front/Member/logout/" class="btnlogin log" id="bigin-logout">logout</a>
								<!-- GTM FOR BIGIN START-->
								<script>
                    				document.querySelector('#bigin-logout').addEventListener('click',function(){
                        				dataLayer.push(
                            			{'data': undefined},
                            			{'event': "logout"});
                    				})
                				</script>
								<!-- GTM FOR BIGIN END-->
							</p>
        				</div>
        				<div id="boxsize">
       				    	<a href="/mypage/mypage.do" class="sltd"><strong>my</strong></a>
            				<a href="/mypage/modify.do">profile</a>
            				<a href="/mypage/address.do">address book</a>
							<a href="/mypage/orderlist.do">orders</a>
            				<a href="/mypage/point.do">point</a>
            				<a href="/mypage/coupon.do">coupon</a>
        				</div>
					</div>
				<div class="w-2">
        	    	<div class="xans-element- xans-myshop xans-myshop-benefit">
        	    		<div class="infoWrap">
                			<div class="myInfo">
                				<strong class="name"><span>${namePoint.nick_name }</span></strong>
                    			<strong class="group">[${namePoint.user_name }]</strong>
               				</div>
               			</div>
               		</div>
               		
   					<div class="xans-element- xans-myshop xans-myshop-bankbook">
   					<ul>
						<li class=" ">
                			<strong class="title">총 포인트</strong>
                			<strong class="data use">${totalPoint.sum }P</strong>
            			</li>
            			<li class="">
                			<strong class="title">사용가능 포인트</strong>
                			<strong class="data">${pointSum.sum }P</strong>
            			</li>
            			<li class="">
                			<strong class="title">사용된 포인트</strong>
                			<strong class="data">${usingSum.sum }P</strong>
            			</li>
            			<li class="etc">
                			<strong class="title">미가용 포인트</strong>
                			<strong class="data">0(0회)</strong>
            			</li>
            			<li class="etc ">
                			<strong class="title">환불예정 포인트</strong>
                			<strong class="data">1</strong>
            			</li>
        			 </ul>
        			 </div>
        			 	<table align="center" border="1" width="550">
        			 		<tr hight="500">
        			 			<td colspan="4" align="center">
			        			 	<strong class="title">적립내역 보기</strong>
        			 			</td>
        			 		</tr>
        			 		<tr hight="500">
		        			 	<td align="center">주문날짜</td>
		        			 	<td align="center">포인트</td>
		        			 	<td align="center">관련 주문</td>
		        			 	<td align="center">적립 내용</td>
        			 		</tr>
        			 		<c:forEach var="article" items="${article }">
	        			 		<tr hight="500">
    	    			 			<td align="center"><fmt:formatDate value="${article.point_date }" pattern="yyyy-MM-dd "/></td>
    	    			 			<td align="center">${article.point}</td>
    	    			 			<td align="center"></td>
    	    			 			<td align="center">${article.point_content}</td>
        				 		</tr>
        			 		</c:forEach>
        			 	</table>        			 	
        			 </div> 
			   		</div>
		    	</div>
     		</div>
			<%@include file="../include/footer.jsp"%>
		</div>
	</div>
</body>
</html>