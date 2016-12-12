package forum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jeff on 12/8/16.
 */
public class Forum {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Post> posts = Post.loadData();

        Scanner input = new Scanner(System.in);
        int replyId = -1;
        while(true){
            int id = 0;
            for(Post post : posts){
                if(post.replyId == replyId){
                    System.out.printf("(%d) %s by %s\n", id, post.text, post.author);
                }
                id++;
            }

            System.out.println("Type the id you want to see replies to:");
            replyId = input.nextInt();
        }
    }
}
