package ke.co.safaricom;

import java.util.ArrayList;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    private int id;
    private static ArrayList<Hero> instances = new ArrayList<>();

    public Hero(String name, Integer age, String power, String weakness) {
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        instances.add(this);
        this.id = instances.size();
    }
    public String getName() {return this.name;}

    public int getAge() {return this.age;}
    public String getPower() {return this.power;}
    public String getWeakness() {return this.weakness;}
    public static ArrayList<Hero> getAllInstances() {return instances;}
    public static void clearAllHeroes(){instances.clear();}
    public int getId(){return id;}
    public static Hero findById(int id) {return instances.get(id-1);}

    public static Hero setUpNewHero(){
        return new Hero("Arrow",23,"Master Archer","Human");
    }
    public static Hero setUpNewHero1(){
        return new Hero("Aquaman",30,"Night Vision","Land");
    }
    public static Hero setUpNewHero2(){
        return new Hero("Deathstroke",30,"Tactical Genius","Humanity/Emotional");
    }
}
