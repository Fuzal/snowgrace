import java.awt.*;  // Klasse Color

public class Dreieck {
    
  // Attribute
  
   private FrmZeichnen kZf;
   private Graphics kLw;
   private int zX, zY, zB, zH;
   private Color zFarbe;
   private boolean zSichtbar;

  // Konstruktoren
  
    /** Konstruktor: erzeugt ein Objekt der Klasse Dreieck. */
    public Dreieck (FrmZeichnen Zf, int xPos, int yPos, int breite, Color farbe) {    
       kZf = Zf;
       kLw= kZf.getGraphics();  // Leinwand = Zeichenflaeche
       zX = xPos + kZf.getInsets().left;
       zY = yPos + kZf.getInsets().top;
       zB = breite;
       zH = breite / 2;
       zFarbe = farbe;
     }

   // Methoden
   
    /** Zeichnet die Figur. */
    public void zeichnen() {
       Polygon eckpunkte;
        
       eckpunkte = new Polygon();
       eckpunkte.addPoint (zX, zY);
       eckpunkte.addPoint (zX + zB, zY);
       eckpunkte.addPoint (zX + zB/2, zY - zH);
        
       kLw.setColor (zFarbe);
       kLw.fillPolygon (eckpunkte);
       kLw.setColor (Color.black);
       kLw.drawPolygon (eckpunkte);
       zSichtbar = true;
    }
 
    /** Uebermalt die Figur mit weisser Farbe. */
    public void loeschen() {
       Color farbeAlt;
       Polygon eckpunkte;
        
       eckpunkte = new Polygon();
       eckpunkte.addPoint (zX, zY);
       eckpunkte.addPoint (zX + zB, zY);
       eckpunkte.addPoint (zX + zB/2, zY - zH);
        
       farbeAlt = kLw.getColor();
       kLw.setColor (Color.white);
       kLw.fillPolygon (eckpunkte);
       kLw.drawPolygon (eckpunkte);
       kLw.setColor (farbeAlt);
       zSichtbar = false;
    }
    
    /** Zeichnet die Figur in der neuen Farbe. */
    public void setzeFarbe (Color farbe) {
       zFarbe = farbe;
       if (zSichtbar)
          zeichnen();
    }
    
    /** Bezugspunkt: Ecke unten links */
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