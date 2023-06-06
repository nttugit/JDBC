package test;

import java.util.ArrayList;

import dao.SachDAO;
import model.Sach;

public class TestSachDAO {
	public static void main(String[] args) {
//		DDL
		// Insert one
//		Sach sachDacNhanTam = new Sach("1111", "Dac Nhan Tam 2", 35000, 1945);
//		int result = SachDAO.getInstance().insert(sachDacNhanTam);
//
		// Insert many
//		for (int i = 1; i <= 1000; i++) {
//			Sach sach = new Sach("S" + i, "Spring in action " + i + "th", 210000 + i, 2020 + i);
//			result = SachDAO.getInstance().insert(sach);
//		}
//
		// Update
//		Sach sachDacNhanTamMoi = new Sach("1111", "Dac Nhan Tam Super", 110000, 2023);
//		SachDAO.getInstance().update(sachDacNhanTamMoi);

		// Delete
//		Sach sachSpring100 = new Sach("S100", "Dac Nhan Tam Super", 110000, 2023);
//		SachDAO.getInstance().delete(sachSpring100);
//		for (int i = 1; i < 100; i++) {
//			Sach sach = new Sach("S" + i, "Spring in action " + i + "th", 210000 + i, 2020 + i);
//			SachDAO.getInstance().delete(sach);
//		}

		// DML
		// selectALL
//		ArrayList<Sach> list = SachDAO.getInstance().selectAll();
//		for (Sach sach : list) {
//			System.out.println(sach.toString());
//		}

//		 Select By Id
//		Sach sach = SachDAO.getInstance().selectById("1111");
//		System.out.println(sach.toString());

		// selectByCondition
		// Truyền condition dạng string vậy là nguy hiểm, không tốt, ta sẽ khắc phục sau
		String queryCondition = "giaBan > 10000 AND giaBan < 200000";
		ArrayList<Sach> list = SachDAO.getInstance().selectByCondition(queryCondition);
		for (Sach sach : list) {
			System.out.println(sach.toString());
		}
	}
}
