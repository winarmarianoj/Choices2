package controller;

import connection.Connection;
import entity.Choices;
import exceptions.ChoicesException;
import factory.Factory;
import games.Game;
import list.Lists;
import messages.MessageError;
import messages.MessageInformation;
import ui.Results;
import ui.WindowPlay;
import ui.panels.MainPlay;
import ui.panels.ResultsPanel2;
import validator.ChoicesValidator;

import static ui.panels.MainPlay.*;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Win2PlayController extends Controller implements Runnable{

    private static final int MAX_SECONDS = 20;

    private final WindowPlay windowPlay;
    private final Game game;
    private final Lists lists;
    private final Connection connection;
    private Choices choices;
    private int secondsOld;
    private int turn=1;

    public Win2PlayController(WindowPlay windowPlay, Game game, Connection connection) {
        super(windowPlay, game,connection);
        this.windowPlay = windowPlay;
        this.windowPlay.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.windowPlay.setVisible(true);
        this.windowPlay.getPanel();
        this.game = game;
        this.connection = connection;
        lists = new Lists();
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
                Results res = new Results(" STADISTICS TWO PLAYERS ", new ResultsPanel2(game));
                Controller resulController = new ResultsController(res);
                Game.endGame=true;
                break;
            case EXIT:
                new MessageInformation("GAME OVER", "THANK YOU " + " " + game.getPlayers1().getName() +
                        " " + " AND " + game.getPlayers2().getName() + " " + "FOR PLAYING WITH OUR");
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

        switch (turn){
            case 1:
                sendingGames(cant,letra, mainPlay,1);
                turn=2;
                mainPlay.setIdPlayer(game.getPlayers2().getIdPlayer());
                mainPlay.setNamePlayer(game.getPlayers2().getName());
                break;
            case 2:
                sendingGames(cant,letra, mainPlay,2);
                turn=1;
                mainPlay.setIdPlayer(game.getPlayers1().getIdPlayer());
                mainPlay.setNamePlayer(game.getPlayers1().getName());
                break;
        }
        secondsOld=seconds;
        game.generateSentences(mainPlay);
        generateChoices(mainPlay);
        sendChoicess();
    }

    /**
     * Funcion que genera el objeto Choices
     * @param mainPlay menu
     */
    private void generateChoices(MainPlay mainPlay) {
        Factory factory = new Factory();
        choices = factory.createChoices(mainPlay);
        ChoicesValidator validator = new ChoicesValidator();

        try{
            validator.validChoices(choices);
        } catch (ChoicesException e){
            lists.addExceptionList(e.getMessage());
        }
    }

    /**
     * Funcion que corrobora los segundos y envia a verificar si es correcta
     * @param cant cantidad de segundos transcurridos en la seleccion
     * @param letra seleccionada
     * @param mainPlay menu
     * @param i id del jugador
     */
    private void sendingGames(int cant, char letra, MainPlay mainPlay, int i) {
        if (cant <= MAX_SECONDS) {
            game.isCorrect(letra, mainPlay,i);
            printClear(mainPlay);
        } else {
            new MessageError("TIMER", "TIME IS OVER");
            new MessageInformation("TIMER", "PRESIONE NUEVAMENTE START PARA COMENZAR NUEVAMENTE O QUIT PARA SALIR");
            secondsOld=0;
        }
    }

    /**
     * Funcion que deja en blanco los campos Letras Utilizadas y Acertadas
     * @param mainPlay tipo de dato del MainPanel de Panel
     */
    private void printClear(MainPlay mainPlay) {
        mainPlay.setIdPlayer(0);
        mainPlay.setNamePlayer(" ");
        mainPlay.setTxtAnswer(" ");
        mainPlay.setOpA(" ");
        mainPlay.setOpB(" ");
        mainPlay.setOpC(" ");
    }

    /**
     * Funcion que envia paquete por soquets Choices elegido
     */
    private void sendChoicess(){
        connection.sendChoice(choices);
        takeChoices(choices);
    }

    /**
     * Funcion que recibe o toma un paquete Choices
     * @param choices objeto tipo Choices
     */
    private void takeChoices(Choices choices){
        choices.getMainPlay().setTxtAnswer(choices.getAnswers());
        choices.getMainPlay().setOpA(choices.getOptionA());
        choices.getMainPlay().setOpB(choices.getOptionB());
        choices.getMainPlay().setOpC(choices.getOptionC());
    }

    @Override
    public void run() {
        while (!Game.endGame){
            takeChoices(connection.haveChoices());
        }
    }
}
