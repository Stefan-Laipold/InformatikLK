// mit import werden bibliotheken für befehle importiert
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
// public = jede beliebige Klasse darf auf Merkmale zugreifen
public class Taschenrechner // Klasse wird erstellt
{
   public static void main(String[] args)
   { // Frame wird erstellt
      CalculatorFrame frame = new CalculatorFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // beendet das Programm beim schließen des Fensters
      frame.setVisible(true);  // macht das Fenser sichtbar 
      frame.setSize( 400, 350); // Fenstergröße
   }
} // bis hierhin sieht man das Grundgerüst
 
class CalculatorFrame extends JFrame
{
   public CalculatorFrame()
   { // Panel wird erstellt
      setTitle("Taschenrechner");
      CalculatorPanel panel = new CalculatorPanel();
      add(panel);
      pack();
   }
}
 
class CalculatorPanel extends JPanel
{
   public CalculatorPanel()
   {
      setLayout(new BorderLayout());
 
      result = 0;
      lastCommand = "=";
      start = true;

 
      display = new JButton("0");
      display.setEnabled(false);
      add(display, BorderLayout.NORTH); // das Display ist oben(Norden)
 
      ActionListener insert = new InsertAction(); 
      ActionListener command = new CommandAction(); 
 
      panel = new JPanel(); // Untergrund wird erstellt 
      panel.setLayout(new GridLayout(4, 4)); // Layout besteht aus 4x4 Kästchen
      // insert = trägt Werte ein ; command = Befehl
      addButton("7", insert);   //Zeile 1, Spalte 1
      addButton("8", insert);   //Zeile 1, Spalte 2
      addButton("9", insert);   //Zeile 1, Spalte 3
      addButton("+", command);  //Zeile 1, Spalte 4
 
      addButton("4", insert);  // Zeile 2, Spalte 1
      addButton("5", insert);  // Zeile 2, Spalte 2
      addButton("6", insert);  // Zeile 2, Spalte 3
      addButton("-", command); // Zeile 2, Spalte 4
 
      addButton("1", insert);  // Zeile 3, Spalte 1
      addButton("2", insert);  // Zeile 3, Spalte 2
      addButton("3", insert);  // Zeile 3, Spalte 3
      addButton("*", command); // Zeile 3, Spalte 4
 
      addButton("0", insert);  // Zeile 4, Spalte 1
      addButton(".", insert);  // Zeile 4, Spalte 2
      addButton("=", command); // Zeile 4, Spalte 3
      addButton("/", command); // Zeile 4, Spalte 4
      
 
      add(panel, BorderLayout.CENTER); // mittig positioniert
   }
 
   private void addButton(String label, ActionListener listener)
   {
      JButton button = new JButton(label);
      button.addActionListener(listener);
      panel.add(button); // button auf Panel packen
   }
   
 // Das Display soll die Werte anzeigen
   private class InsertAction implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      { // Beim Start keinen Text anzeigen
         String input = event.getActionCommand();
         if (start)
         {
            display.setText("");
            start = false;
         }
         display.setText(display.getText() + input); // Eingegebene Werte werden angezeigt
      }
   }
 
   /**
    * Diese Aktion führt den mit der Taste verbundenen
    * Befehl aus. 
    */
   private class CommandAction implements ActionListener
   {
      public void actionPerformed(ActionEvent event)
      {
         String command = event.getActionCommand();
 
         // hier wird "-" davor gesetzt wenn die Zahl negativ ist
         if (start)
         {
            if (command.equals("-"))
            {
               display.setText(command);
               start = false;
            }
            else
               lastCommand = command;
         }
         else
         {
            // Berechnung ausführen
            calculate(Double.parseDouble(display.getText()));
            lastCommand = command;
            start = true;
         }
      }
   }
 
   
    // Führt die anstehenden Berechnungen aus
    
   public void calculate(double x) // double = mathematischer wert mit kommastellen
   {  // x = Ergebnis ; betätigen der Knöpfe (+, -, *, /, = ) -> Ergebnis wird angezeigt
      if (lastCommand.equals("+")) result += x;
      else if (lastCommand.equals("-")) result -= x;
      else if (lastCommand.equals("*")) result *= x;
      else if (lastCommand.equals("/")) result /= x;
      else if (lastCommand.equals("=")) result = x;
      display.setText("Das Ergebnis ist: " + result); 
   }
  // private wie "Schutzmechanismus" ; nur der eigenen Klasse erlaubt auf Methode zuzugreifen
   private final JButton display; // final erzwingt die Unveränderlichkeit des festgelegten Wertes der Variable 
   private final JPanel panel;    
   private double result;  
   private String lastCommand;
   private boolean start; // boolean speichert die Werte true oder false
} 

/**
 * 
 * Hessel & Laipold
 */