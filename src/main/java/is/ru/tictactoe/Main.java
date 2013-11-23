package is.ru.tictactoe;
import static spark.Spark.*;
import spark.*;

public class Main{
	public static void main(String[] args) {
        staticFileLocation("/public");
        final TicTacToe game = new TicTacToe();
        
        setPort(Integer.valueOf(System.getenv("PORT")));

        get(new Route("/hello") {
            @Override
            public Object handle(Request request, Response response) {
                game.resetBoard();
                return "reset";
            }
        });
        
        get(new Route("/add") {
            @Override
            public Object handle(Request request, Response response) {
                String a = request.queryParams("e");
                game.mark(a);
                boolean win = game.checkWin();
                boolean full = game.isFull();
                String json  = "";
                json = "{ \"full\": " + full + ", \"win\": " + win + " }"; 
                //Pair newPair = game.convertToArrayCoords(a);
                //Integer b = Integer.valueOf(request.queryParams("b"));
                //System.out.println(newPair);
                System.out.println(json);
                if(win || full){
                	game.resetBoard();
                	System.out.println("Board was reset");
                }
                return json;
            }
        }); 
    }

}