import java.util.Scanner;

public class Zack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Howdy! I'm Zack");
        System.out.println("What can I do for you?");

        while (true) {
            String input = in.nextLine();

            if (input.equals("bye")) {
                System.out.println("Aite ciao!");
                break;
            }

            System.out.println(input);
        }

    }
}
