public class Rect {
    public double x, y, w, h;
    public Rect(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    public Rect() {
        this(0, 0, 0, 0);
    }
    public boolean intersects(Rect other) {
        return x < other.x + other.w && x + w > other.x && y < other.y + other.h && y + h > other.y;
    }

    public boolean contains(double x, double y) {
        return x >= this.x && x <= this.x + this.w && y >= this.y && y <= this.y + this.h;
    }
}
