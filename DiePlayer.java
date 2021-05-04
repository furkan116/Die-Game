public interface DiePlayer {

    /**
     * myScore: şu anki oyuncunun skoru (score of the current player)
     * turnTotal: tbu turda alınan skor (he accumulated score in the current turn)
     * maxScore: tüm oyuncular arasında maksimum skor (the maximum score among all players)
     * rolls: oyuncunun bu turda zarı kaç defa attığını belirtiyor (number of times the player has rolled in the current turn)
     */
    boolean isRolling(int myScore, int turnTotal, int maxScore, int rolls);

    int run(int myScore, int maxScore);
}
