
public class Game {
    public static GamePiece[][] board = new GamePiece[8][8];

    public Game() {
        makeBoard();
    }

    private void makeBoard() {
        boolean isWhite = false;

        for (int row = 0; row < Game.board.length; row++) {

            if (row < 2) {
                isWhite = false;
            } else if (row > 5) {
                isWhite = true;
            }

            for (int col = 0; col < Game.board.length; col++) {
                if (row > 1 && row < 6) {
                    Game.board[row][col] = null;

                } else if (row == 1 || row == 6) {
                    Game.board[row][col] = new Pawn(PieceType.PAWN, row, col, isWhite);

                } else if (col == 4) {
                    Game.board[row][col] = new King(PieceType.KING, row, col, isWhite);

                } else if (col == 3) {
                    Game.board[row][col] = new Queen(PieceType.QUEEN, row, col, isWhite);

                } else if (col == 0 || col == 7) {
                    Game.board[row][col] = new Rook(PieceType.ROOK, row, col, isWhite);

                } else if (col == 1 || col == 6) {
                    Game.board[row][col] = new Knight(PieceType.KNIGHT, row, col, isWhite);

                } else if (col == 2 || col == 5) {
                    Game.board[row][col] = new Bishop(PieceType.BISHOP, row, col, isWhite);
                }
            }
        }
    }

    public boolean movePiece(int pieceRow, int pieceCol, int nextRow, int nextCol, PieceType promoteTo) {
        GamePiece piece = Game.board[pieceRow][pieceCol];

        if (piece.checkMove(nextRow, nextCol)) {

            if (piece instanceof Pawn) {
                ((Pawn) Game.board[piece.currentRow][piece.currentCol]).promote(promoteTo);
            } else if (piece instanceof Pawn) {
                ((Pawn) Game.board[piece.currentRow][piece.currentCol]).promote(promoteTo);
            }
            return true;
        }
        return false;
    }

    public boolean movePiece(int pieceRow, int pieceCol, int nextRow, int nextCol) {
        GamePiece piece = Game.board[pieceRow][pieceCol];

        if (piece.checkMove(nextRow, nextCol)) {
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int row = 0; row < Game.board.length; row++) {
            for (int col = 0; col < Game.board.length; col++) {
                System.out.print(Game.board[row][col] + " ");
            }
            System.out.println();
        }
    }
}
