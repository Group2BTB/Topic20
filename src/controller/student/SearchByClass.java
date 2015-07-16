package controller.student;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.dao.StudentDAO;
import model.tdo.Student;
import controller.Action;
import controller.ActionForward;

public class SearchByClass implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		String stu_class = request.getParameter("stu_class");
		StudentDAO dao = new StudentDAO();
		ArrayList<Student> students = dao.searchByClass(stu_class);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String student= new Gson().toJson(students);
		
		response.getWriter().write(student);
		
		return null;
	}

}
