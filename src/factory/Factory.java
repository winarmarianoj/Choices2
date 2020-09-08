package factory;

import entity.Choices;
import entity.Players;
import ui.panels.MainPlay;

import javax.swing.*;

public class Factory {
    /**
     * Crea un objeto Player
     * @param id entero con el id del jugador nuevo
     * @return objeto Players
     */
    public Players createPlayer(int id){
        Players players = new Players();
        players.setName(JOptionPane.showInputDialog(null, " ADD PLAYER NAME : ", " DATA PLAYERS ID : " + " " + id, JOptionPane.QUESTION_MESSAGE));
        players.setIdPlayer(id);
        players.setCantAnswers(0);
        players.setScore(0);
        players.setCantAssert(0);
        players.setNoScore(0);
        players.setCant_NotAssert(0);
        players.setResultate(0);
        return players;
    }

    /**
     * Crea objeto Choices con la info para enviar por conexión
     * @param mainPlay panel de juego
     * @return objeto Choices
     */
    public Choices createChoices(MainPlay mainPlay) {
        Choices choices = new Choices();
        choices.setAnswers(String.valueOf(mainPlay.getTxtAnswer()));
        choices.setOptionA(String.valueOf(mainPlay.getOpA()));
        choices.setOptionB(String.valueOf(mainPlay.getOpB()));
        choices.setOptionC(String.valueOf(mainPlay.getOpC()));
        return choices;
    }
}
