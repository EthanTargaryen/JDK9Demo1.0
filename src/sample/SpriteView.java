package sample;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.Serializable;

import static java.lang.StrictMath.PI;

public class SpriteView extends ImageView implements Serializable {

    public void setOrientAngle(double orientAngle) {
        this.orientAngle = orientAngle;
    }

    private double orientAngle;

    private double orgSceneX, orgSceneY, orgTranslateX, orgTranslateY;

    SpriteView(Image image)
    {
        super(image);
        setPreserveRatio(true);
        setFitHeight(169.0);
        setPickOnBounds(true);
        this.setLayoutX(0);
        this.setLayoutY(0);
        this.setTranslateX(100);
        this.setTranslateY(50);
        this.setOnMousePressed(event -> onMousePressed(event));
        this.setOnMouseDragged(event -> onMouseDragged(event));
        //setViewport(new Rectangle2D(600,650,600,650));
        orientAngle = 0;
    }

    void rotateDegree(double degree)
    {
        orientAngle += degree*PI/180.0;
    }

    public double getOrientAngle() {
        return orientAngle;
    }

    public void onMousePressed(MouseEvent me)
    {
        orgSceneX = me.getSceneX();
        orgSceneY = me.getSceneY();

        System.out.println("It happened at " + orgSceneX + "," + orgSceneY );

        orgTranslateX = this.getTranslateX();
        orgTranslateY = this.getTranslateY();
    }

    public void onMouseDragged(MouseEvent me)
    {

        double newTranslateX = orgTranslateX + me.getSceneX() - orgSceneX;
        double newTranslateY = orgTranslateY + me.getSceneY() - orgSceneY;

        ((ImageView)(me.getSource())).setTranslateX(newTranslateX);
        ((ImageView)(me.getSource())).setTranslateY(newTranslateY);

        System.out.println("Source image is at " + this.getTranslateX() + "," + this.getTranslateY());
        System.out.println(" In Parent at " + this.getBoundsInParent());
        System.out.println(" In Local  at " + this.getBoundsInLocal());
    }

    /*
    <children>
            <ImageView fx:id="imageView" fitHeight="169.0" fitWidth="228.0" pickOnBounds="true" preserveRatio="true" />
    </children>
     */
}
