package pl.sdacademy.snake;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private Direction direction;
    private Piont head;
    private List<Piont> body;  //lista, bo ma dużo przydatnych metod

    public Snake(Piont head, List<Piont> body, Direction direction) {
        this.head = head;
        this.body = new ArrayList<>(body);
        this.direction = direction;

    }


    public void move(Snake snake) {
        body.add(0, head);

        switch (direction) {
            case UP:
                head = new Piont(head.getX(), head.getY() - 1);
                break;
            case RIGHT:
                head = new Piont(head.getX() + 1, head.getY());
                break;
            case DOWN:
                head = new Piont(head.getX(), head.getY() + 1);
                break;
            case LEFT:
                head = new Piont(head.getX() - 1, head.getY());
                break;

        }
//wąż utraci ogon
        body.remove(body.size() - 1);

    }
//    public boolean contains(Piont point){
//        return  head
//    }

    @Override
    public String toString() {
        return "Snake{" +
                "head=" + head +
                ", body=" + body +
                '}';
    }
}
