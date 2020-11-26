import java.awt.*;  // Klasse Color

public class Rechteck {
    
  // Attribute
  
   private FrmZeichnen kZf;
   private Graphics kLw;
   private int zX, zY, zB, zH;
   private Color zFarbe;
   private boolean zSichtbar;

   // Konstruktoren
  
   /** Konstruktor: erzeugt ein Objekt der Klasse Rechteck. */
   public Rechteck (FrmZeichnen Zf, int xPos, int yPos, int breite, int hoehe, Color farbe) {    
      kZf = Zf;
      kLw = kZf.getGraphics();  // Leinwand = Zeichenflaeche
      zX = xPos + kZf.getInsets().left;
      zY = yPos + kZf.getInsets().top;
      zB = breite;
      zH = hoehe;
      zFarbe = farbe;
      zSichtbar = false;
   }

   // Methoden
   
    /** Zeichnet die Figur. */
    public void zeichnen() {
       Color farbeAlt;
       farbeAlt = kLw.getColor();
       kLw.setColor (zFarbe);
       kLw.fillRect (zX, zY-zH, zB, zH);
       kLw.setColor (Color.black);
       kLw.drawRect (zX, zY-zH, zB, zH);
       kLw.setColor (farbeAlt);
       zSichtbar = true;
    }
 
    /** Uebermalt die Figur mit weisser Farbe. */
    public void loeschen() {
       Color farbeAlt;
       farbeAlt = kLw.getColor();
       kLw.setColor (Color.white);
       kLw.fillRect (zX, zY-zH, zB, zH);
       kLw.drawRect (zX, zY-zH, zB, zH);
       kLw.setColor (farbeAlt);
       zSichtbar = false;
    }
    
    /** Zeichet die Figur in der neuen Farbe. */
    public void setzeFarbe (Color farbe) {
        zFarbe = farbe;
        if (zSichtbar)
           zeichnen();
    }
    
    /** Bezugspunkt: Ecke unten links. */
    public void setzePosition (int xPos, int yPos) {
       if (zSichtbar) {
          loeschen();
          zX = xPos + kZf.getInsets().left;
          zY = yPos + kZf.getInsets().top;
          zeichnen();
        }
        else {
          zX = xPos + kZf.getInsets().left;
          zY = yPos + kZf.getInsets().top; 
        }    
    }
    
     /** Liefert die x-Koordinate der Figur. */
    public int liesXPosition() {
       return zX - kZf.getInsets().left;
    }
    
    /** Liefert die y-Koordinate der Figur. */
    public int liesYPosition() {
       return zY - kZf.getInsets().top;
    }
    
} // class
