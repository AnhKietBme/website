package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.NhanVien;

public class NhanVienDAO implements DAOinterface<NhanVien> {
//	private ArrayList<NhanVien>data = new ArrayList<>();// tạo một data chứa nhiều ông nhân viên

//	public ArrayList<NhanVien> selectALL() {// Tra ve tat ca tac gia co trong arraylist
//		return data;
//	}

//	public NhanVien selectById(String id) {// lay ra 1 nhan vien dua tren ma nhan vien
//
//		NhanVien tim = new NhanVien();// tạo ra 1 nhân viên để tìm kiếm
//		tim.setMaNhanVien(id);// truyền vô 1 cái ID người ta truyền cho nhân viên
//
//		for (NhanVien nhanVien : data) {// for đi từ đầu đến cuối mảng
//			if (nhanVien.equals(tim)) {// so sánh bằng
//				return nhanVien;// nếu tìm ra trả về nhân viên
//			}
//		}
//		return null; // nếu đi từ cuối về không tìm ra nhân viên trả về null
//	}
//
//	public int insert(NhanVien nv) {// them nhan vien vao data khi chua ton tai nhan vien
//		NhanVien kiemTraTonTai = this.selectById(nv.getMaNhanVien());// nhân viên kiểm tra tồn tại bằng bỏ mã nhân viên
//																		// vô
//		if (kiemTraTonTai != null) {// kiểm tra khác null thì add nhân viên vào
//			data.add(nv);
//			return 1;// đã thêm 1 ông nhân viên vào
//		} else {
//			return 0;// nếu đã tồn tại vào thì không thêm nhân viên vô được
//		}
//	}
//
//	public int insertALL(ArrayList<NhanVien> list) {// thêm hết tất cả nhân viên vô cơ sở dữ liệu
//		int dem = 0;// đếm xem bao nhiêu nhân viên thêm vào được
//		for (NhanVien nhanVien : list) {// đi từ đầu đến cuối thêm từng ông nhân viên vào
//			dem += this.insert(nhanVien);// thêm từng ông nhân viên vào
//		}
//		return dem;
//	}
//
//	public int delete(NhanVien nv) {// kiểm tra nhân viên có tồn tại hay không
//		NhanVien kiemTraTonTai = this.selectById(nv.getMaNhanVien());// nhân viên kiểm tra tồn tại bằng bỏ mã nhân viên
//																		// vô
//		if (kiemTraTonTai != null) {// kiểm tra khác null thì add nhân viên vào
//			data.remove(nv);// xóa đi 1 nhân viên
//			return 1;// đã xóa 1 ông nhân viên di
//		} else {
//			return 0;// nếu đã tồn tại vào thì không xóa nhân viên vô được
//		}
//	}
//
//	public int deleteALL(ArrayList<NhanVien> list) {// thêm hết tất cả nhân viên vô cơ sở dữ liệu
//		int dem = 0;// đếm xem bao nhiêu nhân viên thêm vào được
//		for (NhanVien nhanVien : list) {// đi từ đầu đến cuối thêm từng ông nhân viên vào
//			dem -= this.delete(nhanVien);// thêm từng ông nhân viên vào
//		}
//		return dem;
//	}
//
//	public int update(NhanVien nv) {// kiểm tra có tồn tại hay không để update
//		NhanVien kiemTraTonTai = this.selectById(nv.getMaNhanVien());// nhân viên kiểm tra tồn tại bằng bỏ mã nhân viên
//																		// vô
//		if (kiemTraTonTai != null) {// kiểm tra khác null thì add nhân viên vào
//			data.remove(kiemTraTonTai);// xóa đi trong ton tai
//			data.add(nv);// add nhan vien moi vao
//			return 1;// đã xóa 1 ông nhân viên di
//		} else {
//			return 0;//
//		}
//	}

