import controller.Controller;
import controller.WelcomeController;
import ui.Welcome;
import ui.panels.WelcomePanel;

public class Choices2 {

    public static void main(String[] args) throws Exception {
        Welcome welcome = new Welcome("WELCOME THE FINDING GAME ", new WelcomePanel());
        Controller controller = new WelcomeController(welcome);
    }
}
