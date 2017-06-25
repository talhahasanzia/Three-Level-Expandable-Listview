[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

# Three Level Exapandable List View

This is boiler plate code to implement 3-level exapandable list view in Android. This code will work with dynamic data, an
extension of its [gist](https://gist.github.com/st-f/2b2a838d3f0258c5c33f) which works only on static string text values.

![Demo gif](/sample.gif?raw=true "Demo")

## Getting Started

- Download or clone project
- Add in parent array for more main category, parent is top level list.
```
    String[] parent = new String[]{"MOVIES", "GAMES"};
```
- Define array for genre (subcategory) for each parent category added this is level 2, eg: 
```
   String[] movies = new String[]{"Horror", "Action", "Thriller/Drama"}
   String[] games = new String[]{"Fps", "Moba", "Rpg", "Racing"};

```

- Define level 3 elements in separate arrays:
```
 
    String[] horror = new String[]{"Conjuring", "Insidious", "The Ring"};
   
    String[] action = new String[]{"Jon Wick", "Die Hard", "Fast 7", "Avengers"};
    
    String[] thriller = new String[]{"Imitation Game", "Tinker, Tailer, Soldier, Spy", "Inception", "Manchester by the Sea"};

    String[] fps = new String[]{"CS: GO", "Team Fortress 2", "Overwatch", "Battlefield 1", "Halo II", "Warframe"};
   
    String[] moba = new String[]{"Dota 2", "League of Legends", "Smite", "Strife", "Heroes of the Storm"};
    
    String[] rpg = new String[]{"Witcher III", "Skyrim", "Warcraft", "Mass Effect II", "Diablo", "Dark Souls", "Last of Us"};
    
    String[] racing = new String[]{"NFS: Most Wanted", "Forza Motorsport 3", "EA: F1 2016", "Project Cars"};


```
- Define a ```secondLevel``` ArrayList, this will be used as key data to fetch arrays accross levels.

- Define LinkedHasMap for each subcategory where key is subcategory name, and value is a string array,

```
    LinkedHashMap<String, String[]> thirdLevelMovies = new LinkedHashMap<>();

    LinkedHashMap<String, String[]> thirdLevelGames = new LinkedHashMap<>();
    
    ...now putting it all together
    
        secondLevel.add(movies);
        secondLevel.add(games);
        
        thirdLevelMovies.put(movies[0], horror);
        thirdLevelMovies.put(movies[1], action);
        thirdLevelMovies.put(movies[2], thriller);
        
        thirdLevelGames.put(games[0], fps);
        thirdLevelGames.put(games[1], moba);
        thirdLevelGames.put(games[2], rpg);
        thirdLevelGames.put(games[3], racing);
        
        data.add(thirdLevelMovies);
        data.add(thirdLevelGames);
        
        expandableListView = (ExpandableListView) findViewById(R.id.expandible_listview);
        ParentLevel parentLevelAdapter = new ParentLevel(this, parent, secondLevel, data);
        expandableListView.setAdapter(parentLevelAdapter);   
    

```





## Built Using
- Android Studio 2.3.2
- Min SDK 16, Target SDK 25
- Build Tools 25.0.3
- Gradle 2.3.2

*Code will work fine as long as above configurations are met.*

*You will need to possibly edit code if you change min sdks etc.*




## Contributing

Anyone is allowed to fork and create a pull request provided that the code is improved in anyway.


## Authors

* [Talha Hasan Zia](https://github.com/talhahasanzia) - *Created sample working project with dynamic data.*
* Based on [gist code](https://gist.github.com/st-f/2b2a838d3f0258c5c33f) provided by [Stephane Schittly](https://github.com/st-f)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

Copyright 2017 Talha Hasan Zia

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

See the [LICENSE.md](LICENSE.md) file for details



