package is.ru.tictactoe;

public class TicTacToe {
    private char board[][];

    public static final int n=3;
    public static final int m=3;

    public TicTacToe(){
        board = new char[n][m];
        for(int i=0; i<board.length; i++)
        {
            for (int j=0; j<board.length; j++)
            {
                board[i][j]='-';
            }
        }
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                str += board[i][j] + " ";
            }
            str += "\n";
        }
        return str;
    }

    private void markX(String coords){

    }

    private void markO(String coords){

    }

    private void checkWin(){

    }

    private int convertToArray(String coords){

        return 0;
    }

    public static void main(String[] args) {
    
    }
}
