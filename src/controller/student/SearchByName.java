package controller.student;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.StudentDAO;
import model.tdo.Student;

import com.google.gson.Gson;

import controller.Action;
import controller.ActionForward;

public class SearchByName implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String stu_name = request.getParameter("stu_name");
		StudentDAO dao = new StudentDAO();
		ArrayList<Student> students = dao.searchByName(stu_name);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String student= new Gson().toJson(students);
		
		response.getWriter().write(student);
		
		return null;
	}

}
