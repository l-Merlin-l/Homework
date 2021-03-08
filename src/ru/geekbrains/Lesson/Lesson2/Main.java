package ru.geekbrains.Lesson.Lesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nReverse array");
        int [] bit = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        bit = reverse(bit);
        arrPrint(bit);

        System.out.println("\nAssign to array value - 3 times index");
        arrIndexMultiplication();

        System.out.println("\nMultiplication value if less than 6");
        int [] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplicationIfLess(arr);

        System.out.println("\nSquare matrix");
        matrixDiagonal(6);

        System.out.println("\nMax and min array value ");
        int [] arrMaxMin = createArrayRandomValue(10, 10);
        extremesArr(arrMaxMin);

        System.out.println("\nEquality of the parties");
        int [] arrBalance = createArrayRandomValue(10, 10);
        System.out.println(checkBalance(arrBalance));
        arrBalance = new int[]{1,5,6,0};
        System.out.println(checkBalance(arrBalance));

        System.out.println("\nDisplacement");
        int [] arrDisplacement = createArrayRandomValue(10, 10);
        displacementArray(arrDisplacement, -14);
    }

    public static int [] reverse (int [] bit){
        for (int i = 0; i < bit.length; i++) {
            switch (bit[i]){
                case 0:
                    bit[i] = 1;
                    break;
                case 1:
                    bit[i] = 0;
                    break;
                default:
                    System.out.println("Неверное значение для замены под индексом " + i);
            }
        }
        return bit;
    }

    public static void arrIndexMultiplication(){
        int [] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 3 * i;
        }
        arrPrint(arr);
    }

    public static void multiplicationIfLess(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        arrPrint(arr);
    }

    public static void matrixDiagonal(int length){
        int [][] matrix = new int[length][length];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][matrix.length-1-i] = 1;
        }
        arrPrint(matrix);
    }

    public static void extremesArr(int [] arr){//Не гуглил, просто работал с Java и знаю
        arrPrint(arr);
        System.out.println("Max value = " + Arrays.stream(arr).max().getAsInt());
        System.out.println("Min value = " + Arrays.stream(arr).min().getAsInt());
    }

    public static boolean checkBalance(int [] arr){
        arrPrint(arr);
        int sumI = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            sumI += arr[i];
            int sumJ = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sumJ += arr[j];
            }
            if (sumI == sumJ){
                return true;
            }
        }
        return false;
    }

    public static void displacementArray (int [] arr, int n){
        arrPrint(arr);
        n = n % arr.length;
        if (n < 0) {
            n += arr.length;
        }
        for (int i = 0; i < n; i++) {
            int value = arr[arr.length - 1];
            for (int j = 0; j < arr.length; j++) {
                int val = value;
                value =  arr[j];
                arr[j] = val;
            }
        }
        arrPrint(arr);
    }

    public static int [] createArrayRandomValue (int length, int range){
        int [] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr [i] =(int) Math.round((2 * Math.random() - 1) * range);
        }
        return arr;
    }

    public static void arrPrint(int [] arr){
        for (int a : arr){
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public static void arrPrint(int [][] arr){
        for (int [] a :arr){
            arrPrint(a);
        }
    }
}
