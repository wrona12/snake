package pl.sdacademy.snake;

import java.util.Random;

public class SnakeGame {
    private Snake snake;
    private int xBound;
    private int yBound;
    private Point apple;
    private int points;
    private Runnable drawingStrategy;

    public SnakeGame(Snake snake, int xBound, int yBound) {
        this.snake = snake;
        this.xBound = xBound;
        this.yBound = yBound;
    }

    public SnakeGame(int xBound, int yBound) {
        this(new Snake(), xBound, yBound);
    }

    public void setDrawingStrategy(Runnable drawingStrategy) {
        this.drawingStrategy = drawingStrategy;
    }

    public Snake getSnake() {
        return snake;
    }

    public Point getApple() {
        return apple;
    }

    public void start() {
        points = 0;
        randomizeApple();
        while (isSnakeInBounds()) {
            draw();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            snake.expand();
            if (apple.equals(snake.getHead())) {
                points++;
                randomizeApple();
            } else {
                snake.cutTail();
            }
        }
    }

    private void draw() {
        if (drawingStrategy != null) {
            drawingStrategy.run();
        }
    }

    private boolean isSnakeInBounds() {
        Point head = snake.getHead();
        int headX = head.getX();
        int headY = head.getY();
        return headX >= 0 && headX < xBound &&
                headY >= 0 && headY < yBound;
    }

    private void randomizeApple() {
        Random random = new Random();
        do {
            int appleX = random.nextInt(xBound);
            int appleY = random.nextInt(yBound);
            apple = new Point(appleX, appleY);
        } while (snake.contains(apple));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y = 0; y < yBound; y++) {
            for (int x = 0; x < xBound; x++) {
                char boardChar = boardCharacterAt(x, y);
                stringBuilder.append(boardChar);
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }

    private char boardCharacterAt(int x, int y) {
        Point point = new Point(x, y);
        if (point.equals(apple)) {
            return 'A';
        } else if (point.equals(snake.getHead())) {
            return 'H';
        } else if (snake.getBody().contains(point)) {
            return 'B';
        } else {
            return '*';
        }
    }

    public void setSnakeDirection(Direction direction) {
        snake.setDirection(direction);
    }
}
