package is.ru.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


/**
 * Unit test for simple App.
 */
public class TicTacToeTest {

	@Test
    public void testPrint() {
    	TicTacToe game = new TicTacToe();
    	assertEquals("- - - \n- - - \n- - - \n",game.toString());

    }
    @Test
    public void testMark() {
    	TicTacToe game = new TicTacToe();
    	game.mark("11");
    	assertEquals("X - - \n- - - \n- - - \n",game.toString());
        game.mark("32");
        assertEquals("X - - \n- - - \n- O - \n",game.toString());
    }    
   @Test
    public void testCheckWin(){
        TicTacToe game = new TicTacToe();
        game.mark("11");
        game.mark("12");
        game.mark("21");
        game.mark("13");
        game.mark("31");
        boolean check = true;
        assertEquals(check, game.checkWin());
    }

   @Test
    public void testCheckWin2(){
        TicTacToe game = new TicTacToe();
        game.mark("11");
        game.mark("21");
        game.mark("12");
        game.mark("31");
        game.mark("13");
        boolean check = true;
        assertEquals(check, game.checkWin());

    }

    @Test
    public void testCheckWin3(){
        TicTacToe game = new TicTacToe();
        game.mark("11");
        game.mark("12");
        game.mark("22");
        game.mark("13");
        game.mark("33");
        boolean check = true;
        assertEquals(check, game.checkWin());
    }
    @Test
    public void testCheckWin4(){
        TicTacToe game = new TicTacToe();
        game.mark("11");
        game.mark("12");
        game.mark("22");
        game.mark("32");
        game.mark("13");
        boolean check = false;
        assertEquals(check, game.checkWin());

    }
    @Test
    public void testCheckWin5(){
        TicTacToe game = new TicTacToe();
        game.mark("11");
        game.mark("13");
        game.mark("12");
        game.mark("22");
        game.mark("23");
        boolean check = false;
        assertEquals(check, game.checkWin());

    }
    @Test
    public void testCheckWin6(){
        TicTacToe game = new TicTacToe();
        game.mark("11");
        game.mark("21");
        game.mark("12");
        game.mark("23");
        game.mark("33");
        boolean check = false;
        assertEquals(check, game.checkWin());	
    }
}
