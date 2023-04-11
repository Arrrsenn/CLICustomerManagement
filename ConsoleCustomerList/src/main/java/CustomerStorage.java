import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {

    private static final Logger LOGGER = LogManager.getLogger(CustomerStorage.class);
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws Exception {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components.length != 4) {
            LOGGER.log(Level.WARN, "Неверный формат ввода данных! Коректный формат: " + Main.ADD_COMMAND);
            throw new Exception("Неверный формат ввода! Корректный формат: " + Main.ADD_COMMAND);
        }
        if (!components[0].toLowerCase().matches("[а-я]+") &&
                !components[1].toLowerCase().matches("[а-я]+")) {
            LOGGER.log(Level.WARN, "Неверный формат имяни! Корректный формат: Иван Иванов");
            throw new MyErrors.NoCorrectedNameExcepton();
        }
        if (!components[2].toLowerCase().matches(".+@.+\\..+")) {
            LOGGER.log(Level.WARN, "Неверный формат e-mail! Корректный формат: vasily.petrov@gmail.com");
            throw new MyErrors.NoCorrectedEmailExcepton();
        }
        if (!components[3].matches("(8|\\+7)[0-9]{10}")) {
            LOGGER.log(Level.WARN, "Неверный формат номера! Корректный формат: +7 или 8 9651548721");
            throw new MyErrors.NoCorrectedPhoneExcepton();
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
        System.out.println("Customer " + name + " is added to the list");
        LOGGER.log(Level.INFO, "Покупатель " + name + " добавлен в список");
    }

    public void listCustomers() throws Exception {
        if (storage.size() == 0) {
            throw new Exception("Список пуст");
        }
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        if (storage.containsKey(name)) {
            System.out.println("Customer " + name + " is removed from the list");
            storage.remove(name);
            LOGGER.log(Level.INFO, "Покупатель " + name + " удален из списка");
        } else {
            System.out.println("Customer " + name + " not found to list");
            LOGGER.log(Level.WARN, "Покупатель не найден");
        }
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}