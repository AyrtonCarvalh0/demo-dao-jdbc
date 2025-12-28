package Application;

import model.Dao.DaoFactory;
import model.Dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: Department findById ===");
		
		Department dep = depDao.FindById(2);
		System.out.println(dep);
		
		
	
		
System.out.println("\n === TEST 2: Department findAll ===");

List <Department> list = new ArrayList<Department>();
		
		list = depDao.FindAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		
		
System.out.println("\n === TEST 3: Insert  ===");
		
		System.out.print("Insert new Id : ");
		int id = sc.nextInt();
		
		Department NewDepartment = new Department(id,"football");
		depDao.insert(NewDepartment);
		
		System.out.println("New Id : " + id);
		
		
		
		
		System.out.println("\n === TEST 4: Update  ===");

		Department dep2 = depDao.FindById(3);
		dep2.setName("Programmer");
		depDao.update(dep2);
		System.out.println(" Update complete ");
		

		System.out.println("\n === TEST 4: Delete  ===");
		
		System.out.println("Enter Id for delete : ");
		int id2 = sc.nextInt();
		depDao.deleteById(id2);
		System.out.println("Delete complete ");
		
	
		
		sc.close();
		
		

	}

}
