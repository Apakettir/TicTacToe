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
                return "Hello World!";
            }
        });
        
        get(new Route("/add") {
            @Override
            public Object handle(Request request, Response response) {
                String a = request.queryParams("e");
                //Pair newPair = game.convertToArrayCoords(a);
                //Integer b = Integer.valueOf(request.queryParams("b"));
                //System.out.println(newPair);
                return a;
            }
        }); 
    }

}