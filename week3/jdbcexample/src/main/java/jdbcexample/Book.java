package jdbcexample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jeff on 12/13/16.
 */
public class Book {
    private int id = 0;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("(%d)%s by %s", id, title, author);
    }

    public void save(Connection conn) throws SQLException {
        if(id < 1){
            PreparedStatement insert =
                    conn.prepareStatement("INSERT INTO book (title, author) VALUES(?, ?)");

            insert.setString(1, title);
            insert.setString(2, author);
            insert.executeUpdate();

            ResultSet rs = insert.getGeneratedKeys();
            rs.next();
            this.id = rs.getInt("id");
        }
        else{
            PreparedStatement update =
                    conn.prepareStatement("UPDATE books SET title = ?, author = ? WHERE id = ?");
            update.setString(1, this.title);
            update.setString(2, this.author);
            update.setInt(3, this.id);
            update.executeUpdate();
        }
    }
}
