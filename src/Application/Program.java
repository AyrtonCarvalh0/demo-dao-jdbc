package Application;

import java.util.Date;

import model.Dao.DaoFactory;
import model.Dao.SellerDao;
import model.Dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
	
		SellerDao seller = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		
		Seller sel = seller.FindById(3);
		
		System.out.println(sel);

	}

}
