import java.util.Scanner;

public class nimLooping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input NIM: ");
        String nim = scanner.nextLine();

        int n = 0;
        for (int i = nim.length() - 2; i < nim.length(); i++) {
            n = n * 10 + (nim.charAt(i) - '0');
        }

        if (n < 10) {
            n += 10;
        }

        System.out.println("n: " + n);

        for (int i = 1; i <= n; i++) {
            if (i == 6 || i == 10) {
                continue;
            }
            if (i % 2 != 0) {
                System.out.print("* ");
            } else {
                System.out.print(i + " ");
            }
        }

        scanner.close();
    }
}