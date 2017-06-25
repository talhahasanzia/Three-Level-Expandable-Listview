package com.talhahasanzia.threelevelexpandiblelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The Expandable list view.
     */
    ExpandableListView expandableListView;

    /**
     * The Parent Group Names.
     */
    String[] parent = new String[]{"MOVIES", "GAMES"}; // add more but remember to add further details
    //  String[] parent = new String[]{"MOVIES", "GAMES", "SERIALS"};

    /**
     * The Movies Genre List.
     */
// We have two main category
    String[] movies = new String[]{"Horror", "Action", "Thriller/Drama"};
    /**
     * The Games Genre List.
     */
    String[] games = new String[]{"Fps", "Moba", "Rpg", "Racing"};

    /**
     * The Serials Genre List.
     */
    //String[] serials = new String[]{"Crime", "Family", "Comedy"};



    /**
     * The Horror movie list.
     */
// movies category has further genres
    String[] horror = new String[]{"Conjuring", "Insidious", "The Ring"};
    /**
     * The Action Movies List.
     */
    String[] action = new String[]{"Jon Wick", "Die Hard", "Fast 7", "Avengers"};
    /**
     * The Thriller Movies List.
     */
    String[] thriller = new String[]{"Imitation Game", "Tinker, Tailer, Soldier, Spy", "Inception", "Manchester by the Sea"};


    /**
     * The Fps games.
     */
// games category has further genres
    String[] fps = new String[]{"CS: GO", "Team Fortress 2", "Overwatch", "Battlefield 1", "Halo II", "Warframe"};
    /**
     * The Moba games.
     */
    String[] moba = new String[]{"Dota 2", "League of Legends", "Smite", "Strife", "Heroes of the Storm"};
    /**
     * The Rpg games.
     */
    String[] rpg = new String[]{"Witcher III", "Skyrim", "Warcraft", "Mass Effect II", "Diablo", "Dark Souls", "Last of Us"};
    /**
     * The Racing games.
     */
    String[] racing = new String[]{"NFS: Most Wanted", "Forza Motorsport 3", "EA: F1 2016", "Project Cars"};


    /**
     * Datastructure for Third level movies.
     */
    LinkedHashMap<String, String[]> thirdLevelMovies = new LinkedHashMap<>();
    /**
     * Datastructure for Third level games.
     */
    LinkedHashMap<String, String[]> thirdLevelGames = new LinkedHashMap<>();


    /**
     * The Second level.
     */
    List<String[]> secondLevel = new ArrayList<>();


    /**
     * The Data.
     */
    List<LinkedHashMap<String, String[]>> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // second level category names (genres)
        secondLevel.add(movies);
        secondLevel.add(games);

        // movies category all data
        thirdLevelMovies.put(movies[0], horror);
        thirdLevelMovies.put(movies[1], action);
        thirdLevelMovies.put(movies[2], thriller);


        // games category all data
        thirdLevelGames.put(games[0], fps);
        thirdLevelGames.put(games[1], moba);
        thirdLevelGames.put(games[2], rpg);
        thirdLevelGames.put(games[3], racing);



        // all data
        data.add(thirdLevelMovies);
        data.add(thirdLevelGames);


        // expandable listview
        expandableListView = (ExpandableListView) findViewById(R.id.expandible_listview);

        // parent adapter
        ParentLevel parentLevelAdapter = new ParentLevel(this, parent, secondLevel,data);


        // set adapter
        expandableListView.setAdapter(parentLevelAdapter);


        // OPTIONAL : Show one list at a time
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if(groupPosition != previousGroup)
                    expandableListView.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });


    }
}
