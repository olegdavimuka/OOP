import java.util.Scanner;

class Game {

    static String icon, enemyIcon;
    static String name;
    private static Scanner scan = new Scanner(System.in);

    private static void iconChoose() {
        do {
            System.out.println("Choice icon: X or O");
            icon = scan.nextLine().toUpperCase();
            if ((icon.toUpperCase().equals("X")) || (icon.toUpperCase().equals("O"))) {
                break;
            }
        } while (true);
        if (icon.equals("X")) {
            enemyIcon = "O";
        } else {
            enemyIcon = "X";
        }
    }

    public static void main(String[] args) {

        do {
            results.getResults();
            System.out.println("Enter your name");
            name = scan.nextLine();
            if (!results.scoreBoard.containsKey(name.toLowerCase())) results.scoreBoard.put(name.toLowerCase(), 0);
            Field.initializeField();

            System.out.println("Choice game mode : \n 1. PvP \n 2. PvC (easy) \n 3. PvC (hard)");
            String mode;
            do {
                System.out.println("Print 1-3, refresh, results or champ.");
                mode = scan.nextLine();
                if ((mode.equals("1")) || (mode.equals("2")) || (mode.equals("3")) || (mode.equals("refresh"))
                        || (mode.equals("results")) || (mode.equals("champ"))) {
                    break;
                }
            } while (true);

            switch (mode) {
                case "1":
                    iconChoose();
                    System.out.println("Game mode : PvP");
                    gameModes.PvP();
                    results.modifyResults();
                    break;
                case "2":
                    iconChoose();
                    System.out.println("Game mode : PvC (easy)");
                    gameModes.PvC_Easy();
                    results.modifyResults();
                    break;
                case "3":
                    iconChoose();
                    System.out.println("Game mode : PvC (hard)");
                    gameModes.PvC_Hard();
                    results.modifyResults();
                    break;
                case "refresh":
                    results.clearResults();
                    System.out.println("Results are refreshed");
                    break;
                case "results":
                    results.modifyResults();
                    results.printResults();
                    break;
                case "champ":
                    results.modifyResults();
                    results.champSearch();
                    break;
            }
            System.out.println("Do you want to continue? \n Type Yes or No.");

            if (scan.nextLine().toUpperCase().equals("NO"))
                break;
        } while (true);
    }
}