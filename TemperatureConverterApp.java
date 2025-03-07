import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterApp {
    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("Temperature Converter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Input Label and Field
        JLabel inputLabel = new JLabel("Enter Temperature:");
        inputLabel.setBounds(50, 30, 150, 30);
        frame.add(inputLabel);

        JTextField inputField = new JTextField();
        inputField.setBounds(200, 30, 100, 30);
        frame.add(inputField);

        // Scale Selection
        JLabel scaleLabel = new JLabel("Convert From:");
        scaleLabel.setBounds(50, 80, 150, 30);
        frame.add(scaleLabel);

        String[] scales = {"Celsius", "Fahrenheit", "Kelvin"};
        JComboBox<String> fromScale = new JComboBox<>(scales);
        fromScale.setBounds(200, 80, 100, 30);
        frame.add(fromScale);

        JLabel toScaleLabel = new JLabel("Convert To:");
        toScaleLabel.setBounds(50, 130, 150, 30);
        frame.add(toScaleLabel);

        JComboBox<String> toScale = new JComboBox<>(scales);
        toScale.setBounds(200, 130, 100, 30);
        frame.add(toScale);

        // Convert Button
        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(50, 180, 100, 30);
        frame.add(convertButton);

        // Result Label
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(200, 180, 150, 30);
        frame.add(resultLabel);

        // Button Action
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double inputTemp = Double.parseDouble(inputField.getText());
                    String from = (String) fromScale.getSelectedItem();
                    String to = (String) toScale.getSelectedItem();
                    double result = 0.0;

                    // Conversion Logic
                    if (from.equals("Celsius") && to.equals("Fahrenheit")) {
                        result = TemperatureConverter.celsiusToFahrenheit(inputTemp);
                    } else if (from.equals("Celsius") && to.equals("Kelvin")) {
                        result = TemperatureConverter.celsiusToKelvin(inputTemp);
                    } else if (from.equals("Fahrenheit") && to.equals("Celsius")) {
                        result = TemperatureConverter.fahrenheitToCelsius(inputTemp);
                    } else if (from.equals("Fahrenheit") && to.equals("Kelvin")) {
                        result = TemperatureConverter.fahrenheitToKelvin(inputTemp);
                    } else if (from.equals("Kelvin") && to.equals("Celsius")) {
                        result = TemperatureConverter.kelvinToCelsius(inputTemp);
                    } else if (from.equals("Kelvin") && to.equals("Fahrenheit")) {
                        result = TemperatureConverter.kelvinToFahrenheit(inputTemp);
                    } else {
                        result = inputTemp; // If same scale
                    }

                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number!");
                }
            }
        });

        // Display Frame
        frame.setVisible(true);
    }
}
