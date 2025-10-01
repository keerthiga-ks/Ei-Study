
import java.util.logging.*;

public class LoggerSetup {
    public static Logger setupLogger() {
        Logger logger = Logger.getLogger("PatternLogger");
        logger.setUseParentHandlers(true);
        logger.setLevel(Level.INFO);
        return logger;
    }
}
