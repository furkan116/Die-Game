public class MyDiePlayer implements DiePlayer{
    /**
     * Bu class  DiePlayer interface’ni implement etmekte ve kendi belirlediğiniz stratejiye göre oynamaktadır. İstediğiniz stratejiyi seçebilirsiniz.
     */

    @Override
    public boolean isRolling(int myScore, int turnTotal, int maxScore, int rolls) {

        if (turnTotal >= 35) {
            return false;
        }
        else if ((turnTotal + myScore) >= 100) {
            return false;
        }

        return true;
    }

    @Override
    public int run(int myScore, int maxScore) {

        Die r = new Die();

        int turnTotal = 0;
        int dieNumber;

        while (isRolling(myScore, turnTotal, maxScore, 0)) {
            dieNumber = r.nextRoll();
            turnTotal += dieNumber;

            if (dieNumber == 1) {

                return myScore;
            }
        }

        return myScore + turnTotal;
    }
}
