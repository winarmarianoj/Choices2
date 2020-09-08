package controller;

import connection.Connection;
import games.Game;
import ui.Results;
import ui.Results2;
import ui.Welcome;
import ui.WindowPlay;

import java.awt.event.ActionListener;

public abstract class Controller implements ActionListener {

    /**
     * Funcion del Controlador implementa las Acciones en los botones
     */
    public Controller(Welcome welcome){welcome.setController(this);}
    public Controller(WindowPlay windowPlay, Game game){ windowPlay.setController(this);}
    public Controller(WindowPlay windowPlay, Game game, Connection connection){windowPlay.setController(this);}
    public Controller(Results results){results.setController(this);}
    public Controller(Results2 results2){results2.setController(this);}

}

