package jbpm.application;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;

public class Log {
    private final static Logger logger = Logger.getLogger(Log.class.getName());
    private static FileHandler fh = null;
    public static long start;
    public static long stop;


    public static void init(){
        try {
            fh=new FileHandler("loggerExample.log", true);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        Logger l = Logger.getLogger("");
        fh.setFormatter(new SimpleFormatter());
        l.addHandler(fh);
        l.setLevel(Level.CONFIG);
        logger.log(Level.INFO,"process started");
    }

    public static void close(){

        logger.log(Level.INFO,"process finished");
        logger.log(Level.INFO,"time elapsed: " + (stop-start));
        fh.close();
    }

    public static void log(String msg){
        logger.log(Level.INFO, msg);

    }

}
