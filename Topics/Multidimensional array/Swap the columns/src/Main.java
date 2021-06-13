import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        int[][] numbers = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                numbers[i][j] = scanner.nextInt();
            }
        }

        int swapColumn1 = scanner.nextInt();
        int swapColumn2 = scanner.nextInt();

        for (int i = 0; i < rows; i++) {
            int temp = numbers[i][swapColumn1];
            numbers[i][swapColumn1] = numbers[i][swapColumn2];
            numbers[i][swapColumn2] = temp;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }
    }
}