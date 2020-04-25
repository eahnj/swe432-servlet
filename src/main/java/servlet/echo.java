package servlet;

import com.google.gson.Gson;

import java.io.PrintWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "echo", urlPatterns = {"/echo"})
public class echo extends HttpServlet{
  @Override
   protected void doPost  (HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException{

     res.setContentType ("aplication/json");
     res.setHeader("Access-Control-Allow-Origin", "*");
     res.setHeader("Access-Control-Allow-Methods", "POST");
     res.setHeader("Access-Control-Allow-Headers", "*");

     PrintWriter out = res.getWriter();

     /*
     Map<String, String[]> parameterMap = req.getParameterMap();
     Map<String, String> data = new HashMap<String, String>();
     for (String key: parameterMap.keySet()) {
         String parameter = parameterMap.get(key)[0];
         data.put(key, parameter);
     }
     */

     Map<String, String[]> parameterMap = req.getParameterMap();
      Map<String, String> data = new HashMap<String, String>();
      for (String key: parameterMap.keySet()) {
          String parameter = parameterMap.get(key)[0];
          data.put(key, parameter);
      }
      out.print(new Gson().toJson(data));
      out.flush();
      out.close();

     // String bestpizza = req.getParameter("bestPizza");
     // String[] bpresult = req.getParameterValues("bestPizza");
     //
     // String servicespeedm = req.getParameter("serviceSpeedManhattan");
     // String[] ssmresult = req.getParameterValues("serviceSpeedManhattan");
     //
     // String servicespeedb = req.getParameter("serviceSpeedBlaze");
     // String[] ssbresult = req.getParameterValues("serviceSpeedBlaze");
     //
     // String bestloc = req.getParameter("bestLocation");
     // String[] blresult = req.getParameterValues("bestLocation");
     //
     // Map<String, String> data = new HashMap<String, String>();
     //
     // data.put(bestpizza, bpresult[0]);
     // data.put(servicespeedm, ssmresult[0]);
     // data.put(servicespeedb, ssbresult[0]);
     // data.put(bestloc, blresult[0]);
     //
     // /*
     // out.println("Best pizza");
     // out.println(bestpizza);
     // out.println("Service Speed Manhattan");
     // out.println(servicespeedm);
     // out.println("Service Speed Blaze");
     // out.println(servicespeedb);
     // out.println("Best Location");
     // out.println(bestloc);
     // */
     //
     // out.print(new Gson().toJson(data));
     // out.flush();
     // out.close();
    }

    @Override
     protected void doGet  (HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
     {

          res.setContentType ("text/html");
          PrintWriter out = res.getWriter ();

          out.println ("<HTML>");
          out.println ("<HEAD>");
          out.println ("<TITLE>Invalid request</TITLE>");
          out.println ("</HEAD>");

          out.println ("<BODY>");
          out.println ("<CENTER>");
          out.println (
           "<P>Invalid GET request: This service only accepts POST requests</P>"
          );
          out.println ("</CENTER>");
          out.println ("</BODY>");

          out.println ("</HTML>");
          out.flush();

          out.close ();

      }
}