	@Override
	public ArrayList<NhanVien> selectAll() {
		ArrayList<NhanVien> ketQua = new ArrayList<NhanVien>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();// lay ket noi tu file JDBCUtil

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM nhanvien";
			PreparedStatement st = con.prepareStatement(sql);

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4: xu ly ket qua
			while (rs.next()) {
				String maNhanVien = rs.getString("manhanvien");
				String tenDangNhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hovaten");
				String gioiTinh = rs.getString("gioitinh");
				String diaChi = rs.getString("diachi");
				Date ngaySinh = rs.getDate("ngaysinh");
				String soDienThoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				double giaLuongGio = rs.getDouble("gialuonggio");
				double soGioLam = rs.getDouble("sogiolam");
				double soGioTangCa  = rs.getDouble("sogiotangca");
				double soGioLamDem = rs.getDouble("sogiolamdem");
				String maXacThuc = rs.getString("maxacthuc");
				Date thoiGianHieuLucCuaMaXacThuc = rs.getDate("thoigianhieuluccuamaxacthuc");
				boolean trangThaiXacThuc = rs.getBoolean("trangthaixacthuc");
				String duongDanAnh = rs.getString("duongdananh");
				
				NhanVien nv = new NhanVien(maNhanVien, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi, ngaySinh, soDienThoai, email, giaLuongGio, soGioLam, soGioTangCa, soGioLamDem, maXacThuc, thoiGianHieuLucCuaMaXacThuc, trangThaiXacThuc, duongDanAnh);
				ketQua.add(nv);// them nhan vien vao array list
			}

			// Bước 5: ngat ket noi
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;// sau khi dong ket noi tra ve ket qua
	}

	@Override
	public NhanVien selectById(NhanVien t) {// lay ra 1 nhan vien thoi
		NhanVien ketQua = null;// thay vi co 1 array list day chi 1 nhan vien thoi. lay ra theo ID chi co 1
								// nguoi thoi
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();// lay ket noi tu file JDBCUtil

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM nhanvien WHERE manhanvien=?";// lay 1 nhan vien bang 1 ma nhan vien
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaNhanVien());// tuy theo ma tac gia set dung loai

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4: xu ly ket qua
			while (rs.next()) {
				String manhanvien = rs.getString("manhanvien");
				String tendangnhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hovaten");
				String gioitinh = rs.getString("gioitinh");
				String diachi = rs.getString("diachi");
				Date ngaysinh = rs.getDate("ngaysinh");
				String sodienthoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				double gialuonggio = rs.getDouble("gialuonggio");
				double sogiolam = rs.getDouble("sogiolam");
				double sogiotangca = rs.getDouble("sogiotangca");
				double sogiolamdem = rs.getDouble("sogiolamdem");
				String maxacthuc = rs.getString("maxacthuc");
				Date thoigianhieuluccuamaxacthuc = rs.getDate("thoigianhieuluccuamaxacthuc");
				boolean trangthaixacthuc = rs.getBoolean("trangthaixacthuc");
				String duongdananh = rs.getString("duongdananh");

				ketQua = new NhanVien(manhanvien, tendangnhap, matKhau, hoVaTen, gioitinh, diachi, ngaysinh, sodienthoai, email, gialuonggio, sogiolam, sogiotangca, sogiolamdem, maxacthuc, thoigianhieuluccuamaxacthuc, trangthaixacthuc, duongdananh);
				break;// co 1 nhan vien chon ra roi ket thuc luon
			}

