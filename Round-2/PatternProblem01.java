import java.util.Scanner;

public class PatternProblem01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows : ");
        int inputNumber = scanner.nextInt();
        printPattern(inputNumber);
        scanner.close();
    }

    private static void printPattern(int inputNumber) {
        int num = inputNumber;
    
        for(int row=1;row<=num;row++,System.out.println()){
            int temp = row;
            for(int col=1;col<=row;col++){
                System.out.print(temp+" ");
                temp = temp + num - col;
            }
        }
    }
}