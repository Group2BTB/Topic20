package controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import model.dao.StudentDAO;
import model.tdo.Student;
import controller.Action;
import controller.ActionForward;

public class AddStudent implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Student stu = new Student();
		StudentDAO dao = new StudentDAO();
		if(dao.getLastId() == null){
			stu.setId("131N1");
		}else{
			String stu_id = dao.getLastId().getId().substring(4);
			stu.setId("131N"+(Integer.parseInt(stu_id)+1));
		}
		stu.setName(request.getParameter("stu_name"));
		stu.setGender(Integer.parseInt(request.getParameter("gender")));
		stu.setUniversity(request.getParameter("stu_university"));
		stu.setStu_class(request.getParameter("stu_class"));
		stu.setStatus(1);
		
		response.setContentType("text/plain");
		if(new StudentDAO().addStudentInfo(stu)){
			System.out.println("Insert Successfully!");
			response.getWriter().write("success");
		}else{
			System.err.println("INSERT FAIL");
			response.getWriter().write("fail");
		}
		return null;
	}

}
