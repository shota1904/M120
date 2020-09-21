/**
 * @author Shota Takahira
 * @date 02.04.2020
 * @version 1.0
 *
 */

package app;
import model.*;

public class DataInitialization {
    private Team team;
    private static DataInitialization instance;

    private DataInitialization(){
        team = new Team();

        team.addPlayer(new Player("Lionel Messi", "Flügelspieler", 10, "fit"));
        team.addPlayer(new Player("Thiago Alcántara", "offensives Mittelfeldspieler", 6, "verletzt"));
        team.addPlayer(new Player("Cristiano Ronaldo", "Stürmer", 7, "fit"));
        team.addPlayer(new Player("Alphonso Davies", "Aussenverteidiger", 19, "fit"));
        team.addPlayer(new Player("Sergio Ramos", "Innenverteidiger", 4, "fit"));
        team.addPlayer(new Player("Andres Iniesta", "zentrales Mittelfeldspieler", 8, "fit"));
        team.addPlayer(new Player("Marc-André ter Stegen", "Torwart", 1, "fit"));
        team.addPlayer(new Player("David Alaba", "Aussenverteidiger", 27, "verletzt"));
        team.addPlayer(new Player("Jordi Alba", "Aussenverteidiger", 18, "fit"));
        team.addPlayer(new Player("Ángel Di María", "Flügelspieler", 11, "fit"));
        team.addPlayer(new Player("Ansu Fati", "Stürmer", 31, "verletzt"));
        team.addPlayer(new Player("Joshua Zirkzee", "Stürmer", 35, "fit"));


    }

    public static DataInitialization getInstance(){
        if(instance == null){
            instance = new DataInitialization();
        }
        return instance;
    }

    public Team getTeam(){
        return team;
    }

}

