import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {

    int counter = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reset = request.getParameter("reset");

        if (reset != null){
            counter = 0;
        }

        counter++;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");


        if (name != null){
            out.println("<h3>Hello " + name + "</h3>");
        } else {
            out.println("<h3>Hello World</h3>");
        }

        out.printf("<p>Page views: %d</p>", counter);
    }

}
