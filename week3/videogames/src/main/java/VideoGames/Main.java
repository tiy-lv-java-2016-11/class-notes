package VideoGames;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jeff on 12/12/16.
 */
public class Main {

    public static void main(String[] args) {
        Game finalFantasy = new Game("Final Fantasy XV", "T", 2016);
        Game watchdogs2 = new Game("Watchdogs 2", "M", 2016);
        Game fallout4 = new Game("Fallout 4", "M", 2016);
        Game battlefield4 = new Game("Battlefield 4", "M", 2016);
        Game starWarsBattleFront = new Game("Star Wars Battlefront", "M", 2015);
        Game grandTheftAuto5 = new Game("Grand Theft Auto 5", "M", 2013);

        List<Game> games = new ArrayList<>();
        games.add(finalFantasy);
        games.add(watchdogs2);
        games.add(fallout4);
        games.add(battlefield4);
        games.add(starWarsBattleFront);
        games.add(grandTheftAuto5);

        Game ff = games.get(0);

        List<Game> year2013 = new ArrayList<>();
        for(Game game : games){
            if(game.getYear() == 2013){
                year2013.add(game);
            }
        }

        Map<Integer, ArrayList<Game>> yearMap = new HashMap<>();
        for(Game game : games){
            Integer year = game.getYear();

            ArrayList<Game> gameList = yearMap.get(year);
            if(gameList == null){
                gameList = new ArrayList<>();
                yearMap.put(year, gameList);
            }
            gameList.add(game);

        }




    }
}
