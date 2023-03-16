package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Email {
	// Email: imsolose2312@gmail.com
	// Password: xfvzcowhafvuxdcv
	static final String from = "imsolose2312@gmail.com";
	static final String password = "xfvzcowhafvuxdcv";

	public static boolean sendEmail(String to, String tieuDe, String noiDung) {
		// Properties : khai báo các thuộc tính
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP HOST sử dụng sever nào để gửi mail
		props.put("mail.smtp.port", "587"); // TLS 587 SSL 465 có 2 port phổ biến
		props.put("mail.smtp.auth", "true");// mail phải đăng nhập được khi sử dụng host gửi mail phải đăng nhập
		props.put("mail.smtp.starttls.enable", "true");

		// create Authenticator
		Authenticator auth = new Authenticator() {//bỏ vào dự án khi lấy ra 1 phiên làm việc
			@Override// viết code để đăng nhập vô dự án
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, password);//truyền vô user name với password
			}
		};

		// Phiên làm việc
		Session session = Session.getInstance(props, auth);// đưa hết thuộc tính pro.put và auth vào trong

		// Tạo một tin nhắn
		MimeMessage msg = new MimeMessage(session);

		try {
			// Kiểu nội dung
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");

			// Người gửi
			msg.setFrom(from);

			// Người nhận
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));//tạo ra 1 địa chỉ để nhận email

			// Tiêu đề email
			msg.setSubject(tieuDe);

			// Quy đinh ngày gửi
			msg.setSentDate(new Date());

			// Quy định email nhận phản hồi
			// msg.setReplyTo(InternetAddress.parse(from, false))//nhận phản hồi từ khách hang email khác

			// Nội dung
			msg.setContent(noiDung, "text/HTML; charset=UTF-8");

			// Gửi email
			Transport.send(msg);
			System.out.println("Gửi email thành công");
			return true;
		} catch (Exception e) {
			System.out.println("Gặp lỗi trong quá trình gửi email");
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			Email.sendEmail("anhkietme@gmail.com", System.currentTimeMillis() + "", "Tấn sida");
		}

	}

}