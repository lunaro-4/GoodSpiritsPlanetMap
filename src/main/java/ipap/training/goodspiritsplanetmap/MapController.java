package ipap.training.goodspiritsplanetmap;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class MapController {

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;


    @FXML
    private VBox mainBox;

    @FXML
    private HBox subMainBox;


    @FXML
    protected void initialize(){
        Path p = new Path();
        p.getElements().add(new MoveTo(0.0f,0.0f));
        p.getElements().add(new LineTo(50.0f,0.0f));
        Path p2 = new Path();
        p2.getElements().add(new MoveTo(btn1.getLayoutX(), btn1.getLayoutY()));
        p2.getElements().add(new LineTo(btn2.getLayoutX(), btn2.getLayoutY()));
        System.out.println(btn1.getLayoutX() + "  "+ btn1.getLayoutY());
        System.out.println(btn1.getScaleX() + "  "+ btn1.getScaleY());
        System.out.println(btn1.getTranslateX() + "  "+ btn1.getTranslateY());
        System.out.println(btn2.getLayoutX() + "  "+ btn2.getLayoutY());
        System.out.println(btn2.getScaleX() + "  "+ btn2.getScaleY());
        System.out.println(btn2.getTranslateX() + "  "+ btn2.getTranslateY());
        subMainBox.getChildren().add(p);
        mainBox.getChildren().add(p);
    }

}



