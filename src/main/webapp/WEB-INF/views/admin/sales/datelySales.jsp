<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>thisisthat - 요일별 매출현황</title>
<%@include file="../include/css.jsp"%>
<%@include file="../include/js.jsp"%>
<!-- Custom fonts for this template-->
    <link href="/resources/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/admin/css/sb-admin-2.min.css" rel="stylesheet">
    <script src="/resources/admin/vendor/chart.js/Chart.min.js"></script>
<style type="text/css">
 a:visited { color: white; text-decoration: none;}
 a {color:black;}
 .table td{
 	vertical-align: middle;
 }
 .table th{
 	text-align: center;
 }
</style>
<script type="text/javascript">
$(document).ready(function () {
	$("#sDate").datepicker({
		dateFormat: "yy-mm-dd",
		dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
		monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		maxDate:0
	});
	$("#eDate").datepicker({
		dateFormat: "yy-mm-dd",
		dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'],
		monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		maxDate:0
	});
});
$(document).ready(function () {
	$("#excelDownloadBtn").on("click",function(e){
		var sDate = $("#sDate").val();
		var eDate = $("#eDate").val();
		if(sDate==""||eDate==""){
			alert("다운로드할 기간을 먼저 선택해주세요.");
			return false;
		}else{
			location.href="/admin/excelDownload.mdo?sDate="+sDate+"&eDate="+eDate+"&type=dately";
		}
	});
	$("#pdfDownloadBtn").on("click",function(e){
		var sDate = $("#sDate").val();
		var eDate = $("#eDate").val();
		if(sDate==""||eDate==""){
			alert("다운로드할 기간을 먼저 선택해주세요.");
			return false;
		}else{
			location.href="/admin/pdfDownload.mdo?sDate="+sDate+"&eDate="+eDate+"&type=dately";
		}
	});
});
function getData(){
	var sDate = $("#sDate").val();
	var eDate = $("#eDate").val();
	
	var split1 = sDate.split("-");
	var split2 = eDate.split("-");
	if(parseInt(split1[0])>parseInt(split2[0])){
		alert("종료일이 시작일보다 클 수 없습니다.");
		return false;
	}else if(parseInt(split1[0])==parseInt(split2[0])){
		if(parseInt(split1[1])>parseInt(split2[1])){
			alert("종료일이 시작일보다 클 수 없습니다.");
			return false;
		}else if(parseInt(split1[1])==parseInt(split2[1])){
			if(parseInt(split1[2])>parseInt(split2[2])){
				alert("종료일이 시작일보다 클 수 없습니다.");
				return false;
			}
		}
	}
	if(sDate == '' || eDate == ''){
		alert("조회 일자를 선택해주세요");
		return false;
	}
	location.href="/admin/datelySales.mdo?sDate="+sDate+"&eDate="+eDate;
}

</script>
</head>
<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <%@include file="../include/sideMenu.jsp" %>

        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <%@include file="../include/navbar.jsp" %>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">
                    	요일별 매출현황
                    </h1>
                   	<div>
                   		기간 선택 : <input class="btn btn-dark" type="text" id="sDate" autocomplete="off" name="sDate" value="${startDay }"> ~ <input class="btn btn-dark" type="text" id="eDate" autocomplete="off" name="eDate" value="${endDay }">
                   		&nbsp;&nbsp;&nbsp;&nbsp;<input class="btn btn-dark" type="button" value="조회" onclick="getData()">
                   		&nbsp;&nbsp;&nbsp;&nbsp;<button id="excelDownloadBtn" type="button" class="btn btn-dark"><img height="22px;" alt="" src="/resources/admin/icon/excelIcon.png" >Excel</button>
                   		&nbsp;&nbsp;&nbsp;&nbsp;<button id="pdfDownloadBtn" type="button" class="btn btn-dark"><img height="22px;" alt="" src="/resources/admin/icon/pdfIcon.png" >PDF</button>
                   	</div>
                   	<br>
                    <!-- Content Row -->
            		<div class="card shadow mb-4">
                         <!-- Card Header - Dropdown -->
                         <c:choose>
                         	<c:when test="${not empty datelySales }">
								<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
									<h6 class="m-0 font-weight-bold text-primary">${startDay } ~ ${endDay } 조회 결과</h6>
								</div>
								<!-- Card Body -->
								<div class="card-body">
									<div class="chart-area">
										<canvas id="myAreaChart"></canvas>
									</div>
								</div>
							</c:when>
                         	<c:otherwise>
								<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
									<h6 class="m-0 font-weight-bold text-primary">조회를 해주세요.</h6>
								</div>
							</c:otherwise>
                         </c:choose>
                     </div>
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

 <script type="text/javascript">
