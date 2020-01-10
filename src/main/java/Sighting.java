import java.util.Objects;

public class Sighting extends Animal {
    private String location;
    private String rangerName;

    public Sighting(String name, int id, String location, String rangerName){
        super(name, id);
        this.location = location;
        this.rangerName = rangerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sighting)) return false;
        if (!super.equals(o)) return false;
        Sighting sighting = (Sighting) o;
        return Objects.equals(location, sighting.location) &&
                Objects.equals(rangerName, sighting.rangerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), location, rangerName);
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }
}

