<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>thisisthat® 디스이즈댓</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/common.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/common.js"></script>
</head>
<body>
	<div class="wrap">
		<%@include file="include/header.jsp" %>
		<div></div> 
		<!--  -->
		<div class="content">
			<div class="main_image_area">
				<a href="#">
					<div class="main_image"><img alt="" src="<%=request.getContextPath() %>/resources/image/i-22yi.jpg"></div>
					<div class="main_image_text"><p>thisisthat®  SP21</p></div>
				</a>
			</div>
			<div class="sub_image_area">
				<a href="#">
					<div class="sub_image_text"><p>SUB 1</p></div>
					<div class="sub_image"><img alt="" src="<%=request.getContextPath() %>/resources/image/sub_1.jpg"></div>
				</a>
				<a href="#">
					<div class="sub_image_text"><p>SUB 2</p></div>
					<div class="sub_image"><img alt="" src="<%=request.getContextPath() %>/resources/image/sub_2.jpg"></div>
				</a>
				<a href="#">
					<div class="sub_image_text"><p>SUB 3</p></div>
					<div class="sub_image"><img alt="" src="<%=request.getContextPath() %>/resources/image/sub_3.jpg"></div>
				</a>
				<a href="#">
					<div class="sub_image_text"><p>SUB 4</p></div>
					<div class="sub_image"><img alt="" src="<%=request.getContextPath() %>/resources/image/sub_4.jpg"></div>
				</a>
			</div>
		</div><!-- end Content -->
		<%@include file="include/footer.jsp" %>
		<div class="don"></div>
	</div>
</body>
</html>