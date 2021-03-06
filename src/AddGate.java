import  javafx.scene.control.Label;
import  javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import  javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.ComboBox;
/**
 * @class AddGate adding a new gate to a specific airport
 */
public class AddGate {
    protected static TextField textAreaGate = new TextField();
    protected static ComboBox<String> icao = new ComboBox<>();

    public static void  newGate() {
        GridPane gridPane = new GridPane();
        Stage stage = new Stage();
        SetStyles.creatWindow("ADDING A NEW GATE IN AN AIRPORT", 700,450, stage, gridPane);

        Label gateName = SetStyles.createLabels("Please enter gate name:", 1, 0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        SetStyles.setPosition(textAreaGate,2,0);
        Label airportcode = SetStyles.createLabels("Please pick airport ICAO:", 3,0,
                Paint.valueOf("black"), Font.font("Arial Rounded MT Bold", 22));
        icao.setPromptText("Airport ICAO");
        GridPane.setRowIndex(icao, 4);
        GridPane.setColumnIndex(icao, 0);
        javafx.collections.ObservableList<String> list = icao.getItems();

        Button okButton = new Button("OK");
        SetStyles.setStyleForButtons(okButton, 26, 30);
        okButton.setOnMouseClicked(event -> {
            try {
                CheckAddingInput.checkGate(textAreaGate,stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            CheckAddingInput.checkICAO(icao,stage);
        });

        gridPane.getChildren().addAll(textAreaGate,icao,gateName,airportcode,okButton);

    }
    public static String getGate() { return textAreaGate.getText(); }
    public static String getICAO() { return icao.getValue(); }
}
