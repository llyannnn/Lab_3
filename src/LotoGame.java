//import java.util.*;
//
//class LotoCard {
//    private int[] numbers; // Массив чисел на карточке игрока
//    private boolean[] closed; // Булевый массив для отслеживания закрытых чисел
//
//    // Конструктор, принимающий массив чисел для карточки
//    public LotoCard(int[] numbers) {
//        this.numbers = numbers; // Сохраняем переданный массив чисел
//        this.closed = new boolean[numbers.length]; // Инициализируем массив закрытых чисел (все открыты)
//    }
//
//    // Метод для отображения текущего состояния карточки игрока
//    public void displayCard() {
//        for (int i = 0; i < numbers.length; i++) {
//            if (closed[i]) {
//                System.out.print("X "); // Если число закрыто, отображаем X
//            } else {
//                System.out.print(numbers[i] + " "); // Если число открыто, отображаем его значение
//            }
//        }
//        System.out.println(); // Переход на новую строку после вывода карточки
//    }
//
//    // Метод возвращает количество закрытых и открытых чисел на карточке
//    public int[] countClosedAndOpen() {
//        int closedCount = 0; // Счетчик закрытых чисел
//        for (boolean isClosed : closed) {
//            if (isClosed) closedCount++; // Увеличиваем счетчик, если число закрыто
//        }
//        return new int[]{closedCount, numbers.length - closedCount}; // Возвращаем массив: [количество закрытых, количество открытых]
//    }
//
//    // Метод для закрытия указанного числа на карточке
//    public boolean closeNumber(int number) {
//        for (int i = 0; i < numbers.length; i++) {
//            if (numbers[i] == number && !closed[i]) { // Если найдено совпадающее число, которое еще не закрыто
//                closed[i] = true; // Закрываем число
//                return true; // Возвращаем true, так как число успешно закрыто
//            }
//        }
//        return false; // Если число не найдено или уже закрыто, возвращаем false
//    }
//
//    // Метод проверяет, закрыты ли все числа на карточке
//    public boolean isFullyClosed() {
//        for (boolean isClosed : closed) {
//            if (!isClosed) return false; // Если хотя бы одно число открыто, возвращаем false
//        }
//        return true; // Если все числа закрыты, возвращаем true
//    }
//
//    // Метод для закрытия чисел из массива, возвращает число, которое закрыло карточку полностью
//    public int closeAllFromArray(int[] array) {
//        for (int number : array) {
//            closeNumber(number); // Пытаемся закрыть текущее число
//            if (isFullyClosed()) { // Проверяем, закрыта ли вся карточка
//                return number; // Возвращаем число, которое закрыло карточку
//            }
//        }
//        return -1; // Если карточка не закрыта полностью, возвращаем -1
//    }
//}
//
//public class LotoGame {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in); // Сканер для считывания пользовательского ввода
//
//        System.out.println("Создание карточек игроков...");
//        // Создаем карточки для двух игроков с заранее заданными числами
//        LotoCard player1 = new LotoCard(new int[]{1, 4, 19, 30, 55});
//        LotoCard player2 = new LotoCard(new int[]{2, 10, 19, 40, 60});
//
//        System.out.println("Карточка игрока 1:");
//        player1.displayCard(); // Отображаем карточку игрока 1
//        System.out.println("Карточка игрока 2:");
//        player2.displayCard(); // Отображаем карточку игрока 2
//
//        System.out.println("Введите выпавшие числа (через пробел):");
//        String[] input = scanner.nextLine().split(" "); // Считываем выпавшие числа, разделенные пробелами
//        int[] drawnNumbers = Arrays.stream(input).mapToInt(Integer::parseInt).toArray(); // Преобразуем строки в массив чисел
//
//        // Закрываем числа на карточках игроков
//        int winnerNumber1 = player1.closeAllFromArray(drawnNumbers);
//        int winnerNumber2 = player2.closeAllFromArray(drawnNumbers);
//
//        System.out.println("После обновления карточек:");
//        System.out.println("Карточка игрока 1:");
//        player1.displayCard(); // Отображаем обновленную карточку игрока 1
//        System.out.println("Карточка игрока 2:");
//        player2.displayCard(); // Отображаем обновленную карточку игрока 2
//
//        // Проверяем, закрыта ли карточка каждого игрока
//        boolean player1Wins = player1.isFullyClosed();
//        boolean player2Wins = player2.isFullyClosed();
//
//        if (player1Wins || player2Wins) {
//            System.out.println("Победители:");
//            if (player1Wins) {
//                System.out.println("Игрок 1 закрыл карточку числом " + winnerNumber1); // Выводим победу игрока 1
//            }
//            if (player2Wins) {
//                System.out.println("Игрок 2 закрыл карточку числом " + winnerNumber2); // Выводим победу игрока 2
//            }
//        } else {
//            System.out.println("Ни один из игроков не закрыл карточку полностью."); // Сообщаем, если победителей нет
//        }
//
//        // Выводим количество игроков, закрывших карточку
//        System.out.println("Количество игроков, закрывших карточку: " + ((player1Wins ? 1 : 0) + (player2Wins ? 1 : 0)));
//    }
//}





