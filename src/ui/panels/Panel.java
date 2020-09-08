package ui.panels;

import controller.Controller;

import javax.swing.*;

public abstract class Panel extends JPanel {

    public Panel (){
        this.setLayout(null);
        init();
    }

    /**
     * Funcion que inicia los componentes del Panel
     */
    protected abstract void init();

    /**
     * Funcion que setea el objeto Controlador
     * @param controller tipo de dato Controller
     */
    public abstract void setController(Controller controller);

}
