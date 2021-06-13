import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        switch (input) {
            case "triangle":
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();
                double p = (a + b + c) / 2;
                double result = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                System.out.print(result);
                break;
            case "rectangle":
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                result = a * b;
                System.out.print(result);
                break;
            case "circle":
                a = scanner.nextDouble();
                result = 3.14 * (a * a);
                System.out.print(result);
                break;
            default:
                break;
        }
    }
}