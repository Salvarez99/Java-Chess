
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
    /**
     * Net Income Bi-weekly is compared to HS-Fulltime
     * (payRanges * ((minHrs, maxHrs) * 2) = Biweekly Income)
     * HS PartTime hours adjusted to sum to 37hrs (for commute) when considering TCS
     * min and max hours.
     *
     * TCS-PartTime (20.50 * (6, 15) * 2 = (246, 615))
     * HS-FullTime ((15, 22) * 38 * 2 = (1140, 1672))
     * Net = (+894, +1057)
     * HS-PartTime ((15, 22) * (31, 22) * 2 = (930, 660) || (1364,968))
     * Both PartTime = (1176, 1275) || (1610, 1583)
     * Net = (+36, -397) || (+440, -89)
     *
     *
     */

}
