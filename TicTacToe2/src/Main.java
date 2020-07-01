
import java.util.Scanner;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
        System.out.println("Приветствую Вас!");
        System.out.println("Сыграем в крестики-нолики?");
        System.out.println("===============");
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(player)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            compTurn();
            printMap();
            if (checkWin(computer)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }



    public static char[][] map;
    public static int size = 3;
    public static int dots_for_win = 4;

    public static char space = '-';
    public static char player = 'O';
    public static char computer = 'X';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();



    static void initMap() {
            map = new char[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map[i][j] = space;
                }
            }
        }

        public static void printMap() {
            for (int i = 0; i <= size; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 0; i < size; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < size; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        public static void humanTurn() {
            int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!ValidCell(x, y));
        map[y][x] = computer;
    }


    public static void compTurn() {
        int x, y;
        do {
            x = rand.nextInt(size);
            y = rand.nextInt(size);
        } while (!ValidCell(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = player;
    }





    public static boolean ValidCell(int x, int y) {
        if (x < 0 || x >= size || y < 0 || y >= size) return false;
        if (map[y][x] == space) return true;
        return false;
}


    static boolean checkWin(char[][] map, int size, char sign) { // у меня не получилось сделать проверку победы..внизу у меня есть
        // вариант, но это не цикл. Я не поняла как сделать в цикле, и чтобы все работало(17 и 27
        // строка подсвечивается я не понимаю почему)
        for (int i = 0; i < size; i++) {
            if (map[i][0] == sign && map[i][1] == sign && map[i][2] == sign) {
                return true;
            }
        }
        return false;
    }


    public static boolean isMapFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == space) return false;
            }
        }
        return true;
    }

}





// я пыталась сделать проверку но у меня не вышло

//    private static boolean checkWin(String[][] desc) {
//        return checkWinnerHorizontal(desc) ||
//                checkWinnerVertical(desc) ||
//                checkWinnerDiagonals(desc);
//    }
//
//    private static boolean checkWinnerHorizontal(String[][] desc) {
//        return desc[0][0].equals(desc[1][0]) && desc[0][0].equals(desc[2][0]) ||
//                desc[0][1].equals(desc[1][1]) && desc[0][1].equals(desc[2][1]) ||
//                desc[0][2].equals(desc[1][2]) && desc[0][2].equals(desc[2][2]);
//    }
//
//    private static boolean checkWinnerVertical(String[][] desc) {
//        return desc[0][0].equals(desc[0][1]) && desc[0][0].equals(desc[0][2]) ||
//                desc[1][0].equals(desc[1][1]) && desc[1][0].equals(desc[1][2]) ||
//                desc[2][0].equals(desc[2][1]) && desc[2][0].equals(desc[2][2]);
//    }
//
//    private static boolean checkWinnerDiagonals(String[][] desc) {
//        return desc[0][0].equals(desc[1][1]) && desc[0][0].equals(desc[2][2]) ||
//                desc[2][0].equals(desc[1][1]) && desc[2][0].equals(desc[0][2]);
//    }


