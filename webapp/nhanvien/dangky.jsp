<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
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
<%@include file="../header.jsp" %>
<%
	String baoLoi = request.getAttribute("baoLoi") + "";
	baoLoi = (baoLoi.equals("null")) ? "" : baoLoi;

	String tenDangNhap = request.getAttribute("tenDangNhap") + "";
	tenDangNhap = (tenDangNhap.equals("null")) ? "" : tenDangNhap;

	String hoVaTen = request.getAttribute("hoVaTen") + "";
	hoVaTen = (hoVaTen.equals("null")) ? "" : hoVaTen;

	String gioiTinh = request.getAttribute("gioiTinh") + "";
	gioiTinh = (gioiTinh.equals("null")) ? "" : gioiTinh;

	String ngaySinh = request.getAttribute("ngaySinh") + "";
	ngaySinh = (ngaySinh.equals("null")) ? "" : ngaySinh;

	String diaChi = request.getAttribute("diaChi") + "";
	diaChi = (diaChi.equals("null")) ? "" : diaChi;
	
	String dienThoai = request.getAttribute("dienThoai") + "";
	dienThoai = (dienThoai.equals("null")) ? "" : dienThoai;

	String email = request.getAttribute("email") + "";
	email = (email.equals("null")) ? "" : email;

	String giaLuongGio = request.getAttribute("giaLuongGio") + "";
	giaLuongGio = (giaLuongGio.equals("null")) ? "" : giaLuongGio;
	
	String soGioLam = request.getAttribute("soGioLam") + "";
	soGioLam = (soGioLam.equals("null")) ? "" : soGioLam;
	
	String soGioTangCa = request.getAttribute("soGioTangCa") + "";
	soGioTangCa = (soGioTangCa.equals("null")) ? "" : soGioTangCa;
	
	String soGioLamDem = request.getAttribute("soGioLamDem") + "";
	soGioLamDem = (soGioLamDem.equals("null")) ? "" : soGioLamDem;
		
	%>
<div class="container">
	<div class="text-center">
	<h1>ĐĂNG KÝ TÀI KHOẢN</h1>
	</div>
	<div class="red" id="baoLoi">
			<%=baoLoi %>
		</div>
		 <%
		 String url1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
		 %>
			<form class="form" action="<%=url1 %>/nhan-vien" method="post"><!-- chạy vô trong controller -->
			<input type="hidden" name="hanhDong" value="dang-ky"/>
			<div class="row">
				<div class="col-sm-6">
					<h3>Tài khoản</h3>
					<div class="mb-3">
						<label for="tenDangNhap" class="form-label">Tên đăng nhập<span
							class="red">*</span></label> <input type="text" class="form-control"
							id="tenDangNhap" name="tenDangNhap" required="required" value="<%=tenDangNhap%>" >
					</div>
					<div class="mb-3">
						<label for="matKhau" class="form-label">Mật khẩu<span
							class="red">*</span></label> <input type="password" class="form-control"
							id="matKhau" name="matKhau" required="required" onkeyup="kiemTraMatKhau()" >
					</div>
					<div class="mb-3">
						<label for="matKhauNhapLai" class="form-label" >Nhập lại
							mật khẩu<span class="red">*</span> <span id="msg" class="red" ></span>
						</label> <input type="password" class="form-control" id="matKhauNhapLai"
							name="matKhauNhapLai" required="required" onkeyup="kiemTraMatKhau()" >
					</div>
					<hr />
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
							</label> <input type="text" class="form-control"
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
					<div class="mb-3">
						<label for="dongYDieuKhoan" class="form-label">Đồng ý với
							điều khoản của công ty <span id="red">*</span>
						</label> <input type="checkbox" class="form-check-input"
							id="dongYDieuKhoan" name="dongYDieuKhoan" required="required" onchange="xuLyChonDongY()"><!--tạo một function đổi khi bấm nút chọn-->
					</div>
					<input class="btn btn-primary form-control" type="submit"
						value="Đăng ký" name="submit" id="submit" style="visibility: hidden;" />
				</div>
			</div>
		</form>
</div>
<jsp:include page="../footer.jsp" />
</body>
<script>
	function kiemTraMatKhau(){//tạo function kiểm ưtra mật khẩu
		matKhau = document.getElementById("matKhau").value;// lấy giá trị của mật khẩu
		matKhauNhapLai = document.getElementById("matKhauNhapLai").value;// lấy giá trị của mật khẩu nhập lại
		if(matKhau!=matKhauNhapLai){// kiểm tra xem 2 cái có giống nhau không 
			document.getElementById("msg").innerHTML = "Mật khẩu không khớp!";
			return false;
		}else{
			document.getElementById("msg").innerHTML = "";
			return true;
		}
	}
	
	function xuLyChonDongY(){
		dongYDeuKhoan = document.getElementById("dongYDieuKhoan");
		if(dongYDeuKhoan.checked==true){
			document.getElementById("submit").style.visibility="visible";
		} else {
			document.getElementById("submit").style.visibility="hidden";
		}
	}
</script>
</html>