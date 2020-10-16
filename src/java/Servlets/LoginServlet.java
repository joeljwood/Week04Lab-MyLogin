
package Servlets;

import Manager.AccountService;
import Manager.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joel Wood
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        if(action != null  && action.equals("logout")){
            session.invalidate();
            session = request.getSession();
            request.setAttribute("message", "You logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        HttpSession session = request.getSession();
        String errorMessage;
        AccountService acctServ = new AccountService();
        if(request.getParameter("username") != null && request.getParameter("password") != null){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (acctServ.login(username, password) != null){
                User client = acctServ.login(username, password);
                session.setAttribute("username", client.getUsername());
                response.sendRedirect("/home");
            }
            else{
                errorMessage = "Failed authentication";
                request.setAttribute("message", errorMessage);
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }  
        }
        else{
            errorMessage = "Failed authentication";
                    request.setAttribute("message", errorMessage);
                    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
        
    }

}