			// Bước 5: ngat ket noi
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;// sau khi dong ket noi tra ve ket qua
	}
		public NhanVien selectByUsernameAndPassWord(NhanVien t) {// lay ra 1 nhan vien thoi
		NhanVien ketQua = null;// thay vi co 1 array list day chi 1 nhan vien thoi. lay ra theo ID chi co 1
								// nguoi thoi
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();// lay ket noi tu file JDBCUtil

			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM nhanvien WHERE tendangnhap=? and matkhau=?";// lay 1 nhan vien bang 1 ma nhan vien
			PreparedStatement st = con.prepareStatement(sql);
			System.out.println(t.getTenDangNhap()+"/"+t.getMatKhau());
			
			st.setString(1, t.getTenDangNhap());// bỏ tên đăng nhập vô
			st.setString(2, t.getMatKhau());// bỏ tên đăng nhập vô nếu khớp
			
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = st.executeQuery();

			// Bước 4: xu ly ket qua
			while (rs.next()) {
				String manhanvien = rs.getString("manhanvien");
				String tendangnhap = rs.getString("tendangnhap");
				String matKhau = rs.getString("matkhau");
				String hoVaTen = rs.getString("hovaten");
				String gioitinh = rs.getString("gioitinh");
				String diachi = rs.getString("diachi");
				Date ngaysinh = rs.getDate("ngaysinh");
				String sodienthoai = rs.getString("sodienthoai");
				String email = rs.getString("email");
				double gialuonggio = rs.getDouble("gialuonggio");
				double sogiolam = rs.getDouble("sogiolam");
				double sogiotangca = rs.getDouble("sogiotangca");
				double sogiolamdem = rs.getDouble("sogiolamdem");
				String maxacthuc = rs.getString("maxacthuc");
				Date thoigianhieuluccuamaxacthuc = rs.getDate("thoigianhieuluccuamaxacthuc");
				boolean trangthaixacthuc = rs.getBoolean("trangthaixacthuc");
				String duongdananh = rs.getString("duongdananh");

				ketQua = new NhanVien(manhanvien, tendangnhap, matKhau, hoVaTen, gioitinh, diachi, ngaysinh, sodienthoai, email, gialuonggio, sogiolam, sogiotangca, sogiolamdem, maxacthuc, thoigianhieuluccuamaxacthuc, trangthaixacthuc, duongdananh);
				break;// co 1 nhan vien chon ra roi ket thuc luon
			}

			// Bước 5: ngat ket noi
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;// sau khi dong ket noi tra ve ket qua
	}
	@Override
	public int insert(NhanVien t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO nhanvien (manhanvien, tendangnhap, matkhau, hovaten, gioitinh, diachi, ngaysinh, sodienthoai, email, gialuonggio, sogiolam, sogiotangca, sogiolamdem, maxacthuc, thoigianhieuluccuamaxacthuc, trangthaixacthuc, duongdananh, tongluong) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaNhanVien());
			st.setString(2, t.getTenDangNhap());
			st.setString(3, t.getMatKhau());
			st.setString(4, t.getHoVaTen());
			st.setString(5, t.getGioiTinh());
			st.setString(6, t.getDiaChi());
			st.setDate(7, t.getNgaySinh());
			st.setString(8, t.getSoDienThoai());
			st.setString(9, t.getEmail());
			st.setDouble(10, t.getGiaLuongGio());
			st.setDouble(11, t.getSoGioLam());
			st.setDouble(12, t.getSoGioTangCa());
			st.setDouble(13, t.getSoGioLamDem());
			st.setString(14, t.getMaXacThuc());
			st.setDate(15, t.getThoiGianHieuLucCuaMaXacThuc());
			st.setBoolean(16, t.isTrangThaiXacThuc());
			st.setString(17, t.getDuongDanAnh());
			st.setDouble(18, t.getTongLuong());

			// Bước 3: thực thi câu lệnh SQL
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int insertAll(ArrayList<NhanVien> arr) {
		int dem = 0;
		for (NhanVien nhanVien : arr) {
			dem += this.insert(nhanVien);
		}
		return dem;
	}
	
	
	@Override
	public int delete(NhanVien t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from nhanvien " + " WHERE manhanvien=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaNhanVien());

			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}

	@Override
	public int update(NhanVien t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE nhanvien " + " SET " + " tendangnhap=?" + ", matkhau=?" + ", hovaten=?" + ", gioitinh=?"
					+ ", diachi=?" + ", ngaysinh=?" + ", sodienthoai=?" + ", email=?" + ", gialuonggio=?"
					+ ", sogiolam=?" + ", sogiotangca=?" + ", sogiolamdem=?" + ", maxacthuc=?"
					+ ", thoigianhieuluccuamaxacthuc=?" + ", trangthaixacthuc=?" + ", duongdananh=?" +", tongluong=?"
					+ " WHERE manhanvien=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getTenDangNhap());
			st.setString(2, t.getMatKhau());
			st.setString(3, t.getHoVaTen());
			st.setString(4, t.getGioiTinh());
			st.setString(5, t.getDiaChi());
			st.setDate(6, t.getNgaySinh());
			st.setString(7, t.getSoDienThoai());
			st.setString(8, t.getEmail());
			st.setDouble(9, t.getGiaLuongGio());
			st.setDouble(10, t.getSoGioLam());
			st.setDouble(11, t.getSoGioTangCa());
			st.setDouble(12, t.getSoGioLamDem());
			st.setString(13, t.getMaXacThuc());
			st.setDate(14, t.getThoiGianHieuLucCuaMaXacThuc());
			st.setBoolean(15, t.isTrangThaiXacThuc());
			st.setString(16, t.getDuongDanAnh());
			st.setString(17, t.getMaNhanVien());
			st.setDouble(18, t.getTongLuong());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	
	
	public int updateVerifyInformation(NhanVien t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE nhanvien " + " SET " + " maxacthuc=?"
					+ ", thoigianhieuluccuamaxacthuc=?" + ", trangthaixacthuc=?" 
					+ " WHERE manhanvien=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMaXacThuc());
			st.setDate(2, t.getThoiGianHieuLucCuaMaXacThuc());
			st.setBoolean(3, t.isTrangThaiXacThuc());
			st.setString(4, t.getMaNhanVien());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	
	public int updateImage(NhanVien t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE nhanvien " + " SET " + " duongdananh=?" 
					+ " WHERE manhanvien=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getDuongDanAnh());
			st.setString(2, t.getMaNhanVien());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	public int updateInfo(NhanVien t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE nhanvien " + " SET "  + " hovaten=?" + ", gioitinh=?"
					+ ", diachi=?" + ", ngaysinh=?" + ", sodienthoai=?" + ", email=?" + ", gialuonggio=?"
					+ ", sogiolam=?" + ", sogiotangca=?" + ", sogiolamdem=?" + ", maxacthuc=?"
					+ ", thoigianhieuluccuamaxacthuc=?" + ", trangthaixacthuc=?" + ", duongdananh=?"+ ", tongluong=?"
					+ " WHERE manhanvien=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getHoVaTen());
			st.setString(2, t.getGioiTinh());
			st.setString(3, t.getDiaChi());
			st.setDate(4, t.getNgaySinh());
			st.setString(5, t.getSoDienThoai());
			st.setString(6, t.getEmail());
			st.setDouble(7, t.getGiaLuongGio());
			st.setDouble(8, t.getSoGioLam());
			st.setDouble(9, t.getSoGioTangCa());
			st.setDouble(10, t.getSoGioLamDem());
			st.setString(11, t.getMaXacThuc());
			st.setDate(12, t.getThoiGianHieuLucCuaMaXacThuc());
			st.setBoolean(13, t.isTrangThaiXacThuc());
			st.setString(14, t.getDuongDanAnh());
			st.setString(15, t.getMaNhanVien());
			st.setDouble(16, t.getTongLuong());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua;
	}
	public boolean changePassword(NhanVien t) {
		int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = JDBCUtil.getConnection();

			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE nhanvien " + " SET "  + " matkhau=?" + " WHERE manhanvien=?";

			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getMatKhau());
			st.setString(2, t.getMaNhanVien());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = st.executeUpdate();

			// Bước 4:
			System.out.println("Bạn đã thực thi: " + sql);
			System.out.println("Có " + ketQua + " dòng bị thay đổi!");

			// Bước 5:
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ketQua>0;
	}
	@Override
	public int deleteAll(ArrayList<NhanVien> arr) {
		int dem = 0;
		for (NhanVien nhanVien : arr) {
			dem += this.delete(nhanVien);
		}
		return dem;
	}

	public boolean kiemTraTenDangNhap(String tenDangNhap) {// lay ra 1 tendangnhap
	boolean ketQua = false;//kết quả ban đầu bằng false không có nhân viên nào cả
	try {
		// Bước 1: tạo kết nối đến CSDL
		Connection con = JDBCUtil.getConnection();//lay ket noi tu file JDBCUtil

		// Bước 2: tạo ra đối tượng statement
		String sql = "SELECT * FROM nhanvien WHERE tenDangNhap=?";// lay 1 nhan vien bang 1 ma nhan vien
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, tenDangNhap);//tuy theo ma tac gia set dung loai

		// Bước 3: thực thi câu lệnh SQL
		System.out.println(sql);
		ResultSet rs = st.executeQuery();

		// Bước 4: xu ly ket qua
		while (rs.next()) {//lấy lên có dữ liệu
		  ketQua = true;
			
		}

		// Bước 5: ngat ket noi
		JDBCUtil.closeConnection(con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return ketQua;// sau khi dong ket noi tra ve ket qua
}
//	public static void main(String[] args) {
//		NhanVienDAO nvd = new NhanVienDAO();
//		ArrayList<NhanVien> kq = nvd.selectAll();
//		for (NhanVien nhanVien : kq) {
//			System.out.println(nhanVien.toString());
//		}
//		NhanVien nv = nvd.selectById(new NhanVien("TG1", null, null, null, null, null, null, null, null, 0, 0, 0, 0, null, null, false, null));
//		System.out.println(nv);
//		
//		NhanVien nv_new = new NhanVien("TG10", null, null, null, null, null, null, null, null, 0, 0, 0, 0, null, null, false, null);
//		nvd.delete(nv_new);
//		NhanVien nv = nvd.selectById(new NhanVien("TG1", null, null, null, null, null, null, null, null, 0, 0, 0, 0, null, null, false, null));
//		System.out.println(nv);
//		nv.setDiaChi("Địa chỉ đã bị thay đổi");
//		nvd.update(nv);
	}
//}