package kylec.me.g2048.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import kylec.me.g2048.R;
import kylec.me.g2048.app.Config;
import kylec.me.g2048.app.Constant;

/**
 * 小格子
 * <p>
 * Created by KYLE on 2018/10/2
 */
public class Cell extends FrameLayout {

    /**
     * 显示数字的TextView
     */
    private final TextView cellShowText;

    /**
     * 显示的数字
     */
    private int digital;

    public Cell(Context context) {
        super(context);
        cellShowText = new TextView(context);
        // 不同难度设置不同字体大小
        if (Config.CurrentGameMode == Constant.MODE_INFINITE) {
            cellShowText.setTextSize(20);
        } else {
            switch (Config.GRIDColumnCount) {
                case 5:
                    cellShowText.setTextSize(28);
                    break;
                case 6:
                    cellShowText.setTextSize(20);
                    break;
                default:
                    cellShowText.setTextSize(36);
                    break;
            }
        }
        cellShowText.setGravity(Gravity.CENTER);
        // 抗锯齿
        cellShowText.getPaint().setAntiAlias(true);
        // 粗体
        cellShowText.getPaint().setFakeBoldText(true);
        // 颜色
        cellShowText.setTextColor(ContextCompat.getColor(context, R.color.colorWhiteDim));
        // 背景
        cellShowText.setBackgroundResource(R.drawable.bg_cell);
        // 填充整个父容器
        LayoutParams params = new LayoutParams(-1, -1);
        params.setMargins(dp2px(), dp2px(), 0, 0);
        addView(cellShowText, params);
        setDigital(0);
    }

    /**
     * 获取卡片
     */
    public TextView getItemCell() {
        return cellShowText;
    }

    /**
     * 获取数字
     */
    public int getDigital() {
        return digital;
    }

    /**
     * 设置数字
     */
    public void setDigital(int digital) {
        this.digital = digital;
        cellShowText.setBackgroundTintList(ColorStateList.valueOf(getBackgroundColor(digital)));
        if (digital <= 0) {
            cellShowText.setText("");
        } else {
            cellShowText.setText(String.valueOf(digital));
        }
    }

    /**
     * 根据数字获取相应的背景
     *
     * @return 相应的背景
     */
    private int getBackgroundColor(int number) {
        switch (number) {
            case 0:
                return ContextCompat.getColor(getContext(), R.color.cell_0);
            case 2:
                return ContextCompat.getColor(getContext(), R.color.cell_2);
            case 4:
                return ContextCompat.getColor(getContext(), R.color.cell_4);
            case 8:
                return ContextCompat.getColor(getContext(), R.color.cell_8);
            case 16:
                return ContextCompat.getColor(getContext(), R.color.cell_16);
            case 32:
                return ContextCompat.getColor(getContext(), R.color.cell_32);
            case 64:
                return ContextCompat.getColor(getContext(), R.color.cell_64);
            case 128:
                return ContextCompat.getColor(getContext(), R.color.cell_128);
            case 256:
                return ContextCompat.getColor(getContext(), R.color.cell_256);
            case 512:
                return ContextCompat.getColor(getContext(), R.color.cell_512);
            case 1024:
                return ContextCompat.getColor(getContext(), R.color.cell_1024);
            case 2048:
                return ContextCompat.getColor(getContext(), R.color.cell_2048);
            default:
                return ContextCompat.getColor(getContext(), R.color.cell_default);
        }
    }

    private int dp2px() {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (12 * scale + 0.5f);
    }
}
