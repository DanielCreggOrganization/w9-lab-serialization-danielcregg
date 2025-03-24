package ie.atu.serialization;

import java.io.Serializable;

public class GameSave implements Serializable {
    private static final long serialVersionUID = 2L; // Changed to Version 2
    
    private String playerName;
    private int score;
    private int level;
    private long playTime; // New field

    
    public GameSave(String playerName, int score, int level) {
        this(playerName, score, level, 0);
    }
    
    public GameSave(String playerName, int score, int level, long playTime) {
        this.playerName = playerName;
        this.score = score;
        this.level = level;
        this.playTime = playTime;
    }
    
    public String getPlayerName() {
        return playerName;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getLevel() {
        return level;
    }
    
    public long getPlayTime() {
        return playTime;
    }
    
    @Override
    public String toString() {
        return "GameSave{playerName='" + playerName + "', score=" + score + 
               ", level=" + level + ", playTime=" + playTime + "}";
    }
}
