<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>thisisthat - 주문관리</title>

<%@include file="../include/css.jsp"%>
<%@include file="../include/js.jsp"%>
<style type="text/css">
a:link {
	color: red;
	text-decoration: none;
}

a:visited {
	color: blue;
	text-decoration: none;
}

a:hover {
	color: red;
	text-decoration: underline;
}

a {
	color: black;
}
</style>


</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="../include/sideMenu.jsp"%>

		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				<!-- Topbar -->
				<%@include file="../include/navbar.jsp"%>
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">주문관리</h1>
					<p class="mb-4">
						<!-- 쓸 말 있으면 쓰는 곳 -->
					</p>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<!--   <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">공지사항</h6>
                        </div>
                        -->
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" style="font-size: 10pt" >
									<thead>
										<tr align="center">
											<th>주문<br>번호</th>
											<th>주문일</th>
											<th width="30">아이디</th>
											<th>우편<br>번호</th>
											<th>주소</th>
											<th>상세<br>주소</th>
											<th>결제<br>금액</th>
											<th>결제<br>정보</th>
											<th>무통장<br>이름</th>
											<th>현재<br>상태</th>
											<th>송장<br>번호</th>
											<th>취소<br>유무</th>
										</tr>
									</thead>
									<tbody>
										<c:if test="${not empty orderList}">
											<c:forEach var="article" items="${orderList}">
												<tr>
													<td align="center"><a
														href="getOrderManagement.mdo?order_no=${article.order_no}">${article.order_no}</a></td>
													<td align="center"><fmt:formatDate
															value="${article.order_date}" pattern="yyyy-MM-dd" /></td>
													<td align="center">${article.user_id }</td>
													<td align="center">${article.receive_zipcode }</td>
													<td align="center">${article.receive_first_address }</td>
													<td align="center">${article.receive_last_address }</td>
													<td align="center"><fmt:formatNumber maxFractionDigits="3" value="${article.order_price }"/></td>
													<td align="center">${article.order_select }</td>
													<td align="center">${article.passbook_name }</td>
													<td align="center">
													<input type="hidden" class="articleNo" value="${article.order_no }">
													 <select name="order_state" id="selectorder" class="${article.order_no } selector">
															<option>${article.order_state }</option>
															<option name="select" value="입금대기">입금대기</option>
															<option name="select" value="결제완료">결제완료</option>
															<option name="select" value="주문취소">주문취소</option>
															<option name="select" value="상품준비중">상품준비중</option>
															<option name="select" value="배송준비중">배송준비중</option>
															<option name="select" value="배송중">배송중</option>
															<option name="select" value="배송완료">배송완료</option>
															<option name="select" value="교환요청">교환요청</option>
															<option name="select" value="환불요청">환불요청</option>
															<option name="select" value="환불완료">환불완료</option>
													</select></td>
													<td align="center">
														<c:if test="${article.invoice_no != 0}">
															${article.invoice_no }
														</c:if>
													</td>
													<td align="center">
														<c:if test="${article.order_cancel == 1}">
															취소
														</c:if>
													</td>
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${empty orderList }">
											<tr>
												<td colspan="12" align="center">
													<h1>받은 주문이 없어요</h1>
												</td>
											</tr>
										</c:if>
									</tbody>
								</table>
								<div>
									<form action="getOrderManagementList.mdo" method="get">
										<select name="searchOption" aria-controls="example" class="">
											<option value="all">전체</option>
											<option value="order_no">주문번호</option>
											<option value="user_id">아이디</option>
											<option value="invoice_no">송장번호</option>
										</select> <input type="text" name="keyword">
										<button type="submit" class="btn btn-dark" id="searchBtn">
											<i class="fas fa-search fa-sm mr-2 text-gray-400"></i> 검색
										</button>
									</form>
									<br>
									<div align="center">
										<c:if test="${paging.startPage != 1 }">
											<a href="/admin/getOrderManagementList.mdo?nowPage=${paging.startPage - 1 }&searchOption=${searchOption}&keyword=${keyword}">&lt;</a>
										</c:if>
										<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
											<c:choose>
												<c:when test="${p == paging.nowPage }">
													<b>${p }</b>
												</c:when>
												<c:when test="${p != paging.nowPage }">
													<a href="/admin/getOrderManagementList.mdo?nowPage=${p }&searchOption=${searchOption}&keyword=${keyword}">${p }</a>
												</c:when>
											</c:choose>
										</c:forEach>
										<c:if test="${paging.endPage != paging.lastPage}">
											<a href="/admin/getOrderManagementList.mdo?nowPage=${paging.endPage+1 }&searchOption=${searchOption}&keyword=${keyword}">&gt;</a>
										</c:if>
									</div>
								</div>
							</div>
						</div>
					</div>


				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(document).ready(function(){
		$(".selector").on("change",function(){
			var number = $(this).siblings(".articleNo").val();
			var select = $("."+number+" option:selected").val();
			console.log("select : " + select + "number : " + number);
			if(select == "상품준비중"){
				var invoiceno = prompt("송장번호 입력 : ");
				if(invoiceno == null){
					return false;
				}
				location.href="/admin/selectOrderManagement.mdo?order_state="+select+"&order_no="+number+"&invoice_no="+invoiceno;				
			}else{				
				location.href="/admin/selectOrderManagementList.mdo?order_state="+select+"&order_no="+number;
			}	
		});
	});
	</script>

</body>
</html>