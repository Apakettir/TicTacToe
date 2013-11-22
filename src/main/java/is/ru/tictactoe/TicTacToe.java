package is.ru.tictactoe;
//import static spark.Spark.*;
//import spark.*;

public class TicTacToe {
    private char board[][];
    private boolean player1Turn;

    private static final int n=3;
    private static final int m=3;

    private class Pair{
        private int x;
        private int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return x + " " + y;
        }
    }

    public TicTacToe(){
        board = new char[n][m];
        player1Turn = true;
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

    public void mark(String coords){
        char logo;
        if (player1Turn) {
            logo = 'X';
            player1Turn = false;
        }
        else {
            logo = 'O';
            player1Turn = true;
        }
        Pair thePair = convertToArrayCoords(coords);
        if(isEmpty(thePair.x, thePair.y)){
            board[thePair.y][thePair.x] = logo;
        }
    }

   /* public void markX(String coords){
        mark('X', coords);
    }

    public void markO(String coords){
        mark('O', coords); */

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


    public Pair convertToArrayCoords(String coords){
        String[] cc = coords.split("(?!^)");
        int x = Integer.parseInt(cc[1]) - 1;
        int y = Integer.parseInt(cc[0]) - 1;
        return new Pair(x, y);
    }

    public static void main(String[] args) {
        // staticFileLocation("/public");
        // final TicTacToe game = new TicTacToe();
        
        // setPort(Integer.valueOf(System.getenv("PORT")));

        // get(new Route("/hello") {
        //     @Override
        //     public Object handle(Request request, Response response) {
        //         return "Hello World!";
        //     }
        // });
        
        // get(new Route("/add") {
        //     @Override
        //     public Object handle(Request request, Response response) {
        //         String a = request.queryParams("e");
        //         Pair newPair = game.convertToArrayCoords(a);
        //         //Integer b = Integer.valueOf(request.queryParams("b"));
        //         System.out.println(newPair);
        //         return a;
        //     }
        // });

        /*get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World!";
            }
        });     */ 

    }
}


