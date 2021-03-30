<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="header">
	<nav class="top_nav">
		<ul class="menu">
			<li><a href="/main.do"><img alt="" src="/resources/admin/img/mainlogo.png"></a></li>
			<li class="categoryMenu"><a href="/itemList/category/all.do" class="category">SHOP</a>
				<ul class="sub_category">
					<li><a href="/itemList/category/all.do"><p>ALL</p></a></li>
					<li><a href="/itemList/category/new.do"><p>NEW</p></a></li>
					
					<!-- 여기를 메뉴  -->
					<c:forEach items="${menu }" var="menus">
						<li style="text-transform: uppercase;">
							<a href="/itemList/category/${menus }.do">${menus}</a>
						</li>
					</c:forEach>
				</ul></li>
			<li><a href="#">LOOK BOOK</a></li>
			<li><a href="#">ARCHIVE</a></li>
		</ul>
		<div class="condition">
			<ul>
				<c:if test="${sessionScope.userId == null}"> 
					<li><a href="/login.do">LOGIN</a></li>					
				</c:if>
				<c:if test="${sessionScope.userId != null}"><!-- 로그인한 사용자 -->
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
							    window.location.href="http://localhost:8080/googlelogout.do";
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
				<li><a href="#">ORDERS</a></li>
				<li><a href="/basket.do">BAG</a></li>
			</ul>
		</div> 
		<br style="clear: both" />
	</nav>
</div>