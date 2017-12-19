import java.util.Scanner;

class gameModes {
    static void PvP() {

        Scanner scan = new Scanner(System.in);
        int player;
        int move;
        String image;
        for (int i = 1; i <= 9; i++) {
            player = (i % 2);
            image = Game.icon;
            if (player == 0) {
                player = 2;
                image = Game.enemyIcon;
            }

            System.out.println("Player " + player + " turn :");
            Field.printField();
            while (true) {

                move = scan.nextInt();
                if ((move >= 1) && (move <= 9)
                        && (!Field.x[move].equals(Game.icon))
                        && (!Field.x[move].equals(Game.enemyIcon))) {
                    break;
                }
                System.out.println("Cell is not empty or wrong input, try again. \n Your turn :");
            }

            Field.x[move] = image;
            Field.winnerSearch();

            if ((Field.winnerSearch().equals(Game.icon)) || Field.winnerSearch().equals(Game.enemyIcon)) {
                Field.printField();
                if (Field.winnerSearch().equals(Game.icon)) results.scoreBoard.replace(Game.name.toLowerCase()
                        ,results.scoreBoard.get(Game.name.toLowerCase()) + 1);
                if (Field.winnerSearch().equals(Game.enemyIcon)) results.scoreBoard.replace(Game.name.toLowerCase()
                        ,results.scoreBoard.get(Game.name.toLowerCase()) - 1);
                System.out.println(Field.winnerSearch() + " wins.");
                break;
            }
            if (i == 9) {
                Field.printField();
                System.out.println("Draw.");
            }
        }
    }

    static void PvC_Easy() {

        Scanner scan = new Scanner(System.in);
        int move;
        int myTurn;

        for (int i = 1; i <= 9; i++) {
            myTurn = i % 2;
            if (myTurn == 1) {
                System.out.println("Your turn: ");
                Field.printField();
                while (true) {

                    move = scan.nextInt();
                    if ((move >= 1) && (move <= 9)
                            && (!Field.x[move].equals(Game.icon))
                            && (!Field.x[move].equals(Game.enemyIcon))) {
                        break;
                    }
                    System.out.println("Cell is not empty or wrong input, try again. \n Your turn :");
                }
                Field.x[move] = Game.icon;

            } else {
                EasyComputer.makeTurn();
            }

            Field.winnerSearch();
            if (Field.winnerSearch().equals(Game.icon)) {
                Field.printField();
                System.out.println("You win.");
                results.scoreBoard.replace(Game.name.toLowerCase(),results.scoreBoard.get(Game.name.toLowerCase()) + 1);
                break;
            }
            if (Field.winnerSearch().equals(Game.enemyIcon)) {
                Field.printField();
                System.out.println("You lose.");
                results.scoreBoard.replace(Game.name.toLowerCase(),results.scoreBoard.get(Game.name.toLowerCase()) - 1);
                break;
            }
            if (i == 9) {
                Field.printField();
                System.out.println("Draw.");
            }
        }
    }

    static void PvC_Hard() {

        Scanner scan = new Scanner(System.in);
        int move;
        int myTurn;

        for (int i = 1; i <= 9; i++) {
            myTurn = i % 2;
            if (myTurn == 1) {
                System.out.println("Your turn: ");
                Field.printField();
                while (true) {
                    move = scan.nextInt();
                    if ((move >= 1) && (move <= 9)
                            && (!Field.x[move].equals(Game.icon))
                            && (!Field.x[move].equals(Game.enemyIcon))) {
                        break;
                    }
                    System.out.println("Cell is not empty or wrong input, try again. \n Your turn :");
                }
                Field.x[move] = Game.icon;

            } else {
                HardComputer.makeTurn();
            }
            Field.winnerSearch();
            if (Field.winnerSearch().equals(Game.icon)) {
                Field.printField();
                System.out.println("You win.");
                results.scoreBoard.replace(Game.name.toLowerCase(),results.scoreBoard.get(Game.name.toLowerCase()) + 1);
                break;
            }
            if (Field.winnerSearch().equals(Game.enemyIcon)) {
                Field.printField();
                System.out.println("You lose.");
                results.scoreBoard.replace(Game.name.toLowerCase(),results.scoreBoard.get(Game.name.toLowerCase()) - 1);
                break;
            }
            if (i == 9) {
                Field.printField();
                System.out.println("Draw.");
            }
        }
    }
}
