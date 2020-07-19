package pl.sdacademy.snake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Point head = new Point(3, 3);
        List<Point> body = Arrays.asList(
                new Point(3, 2),
                new Point(3, 1),
                new Point(2, 1)
        );
        Snake snake = new Snake(head, body, Direction.RIGHT);

        SnakeGame snakeGame = new SnakeGame(snake, 10, 10);
        snakeGame.setDrawingStrategy(() -> System.out.println(snakeGame));

        Thread userCommandThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String userInput = scanner.nextLine();
                switch (userInput) {
                    case "u":
                        snakeGame.setSnakeDirection(Direction.UP);
                        break;
                    case "r":
                        snakeGame.setSnakeDirection(Direction.RIGHT);
                        break;
                    case "d":
                        snakeGame.setSnakeDirection(Direction.DOWN);
                        break;
                    case "l":
                        snakeGame.setSnakeDirection(Direction.LEFT);
                        break;
                }
            }
        });
        userCommandThread.setDaemon(true);
        userCommandThread.start();

        snakeGame.start();
    }
}
