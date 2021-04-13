<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">

window.onload=function(){
	alert("${errMsg}");
	var id = "${id}"
	var pw = ${pass}
//	location.href="/updatePw.do?id="+ id+"&pw="+ pw;
	location.href="/main.do";
}

</script>
</body>
</html>