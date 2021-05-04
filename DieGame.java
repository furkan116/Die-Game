public class DieGame {
    /**
     * Bu class oyunun temel kurallarını gerçekleştirmektedir.
     *
     * Fields (data members):
     * 	public static final int GOAL_SCORE = 100; // the goal to be reached,kazanmak icin alinacak skor
     *
     *      private DiePlayer[] players; // Array of Players
     *
     * İhtiyacınız oldukça private data memberlar ekleyebilirsiniz
     *
     *
     * Constructor:
     * public DieGame(DiePlayer[] players): DieGame’i verilen oyuncular dizisi ile birlikte başlatmaktadır. Her oyuncunun başlangıç skoru 0 dır.
     *
     * Diğer metodlar:
     * int playTurn(DiePlayer p, int playerNum): Oyuncunun 1 turdaki oyununu gerçekleştirmektedir. players[] arrayde indexi playerNum olan oyuncu p için oyunu bir tur oynamakta ve oyuncunun aldığı tur skorunu return etmektedir.
     *
     * Eng: simulates one turn of the DiePlayer p at index playerNum in the players[] array). This method returns the turn total for the player p.
     *
     * public int play(): Oyunun 1 turunu tüm oyuncular için oynamaktadır (yukarıdaki metodu tüm oyuncular için çağırmanız gerekiyor): Yani tüm oyuncular birer defa oynamaktadır. Bu metod kazanan oyuncunun dizideki indexini return etmektedir.
     *
     * Eng: Plays an instance of the Die game with the players. This method returns the index in the array of the winning player.
     *
     *
     *
     * Yine şu metodları implement etmeniz faydalı olabilir:
     *
     * int getMaxScore(): Oyuncular arasındaki maximum skoru return etmekte
     * eng: returns the maximum score among all players.
     *
     * void printScores():  Tüm oyuncuların skorlarını yazdırmaktadır. Bunu kullanarak her tur sonunda bunu kullanarak yazdığınız kodun doğruluğunu kontrol edebilirsiniz.
     * eng:prints the scores of all the players. You may use this method to print scores of all players at the end of each players turn to check your implementation.
     */

    public static final int GOAL_SCORE = 100; // the goal to be reached,kazanmak icin alinacak skor
    private DiePlayer[] players; // Array of Players
    private int[] scores = new int[4]; // Array of Players score
    private int maxIndex = 0;

    public DieGame(DiePlayer[] players) {

        this.players = players;
    }


    int playTurn(DiePlayer p, int playerNum) {

        int score = p.run(this.scores[playerNum], getMaxScore());

        this.scores[playerNum] = score;
        return 0;
    }

    public int play() {

        int i = 0;

        while (getMaxScore() < 100) {

            playTurn(players[i], i);

            i++;

            if (i >= players.length) {
                i = 0;
            }
        }

        System.out.println("win: " + maxIndex);
        printScores();

        return 0;
    }

    int getMaxScore() {
        int maxScore = 0;

        for (int i = 0; i < players.length; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
                maxIndex = i;
            }
        }

        return maxScore;
    }

    void printScores() {
        for (int i = 0; i < players.length; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();
    }
}
