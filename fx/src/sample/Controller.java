package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private Label myDummyLable;
    @FXML
    private TextField inputTextField;
    @FXML
    private TextField vardasTextField;
    @FXML
    private TextField pavardeTextField;
    @FXML
    private Label infoLable;

    public void sayHello(ActionEvent event){
        String vardas = vardasTextField.getText();
        String pavarde = pavardeTextField.getText();
        if (isNotBlank(vardas) && isNotBlank(pavarde)){
            infoLable.setText(String.format("Hello %s %s", vardas, pavarde));
            vardasTextField.setText("");
            pavardeTextField.setText("");

        }
    }
    private boolean isNotBlank(String value){
        return value != null && value.length()>0;
    }

    public void changeLableText(ActionEvent event) {
        String input = inputTextField.getText();
        if (input != null && input.length() > 0) {
            myDummyLable.setText(input);
            inputTextField.setText("");
        } else {
            myDummyLable.setText("This lable changed!");
        }
    }
}
