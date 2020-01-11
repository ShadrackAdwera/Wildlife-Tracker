import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Timer;

public class EndangeredAnimal extends Animal {

    private static final String DATABASE_TYPE = "endangered";

    public EndangeredAnimal(String name, String age, String animalLocation, String healthStatus, int rangerId){
        this.name = name;
        this.age = age;
        this.animalLocation = animalLocation;
        this.healthStatus = healthStatus;
        this.rangerId = rangerId;
        timer = new Timer();
        type = DATABASE_TYPE;
    }
    public static List<EndangeredAnimal> all(){
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals WHERE type = 'endangered';";
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(EndangeredAnimal.class);
        }
    }
    public static EndangeredAnimal find(int id){
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals WHERE id = :id";
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(EndangeredAnimal.class);
        }
    }




}
