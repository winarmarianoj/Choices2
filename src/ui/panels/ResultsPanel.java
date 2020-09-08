package ui.panels;

import controller.Controller;
import games.Game;

import javax.swing.*;
import java.awt.*;
import static ui.Results.BG;

public class ResultsPanel extends Panel{

    public static final int PANEL_WIDTH = 1000;
    public static final int PANEL_HEIGHT = 800;
    public static final int MARGIN = 20;
    public static final int MARGIN_Y = 80;

    public static final String EXIT = "QUIT";

    private final int BUTTON_WIDTH = 200;
    private final int BUTTON_HEIGHT = 60;

    private JButton btnQUIT;
    private final Game game;

    public ResultsPanel(Game games){super();this.game = games;}

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setColor(Color.WHITE);
        drawScore(graphics2D);
    }

    private void drawScore(Graphics2D graphics2D) {
        Font score = new Font("DejaVu Serif", Font.BOLD,30);
        graphics2D.setFont(score);

        graphics2D.drawString("ID PLAYERS           :" + " " + game.getPlayers1().getIdPlayer(), 50,50);
        graphics2D.drawString("NAME PLAYERS         :" + " " + game.getPlayers1().getName(), 50,90);
        graphics2D.drawString("SCORE                :" + " " + game.getPlayers1().getScore(),50,170);
        graphics2D.drawString("ANSWERS ASSERT       :" + " " + game.getPlayers1().getCantAssert(),50,210);
        graphics2D.drawString("SCORE FAILED         :" + " " + game.getPlayers1().getNoScore(),50,250);
        graphics2D.drawString("ANSWER NOT ASSERT    :" + " " + game.getPlayers1().getCant_NotAssert(),50,290);
        graphics2D.drawString("FINALLY SCORE        :" + " " + game.getPlayers1().getResultate(),50,330);
    }

    @Override
    protected void init() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(BG);

        btnQUIT = new JButton(EXIT);
        btnQUIT.setActionCommand(EXIT);
        btnQUIT.setFont(new Font("Arial", Font.BOLD,22));
        btnQUIT.setForeground(Color.yellow);
        btnQUIT.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnQUIT.setLocation(PANEL_WIDTH-BUTTON_WIDTH-MARGIN, PANEL_HEIGHT - MARGIN - MARGIN_Y );
        btnQUIT.setFocusable(false);
        btnQUIT.setBackground(Color.black);
        add(btnQUIT);
    }

    @Override
    public void setController(Controller controller) {
        btnQUIT.addActionListener(controller);
    }

}
