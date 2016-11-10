package Terminal;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Created by Владимир on 09.11.2016.
 */
//Very simple console terminal interface - just for demonstration and error handling
public class MainFrame {

    private final Terminal terminal;
    private final MyLogger logger;

    public MainFrame(){
        terminal = new TerminalImpl();
        logger = new MyLogger();
    }

    public static void main(String[] args) {

        System.out.println("Hello, user. Enter /help for information");
        Scanner scanner = new Scanner(new InputStreamReader(System.in));

        while(scanner.hasNext() != true) {
            List<Object> command = new ArrayList<>();
            String line = scanner.nextLine();
            command = parseLine(line);
            doInterfaceJob(command);
        }
    }

    private static void doInterfaceJob(List<Object> command) {
    }

    private static List<Object> parseLine(String line) {
        List<Object> list = new ArrayList<>();
        list = Arrays.asList(line.split(" "));
        return list;
    }
}
