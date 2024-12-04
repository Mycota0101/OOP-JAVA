import java.util.List;

public abstract class Animal {
    protected int age;
    protected boolean alive;
    protected Field field;
    protected Location location;

    public Animal(Field field, Location location) {
        this.field = field;
        this.location = location;
        this.age = 0;
        this.alive = true;
    }

    public abstract void act(List<Animal> newAnimals);

    protected abstract boolean canBreed();

    public void incrementAge(int maxAge) {
        age++;
        if (age > maxAge) {
            setDead();
        }
    }

    public void setDead() {
        alive = false;
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location newLocation) {
        location = newLocation;
    }
}
