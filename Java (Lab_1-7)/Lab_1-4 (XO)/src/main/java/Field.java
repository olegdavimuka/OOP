
class Field {
    static String[] x = new String[10];
    static void initializeField() {
        for (int i = 1; i <= 9; i++) {
                x[i] = "";
                x[i] += i;
        }
    }

    static int turnsNumber() {
        int number = 0;
        for (int i = 1; i <= 9; i++) {
            if ((x[i].equals("X")) || (x[i].equals("O"))) number++;
        }
        return number;
    }

    static void printField() {
        for (int i = 1; i <= 9; i++) {
            System.out.print("|");
            System.out.print(x[i]);
            if (i % 3 == 0) {
                System.out.println("|");
            }
        }
    }

    static String winnerSearch() {
        String winner = "";
        if (((x[1].equals(x[2])) && (x[1].equals(x[3])) && (x[1].equals(Game.icon)))
                || ((x[4].equals(x[5])) && (x[4].equals(x[6])) && (x[4].equals(Game.icon)))
                || ((x[7].equals(x[8])) && (x[7].equals(x[9])) && (x[7].equals(Game.icon)))
                || ((x[1].equals(x[4])) && (x[1].equals(x[7])) && (x[1].equals(Game.icon)))
                || ((x[2].equals(x[5])) && (x[2].equals(x[8])) && (x[2].equals(Game.icon)))
                || ((x[3].equals(x[6])) && (x[3].equals(x[9])) && (x[3].equals(Game.icon)))
                || ((x[1].equals(x[5])) && (x[1].equals(x[9])) && (x[1].equals(Game.icon)))
                || ((x[3].equals(x[5])) && (x[3].equals(x[7])) && (x[3].equals(Game.icon)))) {
            winner += Game.icon;
        }

        if (((x[1].equals(x[2])) && (x[1].equals(x[3])) && (x[1].equals(Game.enemyIcon)))
                || ((x[4].equals(x[5])) && (x[4].equals(x[6])) && (x[4].equals(Game.enemyIcon)))
                || ((x[7].equals(x[8])) && (x[7].equals(x[9])) && (x[7].equals(Game.enemyIcon)))
                || ((x[1].equals(x[4])) && (x[1].equals(x[7])) && (x[1].equals(Game.enemyIcon)))
                || ((x[2].equals(x[5])) && (x[2].equals(x[8])) && (x[2].equals(Game.enemyIcon)))
                || ((x[3].equals(x[6])) && (x[3].equals(x[9])) && (x[3].equals(Game.enemyIcon)))
                || ((x[1].equals(x[5])) && (x[1].equals(x[9])) && (x[1].equals(Game.enemyIcon)))
                || ((x[3].equals(x[5])) && (x[3].equals(x[7])) && (x[3].equals(Game.enemyIcon)))) {
            winner += Game.enemyIcon;
        }
        return winner;
    }
}
