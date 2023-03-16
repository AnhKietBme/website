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
		
		double giaLuongGio = nhanVien.getGiaLuongGio();
		
		double soGioLam = nhanVien.getSoGioLam();
		
		double soGioTangCa = nhanVien.getSoGioTangCa();
		
		double soGioLamDem = nhanVien.getSoGioLamDem();
		
		double tongLuong  = nhanVien.getTongLuong();
	%>
	<div class="container">
	<div class="text-center">
			<h1>Bảng lương của tôi</h1>
		</div>
		
		<div class="red" id="baoLoi">
			<%=baoLoi %>
		</div>
		<%
		 String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
		 %>
			<form>
				<div class="row">
				<div class="col-sm-6">
					<h3>Thông tin nhân viên</h3>
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
					<div class="mb-3">
						<label for=tongLuong class="form-label">Tổng lương
							</label> <input type="text" class="form-control" id="tongLuong"
							name="tongLuong" value="<%=tongLuong%>"  >
					</div> 
					<hr />
					<input class="btn btn-primary form-control" type="submit"
						value="Lưu thông tin" name="submit" id="submit" style="visibility: visible;" />
				</div>		
		</form>
	</div>	
	</div>
	<%} %>
		<jsp:include page="../footer.jsp" />
	</body>

</html>