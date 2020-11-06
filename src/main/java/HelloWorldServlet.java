import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().println("<h1>Hello, World!</h1>");

        if (request.getMethod().equalsIgnoreCase("post")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("admin") && password.equals("password")) {
                response.sendRedirect("profile.jsp");
            }
        }

        Ads ListAdsDao = DaoFactory.getAdsDao();
        // Use a method on the dao to get all ads
        List<Ad> ads = ListAdsDao.all();
        // Pass the data to the jsp
        request.setAttribute("ads", ads);
        request.getRequestDispatcher("/ads/index.jsp").forward(request, response);


    }

}
