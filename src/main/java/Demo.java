import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class Demo {
    public static void main(String[] args) {
        Config config = new Config();

        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM albums");

            while(rs.next()){
                System.out.println("rs.getLong(\"id\") = " + rs.getLong("id"));
                System.out.println("rs.getString(3) = " + rs.getString(3));
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
