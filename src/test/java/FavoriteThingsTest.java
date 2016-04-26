import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class FavoriteThingsTest {

  @Test
public void FavoriteThings_getInputReturnFirstOutput_true() {
  FavoriteThings myFavoriteThings = new FavoriteThings("my first favorite thing");
  assertEquals(true, myFavoriteThings instanceof FavoriteThings);
  }

  @Test
public void getDescription_getInputReturnSecondOutput_expected() {
  FavoriteThings myFavoriteThings = new FavoriteThings("my second favorite thing");
  String expected = "my second favorite thing" ;
  assertEquals(expected, myFavoriteThings.getDescription());
  }

//   @Test
// public void getDescription_getInputReturnBothOutput_ArrayList() {
//   FavoriteThings myFavoriteThings = new FavoriteThings("my second favorite thing");
//   // ArrayList<String> expected = new ArrayList<String>();
//   expected.add("my first favorite thing");
//   expected.add("my second favorite thing");
//   assertEquals(expected, myFavoriteThings.getDescription());
//   }

}
