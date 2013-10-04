import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="calc", urlPatterns="/calc")

public class Calculator extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	    resp.setContentType("text/html");
	    String operation = req.getParameter("op");
	    System.out.println(operation);
	    
	    String title = "<h1>Calculadora</h1>";
	    String body = "<body>\n";

	    body += "<h2>Resultado</h2>";

	    resp.getOutputStream().println(title);
	    resp.getOutputStream().println(body);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		super.doPost(req, resp);
		   resp.setContentType("text/html");
		    String op = req.getParameter("op");
		    String p1 = req.getParameter("p1");
		    String p2 = req.getParameter("p2");
		    
		    Double dp1 = Double.parseDouble(p1);
		    Double dp2 = Double.parseDouble(p2);
		    Double dres = 0.0;
		    
		    String title = "<h1>Calculadora</h1>";
		    String body = "<body>\n";

		    body += "<h2>Resultado</h2>";
		    
		    Integer iop = Integer.parseInt(op);
		    switch(iop){
		    	case 1:
		    		dres = operation(dp1, dp2, new OperatorSum());
		    		break;
		    	case 2:
		    		dres = operation(dp1, dp2, new OperatorSubs());
		    		break;
		    	case 3:
		    		dres = operation(dp1, dp2, new OperatorProduct());
		    		break;
		    	case 4:
		    		dres = operation(dp1, dp2, new OperatorDiv());
		    		break;
		    }
		    
		    body += dres;
		    body += "<br><a href=/ServletCalc/>Otra operaci—n</a>";
		    resp.getOutputStream().println(title);
		    resp.getOutputStream().println(body);
	}
	
	public static Double operation(Double p1, Double p2, CalcOperator op){
		return op.compute(p1, p2);
	}
}
