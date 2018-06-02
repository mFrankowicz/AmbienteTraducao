package controllers.sights;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lombok.Data;

@Data
public class SimpleItem extends BaseItem {

    private AnchorPane root;
    private TextField textField;

    public SimpleItem(String cssClass, double minWidth){
        root = new AnchorPane();
        root.getStyleClass().add(cssClass);

        textField = new TextField();

        root.getChildren().add(textField);
        AnchorPane.setBottomAnchor(textField, 0.);
        AnchorPane.setLeftAnchor(textField, 0.);
        AnchorPane.setRightAnchor(textField, 0.);
        AnchorPane.setTopAnchor(textField, 0.);

        root.setMinWidth(minWidth);
    }

    public void setTextFieldPadding(double top, double right, double bottom, double left){
        textField.setPadding(new Insets(top,right,bottom,left));
    }
}
