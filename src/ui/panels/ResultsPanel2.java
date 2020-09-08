package ui.panels;

import controller.Controller;
import games.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

import static ui.Results.BG;

public class ResultsPanel2 extends Panel{

    public static final int PANEL_WIDTH = 1000;
    public static final int PANEL_HEIGHT = 800;
    public static final int MARGIN = 20;
    public static final int MARGIN_Y = 80;

    public static final String QUITS = "QUIT";

    private final int BUTTON_WIDTH = 200;
    private final int BUTTON_HEIGHT = 60;

    private JButton btnQUITS;
    private final Game game;

    public ResultsPanel2(Game game){super();this.game = game;}

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setColor(Color.WHITE);
        drawScore(graphics2D);
    }

    private void drawScore(Graphics2D graphics2D) {
        Font score = new Font("DejaVu Serif", Font.BOLD,25);
        graphics2D.setFont(score);

        graphics2D.drawString("ID PLAYERS           :" + " " + game.getPlayers1().getIdPlayer(), 50,100);
        graphics2D.drawString("NAME PLAYERS         :" + " " + game.getPlayers1().getName(), 50,140);
        graphics2D.drawString("SCORE                :" + " " + game.getPlayers1().getScore(),50,180);
        graphics2D.drawString("ANSWERS ASSERT       :" + " " + game.getPlayers1().getCantAssert(),50,220);
        graphics2D.drawString("SCORE FAILED         :" + " " + game.getPlayers1().getNoScore(),50,260);
        graphics2D.drawString("ANSWER NOT ASSERT    :" + " " + game.getPlayers1().getCant_NotAssert(),50,300);
        graphics2D.drawString("FINALLY SCORE        :" + " " + game.getPlayers1().getResultate(),50,340);

        Line2D.Double line = new Line2D.Double(0, getBounds().getCenterY(), getBounds().getMaxX(), getBounds().getCenterY());
        graphics2D.draw(line);

        graphics2D.drawString("ID PLAYERS           :" + " " + game.getPlayers2().getIdPlayer(), 50,460);
        graphics2D.drawString("NAME PLAYERS         :" + " " + game.getPlayers2().getName(), 50,500);
        graphics2D.drawString("SCORE                :" + " " + game.getPlayers2().getScore(),50,540);
        graphics2D.drawString("ANSWERS ASSERT       :" + " " + game.getPlayers2().getCantAssert(),50,580);
        graphics2D.drawString("SCORE FAILED         :" + " " + game.getPlayers2().getNoScore(),50,620);
        graphics2D.drawString("ANSWER NOT ASSERT    :" + " " + game.getPlayers2().getCant_NotAssert(),50,660);
        graphics2D.drawString("FINALLY SCORE        :" + " " + game.getPlayers2().getResultate(),50,700);

        if (game.getPlayers1().getResultate() > game.getPlayers2().getResultate()) {
            graphics2D.drawString(" PLAYER 1 WIN ", (float) getBounds().getCenterX(), 40);
        } else {
            graphics2D.drawString(" PLAYER 2 WIN ", (float) getBounds().getCenterX(), 40);
        }

    }

    @Override
    protected void init() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(BG);

        btnQUITS = new JButton(QUITS);
        btnQUITS.setActionCommand(QUITS);
        btnQUITS.setFont(new Font("Arial", Font.BOLD,22));
        btnQUITS.setForeground(Color.yellow);
        btnQUITS.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnQUITS.setLocation(PANEL_WIDTH-BUTTON_WIDTH-MARGIN, PANEL_HEIGHT - MARGIN - MARGIN_Y );
        btnQUITS.setFocusable(false);
        btnQUITS.setBackground(Color.black);
        add(btnQUITS);
    }

    @Override
    public void setController(Controller controller) {
        btnQUITS.addActionListener(controller);
    }

}
