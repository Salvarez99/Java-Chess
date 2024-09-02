
public class Pawn extends GamePiece {

    public Pawn(PieceType type, int currentRow, int currentCol, boolean isWhite) {
        super(type, currentRow, currentCol, isWhite);
    }

    /**
     * Promote the pawn to the type given
     * 
     * @param type : piece is promoting to type
     */
    public void promote(PieceType type) {

        switch (type) {
            case PieceType.QUEEN:
                Game.board[currentRow][currentCol] = new Queen(PieceType.QUEEN, currentRow, currentCol, isWhite);
                break;
            case PieceType.BISHOP:
                Game.board[currentRow][currentCol] = new Bishop(PieceType.BISHOP, currentRow, currentCol, isWhite);
                break;
            case PieceType.KNIGHT:
                Game.board[currentRow][currentCol] = new Knight(PieceType.KNIGHT, currentRow, currentCol, isWhite);
                break;
            case PieceType.ROOK:
                Game.board[currentRow][currentCol] = new Rook(PieceType.ROOK, currentRow, currentCol, isWhite);
                break;
            default:
                System.out.println("Can't promote to : " + type);
                break;
        }
    }

    // Check if pawn's first move is valid
    public boolean isValidFirstMove(int nextRow, int nextCol) {
        if (Math.abs(nextRow - currentRow) < 3) {
            // move(nextRow, nextCol);
            return true;
        }
        return false;
    }

    // Check for all moves after pawn's first move
    @Override
    public boolean isValidMove(int nextRow, int nextCol) {
        if (Math.abs(nextRow - currentRow) < 2) {
            return true;
        }
        return false;
    }

    public boolean validAttack(int nextRow, int nextCol, boolean isWhite) {
        GamePiece piece = Game.board[nextRow][nextCol];

        if (isWhite) {
            if (nextRow == currentRow + 1 && nextCol == currentCol && piece != null) {
                return false;
            } else {
                if (isEnemy(piece)) {
                    return true;
                }
            }
        } else {
            if (nextRow == currentRow - 1 && nextCol == currentCol) {
                return false;
            } else {
                if (isEnemy(piece)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean checkMove(int nextRow, int nextCol) {
        if (inbounds(nextRow, nextCol)) {

            if (Game.board[nextRow][nextCol] != null && Math.abs(nextRow - currentRow) < 2 && nextCol == currentCol) {
                System.out.println("Cannot move to " + nextRow + " ," + nextCol + " " + Game.board[nextRow][nextCol]
                        + " is blocking movement");
                return false;
            } else if (this.isWhite) {
                if (currentRow > nextRow && nextCol == currentCol) {
                    if (currentRow == 6) {
                        return isValidFirstMove(nextRow, nextCol);
                    } else {
                        return isValidMove(nextRow, nextCol);
                    }
                }
            } else {
                if (currentRow < nextRow && nextCol == currentCol) {
                    if (currentRow == 1) {
                        return isValidFirstMove(nextRow, nextCol);
                    } else {
                        return isValidMove(nextRow, nextCol);
                    }
                }
            }
            if (validAttack(nextRow, nextCol, isWhite)) {
                // move(nextRow, nextCol);
                return true;
            }
        }
        System.out.println("Cannot move to " + nextRow + " ," + nextCol);
        return false;
    }
}