package web_erp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TitleInputServlet")
public class TitleInputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public TitleInputServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8");

		RequestDispatcher dispather = request.getRequestDispatcher("index.jsp");
		dispather.include(request, response);
		RequestDispatcher dispather2 = request.getRequestDispatcher("TitleListServlet");
		dispather2.include(request, response);
		request.getRequestDispatcher("titleInput.jsp").include(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
