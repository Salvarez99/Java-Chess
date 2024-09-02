
public abstract class GamePiece {
    protected PieceType type = null;
    protected boolean isWhite = true;
    protected int currentRow = 0;
    protected int currentCol = 0;

    public GamePiece(PieceType type, int currentRow, int currentCol, boolean isWhite) {
        this.type = type;
        this.currentRow = currentRow;
        this.currentCol = currentCol;
        this.isWhite = isWhite;
    }

    public void move(int nextRow, int nextCol) {
        Game.board[currentRow][currentCol] = null;
        this.currentRow = nextRow;
        this.currentCol = nextCol;
        Game.board[currentRow][currentCol] = this;
    }

    public boolean isEnemy(GamePiece piece) {
        if (piece != null && piece.isWhite != this.isWhite) {
            return true;
        }
        return false;
    }

    public boolean inbounds(int nextRow, int nextCol) {
        if (((nextRow > -1) && (nextRow < Game.board.length)) && ((nextCol > -1) && (nextCol < Game.board.length))) {
            return true;
        }
        return false;
    }

    public String toString() {
        String color = isWhite ? "W" : "B";
        String out = "";

        switch (this.type) {
            case PieceType.KING:
                out = "K";
                break;
            case PieceType.QUEEN:
                out = "Q";
                break;
            case PieceType.BISHOP:
                out = "B";
                break;
            case PieceType.KNIGHT:
                out = "N";
                break;
            case PieceType.ROOK:
                out = "R";
                break;
            case PieceType.PAWN:
                out = "P";
                break;
            default:
                break;
        }

        return color + out + currentRow + currentCol + " ";
    }

    public abstract boolean isValidMove(int nextRow, int nextCol);

    public abstract boolean checkMove(int nextRow, int nextCol);

}
