package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import database.NhanVienDAO;
import model.NhanVien;

/**
 * Servlet implementation class KhachHangThayDoiAnh
 */
@WebServlet("/nhan-vien-thay-doi-anh")
public class NhanVienThayDoiAnh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NhanVienThayDoiAnh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("123");
		Object obj = request.getSession().getAttribute("nhanVien");
		NhanVien nhanVien = null;// thuc hien khi co nhan vien trong he thong
		if (obj != null)
			nhanVien = (NhanVien) obj;
		if (nhanVien != null) {
			try {
				String folder = getServletContext().getRealPath("avatar");//tìm thư mục uploadfile quy dinh trong web inf web.xml
				System.out.println(folder);
				File file;//upload file cos file noi upload
				int maxFileSize = 5000 * 1024;// upload toi da 5megabyte 1 anh
				int maxMemSize = 5000 * 1024;// upload toi da bo nho

				String contentType = request.getContentType();//kiem tra file co phai multiback khong

				if (contentType.indexOf(contentType) >= 0) {// neu file o dang multipack thi upload duoc file ham su ly chuoi indexof
					DiskFileItemFactory factory = new DiskFileItemFactory();

					// Quy dinh dung luong toi da cho 1 file
					factory.setSizeThreshold(maxMemSize);

					// Tao file upload
					ServletFileUpload upload = new ServletFileUpload(factory);//lay du kien upload ra bo vo factory

					upload.setSizeMax(maxFileSize);

					List<FileItem> files = upload.parseRequest(request);// tu request lay list file toan bo file upload se nhay vao trong file

					for (FileItem fileItem : files) {
						if(!fileItem.isFormField()) {//neu file Item la file bt thi ta se khong thuc hien
							String fileName = System.currentTimeMillis() + fileItem.getName();//tao ten cua file
							String path = folder + "\\" + fileName;//duogn dan file
							file = new File(path);//tao file 
	
							fileItem.write(file);//luu noi dung xuong file
	
							nhanVien.setDuongDanAnh(fileName);//set duong dan anh bang file name
							NhanVienDAO nhanVienDAO = new NhanVienDAO();
							nhanVienDAO.updateImage(nhanVien);
							nhanVien = nhanVienDAO.selectById(nhanVien);
						}else {
							String name = fileItem.getFieldName();
							String value = fileItem.getString();
							System.out.println(name+" : "+value);
						}
					}
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}