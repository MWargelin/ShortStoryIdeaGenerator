
package ssig;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class SSIG extends Application {
    
    private FileReader fr;
    
    @Override
    public void init() {
        this.fr = new FileReader();
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Short Story Idea Generator");
        
        BorderPane components = new BorderPane();
        components.setPadding(new Insets(10));

        //Welcome text
        Label welcome = new Label("Welcome to the short story idea generator!");
        welcome.setFont(Font.font("Monospaced", 20));
        welcome.setPadding(new Insets(10, 10, 0, 10));
        
        //Randomized words
        HBox words = new HBox();
        Label word1 = new Label("");
        Label word2 = new Label("");
        words.getChildren().add(word1);
        words.getChildren().add(word2);
        word1.setFont(Font.font("Monospaced", 30));
        word2.setFont(Font.font("Monospaced", 30));
        words.setPadding(new Insets(30, 30, 30, 30));
        words.setAlignment(Pos.CENTER);
        words.setPrefSize(300, 100);
        words.setSpacing(20);
        
        
        //The button
        Button button = new Button("Give me an idea!");
        button.setOnAction((event) -> {
            word1.setText(fr.getRandomWord());
            word2.setText(fr.getRandomWord());
        });
        button.setPadding(new Insets(10));
        
               
        components.setTop(welcome);
        components.setCenter(words);
        components.setBottom(button);
        
        Scene scene = new Scene(components);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
