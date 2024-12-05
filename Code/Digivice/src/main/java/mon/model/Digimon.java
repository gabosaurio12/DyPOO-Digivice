package mon.model;

public class Digimon {
    private int id;
    private String name;
    private int evolutionID;
    private String level;
    private String type;
    private String special_attack;
    private String imageRoute;
    private String firstAppearance;

    public Digimon() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEvolutionID() {
        return evolutionID;
    }

    public void setEvolutionID(int evolutionID) {
        this.evolutionID = evolutionID;
    }

    public String getImageRoute() {
        return imageRoute;
    }

    public void setImageRoute(String imageRoute) {
        this.imageRoute = imageRoute;
    }

    public String getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(String firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecial_attack() {
        return special_attack;
    }

    public void setSpecial_attack(String special_attack) {
        this.special_attack = special_attack;
    }
}
