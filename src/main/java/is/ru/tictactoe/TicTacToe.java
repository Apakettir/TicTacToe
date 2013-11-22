package is.ru.tictactoe;
import static spark.Spark.*;
import spark.*;

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

    private void mark(char logo, String coords){
        Pair thePair = convertToArrayCoords(coords);
        if(isEmpty(thePair.x, thePair.y)){
            this.board[thePair.y][thePair.x] = logo;
        }
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
        if(((this.board[0][0] == 'X') && (this.board[0][1] == 'X') && (this.board[0][2] == 'X'))){
            return true;
        }
        else if(((this.board[0][0] == 'O') && (this.board[0][1] == 'O') && (this.board[0][2] == 'O'))){
            return true;
        }
        else if(((this.board[1][0] == 'X') && (this.board[1][1] == 'X') && (this.board[1][2] == 'X'))){
            return true;
        }
        else if(((this.board[1][0] == 'O') && (this.board[1][1] == 'O') && (this.board[1][2] == 'O'))){
            return true;
        }
        else if(((this.board[2][0] == 'X') && (this.board[2][1] == 'X') && (this.board[2][2] == 'X'))){
            return true;
        }
        else if(((this.board[2][0] == 'O') && (this.board[2][1] == 'O') && (this.board[2][2] == 'O'))){
            return true;
        }
        else if(((this.board[0][0] == 'X') && (this.board[1][0] == 'X') && (this.board[2][0] == 'X'))){
            return true;
        }
        else if(((this.board[0][0] == 'O') && (this.board[1][0] == 'O') && (this.board[2][0] == 'O'))){
            return true;
        }
        else if(((this.board[0][1] == 'X') && (this.board[1][1] == 'X') && (this.board[2][1] == 'X'))){
            return true;
        }
        else if(((this.board[0][1] == 'O') && (this.board[1][1] == 'O') && (this.board[2][1] == 'O'))){
            return true;
        }
        else if(((this.board[0][2] == 'X') && (this.board[1][2] == 'X') && (this.board[2][2] == 'X'))){
            return true;
        }
        else if(((this.board[0][2] == 'O') && (this.board[1][2] == 'O') && (this.board[2][2] == 'O'))){
            return true;
        }
        else if(((this.board[0][0] == 'X') && (this.board[1][1] == 'X') && (this.board[2][2] == 'X'))){
            return true;
        }
        else if(((this.board[0][0] == 'O') && (this.board[1][1] == 'O') && (this.board[2][2] == 'O'))){
            return true;
        }
        else if(((this.board[0][2] == 'X') && (this.board[1][1] == 'X') && (this.board[2][0] == 'X'))){
            return true;
        }
        else if(((this.board[0][2] == 'O') && (this.board[1][1] == 'O') && (this.board[2][0] == 'O'))){
            return true;
        }
        else{
            return false;
        }
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
        staticFileLocation("/public");
        
        setPort(Integer.valueOf(System.getenv("PORT")));

        get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World!";
            }
        });
        
        get(new Route("/add") {
            @Override
            public Object handle(Request request, Response response) {
                Integer a = Integer.valueOf(request.queryParams("e"));
                //Integer b = Integer.valueOf(request.queryParams("b"));
                System.out.println(a);
                return a;
            }
        });

        /*get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World!";
            }
        });     */ 

    }
}


