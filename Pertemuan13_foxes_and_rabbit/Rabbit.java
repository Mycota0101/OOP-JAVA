import java.util.List;
import java.util.Random;

public class Rabbit extends Animal {
    private static final int BREEDING_AGE = 5;
    private static final int MAX_AGE = 40;

    public Rabbit(Field field, Location location) {
        super(field, location);
    }

    @Override
    public void act(List<Animal> newRabbits) {
        incrementAge(MAX_AGE);
        if (isAlive()) {
            giveBirth(newRabbits);
            Location newLocation = field.freeAdjacentLocation(location);
            if (newLocation != null) {
                field.place(this, newLocation);
                setLocation(newLocation);
            } else {
                setDead();
            }
        }
    }

    private void giveBirth(List<Animal> newRabbits) {
        Random rand = new Random();
        if (canBreed() && rand.nextDouble() <= 0.12) {
            int births = rand.nextInt(4) + 1;
            for (int i = 0; i < births; i++) {
                Location loc = field.freeAdjacentLocation(location);
                if (loc != null) {
                    Rabbit baby = new Rabbit(field, loc);
                    newRabbits.add(baby);
                    field.place(baby, loc);
                }
            }
        }
    }

    @Override
    protected boolean canBreed() {
        return age >= BREEDING_AGE;
    }
}
