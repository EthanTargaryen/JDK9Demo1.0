package sample;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CodeAnchorBox extends VBox implements java.io.Serializable {

    CodeAnchorBox(){
        setPrefHeight(5657);
        setPrefWidth(220);
        setSpacing(20);
    }

    CodeAnchorBox(double spacing){
        super(spacing);
        setPrefHeight(5657);
        setPrefWidth(220);
    }

    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException{
        for(Node p :getChildren()){
            if(p.getClass().toString().contains("CodeBox"))
                out.writeObject(p);
        }
    }

    private void readObject(java.io.ObjectInputStream in)
        throws IOException, java.lang.ClassNotFoundException{
        CodeBox c = new CodeBox();
        try{
            while(true){
                c = (CodeBox) in.readObject();
                getChildren().add(c);
            }
        } catch (Exception e){
            System.out.println("While writing codeAnchorBox, exception caught: " + e);
        }
        setSpacing(40);
    }
}
