import java.util.Random;

public class Die {
    int nextRoll() {

        Random r = new Random();

        return (r.nextInt(6) + 1);
    }
}
