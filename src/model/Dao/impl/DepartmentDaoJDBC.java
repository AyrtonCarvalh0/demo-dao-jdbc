package model.Dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.Dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{
	
	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
	    this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		
		try {
			st=conn.prepareStatement(
			"Insert into department "+
			"(Name , Id ) "+
			"Values "+
			"(? , ? )"
					
					);
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected < 0) {
				System.out.println("Error in Insert ");
			}
			else {
			System.out.println("Rows affected "+rowsAffected);
			}
					
					
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		finally {
			DB.closeStatement(st);
		}
		
		
		
	}

	@Override
	public void update(Department obj) {
		PreparedStatement st = null;
		
		try {
			st=conn.prepareStatement(
			"Update department "+
			"Set Name = ? "+
			"Where Id = ? "		
					);
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			int rowsAffected = st.executeUpdate();

			if(rowsAffected < 0) {
				System.out.println("Error in Update");
			}
			else {
				System.out.println("Rows affected "+rowsAffected);
			}
			
		}
		
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer Id) {
		PreparedStatement st = null;
		try {
			st=conn.prepareStatement(
					
					"Delete from department "+
					"Where Id = ? "

					);
			st.setInt(1, Id);
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected < 0) {
				System.out.println("Error in delete Id");
			}
			else {
				System.out.println("Rows affected "+rowsAffected);
			}
			
			
			
			
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}

	@Override
	public Department FindById(Integer Id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			
			st=conn.prepareStatement(
					"select * from department "+
							"Where Id = ?"
	
					);
			st.setInt(1, Id);
			
			rs = st.executeQuery();
			
			
			if(rs.next()) {
				
				Department  dep = new Department();
				
				dep.setId(rs.getInt("Id"));
				dep.setName(rs.getString("Name"));
				
				return dep;
			}
					
					
					
					
		}
		catch(SQLException e) {
			
			throw new DbException(e.getMessage());
			
		}
		
		
		return null;
	}

	@Override
	public List<Department> FindAll() {
		
		PreparedStatement st = null ; 
		
		
		try {
			st = conn.prepareStatement(
					"Select * from department "+
			"Order by Name "
										);
			
			ResultSet rs = st.executeQuery();
			List<Department> list1 = new ArrayList<>();
			
			while(rs.next()) {
				Department dep = new Department();
				dep.setName(rs.getString("Name"));
				dep.setId(rs.getInt("Id"));
				
				list1.add(dep);
				
				
			}
			return list1;
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		
	
	}

}
