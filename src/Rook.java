
public class Rook extends GamePiece {

    public Rook(PieceType type, int currentRow, int currentCol, boolean isWhite) {
        super(type, currentRow, currentCol, isWhite);
    }

    @Override
    public boolean isValidMove(int nextRow, int nextCol) {
        /*
         * Check if we are moving in X or Y direction
         * Along path check for blockages
         * if blocks before next pos
         * false
         * else check if next pos is GamePiece
         * check if isEnemy:
         * move
         * true
         * else
         * false
         */
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
