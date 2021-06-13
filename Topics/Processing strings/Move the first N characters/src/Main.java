import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        int number = scanner.nextInt();

        if (number < word.length()) {
            System.out.println(word.substring(number) + word.substring(0, number));
        } else {
            System.out.println(word);
        }
    }
}