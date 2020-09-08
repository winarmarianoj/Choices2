package validator;

import entity.Choices;
import exceptions.ChoicesException;

public class ChoicesValidator {
    public boolean validChoices(Choices choices) throws ChoicesException {
        boolean res = validAnswer(choices.getAnswers());
        res &= validA(choices.getOptionA());
        res &= validB(choices.getOptionB());
        res &= validC(choices.getOptionC());

        if(!res) throw new ChoicesException();

        return res;
    }
    private boolean validAnswer(String a){ return !a.isEmpty();}
    private boolean validA(String a){ return !a.isEmpty();}
    private boolean validB(String a){ return !a.isEmpty();}
    private boolean validC(String a){ return !a.isEmpty();}
}
