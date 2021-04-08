<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>thisisthat - ${where }</title>

<%@include file="include/css.jsp"%>
<%@include file="include/js.jsp"%>
<style type="text/css">
 a:link { color: red; text-decoration: none;}
 a:visited { color: blue; text-decoration: none;}
 a:hover { color: red; text-decoration: underline;}
 a {color:black;}
</style>


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
                    <h1 class="h3 mb-2 text-gray-800">${where}</h1>
                    <p class="mb-4"><!-- 쓸 말 있으면 쓰는 곳 --></p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                       <!--   <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">공지사항</h6>
                        </div>
                        -->
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>번호</th>
                                            <th>제목</th>
                                            <th>작성자</th>
                                            <th>날짜</th>
                                            <th>조회수</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <input type="hidden" value="${where}" id="where">
                                    	 
                                    <!-- 모든 변수명은 상황에 따라서 바꿔도 됩니당  ex)aritcle, articleList-->
                                    	<c:if test="${not empty articleList}" >
	                                        <c:forEach var="board" items="${articleList}">
		                                        <tr>
			                                        <td width="45">${board.board_no}</td>
			                                        <td width="295"><a href="noticeGate.mdo?board_no=${board.board_no }" style="">${board.board_title }<!--댓글수--> </a></td>
			                                        <td width="140">${board.board_writer }</td>
			                                        <td width="115"><fmt:formatDate value="${board.reg_Date}" pattern="yyyy-MM-dd HH:mm"/></td>
			                                        <td width="45">${board.board_cnt }</td>
			                                    </tr>
	                                        </c:forEach>
                                        

                                        </c:if>
                                        <c:if test="${empty articleList}">
                                        	<tr>
                                        		<td colspan="5" align="center">
                                        		<h1> 게시글이 없어요</h1>
                                        		</td>
                                        	</tr>
                                        </c:if>
                                    </tbody>
                                </table>
                                <div>	
                                	<select name="searchOption" aria-controls="example" id="searchOption">
										<option value="board_writer">작성자</option>
										<option value="board_title">제목</option>
										<option value="board_content">내용</option>
									</select>										                                    		
									<input type="text" name="keyword" id="search">

									<button type="button" class="btn btn-dark" id="searchBtn">
										<i class="fa fa-pencil fa-fw mr-2 text-gray-400"></i>
										검색버튼
									</button>

									<button type="button" class="btn btn-dark"  id="insertArticle">
										<i class="fa fa-pencil fa-fw mr-2 text-gray-400"></i>
										글쓰기
									</button>
                                </form>
									<br>
									<div align="center">
										<c:if test="${paging.startPage != 1 }">
											<a href="/admin/getArticleList.mdo?nowPage=${paging.startPage -1 }&cntPerPage=${paging.cntPerPage }&where=${where}&searchOption=${search.searchOption }&keyword=${search.keyword} "> &lt;</a>
										</c:if>
										<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
											<c:choose>
												<c:when test="${p == paging.nowPage }">
													<b>${p}</b>
												</c:when>
												<c:when test="${p != paging.nowPage }">
													<a href="/admin/getArticleList.mdo?nowPage=${p}&cntPerPage=${paging.cntPerPage}&where=${where}&searchOption=${search.searchOption}&keyword=${keyword}">${p}</a>
												</c:when>
											</c:choose>
										</c:forEach>
										<c:if test="${paging.endPage != paging.lastPage}">
											<a href="/admin/getArticleList.mdo?nowPage=${paging.endPage+1}&cntPerPage=${paging.cntPerPage}&where=${where}&searchOption=${search.searchOption}&keyword=${keyword}">&gt;</a>
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
	<script>
	//--------------------검색하는 함수
		$(function(){
			$("#insertArticle").click(function(){
				location.href="/admin/insertArticle.mdo"
			});
			//-------------------검색하는 함수end			
			$("#searchBtn").click(function(){
				var keyword = $('#search').val();
				var searchOption = document.getElementById('searchOption').value;
				var where = document.getElementById('where').value;
				location.href="/admin/getArticleList.mdo?searchOption="
						+ searchOption
						+"&keyword=" + keyword + "&where="+where;
				console.log(search); 
			});
		});
	
	</script>
				
	

</body>
</html>