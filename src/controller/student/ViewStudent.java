package controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.dao.StudentDAO;
import model.tdo.Student;
import controller.Action;
import controller.ActionForward;

public class ViewStudent implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Student stu = new Student();
		String stu_id = request.getParameter("stu_id");
		stu = new StudentDAO().ViewStudent(stu_id);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		String student = new Gson().toJson(stu);
		response.getWriter().write(student);
		
		System.out.println(student);
		
		return null;
	}

}
