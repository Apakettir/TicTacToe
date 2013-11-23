package is.ru.tictactoe;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.regex.Pattern;
import static org.apache.commons.lang3.StringUtils.join;
import com.thoughtworks.selenium.Selenium;

public class FirefoxTestTitleIT {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private Selenium selenium;

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = System.getenv("STAGING_SERVER");
    selenium = new WebDriverBackedSelenium(driver, baseUrl);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void titleShouldBeHelloWorld() throws Exception {
    driver.get(baseUrl);
    assertEquals("Tic Tac Toe!", driver.getTitle());
  }

  @Test
  public void testPlayer1wins() throws Exception {
    selenium.open("/");
    selenium.click("id=A2");
    selenium.click("id=A1");
    selenium.click("id=B2");
    selenium.click("id=A3");
    selenium.click("id=C2");
    assertEquals("Player 1 wins", selenium.getAlert());
  }

  @Test
  public void testPlayer2wins() throws Exception {
    selenium.open("/");
    selenium.click("id=A1");
    selenium.click("id=B1");
    selenium.click("id=C1");
    selenium.click("id=B2");
    selenium.click("id=C2");
    selenium.click("id=B3");
    assertEquals("Player 2 wins", selenium.getAlert());
  }

  @Test
  public void testItsATie() throws Exception {
    selenium.open("/");
    selenium.click("id=A1");
    selenium.click("id=A2");
    selenium.click("id=B1");
    selenium.click("id=B2");
    selenium.click("id=C2");
    selenium.click("id=C1");
    selenium.click("id=A3");
    selenium.click("id=B3");
    selenium.click("id=C3");
    assertEquals("It's a tie!", selenium.getAlert());
  }

  @Test
  public void testOcupied() throws Exception {
    selenium.open("/");
    selenium.click("id=A1");
    selenium.click("id=A1");
    assertEquals("Occupied", selenium.getAlert());
  }


  @Test
  public void testCheckIfX() throws Exception {
    selenium.open("/");
    selenium.click("id=A1");
    assertEquals("X", selenium.getValue("id=A1"));
  }

  @Test
  public void testCheckIfO() throws Exception {
    selenium.open("/");
    selenium.click("id=A1");
    selenium.click("id=A2");
    assertEquals("O", selenium.getValue("id=A2"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    selenium.stop();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}