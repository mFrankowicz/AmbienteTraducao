package controllers.sights.sight;

import controllers.sights.SimpleItem;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Data
public class SightItemController extends SimpleItem {

    public SightItemController(String cssClass, double minWidth){
        super(cssClass, minWidth);
    }
}
