package controller;

import messages.MessageInformation;
import ui.Results;
import ui.panels.ResultsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ResultsController extends Controller{

    private Results results;

    public ResultsController(Results results) {
        super(results);
        this.results = results;
        this.results.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.results.setVisible(true);
        this.results.getPanel();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ResultsPanel resultsPanel = (ResultsPanel) results.getPanel();
        new MessageInformation("GAME OVER", "THANK YOU FOR PLAYING WITH OUR");
        System.exit(0);
    }

}
