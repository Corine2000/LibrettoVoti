package it.polito.tdp.librettovoti;

import javafx.application.Application;
import static javafx.application.Application.launch;

import it.polito.tdp.libretto.model.Libretto;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class EntryPoint extends Application {

    @Override
    public void start(Stage stage) throws Exception {
    	
    	//FXMLLoader è un metodo statico gia implemento in javaFX che crea la scena 
    	/**
    	 * abbiamo fatto 3 modifiche di questa classe 
    	 * 1-abbiamo creato un oggetto della classe FXMLController
    	 * 2-un oggetto della classe Libretto che è il nostro model
    	 * 3-poi comunichiamo al nostro Controller il modello su cui deve lavorare 
    	 */
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));
        Parent root = loader.load();
        FXMLController controller = loader.getController(); //oggetto del classe della classe FXMLController
        
        Libretto model = new Libretto();
        controller.setModel(model);
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
