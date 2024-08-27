
public abstract class GamePiece {
    protected boolean isWhite = true;
    protected int currentX = 0;
    protected int currentY = 0;

    public GamePiece(int currentX, int currentY, boolean isWhite) {
        this.currentX = currentX;
        this.currentY = currentY;
        this.isWhite = isWhite;
    }

    public void move(int nextX, int nextY) {
        Game.board[currentX][currentY] = null;
        this.currentX = nextX;
        this.currentY = nextY;
        Game.board[currentX][currentY] = this;
    }

    public boolean isEnemy(GamePiece piece){
        if(piece != null && piece.isWhite != this.isWhite){
            return true;
        }
        return false;
    }

    public boolean inbounds(int nextX, int nextY) {
        if (((nextX > -1) && (nextX < Game.board.length)) && ((nextY > -1) && (nextY < Game.board.length))) {
            return true;
        }
        return false;
    }

    public String toString() {
        String color = isWhite ? "White " : "Black ";
        return color + this.getClass().getSimpleName() + "(" + currentX + ", " + currentY + ")";
    }

    public abstract boolean checkMove(int nextX, int nextY);

}
