class HardComputer {
    static void makeTurn() {
        int move = 0;

        if (Field.turnsNumber() == 1) move = firstTurn();

        if (prevent() == 0) {
            if (Field.turnsNumber() == 2) move = secondTurn();
        } else  {
            move = prevent();
        }
        if (win() != 0) {
            move = win();
        } else if (move == 0) {
                while (true) {
                    move = (int) (Math.random() * 9);
                    if ((move >= 1) && (move <= 9)
                            && (!Field.x[move].equals(Game.icon))
                            && (!Field.x[move].equals(Game.enemyIcon))) break;
                }
            }
        Field.x[move] = Game.enemyIcon;
    }
    private static int win() {
        int move = 0;
        if (Field.x[1].equals(Game.enemyIcon) && (Field.x[2].equals(Game.enemyIcon)) && Field.x[3].equals("3")) move = 3;
        if (Field.x[1].equals(Game.enemyIcon) && (Field.x[3].equals(Game.enemyIcon)) && Field.x[2].equals("2")) move = 2;
        if (Field.x[2].equals(Game.enemyIcon) && (Field.x[3].equals(Game.enemyIcon)) && Field.x[1].equals("1")) move = 1;

        if (Field.x[4].equals(Game.enemyIcon) && (Field.x[5].equals(Game.enemyIcon)) && Field.x[6].equals("6")) move = 6;
        if (Field.x[4].equals(Game.enemyIcon) && (Field.x[6].equals(Game.enemyIcon)) && Field.x[5].equals("5")) move = 5;
        if (Field.x[5].equals(Game.enemyIcon) && (Field.x[6].equals(Game.enemyIcon)) && Field.x[4].equals("4")) move = 4;

        if (Field.x[7].equals(Game.enemyIcon) && (Field.x[8].equals(Game.enemyIcon)) && Field.x[9].equals("9")) move = 9;
        if (Field.x[7].equals(Game.enemyIcon) && (Field.x[9].equals(Game.enemyIcon)) && Field.x[8].equals("8")) move = 8;
        if (Field.x[8].equals(Game.enemyIcon) && (Field.x[9].equals(Game.enemyIcon)) && Field.x[7].equals("7")) move = 7;

        if (Field.x[1].equals(Game.enemyIcon) && (Field.x[4].equals(Game.enemyIcon)) && Field.x[7].equals("7")) move = 7;
        if (Field.x[1].equals(Game.enemyIcon) && (Field.x[7].equals(Game.enemyIcon)) && Field.x[4].equals("4")) move = 4;
        if (Field.x[4].equals(Game.enemyIcon) && (Field.x[7].equals(Game.enemyIcon)) && Field.x[1].equals("1")) move = 1;

        if (Field.x[2].equals(Game.enemyIcon) && (Field.x[5].equals(Game.enemyIcon)) && Field.x[8].equals("8")) move = 8;
        if (Field.x[2].equals(Game.enemyIcon) && (Field.x[8].equals(Game.enemyIcon)) && Field.x[5].equals("5")) move = 5;
        if (Field.x[5].equals(Game.enemyIcon) && (Field.x[8].equals(Game.enemyIcon)) && Field.x[2].equals("2")) move = 2;

        if (Field.x[3].equals(Game.enemyIcon) && (Field.x[6].equals(Game.enemyIcon)) && Field.x[9].equals("9")) move = 9;
        if (Field.x[3].equals(Game.enemyIcon) && (Field.x[9].equals(Game.enemyIcon)) && Field.x[6].equals("6")) move = 6;
        if (Field.x[6].equals(Game.enemyIcon) && (Field.x[9].equals(Game.enemyIcon)) && Field.x[3].equals("3")) move = 3;

        if (Field.x[1].equals(Game.enemyIcon) && (Field.x[5].equals(Game.enemyIcon)) && Field.x[9].equals("9")) move = 9;
        if (Field.x[1].equals(Game.enemyIcon) && (Field.x[9].equals(Game.enemyIcon)) && Field.x[5].equals("5")) move = 5;
        if (Field.x[5].equals(Game.enemyIcon) && (Field.x[9].equals(Game.enemyIcon)) && Field.x[1].equals("1")) move = 1;

        if (Field.x[3].equals(Game.enemyIcon) && (Field.x[5].equals(Game.enemyIcon)) && Field.x[7].equals("7")) move = 7;
        if (Field.x[7].equals(Game.enemyIcon) && (Field.x[5].equals(Game.enemyIcon)) && Field.x[3].equals("3")) move = 3;
        if (Field.x[9].equals(Game.enemyIcon) && (Field.x[5].equals(Game.enemyIcon)) && Field.x[1].equals("1")) move = 1;

        return move;
    }

