/**
 * @author Shota Takahira
 * @date 02.04.2020
 * @version 1.0
 *
 */

package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.TableModel;

import app.DataInitialization;
import model.*;


public class CreateGui extends JPanel{
    private TableModel playerModel;

    private JTextField[] userInput;
    private JButton createButton;
    private JComboBox<String> statusList;
    String[] status = {"bitte auswählen", "fit", "verletzt"};

    public CreateGui(TableModel playerModel){
        this.setLayout(new BorderLayout(10, 10));

        this.playerModel = playerModel;

        createButton = new JButton("erstellen");
        createButton.setEnabled(false);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int playernumber;
                try {
                    playernumber = Integer.parseInt(userInput[2].getText());
                }catch(NumberFormatException n){
                    userInput[2].setText("");
                    return;
                }
                if(playernumber < 100 && playernumber > 0) {
                    DataInitialization.getInstance().getTeam().addPlayer(new Player(userInput[0].getText(), userInput[1].getText(), playernumber, statusList.getSelectedItem().toString()));
                    userInput[0].setText("");
                    userInput[1].setText("");
                    userInput[2].setText("");
                    statusList.setSelectedItem("bitte auswählen");
                    JOptionPane.showMessageDialog(null, "Spieler erfolgreich erstellt!");
                }else{
                    JOptionPane.showMessageDialog(null, "Spielernummer muss eine Zahl zwischen 1-99 sein!");
                    userInput[2].setText("");
                }
            }
        });
        statusList = new JComboBox<String>(status);
        statusList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(statusList.getSelectedItem() == "fit" | statusList.getSelectedItem() == "verletzt")
                    createButton.setEnabled(true);
                else
                    createButton.setEnabled(false);
            }
        });
        this.add(getPlayerPanel());
    }

    private JPanel getPlayerPanel(){
        JPanel playerPanel = new JPanel(new BorderLayout(5,5));
        JPanel btnPanel    = new JPanel(new BorderLayout(5,5));

        userInput = new JTextField[playerModel.getColumnCount()];
        JPanel inputPanel = new JPanel(new GridLayout(playerModel.getColumnCount(),2));
        for (int i=0; i < playerModel.getColumnCount() - 1; i++){
            userInput[i] = new JTextField();
            inputPanel.add(new JLabel(playerModel.getColumnName(i)+": "));
            inputPanel.add(userInput[i]);
        }
        inputPanel.add(new JLabel("Status: "));
        inputPanel.add(statusList);

        playerPanel.add(new JLabel("Zeilen erfassen"), BorderLayout.NORTH);
        playerPanel.add(inputPanel, BorderLayout.CENTER);

        btnPanel.add(createButton,BorderLayout.EAST);
        playerPanel.add(btnPanel, BorderLayout.SOUTH);

        return playerPanel;
    }

    public void resetInput(){
        userInput[0].setText("");
        userInput[1].setText("");
        userInput[2].setText("");
        statusList.setSelectedItem("bitte auswählen");
    }
}
