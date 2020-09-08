package controller;

import clock.Clock;
import connection.Client;
import connection.Connection;
import connection.Server;
import games.Game;
import list.Lists;
import messages.MessageInformation;
import ui.Welcome;
import ui.WindowPlay;
import ui.panels.MainPlay;
import ui.panels.WelcomePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static ui.panels.WelcomePanel.*;

public class WelcomeController extends Controller{

    private final Welcome welcome;
    private final Game game;
    private final MainPlay mainPlay;
    private final Clock clock;
    private final Lists lists;

    private Connection connection;
    private static final int PORT = 8080;


    /**
     * Funcion del Controlador implementa las Acciones en los botones
     * @param welcome
     */
    public WelcomeController(Welcome welcome) {
        super(welcome);
        this.welcome = welcome;
        this.welcome.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.welcome.setVisible(true);
        this.welcome.getPanel();
        game = new Game();
        lists = new Lists();
        mainPlay = new MainPlay();
        clock = new Clock(mainPlay,lists);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        WelcomePanel panel = (WelcomePanel) welcome.getPanel();

        switch (actionEvent.getActionCommand()){
            case ONE_PLAYER:
                execute1Player();
                break;
            case TWO_PLAYER:
                execute2Player();
                break;
            case QUIT:
                new MessageInformation("GAME OVER", "THANK YOU FOR PLAYING WITH OUR");
                System.exit(0);
                break;
            default:
                new  MessageInformation("CHOICES 2", "THANK YOU FOR PLAYING WHITH OUR");
                break;
        }
    }

    /**
     * Carga lista de imagenes de fondo
     */
    private void imageList() {
        lists.addImgList("images/Capernaum1.jpg");
        lists.addImgList("images/Ceasarea1.jpg");
        lists.addImgList("images/israel21.jpg");
        lists.addImgList("images/israel31.jpg");
        lists.addImgList("images/jerusalen.jpg");
        lists.addImgList("images/jerusalen11.jpg");
        lists.addImgList("images/Mount-of-Olives11.jpg");
        lists.addImgList("images/Mount_of_olives.jpg");
        lists.addImgList("images/Mount_Sinai.jpg");
        lists.addImgList("images/Mount_Tabor41.jpg");
        lists.addImgList("images/olives1.jpg");
        lists.addImgList("images/playa1.jpg");
        lists.addImgList("images/tierraMasChica.jpg");
    }

    /**
     * Ejecuta Menu 1 Jugador
     */
    private void execute1Player() {
        imageList();
        int pos = (int) Math.floor(Math.random() * lists.imgListSize());
        mainPlay.setImage(new ImageIcon(lists.searchImages(pos)));

        try {
            clock.start();
            game.start(mainPlay,1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        WindowPlay windowPlay = new WindowPlay(" ONE PLAYERS ", mainPlay);
        Controller win1Controller = new Win1PlayController(windowPlay, game);
    }

    /**
     * Ejecuta menu 2 Jugadores
     */
    private void execute2Player() {
        imageList();
        int pos = (int) Math.floor(Math.random() * lists.imgListSize());
        mainPlay.setImage(new ImageIcon(lists.searchImages(pos)));

        String select = JOptionPane.showInputDialog(null," ADD 1=SERVER OR 2=CLIENT : ", " SERVER CONNECTION",JOptionPane.QUESTION_MESSAGE);
        int option = Integer.parseInt(select);

        if(option==1){
            connection = new Server(PORT);
            new MessageInformation("SERVER CONNECTION", "WAIT TO CLIENT");
        } else {
            connection = new Client("localhost", PORT);
        }
        connection.startConnection();

        try {
            clock.start();
            game.start(mainPlay,2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        new MessageInformation("TURN", "PLAYER 1 FIRST TURN");
        mainPlay.setIdPlayer(game.getPlayers1().getIdPlayer());
        mainPlay.setNamePlayer(game.getPlayers1().getName());
        WindowPlay windowPlay = new WindowPlay(" TWO PLAYERS ", mainPlay);
        Controller win2Controller = new Win2PlayController(windowPlay, game,connection);
    }

}
