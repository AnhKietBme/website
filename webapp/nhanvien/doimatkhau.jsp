<%@page import="model.NhanVien"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" >
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
	integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
	crossorigin="anonymous"></script>
</head>
<body >
	<jsp:include page="../header.jsp" />
	<%
	//kiểm tra đăng nhập hay chưa mới đổi mật khẩu được
		Object obj = session.getAttribute("nhanVien");
		NhanVien nhanVien = null;
		if (obj!=null)
			nhanVien = (NhanVien)obj;		
			if(nhanVien==null){		
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ!</h1>
	<%
			}else {//lấy ra từ severlet
				String baoLoi = request.getAttribute("baoLoi")+"";
				if(baoLoi.equals("null")){
					baoLoi = "";
				}
	%>
	<div class="container">
			<img alt="" src="https://th.bing.com/th/id/OIP.e4bGeAdIaQjMo1PzcpkajgHaEQ?pid=ImgDet&w=1071&h=615&rs=1" width="300" >
				
			<div class="text-center"><h1>ĐỔI MẬT KHẨU</h1></div>
		<span style="color: red">
			<%=baoLoi%>
		</span>
		<%
		 String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
		 %>
		<form action="<%=url1 %>/nhan-vien" method="POST">
	    <input type="hidden" name="hanhDong" value ="doi-mat-khau"><!--gửi file đến nhaanviencontroller severlet biến hành động  -->
		
		  <div class="mb-3">
		    <label for="matKhauHienTai" class="form-label">Mật khẩu hiện tại</label>
		    <input type="password" class="form-control" id="matKhauHienTai" name="matKhauHienTai">
		  </div>
		  <div class="mb-3">
		    <label for="matKhauMoi" class="form-label">Mật khẩu mới</label>
		    <input type="password" class="form-control" id="matKhauMoi" name="matKhauMoi">
		  </div>
		  <div class="mb-3">
		    <label for="matKhauMoiNhapLai" class="form-label">Mật khẩu mới</label>
		    <input type="password" class="form-control" id="matKhauMoiNhapLai" name="matKhauMoiNhapLai">
		  </div>
		  <button type="submit" class="btn btn-primary">Lưu mật khẩu</button>
		</form>
	</div>
	<%} %>
	<jsp:include page="../footer.jsp" />
</body>
</html>