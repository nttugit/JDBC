package test;

import java.sql.Connection;
import java.sql.Statement;

import database.JDBCUtil;

public class TestJDBCUtil {
	public static void main(String[] args) {
		try {
			// Bước 1: Tạo kết nối
			Connection connection = JDBCUtil.getConnection();
			System.out.println("MariaDB connected");

			// Bước 2: Tạo đối tượng kết nối
			Statement st = connection.createStatement();

			// Bước 3: Thực thi một câu lệnh SQL
			String sqlStr = "INSERT INTO persons (last_name, first_name, gender, dob, income)"
					+ "VALUES (\"Nguyen\", \"Tuan Tu Fake\", \"F\", \"2001-10-10\", 10000000);";

			// Bước 4: Xử lý kết quả
			int check = st.executeUpdate(sqlStr);
			System.out.println("Số dòng thay đổi: " + check);
			if (check > 0) {
				System.out.println("Thêm dữ liệu thành công");
			} else {
				System.out.println("Thêm dữ liệu thất bại");
			}

			// B5: Đóng kết nối
			JDBCUtil.closeConnection(connection);
			System.out.println("MariaDB disconnected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
