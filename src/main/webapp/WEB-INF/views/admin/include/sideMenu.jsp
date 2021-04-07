<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<ul class="navbar-nav bg-gradient-dark sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->


            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/admin/main.mdo">
                <img style="height: 100%;" alt="" src="/resources/admin/img/mainlogo.png">
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="index.html">
                    <i class="fas fa-fw fa-globe"></i>
                    <span>현황</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Interface
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true">
                    <i class="fas fa-fw fa-users"></i>
                    <span>회원관리</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="/admin/userList.mdo">회원정보</a>
                        <a class="collapse-item" href="/admin/getCouponList.mdo">회원쿠폰생성</a>
                        <a class="collapse-item" href="/admin/grantCoupon.mdo">회원쿠폰부여</a>
                        <a class="collapse-item" href="/admin/pointUserList.mdo">회원적립금관리</a>
                        <a class="collapse-item" href="/admin/getTermsList.mdo?state=information">개인정보 수집 및 이용 약관</a>
                        <a class="collapse-item" href="/admin/getTermsList.mdo?state=utilization">이용 약관</a>

                    </div>
                </div>
            </li>

            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true">
                    <i class="fas fa-fw fa-wrench"></i>
                    <span>직원관리</span>
                </a>
                <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">                    	
                        <a class="collapse-item" href="/admin/staffList.mdo">직원정보</a>
                        <a class="collapse-item" href="/admin/insertStaff.mdo">신규직원등록</a>
                        <a class="collapse-item" href="utilities-border.html">직원정보수정</a>
                        <a class="collapse-item" href="/admin/userRoleList.mdo">권한관리</a>
                    </div>
                </div>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
           
            
            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages" aria-expanded="true" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>상품관리</span>
                </a>
                <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="/admin/categoryList.mdo">카테고리 관리</a>
                        <a class="collapse-item" href="/admin/productList.mdo">상품 관리</a>
                        <a class="collapse-item" href="register.html">상품수정/삭제</a>
                        <a class="collapse-item" href="/admin/getProductStockList.mdo">상품재고관리</a>
                    </div>
                </div>
            </li>

            <!-- Nav Item - Charts -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="charts.html" data-toggle="collapse" data-target="#order" aria-expanded="true">
                    <i class="fas fa-fw fa-truck"></i>
                    <span>주문관리</span>
                </a>
                <div id="order" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="/admin/getOrderManagementList.mdo">주문내역</a>
                        <a class="collapse-item" href="register.html">배송관리</a>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseBoards" aria-expanded="false" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-th-list"></i>
                    <span>게시글관리</span>
                </a>
                <div id="collapseBoards" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar" style="">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="/admin/articleGate.mdo?where=notice">공지사항</a>
                        <a class="collapse-item" href="/admin/articleGate.mdo?where=event">이벤트</a>
                        <a class="collapse-item" href="404.html">상품문의관리</a>
                        <a class="collapse-item" href="/admin/answerBoardList.mdo">Q&A</a>
                        <a class="collapse-item" href="blank.html">후기관리</a>
                    </div>
                </div>
            </li>
            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseSales" aria-expanded="false" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>매출현황</span>
                </a>
                <div id="collapseSales" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar" style="">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="/admin/montlySales.mdo">월별 매출현황</a>
                        <a class="collapse-item" href="/admin/dailySales.mdo">일별 매출현황</a>
                        <a class="collapse-item" href="/admin/categorySales.mdo">카테고리별 매출현황</a>
                        <a class="collapse-item" href="/admin/datelySales.mdo">요일별 매출현황</a>
                    </div>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapse" aria-expanded="false" aria-controls="collapsePages">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>기타</span>
                </a>
                <div id="collapse" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar" style="">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <a class="collapse-item" href="/admin/getBanner.mdo">배너 관리</a>
                        <a class="collapse-item" href="/admin/modifyStaff.mdo">내정보 수정</a>
                    </div>
                </div>
            </li>
           

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

            <!-- Sidebar Message -->
            

        </ul>