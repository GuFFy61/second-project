import java.util.*;
public class DotCom {
    // Переменные класса DotCom
    private ArrayList<String> locationCells;                    // Список с ячейками, описывающими местоположение
    private String name;                                        // Имя сайта

    // Сеттер, который обновляет местоположение "сайта" (случайный адрес, предоставленный методом placeDotCom)
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public void setName(String n) {
        name = n;
    }

    /* Метод indexOf() из ArrayList - если ход пользователя
       совпал с одним из элементов ArrayList, то метод
       indexOf() вернет его местоположение. Если нет, то
       indexOf() вернет -1 */
    public String checkYourself(String userInput) {
        String result = "Мимо";
        int index = locationCells.indexOf(userInput);
            if (index >= 0) {
                locationCells.remove(index);

                if (locationCells.isEmpty()) {       // Используем метод isEmpty() для проверки, потоплены ли все адреса
                    result = "Потопил";
                    System.out.println("Ой! Вы потопили " + name + "  : ( ");
                } else {
                    result = "Попал";
                }
            }
            return result;
    }
}
