import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {
        char CODE[] = {'A', 'B', 'D', 'E', 'F', 'G', 'H', 'L', 'N', 'T'};
        
        char CITY[][] = {
            {'B', 'A', 'N', 'T', 'E', 'N', '\0', '\0', '\0', '\0', '\0', '\0'},
            {'J', 'A', 'K', 'A', 'R', 'T', 'A', '\0', '\0', '\0', '\0', '\0'},
            {'B', 'A', 'N', 'D', 'U', 'N', 'G', '\0', '\0', '\0', '\0', '\0'},
            {'C', 'I', 'R', 'E', 'B', 'O', 'N', '\0', '\0', '\0', '\0', '\0'},
            {'B', 'O', 'G', 'O', 'R', '\0', '\0', '\0', '\0', '\0', '\0', '\0'},
            {'P', 'E', 'K', 'A', 'L', 'O', 'N', 'G', 'A', 'N', '\0', '\0'},
            {'S', 'E', 'M', 'A', 'R', 'A', 'N', 'G', '\0', '\0', '\0', '\0'},
            {'S', 'U', 'R', 'A', 'B', 'A', 'Y', 'A', '\0', '\0', '\0', '\0'},
            {'M', 'A', 'L', 'A', 'N', 'G', '\0', '\0', '\0', '\0', '\0', '\0'},
            {'T', 'E', 'G', 'A', 'L', '\0', '\0', '\0', '\0', '\0', '\0', '\0'}
        };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter car plate code: ");
        char inputCode = scanner.next().toUpperCase().charAt(0);
        
        boolean found = false;
        for (int i = 0; i < CODE.length; i++) {
            if (CODE[i] == inputCode) {
                System.out.print("The city for plate code " + inputCode + " is ");
                for (char c : CITY[i]) {
                    if (c == '\0') break;
                    System.out.print(c);
                }
                System.out.println();
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Plate code not found.");
        }
        
        scanner.close();
    }
}
