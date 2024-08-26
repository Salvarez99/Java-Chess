
/*
 * TODO: Check pawn for attack, then take
 */
public class Pawn extends GamePiece {

    public Pawn(int currentX, int currentY, boolean isWhite) {
        super(currentX, currentY, isWhite);
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

    @Override
    public boolean checkMove(int nextX, int nextY) {
        if (inbounds(nextX, nextY)) {
            if (this.isWhite) {
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
            }
        }
        System.out.println("Cannot move to " + nextX + " ," + nextY);
        return false;
    }
}
