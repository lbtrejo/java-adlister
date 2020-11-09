import java.sql.*;

import com.mysql.cj.jdbc.Driver;

import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDAO implements Ads {
    private Connection connection = null;
    private Config config = new Config();
    private List<Ad> ads;

    public MySQLAdsDAO(){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        Statement statement = null;
        List<Ad> ads = new ArrayList<>();

        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ads");
            rs.next();
            System.out.println("rs.getString(\"title\") = " + rs.getString("title"));
            System.out.println("rs.getString(\"description\") = " + rs.getString("description"));
            rs.next();
            System.out.println("rs.getString(\"title\") = " + rs.getString("title"));
            System.out.println("rs.getString(\"description\") = " + rs.getString("description"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    @Override
    public Long insert(Ad ad) {
        return null;
    }
}
