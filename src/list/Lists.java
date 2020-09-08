package list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lists {

    private List<String> incorrectList;
    private HashMap<Integer,String> correctList;
    private HashMap<Integer,String> answersList;
    private List<String> exceptionList;
    private List<String> imgList;

    public Lists() {}

    /** METHODS AND FUNCTION IMAGES LISTS */

    public List<String> getImgList() {
        if(imgList == null){ imgList = new ArrayList<>();}
        return imgList;
    }

    public void addImgList(String text) {
        if(imgList == null){ imgList = new ArrayList<>();}
        imgList.add(text);
    }

    public int imgListSize(){
        if(imgList == null){ imgList = new ArrayList<>();}
        return imgList.size();
    }
    public String searchImages(int index){
        return imgList.get(index);
    }

    /** METHODS AND FUNCTION EXCEPTION LISTS */

    public List<String> getExceptionList() {
        if(exceptionList == null){ exceptionList = new ArrayList<>();}
        return exceptionList;
    }

    public void addExceptionList(String text) {
        if(exceptionList == null){ exceptionList = new ArrayList<>();}
        exceptionList.add(text);
    }

    /** METHODS AND FUNCTION ANSWER INCORRECT LIST */

    public List<String> getIncorrectList(){
        if (incorrectList == null){ incorrectList = new ArrayList<>();}
        return incorrectList;
    }
    public void addIncorrectList(String texto){
        if (incorrectList == null){ incorrectList = new ArrayList<>();}
        incorrectList.add(texto);
    }
    public int incorrectListSize(){
        if (incorrectList == null){ incorrectList = new ArrayList<>();}
        return incorrectList.size();
    }
    public String searchIncorrect(int index){
        return incorrectList.get(index);
    }

    public boolean removeIncorrects(int index){
        incorrectList.remove(index);
        return true;
    }

    /** METHODS AND FUNCTION HASH ANSWER CORRECT LIST */

    public HashMap<Integer, String> getCorrectList() {
        if (correctList == null){
            correctList = new HashMap<Integer, String>();
        }
        return correctList;
    }

    public void addCorrectList(int num, String text) {
        if (correctList == null){
            correctList = new HashMap<Integer, String>();
        }
        correctList.put(num,text);
    }

    public int correctListSize(){
        if (correctList == null){
            correctList = new HashMap<Integer, String>();
        }
        return correctList.size();
    }

    public String searchCorrectList(int index){
        return correctList.get(index);
    }

    public boolean removeCorrectList(int index){
        correctList.remove(index);
        return true;
    }

    /** METHODS AND FUNCTION HASH ANSWERS LIST */

    public HashMap<Integer, String> getAnwersList() {
        if (answersList == null){
            answersList = new HashMap<Integer, String>();
        }
        return answersList;
    }

    public void addAnswersList(int num, String text) {
        if (answersList == null){
            answersList = new HashMap<Integer, String>();
        }
        answersList.put(num,text);
    }

    public int answersListSize(){
        if (answersList == null){
            answersList = new HashMap<Integer, String>();
        }
        return answersList.size();
    }

    public String searchAnswersList(int index){
        return answersList.get(index);
    }

    public boolean removeAnswersList(int index){
        answersList.remove(index);
        return true;
    }

}