//Set new default font family and font color to mimic Bootstrap's default styling
 Chart.defaults.global.defaultFontFamily = 'Nunito', '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
 Chart.defaults.global.defaultFontColor = '#858796';

 function number_format(number, decimals, dec_point, thousands_sep) {
   // *     example: number_format(1234.56, 2, ',', ' ');
   // *     return: '1 234,56'
   number = (number + '').replace(',', '').replace(' ', '');
   var n = !isFinite(+number) ? 0 : +number,
     prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
     sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
     dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
     s = '',
     toFixedFix = function(n, prec) {
       var k = Math.pow(10, prec);
       return '' + Math.round(n * k) / k;
     };
   // Fix for IE parseFloat(0.55).toFixed(0) = 0;
   s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
   if (s[0].length > 3) {
     s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
   }
   if ((s[1] || '').length < prec) {
     s[1] = s[1] || '';
     s[1] += new Array(prec - s[1].length + 1).join('0');
   }
   return s.join(dec);
 }

 // Area Chart Example
 var ctx = document.getElementById("myAreaChart");
 var myLineChart = new Chart(ctx, {
   type: 'bar',
   data: {
     labels: [<c:forEach items="${datelySales}" var="dately">"${dately.groupString}",</c:forEach>],
     datasets: [{
       label: "",
       lineTension: 0.3,
       backgroundColor: "rgb(139, 133, 205,0.8)",
       borderColor: "rgba(78, 115, 223, 1)",
       pointRadius: 3,
       pointBackgroundColor: "rgba(78, 115, 223, 1)",
       pointBorderColor: "rgba(78, 115, 223, 1)",
       pointHoverRadius: 3,
       pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
       pointHoverBorderColor: "rgba(78, 115, 223, 1)",
       pointHitRadius: 10,
       pointBorderWidth: 2,
       data: [<c:forEach items="${datelySales}" var="dately">"${dately.subtotal}",</c:forEach>],
     }],
   },
   options: {
     maintainAspectRatio: false,
     layout: {
       padding: {
         left: 10,
         right: 25,
         top: 25,
         bottom: 0
       }
     },
     scales: {
       xAxes: [{
         time: {
           unit: 'date'
         },
         gridLines: {
           display: false,
           drawBorder: false
         },
         ticks: {
           maxTicksLimit: 10
         }
       }],
       yAxes: [{
         ticks: {
           maxTicksLimit: 10,
           padding: 10,
           // Include a dollar sign in the ticks
           callback: function(value, index, values) {
             return number_format(value)+'원';
           }
         },
         gridLines: {
           color: "rgb(234, 236, 244)",
           zeroLineColor: "rgb(234, 236, 244)",
           drawBorder: false,
           borderDash: [2],
           zeroLineBorderDash: [2]
         }
       }],
     },
     legend: {
       display: false
     },
     tooltips: {
       backgroundColor: "rgb(255,255,255)",
       bodyFontColor: "#858796",
       titleMarginBottom: 10,
       titleFontColor: '#6e707e',
       titleFontSize: 14,
       borderColor: '#dddfeb',
       borderWidth: 1,
       xPadding: 15,
       yPadding: 15,
       displayColors: false,
       intersect: false,
       mode: 'index',
       caretPadding: 10,
       callbacks: {
         label: function(tooltipItem, chart) {
           var datasetLabel = chart.datasets[tooltipItem.datasetIndex].label || '';
           return number_format(tooltipItem.yLabel)+'원';
         }
       }
     }
   }
 });
 </script>

    
 
</body>
</html>