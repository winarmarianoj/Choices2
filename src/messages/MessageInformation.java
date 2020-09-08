package messages;

import javax.swing.*;

public class MessageInformation {

    /**
     * Funcion que imprime un Mensaje por pantalla del tipo Informacion
     * @param title Titulo del Mensaje
     * @param message cuerpo del texto del mensaje a emitir
     */
    public MessageInformation(String title, String message){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
