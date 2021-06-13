class ArrayOperations {
    public static void printCorners(int[][] twoDimArray) {
        System.out.print(twoDimArray[0][0] + " ");
        System.out.print(twoDimArray[0][twoDimArray[0].length - 1] + "\n");

        System.out.print(twoDimArray[twoDimArray.length - 1][0] + " ");
        System.out.print(twoDimArray[twoDimArray.length - 1][twoDimArray[twoDimArray.length - 1].length - 1]);

    }
}