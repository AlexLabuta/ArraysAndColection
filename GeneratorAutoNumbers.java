import java.util.*;

public class GeneratorAutoNumbers {

    private static ArrayList generatorNumber(ArrayList<String> charNum){
        int[] digitNum = {111, 222, 333, 444, 555, 666, 777, 888, 999};
        ArrayList<String> number = new ArrayList<>();
        int digit;
        for(String firstChar: charNum){
            for(int i = 0; i <= 8; i++ ) {
                digit = digitNum[i];

                for (String twoChar : charNum) {
                    for (String thirdChar : charNum) {
                        for (int region = 1; region <= 199; region++) {
                            number.add(firstChar + digit + twoChar + thirdChar + region);
                        }
                    }
                }
            }
        }
        return  number;

    }

    private static void bruteForce(ArrayList<String> number, String enterNumberPlate){
        long start = System.nanoTime();
        if(number.contains(enterNumberPlate)){
            long duration = System.nanoTime() - start;
            System.out.println("Bruteforce method, find took: " + duration);
        }

    }

    private static void binarySearh(ArrayList<String> number, String enterNumberPlate){
        Collections.sort(number);
        long start = System.nanoTime();
        int i = Collections.binarySearch(number, enterNumberPlate);
        if( i >= 0){
            long duration = System.nanoTime() - start;
            System.out.println("Numberplate binarysearch found method, find took: " + duration);
        }else{
            System.out.println("Numberplate not found binary search");
        }
    }

    private static void hashSearch(ArrayList<String> number, String enterNumberPlate){
        HashSet<String> hash = new HashSet<>();
        hash.addAll(number);
        long start = System.nanoTime();
        if(hash.contains(enterNumberPlate)){
            long duration = System.nanoTime() - start;
            System.out.println("HashSet search found numberplate, find took: " + duration);
        }else {
            System.out.println("Numberplate not found HashSet");
        }
    }

    private static void treeSetSearch(ArrayList<String> number, String enterNumberPlate){
        TreeSet<String> tree = new TreeSet<>();
        tree.addAll(number);
        long start = System.nanoTime();
        if(tree.contains(enterNumberPlate)){
            long duration = System.nanoTime() - start;
            System.out.println("TreeSet search found numberplate, find took: " + duration);
        }else {
            System.out.println("Numberplate not found TreeSet");
        }
    }


    public static void main(String[] args) {
      ArrayList<String> charNum = new ArrayList<>(Arrays.asList("А", "В", "Е", "К", "М", "Н", "O", "Р", "С", "Т", "У", "Х"));

        ArrayList<String> number = new ArrayList<>(generatorNumber(charNum));

        Scanner sc = new Scanner(System.in);
        for (;;) {
            System.out.println("Enter number plate: ");
            String enterNumberPlate = sc.nextLine();
            bruteForce(number, enterNumberPlate);
            binarySearh(number, enterNumberPlate);
            hashSearch(number, enterNumberPlate);
            treeSetSearch(number, enterNumberPlate);
        }



    }
}
