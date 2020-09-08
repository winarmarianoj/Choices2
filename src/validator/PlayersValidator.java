package validator;

import entity.Players;
import exceptions.PlayersException;

public class PlayersValidator {

    public boolean validPlayer(Players players) throws PlayersException {
        boolean res = validName(players.getName());
        res &= validID(players.getIdPlayer());

        if(!res){ throw new PlayersException();}
        return res;
    }
    private boolean validName(String text){ return !text.isEmpty();}
    private boolean validID(int a) { return a>0;}
}
