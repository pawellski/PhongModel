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

    @FXML
    private Canvas canvas;

    public void initialize() {
        prepareBackground();
        prepareInitialPhong();
    }

    @FXML
    public void recognizeOperation(KeyEvent k) {

        String key = k.getCode().toString();
        switch (key) {
            case "W":
                System.out.println(key);
                break;
            case "S":
                System.out.println(key);
                break;
            case "A":
                System.out.println(key);
                break;
            case "D":
                System.out.println(key);
                break;
            default:
                break;
        }
    }

    public void focus() {
        canvas.requestFocus();
    }

    private void prepareBackground() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 800, 800);
        map = canvas.getGraphicsContext2D();
        map.setFill(Color.DARKORANGE);
        map.fillOval(200, 200, 400, 400);
        
    }

    private void prepareInitialPhong() {
        surface = new Surface(0.25, 0.75, 25);
        PhongShading.phongAlgoritm(map, surface);
    }

}
