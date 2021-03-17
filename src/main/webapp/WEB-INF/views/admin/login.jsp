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
                                    <form class="user" action="/login.mdo" method="post" >
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                id="id" aria-describedby="emailHelp" name="userId"
                                                placeholder="ID">
                                        </div>
                                        <div class="form-group">
                                            <input name="userPw" type="password" class="form-control form-control-user"
                                                id="exampleInputPassword" placeholder="Password">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" name="autoLogin" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">자동로그인</label>
                                            </div>
                                        </div>
                                        <input type="submit" value="Login" class="btn btn-dark btn-user btn-block">
                                            
                                        
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="forgot-password.html">Forgot Password?</a>
                                    </div>
                                    
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
	
</script>
</html>