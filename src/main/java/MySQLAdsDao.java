import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;
    private Config config = new Config();
    private List<Ad> ads;

    public MySQLAdsDao(){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl();
                    config.getUsername();
                    config.getPassword()
            );
        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {
        Statement stmt = null;
        List<Ad> ads = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from ads");
            while(rs.next()){
                ads.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Long insert(Ad ad) {
        return null;
    }
}
