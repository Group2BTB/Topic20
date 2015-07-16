package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

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
	
	public boolean addStudentInfo(Student stu) throws SQLException{
		String sql = "insert into hrd_students(stu_id, stu_name, stu_gender, stu_university, stu_class, stu_status) values(?,?,?,?,?,?)";
		PreparedStatement pres = cn.prepareStatement(sql);
			pres.setString(1, stu.getId());
			pres.setString(2, stu.getName());
			pres.setInt(3, stu.getGender());
			pres.setString(4, stu.getUniversity());
			pres.setString(5, stu.getStu_class());
			pres.setInt(6, stu.getStatus());
			pres.executeUpdate();
			pres.close();
			return true;
	}
	
	public Student getLastId() throws SQLException{
		Student stu = new Student();
		String sql = "select stu_id from hrd_students order by stu_id DESC limit 1";
		PreparedStatement pres  = cn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = pres.executeQuery();
		if(rs.last()){
			stu.setId(rs.getString("stu_id"));
			return stu;
		}
		return null;
	}
	
	public boolean deleteStudent(String stu_id) throws SQLException{
		String sql = "delete from hrd_students where stu_id=?";
		PreparedStatement pres = cn.prepareStatement(sql);
		pres.setString(1, stu_id);
		pres.executeUpdate();
		pres.close();
		cn.close();
		return true;
	}
	
	public boolean updateStudent(Student stu) throws SQLException{
		String sql = "update hrd_students set stu_name=?, stu_university=?, stu_class=?, stu_gender=? where stu_id =?";
		PreparedStatement pres = cn.prepareStatement(sql);
		pres.setString(1, stu.getName());
		pres.setString(2, stu.getUniversity());
		pres.setString(3, stu.getStu_class());
		pres.setInt(4, stu.getGender());
		pres.setString(5, stu.getId());
		pres.executeUpdate();
		
		pres.close();
		cn.close();
		return true;
	}
	
	public Student ViewStudent(String id) throws SQLException{
		Student stu = new Student();
		PreparedStatement pre = cn.prepareStatement("select * from hrd_students where stu_id=?",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		pre.setString(1,id);
		ResultSet rs = pre.executeQuery();
		if(rs.last()){
			stu.setId(id);
			stu.setName(rs.getString("stu_name"));
			stu.setUniversity(rs.getString("stu_university"));
			stu.setStu_class(rs.getString("stu_class"));
			stu.setGender(rs.getInt("stu_gender"));
			stu.setStatus(rs.getInt("stu_status"));
		}
		
		rs.close();
		pre.close();
		cn.close();
		return stu;
		
	}
	
	public ArrayList<Student> searchByName(String name) throws SQLException{
		ArrayList<Student> arrList = new ArrayList<Student>();
		PreparedStatement pre = cn.prepareStatement("select * from hrd_students where stu_name= %?%");
		pre.setString(1, name);
		ResultSet rs = pre.executeQuery();
		while(rs.next()){
			arrList.add(new Student(
				rs.getString("stu_id"),
				rs.getString("stu_name"),
				rs.getInt("stu_gender"),
				rs.getString("stu_university"),
				rs.getString("stu_class"),
				rs.getInt("stu_status")));
		}
		
		rs.close();
		pre.close();
		cn.close();
		return arrList;
		
	}
	
	public ArrayList<Student> searchByClass(String stuClass) throws SQLException{
		ArrayList<Student> arrList = new ArrayList<Student>();
		PreparedStatement pre = cn.prepareStatement("select * from hrd_students where stu_class= ?");
		pre.setString(1, stuClass);
		ResultSet rs = pre.executeQuery();
		while(rs.next()){
			arrList.add(new Student(
				rs.getString("stu_id"),
				rs.getString("stu_name"),
				rs.getInt("stu_gender"),
				rs.getString("stu_university"),
				rs.getString("stu_class"),
				rs.getInt("stu_status")));
		}
		
		rs.close();
		pre.close();
		cn.close();
		return arrList;
		
	}
	
	/*public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		StudentDAO dao = new StudentDAO();
		System.out.println(dao.getLastId().getId());
	}*/
}
