package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import database.NhanVienDAO;
import model.NhanVien;
import util.Email;
import util.MaHoa;
import util.SoNgauNhien;

/**
 * Servlet implementation class NhanVien
 */
@WebServlet("/nhan-vien")
public class NhanVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NhanVienController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hanhDong = request.getParameter("hanhDong");
		if (hanhDong.equals("dang-nhap")) {// nếu hành động là đăng nhập
			dangNhap(request, response);
		} else if (hanhDong.equals("dang-xuat")) {
			dangXuat(request, response);
		} else if (hanhDong.equals("dang-ky")) {
			dangKy(request, response);
		} else if (hanhDong.equals("doi-mat-khau")) {
			doiMatKhau(request, response);
		} else if (hanhDong.equals("thay-doi-thong-tin")) {
			thayDoiThongTin(request, response);
		} else if (hanhDong.equals("xac-thuc")) {
			xacThuc(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void dangNhap(HttpServletRequest request, HttpServletResponse response) {
		try {
			String tenDangNhap = request.getParameter("tenDangNhap");// lấy tên đăng nhập
			String matKhau = request.getParameter("matKhau");// lấy password

			matKhau = MaHoa.toSHA1(matKhau);// so sanh 2 chuỗi đã bị mã hóa với nhau
			System.out.println("Mat khau ma hoa: " + matKhau);

			NhanVien nv = new NhanVien();// tìm kiếm nhân viên
			nv.setTenDangNhap(tenDangNhap); // truyền vào 1 tên đăng nhập
			nv.setMatKhau(matKhau);// truyền vào mật khẩu

			NhanVienDAO nvd = new NhanVienDAO();// cho nhân viên DAO vô
			NhanVien nhanVien = nvd.selectByUsernameAndPassWord(nv);// tạo 1 nhân viên vô
			String url = "";
			if (nhanVien != null) {// nếu có 1 nhân viên đăng nhập thành công khac null
				HttpSession session = request.getSession();// tạo ra 1 sesion để lưu trữ thông tin sau đó lấy session ra
				session.setAttribute("nhanVien", nhanVien);// set nhân viên vào
				url = "/index.jsp";// quay lại trang index.jsp
			} else {
				request.setAttribute("baoLoi", "Tên đăng nhập hoặc mật khẩu không đúng");// set attribute tên báo lỗi,
																							// quay lại trang đăng nhập
																							// và báo lỗi
				url = "/nhanvien/dangnhap.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void dangXuat(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession();
			// Huy bo session
			session.invalidate();

			String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();

			response.sendRedirect(url + "/index.jsp");// trở về index
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void dangKy(HttpServletRequest request, HttpServletResponse response) {
		try {
			String tenDangNhap = request.getParameter("tenDangNhap");
			String matKhau = request.getParameter("matKhau");
			String matKhauNhapLai = request.getParameter("matKhauNhapLai");
			String hoVaTen = request.getParameter("hoVaTen");
			String gioiTinh = request.getParameter("gioiTinh");
			String ngaySinh = request.getParameter("ngaySinh");
			String diaChi = request.getParameter("diaChi");
			String dienThoai = request.getParameter("dienThoai");
			String email = request.getParameter("email");
			String giaLuongGio = request.getParameter("giaLuongGio");
			String soGioLam = request.getParameter("soGioLam");
			String soGioTangCa = request.getParameter("soGioTangCa");
			String soGioLamDem = request.getParameter("soGioLamDem");
			
			request.setAttribute("tenDangNhap", tenDangNhap);// tuy báo lỗi nhưng giữ lại thông tin khách hàng trừ mật
																// khẩu
			request.setAttribute("hoVaTen", hoVaTen);// lấy lại thông tin để khách không phải đăng nhập lại
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("ngaySinh", ngaySinh);
			request.setAttribute("diaChi", diaChi);
			request.setAttribute("dienThoai", dienThoai);
			request.setAttribute("email", email);
			request.setAttribute("giaLuongGio", giaLuongGio);
			request.setAttribute("soGioLam", soGioLam);
			request.setAttribute("soGioTangCa", soGioTangCa);
			request.setAttribute("soGioLamDem", soGioLamDem);
			

			System.out.println(ngaySinh);

			String url = "";// String url bằng rỗng

			String baoLoi = "";// ban đầu không có lỗi gì cả

			NhanVienDAO nhanVienDAO = new NhanVienDAO();// tạo 1 nhân viên lấy trong cơ sở dữ liệu

			if (nhanVienDAO.kiemTraTenDangNhap(tenDangNhap)) {// kiểm tra truyền tên đăng nhập vô
				baoLoi += "Tên đăng nhập đã tồn tại, vui lòng chọn tên đăng nhập khác.<br/> ";
			}
			System.out.println("Mat khau: " + matKhau);
			System.out.println("Mat khau nhap lai: " + matKhauNhapLai);
			System.out.println(matKhau.equals(matKhauNhapLai));
			if (!matKhau.equals(matKhauNhapLai)) {// kiểm tra mật khẩu
				baoLoi += "Mật khẩu không khớp.<br/> ";
			} else {// trước khi lưu xuống hệ thống cần mã hóa mật khẩu
				matKhau = MaHoa.toSHA1(matKhau);
			}
			request.setAttribute("baoLoi", baoLoi);
			System.out.print("Bao loi: " + baoLoi);

			if (baoLoi.length() > 0) {// nếu có tồn tại báo lỗi
				url = "/nhanvien/dangky.jsp";
			} else {
				Random ran = new Random();
				String maNhanVien = System.currentTimeMillis() + ran.nextInt(1000) + "";// ngẫu nhiên trong số 1000 cho
																						// no thành chuỗi
							
				NhanVien nv = new NhanVien(maNhanVien, tenDangNhap, matKhau, hoVaTen, gioiTinh, diaChi,
						Date.valueOf(ngaySinh), dienThoai, email, Double.parseDouble(giaLuongGio),
						Double.parseDouble(soGioLam), Double.parseDouble(soGioLamDem), Double.parseDouble(soGioTangCa),
						"", null, false, "");
					if(nhanVienDAO.insert(nv)>0) {//nếu đăng ký thành công
					
					//dãy số xác thực ngẪU NHIÊN
					String soNgauNhien = SoNgauNhien.getSoNgauNhien();
					// Quy dinh thoi gian hieu luc
					Date todaysDate = new Date(new java.util.Date().getTime());
					Calendar c = Calendar.getInstance();
					c.setTime(todaysDate);//ngày đăng ký hôm nay
					c.add(Calendar.DATE, 1);//thêm thời gian cộng thêm 1 ngày
					Date thoiGianHieuLucCuaMaXacThuc = new Date(c.getTimeInMillis());
					
					// Trang thai xac thuc = false
					boolean trangThaiXacThuc = false;//đầu tiên chưa có nv nên bằng false

					nv.setMaXacThuc(soNgauNhien);//tạo mã xác thực
					nv.setThoiGianHieuLucCuaMaXacThuc(thoiGianHieuLucCuaMaXacThuc);//set thời gian hiệu lực 24h
					nv.setTrangThaiXacThuc(trangThaiXacThuc);//mặc định false
					
					
					if (nhanVienDAO.updateVerifyInformation(nv) > 0) {//thêm 1 khách hàng xuống
						// Gui email cho khach hang
						Email.sendEmail(nv.getEmail(), "Xác thực tài khoản tại trananhkiet.vn", getNoiDung(nv));
					}
					
				}// thêm ông nhân viên vô
				url = "/nhanvien/thanhcong.jsp";
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);// đi đến trang url
			rd.forward(request, response);// truyển request và response
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	private void xacThuc(HttpServletRequest request, HttpServletResponse response) {
		try {
			String maNhanVien = request.getParameter("maNhanVien");
			String maXacThuc = request.getParameter("maXacThuc");

			NhanVienDAO nhanVienDAO = new NhanVienDAO();

			NhanVien nv = new NhanVien();
			nv.setMaNhanVien(maNhanVien);
			NhanVien nhanVien = nhanVienDAO.selectById(nv);

			String msg = "";
			if (nhanVien != null) {
				// Kiem tra ma xac thuc co giong nhau hay khong? // Kiem tra xem ma xac thuc con
				// hieu luc hay khong?
				if (nhanVien.getMaXacThuc().equals(maXacThuc)) {// so sánh 2 mã xác thực
					// Thanh Cong
					nhanVien.setTrangThaiXacThuc(true);// đổi từ false sang true
					nhanVienDAO.updateVerifyInformation(nhanVien);
					msg = "Xác thực thành công!";
				} else {
					// That Bai
					msg = "Xác thực không thành công!";
				}
			} else {
				msg = "Tài khoản không tồn tại!";
			}
			String url = "/nhanvien/thongbao.jsp";
			request.setAttribute("baoLoi", msg);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void doiMatKhau(HttpServletRequest request, HttpServletResponse response) {
		try {
			String matKhauHienTai = request.getParameter("matKhauHienTai");// lấy ra được mật khẩu hiện tại
			String matKhauMoi = request.getParameter("matKhauMoi");// lấy ra mật khẩu mới nhập lại
			String matKhauMoiNhapLai = request.getParameter("matKhauMoiNhapLai");// lấy ra mật khẩu mới nhập lại

			String matKhauHienTai_Sha1 = MaHoa.toSHA1(matKhauHienTai);// mật khẩu để so sanh

			String baoLoi = "";
			String url = "/nhanvien/doimatkhau.jsp";

			// Kiem tra mat khau cu co giong hay khong
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("nhanVien");// lấy nhân viên ra
			NhanVien nhanVien = null;//
			if (obj != null)// ép kiểu
				nhanVien = (NhanVien) obj;
			if (nhanVien == null) {
				baoLoi = "Bạn chưa đăng nhập vào hệ thống!";// nhân viên chưa đăng nhập
			} else {
				// Neu khach hang da dang nhap
				if (!matKhauHienTai_Sha1.equals(nhanVien.getMatKhau())) {// mât khẩu và mật khẩu nhập lại kiểm tra
					baoLoi = "Mật khẩu hiện tại không chính xác!";
				} else {// nếu cả 2 đúng
					if (!matKhauMoi.equals(matKhauMoiNhapLai)) {
						baoLoi = "Mật khẩu nhập lại không khớp!";
					} else {
						String matKhauMoi_Sha1 = MaHoa.toSHA1(matKhauMoi);// mã hóa mật khẩu mới
						nhanVien.setMatKhau(matKhauMoi_Sha1);// set mật khẩu mới
						NhanVienDAO khd = new NhanVienDAO();
						if (khd.changePassword(nhanVien)) {// truyền vô hàm 1 nhân viên
							baoLoi = "Mật khẩu đã thay đổi thành công!";
						} else {
							baoLoi = "Quá trình thay đổi mật khẩu không thành công!";
						}
					}
				}
			}
			// lay bao loi ra
			request.setAttribute("baoLoi", baoLoi);
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void thayDoiThongTin(HttpServletRequest request, HttpServletResponse response) {
		try {
			String hoVaTen = request.getParameter("hoVaTen");
			String gioiTinh = request.getParameter("gioiTinh");
			String ngaySinh = request.getParameter("ngaySinh");
			String diaChi = request.getParameter("diaChi");
			String dienThoai = request.getParameter("dienThoai");
			String email = request.getParameter("email");
			String giaLuongGio = request.getParameter("giaLuongGio");
			String soGioLam = request.getParameter("soGioLam");
			String soGioTangCa = request.getParameter("soGioTangCa");
			String soGioLamDem = request.getParameter("soGioLamDem");
			request.setAttribute("hoVaTen", hoVaTen);// lấy lại thông tin để khách không phải đăng nhập lại
			request.setAttribute("gioiTinh", gioiTinh);
			request.setAttribute("ngaySinh", ngaySinh);
			request.setAttribute("diaChi", diaChi);
			request.setAttribute("dienThoai", dienThoai);
			request.setAttribute("email", email);
			request.setAttribute("giaLuongGio", giaLuongGio);
			request.setAttribute("soGioLam", soGioLam);
			request.setAttribute("soGioTangCa", soGioTangCa);
			request.setAttribute("soGioLamDem", soGioLamDem);
//		System.out.println(ngaySinh);

			String url = "";// String url bằng rỗng

			String baoLoi = "";// ban đầu không có lỗi gì cả

			NhanVienDAO nhanVienDAO = new NhanVienDAO();// tạo 1 nhân viên lấy trong cơ sở dữ liệu

			request.setAttribute("baoLoi", baoLoi);
			System.out.print("Bao loi: " + baoLoi);

			if (baoLoi.length() > 0) {// nếu có tồn tại báo lỗi
				url = "/nhanvien/dangky.jsp";
			} else {
				Object obj = request.getSession().getAttribute("nhanVien");// getAttribute lúc nào cũng có đối tượng nên
																			// phải ép kiểu
				NhanVien nhanVien = null; // ép kiểu có 1 nhân viên bằng null
				if (obj != null)// hiển thị ra khi nhân viên khac null
					nhanVien = (NhanVien) obj;
				if (nhanVien != null) {
					String maNhanVien = nhanVien.getMaNhanVien();// truyền mã khách hàng vào
					NhanVien nv = new NhanVien(maNhanVien, "", "", hoVaTen, gioiTinh, diaChi, Date.valueOf(ngaySinh),
							dienThoai, email, Double.parseDouble(giaLuongGio), Double.parseDouble(soGioLam),
							Double.parseDouble(soGioLamDem), Double.parseDouble(soGioTangCa), "", null, false, "");
					nhanVienDAO.updateInfo(nv);// thêm ông nhân viên vô
					url = "/nhanvien/thanhcong.jsp";
				}
			}
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);// đi đến trang url
			rd.forward(request, response);// truyển request và response
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getNoiDung(NhanVien nv) {
		String link = "http://localhost:8080/WebTinhLuong/nhan-vien?hanhDong=xac-thuc&maNhanVien="
				+ nv.getMaNhanVien() + "&maXacThuc=" + nv.getMaXacThuc();
		String noiDung = "<p>trananhkiet.vn xin ch&agrave;o bạn <strong>" + nv.getHoVaTen() + "</strong>,</p>\r\n"
				+ "<p>Vui l&ograve;ng x&aacute;c thực t&agrave;i khoản của bạn bằng c&aacute;ch nhập m&atilde; <strong>"
				+ nv.getMaXacThuc() + "</strong>, hoặc click trực tiếp v&agrave;o đường link sau đ&acirc;y:</p>\r\n"
				+ "<p><a href=\"" + link + "\">" + link + "</a></p>\r\n"
				+ "<p>Đ&acirc;y l&agrave; email tự động, vui l&ograve;ng kh&ocirc;ng phản hồi email n&agrave;y.</p>\r\n"
				+ "<p>Tr&acirc;n trọng cảm ơn.</p>";
		return noiDung;
	}
}
