import java.util.List;
import java.util.Random;

/**
 * A class representing shared characteristics of animals.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.03.18
 */
public abstract class Animal implements IAnimal
{
    // Whether the animal is alive or not.
    private boolean alive;
    protected int age;
    // The animal's field.
    private Field field;
    // The animal's position in the field.
    private Location location;
    
    protected static final Random rand = Randomizer.getRandom();
    
    /**
     * Create a new animal at location in field.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Animal(Field field, Location location)
    {
        alive = true;
        this.field = field;
        setLocation(location);
    }
    
    /**
     * Make this animal act - that is: make it do
     * whatever it wants/needs to do.
     * @param newAnimals A list to receive newly born animals.
     */
    @Override
    abstract public void act(List<Animal> newAnimals);

    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    @Override
    public boolean isAlive()
    {
        return alive;
    }
    
    abstract protected Animal newAnimal(boolean flag, Field field, Location loc);

    /**
     * Check whether or not this fox is to give birth at this step.
     * New births will be made into free adjacent locations.
     * @param newFoxes A list to return newly born foxes.
     */
    public void giveBirth(List<Animal> newBabies)
    {
        // New foxes are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = this.breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Animal young = newAnimal(false, field, loc);
            newBabies.add(young);
        }
    }
    
    // Get the unique constants from the animal classes
    protected abstract double getBreedProb();
    protected abstract boolean canBreed();
    protected abstract int maxLitter();
    protected abstract int maxAge();
    
     /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    public int breed()
    {
        int births = 0;
        if(canBreed() && rand.nextDouble() <= getBreedProb()) {
            births = rand.nextInt(maxLitter()) + 1;
        }
        return births;
    }
    
    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    public void setDead()
    {
        alive = false;
        
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
    
    /**
     * Increase the age.
     * This could result in the animal's death.
     */
    protected void incrementAge() {
        age++;
        
        if(age > maxAge()) {
            setDead();
        }
    }

    /**
     * Return the animal's location.
     * @return The animal's location.
     */
    protected Location getLocation()
    {
        return location;
    }
    
    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if (location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    /**
     * Return the animal's field.
     * @return The animal's field.
     */
    protected Field getField()
    {
        return field;
    }
}
