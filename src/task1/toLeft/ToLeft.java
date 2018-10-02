package task1.toLeft;

import java.util.Scanner;

public class ToLeft {

    private static Scanner scanner = new Scanner(System.in);

    private static int numberOfLine;

    protected static int setNumberOfLine() {
        System.out.println("Укажите число строк:");
        try {
            numberOfLine = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Указано не целое число");
        }
        return numberOfLine;
    }

    private static int numberOfColumn;

    protected static int setNumberOfColumn() {
        System.out.println("Укажите число столбцов:");
        try {
            numberOfColumn = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Указано не целое число");
        }
        return numberOfColumn;
    }

    private static int[][] myArray = new int[setNumberOfLine()][setNumberOfColumn()];

    public static void getArray() {//Заполняем массив
        System.out.println("Заполняем массив рандомными числами от 0 до 100:");

        for (int i = 0; i < numberOfLine; i++) {
            for (int j = 0; j < numberOfColumn; j++) {
                myArray[i][j] = (int) (Math.random() * 100);
            }
        }
        printArray();

    }

    public static void arrayToLeft() {
        System.out.println("Сдвигаем столбцы массива влево, последнему столбцу присваиваем 0...");
        for (int i = 0; i < numberOfLine; i++) {
            for (int j = 0; j < numberOfColumn - 1; j++) {
                myArray[i][j] = myArray[i][j + 1];
            }
            myArray[i][numberOfColumn - 1] = 0;
        }
        printArray();
    }


    protected static void printArray() {
        System.out.println("Печатаем масив...");
        for (int i = 0; i < numberOfLine; i++) {
            for (int j = 0; j < numberOfColumn; j++) {
                System.out.print(myArray[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void reversArray() {
        System.out.println("Сортировка массива от большего к меньшему:");
        for (int i = 0; i < numberOfLine; i++) {
            for (int k = numberOfColumn - 1; k > 0; k--) {
                for (int j = 0; j < k; j++) {
                    if (myArray[i][j] < myArray[i][j + 1]) {
                        swap(i, j, j + 1);
                    }
                }
            }
        }
        printArray();
    }

    private static void swap(int i, int one, int two) {
        int tmp = myArray[i][two];
        myArray[i][two] = myArray[i][one];
        myArray[i][one] = tmp;
    }

}
