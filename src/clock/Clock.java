package clock;

import list.Lists;
import ui.panels.MainPlay;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Clock extends Timer {

    private final static int COUNTER = 1000;  // 1000 milliseconds

    private final TimerTask task;
    private final Timer timer;
    private final MainPlay mainPlay;
    private final Lists lists;

    private int seconds;
    private int cont=20;

    public Clock(MainPlay dos, Lists listita){
        this.mainPlay = dos;
        this.lists = listita;
        timer = new Timer();
        task = new LoopTask();
    }

    public void start(){
        timer.scheduleAtFixedRate(task,COUNTER,COUNTER);
    }
    public void stop(){ timer.cancel(); }

    public class LoopTask extends TimerTask{

        @Override
        public void run() {
            try{
                if(seconds==cont){
                    int pos = (int) Math.floor(Math.random() * lists.imgListSize());
                    mainPlay.setImage(new ImageIcon(lists.searchImages(pos)));
                    cont+=20;
                }
                Thread.sleep(1500);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            seconds++;
            mainPlay.setTxtClock(seconds);
        }
    }

}
