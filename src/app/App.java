/**
 * @author Shota Takahira
 * @date 02.04.2020
 * @version 1.0
 *
 */

package app;
import model.*;
import gui.*;

public class App {

    public static void main(String[] args){

        Team team = DataInitialization.getInstance().getTeam();
        System.out.println(team);

        AppGui gui = new AppGui(team);
    }
}
