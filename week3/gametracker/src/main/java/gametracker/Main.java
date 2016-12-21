package gametracker;

import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jeff on 12/15/16.
 */
public class Main {
    static Map<String, User> users = new HashMap<>();
    public static final String SESSION_USER_NAME = "userName";
    public static List<Game> games = new ArrayList<>();

    public static void main(String[] args) {
        Spark.staticFileLocation("/public");
        Spark.init();

        games.add(new Game("Battlefield One", "Shooter", "Xbox", 2016));

        Spark.get("/", ((request, response) -> {
                    Session session = request.session();
                    String name = session.attribute(SESSION_USER_NAME);

                    User user = users.get(name);
                    HashMap m = new HashMap();
                    if(user == null){
                        return new ModelAndView(m, "login.html");
                    }
                    else{
                        m.put("games", games);
                        return new ModelAndView(m, "home.html");
                    }

                }), new MustacheTemplateEngine());

        Spark.post("/login", ((request, response) -> {
            String name = request.queryParams("loginName");
            User user = users.get(name);
            if(user == null){
                user = new User(name);
                users.put(name, user);
            }

            Session session = request.session();
            session.attribute(SESSION_USER_NAME, name);

            response.redirect("/");
            return "";

        }));

        Spark.post("/logout", ((request, response) -> {
            Session session = request.session();
            session.invalidate();
            response.redirect("/");
            return "";

        }));

        Spark.post("/create-game", ((request, response) -> {
            Session session = request.session();
            String name = session.attribute(SESSION_USER_NAME);
            User user = users.get(name);
            if(user == null){
                throw new Exception("User is not logged in");
            }

            String gameName = request.queryParams("gameName");
            String gameGenre = request.queryParams("gameGenre");
            String gamePlatform = request.queryParams("gamePlatform");
            int gameYear = Integer.parseInt(request.queryParams("gameYear"));
            Game game = new Game(gameName, gameGenre, gamePlatform, gameYear);

            games.add(game);

            response.redirect("/");
            return "";
        }));

        Spark.get("/detail", ((request, response) -> {
            Session session = request.session();
            User user = users.get(session.attribute(SESSION_USER_NAME));
            if(user == null){
                throw new Exception("User not logged in");
            }

            String gameName = request.queryParams("name");
            Game game = null;
            for(Game g : games){
                if(g.getName().equalsIgnoreCase(gameName)){
                    game = g;
                }
            }

            HashMap m = new HashMap();
            m.put("game", game);

            return new ModelAndView(m, "detail.html");

        }) , new MustacheTemplateEngine());

        Spark.post("/delete", ((request, response) -> {
            Session session = request.session();
            User user = users.get(session.attribute(SESSION_USER_NAME));
            if(user == null){
                throw new Exception("User not logged in");
            }

            String gameName = request.queryParams("gameName");

            Game game = null;
            for(Game g : games){
                if(g.getName().equalsIgnoreCase(gameName)){
                    game = g;
                }
            }

            games.remove(game);

            response.redirect("/");
            return "";

        }));
    }
}
