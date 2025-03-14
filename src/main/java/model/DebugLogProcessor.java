package model;

public class DebugLogProcessor extends LogProcessor {

    public DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void log(int logLevel, String message){
        if(logLevel==DEBUG){
            System.out.println("Debug Log: "+message);
        }else {
            super.log(logLevel,message);
        }
    }
}
