import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("My Favorite Things List is : ");
  }

  @Test
  public void oneItemIsAdded() {
    goTo("http://localhost:4567/");
    fill("#description").with("travelling to a tropical island");
    submit(".btn");
    assertThat(pageSource()).contains("Your favorite thing has been saved.");
  }

  @Test
  public void twoItemsIsAdded() {
    goTo("http://localhost:4567/");
    fill("#description").with("travelling to a tropical island");
    submit(".btn");
    click("a", withText("Go Back"));
    //fill("#description").with("moving to California");
    //submit(".btn");
    //click("a", withText("Go Back"));
    assertThat(pageSource()).contains("travelling to a tropical island");
    //assertThat(pageSource()).contains("moving to California");
  }

}
