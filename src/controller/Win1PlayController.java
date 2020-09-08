package controller;

import games.Game;
import messages.MessageError;
import messages.MessageInformation;
import ui.Results;
import ui.WindowPlay;
import ui.panels.MainPlay;
import ui.panels.ResultsPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import static ui.panels.MainPlay.*;

public class Win1PlayController extends Controller{

    private static final int MAX_SECONDS = 10;

    private final WindowPlay windowPlay;
    private final Game game;
    private int secondsOld;

    public Win1PlayController(WindowPlay windowPlay, Game game) {
        super(windowPlay, game);
        this.windowPlay = windowPlay;
        this.windowPlay.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.windowPlay.setVisible(true);
        this.windowPlay.getPanel();
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        MainPlay mainPlay = (MainPlay) windowPlay.getPanel();

        switch (actionEvent.getActionCommand()){
            case A:
                go('a',mainPlay);
                break;
            case B:
                go('b',mainPlay);
                break;
            case C:
                go('c',mainPlay);
                break;
            case FINALIZE:
                printClear(mainPlay);
                mainPlay.setResult(new ImageIcon("sources/continua.jpg"));
                Results res = new Results("STADISTICS", new ResultsPanel(game));
                Controller resulController = new ResultsController(res);
                break;
            case EXIT:
                new MessageInformation("GAME OVER", "THANK YOU " + " " + game.getPlayers1().getName() + " " + "FOR PLAYING WITH OUR");
                System.exit(0);
                break;
        }
    }

    /**
     * Funcion que inicia la operacion por cada opcion seleccionada
     * @param mainPlay objeto tipo MainPanel
     */
    private void go(char letra, MainPlay mainPlay) {
        int seconds = mainPlay.getSeconds();
        int cant = seconds-secondsOld;
        if (cant<0) cant*=(-1);
        if (cant <= MAX_SECONDS) {
            game.isCorrect(letra,mainPlay,1);
            printClear(mainPlay);
        } else {
            new MessageError("TIMER", "TIME IS OVER");
            new MessageInformation("TIMER", "PRESIONE NUEVAMENTE START PARA COMENZAR NUEVAMENTE O QUIT PARA SALIR");
            secondsOld=0;
        }
        secondsOld=seconds;
        game.generateSentences(mainPlay);
    }

    /**
     * Funcion que deja en blanco los campos Letras Utilizadas y Acertadas
     * @param mainPlay tipo de dato del MainPanel de Panel
     */
    private void printClear(MainPlay mainPlay) {
        mainPlay.setTxtAnswer(" ");
        mainPlay.setOpA(" ");
        mainPlay.setOpB(" ");
        mainPlay.setOpC(" ");
    }

}
