import org.junit.rules.ExternalResource;
import spark.Spark;

public class ServerRule extends ExternalResource {

  protected void before() {
    String[] args = {};
    App.main(args); //replace App with the name of the main app class (often App)
   }

  protected void after() {
    Spark.stop();
  }
}
