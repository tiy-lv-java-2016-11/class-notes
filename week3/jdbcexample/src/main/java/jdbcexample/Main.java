package jdbcexample;

import java.sql.*;

/**
 * Created by jeff on 12/13/16.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql:books");

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM books LIMIT 5");

        while(rs.next()){
            int id = rs.getInt("id");
            String title = rs.getString("title");
            String author = rs.getString("author");

            Book book = new Book(id, title, author);

            System.out.println(book);
        }
    }
}
