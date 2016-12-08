package forum;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by jeff on 12/8/16.
 */
public class PostTest {

    @Test
    public void testLoadData() throws FileNotFoundException {
        ArrayList<Post> posts = Post.loadData();
        //2|alice|Hi charlie
        assertEquals(5, posts.size());
        Post post = posts.get(3);
        assertEquals(-1, post.replyId);
        assertEquals("alice", post.author);
        assertEquals("Hi charlie", post.text);
    }
}
