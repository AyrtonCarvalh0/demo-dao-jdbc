package Application;

import java.util.Date;
import java.util.List;

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
		
		System.out.println("\n === TEST 2: seller findByDepartment ===");
		
		Department department = new Department(2,null);
		
		List<Seller> list = seller.FindByDepartment(department);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n === TEST 3: seller findAll ===");
		
		list = seller.FindAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		
		
		

	}

}
