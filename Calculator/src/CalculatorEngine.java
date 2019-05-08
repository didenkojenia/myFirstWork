import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CalculatorEngine implements ActionListener {
    calculator parent;
    char selectedAction = ' '; // + - * /
    double currentResult = 0;
    CalculatorEngine(calculator parent){
        this.parent = parent;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        JButton clickedButton = (JButton)e.getSource();
        String dispFieldText = parent.displayField.getText();
        double displayValue = 0;
        if(!"".equals(dispFieldText)){
            displayValue = Double.parseDouble(dispFieldText);
        }
        Object src = e.getSource();
        if (src == parent.buttonPlus){
            selectedAction = '+';
            currentResult = displayValue;
            parent.displayField.setText("");
        }else if (src ==parent.buttonMinus){
            selectedAction ='-';
            currentResult = displayValue;
            parent.displayField.setText("");
        }
        else if (src == parent.buttonDivide){
            selectedAction = '/';
            currentResult = displayValue;
            parent.displayField.setText("");
        }else if (src == parent.buttonMultyply){
            selectedAction = '*';
            currentResult = displayValue;
            parent.displayField.setText("");
        }else if (src == parent.buttonEqual){
            if(selectedAction=='+')
            currentResult += displayValue;
            parent.displayField.setText("" + currentResult);
        }else if(selectedAction=='-'){
            currentResult -= displayValue;
            parent.displayField.setText(""+currentResult);
        }else if(selectedAction=='/'){
            currentResult /= displayValue;
            parent.displayField.setText(""+currentResult);
        }else if(selectedAction=='*'){
            currentResult *= displayValue;
            parent.displayField.setText(""+currentResult);
        }
          else {
              String clickedButtonLabel = clickedButton.getText();
              parent.displayField.setText(dispFieldText+clickedButtonLabel);
        }
        String clickedButtonLabel = clickedButton.getText();
        parent.displayField.setText(dispFieldText + clickedButtonLabel);
    }
}
