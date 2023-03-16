<%@page import="model.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Thông tin</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous"></script>
<style>
.red {
	color: red;
}
</style>
</head>
<body>
<jsp:include page="../header.jsp" />
	<%
	//lấy ông nhan vien ra báo lỗi khi chưa đăng nhập
		Object obj = session.getAttribute("nhanVien");
		NhanVien nhanVien = null;
		if (obj!=null)
			nhanVien = (NhanVien)obj;		
			if(nhanVien==null){		
	%>
	<h1>Bạn chưa đăng nhập vào hệ thống. Vui lòng quay lại trang chủ!</h1>
	<%
			}else {
				
	%>
	<div class="container">
	<%
		String baoLoi = request.getAttribute("baoLoi")+"";
		baoLoi = (baoLoi.equals("null"))?"":baoLoi;
		
		String hoVaTen= nhanVien.getHoVaTen();//lấy thông tin từ khách hàng ra
		
		String gioiTinh= nhanVien.getGioiTinh();
		
		String ngaySinh= nhanVien.getNgaySinh().toString();
		
		String diaChi = nhanVien.getDiaChi();
		
		String dienThoai = nhanVien.getSoDienThoai();

		String email = nhanVien.getEmail();

		double giaLuongGio = nhanVien.getGiaLuongGio();
		
		double soGioLam = nhanVien.getSoGioLam();
		
		double soGioTangCa = nhanVien.getSoGioTangCa();
		
		double soGioLamDem = nhanVien.getSoGioLamDem();
	%>
	<div class="container">
	<div class="text-center">
			<h1>THÔNG TIN TÀI KHOẢN</h1>
		</div>
		
		<div class="red" id="baoLoi">
			<%=baoLoi %>
		</div>
		<%
		 String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
		 %>
			<form class="form" action="<%=url1 %>/nhan-vien" method="post"><!-- chạy vô trong controller -->
			<input type="hidden" name="hanhDong" value ="thay-doi-thong-tin"><!--gửi file đến nhaanviencontroller severlet biến hành động  -->
			
			<div class="row">
				<div class="col-sm-6">
					<h3>Thông tin nhân viên</h3>
					<div class="mb-3">
						<label for="hoVaTen" class="form-label">Họ và tên</label> <input
							type="text" class="form-control" id="hoVaTen" name="hoVaTen" value="<%=hoVaTen%>">
					</div>
					<div class="mb-3">
						<label for="gioiTinh" class="form-label">Giới tính</label> <select
							class="form-control" id="gioiTinh" name="gioiTinh">
							<option></option>
							<option value="Nam"
								<%=(gioiTinh.equals("Nam")) ? "selected='selected'" : ""%>>Nam</option>
							<option value="Nữ"
								<%=(gioiTinh.equals("Nữ")) ? "selected='selected'" : ""%>>Nữ</option>
							<option value="Khác"
								<%=(gioiTinh.equals("Khác")) ? "selected='selected'" : ""%>>Khác</option>
						</select>
					</div>
					<div class="mb-3">
						<label for="ngaySinh" class="form-label">Ngày sinh</label> <input
							type="date" class="form-control" id="ngaySinh" name="ngaySinh" value="<%=ngaySinh%>">
					</div>
				</div>
				<div class="col-sm-6">
					<h3>Địa chỉ</h3>
					<div class="mb-3">
						<label for="diaChi" class="form-label">Địa chỉ
							nhận hàng</label> <input type="text" class="form-control"
							id="diaChi" name="diaChi"
							value="<%=diaChi%>">
					</div>
					<div class="mb-3">
						<label for="dienThoai" class="form-label">Điện thoại</label> <input
							type="tel" class="form-control" id="dienThoai" name="dienThoai" value="<%=dienThoai%>">
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email" name="email" value="<%=email%>">
					</div>
					<hr />
					<h3>Công việc</h3>
					<div class="mb-3">
						<label for="giaLuongGio" class="form-label">Giá lương giờ
							</label> <input type="text" class="form-control" id="giaLuongGio"
							name="giaLuongGio" value="<%=giaLuongGio%>">
					</div>
					<div class="mb-3">
						<label for="soGioLam" class="form-label">Số giờ làm
							</label> <input type="text" class="form-control" id="soGioLam"
							name="soGioLam" value="<%=giaLuongGio%>" >
					</div>
					<div class="mb-3">
						<label for="soGioTangCa" class="form-label">Số giờ tăng ca
							</label> <input type="text" class="form-control" id="soGioTangCa"
							name="soGioTangCa" value="<%=soGioTangCa%>" >
					</div>
					<div class="mb-3">
						<label for="soGioLamDem" class="form-label">Số giờ làm đêm
							</label> <input type="text" class="form-control" id="soGioLamDem"
							name="soGioLamDem" value="<%=soGioLamDem%>"  >
					</div>
					<hr />
					<input class="btn btn-primary form-control" type="submit"
						value="Lưu thông tin" name="submit" id="submit" style="visibility: visible;" />
				</div>
			</div>
		</form>
</div>
	</div>
	<%} %>
		<jsp:include page="../footer.jsp" />
	</body>

</html>