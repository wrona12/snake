package pl.sdacademy.snake;

import java.awt.*;
import java.util.Random;

public class SnakeGame {
    private Snake snake;
    private int xBound;
    private int yBound;
    private Piont apple;

    public SnakeGame(Snake snake, int xBound, int yBound) {
        this.snake = snake;
        this.xBound = xBound;
        this.yBound = yBound;
    }

    public void start() {
        randomizeApple();
        while (isSnakeInBounds()) {
            snake.expand();
            if (apple.equals(snake.getHead())) {
                randomizeApple();
            } else {
                snake.cutTail();

            }

        }
    }


    //    private boolean isSnakeInBounds(){
//        Point head = snake.getHead();
//        int headX = head.getX();
//        int headY = head.getY();
//    }
    private void randomizeApple() {
        Random random = new Random();
        do {
            int appleX = random.nextInt(xBound);
            int appleY = random.nextInt(yBound);
        } while (snake.contains(apple));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int y=0; y<yBound;y++){
            for (int x=0;x<xBound;x++);
            Point point = new Point(x, y);
            if (point.equals(apple)) {
                stringBuilder.append('A');

            }else if(point.equals(snake.getHead())){
                stringBuilder.append('H')
            }else if(point.equals(snake.getHead())){
                stringBuilder.append('B')
            }else if(point.equals(snake.getHead())){
                stringBuilder.append('H')
            }
            }

        }
    }
}
