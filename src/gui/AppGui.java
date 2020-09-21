/**
 * @author Shota Takahira
 * @date 02.04.2020
 * @version 1.0
 *
 */

package gui;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableModel;

import app.DataInitialization;
import java.awt.*;

public class AppGui extends JFrame {
    private TableModel playerModel;

    private JTabbedPane tabbedPane;
    private SearchGui searchPane;
    private CreateGui createPane;
    private DeleteGui deletePane;


    public AppGui(TableModel playerModel){
        super("Spielerinformationen des FC Altstettens");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.playerModel = playerModel;

        tabbedPane = new JTabbedPane();

        initSearchTab();
        initCreateTab();
        initDeleteTab();

        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                DataInitialization.getInstance().getTeam().stopSearch();
                deletePane.setTablePanelVisible(false);
                deletePane.resetInput();
                searchPane.resetInput();
                createPane.resetInput();
            }
        });
        this.add(tabbedPane, BorderLayout.CENTER);

        pack();
        this.setVisible(true);
    }

    private void initSearchTab(){
        searchPane = new SearchGui(playerModel);
        tabbedPane.add("suchen", searchPane);
    }

    private void initCreateTab(){
        createPane = new CreateGui(playerModel);
        tabbedPane.add("erstellen", createPane);
    }

    private void initDeleteTab(){
        deletePane = new DeleteGui(playerModel);
        tabbedPane.add("löschen", deletePane);
    }


}
