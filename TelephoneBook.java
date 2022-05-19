import java.security.Key;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class TelephoneBook {

    private  static void printMap(Map<String, String> map) {
        for (String key : map.keySet()) {
            System.out.println(key + " phone number: " + map.get(key));
        }
    }

        private static void numberAdd(Map<String, String> phoneBook,String number) {
            if (phoneBook.containsValue(number)) {
                for(String key: phoneBook.keySet()){
                    if (phoneBook.get(key).equals(number)){
                        number = key;
                        break;
                    }
                }
                System.out.println(number + " " + phoneBook.get(number));
            } else {
                System.out.println("There is no such number in the phone book. Please enter a name to add it to phonebook.");
                Scanner scName = new Scanner(System.in);
                String name = scName.nextLine();
                phoneBook.put(name, number);
                System.out.println("Add:\n " + name + "  " + number);
                //scName.close();
            }

        }

        private static void nameAdd(Map<String, String> phoneBook, String name){
            if(phoneBook.containsKey(name)){
                System.out.println(name + "  " + phoneBook.get(name));
            } else {
                System.out.println("There is no such name in the phone book. Please enter a number to add it to phonebook.");
                Scanner scName = new Scanner(System.in);
                String scNum = scName.nextLine();
                phoneBook.put(name, scNum);
                System.out.println("Add:\n " + name + "  " + scNum);
                //scName.close();
            }
        }

    public static void main(String[] args) {
        TreeMap<String, String> phoneBook = new TreeMap<>();
        Scanner sc = new Scanner(System.in);
        String regexNumber = "[0-9]+";
        String regexName = "[A-Za-zА-Яа-я]+";
        String number ="";
        phoneBook.put("Alexei", "2167845");
        phoneBook.put("Misha", "2784565");
        phoneBook.put("Natalya", "7924683265");
        String enter = "";

        while(true){
            enter = sc.nextLine();

            enter = enter.trim();
            String[] commands = enter.split(" ");

            if(enter.equalsIgnoreCase("LIST")){
                printMap(phoneBook);
                continue;
            } //else {
                if(enter.matches(regexNumber)){
                    number = enter;
                    numberAdd(phoneBook, number);
                } else {
                    if( enter.matches(regexName)){

                        nameAdd(phoneBook, enter);
                    }
                }
            }


        }
    }