    private static int prevent() {
        int move = 0;
        if (Field.x[1].equals(Game.icon) && (Field.x[2].equals(Game.icon)) && Field.x[3].equals("3")) move = 3;
        if (Field.x[1].equals(Game.icon) && (Field.x[3].equals(Game.icon)) && Field.x[2].equals("2")) move = 2;
        if (Field.x[2].equals(Game.icon) && (Field.x[3].equals(Game.icon)) && Field.x[1].equals("1")) move = 1;

        if (Field.x[4].equals(Game.icon) && (Field.x[5].equals(Game.icon)) && Field.x[6].equals("6")) move = 6;
        if (Field.x[4].equals(Game.icon) && (Field.x[6].equals(Game.icon)) && Field.x[5].equals("5")) move = 5;
        if (Field.x[5].equals(Game.icon) && (Field.x[6].equals(Game.icon)) && Field.x[4].equals("4")) move = 4;

        if (Field.x[7].equals(Game.icon) && (Field.x[8].equals(Game.icon)) && Field.x[9].equals("9")) move = 9;
        if (Field.x[7].equals(Game.icon) && (Field.x[9].equals(Game.icon)) && Field.x[8].equals("8")) move = 8;
        if (Field.x[8].equals(Game.icon) && (Field.x[9].equals(Game.icon)) && Field.x[7].equals("7")) move = 7;

        if (Field.x[1].equals(Game.icon) && (Field.x[4].equals(Game.icon)) && Field.x[7].equals("7")) move = 7;
        if (Field.x[1].equals(Game.icon) && (Field.x[7].equals(Game.icon)) && Field.x[4].equals("4")) move = 4;
        if (Field.x[4].equals(Game.icon) && (Field.x[7].equals(Game.icon)) && Field.x[1].equals("1")) move = 1;

        if (Field.x[2].equals(Game.icon) && (Field.x[5].equals(Game.icon)) && Field.x[8].equals("8")) move = 8;
        if (Field.x[2].equals(Game.icon) && (Field.x[8].equals(Game.icon)) && Field.x[5].equals("5")) move = 5;
        if (Field.x[5].equals(Game.icon) && (Field.x[8].equals(Game.icon)) && Field.x[2].equals("2")) move = 2;

        if (Field.x[3].equals(Game.icon) && (Field.x[6].equals(Game.icon)) && Field.x[9].equals("9")) move = 9;
        if (Field.x[3].equals(Game.icon) && (Field.x[9].equals(Game.icon)) && Field.x[6].equals("6")) move = 6;
        if (Field.x[6].equals(Game.icon) && (Field.x[9].equals(Game.icon)) && Field.x[3].equals("3")) move = 3;

        if (Field.x[1].equals(Game.icon) && (Field.x[5].equals(Game.icon)) && Field.x[9].equals("9")) move = 9;
        if (Field.x[1].equals(Game.icon) && (Field.x[9].equals(Game.icon)) && Field.x[5].equals("5")) move = 5;
        if (Field.x[5].equals(Game.icon) && (Field.x[9].equals(Game.icon)) && Field.x[1].equals("1")) move = 1;

        if (Field.x[3].equals(Game.icon) && (Field.x[5].equals(Game.icon)) && Field.x[7].equals("7")) move = 7;
        if (Field.x[7].equals(Game.icon) && (Field.x[5].equals(Game.icon)) && Field.x[3].equals("3")) move = 3;
        if (Field.x[9].equals(Game.icon) && (Field.x[5].equals(Game.icon)) && Field.x[1].equals("1")) move = 1;

        return move;
    }
    private static int firstTurn() {
        int move;

        if (Field.x[5].equals(Game.icon)) {
            move = 1;
        } else {
            move = 5;
        }
        return move;
    }

    private static int secondTurn() {
        int move = 0;

        if (Field.x[2].equals(Game.icon) && (Field.x[8].equals(Game.icon))) move = 1;
        if (Field.x[4].equals(Game.icon) && (Field.x[6].equals(Game.icon))) move = 1;
        if (Field.x[1].equals(Game.icon) && (Field.x[9].equals(Game.icon))) move = 2;
        if (Field.x[3].equals(Game.icon) && (Field.x[7].equals(Game.icon))) move = 2;

        if (Field.x[2].equals(Game.icon) && (Field.x[4].equals(Game.icon))) move = 1;
        if (Field.x[2].equals(Game.icon) && (Field.x[6].equals(Game.icon))) move = 3;
        if (Field.x[4].equals(Game.icon) && (Field.x[8].equals(Game.icon))) move = 7;
        if (Field.x[6].equals(Game.icon) && (Field.x[8].equals(Game.icon))) move = 9;

        if (Field.x[1].equals(Game.icon) && (Field.x[6].equals(Game.icon))) move = 3;
        if (Field.x[1].equals(Game.icon) && (Field.x[8].equals(Game.icon))) move = 7;
        if (Field.x[3].equals(Game.icon) && (Field.x[4].equals(Game.icon))) move = 1;
        if (Field.x[3].equals(Game.icon) && (Field.x[8].equals(Game.icon))) move = 9;
        if (Field.x[7].equals(Game.icon) && (Field.x[2].equals(Game.icon))) move = 1;
        if (Field.x[7].equals(Game.icon) && (Field.x[6].equals(Game.icon))) move = 9;
        if (Field.x[9].equals(Game.icon) && (Field.x[2].equals(Game.icon))) move = 3;
        if (Field.x[9].equals(Game.icon) && (Field.x[4].equals(Game.icon))) move = 7;

        if (Field.x[5].equals(Game.icon) && (Field.x[3].equals(Game.icon))) move = 7;
        if (Field.x[5].equals(Game.icon) && (Field.x[7].equals(Game.icon))) move = 3;
        if (Field.x[5].equals(Game.icon) && (Field.x[9].equals(Game.icon))) move = 3;

        return move;
    }
}
