package launcher.avaj.logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// Singleton Logger class
public class Logger {

    private static Logger logger;
    private static String str = "";
    private static final String FILENAME = "simulation.txt";

    private Logger() {
    }

    public static synchronized Logger getLogger() {
        if (logger == null)
            logger = new Logger();
        return logger;
    }

    public void addLog(String log) {
        str += log + '\n';
    }

    public void showLog() {
        System.out.println(str);
    }

    public void writeInFile() {
        File file = new File(FILENAME);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(str);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}