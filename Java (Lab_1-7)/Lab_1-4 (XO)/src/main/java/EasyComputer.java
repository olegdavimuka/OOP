class EasyComputer {
    static void makeTurn() {
        int move;
        while (true) {
            move = (int) (Math.random() * 9);
            if ((move >= 1) && (move <= 9)
                    && (!Field.x[move].equals(Game.icon))
                    && (!Field.x[move].equals(Game.enemyIcon))) {
                Field.x[move] = Game.enemyIcon;
                break;
            }
        }
    }
}
