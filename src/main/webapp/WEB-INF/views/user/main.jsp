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
	.banner {position: relative; width: 2000px; height: 1000px; top: 50px;  margin:0 auto; padding:0; overflow: hidden;}
	.banner ul {position: absolute; margin: 0px; padding:0; list-style: none; }
	.banner ul li {float: left; width: 2000px; height: 1000px; margin:0; padding:0;}
	.movebtn{
		text-decoration : none;
		top: 50%;
		color: #000000;
		font-size: 36px;
		font-weight: 700;
		position: absolute;
		opacity: 0.5;
	}
	.movebtn.hover{
		opacity: 1;
	}
	.next{
		right:10%
	}
	.prev{
		left:10%;
	}
</style>
</head>
<body>
	<div class="wrap">
		<%@include file="include/header.jsp" %>
		<div class="content">
			<div class="main_image_area">
					<div class="banner">
						<ul>
							<li><img alt="" src="/resources/user/image/i-22yi.jpg"  height= "1000px"></li>
							<li><img alt="" src="/resources/user/image/i-22yi.jpg"  height= "1000px"></li>
							<li><img alt="" src="/resources/user/image/i-22yi.jpg"  height= "1000px"></li>
														
						</ul>
						
						<a id="prev" class= "movebtn prev">&lt;</a>
						<a id="next" class= "movebtn next">&gt;</a>
					</div>
					<div class="main_image_text"><p>thisisthat®  SP21</p></div>
				
			</div>
			<div class="sub_image_area">
				<a href="#">
					<div class="sub_image_text"><p>SUB 1</p></div>
					<div class="sub_image"><img alt="" src="/resources/user/image/sub_1.jpg"></div>
				</a>
				<a href="#">
					<div class="sub_image_text"><p>SUB 2</p></div>
					<div class="sub_image"><img alt="" src="/resources/user/image/sub_2.jpg"></div>
				</a>
				<a href="#">
					<div class="sub_image_text"><p>SUB 3</p></div>
					<div class="sub_image"><img alt="" src="/resources/user/image/sub_3.jpg"></div>
				</a>
				<a href="#">
					<div class="sub_image_text"><p>SUB 4</p></div>
					<div class="sub_image"><img alt="" src="/resources/user/image/sub_4.jpg"></div>
				</a>
			</div>
		</div><!-- end Content -->
		<%@include file="include/footer.jsp" %>
		<div class="don"></div>
	</div>
	
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		//사용할 배너
		var $banner = $(".banner").find("ul");

		var $bannerWidth = $banner.children().outerWidth();//배너 이미지의 폭
		var $bannerHeight = $banner.children().outerHeight(); // 높이
		var $bannerLength = $banner.children().length;//배너 이미지의 갯수
		var rollingId;

		//정해진 초마다 함수 실행
		rollingId = setInterval(function() { rollingStart(); }, 3000);//다음 이미지로 롤링 애니메이션 할 시간차

		//마우스 오버시 롤링을 멈춘다.
		$banner.hover(function(){
			//중지
			clearInterval(rollingId);
			$(this).css("cursor", "pointer");
		});
		//마우스 아웃되면 다시 시작
		$banner.mouseout(function(){
			rollingId = setInterval(function() { rollingStart(); }, 3000);
			$(this).css("cursor", "default");
		});
		
		function rollingStart() {
			$banner.css("width", $bannerWidth * $bannerLength + "px");
			$banner.css("height", $bannerHeight + "px");
			//alert(bannerHeight);
			//배너의 좌측 위치를 옮겨 준다.
			$banner.animate({left: - $bannerWidth + "px"}, 1500, function() { //숫자는 롤링 진행되는 시간이다.
				//첫번째 이미지를 마지막 끝에 복사(이동이 아니라 복사)해서 추가한다.
				$(this).append("<li>" + $(this).find("li:first").html() + "</li>");
				//뒤로 복사된 첫번재 이미지는 필요 없으니 삭제한다.
				$(this).find("li:first").remove();
				//다음 움직임을 위해서 배너 좌측의 위치값을 초기화 한다.
				$(this).css("left", 0);
				//이 과정을 반복하면서 계속 롤링하는 배너를 만들 수 있다.
			});
		}
		var $banner = $(".banner").find("ul");
		$('.prev').click(function(){
			console.log($(this).attr('class'));
		});
	});



	</script>
</html>