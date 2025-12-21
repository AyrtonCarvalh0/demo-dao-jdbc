package model.Dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;


public interface SellerDao {
	
	void insert (Seller obj);//inserir no bd o objeto que eu enviar como parametro de entrada
	void update (Seller obj);
	void deleteById (Integer Id);
	Seller FindById(Integer Id);
	List <Seller> FindAll();
	
	List<Seller> FindByDepartment (Department department);
	

}
