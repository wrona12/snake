package pl.sdacademy.snake;

//immutable - jak stworzymy instancje to nie bedzie mozna zmodyfikować
public class Piont {
    private int x;
    private int y;

    public Piont(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piont piont = (Piont) o;

        if (x != piont.x) return false;
        return y == piont.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
