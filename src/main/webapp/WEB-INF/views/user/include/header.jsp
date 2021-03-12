<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="header">
	<nav class="top_nav">
		<ul class="menu">
			<li><a href="/main.do"><img alt="" src="/resources/user/image/mainlogo.png"></a></li>
			<li class="categoryMenu"><a href="/shop/list/all.do" class="category">SHOP</a>
				<ul class="sub_category">
					<li><a href="/shop/list/all.do"><p>ALL</p></a></li>
					<li><a href="/shop/list/new.do"><p>NEW</p></a></li>
					<li><a href="/shop/list/jackets.do"><p>JACKETS</p></a></li>
					<li><a href="/shop/list/shirts.do"><p>SHIRTS</p></a></li>
					<li><a href="/shop/list/longsleevetees.do"><p>LONG SLEEVE TEES</p></a></li>
					<li><a href="/shop/list/tees.do"><p>TEES</p></a></li>
					<li><a href="/shop/list/pants.do"><p>PANTS</p></a></li>
					<li><a href="/shop/list/jeans.do"><p>JEANS</p></a></li>
				</ul></li>
			<li><a href="#">LOOK BOOK</a></li>
			<li><a href="#">ARCHIVE</a></li>
		</ul>
		<div class="condition">
			<ul>
				<c:if test="${sessionScope.userId == null && sessionScope.kakaoUserId == null && sessionScope.naverUserId == null && sessionScope.googleUserId == null}"> 
					<li><a href="/login.do">LOGIN</a></li>					
				</c:if>
				<c:if test="${sessionScope.userId != null || sessionScope.kakaoUserId != null || sessionScope.naverUserId != null || sessionScope.googleUserId != null}"><!-- 로그인한 사용자 -->
					<c:if test="${sessionScope.googleUserId != null }">
						<script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>
						<meta name="google-signin-client_id" content="619294176541-km5g9ed08619ijmirsaj6i4bsqife0dm.apps.googleusercontent.com">
						<li><a href="#" onclick="signOut();">Sign out</a></li>
						<script type="text/javascript">
						function signOut() {
						    var auth2 = gapi.auth2.getAuthInstance();
						    auth2.signOut().then(function () {
						      console.log('User signed out.');
						    });
						    window.location.href="http://localhost:8080/googlelogout.do";
						  }
						function onLoad() {
						      gapi.load('auth2', function() {
						        gapi.auth2.init();
						      });
						    }
						
						</script>
					</c:if>
					<c:if test="${sessionScope.userId != null || sessionScope.kakaoUserId != null || sessionScope.naverUserId != null }">
						<li><a href="/logout.do">LOGOUT</a></li>
					</c:if>
					<li><a href="/mypage.do">MYPAGE</a></li>	
				</c:if>
				<li><a href="#">ORDERS</a></li>
				<li><a href="#">BAG</a></li>
			</ul>
		</div> 
		<br style="clear: both" />
	</nav>
</div>