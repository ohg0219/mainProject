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

<title>thisisthat - 회원목록</title>

<%@include file="include/css.jsp"%>
<%@include file="include/js.jsp"%>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="include/sideMenu.jsp"%>

		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">
				<!-- Topbar -->
				<%@include file="include/navbar.jsp"%>
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">회원목록</h1>
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
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>아이디</th>
											<th align="center">성명</th>
											<th>닉네임</th>
											<th>휴대폰</th>
											<th>가입일</th>
											<th>계정관리</th>
										</tr>
									</thead>
									<tbody>

										<!-- 모든 변수명은 상황에 따라서 바꿔도 됩니당  ex)aritcle, articleList-->
										<c:if test="${not empty userInfo}">
											<c:forEach var="user" items="${userInfo}">
												<tr>
													<td width="85">${user.userId}</td>
													<td width="95">
														<a id = "${user.userId }" class="who"
														data-toggle="modal" data-target="#getUserModal">${user.userName}</a></td>
													<td width="85">${user.nickName}</td>
													<td width="160">${user.userPhone}</td>
													<td width="95"><fmt:formatDate value="${user.inDate}"
															pattern="yyyy-MM-dd" /></td>
													<c:if test="${not empty user.outDate}">
														<td width="75">탈퇴</td>
													</c:if>
													<c:if test="${empty user.outDate}">
														<c:if test="${user.userRole == 100}">
															<td width="75">회원</td>
														</c:if>
														<c:if test="${user.userRole == 110}">
															<td width="75">정지</td>
														</c:if>
													</c:if>
												
												</tr>
											</c:forEach>
										</c:if>
										<c:if test="${empty userInfo}">
											<tr>
												<td colspan="6" align="center">
													<h3>회원이 없어요</h3>
												</td>
											</tr>
										</c:if>
									</tbody>
								</table>

								<div>
									<select name="example_length" id="search_select" aria-controls="example">
										<option value="all">전체</option>
										<option value="id">아이디</option>
										<option value="nickname">닉네임</option>
									</select>

									 <input type="text" id="search">
		
									<button type="button" class="btn btn-dark" id="searchBtn">
										<i class="fa fa-pencil fa-fw mr-2 text-gray-400"></i> 검색버튼
									</button>
									<br>
									<div style="display: block; text-align: center;">
										<c:if test="${paging.startPage != 1 }">
											<a
												href="/admin/userList.mdo?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}
												search=${userVO.search}&select=${userVO.select}">&lt;</a>
										</c:if>
										<c:forEach begin="${paging.startPage }"
											end="${paging.endPage }" var="p">
											
												<c:if test="${p == paging.nowPage }">
													<b>${p }</b>
												</c:if>
												<c:if test="${p != paging.nowPage }">
													<a
														href="/admin/userList.mdo?nowPage=${p }&cntPerPage=${paging.cntPerPage}
														search=${userVO.search}&select=${userVO.select}">${p }</a>
												</c:if>
											
										</c:forEach>
										<c:if test="${paging.endPage != paging.lastPage}">
											<a
												href="/admin/userList.mdo?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}
												search=${userVO.search}&select=${userVO.select}">&gt;</a>
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
	
	<form action="/admin/pwCheck.mdo" method="post">
	<div class="modal fade" id="getUserModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">비밀번호를 입력해 주세요</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-content">
					<input type="password" name="userPw" placeholder="비밀번호">
					
				</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<input type="submit" class="btn btn-primary" id="modalInput" value="확인">					
					<input type="hidden" id="userId" name="userId">
				</div>
			</div>
		</div>
	</div>
	</form>

	<script>
		//--------------------검색하는 함수
		var msg = '${msg}';
		var failId = '${failId}';
		if(msg==='fail'){
			console.log(failId);
			document.getElementById(failId).click();
			alert('비밀번호를 확인해 주세요');
		}
		if(msg === "noPw"){
			alert('잘못된 접근입니다.');
		}
	
		$(function(){
			$("#searchBtn").click(function(){
				var search = $('#search').val();
				var select = document.getElementById("search_select");
				var val;

				for(i=0; i<select.options.length; i++) {
				    if(select.options[i].selected == true) {
				        val = select.options[i].value;
				        break;
				    }
				}location.href="/admin/userList.mdo?search="+search+"&select="+val;
			});
			
			$('#search').keypress(function(event){
			     if ( event.which == 13 ) {
			         $('#searchBtn').click();
			         return false;
			     }
			});
			

			//--getUser전 비밀번호 체크
			$('.who').click(function(){
				document.getElementById("userId").value = $(this).attr('id'); 
			})	
		});
		

			
		

	</script>
</body>
</html>