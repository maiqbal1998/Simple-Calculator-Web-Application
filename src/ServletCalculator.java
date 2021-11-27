import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCalculator extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher view = req.getRequestDispatcher("index.jsp");
		req.setAttribute("total", 0);
		view.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int num1 = Integer.valueOf(req.getParameter("num1"));
		int num2 = Integer.valueOf(req.getParameter("num2"));
		String operation = req.getParameter("operation");
		int ans = 0;
		
		switch(operation) {
		case "+":
			ans = num1 + num2;
			break;
		case "-":
			ans = num1 - num2;
			break;
		case "*":
			ans = num1 * num2;
			break;
		case "/":
			ans = num1 / num2;
			break;
		
		default:
			break;
		}
		
		RequestDispatcher view = req.getRequestDispatcher("index.jsp");
		req.setAttribute("total", ans);
		view.forward(req, resp);
		
	}
}
