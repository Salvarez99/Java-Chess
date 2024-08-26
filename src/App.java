public class App {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        game.printBoard();
        System.out.println();

        if (game.movePiece(6, 0, 5, 0)) {
            game.printBoard();
            System.out.println();

        }

        if (game.movePiece(5, 0, 6, 0)) {
            game.printBoard();
        }

    }
}
