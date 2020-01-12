import org.sql2o.Connection;

import java.util.List;
import java.util.Timer;

public class NotEndangeredAnimal extends Animal {
    private static final String DATABASE_TYPE = "not endangered";

    public NotEndangeredAnimal(String name, String age, String animalLocation, String healthStatus, int rangerId){
        this.name = name;
        this.age = age;
        this.animalLocation = animalLocation;
        this.healthStatus = healthStatus;
        this.rangerId = rangerId;
        timer = new Timer();
        type = DATABASE_TYPE;
    }
    public static List<NotEndangeredAnimal> all(){
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals WHERE type = 'not endangered';";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(NotEndangeredAnimal.class);
        }
    }
    public static NotEndangeredAnimal find(int id){
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals WHERE id = :id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(NotEndangeredAnimal.class);
        }
    }

}
