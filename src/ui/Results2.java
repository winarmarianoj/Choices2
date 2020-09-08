package ui;

import controller.Controller;
import ui.panels.Panel;

import javax.swing.*;
import java.awt.*;

public class Results2 extends JFrame {

    public static final Color BG = Color.BLACK;
    private Panel panel;

    public Results2(String title, Panel panel) throws HeadlessException {
        init(panel,title);
        setLocationRelativeTo(null);
    }

    /**
     * Funcion de inicio
     * @param panel tipo dato Panel
     * @param title String con el titulo
     */
    private void init(Panel panel, String title) {
        setTitle(title);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.panel = panel;
        add((panel));
        pack();
    }

    /**
     * Devuelve panel de Panel
     * @return tipo de dato Panel
     */
    public Panel getPanel(){return panel;}

    /**
     * Setea el Controlador
     * @param controller tipo de dato Controller
     */
    public void setController(Controller controller){
        panel.setController(controller);
    }
}
