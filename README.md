# CLICustomerManagement
The application allows the user to enter commands to add new clients, display a list of clients, delete clients and display the number of clients in the list.

When launching the application, the user will see the message "input help" and can enter a command to manage the list of clients. If the user enters an incorrect command, the application displays an error message and prompts you to enter the HELP command to get a list of available commands.

The application code uses the Log4j library to log various levels of messages to the console. When the user enters the HELP command, the application records information about this event in the INFO level log, and when entering an incorrect command, it records a warning level warning.
