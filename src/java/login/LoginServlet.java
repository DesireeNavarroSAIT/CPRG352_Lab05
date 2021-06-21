package login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import login.AccountService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //create a server session to remember the users name
        HttpSession session = request.getSession();
        
        
        String username = (String) session.getAttribute("user_name");

        String logOut = request.getParameter("logout");

        if (logOut != null) {
            // if logout has been clicked,shutdown the session
            session.invalidate();
            // Display a message to show user that you have succesfully logged out!
            request.setAttribute("warning", "You have successfully logged out.");

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else if (username != null) {
            // if username is not null, redirect them to home
            response.sendRedirect("home");
        } else {
            //send the user to login page to login
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // create HttpSession 
        HttpSession session = request.getSession();
      
        AccountService accServices = new AccountService();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // when login gets clicked 
        String logIn = request.getParameter("login");

        if (logIn != null) {

            // display an error message to show user that the fields are empty
            if (username == null || username.equals("") || password == null || password.equals("")) {
                request.setAttribute("warning", "Please enter your username");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            } 
            else {
                // if values are correct, send them to home page
                if (accServices.login(username, password) != null) {
                    session.setAttribute("user", username);
                    response.sendRedirect("home");
                } else {
                    // if the username is not adam or betty, warn the user
                    request.setAttribute("warning", "Username and Password does not exist. Please try again.");
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

                }
            }

        }
    }

}
