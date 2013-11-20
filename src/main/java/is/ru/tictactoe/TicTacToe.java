package is.ru.tictactoe;

public class TicTacToe {
    private char board[][];

    public static final int n=3;
    public static final int m=3;

    private class Pair{
        private int x;
        private int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

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

    public void markX(String coords){

    }

    public void markO(String coords){

    }

    private boolean isEmpty(int x, int y){
       return board[y][x] == '-';
    }
    public boolean checkWin(){
        return true;
    }


    private Pair convertToArrayCoords(String coords){
        String[] cc = coorgds.split("(?!^)");
        int x = Integer.parseInt(cc[0]) - 1;
        int y = charToInt(cc[1]);
        return new Pair(x, y);
    }

    //helper function for the convertToArrayCoords method to convert char to the correct integer
    private int charToInt(String c){
        if(c.equals("a")) return 0;
        else if(c.equals("b")) return 1;
        else if (c.equals("c")) return 2;
        else throw new IllegalArgumentException("Illegal character");
    }

    public static void main(String[] args) {

    }
}
