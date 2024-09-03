
public class Queen extends GamePiece {

    public Queen(PieceType type, int currentRow, int currentCol, boolean isWhite) {
        super(type, currentRow, currentCol, isWhite);
    }

    @Override
    public boolean isValidMove(int nextRow, int nextCol) {
        // Check if the move is either vertical, horizontal, or diagonal
        boolean isDiagonal = Math.abs(nextRow - currentRow) == Math.abs(nextCol - currentCol);
        boolean isVertical = nextCol == currentCol && nextRow != currentRow;
        boolean isHorizontal = nextRow == currentRow && nextCol != currentCol;

        if (!(isDiagonal || isVertical || isHorizontal)) {
            return false; // Invalid move for a queen
        }

        // Determine the direction of movement
        int rowDirection = Integer.signum(nextRow - currentRow);
        int colDirection = Integer.signum(nextCol - currentCol);

        // Check each square along the path
        int tempRow = currentRow + rowDirection;
        int tempCol = currentCol + colDirection;

        while (tempRow != nextRow || tempCol != nextCol) {
            if (Game.board[tempRow][tempCol] != null) {
                return false; // There's a piece blocking the path
            }
            tempRow += rowDirection;
            tempCol += colDirection;
        }

        // Final position check
        GamePiece piece = Game.board[nextRow][nextCol];
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
