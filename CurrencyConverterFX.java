import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverterFX extends Application {

    @Override
    public void start(Stage stage) {

        TextField amountField = new TextField();
        amountField.setPromptText("Enter amount");

        ComboBox<String> fromCurrency = new ComboBox<>();
        ComboBox<String> toCurrency = new ComboBox<>();

        fromCurrency.getItems().addAll("USD", "INR", "EUR", "GBP", "JPY");
        toCurrency.getItems().addAll("USD", "INR", "EUR", "GBP", "JPY");

        fromCurrency.setValue("USD");
        toCurrency.setValue("INR");

        Button convertBtn = new Button("Convert");
        Label resultLabel = new Label("Converted Amount: ");

        convertBtn.setOnAction(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                String from = fromCurrency.getValue();
                String to = toCurrency.getValue();

                double result = getConvertedAmount(from, to, amount);
                resultLabel.setText("Converted Amount: " + result);

            } catch (Exception ex) {
                resultLabel.setText("Invalid Input");
            }
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        grid.add(new Label("Amount:"), 0, 0);
        grid.add(amountField, 1, 0);
        grid.add(new Label("From:"), 0, 1);
        grid.add(fromCurrency, 1, 1);
        grid.add(new Label("To:"), 0, 2);
        grid.add(toCurrency, 1, 2);
        grid.add(convertBtn, 1, 3);
        grid.add(resultLabel, 1, 4);

        Scene scene = new Scene(grid, 400, 300);
        stage.setTitle("Currency Converter");
        stage.setScene(scene);
        stage.show();
    }

    // API CALL + JSON PARSING
    private double getConvertedAmount(String from, String to, double amount) throws Exception {

        String urlStr = "https://api.exchangerate.host/convert?from=" + from + "&to=" + to + "&amount=" + amount;
        URL url = new URL(urlStr);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();

        while ((line = br.readLine()) != null) {
            response.append(line);
        }
        br.close();

        // Extract result value manually from JSON
        String json = response.toString();
        String key = "\"result\":";
        int index = json.indexOf(key);
        int start = index + key.length();
        int end = json.indexOf(",", start);

        return Double.parseDouble(json.substring(start, end));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
