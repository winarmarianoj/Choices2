package messages;

import javax.swing.*;

public class MessageError {

    /**
     * Funcion que imprime un Mensaje de error por pantalla
     * @param title Titulo del Mensaje
     * @param message cuerpo del texto del mensaje a emitir
     */
    public MessageError(String title, String message){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
    }
}
