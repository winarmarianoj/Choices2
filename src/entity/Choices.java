package entity;

import ui.panels.MainPlay;

import java.io.Serializable;

public class Choices implements Serializable {

    private String answers;
    private String optionA;
    private String optionB;
    private String optionC;
    private MainPlay mainPlay;

    public Choices(){}

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public MainPlay getMainPlay() {
        return mainPlay;
    }

    public void setMainPlay(MainPlay mainPlay) {
        this.mainPlay = mainPlay;
    }
}
