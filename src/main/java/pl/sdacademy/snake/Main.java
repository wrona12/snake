package pl.sdacademy.snake;

import java.util.Arrays;
import java.util.List;

//import static pl.sdacademy.snake.Direction.RIGHT;

public class Main {
    public static void main(String[] args) {
        Piont head = new Piont(3, 3);
        List<Piont> body = Arrays.asList(
                new Piont(3, 2),
                new Piont(3, 1),
                new Piont(2, 1)

        );

        Snake snake = new Snake(head, body, Direction.RIGHT);
        Snake snakeGame = new SnakeGame(snake, 10, 10);
    }
}
