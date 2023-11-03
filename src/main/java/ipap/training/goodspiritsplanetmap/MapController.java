package ipap.training.goodspiritsplanetmap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MapController {

    private final int Y_PADDING = 120;
    private final int X_PADDING = 120;
    private final int BTN_SIDE = 40;



    @FXML
    private Label debugText;


    @FXML
    private TextField fileField;

    @FXML
    private Button readFromFile;

    @FXML
    private AnchorPane mainBox;

    @FXML
    private AnchorPane subPane;


    private HashMap<String, Button> nameToButton = new HashMap<>();
    private int maxNodesInLayer;


    @FXML
    protected void initialize() {
    }

    private void drawLayer(double yBase,double xBase, Layer layer){
        for (int i =0; i< layer.nodeList.length;i++) {
            Button b = new Button(""+(layer.index+1)+"."+(i+1));
            b.setLayoutX(xBase + X_PADDING*i);
            b.setLayoutY(yBase);
            b.setMinSize(BTN_SIDE,BTN_SIDE);
//            b.setPrefHeight(BTN_SIDE);
            b.setId(b.getText());
            subPane.getChildren().add(b);
            nameToButton.put(b.getText(),b);
        }

    }

    private void drawGraph(Layer[] nodeMap){
        for (int i = 0; i < nodeMap.length; i++) {
            drawLayer((nodeMap.length-1)*Y_PADDING-i*Y_PADDING,X_PADDING,nodeMap[i]);
        }
        Layer layer = new Layer(new Node[]{new Node(new ArrayList<>(),0)}, -1);
        drawLayer(nodeMap.length*Y_PADDING,X_PADDING+ X_PADDING/2,layer);
        subPane.layout();
        HashMap<Integer, String> indexToName = Ivanushka.getDict(nodeMap)[1];
        int[][] nodemap2 = Ivanushka.convert2(nodeMap);
        for (int i = 0; i < nodemap2.length; i++) {
            for (int j = 0; j < nodemap2[i].length; j++) {
                if (nodemap2[i][j] != 99999) {
                    subPane.getChildren().add(
                            drawPath(nameToButton.get(indexToName.get(i)),nameToButton.get(indexToName.get(j))));
                }

            }
        }

    }

    @FXML
    void readFromFile(ActionEvent event) {
        subPane.getChildren().clear();
        try {
            Layer[] nodeMap = Ivanushka.readFromFile(fileField.getText());
            maxNodesInLayer= getMaxNodesInLayer(nodeMap);
            drawGraph(nodeMap);
        } catch (IOException e){
            debugText.setText("FileNotFound");
        }
    }

    private int getMaxNodesInLayer(Layer[] nodeMap){
        int maxNodes=-1;
        for (Layer l :
                nodeMap) {
                if(l.nodeList.length>maxNodes)
                    maxNodes=l.nodeList.length;
            }
        return maxNodes;
        }




    private Path drawPath(Button b1, Button b2){
        Path p = new Path();
        p.getElements().add(new MoveTo(b1.getLayoutX()+BTN_SIDE/2, b1.getLayoutY()));
        p.getElements().add(new LineTo(b2.getLayoutX()+BTN_SIDE/2, b2.getLayoutY()+BTN_SIDE));
        p.setId(b1.getId()+" "+b2.getId());
        return p;
    }

}



