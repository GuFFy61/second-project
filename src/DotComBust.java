import java.util.*;
public class DotComBust {
    // Объявляем и инициализируем переменные, которые нам понадобятся
   private GameHelper helper = new GameHelper();
   private ArrayList<DotCom> dotComList = new ArrayList<DotCom>();
   private int numOfGuesses = 0;

   private void setUpGame() {
     // Создаем три объекта DotCom, даем им имена и помещаем в ArrayList
     DotCom one = new DotCom();
     one.setName("Pets.com");
     DotCom two = new DotCom();
     two.setName("eToys.com");
     Dotcom three = new DotCom();
     three.setName("Go2.com");
     dotComList.add(one);
     dotComList.add(two);
     dotComList.add(three);

       // Выводим краткие инструкции для пользователя
       System.out.println("Ваша цель - потопить три \"сайта\".");
       System.out.println("Pets.com, eToys.com, Go2.com");
       System.out.println("Попытайтесь потопить их за минимальное количество ходов");

       for (DotComm dotComToSet: dotComList) {                      // Повторяем с каждым объектом DotCom в списке
           ArrayList<String> newLocation = helper.placeDotCom(3);   // Запрашиваем у вспомогательного объекта адрес "сайта"
           dotComToSet.setLocationCells(newLocation);               /* Вызываем сеттер из объекта DotCom, чтобы
                                                                       передать ему местоположение, которое только что
                                                                       получили от вспомогательного объекта */
       }
   }

   private void startPlaying() {
   while(!dotComList.isEmpty()) {                                    // До тех пор, пока список не станет пустым
       String userGuess = helper.getUserInput("Сделайте ход");       // Получем ввод от пользоваттеля
       checkUserGuess(userGuess);
   }
   finishGame();
}

   private void checkUserGuess(String userGuess) {
   numOfGuesses++;
   String result = "мимо";

   for (DotCom dotComToTest: dotComList) {
       result = dotComToTest.checkYourself(userGuess);                // Просим DotCom проверить ход пользователя
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
       DotComBust game = new DotComBust();                          // Создаем игровой объект
       game.setUpGame();                                            // Говорим объекту подготовить игру
       game.startPlaying();                                         /* Говорим объекту начать главный игровой цикл
                                                                       (продолжаем запрашивать пользовательский ввод и
                                                                       проверять полученные данные) */
    }
}