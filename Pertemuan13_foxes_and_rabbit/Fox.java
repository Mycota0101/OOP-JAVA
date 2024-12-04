import java.util.List;
import java.util.Random;

public class Fox extends Animal {
    private static final int BREEDING_AGE = 10;
    private static final int MAX_AGE = 50;
    private static final int RABBIT_FOOD_VALUE = 9;
    private int foodLevel;

    public Fox(Field field, Location location) {
        super(field, location);
        foodLevel = RABBIT_FOOD_VALUE;
    }

    @Override
    public void act(List<Animal> newFoxes) {
        incrementAge(MAX_AGE);
        foodLevel--;
        if (foodLevel <= 0) {
            setDead();
        }
        if (isAlive()) {
            giveBirth(newFoxes);
            Location newLocation = findFood();
            if (newLocation == null) {
                newLocation = field.freeAdjacentLocation(location);
            }
            if (newLocation != null) {
                field.place(this, newLocation);
                setLocation(newLocation);
            } else {
                setDead();
            }
        }
    }

    private void giveBirth(List<Animal> newFoxes) {
        Random rand = new Random();
        if (canBreed() && rand.nextDouble() <= 0.08) {
            int births = rand.nextInt(2) + 1;
            for (int i = 0; i < births; i++) {
                Location loc = field.freeAdjacentLocation(location);
                if (loc != null) {
                    Fox baby = new Fox(field, loc);
                    newFoxes.add(baby);
                    field.place(baby, loc);
                }
            }
        }
    }

    private Location findFood() {
        Location newLoc = field.freeAdjacentLocation(location);
        if (newLoc != null) {
            field.clear(location);
            return newLoc;
        }
        return null;
    }

    @Override
    protected boolean canBreed() {
        return age >= BREEDING_AGE;
    }
}
