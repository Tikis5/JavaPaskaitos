package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class Controller {

    @FXML
    private TextField insertedNumberTextField;
    @FXML
    private Label succsesMsgLabel;
    @FXML
    private Label succsesNumberLabel;
    @FXML
    private Label warningMsgLabel;
    @FXML
    private Label warningNumberLabel;

    public void guessLuckyNumber(ActionEvent event) {
        cleanUp();

        Random random = new Random();
        int numb = random.nextInt(10) + 1;
        try {
            int guessNumb = Integer.parseInt(insertedNumberTextField.getText());

            if (numb == guessNumb) {
                succsesMsgLabel.setText("You are lucky today :)");
                succsesNumberLabel.setText(String.valueOf(guessNumb));
            } else {
                warningMsgLabel.setText("Try again");
                warningNumberLabel.setText(String.valueOf(numb));
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("This is not a number, please try again!");
            alert.show();
        }
        insertedNumberTextField.setText("");
    }

    private void cleanUp() {
        succsesNumberLabel.setText("");
        succsesMsgLabel.setText("");
        warningNumberLabel.setText("");
        warningMsgLabel.setText("");
    }
}
