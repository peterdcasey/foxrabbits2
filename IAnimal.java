import java.util.List;

/**
 * What does it mean to be an animal.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface IAnimal
{
    void act(List<Animal> newAnimals);
    boolean isAlive();
    void giveBirth(List<Animal> newBabies);
    int breed();
    void setDead();
}
