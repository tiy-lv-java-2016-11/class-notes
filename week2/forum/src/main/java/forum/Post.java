package forum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jeff on 12/8/16.
 */
public class Post {
    String author;
    String text;
    int replyId;

    public Post(String author, String text, int replyId) {
        this.author = author;
        this.text = text;
        this.replyId = replyId;
    }

    @Override
    public String toString() {
        return String.format("Post Author=%s Text=%s ReplyId=%d", author, text, replyId);
    }

    public static ArrayList<Post> loadData() throws FileNotFoundException {
        ArrayList<Post> posts = new ArrayList<>();

        File f = new File("posts.txt");
        Scanner fileScanner = new Scanner(f);
        while(fileScanner.hasNext()){
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Post post = new Post(columns[1], columns[2], Integer.parseInt(columns[0]));
            posts.add(post);
        }

        return posts;
    }
}
