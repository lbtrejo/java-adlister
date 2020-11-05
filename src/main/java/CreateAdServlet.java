import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CreateAdServlet", urlPatterns = "/create")
public class CreateAdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Load our DAO factory and populate our ad list
        Ads adsDao = DaoFactory.getAdsDao();
        List<Ad> ads = adsDao.all();

        // Pull in our new ad parameters set in the web form
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        long adId = Integer.parseInt(request.getParameter("adId"));
        long userId = Integer.parseInt(request.getParameter("userId"));

        // Add the new ad to the list of ads
        ads.add(new Ad(adId, userId, title, description));

        // Redirect the user to the ad listing page where the new add should be shown
        response.sendRedirect("/ads");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/ads/create.jsp").forward(request, response);
    }
}
