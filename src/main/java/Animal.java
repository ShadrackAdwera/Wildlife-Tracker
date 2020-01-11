import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Animal {
    protected String name;
    protected int id;
    protected String age;
    protected String location;
    protected String healthStatus;
    protected int rangerId;
    protected Timestamp lastSeen;
    protected Timer timer;
    protected String type;
    protected boolean located;


    public static final String HEALTH_ILL = "ill";
    public static final String HEALTH_HEALTHY = "healthy";
    public static final String HEALTH_OKAY = "okay";
    public static final String AGE_YOUNG = "young";
    public static final String AGE_NEWBORN = "newborn";
    public static final String AGE_ADULT = "adult";


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return getId() == animal.getId() &&
                getRangerId() == animal.getRangerId() &&
                Objects.equals(getName(), animal.getName()) &&
                Objects.equals(getAge(), animal.getAge()) &&
                Objects.equals(getLocation(), animal.getLocation()) &&
                Objects.equals(getHealthStatus(), animal.getHealthStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId(), getAge(), getLocation(), getHealthStatus(), getRangerId());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public String getHealthStatus() {
        return healthStatus;
    }
    public static String getHealthIll() {
        return HEALTH_ILL;
    }

    public static String getHealthHealthy() {
        return HEALTH_HEALTHY;
    }

    public static String getHealthOkay() {
        return HEALTH_OKAY;
    }

    public static String getAgeYoung() {
        return AGE_YOUNG;
    }

    public static String getAgeNewborn() {
        return AGE_NEWBORN;
    }

    public static String getAgeAdult() {
        return AGE_ADULT;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public int getRangerId() {
        return rangerId;
    }

    public Timestamp getLastSeen() {
        return lastSeen;
    }

    public boolean isLocated() {
        return located;
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name, age, location, healthstatus, rangerid, lastseen, type) VALUES (:name, :age, :location, :healthstatus, :rangerid, now(), :type)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("age", this.age)
                    .addParameter("location", this.location)
                    .addParameter("healthstatus", this.healthStatus)
                    .addParameter("rangerid", this.rangerId)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
        }
    }
        public void delete() {
            try(Connection con = DB.sql2o.open()) {
                String sql = "DELETE FROM animals WHERE id = :id";
                con.createQuery(sql)
                        .addParameter("id", this.id)
                        .executeUpdate();
            }
       }
   }

