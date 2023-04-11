import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {

        System.out.println("input help");

        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.trim().split("\\s+", 2);
            try {
                switch (tokens[0].toLowerCase()) {
                    case "add" -> executor.addCustomer(tokens[1]);
                    case "list" -> executor.listCustomers();
                    case "remove" -> executor.removeCustomer(tokens[1]);
                    case "count" -> System.out.println("There are " + executor.getCount() + " customers");
                    case "help" -> {
                        System.out.println(helpText);
                        LOGGER.log(Level.INFO, "Пользователь ввел команду HELP");
                    }
                    default -> {
                        System.out.println(COMMAND_ERROR);
                        LOGGER.log(Level.WARN, "Команда введена не верно! Введите HELP");
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
