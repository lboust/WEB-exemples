package hello;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToDoListServlet
 */
@WebServlet("/ToDoListServlet/*")
public class ToDoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Content-Type", "text/html");
		response.setCharacterEncoding("UTF-8");
		
		String pathInfo= request.getPathInfo();

		if (pathInfo == null ) {
			response.getWriter().append("<ul>");
			response.getWriter().append("<li><a href=\"http://localhost:8080/HelloWeb/ToDoListServlet/1\">todo list 1</a></li>");
			response.getWriter().append("<li><a href=\"http://localhost:8080/HelloWeb/ToDoListServlet/2\">todo list 2</a></li>");
			response.getWriter().append("</ul>");
		} 
			// expression régulière
		if (! pathInfo.substring(1).matches("\\d+")) {
			response.setStatus(404);
			response.getWriter().append("<p>404 - La page demandée n'existe pas");
			return;
		}
		
		int id = Integer.parseInt(pathInfo.substring(1));
		ToDoListRepository repo = new ToDoListRepository();
		ArrayList<ToDo> toDoList = repo.findToDoListById(id);
		
		if(toDoList == null) {
			response.setStatus(404);
			response.getWriter().append("<p>404 - La page demandée n'existe pas</p>");
			return;
		}
		response.getWriter().append("<a href=\"http://localhost:8080/HelloWeb/ToDoListServlet\">retour vers accueil</a>");
		response.getWriter().append("<ul>");
		for (ToDo toDo : toDoList) {
			response.getWriter().append("<li>" + toDo.getTitle() + "</li>");
		}
		response.getWriter().append("</ul>");
					
			/*
			try {
				int id = Integer.parseInt(pathInfo.substring(1));
				//TODO c'est un entier
			} catch (NumberFormatException ex) {
				//TODO ce n'est pas un entier
			}//regarder si on peut faire mieux
			*/
		
		//header

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
