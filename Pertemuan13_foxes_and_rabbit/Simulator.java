import java.util.ArrayList;
import java.util.List;

public class Simulator {
    public static void main(String[] args) {
        Field field = new Field(10, 10);
        List<Animal> animals = new ArrayList<>();

        animals.add(new Rabbit(field, new Location(2, 3)));
        field.place(animals.get(0), new Location(2, 3));
        animals.add(new Fox(field, new Location(5, 5)));
        field.place(animals.get(1), new Location(5, 5));

        for (int step = 0; step < 10; step++) {
            System.out.println("Step " + step + ":");
            field.printField();
            System.out.println();

            List<Animal> newAnimals = new ArrayList<>();
            for (Animal animal : animals) {
                animal.act(newAnimals);
            }
            animals.addAll(newAnimals);
        }
    }
}
