package core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Main extends Application {

    private ConfigurableApplicationContext springContext;
    private Parent rootNode;


    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(Main.class);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainInterface.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        rootNode = fxmlLoader.load();
        rootNode.getStylesheets().add("CSS/translationController.css");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Ambiente Tradução 0.1");
        primaryStage.setScene(new Scene(rootNode, 1200, 700));
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
        springContext.close();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
