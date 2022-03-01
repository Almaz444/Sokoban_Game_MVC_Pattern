public class LevelsFromServer {

    private int level;

    public LevelsFromServer() {
        level = 7;
    }

    public int[][] nextLevel() {
        int[][] desktop = null;
        switch (level) {
            case 7:
                desktop = getSeventhLevel();
                break;
            case 8:
                desktop = getEightLevel();
                break;
            case 9:
                desktop = getNineLevel();
                break;
            default:
                level = 7;
                desktop = getSeventhLevel();
                break;
        }
        if (level == 9) {
            level = 7;
        } else {
            level = level + 1;
        }
        return desktop;
    }


    private int[][] getSeventhLevel() {
        int[][] levelSeven = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 0, 0, 0, 0, 0, 0, 0, 2, 2},
                {2, 2, 3, 2, 0, 0, 0, 3, 0, 0, 2},
                {2, 2, 0, 2, 0, 3, 2, 2, 2, 0, 2},
                {2, 2, 0, 3, 0, 0, 3, 1, 2, 0, 2},
                {2, 2, 0, 0, 3, 0, 2, 2, 2, 0, 2},
                {2, 2, 4, 0, 2, 0, 2, 2, 2, 0, 2},
                {2, 4, 4, 4, 4, 3, 2, 2, 2, 0, 2},
                {2, 2, 0, 4, 2, 0, 3, 0, 3, 0, 2},
                {2, 4, 0, 0, 4, 0, 4, 0, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        return levelSeven;
    }

    private int[][] getEightLevel() {
        int[][] levelEight = new int[][]{
                {0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},
                {0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 2, 0},
                {0, 0, 2, 0, 0, 3, 0, 3, 4, 0, 2, 0},
                {0, 0, 2, 0, 2, 4, 4, 2, 4, 0, 2, 0},
                {0, 0, 2, 0, 3, 4, 2, 0, 3, 0, 2, 0},
                {0, 0, 2, 0, 2, 4, 3, 4, 3, 0, 2, 2},
                {2, 2, 2, 0, 3, 4, 2, 4, 2, 0, 0, 2},
                {2, 0, 3, 0, 2, 4, 2, 4, 0, 3, 0, 2},
                {2, 0, 0, 0, 3, 4, 2, 4, 3, 3, 0, 2},
                {2, 2, 0, 0, 1, 3, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0}
        };
        return levelEight;
    }

    private int[][] getNineLevel() {
        int[][] levelNine = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0},
                {2, 0, 1, 0, 0, 0, 2, 2, 2, 2, 2},
                {2, 0, 3, 3, 3, 0, 3, 0, 0, 0, 2},
                {2, 0, 0, 2, 4, 4, 2, 3, 3, 0, 2},
                {2, 2, 3, 2, 4, 4, 4, 0, 0, 0, 2},
                {2, 2, 0, 4, 4, 4, 2, 2, 3, 2, 2},
                {2, 0, 0, 2, 4, 4, 2, 2, 0, 0, 2},
                {2, 0, 0, 3, 0, 0, 3, 0, 0, 0, 2},
                {2, 0, 0, 2, 0, 0, 0, 2, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        return levelNine;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}


