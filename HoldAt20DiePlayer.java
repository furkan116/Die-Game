public class HoldAt20DiePlayer implements DiePlayer{

    /**
     * Hold at 20 or goal (20 de yada kazanınca bırak): Her turda
     * ya 1 gelene kadar
     * yada tur skoru 20 yada büyük olana kadar
     * yada alınan tur skoru ile toplam skorun toplamı 100 yada büyük olana kadar atmaya devam et
     */

    @Override
    public boolean isRolling(int myScore, int turnTotal, int maxScore, int rolls) {

        if (turnTotal >= 20) {
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
