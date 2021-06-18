/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author m-navarro
 */
public class LoginServlet extends HttpServlet {
      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
         //responsible for making the user LOGOUT
         
        String logOutClicked = request.getParameter("logout");
         
          if (logOutClicked != null) {

            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            request.setAttribute("errorMsg", "You have successfully log out!");
                   
          }
    
    }
    
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        //////VALIDATION\\\\\\\\
        
        if(username == null || username.equals("")){
            request.setAttribute("errorMsg", "Please enter your username");
            return;
        }
        else if (password == null || password.equals("")){
            request.setAttribute("errorMsg", "Please enter your password");
            return;
        }
        
        //////END OF VALIDATION\\\\\\\\
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            return;
        }
        
        //TODO:
        ///Validation are not NULL
        ///
    }


}
