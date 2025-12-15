package model.Dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {
	
	void insert (Department obj);//inserir no bd o objeto que eu enviar como parametro de entrada
	void update (Department obj);
	void deleteById (Integer Id);
	Department FindById(Integer Id);
	List <Department> FindAll();
	

}
