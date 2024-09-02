
public class Rook extends GamePiece {

    public Rook(PieceType type, int currentRow, int currentCol, boolean isWhite) {
        super(type, currentRow, currentCol, isWhite);
    }

    @Override
    public boolean isValidMove(int nextRow, int nextCol) {
        boolean isBlocked = false;

        // up || down movement
        if (currentRow != nextRow && currentCol == nextCol) {
            // Up movement
            if (nextRow < currentRow) {
                for (int i = currentRow - 1; i >= nextRow; i--) {
                    GamePiece scanPiece = Game.board[i][currentCol];

                    if (i != nextRow) {
                        if (scanPiece != null) {
                            isBlocked = true;
                            break;
                        }
                    } else {
                        if (scanPiece != null && (scanPiece.isWhite == this.isWhite)) {
                            isBlocked = true;
                        }
                    }
                }
            } else {
                // Down movement
                for (int i = currentRow + 1; i <= nextRow; i++) {
                    GamePiece scanPiece = Game.board[i][currentCol];

                    if (i != nextRow) {
                        if (scanPiece != null) {
                            isBlocked = true;
                            break;
                        }
                    } else {
                        if (scanPiece != null && (scanPiece.isWhite == this.isWhite)) {
                            isBlocked = true;
                        }
                    }
                }
            }
        } else {
            // left || right movement
            // Left movement
            if (nextCol < currentCol) {
                for (int i = currentCol - 1; i >= nextCol; i--) {
                    GamePiece scanPiece = Game.board[currentRow][i];

                    if (i != nextCol) {
                        if (scanPiece != null) {
                            isBlocked = true;
                            break;
                        }
                    } else {
                        if (scanPiece != null && (scanPiece.isWhite == this.isWhite)) {
                            isBlocked = true;
                        }
                    }
                }
            } else {
                // Right movement
                for (int i = currentCol + 1; i <= nextCol; i++) {
                    GamePiece scanPiece = Game.board[currentRow][i];

                    if (i != nextCol) {
                        if (scanPiece != null) {
                            isBlocked = true;
                            break;
                        }
                    } else {
                        if (scanPiece != null && (scanPiece.isWhite == this.isWhite)) {
                            isBlocked = true;
                        }
                    }
                }
            }
        }
        return !isBlocked;
    }

    @Override
    public boolean checkMove(int nextRow, int nextCol) {
        if (inbounds(nextRow, nextCol)) {
            if (isValidMove(nextRow, nextCol)) {
                return true;
            }
        }
        System.out.println("Cannot move to " + nextRow + " ," + nextCol);
        return false;
    }
}
