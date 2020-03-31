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


@WebServlet( name = "assign6", urlPatterns = {"/assign6"} )

public class assign6 extends HttpServlet
{

// Location of servlet.
static String Domain  = "swe432-servlet.herokuapp.com";
static String Path    = "/";
static String Servlet = "assign6";


// Other strings.
//static String Style ="https://www.cs.gmu.edu/~offutt/classes/432/432-style.css";

/** *****************************************************
 *  Overrides HttpServlet's doPost().
 *  Converts the values in the form, performs the actions
 *  indicated by the submit button, and sends the results
 *  back to the client.
********************************************************* */
public void doPost (HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException
{
   // first, set the "content type" header of the response
   response.setContentType ("text/html");
   //Get the response's PrintWriter to return text to the client.
   PrintWriter toClient = response.getWriter ();

   String para;
   Enumeration paraNames = request.getParameterNames();

   toClient.println("<html>");
   toClient.println("<head>");
   toClient.println("  <title>Generic Form Handler</title>");
   toClient.println("</head>");

   toClient.println("<body bgcolor=\"#EEEEEE\">");
   toClient.println("");
   toClient.println("<center><h2>Generic Form Handler</h2></center>");
   toClient.println("<p>");
   toClient.println("The following table lists all parameter names and");
   toClient.println("their values that were submitted from your form.");
   toClient.println("</p>");
   toClient.println("");
   toClient.println("<p>");
   toClient.println("<table cellSpacing=1 cellPadding=1 width=\"75%\" border=1 bgColor=lavender>");
   toClient.println("");
   toClient.println("  <tr bgcolor=\"#FFFFFF\">");
   toClient.println("   <th align=\"center\"><b>Parameter</b></td>");
   toClient.println("   <th align=\"center\"><b>Value</b></td>");
   toClient.println("  </tr>");

   while (paraNames.hasMoreElements())
   {  // For each parameter name.
      para = (String)paraNames.nextElement();
      if (!para.equalsIgnoreCase("submit"))
      {
         toClient.println("  <tr>");
         toClient.println("    <td style=\"width: 20%\" width=\"20%\"><b>" + para + "</b></td>");

         String[] values = request.getParameterValues(para);

         if (values != null && !values[0].equals(""))
            toClient.println("    <td>" + values[0] + "</td></tr>");
         else
            toClient.println("    <td>&nbsp;</td></tr>");

         for (int i = 1; i < values.length; i++)
         {
            if (!values[i].equals(""))
            {
               toClient.println("  <tr>");
               toClient.println("    <td style=\"width: 20%\" width=\"20%\">&nbsp;</td>");
               toClient.println("    <td>" + values[i] + "</td></tr>");
            }
         }
      }
   }
   toClient.println("</table>");
   toClient.println("");
   toClient.println("</body>");
   toClient.println("</html>");

   toClient.println("");

   // Close the writer; the response is done.
   toClient.close();

   response.setContentType("text/html");
   PrintWriter out = response.getWriter();
   PrintHtml(out);
//    PrintBody(out);
//    PrintTail(out);
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
   PrintHtml(out);
   //PrintBody(out);
//    PrintTail(out);
} // End doGet

/** *****************************************************
 *  Prints the entire HTML page.
********************************************************* */
private void PrintHtml (PrintWriter out)
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
   
   out.println("<body>");
   out.println("<br>");
   out.println("Collaboration Summary: Edwin worked on the GET method and Abhilaash worked on the POST method");
   out.println("and assisted with the GET method. Both members were actively testing and deploying on Heroku to fix issues that arose.");
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
   out.println("<form method=\"post\" action=\"https://swe432-servlet.herokuapp.com/assign6\">");
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
   out.println("<label for=\"fiveMinutesBlaze\">05 minutes or less</label><br>");
   out.println("<input type=\"radio\" id=\"tenMinutesBlaze\" name=\"serviceSpeedBlaze\" value=\"tenMinutesBlaze\">");
   out.println("<label for=\"tenMinutesBlaze\">10 minutes</label><br>");
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
} // End PrintHead

/** *****************************************************
 *  Prints the <BODY> of the HTML page with the form data
 *  values from the parameters.
********************************************************* */
//private void PrintBody (PrintWriter out)
//{
//
//} // End PrintBody

/** *****************************************************
 *  Overloads PrintBody (out,lhs,rhs,rslt) to print a page
 *  with blanks in the form fields.
********************************************************* */
//private void PrintBody (PrintWriter out)
//{
//   PrintBody(out, "", "", "");
//}

/** *****************************************************
 *  Prints the bottom of the HTML page.
********************************************************* */
private void PrintTail (PrintWriter out)
{
   out.println("");
   out.println("</html>");
} // End PrintTail

}  // End assign6