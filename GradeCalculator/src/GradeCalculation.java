import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class GradeCalculation {

    public String result(JPanel panel) {
        Component[] components = panel.getComponents();
        int count = 0;
        int sum = 0;

        for (Component component : components) {
            if (component instanceof JTextField && component.isVisible()) {
                try {
                    count++;
                    sum += Integer.parseInt(((JTextField) component).getText());
                } catch (NumberFormatException e) {
                    // Handle the case where the text is not a valid integer
                    return "Invalid input. Please enter valid integer marks.";
                }
            }
        }

        if (count == 0) {
            return "No valid marks found.";
        }
        count/=2;
        float avg_percentage = (float) sum / count; // Corrected calculation
        String Grade = "";

        if (avg_percentage <= 40) {
            Grade = "U";
        } else if (avg_percentage > 40 && avg_percentage <= 55) {
            Grade = "C";
        } else if (avg_percentage > 55 && avg_percentage <= 75) {
            Grade = "B";
        } else if (avg_percentage > 75 && avg_percentage <= 85) {
            Grade = "A";
        } else if (avg_percentage > 85 && avg_percentage <= 95) {
            Grade = "A+";
        } else {
            Grade = "O";
        }

        return "Average Percentage is: " + avg_percentage + ", Your Grade is: " + Grade + ", Total Mark is: " + sum + "/" + (count * 100);
    }
}
