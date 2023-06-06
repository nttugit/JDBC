package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.JDBCUtil;
import model.User;

public class UserDAO implements DAOInterface<User> {

	public static UserDAO getInstance() {
		return new UserDAO();
	}

	@Override
	public int insert(User u) {
		int result = 0;
		try {
			// B1: Tao ket noi den CSDL
			Connection conn = JDBCUtil.getConnection();


			// B3: Cau lenh SQL
			String sqlStr = "INSERT INTO User(username, password, hoVaTen) VALUES (?,?,?);";

			// B2: Tao doi tuong statement (loại câu lệnh thao tác với CSDL)
			// Nó kiểm tra và loại bỏ câu lệnh SQL để không bị hack
			PreparedStatement pst = conn.prepareStatement(sqlStr);
			pst.setString(1, u.getUsername());
			pst.setString(2, u.getPassword());
			pst.setString(3, u.getHoVaTen());

			result = pst.executeUpdate();

			// B4
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
	public int update(User u) {
		int result = 0;
		try {
			// B1: Tao ket noi den CSDL
			Connection conn = JDBCUtil.getConnection();

			String sqlStr = "UPDATE User SET password=?, hoVaTen=? WHERE username=?";

			// B2: Tao doi tuong statement (loại câu lệnh thao tác với CSDL)
			PreparedStatement pst = conn.prepareStatement(sqlStr);
			pst.setString(1, u.getPassword());
			pst.setString(2, u.getHoVaTen());
			pst.setString(3, u.getUsername());
			// B3: Cau lenh SQL

			result = pst.executeUpdate();

			// B4
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
	public int delete(User u) {
		int result = 0;
		try {
			Connection conn = JDBCUtil.getConnection();

			String sqlStr = "DELETE FROM User WHERE username=?";

			PreparedStatement pst = conn.prepareStatement(sqlStr);
			pst.setString(1, u.getUsername());
			result = pst.executeUpdate();


			System.out.println("Có " + result + " dòng bị thay đổi");


			JDBCUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<User> selectAll() {
		ArrayList<User> result = new ArrayList<User>();
		
		try {
			Connection conn = JDBCUtil.getConnection();

			String sqlStr = "SELECT * FROM User";

			PreparedStatement pst = conn.prepareStatement(sqlStr);

			ResultSet rs = pst.executeQuery();

			// B4
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hoVaTen = rs.getString("hoVaTen");

				User user = new User(username, password, hoVaTen);
				result.add(user);
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
	public User selectById(String username) {
		User result = null;
		System.out.println(username);
		try {
			// B1: Tao ket noi den CSDL
			Connection conn = JDBCUtil.getConnection();

			String sqlStr = "SELECT * FROM User WHERE username = ? ";

			PreparedStatement pst = conn.prepareStatement(sqlStr);
			pst.setString(1, username);
			// B3: Cau lenh SQL
			ResultSet rs = pst.executeQuery();
			System.out.println("Bạn đã thực thi " + sqlStr);

			// B4
			while (rs.next()) {
				String userName = rs.getString("username");
				String password = rs.getString("password");
				String hoVaTen = rs.getString("hoVaTen");

				result = new User(userName, password, hoVaTen);
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
	public ArrayList<User> selectByCondition(String condition) {
		ArrayList<User> result = new ArrayList<User>();

		try {
			Connection conn = JDBCUtil.getConnection();

			String sqlStr = "SELECT * FROM User WHERE " + condition;

			PreparedStatement pst = conn.prepareStatement(sqlStr);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hoVaTen = rs.getString("hoVaTen");

				User user = new User(username, password, hoVaTen);
				result.add(user);
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
	public User selectById(User t) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
