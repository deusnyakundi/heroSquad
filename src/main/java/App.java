import ke.co.safaricom.Hero;
import ke.co.safaricom.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.port;
import static spark.Spark.*;
import static spark.Spark.staticFileLocation;

public class App {

    public static void main(String[] args) {

        ProcessBuilder process = new ProcessBuilder();
        int port;

        if (process.environment().get("PORT") != null) port = Integer.parseInt(process.environment().get("PORT"));
        else port = 4567;
        port(port);

        staticFileLocation("/public");

        Hero.setUpNewHero();
        Hero.setUpNewHero1();
        Squad.setUpNewSquad();


        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero-form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> hero = Hero.getAllInstances();
            model.put("hero",hero);
            return new ModelAndView(model, "hero.hbs");
        }, new HandlebarsTemplateEngine());

        get("/new/:id",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            int idOfHero = Integer.parseInt(req.params(":id"));
            Hero foundHero = Hero.findById(idOfHero);
            model.put("hero",foundHero);
            return new ModelAndView(model, "more.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad-form",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "squad-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/squad",(req, res) ->{
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.getInstances();
            model.put("squads",squads);
            ArrayList<Hero> members = Hero.getAllInstances();
            model.put("heroes",members);
            Squad newSquad = Squad.findBySquadId(1);
            model.put("allSquadMembers", newSquad.getSquadMembers());
            return new ModelAndView(model, "squad.hbs");
        }, new HandlebarsTemplateEngine());


    }

}
