package model;

import java.sql.Date;
import java.util.Objects;

public class NhanVien {
		private String maNhanVien;
		private String tenDangNhap;
		private String matKhau; 
		private String hoVaTen;
		private String gioiTinh;
		private String diaChi; // xa, huyen, tinh
		private Date ngaySinh;
		private String soDienThoai;
		private String email;
		private double giaLuongGio;
		private double soGioLam;
		private double soGioTangCa;
		private double soGioLamDem;
		private String maXacThuc;
		private Date thoiGianHieuLucCuaMaXacThuc;
		private boolean trangThaiXacThuc;
		private String duongDanAnh;
		private double tongLuong;
					
		public NhanVien(String maNhanVien, String tenDangNhap, String matKhau, String hoVaTen, String gioiTinh,
				String diaChi, Date ngaySinh, String soDienThoai, String email, double giaLuongGio, double soGioLam,
				double soGioTangCa, double soGioLamDem, String maXacThuc, Date thoiGianHieuLucCuaMaXacThuc,
				boolean trangThaiXacThuc, String duongDanAnh, double tongLuong) {
			super();
			this.maNhanVien = maNhanVien;
			this.tenDangNhap = tenDangNhap;
			this.matKhau = matKhau;
			this.hoVaTen = hoVaTen;
			this.gioiTinh = gioiTinh;
			this.diaChi = diaChi;
			this.ngaySinh = ngaySinh;
			this.soDienThoai = soDienThoai;
			this.email = email;
			this.giaLuongGio = giaLuongGio;
			this.soGioLam = soGioLam;
			this.soGioTangCa = soGioTangCa;
			this.soGioLamDem = soGioLamDem;
			this.maXacThuc = maXacThuc;
			this.thoiGianHieuLucCuaMaXacThuc = thoiGianHieuLucCuaMaXacThuc;
			this.trangThaiXacThuc = trangThaiXacThuc;
			this.duongDanAnh = duongDanAnh;
			this.tongLuong = tongLuong;
		}
		public double getTongLuong() {
			tongLuong = giaLuongGio*(soGioLam+soGioTangCa*0.25);
			if (soGioLamDem>4) {
				tongLuong = tongLuong+400;
			}
			return tongLuong;
		}
		public void setTongLuong(double tongLuong) {
			this.tongLuong = tongLuong;
		}
		public String getMaNhanVien() {
			return maNhanVien;
		}
		public void setMaNhanVien(String maNhanVien) {
			this.maNhanVien = maNhanVien;
		}
		public String getTenDangNhap() {
			return tenDangNhap;
		}
		public void setTenDangNhap(String tenDangNhap) {
			this.tenDangNhap = tenDangNhap;
		}
		public String getMatKhau() {
			return matKhau;
		}
		public void setMatKhau(String matKhau) {
			this.matKhau = matKhau;
		}
		public String getHoVaTen() {
			return hoVaTen;
		}
		public void setHoVaTen(String hoVaTen) {
			this.hoVaTen = hoVaTen;
		}
		public String getGioiTinh() {
			return gioiTinh;
		}
		public void setGioiTinh(String gioiTinh) {
			this.gioiTinh = gioiTinh;
		}
		public String getDiaChi() {
			return diaChi;
		}
		public void setDiaChi(String diaChi) {
			this.diaChi = diaChi;
		}
		public Date getNgaySinh() {
			return ngaySinh;
		}
		public void setNgaySinh(Date ngaySinh) {
			this.ngaySinh = ngaySinh;
		}
		public String getSoDienThoai() {
			return soDienThoai;
		}
		public void setSoDienThoai(String soDienThoai) {
			this.soDienThoai = soDienThoai;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public double getGiaLuongGio() {
			return giaLuongGio;
		}
		public void setGiaLuongGio(double giaLuongGio) {
			this.giaLuongGio = giaLuongGio;
		}
		public double getSoGioLam() {
			return soGioLam;
		}
		public void setSoGioLam(double soGioLam) {
			this.soGioLam = soGioLam;
		}
		public double getSoGioTangCa() {
			return soGioTangCa;
		}
		public void setSoGioTangCa(double soGioTangCa) {
			this.soGioTangCa = soGioTangCa;
		}
		public double getSoGioLamDem() {
			return soGioLamDem;
		}
		public void setSoGioLamDem(double soGioLamDem) {
			this.soGioLamDem = soGioLamDem;
		}
		public String getMaXacThuc() {
			return maXacThuc;
		}
		public void setMaXacThuc(String maXacThuc) {
			this.maXacThuc = maXacThuc;
		}
		public Date getThoiGianHieuLucCuaMaXacThuc() {
			return thoiGianHieuLucCuaMaXacThuc;
		}
		public void setThoiGianHieuLucCuaMaXacThuc(Date thoiGianHieuLucCuaMaXacThuc) {
			this.thoiGianHieuLucCuaMaXacThuc = thoiGianHieuLucCuaMaXacThuc;
		}
		public boolean isTrangThaiXacThuc() {
			return trangThaiXacThuc;
		}
		public void setTrangThaiXacThuc(boolean trangThaiXacThuc) {
			this.trangThaiXacThuc = trangThaiXacThuc;
		}
		public String getDuongDanAnh() {
			return duongDanAnh;
		}
		public void setDuongDanAnh(String duongDanAnh) {
			this.duongDanAnh = duongDanAnh;
		}
		@Override
		public int hashCode() {
			return Objects.hash(diaChi, duongDanAnh, email, giaLuongGio, gioiTinh, hoVaTen, maNhanVien, maXacThuc,
					matKhau, ngaySinh, soDienThoai, soGioLam, soGioLamDem, soGioTangCa, tenDangNhap,
					thoiGianHieuLucCuaMaXacThuc, trangThaiXacThuc);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			NhanVien other = (NhanVien) obj;
			return Objects.equals(diaChi, other.diaChi) && Objects.equals(duongDanAnh, other.duongDanAnh)
					&& Objects.equals(email, other.email) && Objects.equals(giaLuongGio, other.giaLuongGio)
					&& Objects.equals(gioiTinh, other.gioiTinh) && Objects.equals(hoVaTen, other.hoVaTen)
					&& Objects.equals(maNhanVien, other.maNhanVien) && Objects.equals(maXacThuc, other.maXacThuc)
					&& Objects.equals(matKhau, other.matKhau) && Objects.equals(ngaySinh, other.ngaySinh)
					&& Objects.equals(soDienThoai, other.soDienThoai) && Objects.equals(soGioLam, other.soGioLam)
					&& Objects.equals(soGioLamDem, other.soGioLamDem) && Objects.equals(soGioTangCa, other.soGioTangCa)
					&& Objects.equals(tenDangNhap, other.tenDangNhap)
					&& Objects.equals(thoiGianHieuLucCuaMaXacThuc, other.thoiGianHieuLucCuaMaXacThuc)
					&& trangThaiXacThuc == other.trangThaiXacThuc;
		}
		@Override
		public String toString() {
			return "NhanVien [maNhanVien=" + maNhanVien + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau
					+ ", hoVaTen=" + hoVaTen + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", ngaySinh="
					+ ngaySinh + ", soDienThoai=" + soDienThoai + ", email=" + email + ", giaLuongGio=" + giaLuongGio
					+ ", soGioLam=" + soGioLam + ", soGioTangCa=" + soGioTangCa + ", soGioLamDem=" + soGioLamDem
					+ ", maXacThuc=" + maXacThuc + ", thoiGianHieuLucCuaMaXacThuc=" + thoiGianHieuLucCuaMaXacThuc
					+ ", trangThaiXacThuc=" + trangThaiXacThuc + ", duongDanAnh=" + duongDanAnh + ", tongLuong="
					+ tongLuong + "]";
		}
		public NhanVien(String maNhanVien, String tenDangNhap, String matKhau, String hoVaTen, String gioiTinh,
				String diaChi, Date ngaySinh, String soDienThoai, String email, double giaLuongGio, double soGioLam,
				double soGioTangCa, double soGioLamDem, String maXacThuc, Date thoiGianHieuLucCuaMaXacThuc,
				boolean trangThaiXacThuc, String duongDanAnh) {
			super();
			this.maNhanVien = maNhanVien;
			this.tenDangNhap = tenDangNhap;
			this.matKhau = matKhau;
			this.hoVaTen = hoVaTen;
			this.gioiTinh = gioiTinh;
			this.diaChi = diaChi;
			this.ngaySinh = ngaySinh;
			this.soDienThoai = soDienThoai;
			this.email = email;
			this.giaLuongGio = giaLuongGio;
			this.soGioLam = soGioLam;
			this.soGioTangCa = soGioTangCa;
			this.soGioLamDem = soGioLamDem;
			this.maXacThuc = maXacThuc;
			this.thoiGianHieuLucCuaMaXacThuc = thoiGianHieuLucCuaMaXacThuc;
			this.trangThaiXacThuc = trangThaiXacThuc;
			this.duongDanAnh = duongDanAnh;
		}
		public NhanVien() {
			
		}
		
		
}