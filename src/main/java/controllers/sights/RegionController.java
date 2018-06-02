package controllers.sights;

import controllers.sights.literature.LiteratureController;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class RegionController {
    private HBox mainHBox;
    private VBox sighsRegionVBox;
    private HBox literatureHBox;

    public RegionController(){
        mainHBox = new HBox();
        mainHBox.getStyleClass().add("region-hbox");
        sighsRegionVBox = new VBox();
        literatureHBox = new HBox();

        for (int i = 0; i<=6; i++){
            SightsController sightsController = new SightsController(i);
            sighsRegionVBox.getChildren().add(sightsController.getMainHBox());
        }

        mainHBox.getChildren().add(sighsRegionVBox);

        LiteratureController literature = new LiteratureController("vbox-literature");
        literatureHBox.getChildren().add(literature.getRoot());

        mainHBox.getChildren().add(literatureHBox);

    }
}
