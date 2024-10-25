package hwdp;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {
    private static LibraryLogger instance = null;
    private List<String> writtenLines;

    private LibraryLogger() {
        writtenLines = new ArrayList<>();
        ExpensiveComputeToy.performExpensiveLogSetup(); 
    }

    public void writeLine(String line) {
        System.out.println("LibraryLogger: " + line);  
        writtenLines.add(line); 
    }

    public String[] getWrittenLines() {
        return writtenLines.toArray(new String[0]);
    }

    public void clearWriteLog() {
        writtenLines.clear(); 
    }
    
    public static LibraryLogger getInstance() {
        if (instance == null) {
            instance = new LibraryLogger();
        }
        return instance;
    }


}
