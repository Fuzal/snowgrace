import java.awt.*;  // Klasse Color

public class Quadrat
{
    // Attribute
  
   private FrmZeichnen kZf;
   private Graphics kLw;
   private int zX, zY, zB;
   private Color zFarbe;
   private boolean zSichtbar;


    // Konstrutor(en)

  /** Konstruktor: erzeugt ein Objekt der Klasse Quadrat. */
  public Quadrat (FrmZeichnen zf, int xPos, int yPos, int breite, Color farbe) {    
       kZf = zf;
       kLw = kZf.getGraphics();  // Leinwand = Zeichenflaeche
       zX = xPos + kZf.getInsets().left;
       zY = yPos + kZf.getInsets().top;
       zB = breite;
       zFarbe = farbe;
    }
     
     // Methoden  

    /** Zeichnet die Figur. */
    public void zeichnen() {
       Color farbeAlt;
       farbeAlt = kLw.getColor();
       kLw.setColor (zFarbe);
       kLw.fillRect (zX, zY-zB, zB, zB);
       kLw.setColor (Color.black);
       kLw.drawRect (zX, zY-zB, zB, zB);
       kLw.setColor (farbeAlt);
       zSichtbar = true;
    }
     
    /** Uebermalt die Figur mit weisser Farbe. */
    public void loeschen() {
       Color farbeAlt;
       farbeAlt = kLw.getColor();
       kLw.setColor (Color.white);
       kLw.fillRect (zX, zY-zB, zB, zB);
       kLw.drawRect (zX, zY-zB, zB, zB);
       kLw.setColor (farbeAlt);
       zSichtbar = false;
    }
    
    /** Zeichnet die Figur in der neuen Farbe. */
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
     
     
}  // Klasse Quadrat