import java.util.*;

class LotoCard {
    private int[] numbers; // Массив чисел на карточке игрока
    private boolean[] closed; // Булевый массив для отслеживания закрытых чисел

    // Конструктор, принимающий массив чисел для карточки
    public LotoCard(int[] numbers) {
        this.numbers = numbers; // Сохраняем переданный массив чисел
        this.closed = new boolean[numbers.length]; // Инициализируем массив закрытых чисел (все открыты)
    }

    // Метод для отображения текущего состояния карточки игрока
    public void displayCard() {
        for (int i = 0; i < numbers.length; i++) {
            if (closed[i]) {
                System.out.print("X "); // Если число закрыто, отображаем X
            } else {
                System.out.print(numbers[i] + " "); // Если число открыто, отображаем его значение
            }
        }
        System.out.println(); // Переход на новую строку после вывода карточки
    }

    // Метод для закрытия указанного числа на карточке
    public boolean closeNumber(int number) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number && !closed[i]) { // Если найдено совпадающее число, которое еще не закрыто
                closed[i] = true; // Закрываем число
                return true; // Возвращаем true, так как число успешно закрыто
            }
        }
        return false; // Если число не найдено или уже закрыто, возвращаем false
    }

    // Метод проверяет, закрыты ли все числа на карточке
    public boolean isFullyClosed() {
        for (boolean isClosed : closed) {
            if (!isClosed) return false; // Если хотя бы одно число открыто, возвращаем false
        }
        return true; // Если все числа закрыты, возвращаем true
    }

    // Метод для закрытия чисел из массива, возвращает число, которое закрыло карточку полностью
    public int closeAllFromArray(int[] array) {
        for (int number : array) {
            closeNumber(number); // Пытаемся закрыть текущее число
            if (isFullyClosed()) { // Проверяем, закрыта ли вся карточка
                return number; // Возвращаем число, которое закрыло карточку
            }
        }
        return -1; // Если карточка не закрыта полностью, возвращаем -1
    }
}

public class LotoGame {

    // Метод для создания карточки игрока
    private static LotoCard createCard(Scanner scanner) {
        System.out.println("Введите числа для карточки (через пробел):");
        String[] input = scanner.nextLine().split(" "); // Читаем числа из ввода пользователя
        int[] numbers = Arrays.stream(input).mapToInt(Integer::parseInt).toArray(); // Преобразуем строки в массив чисел
        return new LotoCard(numbers); // Возвращаем новую карточку
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Сканер для считывания пользовательского ввода

        System.out.println("Создание карточек игроков...");
        LotoCard player1 = createCard(scanner); // Создаем карточку игрока 1
        LotoCard player2 = createCard(scanner); // Создаем карточку игрока 2

        System.out.println("Карточка игрока 1:");
        player1.displayCard(); // Отображаем карточку игрока 1
        System.out.println("Карточка игрока 2:");
        player2.displayCard(); // Отображаем карточку игрока 2

        System.out.println("Введите выпавшие числа (через пробел):");
        String[] input = scanner.nextLine().split(" "); // Считываем выпавшие числа, разделенные пробелами
        int[] drawnNumbers = Arrays.stream(input).mapToInt(Integer::parseInt).toArray(); // Преобразуем строки в массив чисел

        // Закрываем числа на карточках игроков
        int winnerNumber1 = player1.closeAllFromArray(drawnNumbers);
        int winnerNumber2 = player2.closeAllFromArray(drawnNumbers);

        System.out.println("После обновления карточек:");
        System.out.println("Карточка игрока 1:");
        player1.displayCard(); // Отображаем обновленную карточку игрока 1
        System.out.println("Карточка игрока 2:");
        player2.displayCard(); // Отображаем обновленную карточку игрока 2

        // Проверяем, закрыта ли карточка каждого игрока
        boolean player1Wins = player1.isFullyClosed();
        boolean player2Wins = player2.isFullyClosed();

        if (player1Wins || player2Wins) {
            System.out.println("Победители:");
            if (player1Wins) {
                System.out.println("Игрок 1 закрыл карточку числом " + winnerNumber1); // Выводим победу игрока 1
            }
            if (player2Wins) {
                System.out.println("Игрок 2 закрыл карточку числом " + winnerNumber2); // Выводим победу игрока 2
            }
        } else {
            System.out.println("Ни один из игроков не закрыл карточку полностью."); // Сообщаем, если победителей нет
        }

        // Выводим количество игроков, закрывших карточку
        System.out.println("Количество игроков, закрывших карточку: " + ((player1Wins ? 1 : 0) + (player2Wins ? 1 : 0)));
    }
}
