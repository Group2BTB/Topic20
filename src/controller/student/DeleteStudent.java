package controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.StudentDAO;
import controller.Action;
import controller.ActionForward;

public class DeleteStudent implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String stu_id = request.getParameter("stu_id");
		if(new StudentDAO().deleteStudent(stu_id)){
			System.out.println("Delete successfully!");
		}else{
			System.out.println("Delete unsuccessfully!");
		}
		
		return null;
	}

}
