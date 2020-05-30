package controller;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import logic.PhongShading;
import logic.Surface;

public class Controller {

    private GraphicsContext map;
    private Surface surface;
    private Color color;

    @FXML
    private Canvas canvas;

    public void initialize() {
        color = Color.SADDLEBROWN;
        surface = new Surface(0.4, 0.75, 0.25, 5);
        prepareBackground();
        PhongShading.phongAlgoritm(map, surface);
    }

    @FXML
    public void recognizeOperation(KeyEvent k) {

        String key = k.getCode().toString();
        switch (key) {
            case "W":
                PhongShading.moveUp();
                break;
            case "S":
                PhongShading.moveDown();
                break;
            case "A":
                PhongShading.moveLeft();
                break;
            case "D":
                PhongShading.moveRight();
                break;
            case "Z":
                PhongShading.moveForward();
                break;
            case "X":
                PhongShading.moveBackward();
                break;
            case "DIGIT1":
                color = Color.SADDLEBROWN;
                surface = new Surface(0.4, 0.75, 0.25, 5);
                break;
            case "DIGIT2":
                color = Color.WHITE;
                surface = new Surface(0.05, 0.5, 0.7, 0.078125);
                break;
            case "DIGIT3":
                color = Color.SADDLEBROWN;
                surface = new Surface(0.4, 0.25, 0.75, 100);
                break;
            case "DIGIT4":
                color = Color.TURQUOISE;
                surface = new Surface(0.4, 0.75, 0.25, 5);
                break;
            default:
                break;
        }
        prepareBackground();
        PhongShading.phongAlgoritm(map, surface);
    }

    public void focus() {
        canvas.requestFocus();
    }

    private void prepareBackground() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 500, 500);
        map = canvas.getGraphicsContext2D();
        map.setFill(color);
        map.fillOval(100, 100, 300, 300);
    }

}
