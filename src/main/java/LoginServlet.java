import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if (username.equals("admin") && password.equals("password")) {
                resp.sendRedirect("/profile.jsp");
            }


//            String username = req.getParameter("username");
//            String password = req.getParameter("password");

            boolean validAttempt = username.equals("admin") && password.equals("password");

            HttpSession session = req.getSession();

            if (validAttempt) {
                session.setAttribute("isAdmin", true);
                resp.sendRedirect("/profile");
            } else {
                resp.sendRedirect("/login");
            }


        }


    }
}
