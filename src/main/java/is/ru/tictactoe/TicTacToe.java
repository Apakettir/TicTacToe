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

    private void mark(char merki, String coords){
        Pair parid = convertToArrayCoords(coords);
        this.board[parid.y][parid.x] = merki;
    }

    public void markX(String coords){
        mark('X', coords);
    }

    public void markO(String coords){
        mark('O', coords);
    }

    private boolean isEmpty(int x, int y){
       return board[y][x] == '-';
    }
    public boolean checkWin(){
        return true;
    }


    private Pair convertToArrayCoords(String coords){
        String[] cc = coords.split("(?!^)");
        int x = Integer.parseInt(cc[1]) - 1;
        int y = charToInt(cc[0]);
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
