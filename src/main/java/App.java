import java.util.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {

    staticFileLocation("/public");

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("items", request.session().attribute("items"));

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());


    post("/items", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();

        ArrayList<FavoriteThings> items = request.session().attribute("items");
       if (items == null) {
         items = new ArrayList<FavoriteThings>();
         request.session().attribute("items", items);
       }

       String description = request.queryParams("description");
       FavoriteThings newFavoriteThings = new FavoriteThings(description);
       items.add(newFavoriteThings);
        //
        // String description = request.queryParams("description");
        // System.out.println(description);
        // FavoriteThings newFavoriteThing = new FavoriteThings(description);
        // //here we create a new fave thing
        // // FavoriteThings newFavoriteThing = new FavoriteThings(description);
        // System.out.println(description);
        // //now we need to create a list of fave Things
        //
        // items = new ArrayList<FavoriteThings>();
        // //then we add our new fave thing to the list
        // items.add(description);
        // System.out.println(items);
        // //then we add it to the session so we can display it.
        // request.session().attribute("items", items);
        // System.out.println(items);
        // // request.session().attribute("items",newFavoriteThings);


        model.put("template", "templates/success.vtl");
        return new ModelAndView(model, "templates/layout.vtl");
      }, new VelocityTemplateEngine());
  }
}
