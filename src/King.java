
public class King extends GamePiece {

    public King(PieceType type, int currentRow, int currentCol, boolean isWhite) {
        super(type, currentRow, currentCol, isWhite);
    }

    @Override
    public boolean isValidMove(int nextRow, int nextCol) {

        int rowDiff = Math.abs(nextRow - currentRow);
        int colDiff = Math.abs(nextCol - currentCol);
        GamePiece piece = Game.board[nextRow][nextCol];
        
        if(piece != null && piece.isWhite == this.isWhite){
            return false;

        // up / down
        }else if (rowDiff == 1 && colDiff == 0) {
            return true;

        // left / right
        } else if (rowDiff == 0 && colDiff == 1) {
            return true;

        // diagonal
        } else if (rowDiff == 1 && colDiff == 1) {
            return true;
        }

        return false;
    }

    @Override
    public boolean checkMove(int nextRow, int nextCol) {
        if (inbounds(nextRow, nextCol)) {
            if (isValidMove(nextRow, nextCol)) {
                return true;
            }
        }
        System.out.println("Cannot move to " + nextRow + ", " + nextCol);
        return false;
    }
}
