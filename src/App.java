import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        Scanner keyboard = new Scanner(System.in);
        String input = "";

        while (!input.equals("end")) {

            game.printBoard();
            System.out.print("Choose piece and next move: ");
            input = keyboard.nextLine();

            if (!input.equals("end")) {
                int[] coords = new int[4];
                for (int i = 0; i < coords.length; i++) {
                    coords[i] = Integer.parseInt(input.split(" ")[i]);
                }
                System.out.println();
                game.movePiece(coords[0], coords[1], coords[2], coords[3]);
                
            }

        }

        keyboard.close();

    }
}
