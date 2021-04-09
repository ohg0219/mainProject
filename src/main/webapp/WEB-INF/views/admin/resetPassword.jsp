<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Login</title>

    <!-- Custom fonts for this template-->
    <link href="/resources/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/admin/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-dark">

    <div class="container">
        <!-- Outer Row -->
        <div class="row justify-content-center">
            <div class="col-xl-8 col-lg-8 col-md-8">
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">
                                            <img src="/resources/admin/img/mainlogo.png" style="width: 100%;" alt="">
                                        </h1>
                                    </div>
                                    <form class="user" action="/resetPassword.mdo" method="post" >
                                    <input type="hidden" name="userId" value="${id}">
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user" id=""
                                                 aria-describedby="emailHelp" name="userPw" placeholder="password">
                                                 <span id="passwordRegChk"></span>
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user" placeholder="Password Check"
                                             name="confirmPassword">
                                            <span id="passwordCheck"></span>
                                        </div>
                                        <input type="submit" id="registBtn" value="확인" class="btn btn-dark btn-user btn-block">
                                    </form>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/resources/admin/vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/admin/js/sb-admin-2.min.js"></script>

</body>
<script type="text/javascript">
	var msg = "${msg}";
	if(msg === "pwFail"){
		alert("아이디, 비밀번호를 확인해 주세요");
	}
	if(msg === "roleFail"){
		alert("권한이 없습니다")
		location.href="/main.do"
	}
	function btn_on(){
		$("#registBtn").attr("disabled",false);
		$("#registBtn").css('cursor','pointer');
	}
	function btn_off(){
		$("#registBtn").attr("disabled",true);
		$("#registBtn").css('cursor','no-drop');
	}
	$(document).ready(function(){
		btn_off();
		//비밀번호 유효성 검사
		$("input[name=userPw]").on("keyup",function(){
		    var password = $("input[name=userPw]").val();
		    var regType2 = /^[A-za-z0-9]{8,16}/g;
		    if(!regType2.test(password)){
		        $('#passwordRegChk').text('영문 대,소문자/숫자  8~16자로 입력해 주세요.');
		        $("#passwordRegChk").css("color", "red");
		        $("input[name=userPw]").focus();
		        btn_off();
		    }else{
		        $("#passwordRegChk").text("");
		    }
		});
		
		// 비밀번호 와 비밀번호 확인 일치확인
		$("input[name=confirmPassword]").keyup(function(){
		    if($('input[name=userPw]').val() != $('input[name=confirmPassword]').val()){
		      $('#passwordCheck').text('비밀번호 일치하지 않음');
		      $("#passwordCheck").css("color", "red");
		      btn_off();
		    } else{
		      $('#passwordCheck').text('비밀번호 일치함');
		      $("#passwordCheck").css("color", "black");
		      btn_on();
		    }
		});//end passwordCheck
	});
	
</script>
</html>