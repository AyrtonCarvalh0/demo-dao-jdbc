package Application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department dep = new Department(1 , "Books");
		
		System.out.println(dep);
		
		Seller sell = new Seller(21 , "Drake" , "Drake@gmail.com" , new Date() , 2500.0 , dep);
		
		System.out.println(sell);

	}

}
