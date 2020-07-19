package pl.sdacademy.snake.ui.javafx;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import pl.sdacademy.snake.Direction;
import pl.sdacademy.snake.Point;
import pl.sdacademy.snake.Snake;
import pl.sdacademy.snake.SnakeGame;

public class Controller {
        private static final int POINT_SIZE = 20;

        @FXML
        private Canvas canvas;

        @FXML
        private Button btnUp;

        @FXML
        private Button btnLeft;

        @FXML
        private Button btnRight;

        @FXML
        private Button btnDown;

        public void initialize() {
                int xBound = (int) canvas.getWidth() / POINT_SIZE;
                int yBound = (int) canvas.getHeight() / POINT_SIZE;
                SnakeGame snakeGame = new SnakeGame(xBound, yBound);
                snakeGame.setDrawingStrategy(() -> {
                        GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
                        graphicsContext2D.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                        Snake snake = snakeGame.getSnake();
                        drawPoint(snake.getHead(), Color.RED);
                        snake.getBody()
                                .forEach(point -> drawPoint(point, Color.DARKRED));
                        drawPoint(snakeGame.getApple(), Color.GREEN);
                });
                Thread thread = new Thread(snakeGame::start);
                thread.start();

                btnUp.setOnAction(event -> snakeGame.setSnakeDirection(Direction.UP));
                btnRight.setOnAction(event -> snakeGame.setSnakeDirection(Direction.RIGHT));
                btnDown.setOnAction(event -> snakeGame.setSnakeDirection(Direction.DOWN));
                btnLeft.setOnAction(event -> snakeGame.setSnakeDirection(Direction.LEFT));
        }

        private void drawPoint(Point point, Color color) {
                GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
                graphicsContext2D.setFill(color);
                graphicsContext2D.fillRect(
                        point.getX() * POINT_SIZE,
                        point.getY() * POINT_SIZE,
                        POINT_SIZE,
                        POINT_SIZE);
        }
}
