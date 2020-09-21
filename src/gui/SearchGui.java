/**
 * @author Shota Takahira
 * @date 02.04.2020
 * @version 1.0
 *
 */

package gui;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;

import app.DataInitialization;

public class SearchGui extends JPanel{
    private TableModel playerModel;

    private JTextField playernumberInput;
    private JTable playerTable;
    private JButton searchButton;

    public SearchGui(TableModel playerModel){
        this.setLayout(new BorderLayout(10, 10));
        this.playerModel = playerModel;

        searchButton = new JButton("suchen");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int playernumber;
                try {
                    playernumber = Integer.parseInt(playernumberInput.getText());
                }catch (NumberFormatException n){
                    playernumberInput.setText("");
                    return;
                }
                if(playernumber < 100 && playernumber > 0) {
                    DataInitialization.getInstance().getTeam().search(playernumber);
                    playernumberInput.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, "Spielernummer muss eine Zahl zwischen 1-99 sein!");
                    playernumberInput.setText("");
                }
            }
        });
        playernumberInput = new JTextField();
        playernumberInput.setColumns(10);

        playerTable = new JTable(playerModel);


        this.add(getPlayerPanel());

    }


    private JPanel getPlayerPanel(){
        JPanel searchPanel = new JPanel(new BorderLayout(5, 5));
        JPanel playerPanel = new JPanel(new BorderLayout(5,5));
        JPanel btnPanel    = new JPanel(new BorderLayout(5,5));


        btnPanel.add(searchButton,BorderLayout.EAST);

        searchPanel.add(new JLabel("Spielernummer: "), BorderLayout.WEST);
        searchPanel.add(playernumberInput, BorderLayout.EAST);

        playerPanel.add(searchPanel, BorderLayout.NORTH);
        playerPanel.add(new JScrollPane(playerTable), BorderLayout.CENTER);
        playerPanel.add(btnPanel, BorderLayout.SOUTH);


        return playerPanel;
    }

    public void resetInput(){
        playernumberInput.setText("");
    }
}

