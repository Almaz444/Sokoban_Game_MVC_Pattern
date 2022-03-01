public class Model {
    private Viewer viewer;
    private int[][] desktop;
    private int[][] goalsIndexArray;
    private int indexX;
    private int indexY;
    private Levels levels;
    private boolean isOk;
    private LevelsFromFile levelsFromFile;

    public Model(Viewer viewer) {
        this.viewer = viewer;
        levels = new Levels();
        isOk = true;
        desktop = levels.nextLevel();
        levelsFromFile = new LevelsFromFile();
        initialization();
    }

    public boolean getStatus() {
        return isOk;
    }

    public void initialization() {
        if (isValidate()) {
            getIndexPlayer();
            desktop[indexX][indexY] = 1;
            initializationGoalsIndex();

        } else {
            isOk = false;

        }

    }

    public void move(String direction) {
        if (direction.equals("Up")) {
            moveUp();
        } else if (direction.equals("Right")) {
            moveRight();
        } else if (direction.equals("Down")) {
            moveDown();
        } else if (direction.equals("Left")) {
            moveLeft();
        } else {
            return;
        }
        checkGoal();
        viewer.update();
        won();
    }


    private void won() {
        boolean isWon = true;
        for (int i = 0; i < goalsIndexArray[0].length; i++) {
            int x = goalsIndexArray[0][i];
            int y = goalsIndexArray[1][i];
            if (desktop[x][y] != 3) {
                isWon = false;
                break;
            }
        }
        if (isWon) {
            if (viewer.showDialogWon()) {
                System.out.printf("Get to next level?");
                desktop = levels.nextLevel();
                initialization();
                viewer.update();
            }

        }
    }

    private void getIndexPlayer() {
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 1) {
                    indexX = i;
                    indexY = j;
                    return;
                }
            }
        }
    }

    private boolean isValidate() {
        int countBoxes = 0;
        int countGoals = 0;
        int countPlayer = 0;
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 1) {
                    countPlayer++;
                }
                if (desktop[i][j] == 3) {
                    countBoxes++;
                }
                if (desktop[i][j] == 4) {
                    countGoals++;
                }
            }
        }
        if ((countPlayer > 0 && countPlayer < 2) && (countBoxes > 0 && countGoals > 0) && (countBoxes == countGoals)) {
            return true;
        } else {
            return false;
        }
    }

    private void checkGoal() {
        for (int i = 0; i < goalsIndexArray[0].length; i++) {
            int x = goalsIndexArray[0][i];
            int y = goalsIndexArray[1][i];
            if (desktop[x][y] == 0) {
                desktop[x][y] = 4;
            }
        }
    }

    private void moveUp() {
        if (desktop[indexX - 1][indexY] == 3) {
            if (desktop[indexX - 2][indexY] == 0 || desktop[indexX - 2][indexY] == 4) {
                desktop[indexX - 1][indexY] = 0;
                desktop[indexX - 2][indexY] = 3;
            }
        }
        if (desktop[indexX - 1][indexY] == 0 || desktop[indexX - 1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX = indexX - 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveRight() {
        if (desktop[indexX][indexY + 1] == 3) {
            if (desktop[indexX][indexY + 2] == 0 || desktop[indexX][indexY + 2] == 4) {
                desktop[indexX][indexY + 1] = 0;
                desktop[indexX][indexY + 2] = 3;
            }

        }
        if (desktop[indexX][indexY + 1] == 0 || desktop[indexX][indexY + 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY = indexY + 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveDown() {
        if (desktop[indexX + 1][indexY] == 3) {
            if (desktop[indexX + 2][indexY] == 0 || desktop[indexX + 2][indexY] == 4) {
                desktop[indexX + 1][indexY] = 0;
                desktop[indexX + 2][indexY] = 3;
            }
        }
        if (desktop[indexX + 1][indexY] == 0 || desktop[indexX + 1][indexY] == 4) {
            desktop[indexX][indexY] = 0;
            indexX = indexX + 1;
            desktop[indexX][indexY] = 1;
        }
    }

    private void moveLeft() {
        if (desktop[indexX][indexY - 1] == 3) {
            if (desktop[indexX][indexY - 2] == 0 || desktop[indexX][indexY - 2] == 4) {
                desktop[indexX][indexY - 1] = 0;
                desktop[indexX][indexY - 2] = 3;
            }
        }


        if (desktop[indexX][indexY - 1] == 0 || desktop[indexX][indexY - 1] == 4) {
            desktop[indexX][indexY] = 0;
            indexY = indexY - 1;
            desktop[indexX][indexY] = 1;
        }
    }

    public int[][] getDesktop() {
        return desktop;
    }

    private void initializationGoalsIndex() {
        int countGoalsIndex = 0;
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 4) {
                    countGoalsIndex = countGoalsIndex + 1;
                }

            }
        }
        goalsIndexArray = new int[2][countGoalsIndex];
        int goalY = 0;
        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 4) {
                    goalsIndexArray[0][goalY] = i;
                    goalsIndexArray[1][goalY] = j;
                    goalY = goalY + 1;
                }

            }
        }
    }

    public void selectLevelFromMenu(String level) {
        switch (level) {
            case "One":
                levels.setLevel(1);
                desktop = levels.nextLevel();
                initialization();
                viewer.update();
                break;
            case "Two":
                levels.setLevel(2);
                desktop = levels.nextLevel();
                initialization();
                viewer.update();
                break;
            case "Three":
                levels.setLevel(3);
                desktop = levels.nextLevel();
                initialization();
                viewer.update();
                break;
            case "Four":
                levels.setLevel(4);
                desktop = levels.nextLevel();
                initialization();
                viewer.update();
                break;
            case "Five":
                levels.setLevel(5);
                desktop = levels.nextLevel();
                initialization();
                viewer.update();
                break;
            case "Six":
                levels.setLevel(6);
                desktop = levels.nextLevel();
                initialization();
                viewer.update();
                break;
            case "Seven":
                levels.setLevel(7);
                desktop = levels.nextLevel();
                initialization();
                viewer.update();
                break;
            case "Eight":
                levels.setLevel(8);
                desktop = levels.nextLevel();
                initialization();
                viewer.update();
                break;
            case "Nine":
                levels.setLevel(9);
                desktop = levels.nextLevel();
                initialization();
                viewer.update();
                break;

        }
    }

    public int getCurrentLevel() {
        return (this.levels.getLevel() - 1);
    }


}
