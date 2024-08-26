
public class Game {
    public static GamePiece[][] board = new GamePiece[8][8];
    
    public Game(){
      makeBoard();
    }

    private void makeBoard(){
        boolean isWhite = false;

        for (int i = 0; i < Game.board.length; i++){

            if(i < 2){
                isWhite = false;
            }else if (i > 5) {
                isWhite = true;
            }

            for (int j = 0; j < Game.board.length; j++) {
                if (i > 1 && i < 6) {
                    Game.board[i][j] = null;
                    
                }else if(i == 1 || i == 6){
                    Game.board[i][j] = new Pawn(i, j, isWhite);

                }else if(j == 4){
                    Game.board[i][j] = new King(i, j, isWhite);
    
                }else if(j == 3){
                    Game.board[i][j] = new Queen(i, j, isWhite);
    
                }else if(j == 0 || j == 7){
                    Game.board[i][j] = new Rook(i, j, isWhite);
    
                }else if(j == 1 || j == 6){
                    Game.board[i][j] = new Knight(i, j, isWhite);
    
                }else if(j == 2 || j == 5){
                    Game.board[i][j] = new Bishop(i, j, isWhite);
                }
            }
        }
    }

    public boolean movePiece(int pieceX, int pieceY, int nextX, int nextY){

        if(Game.board[pieceX][pieceY].checkMove(nextX, nextY)){
            return true;
        }
        return false;
    }

    public void printBoard(){
        for (int i = 0; i < Game.board.length; i++) {
            for (int j = 0; j < Game.board.length; j++) {
                System.out.print(Game.board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
