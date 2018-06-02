package core;

import controllers.sights.RegionController;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {

    @FXML
    MenuBar menuBar;

    @FXML
    VBox vBox;

    public void initialize(){

        for (int i = 0; i < 6; i++) {
            RegionController regions = new RegionController();
            vBox.getChildren().add(regions.getMainHBox());
        }
    }

}
