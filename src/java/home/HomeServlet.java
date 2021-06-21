/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // create http session
        HttpSession session = request.getSession();
        
        String username = (String) session.getAttribute("user");
        
        // if the username is null or if the username has the a vakue such as betty or adam
        if (username == null || username.equals("")) {
            response.sendRedirect("login");
           
        // send user to requested home JSP
         }else {
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

                }
        
    }


}
