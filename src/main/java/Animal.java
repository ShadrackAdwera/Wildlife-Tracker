import java.util.Objects;

public class Animal {
    private String name;
    private int id;

    public Animal(String name, int id){
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return getId() == animal.getId() &&
                Objects.equals(getName(), animal.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getId());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
