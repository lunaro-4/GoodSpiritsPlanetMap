module ipap.training.goodspiritsplanetmap {
    requires javafx.controls;
    requires javafx.fxml;


    opens ipap.training.goodspiritsplanetmap to javafx.fxml;
    exports ipap.training.goodspiritsplanetmap;
}