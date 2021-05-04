import java.util.Scanner;

public class UserDiePlayer implements DiePlayer{
    /**
     * Bu class  DiePlayer interface’ni implement etmekte ve oyuncunun consoledan oyunu oynamasına yardımcı olmaktadır.
     * Kullanıcının oyunu oynayabilmesi için kullanıcıya tur toplamını göstermekte ve “Roll or Hold?” şeklinde sorarak kullanıcının kararını almaktadır:
     * Eğer empty string girildiyse (yani hiç bir şey girilmeden entera basıldıysa) devam
     * Diğer durumlarda hold (yani bırak)
     */

    int dieNumber = 0;

    @Override
    public boolean isRolling(int myScore, int turnTotal, int maxScore, int rolls) {

        return dieNumber != 1;
    }

    @Override
    public int run(int myScore, int maxScore) {
        Die r = new Die();
        Scanner scanner = new Scanner(System.in);
        String str = new String();

        int turnTotal = 0;

        while (str.equals("")) {

            System.out.println("Turn Total: " + turnTotal + " Score: " + myScore);
            System.out.print("Roll or Hold: ");
            str = scanner.nextLine();

            dieNumber = r.nextRoll();

            if (!isRolling(myScore, turnTotal, maxScore, 0)) {
                turnTotal = 0;
                break;
            }

            turnTotal += dieNumber;

        }

        System.out.println("Next Player");

        return myScore + turnTotal;
    }

}
