package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.KhachHang;


public class KhachHangDAO implements DAOInterface<KhachHang> {

	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}

	@Override
	public int insert(KhachHang k) {
		int result = 0;
		try {
			// B1: Tao ket noi den CSDL
			Connection conn = JDBCUtil.getConnection();

			// B2: Tao doi tuong statement (loại câu lệnh thao tác với CSDL)
			Statement st = conn.createStatement();

			// B3: Cau lenh SQL
			String sqlStr = "INSERT INTO khachhang(hoVaTen, ngaySinh, diaChi)" + " VALUES ('" + k.getHoVaTen() + "', '"
					+ k.getNgaySinh() + "', '" + k.getDiaChi() + "');";
//			
//			System.out.println(sqlStr);
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
	public int update(KhachHang k) {
		int result = 0;
		try {
			// B1: Tao ket noi den CSDL
			Connection conn = JDBCUtil.getConnection();

			// B2: Tao doi tuong statement (loại câu lệnh thao tác với CSDL)
			Statement st = conn.createStatement();

			// B3: Cau lenh SQL
			String sqlStr = "UPDATE khachhang SET " + "hoVaTen = '" + k.getHoVaTen() + "', ngaySinh = '"
					+ k.getNgaySinh() + "', diaChi = '" + k.getDiaChi() + "' WHERE id = '" + k.getId() + "';";
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
	public int delete(KhachHang k) {
		int result = 0;
		try {
			// B1: Tao ket noi den CSDL
			Connection conn = JDBCUtil.getConnection();

			// B2: Tao doi tuong statement (loại câu lệnh thao tác với CSDL)
			Statement st = conn.createStatement();

			// B3: Cau lenh SQL
			String sqlStr = "DELETE FROM khachhang WHERE id = '" + k.getId() + "';";
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
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> result = new ArrayList<KhachHang>();

		try {
			// B1: Tao ket noi den CSDL
			Connection conn = JDBCUtil.getConnection();

			// B2: Tao doi tuong statement (loại câu lệnh thao tác với CSDL)
			Statement st = conn.createStatement();

			// B3: Cau lenh SQL
			String sqlStr = "SELECT * FROM khachhang";
			ResultSet rs = st.executeQuery(sqlStr);
			System.out.println("Bạn đã thực thi " + sqlStr);

			// B4
			while (rs.next()) {
				int id = rs.getInt("id");
				String hoVaTen = rs.getString("hoVaTen");
				Date ngaySinh = (Date) rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");

				KhachHang khachHang = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
				result.add(khachHang);
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
	public KhachHang selectById(KhachHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<KhachHang> selectByCondition(String condition) {
		ArrayList<KhachHang> result = new ArrayList<KhachHang>();

		try {
			// B1: Tao ket noi den CSDL
			Connection conn = JDBCUtil.getConnection();

			// B2: Tao doi tuong statement (loại câu lệnh thao tác với CSDL)
			Statement st = conn.createStatement();

			// B3: Cau lenh SQL
			String sqlStr = "SELECT * FROM khachhang WHERE " + condition;
			ResultSet rs = st.executeQuery(sqlStr);
			System.out.println("Bạn đã thực thi " + sqlStr);

			// B4
			while (rs.next()) {
				int id = rs.getInt("id");
				String hoVaTen = rs.getString("tenSach");
				Date ngaySinh = (Date) rs.getDate("giaBan");
				String diaChi = rs.getString("diaChi");

				KhachHang khachHang = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
				result.add(khachHang);
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
	public KhachHang selectById(String t) {
		// TODO Auto-generated method stub
		return null;
	}

}
