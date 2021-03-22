package kylec.me.game2048.db;

import androidx.annotation.NonNull;

/**
 * Created by KYLE on 2019/5/3 - 15:34
 */
public class CellEntity {

    private int x;
    private int y;
    private int num;

    public CellEntity(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNum() {
        return num;
    }

    @NonNull
    @Override
    public String toString() {
        return "(" + x + "," + y + ")" + num + "\n";
    }
}
