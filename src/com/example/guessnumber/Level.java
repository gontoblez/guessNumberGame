package com.example.guessnumber;

public class Level {
    private String levelName;
    private int levelNumber;
    private int range;
    private int tries;
    private boolean progress;

    public Level(String levelName, int levelNumber, int range, int tries, boolean progress) {
        this.levelName = levelName;
        this.levelNumber = levelNumber;
        this.range = range;
        this.tries = tries;
        this.progress = progress;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    public boolean getProgress() {
        return progress;
    }

    public void setProgress(boolean progress) {
        this.progress = progress;
    }
}
