import java.util.Scanner;

public class Sorting65 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so so hang: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Nhap day so:");
        for (int i = 0; i < n; i++) {
            System.out.print("So thu " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
        }

        double average = (double) sum / n;

        System.out.println("Sap xep: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nTong: " + sum);
        System.out.println("Trung binh: " + average);

        scanner.close();
    }
}