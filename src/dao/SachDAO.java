package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.Sach;

public class SachDAO implements DAOInterface<Sach> {

	public static SachDAO getInstance() {
		return new SachDAO();
	}

	@Override
	public int insert(Sach s) {
		int result = 0;
		try {
			// B1: Tao ket noi den CSDL
			Connection conn = JDBCUtil.getConnection();

			// B2: Tao doi tuong statement (loại câu lệnh thao tác với CSDL)
			Statement st = conn.createStatement();

			// B3: Cau lenh SQL
			String sqlStr = "INSERT INTO sach(id, tenSach, giaBan, namXuatBan)" + " VALUES ('" + s.getId() + "', '"
					+ s.getTenSach() + "', " + s.getGiaBan() + ", " + s.getNamXuatBan() + ");";

			result = st.executeUpdate(sqlStr);

			// B4
			System.out.println("Bạn đã thực thi " + sqlStr);
			System.out.println("Có " + result + " dòng bị thay đổi");

			// B5
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Sach s) {
		int result = 0;
		try {
			// B1: Tao ket noi den CSDL
			Connection conn = JDBCUtil.getConnection();

			// B2: Tao doi tuong statement (loại câu lệnh thao tác với CSDL)
			Statement st = conn.createStatement();

			// B3: Cau lenh SQL
			String sqlStr = "UPDATE sach SET " + "tenSach = '" + s.getTenSach() + "', giaBan = " + s.getGiaBan()
					+ ", namXuatBan = " + s.getNamXuatBan() + " WHERE id = '" + s.getId() + "';";
			System.out.println(sqlStr);
			result = st.executeUpdate(sqlStr);

			// B4
			System.out.println("Bạn đã thực thi " + sqlStr);
			System.out.println("Có " + result + " dòng bị thay đổi");

			// B5
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(Sach s) {
		int result = 0;
		try {
			// B1: Tao ket noi den CSDL
			Connection conn = JDBCUtil.getConnection();

			// B2: Tao doi tuong statement (loại câu lệnh thao tác với CSDL)
			Statement st = conn.createStatement();

			// B3: Cau lenh SQL
			String sqlStr = "DELETE FROM sach WHERE id = '" + s.getId() + "';";
			System.out.println(sqlStr);
			result = st.executeUpdate(sqlStr);

			// B4
			System.out.println("Bạn đã thực thi " + sqlStr);
			System.out.println("Có " + result + " dòng bị thay đổi");

			// B5
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> result = new ArrayList<Sach>();
		
		try {
			// B1: Tao ket noi den CSDL
			Connection conn = JDBCUtil.getConnection();

			// B2: Tao doi tuong statement (loại câu lệnh thao tác với CSDL)
			Statement st = conn.createStatement();

			// B3: Cau lenh SQL
			String sqlStr = "SELECT * FROM sach";
			ResultSet rs = st.executeQuery(sqlStr);
			System.out.println("Bạn đã thực thi " + sqlStr);

			// B4
			while (rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				double giaBan = rs.getDouble("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");

				Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
				result.add(sach);
			}

			// B5
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Sach selectById(String bookID) {
		Sach result = null;

		try {
			// B1: Tao ket noi den CSDL
			Connection conn = JDBCUtil.getConnection();

			// B2: Tao doi tuong statement (loại câu lệnh thao tác với CSDL)
			Statement st = conn.createStatement();

			// B3: Cau lenh SQL
			String sqlStr = "SELECT * FROM sach WHERE id = '" + bookID + "'";
			ResultSet rs = st.executeQuery(sqlStr);
			System.out.println("Bạn đã thực thi " + sqlStr);

			// B4
			while (rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				double giaBan = rs.getDouble("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");

				result = new Sach(id, tenSach, giaBan, namXuatBan);
			}

			// B5
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<Sach> selectByCondition(String condition) {
		ArrayList<Sach> result = new ArrayList<Sach>();

		try {
			// B1: Tao ket noi den CSDL
			Connection conn = JDBCUtil.getConnection();

			// B2: Tao doi tuong statement (loại câu lệnh thao tác với CSDL)
			Statement st = conn.createStatement();

			// B3: Cau lenh SQL
			String sqlStr = "SELECT * FROM sach WHERE " + condition;
			ResultSet rs = st.executeQuery(sqlStr);
			System.out.println("Bạn đã thực thi " + sqlStr);

			// B4
			while (rs.next()) {
				String id = rs.getString("id");
				String tenSach = rs.getString("tenSach");
				double giaBan = rs.getDouble("giaBan");
				int namXuatBan = rs.getInt("namXuatBan");

				Sach sach = new Sach(id, tenSach, giaBan, namXuatBan);
				result.add(sach);
			}

			// B5
			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Sach selectById(Sach t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
