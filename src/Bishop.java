
public class Bishop extends GamePiece {

    public Bishop(PieceType type, int currentRow, int currentCol, boolean isWhite) {
        super(type, currentRow, currentCol, isWhite);
    }

    @Override
    public boolean isValidMove(int nextRow, int nextCol) {
        /*
         * Bishop moves:
         * 1. cr - 1 , cc - 1 (top-left) : nextRC < currRC
         * 2. cr - 1 , cc + 1 (top-right) : nextR < currR and nextC > currR 
         * 3. cr + 1 , cc - 1 (bot-left) : nextR > currR and nextC < currR
         * 4. cr + 1 , cc + 1 (bot-right) : nextRC > currRC
         */
        
        GamePiece piece = Game.board[nextRow][nextCol];
        int rowDirection = (nextRow < currentRow) ? -1 : 1; // up : down
        int colDirection = (nextCol < currentCol) ? -1 : 1; // left : right

        if(Math.abs((nextRow - currentRow)) != Math.abs((nextCol - currentCol))){
            return false;
        }

        int tempRow = currentRow + rowDirection;
        int tempCol = currentCol + colDirection;

        //Checking if path is blocked
        while(tempRow != nextRow && tempCol != nextCol){
            if(Game.board[tempRow][tempCol] != null){
                 return false;
            }
            tempRow += rowDirection;
            tempCol += colDirection;
        }

        if (piece == null || piece.isWhite != this.isWhite) {
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
