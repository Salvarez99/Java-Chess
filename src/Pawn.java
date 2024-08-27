
public class Pawn extends GamePiece {

    public Pawn(int currentX, int currentY, boolean isWhite) {
        super(currentX, currentY, isWhite);
    }

    /**
     * Promote the pawn to the type given
     * 
     * @param type : piece is promoting to type
     */
    public void promote(PieceType type) {

        switch (type) {
            case PieceType.QUEEN:
                Game.board[currentX][currentY] = new Queen(currentX, currentY, isWhite);
                break;
            case PieceType.BISHOP:
                Game.board[currentX][currentY] = new Bishop(currentX, currentY, isWhite);
                break;
            case PieceType.KNIGHT:
                Game.board[currentX][currentY] = new Knight(currentX, currentY, isWhite);
                break;
            case PieceType.ROOK:
                Game.board[currentX][currentY] = new Rook(currentX, currentY, isWhite);
                break;
            default:
                System.out.println("Can't promote to : " + type);
                break;
        }
    }

    // Check if pawn's first move is valid
    public boolean isValidFirstMove(int nextX, int nextY) {
        if (Math.abs(nextX - currentX) < 3) {
            move(nextX, nextY);
            return true;
        }
        System.out.println("Cannot move to " + nextX + " ," + nextY);
        return false;
    }

    // Check for all moves after pawn's first move
    public boolean isValidMove(int nextX, int nextY) {
        if (Math.abs(nextX - currentX) < 2) {
            move(nextX, nextY);
            return true;
        }
        System.out.println("Cannot move to " + nextX + " ," + nextY);
        return false;
    }

    public boolean validAttack(int nextX, int nextY, boolean isWhite) {
        GamePiece piece = Game.board[nextX][nextY];

        if (isWhite) {
            if(nextX == currentX + 1 && nextY == currentY && piece != null){
                return false;
            }else{
                if(isEnemy(piece)){
                    return true;
                }
            }
        } else {
            if(nextX == currentX - 1 && nextY == currentY){
                return false;
            }else{
                if(isEnemy(piece)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean checkMove(int nextX, int nextY) {
        if (inbounds(nextX, nextY)) {

             if (Game.board[nextX][nextY] != null && Math.abs(nextX - currentX) < 2 && nextY == currentY) {
                System.out.println("Cannot move to " + nextX + " ," + nextY + " " + Game.board[nextX][nextY]
                        + " is blocking movement");
                return false;
            }else if (this.isWhite) {
                if (currentX > nextX && nextY == currentY) {
                    if (currentX == 6) {
                        return isValidFirstMove(nextX, nextY);
                    } else {
                        return isValidMove(nextX, nextY);
                    }
                }
            } else {
                if (currentX < nextX && nextY == currentY) {
                    if (currentX == 1) {
                        return isValidFirstMove(nextX, nextY);
                    } else {
                        return isValidMove(nextX, nextY);
                    }
                }
            } if (validAttack(nextX, nextY, isWhite)) {
                move(nextX, nextY);
                return true;
            } 
        }
        System.out.println("Cannot move to " + nextX + " ," + nextY);
        return false;
    }
}