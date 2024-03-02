package p2;

import p1.*;

public class threeDim extends twoDim {
    private int z;

    public threeDim() {
        super();
        z = 0;
    }

    public threeDim(int x, int y, int z) {
        this.z = z;
    }

    public String toString() {
        return super.toString() + "" + z;
    }
}
