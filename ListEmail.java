import java.util.Scanner;
import java.util.TreeSet;

/**
 * Научиться работать со множеством TreeSet. Что нужно сделать
 * 1. Напишите программу, в которой будет храниться перечень адресов электронной почты. Адреса можно добавлять через консоль командой ADD и печатать весь список командой LIST.
 * 2. Программа должна проверять корректность вводимых email’ов и печатать сообщение об ошибке при необходимости. Принцип работы команд
 * LIST — выводит список электронных адресов. ADD — проверяет и, если формат адреса верный, добавляет в множество
 **/
public class ListEmail {
    public static void main(String[] args) {
        TreeSet<String> listEmail = new TreeSet<>();
        listEmail.add("al@ya.ru");
        listEmail.add("dima-voronov@gmail.com");
        listEmail.add("lukoil_pnos@luk.gov");

        Scanner sc = new Scanner(System.in);
        String enter = "";
        while (!enter.equalsIgnoreCase("Exit")) {
            enter = sc.nextLine();
            String[] commands = enter.split("\\s+");
            String command = commands[0].trim();

            //System.out.println("Command: " + command);
            //System.out.println("Email: " + email);

            if (command.equalsIgnoreCase("LIST")) {
                for (String em : listEmail) {
                    System.out.println(em);
                }
            } else {

                if (command.equalsIgnoreCase("ADD")) {
                    String email = commands[1].trim();
                    if (email.matches(".+\\@.+\\..+")) {
                        listEmail.add(email);
                        System.out.println("Add email: " + email);
                    } else {
                        System.out.println("Invalid email.Please enter email again");
                    }
                } else {
                    System.out.println("Invalid command");
                }

            }
        }
    }
}


