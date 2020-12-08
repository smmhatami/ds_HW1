import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        MyLinkedList parenthesisList = new MyLinkedList();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '(':
                case ')':
                    parenthesisList.insert(c);
                    break;
                case 'R':
                    parenthesisList.goRight();
                    break;
                case 'L':
                    parenthesisList.goLeft();
                    break;
                case 'E':
                    parenthesisList.erase();
            }
        }
        System.out.println(parenthesisList.print());
        System.out.println(finMaxValid(parenthesisList.print()));
    }

    public static int finMaxValid(String input) {

        int leftOpen = 0;
        int rightOpen = 0;
        char[] inputArray = input.toCharArray();
        boolean[] badParenthesis = new boolean[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            leftOpen += inputArray[i] == '(' ? 1 : -1;
            if (leftOpen < 0) {
                badParenthesis[i] = true;
                leftOpen = 0;
            }
            rightOpen += inputArray[inputArray.length - 1 - i] == ')' ? 1 : -1;
            if (rightOpen < 0) {
                badParenthesis[inputArray.length - 1 - i] = true;
                rightOpen = 0;
            }
        }
        int maxLength = 0;
        int currentLength = 0;
        for (boolean isBad : badParenthesis) {
            if (isBad) {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 0;
            } else {
                currentLength ++;
            }
        }

        return Math.max(maxLength, currentLength);

    }
}
