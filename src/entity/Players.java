package entity;

public class Players {

    private int idPlayer;
    private String name;
    private int score;
    private int noScore;
    private int cantAnswers;
    private int cantAssert;
    private int cant_NotAssert;
    private int resultate;

    public Players(){}

    public int getIdPlayer() {return idPlayer;}

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNoScore() {
        return noScore;
    }

    public void setNoScore(int noScore) {
        this.noScore = noScore;
    }

    public int getCantAnswers() {
        return cantAnswers;
    }

    public void setCantAnswers(int cantAnswers) {
        this.cantAnswers = cantAnswers;
    }

    public int getCantAssert() {
        return cantAssert;
    }

    public void setCantAssert(int cantAssert) {
        this.cantAssert = cantAssert;
    }

    public int getCant_NotAssert() {
        return cant_NotAssert;
    }

    public void setCant_NotAssert(int cant_NotAssert) {
        this.cant_NotAssert = cant_NotAssert;
    }

    public int getResultate() {
        return resultate;
    }

    public void setResultate(int resultate) {
        this.resultate = resultate;
    }
}
