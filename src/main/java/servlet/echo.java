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
     
     String bestpizza = req.getParameter("bestPizza");
     String servicespeedm = req.getParameter("serviceSpeedManhattan");
     String servicespeedb = req.getParameter("serviceSpeedBlaze");
     String bestloc = req.getParameter("bestLocation");
     
     out.println("Best pizza");
     out.println(bestpizza);
     out.println("Service Speed Manhattan");
     out.println(servicespeedm);
     out.println("Service Speed Blaze");
     out.println(servicespeedb);
     out.println("Best Location");
     out.println(bestloc);
     //out.print(new Gson().toJson(data));
     //out.flush();
     out.close();
    }
}