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

public class DeleteGui extends JPanel{
    private TableModel playerModel;
    private JPanel tablePanel;
    private JTextField playernumberInput;
    private JTable playerTable;
    private JButton deleteButton;

    public DeleteGui(TableModel playerModel){
        this.setLayout(new BorderLayout(10, 10));

        this.playerModel = playerModel;

        playerTable = new JTable(playerModel);
        deleteButton = new JButton("löschen");
        deleteButton.addActionListener(new ActionListener() {
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
                    tablePanel.setVisible(true);
                    DataInitialization.getInstance().getTeam().deleteSearchResult();
                    playernumberInput.setText("");
                }else{
                    JOptionPane.showMessageDialog(null, "Spielernummer muss eine Zahl zwischen 1-99 sein!");
                    playernumberInput.setText("");
                }
            }
        });

        playernumberInput = new JTextField();
        playernumberInput.setColumns(10);

        this.add(getPlayerPanel());
    }


    private JPanel getPlayerPanel(){
        JPanel deletePanel = new JPanel(new BorderLayout(5, 5));
        JPanel playerPanel = new JPanel(new BorderLayout(5,5));
        JPanel btnPanel    = new JPanel(new BorderLayout(5,5));
        tablePanel  = new JPanel(new BorderLayout(5,5));

         btnPanel.add(deleteButton,BorderLayout.EAST);

         deletePanel.add(new JLabel("Spielernummer: "), BorderLayout.WEST);
         deletePanel.add(playernumberInput, BorderLayout.EAST);

         tablePanel.setVisible(false);
         tablePanel.add(new JLabel("Dieser Spieler wurde gelöscht:"), BorderLayout.NORTH);
         tablePanel.add(new JScrollPane(playerTable), BorderLayout.CENTER);

         playerPanel.add(deletePanel, BorderLayout.NORTH);
         playerPanel.add(tablePanel, BorderLayout.CENTER);
         playerPanel.add(btnPanel, BorderLayout.SOUTH);


        return playerPanel;
    }

    public void setTablePanelVisible(boolean visible){
        tablePanel.setVisible(visible);
    }

    public void resetInput(){
        playernumberInput.setText("");
    }
}
