public class PlayDie {
    /**
     * Bu class main metodunu içermektedir. Bu metod içerisinde farklı şekillerde oyunlar dizayn edebilirsiniz.
     * Mesela bir kaç tane DiePlayer interfaceni implement eden herhangi bir classdan player oluşturursunuz, bir tane UserPlayer oluşturursunuz.
     * Böylelikle user bilgisayara karşı oynamış olur.
     * Burada farklı stratejileri deneyerek hangi stratejinin daha iyi çalıştığını belirleyiniz.
     * Bunun için mesela 4 tane farklı stratejilerde oynayan oyuncu oluşturunuz
     * ve bu oyuncuları bir birlerine karşı oynatıp kazananı not ediniz.
     * Sonra bunu 1000 defa tekrarlayıp hangi stratejinin kaç defa kazandığını belirleyiniz.
     * Sonuç olarak statistics.txt dosyası içerisine
     * Herbir stratejinin kazanma oranlarını
     * Hangi stratejinin neden en iyi strateji olduğunu
     * Yine MyDiePlayer class ile oluşturmuş olduğunuz kendi stratejinizin verilenlerden daha mı iyi yada kötü olduğunu
     * Ve diğer yorumlarınızı giriniz.
     */
    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            DiePlayer hol20 = new HoldAt20DiePlayer();
            DiePlayer hol25 = new HoldAt25DiePlayer();
            DiePlayer raceToGoalDiePlayer = new RaceToGoalDiePlayer();
            DiePlayer myPlayer = new MyDiePlayer();

            DiePlayer[] a = new DiePlayer[4];

            a[0] = hol20;
            a[1] = hol25;
            a[2] = raceToGoalDiePlayer;
            a[3] = myPlayer;

            DieGame bruh = new DieGame(a);

            bruh.play();

        }

        /*
        DiePlayer hol20 = new UserDiePlayer();

        DiePlayer hol20 = new HoldAt20DiePlayer();
        DiePlayer hol25 = new HoldAt25DiePlayer();
        DiePlayer raceToGoalDiePlayer = new RaceToGoalDiePlayer();
        DiePlayer user = new UserDiePlayer();

        DiePlayer[] a = new DiePlayer[4];

        a[0] = hol20;
        a[1] = hol25;
        a[2] = raceToGoalDiePlayer;
        a[3] = user;

        DieGame bruh = new DieGame(a);
        bruh.play();
        */
    }
}
