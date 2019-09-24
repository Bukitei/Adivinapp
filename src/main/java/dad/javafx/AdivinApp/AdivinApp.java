package dad.javafx.AdivinApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {

	private TextField numeroText;
	private Button comprobarButton;
	private Label condicionLabel;
	private int counter = 0;
	private int number = (int) (Math.random() * 100 + 1);

	public void start(Stage primaryStage) throws Exception {

		numeroText = new TextField();
		numeroText.setPromptText("Introduce un número");
		numeroText.setMaxWidth(150);

		comprobarButton = new Button();
		comprobarButton.setText("Comrpobar");
		comprobarButton.setDefaultButton(true);
		comprobarButton.setOnAction(a -> onCheckNumberAction(a));

		condicionLabel = new Label("Introduce un número del 1 al 100");

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(condicionLabel, numeroText, comprobarButton);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setTitle("AdivinApp funcional");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
		
	}

	private void onCheckNumberAction(ActionEvent a) {

		try {
			int numberU = Integer.parseInt(numeroText.getText());
			counter++;
			
			if (number > numberU) {
				Alert alertF = new Alert(AlertType.WARNING);
				alertF.setHeaderText("¡Has fallado!");
				alertF.setContentText("El número a adivinar es mayor que " + numberU + ".\n\nVuelve a intentarlo.");
				alertF.showAndWait();
			} else if (number < numberU) {
				Alert alertF = new Alert(AlertType.WARNING);
				alertF.setHeaderText("¡Has fallado!");
				alertF.setContentText("El número a adivinar es menor que " + numberU + ".\n\nVuelve a intentarlo.");
				alertF.showAndWait();
			} else {
				Alert alertW = new Alert(AlertType.INFORMATION);
				alertW.setHeaderText("¡Has ganado!");
				alertW.setContentText("Sólo has necesitado " + counter + " intentos.\n\nVuelve a jugar y hazlo mejor.");
				alertW.showAndWait();
			}

		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Error");
			alert.setContentText("El número introducido no es válido.");

			alert.showAndWait();
		}
	}
}
