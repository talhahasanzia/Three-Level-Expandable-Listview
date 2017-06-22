package com.example.threelevelexpandiblelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;

    String[] parent = new String[]{"MOVIES", "GAMES"};


    String[] movies = new String[]{"Horror", "Action", "Thriller/Drama"};
    String[] games = new String[]{"FPS", "MOBA", "RPG", "RACING"};


    // movies
    String[] horror = new String[]{"Conjuring", "Insidious", "The Ring"};
    String[] action = new String[]{"Jon Wick", "Die Hard", "Fast 7", "Avengers"};
    String[] thriller = new String[]{"Imitation Game", "Tinker, Tailer, Soldier, Spy", "Inception", "Manchester by the Sea"};


    // games
    String[] fps = new String[]{"CS: GO", "Team Fortress 2", "Overwatch", "Battlefield 1", "Halo II", "Warframe"};
    String[] moba = new String[]{"Dota 2", "League of Legends", "Smite", "Strife", "Heroes of the Storm"};
    String[] rpg = new String[]{"Witcher III", "Skyrim", "Warcraft", "Mass Effect II", "Diablo", "Dark Souls", "Last of Us"};
    String[] racing = new String[]{"NFS: Most Wanted", "Forza Motorsport 3", "EA: F1 2016", "Project Cars"};


    HashMap<String, String[]> thirdLevelMovies = new HashMap<>();
    HashMap<String, String[]> thirdLevelGames = new HashMap<>();


    List<String[]> secondLevel = new ArrayList<>();


    List<HashMap<String, String[]>> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        secondLevel.add(movies);
        secondLevel.add(games);

        // movies
        thirdLevelMovies.put(movies[0], horror);
        thirdLevelMovies.put(movies[1], action);
        thirdLevelMovies.put(movies[2], thriller);


        // games
        thirdLevelGames.put(games[0], fps);
        thirdLevelGames.put(games[1], moba);
        thirdLevelGames.put(games[2], rpg);
        thirdLevelGames.put(games[3], racing);


        data.add(thirdLevelMovies);
        data.add(thirdLevelGames);

        expandableListView = (ExpandableListView) findViewById(R.id.expandible_listview);

        ParentLevel parentLevelAdapter = new ParentLevel(this, parent, secondLevel,data);

        expandableListView.setAdapter(parentLevelAdapter);


    }
}
