package hellospark;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jeff on 12/14/16.
 */
public class Main {
    static User user;

    public static void main(String[] args) {

        Spark.init();
        boolean sale = true;
        Spark.get("/", ((request, response) -> {
            HashMap m = new HashMap();

            if(user == null){
                return new ModelAndView(m, "login.html");
            }
            else {
                m.put("user", user);
                if (sale) {
                    m.put("saleItem", "hats");
                }

                //Set a list of items
                ArrayList<String> items = new ArrayList<String>();
                items.add("Shoes");
                items.add("Boots");
                items.add("Sandles");
                m.put("items", items);

                ArrayList<User> users = new ArrayList<User>();
                users.add(new User("Sally"));
                users.add(new User("Fred"));
                m.put("users", users);

                return new ModelAndView(m, "home.html");
            }
        }), new MustacheTemplateEngine());

        Spark.post("/login",((request, response) -> {
            String name = request.queryParams("loginName");
            user = new User(name);
            response.redirect("/");
            return "";
        }));

    }
}
