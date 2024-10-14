

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstNumber=request.getParameter("firstNumber");    //the parameter name should be same which is given in the html file
		String secondNumber=request.getParameter("secondNumber");  //the parameter name should be same which is given in the html file
		
		int firstNumber1=Integer.parseInt(firstNumber);   // parseInt() is used to convert string type data to int type data
		int secondNumber1=Integer.parseInt(secondNumber);
		
		int result=firstNumber1+secondNumber1;
		
		PrintWriter out=response.getWriter();
		out.println("The added valu is "+result);
	}

}
