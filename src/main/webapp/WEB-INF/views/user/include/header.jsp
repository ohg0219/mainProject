<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<style type="text/css">

.rightMenu {
    position: fixed;
    bottom:190px;
    left: 40px;
    z-index: 100;
}
    
    
</style>
</head>  
<body>
<div class="header">
	<nav class="top_nav">
		<ul class="menu">
			<li><a href="/main.do"><img alt="" src="/resources/admin/img/mainlogo.png"></a></li>
			<li class="categoryMenu"><a href="/itemList/category/all.do" class="category">SHOP</a>
				<ul class="sub_category">
					<li><a href="/itemList/category/all.do"><p>ALL</p></a></li>
					<li><a href="/itemList/category/new.do"><p>NEW</p></a></li>
					
					<!-- ì¬ê¸°ë¥¼ ë©ë´  -->
					<c:forEach items="${menu }" var="menus">
						<li style="text-transform: uppercase;">
							<a href="/itemList/category/${menus }.do">${menus}</a>
						</li>
					</c:forEach>
				</ul></li>
			<li><a href="/notice.do">NOTICE</a></li>
			<li><a href="/event.do">EVENT</a></li>
		</ul>
		<div class="condition">
			<ul>
				<c:if test="${sessionScope.userId == null}"> 
					<li><a href="/login.do">LOGIN</a></li>					
				</c:if>
				<c:if test="${sessionScope.userId != null}"><!-- ë¡ê·¸ì¸í ì¬ì©ì -->
					<c:if test="${sessionScope.userId != null || sessionScope.kakaoUserId != null || sessionScope.naverUserId != null || sessionScope.googleUserId != null }">	
						<c:if test="${sessionScope.googleUserId != null }">
							<script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>
							<meta name="google-signin-client_id" content="619294176541-km5g9ed08619ijmirsaj6i4bsqife0dm.apps.googleusercontent.com">
							<li><a href="#" onclick="signOut();">LOGOUT</a></li>
							<script type="text/javascript">
							function signOut() {
							    var auth2 = gapi.auth2.getAuthInstance();
							    auth2.signOut().then(function () {
							      console.log('User signed out.');
							    });
							    window.location.href="http://ec2-13-124-128-58.ap-northeast-2.compute.amazonaws.com/googlelogout.do";
							  }
							function onLoad() {
							      gapi.load('auth2', function() {
							        gapi.auth2.init();
							      });
							    }
							</script>
						</c:if>
						<c:if test="${sessionScope.googleUserId == null }">
							<c:if test="${sessionScope.userId != null || sessionScope.kakaoUserId != null || sessionScope.naverUserId != null }">
								<li><a href="/logout.do">LOGOUT</a></li>
							</c:if>
						</c:if>	
						<li><a href="/mypage/mypage.do">MYPAGE</a></li>	
					</c:if>	
				</c:if>
				<li><a href="/orders.do">ORDERS</a></li>
				<li><a href="/basket.do">BAG</a></li>
			</ul>
		</div> 
		<br style="clear: both" />
	</nav>
	
	<div class="rightMenu" style="display:block;">
		<ul>
			<li>
				 <div style="font-size: 23px;">
				 	<a href="/basket.do" style="color:gray">
      					<i class="fas fa-cart-arrow-down"></i>
      				</a>
    			</div>
			</li>
			<li>
				<div style="font-size: 23px;">
					<a href="/recentView.do" style="color:gray">
						<i class="fas fa-history"></i>
					</a>
				</div>
			</li>
			<li>
				<div style="font-size: 23px; color:gray;">
					<a href="#" class="scrollTop" style="color:gray">
						<i class="fas fa-angle-up"></i>
					</a>
				</div>
			</li>
			<li>
				<div style="font-size: 23px; color:gray;">
					<a href="#" class="scrollBottom" style="color:gray;bottom" >
						<i class="fas fa-angle-down"></i>
					</a>
				</div>	
			</li>
		</ul>
	</div>
</div>

<!-- Scroll Top 맨 위로 이동 버튼 -->
<script>

$(document).ready(function(){

		$('.scrollTop').click(function(){
			$('html,body').animate({scrollTop:0},400);
				return false;
		});
	
		var scrollHeight = $(document).height();
		$('.scrollBottom').click(function(){
			$('html,body').animate({scrollTop: scrollHeight}, 400);
				return false;
		});
});



</script>
 </body>
</html>