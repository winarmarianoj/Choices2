package ui.panels;

import controller.Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class WelcomePanel extends Panel{

    private static final int PANEL_WIDTH = 1000;
    private static final int PANEL_HEIGHT = 700;
    private static final int IMAGE_WIDTH = 1000;
    private static final int IMAGE_HEIGHT = 700;
    private static final int MARGIN = 20;
    public static final int MARGIN_Y = 80;

    public static final String ONE_PLAYER = "ONE PLAYER";
    public static final String TWO_PLAYER = "TWO PLAYER";
    public static final String QUIT = "QUIT";

    private final int BUTTON_WIDTH = 260;
    private final int BUTTON_HEIGHT = 50;

    private JButton btnOnePlayer;
    private JButton btnTwoPlayer;
    private JButton btnQuit;

    public WelcomePanel() {}

    @Override
    protected void init() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));

        btnOnePlayer = new JButton(ONE_PLAYER);
        btnOnePlayer.setActionCommand(ONE_PLAYER);
        btnOnePlayer.setFont(new Font("Arial", Font.BOLD,24));
        btnOnePlayer.setForeground(Color.white);
        btnOnePlayer.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnOnePlayer.setLocation( MARGIN, PANEL_HEIGHT - MARGIN - MARGIN_Y );
        btnOnePlayer.setFocusable(false);
        btnOnePlayer.setBackground(Color.blue);
        add(btnOnePlayer);

        btnTwoPlayer = new JButton(TWO_PLAYER);
        btnTwoPlayer.setActionCommand(TWO_PLAYER);
        btnTwoPlayer.setFont(new Font("Arial", Font.BOLD,24));
        btnTwoPlayer.setForeground(Color.white);
        btnTwoPlayer.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnTwoPlayer.setLocation( MARGIN + 250, PANEL_HEIGHT - MARGIN - MARGIN_Y );
        btnTwoPlayer.setFocusable(false);
        btnTwoPlayer.setBackground(Color.blue);
        add(btnTwoPlayer);

        btnQuit = new JButton(QUIT);
        btnQuit.setActionCommand(QUIT);
        btnQuit.setFont(new Font("Arial", Font.BOLD,24));
        btnQuit.setForeground(Color.white);
        btnQuit.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnQuit.setLocation( MARGIN + 500, PANEL_HEIGHT - MARGIN - MARGIN_Y  );
        btnQuit.setFocusable(false);
        btnQuit.setBackground(Color.blue);
        add(btnQuit);

        JLabel jLabel = new JLabel(" ");
        jLabel.setSize(IMAGE_WIDTH,IMAGE_HEIGHT);
        jLabel.setLocation(0,0);
        jLabel.setBorder(new LineBorder(new Color(0,0,0),3,true));
        jLabel.setIcon(new ImageIcon("images/biblia-1.jpg"));
        add(jLabel);

    }

    @Override
    public void setController(Controller controller) {
        btnOnePlayer.addActionListener(controller);
        btnTwoPlayer.addActionListener(controller);
        btnQuit.addActionListener(controller);
    }

}
