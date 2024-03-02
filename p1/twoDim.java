package p1;

public class twoDim {
    private int x;
    private int y;

    public twoDim() {
        x = 0;
        y = 0;
    }

    public twoDim(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return x + "" + y;
    }
}
