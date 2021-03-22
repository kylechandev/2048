package kylec.me.game2048.app;

import android.app.Application;

/**
 * 应用配置
 * <p>
 * Created by KYLE on 2018/10/4
 */
public class Config extends Application {

    /**
     * 保存最高分的SharedPreferences
     */
    public static final String SAVE_BEST_SCORE = "SAVE_BEST_SCORE";
    /**
     * 保存当前得分的SharedPreferences
     */
    public static final String SAVE_CURRENT_SCORE = "SAVE_CURRENT_SCORE";
    public static final String SAVE_CURRENT_SCORE_INFINITE = "SAVE_CURRENT_SCORE";
    /**
     * 保存游戏难度的SharedPreferences
     */
    public static final String SAVE_GAME_DIFFICULTY = "SAVE_GAME_DIFFICULTY";

    /**
     * 保存游戏音效状态的SharedPreferences
     */
    public static final String SAVE_GAME_VOLUME_STATE = "SAVE_GAME_VOLUME_STATE";

    /**
     * 保存达成游戏目标次数的SharedPreferences
     */
    public static final String SAVE_GET_GOAL_TIME = "SAVE_GET_GOAL_TIME";

    /**
     * 保存游戏模式的SharedPreferences
     */
    public static final String SAVE_CURRENT_GAME_MODE = "SAVE_CURRENT_GAME_MODE";

    /**
     * SharedPreferences保存4难度下最高分的KEY
     */
    public static final String KEY_BEST_SCORE_WITHIN_4 = "KEY_BEST_SCORE_WITHIN_4";

    /**
     * SharedPreferences保存5难度下最高分的KEY
     */
    public static final String KEY_BEST_SCORE_WITHIN_5 = "KEY_BEST_SCORE_WITHIN_5";

    /**
     * SharedPreferences保存6难度下最高分的KEY
     */
    public static final String KEY_BEST_SCORE_WITHIN_6 = "KEY_BEST_SCORE_WITHIN_6";

    /**
     * SharedPreferences保存无限模式下最高分的KEY
     */
    public static final String KEY_BEST_SCORE_WITHIN_INFINITE = "KEY_BEST_SCORE_WITHIN_INFINITE";

    /**
     * SharedPreferences保存游戏难度的KEY
     */
    public static final String KEY_GAME_DIFFICULTY = "KEY_GAME_DIFFICULTY";

    /**
     * SharedPreferences保存游戏音效状态的KEY
     */
    public static final String KEY_GAME_VOLUME_STATE = "KEY_GAME_VOLUME_STATE";

    /**
     * SharedPreferences保存达成游戏目标的KEY
     */
    public static final String KEY_GET_GOAL_TIME = "KEY_GET_GOAL_TIME";

    /**
     * SharedPreferences保存游戏模式的KEY
     */
    public static final String KEY_CURRENT_GAME_MOE = "KEY_CURRENT_GAME_MOE";

    /**
     * 最高得分
     */
    public static int BestScore;

    /**
     * 无限模式下最高分
     */
    public static int BestScoreWithinInfinite;

    /**
     * 方格数(默认4行4列)
     */
    public static int GRIDColumnCount = 4;

    /**
     * 游戏音效状态(默认打开)
     */
    public static boolean VolumeState = true;

    /**
     * 达成游戏目标次数(默认0)
     */
    public static int GetGoalTime = 0;

    /**
     * 当前游戏模式(默认经典模式)
     */
    public static int CurrentGameMode = 0;

    /**
     * 判断有没有使用过外挂模式(默认没有)
     */
    public static boolean haveCheat = false;

    @Override
    public void onCreate() {
        super.onCreate();
        // 获取到游戏难度
        GRIDColumnCount = ConfigManager.getGameDifficulty(this);
        // 获取到最高分
        BestScore = ConfigManager.getBestScore(this);
        // 获取游戏音效状态
        VolumeState = ConfigManager.getGameVolumeState(this);
        // 获取达成游戏目标次数
        GetGoalTime = ConfigManager.getGoalTime(this);
        // 获取游戏模式
        CurrentGameMode = ConfigManager.getCurrentGameMode(this);
        // 获取无限模式下最高分
        BestScoreWithinInfinite = ConfigManager.getBestScoreWithinInfinite(this);
    }

    public static String getTableName() {
        if (CurrentGameMode == 0) {
            switch (GRIDColumnCount) {
                case 4:
                    return Constant.TABLE_NAME_4;
                case 5:
                    return Constant.TABLE_NAME_5;
                case 6:
                    return Constant.TABLE_NAME_6;
                default:
                    return Constant.TABLE_NAME_4;
            }
        } else {
            return Constant.TABLE_NAME_INFINITE;
        }
    }

}
