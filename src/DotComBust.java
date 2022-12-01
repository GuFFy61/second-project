import java.util.*;
public class DotComBust {
   private GameHelper helper = new GameHelper();
   private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
   private int numOfGuesses = 0;

   private void setUpGame() {
     DotCom one = new DotCom();
     one.setName("Pets.com");
     DotCom two = new DotCom();
     two.setName("eToys.com");
     Dotcom three = new DotCom();
     three.setName("Go2.com");
     dotComList.add(one);
     dotComList.add(two);
     dotComList.add(three);

       System.out.println("Ваша цель - потопить три \"сайта\".");
       System.out.println("Pets.com, eToys.com, Go2.com");
       System.out.println("Попытайтесь потопить их за минимальное количество ходов");

       for (DotComm dotComToSet: dotComList) {
           ArrayList<String> newLocation = helper.placeDotCom(3);
           dotComToSet.setLocationCells(newLocation);
       }
   }

   private void startPlaying() {
   while(!dotComList.isEmpty()) {
       String userGuess = helper.getUserInput("Сделайте ход");
       checkUserGuess(userGuess);
   }
   finishGame();
}

   private void checkUserGuess(String userGuess) {
   numOfGuesses++;
   String result = "мимо";

   for (DotCom dotComToTest: dotComList) {
       result = dotComToTest.checkYourself(userGuess);
       if (result.equals("Попал")) {
           break;
       }
       if (result.equals("Потопил")) {
           dotComList.remove(dotComToTest);
           break;
       }
   }
}

   private void finishGame() {
       System.out.println("Все \"сайты\" ушли ко дну! Ваши акции теперь ничего не стоят.");
       if (numOfGuesses <= 18) {
           System.out.println("Это заняло у Вас всего "+ numOfGuesses + " попыток.");
           System.out.println("Вы успели выбраться до того, как Ваши вложения утонули.");
       } else {
           System.out.println("Это заняло у Вас довольно много времени. " + numOfGuesses + " попыток.");
           System.out.println("Рыбы водят хороводы вокруг Ваших вложений.");
       }
}

    public static void main(String[] args) {
       DotComBust game = new DotComBust();
       game.setUpGame();
       game.startPlaying();
    }
}