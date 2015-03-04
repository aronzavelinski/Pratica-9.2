
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aron
 */
public class MostraHora{
    Timer timer;
    TaskWait ct;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    
    public MostraHora(){
        timer = new Timer();
    }

    public void start(){
        Date d = new Date();
        int s;
                
        System.out.println("Hora de início: "+sdf.format(d));
        if((s = d.getSeconds()) > 0){
            d = new Date(d.getTime()+(60-s)*1000);
        }
        if(d.getMinutes()%2==0){
            ct = new TaskWait();
        }
        
        timer.schedule(new Taskhora(), d, 1*60*1000);
    }
    
    public void stop(){
        timer.cancel();
        System.out.println("Hora de término: "+sdf.format(new Date()));
    }
    
    public class Taskhora extends TimerTask{
        @Override
        public void run(){
            Date d = new Date();
            System.out.println("Hora atual: "+sdf.format(d));
            if(d.getMinutes()%2!=0){
                ct = new TaskWait();
                timer.schedule(ct, d, 10*1000);
            }else{
                ct.cancel();
            }
        }
    }

    public class TaskWait extends TimerTask{
        @Override
        public void run(){
            System.out.println("Esperando...");
        }
    }
}
