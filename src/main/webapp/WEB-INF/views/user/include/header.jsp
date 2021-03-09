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
				
				<c:if test="${sessionScope.userId == null }"> 
					<li><a href="/login.do">LOGIN</a></li>					
				</c:if>
				<c:if test="${sessionScope.userId != null }"><!-- 로그인한 사용자 -->
					<li><a href="/logout.do">LOGOUT</a></li>
					<li><a href="/mypage.do">MYPAGE</a></li>						
				</c:if>
				
				
				<li><a href="#">ORDERS</a></li>
				<li><a href="#">BAG</a></li>
			</ul>
		</div> 
		<br style="clear: both" />
	</nav>
</div>