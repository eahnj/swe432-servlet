/** *****************************************************************
    assign6.java   servlet example

        @author Edwin & Abhilaash
********************************************************************* */

// Import Java Libraries
import java.io.*;
import java.util.*;

//Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;

//Import for Hiroku
import javax.servlet.annotation.WebServlet;

// assign6 class
// CONSTRUCTOR: no constructor specified (default)
//
// ***************  PUBLIC OPERATIONS  **********************************
// public void doPost ()  --> prints a blank HTML page
// public void doGet ()  --> prints a blank HTML page
// private void PrintHead (PrintWriter out) --> Prints the HTML head section
// private void PrintBody (PrintWriter out) --> Prints the HTML body with
//              the form. Fields are blank.
// private void PrintBody (PrintWriter out, String lhs, String rhs, String rslt)
//              Prints the HTML body with the form.
//              Fields are filled from the parameters.
// private void PrintTail (PrintWriter out) --> Prints the HTML bottom
//***********************************************************************

@WebServlet( name = "assign6", urlPatterns = {"/assign6"} )

public class assign6 extends HttpServlet
{

// Location of servlet.
static String Domain  = "cs.gmu.edu:8443";
static String Path    = "/offutt/servlet/";
static String Servlet = "assign6";

// Button labels
static String OperationAdd = "Add";
static String OperationSub = "Subtract";
static String OperationMult = "Multiply";

// Other strings.
static String Style ="https://www.cs.gmu.edu/~offutt/classes/432/432-style.css";

/** *****************************************************
 *  Overrides HttpServlet's doPost().
 *  Converts the values in the form, performs the operation
 *  indicated by the submit button, and sends the results
 *  back to the client.
********************************************************* */
public void doPost (HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
{
   Float rslt   = new Float(0.0);
   Float lhsVal = new Float(0.0);
   Float rhsVal = new Float(0.0);
   String operation = request.getParameter("Operation");
   String lhsStr = request.getParameter("LHS");
   String rhsStr = request.getParameter("RHS");
   if ((lhsStr != null) && (lhsStr.length() > 0))
      lhsVal = new Float(lhsStr);
   if ((rhsStr != null) && (rhsStr.length() > 0))
      rhsVal = new Float(rhsStr);

   if (operation.equals(OperationAdd))
   {
      rslt = new Float(lhsVal.floatValue() + rhsVal.floatValue());
   }
   else if (operation.equals(OperationSub))
   {
      rslt = new Float(lhsVal.floatValue() - rhsVal.floatValue());
   }
   else if (operation.equals(OperationMult))
   {
      rslt = new Float(lhsVal.floatValue() * rhsVal.floatValue());
   }

   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   PrintHead(out);
   PrintBody(out, lhsStr, rhsStr, rslt.toString());
   PrintTail(out);
}  // End doPost

/** *****************************************************
 *  Overrides HttpServlet's doGet().
 *  Prints an HTML page with a blank form.
********************************************************* */
public void doGet (HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException
{
   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   PrintHead(out);
   //PrintBody(out);
   PrintTail(out);
} // End doGet

/** *****************************************************
 *  Prints the <head> of the HTML page, no <body>.
********************************************************* */
private void PrintHead (PrintWriter out)
{
   out.println("<html>");
   out.println("");

   out.println("<head>");
   out.println("<title>Assignment 6</title>");
   //out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"" + Style + "\">");
   out.println("</head>");
   out.println("");
   
   out.println("<style>");
   out.println("body {");
   out.println("background: #d3d3d3");
   out.println("}");
   out.println("h1 {");
   out.println("color: #007099");
   out.println("text-align: center");
   out.println("}");
   out.println("h2 {");
   out.println("color: #007099");
   out.println("text-align: center");
   out.println("}");
   out.println("h2 {");
   out.println("color: #007099");
   out.println("text-align: center");
   out.println("}");
   out.println("</style>");
   
} // End PrintHead

/** *****************************************************
 *  Prints the <BODY> of the HTML page with the form data
 *  values from the parameters.
********************************************************* */
private void PrintBody (PrintWriter out, String lhs, String rhs, String rslt)
{
   out.println("<body>");
   out.println("<br>");
   out.println("Collaboration Summary: It has a few forms and two javascripts functions");
    out.println("that access the BOM. Abhilaash worked on the BOM while Edwin worked on the forms.");
   out.println("<br>");
   out.println("<input type=\"button\" value=\"Back\" onclick=\"goBack()\">");
   out.println("<p id=\"pageLocation\"></p>");
   out.println("<br>");
   out.println("Please fill out the following survey to the best of your ability and answer all of the questions.");
   out.println("<br>");
   out.println("");
   out.println("Best pizza on campus");
   out.println("<br>");
   out.println("");
   out.println("<form method=\"post\" action=\"https://cs.gmu.edu:8443/offutt/servlet/formHandler\">");
   out.println("<input type=\"radio\" id=\"manhattan\" name=\"bestPizza\" value=\"manhattan\">");
   out.println("<label for=\"manhattan\">Manhattan Pizza</label><br>");
   out.println("<input type=\"radio\" id=\"blaze\" name=\"bestPizza\" value=\"blaze\">");
   out.println("<label for=\"blaze\">Blaze Pizza</label><br>");
   out.println("<input type=\"radio\" id=\"other\" name=\"bestPizza\" value=\"other\">");
   out.println("<label for=\"other\">Other</label>");
   out.println("<br>");
   out.println("<br>");
   out.println("");
   out.println("Service Speed at Manhattan");
   out.println("<br>");
   out.println("");
   out.println("<input type=\"radio\" id=\"fiveMinutesManhattan\" name=\"serviceSpeedManhattan\" value=\"fiveMinutesManhattan\">");
   out.println("<label for=\"fiveMinutesManhattan\">05 minutes or less</label><br>");
   out.println("<input type=\"radio\" id=\"tenMinutesManhattan\" name=\"serviceSpeedManhattan\" value=\"tenMinutesManhattan\">");
   out.println("<label for=\"tenMinutesManhattan\">10 minutes</label><br>");
   out.println("<input type=\"radio\" id=\"fifteenMinutesManhattan\" name=\"serviceSpeedManhattan\" value=\"fifteenMinutesManhattan\">");
   out.println("<label for=\"fifteenMinutesManhattan\">15 minutes</label><br>");
   out.println("<input type=\"radio\" id=\"thirtyMinutesManhattan\" name=\"serviceSpeedManhattan\" value=\"thirtyMinutesManhattan\">");
   out.println("<label for=\"thirtyMinutesManhattan\">30 minutes or more</label><br>");
   out.println("<br>");
   out.println("<br>");
   out.println("");
   out.println("Service Speed at Blaze");
   out.println("<br>");
   out.println("");
   out.println("<input type=\"radio\" id=\"fiveMinutesBlaze\" name=\"serviceSpeedBlaze\" value=\"fiveMinutesBlaze\">");
   out.println("<label for=\"fiveMinutesManhattan\">05 minutes or less</label><br>");
   out.println("<input type=\"radio\" id=\"tenMinutesBlaze\" name=\"serviceSpeedBlaze\" value=\"tenMinutesBlaze\">");
   out.println("<label for=\"tenMinutesManhattan\">10 minutes</label><br>");
   out.println("<input type=\"radio\" id=\"fifteenMinutesBlaze\" name=\"serviceSpeedBlaze\" value=\"fifteenMinutesBlaze\">");
   out.println("<label for=\"fifteenMinutesBlaze\">15 minutes</label><br>");
   out.println("<input type=\"radio\" id=\"thirtyMinutesBlaze\" name=\"serviceSpeedBlaze\" value=\"thirtyMinutesBlaze\">");
   out.println("<label for=\"thirtyMinutesBlaze\">30 minutes or more</label><br>");
   out.println("<br>");
   out.println("<br>");
   out.println("");
   out.println("Best location on campus for food");
   out.println("<br>");
   out.println("");
   out.println("<input type=\"radio\" id=\"jc\" name=\"bestLocation\" value=\"jc\">");
   out.println("<label for=\"jc\">Johnson Center</label><br>");
   out.println("<input type=\"radio\" id=\"mertenHall\" name=\"bestLocation\" value=\"mertenHall\">");
   out.println("<label for=\"mertenHall\">Merten Hall</label><br>");
   out.println("<input type=\"radio\" id=\"other\" name=\"bestLocation\" value=\"other\">");
   out.println("<label for=\"other\">Other</label>");
   out.println("<br>");
   out.println("");
   out.println("<br>");
   out.println("<input type=\"submit\" value=\"Submit\">");
   out.println("");
   out.println("</form>");
   out.println("");
   out.println("</script>");
   out.println("document.getElementById(\"pageLocation\").innerHTML =");
   out.println("\"Page location is \" + window.location.href;");
   out.println("function goBack() {");
   out.println("window.history.back()");
   out.println("}");
   out.println("</script>");
   out.println("</body>");
} // End PrintBody

/** *****************************************************
 *  Overloads PrintBody (out,lhs,rhs,rslt) to print a page
 *  with blanks in the form fields.
********************************************************* */
private void PrintBody (PrintWriter out)
{
   PrintBody(out, "", "", "");
}

/** *****************************************************
 *  Prints the bottom of the HTML page.
********************************************************* */
private void PrintTail (PrintWriter out)
{
   out.println("");
   out.println("</html>");
} // End PrintTail

}  // End twoButtons