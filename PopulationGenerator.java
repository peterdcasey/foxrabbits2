import java.util.Random;
import java.util.List;
import java.awt.Color;

/**
 * PopulationGenerator for foxes and rabbits
 * Used by Simulator
 * Uses concrete Animal classes
 */
public class PopulationGenerator {
    
    // The probability that a fox will be created in any given grid position.
    private static final double FOX_CREATION_PROBABILITY = 0.02;
    // The probability that a rabbit will be created in any given grid position.
    private static final double RABBIT_CREATION_PROBABILITY = 0.08;    

    private Field field;
    private List<Animal> animals;
    
    /**
     * Constructor for objects of class PopulationGenerator
     */
    public PopulationGenerator(Field field, List<Animal> animals) {
        this.field = field;
        this.animals = animals;
    }
    
    /**
     * Method to set the color of the various animals
     *   in a view.
     */
    public void setViewColors(SimulatorView view) {
        view.setColor(Rabbit.class, Color.ORANGE);
        view.setColor(Fox.class, Color.BLUE);
    }
    
    /**
     * Randomly populate the field with foxes and rabbits.
     */
    public void populate() {
        Random rand = Randomizer.getRandom();
        field.clear();
        for(int row = 0; row < field.getDepth(); row++) {
            for(int col = 0; col < field.getWidth(); col++) {
                if(rand.nextDouble() <= FOX_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Fox fox = new Fox(true, field, location);
                    animals.add(fox);
                } 
                else if(rand.nextDouble() <= RABBIT_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    Rabbit rabbit = new Rabbit(true, field, location);
                    animals.add(rabbit);
                }
                // else leave the location empty.
            }
        }
    }
    


}
