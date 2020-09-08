package games;

import entity.Players;
import exceptions.PlayersException;
import factory.Factory;
import list.Lists;
import ui.panels.MainPlay;
import validator.PlayersValidator;

import javax.swing.*;
import java.io.*;

public class Game {

    private final Lists lists = new Lists();
    public static boolean endGame = false;
    private String correct;
    private String answer;
    private Players players1;
    private Players players2;

    public Game() {}

    public Players getPlayers1() { return players1;}

    public Players getPlayers2() {
        return players2;
    }

    public String getCorrect() {
        return correct;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Funcion que genera un nuevo jugador
     */
    private Players generatePlayers(int id) {
        Factory factory = new Factory();
        PlayersValidator validator = new PlayersValidator();
        Players players = factory.createPlayer(id);

        try {
            validator.validPlayer(players);
        } catch (PlayersException e){
            lists.addExceptionList(e.getMessage());
        }
        return players;
    }

    /**
     * Funcion que genera Todas las oraciones y las muestra por pantalla
     * @param mainPlay objeto tipo MainPanel
     */
    public void generateSentences(MainPlay mainPlay) {
        setAnswer(generateAnswer());
        mainPlay.setTxtAnswer(getAnswer());
        int turn = (int) Math.floor(Math.random() * 3);
        turn0(turn, mainPlay);
        turn1(turn, mainPlay);
        turn2(turn, mainPlay);
    }

    private void turn2(int turn, MainPlay mainPlay) {
        if (turn == 2) {
            mainPlay.setOpA(generateIncorrects());
            mainPlay.setOpB(generateIncorrects());
            mainPlay.setOpC(correct);
        }
    }

    private void turn1(int turn, MainPlay mainPlay) {
        if (turn == 1) {
            mainPlay.setOpA(generateIncorrects());
            mainPlay.setOpB(correct);
            mainPlay.setOpC(generateIncorrects());
        }
    }

    private void turn0(int turn, MainPlay mainPlay) {
        if (turn == 0) {
            mainPlay.setOpA(correct);
            mainPlay.setOpB(generateIncorrects());
            mainPlay.setOpC(generateIncorrects());
        }
    }

    /**
     * Funcion que inicia el juego y genera las listas
     * como las preguntas, correctas, incorrectas
     * @return String pregunta actual
     * @throws Exception
     */
    public void start(MainPlay mainPlay, int cantPlayers) throws Exception {
        if(cantPlayers==1) {
            this.players1 = generatePlayers(1);
            mainPlay.setIdPlayer(players1.getIdPlayer());
            mainPlay.setNamePlayer(players1.getName());
        } else{
            this.players1 = generatePlayers(1);
            this.players2 = generatePlayers(2);
        }
        generateList();
        generateSentences(mainPlay);
    }

    /**
     * Genera un numero entero al azar para la posicion de la oración
     * incorrecta a mostrar en pantalla, en la lista de Incorrectas
     * de la base de datos
     * @return String con la respuesta incorrecta a mostrar
     */
    public String generateIncorrects() {
        return lists.searchIncorrect((int) Math.floor(Math.random() * lists.incorrectListSize()));
    }

    /**
     * Genera un numero entero al azar para la posicion de la pregunta
     * a responder, en la lista de Preguntas de la base de datos
     * @return String con la pregunta a responder
     */
    public String generateAnswer() {
        int pos = (int) Math.floor(Math.random() * lists.answersListSize());
        correct = lists.searchCorrectList(pos);
        return lists.searchAnswersList(pos);
    }

    /**
     * Funciones que leen y generan las listas de Preguntas,
     * Respuestas Correctas e Incorrectas
     * @throws Exception
     */
    public void generateList () throws Exception {
        try {
            answerList();
            correctList();
            incorrectList();
        } catch (Exception e){
            lists.addExceptionList(e.getMessage());
        }
    }

    public void incorrectList() throws Exception {
        File fileIncorrects = new File("sources/incorrectas.bbl");
        BufferedReader readIncorrects = new BufferedReader(new FileReader(fileIncorrects));
        String incorrects;
        while ((incorrects = readIncorrects.readLine()) != null) {
            lists.addIncorrectList(incorrects);
        }
        readIncorrects.close();
    }

    public void correctList() throws Exception {
        File fileCorrects = new File("sources/correctas.bbl");
        BufferedReader readCorrects = new BufferedReader(new FileReader(fileCorrects));
        String corrects;
        int j=1;
        while ((corrects = readCorrects.readLine()) != null) {
            lists.addCorrectList(j,corrects);
            j++;
        }
        readCorrects.close();
    }

    public void answerList() throws Exception {
        File fileAnswers = new File("sources/preguntas.bbl");
        BufferedReader readAnswers = new BufferedReader(new FileReader(fileAnswers));
        String answers;
        int i=1;
        while ((answers = readAnswers.readLine()) != null) {
            lists.addAnswersList(i,answers);
            i++;
        }
        readAnswers.close();
    }

    /**
     * Funcion que a medida de los intentos fallidos va imprimiendo
     * por pantalla la imagen relacionada al numero de intento fallido
     * @param intentFailed Numero entero del contador de intentos fallidos
     * @return La imagen tipo jpg a mostrar por pantalla
     */
    public ImageIcon searchImageIcon(int intentFailed) {
        ImageIcon imageIcon = new ImageIcon();
        if (intentFailed==1) {
            imageIcon = new ImageIcon("sources/ok.jpg");
        } else {
            imageIcon = new ImageIcon("sources/error.jpg");
        }
        return imageIcon;
    }

    /**
     * Funcion que imprime la imagen de No asierto en la opcion seleccionada
     * ademas suma puntos a errores y palabras no acertadas
     * @param mainPlay objeto tipo MainPanel
     */
    public void no(MainPlay mainPlay, int id) {
        mainPlay.setResult(searchImageIcon(2));
        if(id==1){ no1(mainPlay);}else { no2(mainPlay);}
    }

    private void no2(MainPlay mainPlay) {
        players2.setNoScore(players2.getNoScore()+10);
        players2.setCant_NotAssert(players2.getCant_NotAssert()+1);
        players2.setResultate(players2.getScore()-players2.getNoScore());
        mainPlay.setTxtScore(String.valueOf(players2.getResultate()));
    }

    private void no1(MainPlay mainPlay) {
        players1.setNoScore(players1.getNoScore()+10);
        players1.setCant_NotAssert(players1.getCant_NotAssert()+1);
        players1.setResultate(players1.getScore()-players1.getNoScore());
        mainPlay.setTxtScore(String.valueOf(players1.getResultate()));
    }

    /**
     * Funcion que imprime la imagen de Asierto en la opcion seleccionada
     * Ademas suma puntos y cantidad de aciertos
     * @param mainPlay objeto MainPanel
     */
    public void yes(MainPlay mainPlay, int id) {
        mainPlay.setResult(searchImageIcon(1));
        if(id==1){ yes1(mainPlay);}else { yes2(mainPlay);}
    }

    private void yes2(MainPlay mainPlay) {
        players2.setScore(players2.getScore()+10);
        players2.setCantAssert(players2.getCantAssert()+1);
        players2.setResultate(players2.getScore()-players2.getNoScore());
        mainPlay.setTxtScore(String.valueOf(players2.getResultate()));
    }

    private void yes1(MainPlay mainPlay) {
        players1.setScore(players1.getScore()+10);
        players1.setCantAssert(players1.getCantAssert()+1);
        players1.setResultate(players1.getScore()-players1.getNoScore());
        mainPlay.setTxtScore(String.valueOf(players1.getResultate()));
    }

    /**
     * Funcion que supervisa si con la opcion seleccionada es igual o no
     * a la respuesta correcta de cada pregunta
     * @param option Letra con la seleccion de cada boton
     * @param mainPlay objeto MainPanel
     */
    public void isCorrect(char option, MainPlay mainPlay, int id) {
        switch (option){
            case 'a':
                if (correct.equals(mainPlay.getOpA().getText())) { yes(mainPlay,id);} else { no(mainPlay,id);}
                break;
            case 'b':
                if (correct.equals(mainPlay.getOpB().getText())) { yes(mainPlay,id);} else { no(mainPlay,id);}
                break;
            case 'c':
                if (correct.equals(mainPlay.getOpC().getText())) { yes(mainPlay,id);} else { no(mainPlay,id);}
                break;
        }
    }

}
