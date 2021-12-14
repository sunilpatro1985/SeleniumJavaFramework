package base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public void printCurrentDateTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
    }
}
