package pl.sdacademy.snake;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Snake {
    private Point head;
    private List<Point> body;
    private Direction direction;

    public Snake(Point head, List<Point> body, Direction direction) {
        this.head = head;
        // TODO wywolanie konstruktora
        this.body = new ArrayList<>(body);
        this.direction = direction;
    }

    public Snake() {
        this(new Point(0, 0), Collections.emptyList(), Direction.RIGHT);
    }

    public void cutTail() {
        // wąż utraci ogon (ostatni punkt ciała)
        body.remove(body.size() - 1);
    }

    public void expand() {
        // stara głowa utworzy pierwszy punkt ciała węża
        body.add(0, head);
        // nowa głowa będzie nowym punktem - wynikiem przesunięcia starej głowy w kierunku ruchu węża
        head = head.neighbour(direction);
    }

    @Override
    public String toString() {
        return "Snake{" +
                "head=" + head +
                ", body=" + body +
                '}';
    }

    public Point getHead() {
        return head;
    }

    public List<Point> getBody() {
        return body;
    }

    public boolean contains(Point point) {
        return head.equals(point) || body.contains(point);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}