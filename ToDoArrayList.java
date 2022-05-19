import java.util.ArrayList;
import java.util.Scanner;

public class ToDoArrayList {

    private static String comm(String[] commands) { // type command
        return commands[0].trim();
    }

    private static Integer ind(String[] commands) {  // number business
        return Integer.parseInt(commands[1].trim());
    }

    private static String scanBusiness(String[] commands, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < commands.length; i++) {
            sb.append(commands[i]).append(" ");
        }
        return sb.toString().trim();
    }


    public static void main(String[] args) {
        ArrayList<String> toDo = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String enter = "";
        while (!enter.equalsIgnoreCase("Exit")) {


            enter = sc.nextLine();
            String[] commands = enter.split("\\s+");

            String command = "";
            int index = -1;
            String business = null;

            if (enter.matches("^[\\p{Upper}]+")) {
                command = enter.trim();

            } else if (enter.matches("^[\\p{Upper}]+\\s+\\d+")) {
                command = comm(commands);
                index = ind(commands);

            } else if (enter.matches("^[\\p{Upper}]+\\s+\\d+.+")) {
                command = comm(commands);
                index = ind(commands);
                business = scanBusiness(commands, 2);

            } else if (enter.matches("^[\\p{Upper}]+.+")) {
                command = comm(commands);
                business = scanBusiness(commands, 1);

            } else {
                System.out.println("Неверная команда.");
            }

            switch (command) {
                case ("LIST"):
                    System.out.println("List business");
                    for (int i = 0; i < toDo.size(); i++) {
                        System.out.println(i + 1 + " " + toDo.get(i));
                    }
                    break;
                case ("ADD"):
                    if (index > -1 && index < toDo.size()) {
                        toDo.add(index, business);
                        System.out.println("Add business " + business + " with index " + index);
                    } else if (index > toDo.size()) {
                        System.out.println("Invalid index. Index no more " + (toDo.size() - 1));
                    } else {
                        toDo.add(business);
                    }
                    break;
                case ("EDIT"):
                    if (index > -1 && index < toDo.size()) {
                        toDo.set(index, business);
                        System.out.println("Business number " + index + " edit on \"" + business + "\"");
                    } else {
                        System.out.println("Invalid index. Write index no more " + (toDo.size() - 1));
                    }
                    break;
                case ("DELETE"):
                    if (index > -1 && index < toDo.size()) {
                        toDo.remove(index);
                        System.out.println("Business number " + index + " remove");
                    } else {
                        System.out.println("Invalid index. Write index no more " + (toDo.size() - 1));
                    }
                    break;
                case ("EXIT"):
                    System.out.println("Exiting the program");
                    break;
                default:
                    System.out.println("Invalid command. Please enter LIST, ADD, DELETE, EDIT");

            }

        }

    }
}




