public class RaceToGoalDiePlayer implements DiePlayer{
    /**
     * oyuncunun toplam skoru tsi olsun,  maxTS de tüm oyuncular arasındaki maksimum toplam skor olsun.
     * Eğer  tsi >= 71 yada maxTS >= 71, toplam 100’ü bulana (yani oyunu kazanana) kadar atmaya devam et.
     * Diğer durumlarda
     * tur skoru >= 21 +  round((maxTS - tsi) / 8), olana kadar
     * yada tur skoru ile toplam skorun toplamı 100 yada büyük olana kadar atmaya devam et.
     */

    @Override
    public boolean isRolling(int myScore, int turnTotal, int maxScore, int rolls) {

        if (((turnTotal + myScore) >= 71) || (maxScore >= 71)) {
            return true;
        }
        else if (turnTotal >= (21 + Math.round((maxScore - (turnTotal + myScore)) / 8))) {
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
