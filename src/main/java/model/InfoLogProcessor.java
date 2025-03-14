package model;

public class InfoLogProcessor extends LogProcessor {


    public InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String message){
        if(logLevel==INFO){
            System.out.println("Info Log: "+message);
        }else {
            super.log(logLevel,message);
        }
    }

}
