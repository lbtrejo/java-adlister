import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        boolean loginStatus = (session.getAttribute("user") != null);

        if (loginStatus) {
            response.sendRedirect("/profile");
        } else {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password");
        HttpSession session = request.getSession();

        if (validAttempt) {
            session.setAttribute("isAdmin", true);
            session.setAttribute("user", "admin");
            session.removeAttribute("error");
            response.sendRedirect("/profile");
        } else {
            session.setAttribute("error", "Invalid username or password");
            response.sendRedirect("/login");
        }
    }
}
