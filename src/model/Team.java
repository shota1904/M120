/**
 * @author Shota Takahira
 * @date 02.04.2020
 * @version 1.0
 *
 */

package model;
import javax.swing.table.AbstractTableModel;
import java.util.Vector;

public class Team extends AbstractTableModel {
    private Vector<Player> allPlayer;
    private final String[] title = {"Name", "Position", "Spielernummer", "Status"};
    private boolean isSearching;
    private Vector<Player> searchResult;

    public Team(){
        allPlayer = new Vector<Player>();
    }

    @Override
    public int getColumnCount(){
        return title.length;
    }


    @Override
    public int getRowCount(){
        if(isSearching){
            return searchResult.size();
        }else {
            return allPlayer.size();
        }
    }

    @Override
    public String getColumnName(int column){
        return title[column];
    }



    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        Player player;
        if(isSearching){
            player = searchResult.get(rowIndex);
        }else{
            player = allPlayer.get(rowIndex);
        }
        switch (columnIndex){
            case 0: return player.getPlayername();
            case 1: return player.getPosition();
            case 2: return player.getPlayernumber();
            case 3: return player.getStatus();
            default: return null;
        }
    }

    public void search(int playernumber){
        isSearching = true;
        searchResult = new Vector<Player>();
        for (Player player: allPlayer){
            if(player.getPlayernumber() == playernumber)
                searchResult.add(player);
        }
        fireTableDataChanged();
    }

    public void stopSearch(){
        isSearching = false;
        fireTableDataChanged();
    }

    public void deleteSearchResult(){
        for (Player player: searchResult){
            int i = 0;
            while(i < allPlayer.size()){
                if(allPlayer.get(i) == player){
                    allPlayer.remove(i);
                }else{
                    i++;
                }
            }
        }
    }

    public void addPlayer(Player player){
        allPlayer.add(player);
        this.fireTableDataChanged();
    }

}
