package test;

import dao.UserDAO;
import model.User;

public class TestUserDAO {
	public static void main(String[] args) {
		User user1 = new User("nttu3", "aaaa", "Nguyen Tuan Tu2222");
//		UserDAO.getInstance().insert(user1);
//		UserDAO.getInstance().update(user1);
		System.out.println(UserDAO.getInstance().selectById("nttu3"));
		for (User user : UserDAO.getInstance().selectAll()) {
			System.out.println(user.toString());
		}

		// Hacking query, sau khi cập nhật thành PreparedStatement thì không còn tấn
		// công được
//		System.out.println(UserDAO.getInstance().selectById("x\' or 1 = 1; -- "));

//		System.out.println(UserDAO.getInstance().selectByCondition("username=\"a1\" OR 1=1 ;--"));
	}
}
