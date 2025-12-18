package model.Dao.impl;

import java.awt.dnd.DnDConstants;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.Dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao{
	
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller FindById(Integer Id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					" Select seller .* , department.Name as DepName"+
					" From seller INNER JOIN department "+
					" On seller.DepartmentId = department.Id "+
					" where seller.Id = ?");
			
			st.setInt(1, Id);
			rs = st.executeQuery();
			if(rs.next()) {
				Department dep = instatiateDepartement(rs);
				
				Seller sel =  instatiateSeller(rs , dep);
				
				return sel;
				
			}
			return null;
		}
		catch(SQLException s) {
			throw new DbException(s.getMessage());
		}
		
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			
		}
	}

	private Seller instatiateSeller(ResultSet rs, Department dep) throws SQLException {
		Seller sel = new Seller();
		sel.setId(rs.getInt("Id"));
		sel.setName(rs.getString("Name"));
		sel.setEmail(rs.getString("Email"));
		sel.setBaseSalary(rs.getDouble("BaseSalary"));
		sel.setDate(rs.getDate("BirthDate"));
		sel.setDepa(dep);
		
		return sel;
	}

	private Department instatiateDepartement(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		
		return dep;
	}

	@Override
	public List<Seller> FindAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
