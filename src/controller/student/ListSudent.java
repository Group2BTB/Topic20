package controller.student;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.dao.StudentDAO;
import model.tdo.Student;

import com.google.gson.Gson;

import controller.Action;
import controller.ActionForward;

public class ListSudent implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			
			StudentDAO dao = new StudentDAO();
			ArrayList<Student> articles = dao.list();
	
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			String article= new Gson().toJson(articles);
			
			response.getWriter().write(article);
		
			//System.out.println(article);

		return null;
	}
	
}
