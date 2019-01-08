import game.Vector2D;

public class Rectangle {
    Vector2D position;
    int width;
    int height;

    public Rectangle(float x, float y, int width, int height) {
        this.position = new Vector2D(x, y);
        this.width = width;
        this.height = height;
    }

    public float top() {
        return this.position.y;
    }

    public float bot() {
        return this.top() + height;
    }

    public float left() {
        return this.position.x;
    }

    public float right() {
        return this.left() + width;
    }

    public boolean intersected(Rectangle other) {
        return this.top() <= other.bot()
            && this.bot() >= other.top()
            && this.right() >= other.left()
            && this.left() <= other.right();
    }
}
