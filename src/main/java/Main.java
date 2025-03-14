import model.DebugLogProcessor;
import model.ErrorLogProcessor;
import model.InfoLogProcessor;
import model.LogProcessor;

public class Main {

    public static void main(String[] args) {

        LogProcessor loggerObj= new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        loggerObj.log(LogProcessor.INFO,"This is a INFO Log");
        loggerObj.log(LogProcessor.DEBUG,"This is a DEBUG Log");
        loggerObj.log(LogProcessor.ERROR,"This is a ERROR Log");

    }
}
