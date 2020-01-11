import org.sql2o.Connection;

import java.util.List;
import java.util.Objects;

public class Sighting {
    private String rangerName;
    private int id;
    private String location;

    public Sighting(String location, String rangerName){
        this.location = location;
        this.rangerName = rangerName;
    }

    public String getRangerName() {
        return rangerName;
    }
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sighting)) return false;
        Sighting sighting = (Sighting) o;
        return getId() == sighting.getId() &&
                Objects.equals(getRangerName(), sighting.getRangerName()) &&
                Objects.equals(location, sighting.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRangerName(), getId(), location);
    }

    public String getLocation() {
        return location;
    }

    public void save(){
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (location, rangername) VALUES (:location, :rangername)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("location", this.location)
                    .addParameter("rangername", this.rangerName)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Sighting> all(){
        try (Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM sightings";
            return con.createQuery(sql)
                    .executeAndFetch(Sighting.class);
        }
    }
    public static Sighting find(int id){
        try (Connection con = DB.sql2o.open()){
            String sql = "SELECT * FROM sightings WHERE id = :id";
            Sighting sighting = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Sighting.class);
            return sighting;
        }
    }
    //One to many relationship
    public List<EndangeredAnimal> getAnimals() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where location=:location";
            return con.createQuery(sql)
                    .addParameter("location", this.location)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }

}

