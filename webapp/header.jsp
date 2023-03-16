<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="model.NhanVien" %><!--import model-->
 <%
 String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	+ request.getContextPath();//lấy absolute link
 %>

<!-- Navbar -->
<header class="header_section">
      <div class="container-fluid">
        <nav class="navbar navbar-expand-lg custom_nav-container pt-3">
          <a class="navbar-brand" href="index.jsp">
            <img src="images/1.png" width="200" alt="">
          </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="d-flex ml-auto flex-column flex-lg-row align-items-center">
              <ul class="navbar-nav  ">
                <li class="nav-item ">
                  <a class="nav-link" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="about.jsp">
                    About
                  </a>
                </li>
                <li class="nav-item">
                <%
						Object obj = session.getAttribute("nhanVien");// getAttribute lúc nào cũng có đối tượng nên phải ép kiểu
						NhanVien nhanVien = null; // ép kiểu có 1 nhân viên bằng null
						if (obj!=null)// hiển thị ra khi nhân viên khac null
							nhanVien = (NhanVien)obj;
						
						if(nhanVien==null){
					%>
                  <!-- <a class="nav-link" href="nhanvien/dangnhap.jsp">
                  Log In
                  </a> -->
                  <a class="nav-link" href="<%=url %>/nhanvien/dangnhap.jsp"><!--absolute link-->
                  Log In 
                  </a>
                  <%} else { %>
						<ul class="navbar-nav me-auto mb-2 mb-lg-0 bg-infor ">
						<li class="nav-item dropdown dropstart"><a
							class="nav-link dropdown-toggle" href="#" role="button"
							data-bs-toggle="dropdown" aria-expanded="false"> Tài khoản</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="<%=url %>/nhanvien/luongcuatoi.jsp">Lương của tôi</a></li>
								<li><a class="dropdown-item" href="<%=url %>/nhanvien/thaydoianh.jsp">Thay đổi ảnh avatar</a></li>
								<li><a class="dropdown-item" href="<%=url %>/nhanvien/thaydoithongtin.jsp">Thay đổi thông tin</a></li>
								<li><a class="dropdown-item" href="<%=url %>/nhanvien/doimatkhau.jsp">Đổi mật khẩu</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item" href="<%=url %>/nhanvien/nhan-vien?hanhDong=dang-xuat">Thoát tài khoản</a></li><!--truyền giá trị đi có giá trị hành động là đăng xuất  -->
							</ul></li>
					</ul>	
					<% } %>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="contact.jsp">Contact Us</a>
                </li>
              </ul>
              <form class="form-inline my-2 my-lg-0 ml-0 ml-lg-4 mb-3 mb-lg-0">
                <button class="btn  my-2 my-sm-0 nav_search-btn" type="submit"></button>
              </form>
            </div>
          </div>
        </nav>
      </div>
    </header>
	<!-- End Navbar -->