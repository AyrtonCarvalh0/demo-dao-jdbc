package model.Dao;

import java.util.List;

import db.DB;
import model.Dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDao createSellerDao(){
		return new SellerDaoJDBC(DB.getConnection());
	}

}
