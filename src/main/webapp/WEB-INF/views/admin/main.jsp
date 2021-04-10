<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>This is that</title>

    <!-- Custom fonts for this template-->
    <link href="/resources/admin/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/admin/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <%@include file="include/sideMenu.jsp" %>

        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
               <%@include file="include/navbar.jsp" %>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">현황판</h1>
                    </div>

                    <!-- Content Row -->
                    <div class="row">

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-6 col-md-6 mb-6">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">이번달 매출</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${thisMonthSales }</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-won-sign fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-6 col-md-6 mb-6">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">금일 매출</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${thisDaySales}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-won-sign fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Content Row -->

                    <div class="row">

                        <!-- Area Chart -->
                        <div class="col-xl-8 col-lg-7">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">최근 일주일 매출</h6>
                                    
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-area">
                                        <canvas id="myAreaChart"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Pie Chart -->
                        <div class="col-xl-4 col-lg-5">
                            <div class="card shadow mb-4">
                                <!-- Card Header - Dropdown -->
                                <div
                                    class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                                    <h6 class="m-0 font-weight-bold text-primary">금일 카테고리별 판매수량</h6>
                                    <div class="dropdown no-arrow">
                                        
                                    </div>
                                </div>
                                <!-- Card Body -->
                                <div class="card-body">
                                    <div class="chart-pie pt-4 pb-2">
                                        <canvas id="myPieChart"></canvas>
                                    </div>
                                    <div class="mt-4 text-center small">
                                    	<c:forEach items="${todayCategorySales }" var="cate">
                                    		<span style="text-transform: uppercase;">${cate.productCategory } : ${cate.count }개<br></span>&nbsp;
                                    	</c:forEach>
                                    	
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Content Row -->
                    <div class="row">

                        <!-- Content Column -->
                        <div class="col-lg-6 mb-4">

                           


                        </div>

                        <div class="col-lg-6 mb-4">


                        </div>
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

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">로그아웃하시겠습니까?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.mdo">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/resources/admin/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/admin/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="/resources/admin/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script type="text/javascript">
		// Set new default font family and font color to mimic Bootstrap's default styling
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
	      type: 'line',
	      data: {
	        labels: [<c:forEach items="${dateList}" var="date">"${date}",</c:forEach>],
	        datasets: [{
	          label: "",
	          lineTension: 0.3,
	          backgroundColor: "rgba(78, 115, 223, 0.05)",
	          borderColor: "rgba(78, 115, 223, 1)",
	          pointRadius: 3,
	          pointBackgroundColor: "rgba(78, 115, 223, 1)",
	          pointBorderColor: "rgba(78, 115, 223, 1)",
	          pointHoverRadius: 3,
	          pointHoverBackgroundColor: "rgba(78, 115, 223, 1)",
	          pointHoverBorderColor: "rgba(78, 115, 223, 1)",
	          pointHitRadius: 10,
	          pointBorderWidth: 2,
	          data: [<c:forEach items="${dataList}" var="data">"${data}",</c:forEach>],
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
	              maxTicksLimit: 7
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
	    var ctx = document.getElementById("myPieChart");
	    var myPieChart = new Chart(ctx, {
	      type: 'doughnut',
	      data: {
	        labels: [<c:forEach items="${todayCategorySales}" var="cate">"${cate.productCategory}",</c:forEach>],
	        datasets: [{
	          data: [<c:forEach items="${todayCategorySales}" var="cate">"${cate.count}",</c:forEach>],
	          backgroundColor: ['#4e73df', '#1cc88a', '#36b9cc','#C70039','#FFC300','#D1C92B','#D12BB2'],
	          hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf'],
	          hoverBorderColor: "rgba(234, 236, 244, 1)",
	        }],
	      },
	      options: {
	        maintainAspectRatio: false,
	        tooltips: {
	          backgroundColor: "rgb(255,255,255)",
	          bodyFontColor: "#858796",
	          borderColor: '#dddfeb',
	          borderWidth: 1,
	          xPadding: 15,
	          yPadding: 15,
	          displayColors: false,
	          caretPadding: 10,
	        },
	        legend: {
	          display: false
	        },
	        cutoutPercentage: 80,
	      },
	    });
    </script>

</body>
</html>