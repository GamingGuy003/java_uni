import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Gambling {
    public void gamble() {
        List<Integer> numbersSelected = new ArrayList<Integer>();
        Random generator = new Random();

        for (int i = 0; i < 6;) {
            int random = generator.nextInt(90);

            // if number is already present, roll again
            if (numbersSelected.contains(random)) {
                continue;
            }
            System.out.print(random + "\t");
            numbersSelected.add(random);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.print("Exception while waiting: " + e);
            }
            i++;
        }
        System.out.println("---\t" + generator.nextInt(90));
    }
}
