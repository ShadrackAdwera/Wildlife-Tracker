import java.util.Objects;

public class EndangeredAnimal extends Animal {
    private static final String HEALTH_ILL = "ill";
    private static final String HEALTH_HEALTHY = "healthy";
    private static final String HEALTH_OKAY = "okay";
    private static final String AGE_YOUNG = "young";
    private static final String AGE_NEWBORN = "newborn";
    private static final String AGE_ADULT = "adult";
    private String healthStatus;
    private String age;

    public EndangeredAnimal(String name, int id){
        super(name, id);
        this.healthStatus = HEALTH_HEALTHY;
        this.age = AGE_ADULT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EndangeredAnimal)) return false;
        if (!super.equals(o)) return false;
        EndangeredAnimal that = (EndangeredAnimal) o;
        return Objects.equals(getHealthStatus(), that.getHealthStatus()) &&
                Objects.equals(getAge(), that.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getHealthStatus(), getAge());
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

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
