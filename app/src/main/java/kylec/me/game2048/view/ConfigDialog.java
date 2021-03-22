package kylec.me.game2048.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.button.MaterialButton;

import java.util.Objects;

import kylec.me.game2048.R;
import kylec.me.game2048.app.Config;

/**
 * 自定义配置对话框
 * <p>
 * Created by KYLE on 2018/10/4
 */
public class ConfigDialog extends Dialog {

    private View.OnClickListener onPositiveClickListener;

    /**
     * 游戏难度
     */
    private int difficulty = Config.GRIDColumnCount;

    /**
     * 游戏音效状态
     */
    private boolean volumeState = Config.VolumeState;

    public ConfigDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_config);

        setCancelable(true);
        setCanceledOnTouchOutside(true);

        Objects.requireNonNull(getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView confirm = findViewById(R.id.tv_confirm);
        MaterialButton difficulty4 = findViewById(R.id.btn_difficulty_4);
        MaterialButton difficulty5 = findViewById(R.id.btn_difficulty_5);
        MaterialButton difficulty6 = findViewById(R.id.btn_difficulty_6);
        MaterialButton volumeON = findViewById(R.id.btn_volume_on);
        MaterialButton volumeOFF = findViewById(R.id.btn_volume_off);
        TextView getGoalTime = findViewById(R.id.tv_goal_get_time);
        // 根据游戏难度选中按钮
        switch (Config.GRIDColumnCount) {
            case 4:
                difficulty4.setStrokeColorResource(R.color.colorWhite);
                difficulty = 4;
                break;
            case 5:
                difficulty5.setStrokeColorResource(R.color.colorWhite);
                difficulty = 5;
                break;
            case 6:
                difficulty6.setStrokeColorResource(R.color.colorWhite);
                difficulty = 6;
                break;
            default:
                break;
        }
        // 根据配置参数选中按钮
        if (Config.VolumeState) {
            volumeON.setStrokeColorResource(R.color.colorWhite);
        } else {
            volumeOFF.setStrokeColorResource(R.color.colorWhite);
        }

        if (onPositiveClickListener != null) {
            confirm.setOnClickListener(onPositiveClickListener);
        }

        difficulty4.setOnClickListener(v -> {
            difficulty = 4;
            difficulty4.setStrokeColorResource(R.color.colorWhite);
            difficulty5.setStrokeColorResource(android.R.color.transparent);
            difficulty6.setStrokeColorResource(android.R.color.transparent);
        });
        difficulty5.setOnClickListener(v -> {
            difficulty = 5;
            difficulty4.setStrokeColorResource(android.R.color.transparent);
            difficulty5.setStrokeColorResource(R.color.colorWhite);
            difficulty6.setStrokeColorResource(android.R.color.transparent);
        });
        difficulty6.setOnClickListener(v -> {
            difficulty = 6;
            difficulty4.setStrokeColorResource(android.R.color.transparent);
            difficulty5.setStrokeColorResource(android.R.color.transparent);
            difficulty6.setStrokeColorResource(R.color.colorWhite);
        });

        volumeON.setOnClickListener(v -> {
            volumeState = true;
            volumeON.setStrokeColorResource(R.color.colorWhite);
            volumeOFF.setStrokeColorResource(android.R.color.transparent);
        });
        volumeOFF.setOnClickListener(v -> {
            volumeState = false;
            volumeON.setStrokeColorResource(android.R.color.transparent);
            volumeOFF.setStrokeColorResource(R.color.colorWhite);
        });

        getGoalTime.setText(Config.GetGoalTime == 0 ? "暂未达成" : String.valueOf(Config.GetGoalTime));

        // 无限模式下游戏难度不可设置
        if (Config.CurrentGameMode == 1) {
            difficulty4.setStrokeColorResource(android.R.color.transparent);
            difficulty5.setStrokeColorResource(android.R.color.transparent);
            difficulty6.setStrokeColorResource(android.R.color.transparent);
            difficulty4.setEnabled(false);
            difficulty5.setEnabled(false);
            difficulty6.setEnabled(false);
        }
    }

    /**
     * 确认按钮点击
     */
    public ConfigDialog setOnPositiveClickListener(
            View.OnClickListener onPositiveClickListener) {
        this.onPositiveClickListener = onPositiveClickListener;
        return this;
    }

    /**
     * 获取选择的游戏难度
     */
    public int getSelectDifficulty() {
        return difficulty;
    }

    /**
     * 获取游戏音效状态
     */
    public boolean getVolumeState() {
        return volumeState;
    }
}
