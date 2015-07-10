package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.DBConversion;
import ultilities.DBUtility;
import model.tdo.Student;


public class StudentDAO {
	Connection cn;
	public StudentDAO() throws ClassNotFoundException, SQLException{
		cn = DBUtility.getConnection();
	}
	public ArrayList<Student> list() throws SQLException{
		PreparedStatement ps = cn.prepareStatement("SELECT * FROM hrd_students");
		ResultSet rs = ps.executeQuery();
		ArrayList<Student> arrList = new ArrayList<Student>();
		try{
			while(rs.next()){
				arrList.add(new Student(
						rs.getString("stu_id"),
						rs.getString("stu_name"),
						rs.getInt("stu_gender"),
						rs.getString("stu_university"),
						rs.getString("stu_class"),
						rs.getInt("stu_status")));
			}
			return arrList;
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException e){throw e;}
			if(ps!=null)try{ps.close();}catch(SQLException e){throw e;}
			if(cn!=null)try{cn.close();}catch(SQLException e){throw e;}
		}
	}
}
