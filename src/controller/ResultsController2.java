package controller;

import messages.MessageInformation;
import ui.Results2;
import ui.panels.ResultsPanel2;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ResultsController2 extends Controller{

    private Results2 results2;

    public ResultsController2(Results2 results2) {
        super(results2);
        this.results2 = results2;
        this.results2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.results2.setVisible(true);
        this.results2.getPanel();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ResultsPanel2 resultsPanel2 = (ResultsPanel2) results2.getPanel();
        new MessageInformation("GAME OVER", "THANK YOU FOR PLAYING WITH OUR");
        System.exit(0);
    }
}
