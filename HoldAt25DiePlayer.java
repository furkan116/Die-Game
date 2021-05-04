public class HoldAt25DiePlayer implements DiePlayer{
    /**
     * Hold at 25 or goal (25 de yada kazanınca bırak): Her turda
     * ya 1 gelene kadar
     * yada tur skoru 25 yada büyük olana kadar
     * yada alınan tur skoru ile toplam skorun toplamı 100 yada büyük olana kadar atmaya devam et
     */

    @Override
    public boolean isRolling(int myScore, int turnTotal, int maxScore, int rolls) {

        if (turnTotal >= 25) {
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
