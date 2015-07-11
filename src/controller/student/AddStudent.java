package controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.tdo.Student;
import controller.Action;
import controller.ActionForward;

public class AddStudent implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Student stu = new Student();
		stu.setId("131N");
		stu.setName(request.getParameter("name"));
		if(request.getParameter("gender").equalsIgnoreCase("male")){
			stu.setGender(1);
		}else if(request.getParameter("gender").equalsIgnoreCase("female")){
			stu.setGender(1);
		}
		stu.setUniversity("university");
		stu.setStu_class("class");
		stu.setStatus(1);
		return null;
	}

}
