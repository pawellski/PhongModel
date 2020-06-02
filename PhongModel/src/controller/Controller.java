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
        surface = new Surface(0.4, 0.75, 0.25, 10);
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
                // KULKA MIEDZIANA
                color = Color.SADDLEBROWN;
                surface = new Surface(0.4, 0.75, 0.25, 10);
                break;
            case "DIGIT2":
                // KULKA PLASTIKOWA
                color = Color.RED;
                surface = new Surface(0.4, 0.6, 0.4, 10);
                break;
            case "DIGIT3":
                // KULKA DREWNIANA
                color = new Color(94.0/255, 41.0/255, 12.0/255, 1.0);
                surface = new Surface(0.4, 0.7, 0.3, 3);
                break;
            case "DIGIT4":
                //KULKA MATERIAŁOWA
                color = Color.DARKSLATEGREY;
                surface = new Surface(0.4, 0.75, 0.25, 3);
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
