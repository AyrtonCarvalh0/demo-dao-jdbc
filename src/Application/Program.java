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
	
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		
		Seller sel = sellerDao.FindById(3);
		
		System.out.println(sel);
		
		System.out.println("\n === TEST 2: seller findByDepartment ===");
		
		Department department = new Department(2,null);
		
		List<Seller> list = sellerDao.FindByDepartment(department);
		
		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n === TEST 3: seller findAll ===");
		
		list = sellerDao.FindAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		
			System.out.println("\n === TEST 4: seller Insert ===");

			Seller nseller = new Seller(null , "Greg " , "greg@gmail.com " , new Date() , 4000.0 , department);
			sellerDao.insert(nseller);
			System.out.println("Inserted! new Id = " + nseller.getId());
			
			
			System.out.println("\n === TEST 5: seller Update ===");
			
			nseller = sellerDao.FindById(1);
			nseller.setName("Marcos Braz ");
			sellerDao.update(nseller);
			
			System.out.println("Update completes !!");
			
		
		
		
		

	}

}
