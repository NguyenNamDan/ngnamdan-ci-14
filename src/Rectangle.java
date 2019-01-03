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

    public boolean intersected(Rectangle other) {
        if((this.position.x + this.width < other.position.x) ||
                (other.position.x + other.width < this.position.x)) {
            return false;
        }
        else {
            if((this.position.y + this.height < other.position.y) ||
                    (other.position.y + other.height < this.position.y)) {
                return false;
            }
            else return true;
        }
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(0,0,4,4);
        Rectangle rect2 = new Rectangle(5,5,4,4);
        Rectangle rect3 = new Rectangle(2,2,4,4);
        Rectangle rect4 = new Rectangle(3,5,2,2);
        System.out.println(rect1.intersected(rect2)); // false
        System.out.println(rect1.intersected(rect3)); // true
        System.out.println(rect2.intersected(rect3)); // true
        System.out.println(rect1.intersected(rect4)); // false
    }
}
