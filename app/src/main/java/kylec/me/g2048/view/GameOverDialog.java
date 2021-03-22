package kylec.me.g2048.view;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.util.Objects;

import kylec.me.g2048.R;

/**
 * 游戏结束对话框
 * <p>
 * Created by KYLE on 2018/10/6.
 */
public class GameOverDialog extends Dialog {

    private String finalScore;
    private String title;

    private View.OnClickListener onShareClickListener;
    private View.OnClickListener onGoOnClickListener;

    public GameOverDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_game_over);

        setCancelable(true);
        setCanceledOnTouchOutside(true);

        Objects.requireNonNull(getWindow()).setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView title = findViewById(R.id.tv_custom_title);
        TextView finalScore = findViewById(R.id.tv_final_score);
        MaterialButton share = findViewById(R.id.tv_share);
        MaterialButton goOn = findViewById(R.id.tv_go_on);
        if (onShareClickListener != null) {
            share.setOnClickListener(onShareClickListener);
        }
        if (onGoOnClickListener != null) {
            goOn.setOnClickListener(onGoOnClickListener);
        }
        if (!TextUtils.isEmpty(this.finalScore)) {
            finalScore.setText(this.finalScore);
        }
        if (!TextUtils.isEmpty(this.title)) {
            title.setText(this.title);
        }
    }

    public GameOverDialog setOnShareClickListener(
            View.OnClickListener onShareClickListener) {
        this.onShareClickListener = onShareClickListener;
        return this;
    }

    public GameOverDialog setOnGoOnClickListener(
            View.OnClickListener onGoOnClickListener) {
        this.onGoOnClickListener = onGoOnClickListener;
        return this;
    }

    /**
     * 设置最终得分
     */
    public GameOverDialog setFinalScore(String finalScore) {
        this.finalScore = finalScore;
        return this;
    }

    /**
     * 设置标题
     */
    public GameOverDialog setTitle(String title) {
        this.title = title;
        return this;
    }
}
