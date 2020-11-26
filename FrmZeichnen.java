import java.awt.*;

public class FrmZeichnen extends Frame {
	
    // Attribute
    
    // Konstruktor
    
    /** Konstruktor: erzeugt ein Zeichenfenster. */
    public FrmZeichnen () {
       setSize (400, 300);
       setLocation (20, 20); 
       setTitle ("Zeichenfenster"); 
       setResizable (false);
    }
    
    // Neue Methoden: noch keine...
   
    // Einige wenige Fenster-Methoden
    
    /** Macht das Fenster sichtbar oder unsichtbar. */ 
    public void setVisible (boolean b) {
       super.setVisible(b);
    } 
    
    /** Setzt die Groesse (Breite, Hoehe) des Fensters. */
    public void setSize (int b, int h) {
      super.setSize (b, h);    
    }    
    
   /** Setzt die Beschriftung in der Titelzeile des Fensters. */
    public void setTitle (String str) {
      super.setTitle(str);
    }
  
} // class FrmZeichnen
