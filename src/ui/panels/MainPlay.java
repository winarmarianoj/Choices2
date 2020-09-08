package ui.panels;

import controller.Controller;
import static ui.WindowPlay.BG;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MainPlay extends Panel{

    public static final int PANEL_WIDTH = 1800;
    public static final int PANEL_HEIGHT = 700;
    public static final int MARGIN = 20;
    public static final int MARGIN_Y = 40;

    public static final String A = "A";
    public static final String B = "B";
    public static final String C = "C";
    public static final String FINALIZE = "FINALIZE";
    public static final String EXIT = "QUIT";

    private final int BUTTON_WIDTH_WORDS = 60;
    private final int BUTTON_HEIGHT_WORDS = 60;

    private final int BUTTON_WIDTH = 200;
    private final int BUTTON_HEIGHT = 60;

    private final int JLABEL_WIDTH_EMOTICON = 350;
    private final int JLABEL_HEIGHT_EMOTICON = 350;

    private final int JTEXTFIELD_WORD_HEIGHT = 50;
    private final int JTEXTFIELD_WORD_WIDTH = 1250;

    private final int RESULT_EMOTICON_WIDTH = 1410;
    private final int RESULT_EMOTICON_HEIGHT = 150;

    private final int IMAGE_FONDO_WIDTH = 1800;
    private final int IMAGE_FONDO_HEIGHT = 700;

    private final int JTEXT_NAME_WIDTH = 480;
    private final int JTEXT_LOCA_NAME_WIDTH = 650;

    private final int JLABEL_TITLE_WIDTH = 250;
    private final int JLABEL_TITLE_HEIGHT = 40;

    private final int JLABEL_SCORE_WIDTH = 180;
    private final int JLABEL_SCORE_HEIGHT = 30;

    private final int JTEXTFIELD_SCORE_WIDTH = 180;
    private final int JTEXTFIELD_SCORE_HEIGHT = 100;

    private final int JTEXTFIELD_CLOCK_WIDTH = 220;
    private final int JTEXTFIELD_CLOCK_HEIGHT = 110;

    private JButton btnA;
    private JButton btnB;
    private JButton btnC;
    private JButton btnFINALIZE;
    private JButton btnQUIT;

    private JLabel result;
    private JLabel image;
    private JTextField namePlayer;
    private JTextField idPlayer;
    private JTextField txtScore;
    private JTextField txtClock;
    private JTextField txtAnswer;
    private JTextField opA;
    private JTextField opB;
    private JTextField opC;

    private int buttonCounter;
    private int textCounter;
    private int seconds;

    public MainPlay(){super();}

    /**
     * Funcion que inicia los componentes del Panel
     */
    @Override
    protected void init() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(BG);

        JLabel titleIDPlayer = new JLabel(" NUMBER PLAYER: ");
        titleIDPlayer.setFont(new Font("Arial", Font.BOLD, 22));
        titleIDPlayer.setForeground(Color.red);
        titleIDPlayer.setSize(JLABEL_TITLE_WIDTH, JLABEL_TITLE_HEIGHT);
        titleIDPlayer.setLocation(MARGIN, MARGIN_Y);
        add(titleIDPlayer, BorderLayout.NORTH);

        idPlayer = new JTextField();
        idPlayer.setFont(new Font("Serif", Font.PLAIN, 30));
        idPlayer.setForeground(Color.black);
        idPlayer.setSize(80,JLABEL_TITLE_HEIGHT);
        idPlayer.setLocation(300, MARGIN_Y);
        add(idPlayer);

        JLabel titlePlayer1 = new JLabel("PLAYER NAME : ");
        titlePlayer1.setFont(new Font("Arial", Font.BOLD, 22));
        titlePlayer1.setForeground(Color.red);
        titlePlayer1.setSize(JLABEL_TITLE_WIDTH, JLABEL_TITLE_HEIGHT);
        titlePlayer1.setLocation(400, MARGIN_Y);
        add(titlePlayer1, BorderLayout.NORTH);

        namePlayer = new JTextField();
        namePlayer.setFont(new Font("Serif", Font.PLAIN, 30));
        namePlayer.setForeground(Color.black);
        namePlayer.setSize(JTEXT_NAME_WIDTH, JLABEL_TITLE_HEIGHT);
        namePlayer.setLocation(JTEXT_LOCA_NAME_WIDTH,MARGIN_Y);
        add(namePlayer);

        JLabel titleAnswer = new JLabel(" ANSWERS : ");
        titleAnswer.setFont(new Font("Arial", Font.BOLD, 22));
        titleAnswer.setForeground(Color.red);
        titleAnswer.setSize(JLABEL_TITLE_WIDTH, JLABEL_TITLE_HEIGHT);
        titleAnswer.setLocation(nextTextLocation());
        add(titleAnswer, BorderLayout.NORTH);

        txtAnswer = new JTextField();
        txtAnswer.setFont(new Font("Serif", Font.PLAIN, 20));
        txtAnswer.setForeground(Color.black);
        txtAnswer.setSize(JTEXTFIELD_WORD_WIDTH,JTEXTFIELD_WORD_HEIGHT);
        txtAnswer.setLocation(nextTextLocation());
        add(txtAnswer);

        JLabel titleOpA = new JLabel(" OPTION A : ");
        titleOpA.setFont(new Font("Arial", Font.BOLD, 22));
        titleOpA.setForeground(Color.red);
        titleOpA.setSize(JLABEL_TITLE_WIDTH, JLABEL_TITLE_HEIGHT);
        titleOpA.setLocation(nextTextLocation());
        add(titleOpA, BorderLayout.NORTH);

        opA = new JTextField();
        opA.setFont(new Font("Serif", Font.PLAIN, 20));
        opA.setForeground(Color.black);
        opA.setSize(JTEXTFIELD_WORD_WIDTH,JTEXTFIELD_WORD_HEIGHT);
        opA.setLocation(nextTextLocation());
        add(opA);

        JLabel titleOpB = new JLabel(" OPTION B : ");
        titleOpB.setFont(new Font("Arial", Font.BOLD, 22));
        titleOpB.setForeground(Color.red);
        titleOpB.setSize(JLABEL_TITLE_WIDTH, JLABEL_TITLE_HEIGHT);
        titleOpB.setLocation(nextTextLocation());
        add(titleOpB, BorderLayout.NORTH);

        opB = new JTextField();
        opB.setFont(new Font("Serif", Font.PLAIN, 20));
        opB.setForeground(Color.black);
        opB.setSize(JTEXTFIELD_WORD_WIDTH,JTEXTFIELD_WORD_HEIGHT);
        opB.setLocation(nextTextLocation());
        add(opB);

        JLabel titleOpC = new JLabel(" OPTION C : ");
        titleOpC.setFont(new Font("Arial", Font.BOLD, 22));
        titleOpC.setForeground(Color.red);
        titleOpC.setSize(JLABEL_TITLE_WIDTH, JLABEL_TITLE_HEIGHT);
        titleOpC.setLocation(nextTextLocation());
        add(titleOpC, BorderLayout.NORTH);

        opC = new JTextField();
        opC.setFont(new Font("Serif", Font.PLAIN, 20));
        opC.setForeground(Color.black);
        opC.setSize(JTEXTFIELD_WORD_WIDTH,JTEXTFIELD_WORD_HEIGHT);
        opC.setLocation(nextTextLocation());
        add(opC);

        btnA = new JButton(A);
        btnA.setActionCommand(A);
        btnA.setFont(new Font("Arial", Font.BOLD,23));
        btnA.setForeground(Color.white);
        btnA.setSize(BUTTON_WIDTH_WORDS, BUTTON_HEIGHT_WORDS);
        btnA.setLocation( nextButtonLocation() );
        btnA.setFocusable(false);
        btnA.setBackground(Color.blue);
        add(btnA);

        btnB = new JButton(B);
        btnB.setActionCommand(B);
        btnB.setFont(new Font("Arial", Font.BOLD,23));
        btnB.setForeground(Color.white);
        btnB.setSize(BUTTON_WIDTH_WORDS, BUTTON_HEIGHT_WORDS);
        btnB.setLocation( nextButtonLocation() );
        btnB.setFocusable(false);
        btnB.setBackground(Color.blue);
        add(btnB);

        btnC = new JButton(C);
        btnC.setActionCommand(C);
        btnC.setFont(new Font("Arial", Font.BOLD,23));
        btnC.setForeground(Color.white);
        btnC.setSize(BUTTON_WIDTH_WORDS, BUTTON_HEIGHT_WORDS);
        btnC.setLocation( nextButtonLocation() );
        btnC.setFocusable(false);
        btnC.setBackground(Color.blue);
        add(btnC);

        btnFINALIZE = new JButton(FINALIZE);
        btnFINALIZE.setActionCommand(FINALIZE);
        btnFINALIZE.setFont(new Font("Arial", Font.BOLD,22));
        btnFINALIZE.setForeground(Color.yellow);
        btnFINALIZE.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnFINALIZE.setLocation( 220, 620);
        btnFINALIZE.setFocusable(false);
        btnFINALIZE.setBackground(Color.black);
        add(btnFINALIZE);

        btnQUIT = new JButton(EXIT);
        btnQUIT.setActionCommand(EXIT);
        btnQUIT.setFont(new Font("Arial", Font.BOLD,22));
        btnQUIT.setForeground(Color.yellow);
        btnQUIT.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        btnQUIT.setLocation(420, 620);
        btnQUIT.setFocusable(false);
        btnQUIT.setBackground(Color.black);
        add(btnQUIT);

        JLabel titleTime = new JLabel(" SECONDS : ");
        titleTime.setFont(new Font("Arial", Font.BOLD, 30));
        titleTime.setForeground(Color.blue);
        titleTime.setSize(290, JLABEL_SCORE_HEIGHT);
        titleTime.setLocation(1300,  MARGIN_Y);
        add(titleTime, BorderLayout.NORTH);

        txtClock = new JTextField();
        txtClock.setFont(new Font("Serif", Font.BOLD, 80));
        txtClock.setBackground(Color.green);
        txtClock.setForeground(Color.RED);
        txtClock.setSize(JTEXTFIELD_CLOCK_WIDTH, JTEXTFIELD_CLOCK_HEIGHT);
        txtClock.setLocation( 1530, MARGIN);
        add(txtClock);

        JLabel titleScore = new JLabel("SCORE : ");
        titleScore.setFont(new Font("Arial", Font.BOLD, 35));
        titleScore.setForeground(Color.blue);
        titleScore.setSize(JLABEL_SCORE_WIDTH, JLABEL_SCORE_HEIGHT);
        titleScore.setLocation(1300,  620);
        add(titleScore, BorderLayout.NORTH);

        txtScore = new JTextField();
        txtScore.setFont(new Font("Serif", Font.PLAIN, 60));
        txtScore.setBackground(Color.green);
        txtScore.setForeground(Color.BLUE);
        txtScore.setSize(JTEXTFIELD_SCORE_WIDTH, JTEXTFIELD_SCORE_HEIGHT);
        txtScore.setLocation(1530, 580);
        add(txtScore);

        result = new JLabel(" ");
        result.setSize(JLABEL_WIDTH_EMOTICON, JLABEL_HEIGHT_EMOTICON);
        result.setLocation(RESULT_EMOTICON_WIDTH, RESULT_EMOTICON_HEIGHT);
        result.setBorder(new LineBorder(new Color(0,0,0),3,true));
        add(result);

        image = new JLabel(" ");
        image.setSize(IMAGE_FONDO_WIDTH, IMAGE_FONDO_HEIGHT);
        image.setLocation(0,0);
        image.setBorder(new LineBorder(new Color(0,0,0),3,true));
        add(image);

    }

    /**
     * Funcion que setea y envia los botones al Controller
     * @param controller tipo de dato Controller
     */
    @Override
    public void setController(Controller controller) {
        btnA.addActionListener(controller);
        btnB.addActionListener(controller);
        btnC.addActionListener(controller);
        btnFINALIZE.addActionListener(controller);
        btnQUIT.addActionListener(controller);
    }

    /**
     * Funcion que establece la posicion de los Botones
     * para seleccionar la opcion de su respuesta
     * @return la posicion del mismo
     */
    private Point nextButtonLocation(){
        return new Point( 1310, 270 + ( 65 * buttonCounter++*2));
    }

    /**
     * Funcion que establece la siguiente posicion del texto a dibujar en el Panel
     * @return la posicion del mismo
     */
    private Point nextTextLocation(){
        return new Point(MARGIN, 60 * textCounter++ + 100);
    }

    /**
     * Recibe el nombre del jugador
     * @param namePlayer1 imprime por pantalla el nombre del jugador
     */
    public void setNamePlayer(String namePlayer1) {
        this.namePlayer.setText(namePlayer1);
    }

    /**
     * Recibe el ID del jugador
     * @param id tipo de dato entero
     */
    public void setIdPlayer(int id) { this.idPlayer.setText(String.valueOf(id));}

    /**
     * Recibe y setea la opcion Texto de la Pregunta
     * @param txtAnswer recibe String
     */
    public void setTxtAnswer(String txtAnswer) {
        this.txtAnswer.setText(txtAnswer);
    }

    public JTextField getTxtAnswer() {
        return txtAnswer;
    }

    /**
     * Recibe y setea la opcion A seleccionada
     * @param opA a
     */
    public void setOpA(String opA) {
        this.opA.setText(opA);
    }

    /**
     * Recibe y setea la opcion B seleccionada
     * @param opB b
     */
    public void setOpB(String opB) {
        this.opB.setText(opB);
    }

    /**
     * Recibe y setea la opcion C seleccionada
     * @param opC c
     */
    public void setOpC(String opC) {
        this.opC.setText(opC);
    }

    /**
     * Funcion que devuelve lo impreso en Opcion A
     * @return
     */
    public JTextField getOpA() {
        return opA;
    }

    /**
     * Funcion que devuelve lo impreso en Opcion B
     * @return
     */
    public JTextField getOpB() {
        return opB;
    }

    /**
     * Funcion que devuelve lo impreso en Opcion C
     * @return
     */
    public JTextField getOpC() {
        return opC;
    }

    /**
     * Funcion que recibe la imagen jpg a mostrar por pantalla
     * @param imageIcon recibe jpg del tipo ImageIcon
     */
    public void setResult(ImageIcon imageIcon) {
        this.result.setIcon(imageIcon);
    }

    /**
     * Funcion que recibe la imagen jpg a cambiar en el fondo del panel
     * @param imageIcon recibe jpg tipo ImageIcon
     */
    public void setImage(ImageIcon imageIcon) { this.image.setIcon(imageIcon);}

    /**
     * Funcion que setea Score y lo muestra por pantalla
     * @param txtScore dato a mostrar
     */
    public void setTxtScore(String txtScore) {
        this.txtScore.setText(txtScore);
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    /**
     * Funcion que setea e imprime los segundos
     * @param txtClock
     */
    public void setTxtClock(int txtClock) {
        setSeconds(txtClock);
        this.txtClock.setText(String.valueOf(txtClock));
    }


}
