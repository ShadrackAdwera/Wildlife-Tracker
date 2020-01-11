import java.util.Objects;

public class Sighting extends Animal {
    private String rangerName;
    private int id;

    public Sighting(String name, String age, String healthStatus, String location, String rangerName){
        this.name = name;
        this.age = AGE_ADULT;
        this.healthStatus = HEALTH_HEALTHY;
        this.location = location;
        this.rangerName = rangerName;
    }

    public String getRangerName() {
        return rangerName;
    }

    @Override
    public int getId() {
        return id;
    }

}

