/**
 * @author Shota Takahira
 * @date 02.04.2020
 * @version 1.0
 *
 */

package model;

public class Player {
    private String playername;
    private String position;
    private int playernumber;
    private String status;

    public Player(){}

    public Player(String playername, String position, int playernumber, String status) {
        this.setPlayername(playername);
        this.setPosition(position);
        this.setPlayernumber(playernumber);
        this.setStatus(status);
    }

    public String getPlayername() {
        return playername;
    }

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPlayernumber() {
        return this.playernumber;
    }

    public void setPlayernumber(int playernumber) {
        this.playernumber = playernumber;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
