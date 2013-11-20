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


}
