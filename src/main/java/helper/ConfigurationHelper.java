package helper;


import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class ConfigurationHelper {

    public static void setAnchorConstrain(Node node,
                                          double top,
                                          double bottom,
                                          double left,
                                          double rigth){

        AnchorPane.setTopAnchor(node,top);
        AnchorPane.setRightAnchor(node, rigth);
        AnchorPane.setLeftAnchor(node, left);
        AnchorPane.setBottomAnchor(node, bottom);
    }
}
