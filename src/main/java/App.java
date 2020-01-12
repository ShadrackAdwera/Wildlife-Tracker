import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    //    private static int getHerokuAssignedPort(){
//        ProcessBuilder processBuilder = new ProcessBuilder();
//        if (processBuilder.environment().get("PORT")!=null){
//            return Integer.parseInt(processBuilder.environment().get("PORT"));
//        } else {
//            return 4567;
//        }
//    }
    public static void main(String[]args){
        staticFileLocation("public");
//        port(getHerokuAssignedPort());
        get("/", (request, response) ->{
            Map<String, Object> model = new HashMap<>();
            List<Sighting> sightings = Sighting.all();
            model.put("sighting", sightings);
            List<EndangeredAnimal> animals = EndangeredAnimal.all();
            model.put("animals", animals);
            List<NotEndangeredAnimal> notEndangeredAnimals = NotEndangeredAnimal.all();
            model.put("not-endangered-animals", notEndangeredAnimals);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine() );
        //display location form
        get("/location/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> sightings = Sighting.all();
            model.put("sightings", sightings);
            List<EndangeredAnimal> animals = EndangeredAnimal.all();
            model.put("animals", animals);
            List<NotEndangeredAnimal> notEndangeredAnimals = NotEndangeredAnimal.all();
            model.put("not-endangered-animals", notEndangeredAnimals);
            return new ModelAndView(model, "location.hbs");
        }, new HandlebarsTemplateEngine());
        //post: process location form
        post("/location", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String rangerName = request.queryParams("name");
            String location = request.queryParams("location");
            Sighting newSight = new Sighting(location, rangerName);
            newSight.save();
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());
        //get: display all animals in a location
        get("/location/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> sightings = Sighting.all();
            model.put("sightings", sightings);
            List<EndangeredAnimal> animals = EndangeredAnimal.all();
            model.put("animals", animals);
            List<NotEndangeredAnimal> notEndangeredAnimals = NotEndangeredAnimal.all();
            model.put("not-endangered-animals", notEndangeredAnimals);
            int idOfFoundSite = Integer.parseInt(request.params("id"));
            Sighting foundSite = Sighting.find(idOfFoundSite);
            model.put("sights", foundSite);
            List<EndangeredAnimal> animalsFound = Sighting.findByLocation(foundSite.getLocation());
            model.put("animals", animalsFound);
            model.put("sightings", Sighting.all());
            return new ModelAndView(model, "location-animal.hbs");
        }, new HandlebarsTemplateEngine());
        //display animal form
        get("/animal/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> sightings = Sighting.all();
            model.put("sightings", sightings);
            List<EndangeredAnimal> animals = EndangeredAnimal.all();
            model.put("animals", animals);
            List<NotEndangeredAnimal> notEndangeredAnimals = NotEndangeredAnimal.all();
            model.put("not-endangered-animals", notEndangeredAnimals);
            return new ModelAndView(model,"animal.hbs");
        }, new HandlebarsTemplateEngine());
        //post: process animals form
        post("/animal", (request, response) -> {
            Map <String, Object> model = new HashMap<>();
            String animalName = request.queryParams("name");
            String animalAge = request.queryParams("age");
            String animalLocation = request.queryParams("animalLocation");
            String animalHealth = request.queryParams("healthStatus");
            EndangeredAnimal animal = new EndangeredAnimal(animalName, animalAge, animalLocation, animalHealth, 1);
            animal.save();
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //display not endangered animal form
        get("/not-endangered-animal/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> sightings = Sighting.all();
            model.put("sightings", sightings);
            List<EndangeredAnimal> animals = EndangeredAnimal.all();
            model.put("animals", animals);
            List<NotEndangeredAnimal> notEndangeredAnimals = NotEndangeredAnimal.all();
            model.put("not-endangered-animals", notEndangeredAnimals);
            return new ModelAndView(model,"not-endangered.hbs");
        }, new HandlebarsTemplateEngine());
        //post: process not endangered animals form
        post("/not-endangered", (request, response) -> {
            Map <String, Object> model = new HashMap<>();
            String animalName = request.queryParams("name");
            String animalAge = request.queryParams("age");
            String animalLocation = request.queryParams("animalLocation");
            String animalHealth = request.queryParams("healthStatus");
            NotEndangeredAnimal animal = new NotEndangeredAnimal(animalName, animalAge, animalLocation, animalHealth, 1);
            animal.save();
            response.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: view an animal
        get("/location/:locationId/animal/:animalId", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> sightings = Sighting.all();
            model.put("sighting", sightings);
            List<EndangeredAnimal> animals = EndangeredAnimal.all();
            model.put("animals", animals);
            List<NotEndangeredAnimal> notEndangeredAnimals = NotEndangeredAnimal.all();
            model.put("not-endangered-animals", notEndangeredAnimals);
            int idAnimalToFind = Integer.parseInt(request.params("animalId"));
            EndangeredAnimal foundAnimal = EndangeredAnimal.find(idAnimalToFind);
            int locationFound = Integer.parseInt(request.params("locationId"));
            Sighting foundSite = Sighting.find(locationFound);
            model.put("animal", foundAnimal);
            model.put("sighting", foundSite);
            model.put("sightings", Sighting.all());
            return new ModelAndView(model, "animal-detail.hbs");
        }, new HandlebarsTemplateEngine());
        //get: view not endangered animal
        get("/location/:locationId/animal/:animalId", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Sighting> sightings = Sighting.all();
            model.put("sighting", sightings);
            List<EndangeredAnimal> animals = EndangeredAnimal.all();
            model.put("animals", animals);
            List<NotEndangeredAnimal> notEndangeredAnimals = NotEndangeredAnimal.all();
            model.put("not-endangered-animals", notEndangeredAnimals );
            int idAnimalToFind = Integer.parseInt(request.params("animalId"));
            NotEndangeredAnimal foundAnimal = NotEndangeredAnimal.find(idAnimalToFind);
            int locationFound = Integer.parseInt(request.params("locationId"));
            Sighting foundSite = Sighting.find(locationFound);
            model.put("not-endangered-animal", foundAnimal);
            model.put("sighting", foundSite);
            model.put("sightings", Sighting.all());
            return new ModelAndView(model, "not-endangered-details.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
