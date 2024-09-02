
public class Knight extends GamePiece {

    public Knight(PieceType type, int currentRow, int currentCol, boolean isWhite) {
        super(type, currentRow, currentCol, isWhite);
    }

    @Override
    public boolean isValidMove(int nextRow, int nextCol) {
        /*
         * knight possible moves
         * 
         * |nr - cr|  == 2 && |nc - cc| == 1
         * |7 - 5| = 2
         * |1 - 2| = 1
         * 
         * |nr - cr|  == 1 && |nc - cc| == 2
         */
        int rowDiff = Math.abs(nextRow - currentRow);
        int colDiff = Math.abs(nextCol - currentCol);
        GamePiece piece = Game.board[nextRow][nextCol];

        if(piece != null && piece.isWhite == this.isWhite){
            return false;
        }else{
            if(rowDiff == 2 && colDiff == 1){
                return true;
            }else if(rowDiff == 1 && colDiff == 2){
                return true;
            }
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
        return false;
    }
}
