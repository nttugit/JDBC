package test;

import java.sql.Date;
import java.util.ArrayList;

import dao.KhachHangDAO;
import model.KhachHang;

public class TestKhachHangDAO {
	public static void main(String[] args) {
		try {
			Date kh_dob = Date.valueOf("2000-12-12");

////			insert
//			KhachHang kh1 = new KhachHang("Nguyen Van Ba", kh_dob, "331, Nguyen Van Cu");
//			KhachHangDAO.getInstance().insert(kh1);
//			
////		update
//			KhachHang updatedKH = new KhachHang(3, "Nguyen Van Ba BA", kh_dob, "102, CMT8");
//			KhachHangDAO.getInstance().update(updatedKH);

			// delete
//			KhachHang deletedKH = new KhachHang(2, "Nguyen Van Hai", kh_dob, "102, CMT8");
//			KhachHangDAO.getInstance().delete(deletedKH);

			// selectAll
			ArrayList<KhachHang> list = KhachHangDAO.getInstance().selectAll();
			
			for (KhachHang kh : list) {
				System.out.println(kh);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
