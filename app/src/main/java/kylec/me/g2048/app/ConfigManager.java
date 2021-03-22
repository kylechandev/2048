package kylec.me.g2048.app;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 保存配置工具
 * <p>
 * Created by KYLE on 2018/10/4
 */
public class ConfigManager {

    /**
     * 保存最高分
     */
    public static void putBestScore(Context context, int bestScore) {
        SharedPreferences.Editor editor = context.getSharedPreferences(
                Config.SAVE_BEST_SCORE, Context.MODE_PRIVATE).edit();
        switch (Config.GRIDColumnCount) {
            case 4:// 难度4
                editor.putInt(Config.KEY_BEST_SCORE_WITHIN_4, bestScore).apply();
                break;
            case 5:// 难度5
                editor.putInt(Config.KEY_BEST_SCORE_WITHIN_5, bestScore).apply();
                break;
            case 6:// 难度6
                editor.putInt(Config.KEY_BEST_SCORE_WITHIN_6, bestScore).apply();
                break;
            default:
                break;
        }
    }

    /**
     * 获取最高分
     */
    public static int getBestScore(Context context) {
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(Config.SAVE_BEST_SCORE, Context.MODE_PRIVATE);
        switch (Config.GRIDColumnCount) {
            case 4:// 难度4
                return sharedPreferences.getInt(Config.KEY_BEST_SCORE_WITHIN_4, 0);
            case 5:// 难度5
                return sharedPreferences.getInt(Config.KEY_BEST_SCORE_WITHIN_5, 0);
            case 6:// 难度6
                return sharedPreferences.getInt(Config.KEY_BEST_SCORE_WITHIN_6, 0);
            default:
                return 0;
        }
    }

    /**
     * 保存当前得分
     */
    public static void putCurrentScore(Context context, int currentScore) {
        SharedPreferences.Editor editor = context.getSharedPreferences(
                Config.SAVE_CURRENT_SCORE, Context.MODE_PRIVATE).edit();
        switch (Config.GRIDColumnCount) {
            case 4:// 难度4
                editor.putInt("KEY_CURRENT_SCORE_4", currentScore).apply();
                break;
            case 5:// 难度5
                editor.putInt("KEY_CURRENT_SCORE_5", currentScore).apply();
                break;
            case 6:// 难度6
                editor.putInt("KEY_CURRENT_SCORE_6", currentScore).apply();
                break;
            default:
                break;
        }
    }

    /**
     * 获取当前得分
     */
    public static int getCurrentScore(Context context) {
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(Config.SAVE_CURRENT_SCORE, Context.MODE_PRIVATE);
        switch (Config.GRIDColumnCount) {
            case 4:// 难度4
                return sharedPreferences.getInt("KEY_CURRENT_SCORE_4", 0);
            case 5:// 难度5
                return sharedPreferences.getInt("KEY_CURRENT_SCORE_5", 0);
            case 6:// 难度6
                return sharedPreferences.getInt("KEY_CURRENT_SCORE_6", 0);
            default:
                return 0;
        }
    }

    /**
     * 保存无限模式下最高分
     */
    public static void putBestScoreWithinInfinite(Context context, int bestScore) {
        SharedPreferences.Editor editor = context.getSharedPreferences(
                Config.SAVE_BEST_SCORE, Context.MODE_PRIVATE).edit();
        editor.putInt(Config.KEY_BEST_SCORE_WITHIN_INFINITE, bestScore).apply();
    }

    /**
     * 获取无限模式下最高分
     */
    public static int getBestScoreWithinInfinite(Context context) {
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(Config.SAVE_BEST_SCORE, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(Config.KEY_BEST_SCORE_WITHIN_INFINITE, 0);
    }

    /**
     * 保存当前无限模式分数
     */
    public static void putCurrentScoreWithinInfinite(Context context, int currentScore) {
        SharedPreferences.Editor editor = context.getSharedPreferences(
                Config.SAVE_CURRENT_SCORE_INFINITE, Context.MODE_PRIVATE).edit();
        editor.putInt("KEY_CURRENT_SCORE_INFINITE", currentScore).apply();
    }

    /**
     * 获取当前无限模式分数
     */
    public static int getCurrentScoreWithinInfinite(Context context) {
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(Config.SAVE_CURRENT_SCORE_INFINITE, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("KEY_CURRENT_SCORE_INFINITE", 0);
    }

    /**
     * 保存游戏难度
     */
    public static void putGameDifficulty(Context context, int difficulty) {
        SharedPreferences.Editor editor = context.getSharedPreferences(
                Config.SAVE_GAME_DIFFICULTY, Context.MODE_PRIVATE).edit();
        editor.putInt(Config.KEY_GAME_DIFFICULTY, difficulty).apply();
    }

    /**
     * 获取游戏难度
     */
    static int getGameDifficulty(Context context) {
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(Config.SAVE_GAME_DIFFICULTY, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(Config.KEY_GAME_DIFFICULTY, 4);
    }

    /**
     * 保存游戏音效状态
     */
    public static void putGameVolume(Context context, boolean volumeState) {
        SharedPreferences.Editor editor = context.getSharedPreferences(
                Config.SAVE_GAME_VOLUME_STATE, Context.MODE_PRIVATE).edit();
        editor.putBoolean(Config.KEY_GAME_VOLUME_STATE, volumeState).apply();
    }

    /**
     * 获取游戏音效状态
     */
    static boolean getGameVolumeState(Context context) {
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(Config.SAVE_GAME_VOLUME_STATE, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(Config.KEY_GAME_VOLUME_STATE, true);
    }

    /**
     * 保存达成游戏目标次数
     */
    public static void putGoalTime(Context context, int time) {
        SharedPreferences.Editor editor = context.getSharedPreferences(
                Config.SAVE_GET_GOAL_TIME, Context.MODE_PRIVATE).edit();
        editor.putInt(Config.KEY_GET_GOAL_TIME, time).apply();
    }

    /**
     * 获取达成游戏目标次数
     */
    public static int getGoalTime(Context context) {
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(Config.SAVE_GET_GOAL_TIME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(Config.KEY_GET_GOAL_TIME, 0);
    }

    /**
     * 保存游戏模式
     */
    public static void putCurrentGameMode(Context context, int mode) {
        SharedPreferences.Editor editor = context.getSharedPreferences(
                Config.SAVE_CURRENT_GAME_MODE, Context.MODE_PRIVATE).edit();
        editor.putInt(Config.KEY_CURRENT_GAME_MOE, mode).apply();
    }

    /**
     * 获取游戏模式
     */
    static int getCurrentGameMode(Context context) {
        SharedPreferences sharedPreferences =
                context.getSharedPreferences(Config.SAVE_CURRENT_GAME_MODE, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(Config.KEY_CURRENT_GAME_MOE, 0);
    }

}
