package controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.StudentDAO;
import model.tdo.Student;
import controller.Action;
import controller.ActionForward;

public class UpdateStudent implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Student stu = new Student();
		stu.setName(request.getParameter("stu_name"));
		stu.setUniversity(request.getParameter("stu_university"));
		stu.setStu_class(request.getParameter("stu_class"));
		stu.setGender(Integer.parseInt(request.getParameter("gender")));
		stu.setId(request.getParameter("stu_id"));
		response.setContentType("text/plain");
		
		if(new StudentDAO().updateStudent(stu)){
			System.out.println("Update successful");
			response.getWriter().write("success");
		}else{
			System.err.println("Update FAIL");
			response.getWriter().write("fail");
		}
		return null;
	}

}
