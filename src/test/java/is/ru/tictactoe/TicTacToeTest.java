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
    public void testMarkX() {
    	TicTacToe game = new TicTacToe();
    	game.markX("a1");
    	assertEquals("X - - \n- - - \n- - - \n",game.toString());
    }
    @Test
    public void testMarkO() {
    	TicTacToe game = new TicTacToe();
    	game.markO("c2");
    	assertEquals("- - - \n- - - \n- O - \n",game.toString());
    }    
    @Test
    public void testCheckWin(){
        TicTacToe game = new TicTacToe();
        game.markX("a1");
        game.markX("b1");
        game.markX("c1");
        boolean jamm = true;
        assertEquals(jamm, game.checkWin());
    }

    @Test
    public void testCheckWin2(){
        TicTacToe game = new TicTacToe();
        game.markX("a1");
        game.markX("a2");
        game.markX("a3");
        boolean jamm = true;
        assertEquals(jamm, game.checkWin());

    }

    @Test
    public void testCheckWin3(){
        TicTacToe game = new TicTacToe();
        game.markX("a1");
        game.markX("b2");
        game.markX("c3");
        boolean jamm = true;
        assertEquals(jamm, game.checkWin());
    }
    @Test
    public void testCheckWin4(){
        TicTacToe game = new TicTacToe();
        game.markX("a1");
        game.markX("b2");
        game.markX("a3");
        boolean jamm = false;
        assertEquals(jamm, game.checkWin());

    }
    @Test
    public void testCheckWin5(){
        TicTacToe game = new TicTacToe();
        game.markX("a1");
        game.markX("a2");
        game.markX("b3");
        boolean jamm = false;
        assertEquals(jamm, game.checkWin());

    }
}
