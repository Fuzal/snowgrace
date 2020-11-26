import java.awt.Color;

public class Ampel
{
    private FrmZeichnen kZf;
    private Rechteck hGehaeuse;
    private Kreis hLampeRot, hLampeGelb, hLampeGruen;
    boolean istRot, istRotGelb, istGelb, istGruen, istAus;
    private String zStatus = "Noch kein Ereignis ausgeführt (default = Rot-Gelb-Grün)";
    
    public Ampel(FrmZeichnen Zf, int zX, int zY, int zB)
    {
        kZf = Zf;
        hGehaeuse = new Rechteck(Zf, zX, zY, (int)(zB*0.25), (int)(zB*0.75), Color.gray);
        hLampeRot = new Kreis(Zf, (int)(zX + 0.125*zB), (int)(zY - 0.625*zB), (int)(zB*0.1), Color.red);
        hLampeGelb = new Kreis(Zf, (int)(zX + 0.125*zB), (int)(zY - 0.375*zB), (int)(zB*0.1), Color.yellow);
        hLampeGruen = new Kreis(Zf, (int)(zX + 0.125*zB), (int)(zY - 0.125*zB), (int)(zB*0.1), Color.green);
    }
    
    public String statusAbfragen()
    {
        return zStatus;
    }
    
    public void zeichnen()
    {
        hGehaeuse.zeichnen();
        hLampeRot.zeichnen();
        hLampeGelb.zeichnen();
        hLampeGruen.zeichnen();
    }
    
    public void ampelAus()
    {
        hLampeRot.setzeFarbe(Color.black);
        hLampeGelb.setzeFarbe(Color.black);
        hLampeGruen.setzeFarbe(Color.black);
        zStatus = "Aus";
    }
    
    public void ampelRot()
    {
        hLampeRot.setzeFarbe(Color.red);
        hLampeGelb.setzeFarbe(Color.black);
        hLampeGruen.setzeFarbe(Color.black);
        zStatus = "Rot";
    }
    
    public void ampelRotGelb()
    {
        hLampeRot.setzeFarbe(Color.red);
        hLampeGelb.setzeFarbe(Color.yellow);
        hLampeGruen.setzeFarbe(Color.black);
        zStatus = "Rot-Gelb";
    }
    
    public void ampelGelb()
    {
        hLampeRot.setzeFarbe(Color.black);
        hLampeGelb.setzeFarbe(Color.yellow);
        hLampeGruen.setzeFarbe(Color.black);
        zStatus = "Gelb";
    }
    
    public void ampelGruen()
    {
        hLampeRot.setzeFarbe(Color.black);
        hLampeGelb.setzeFarbe(Color.black);
        hLampeGruen.setzeFarbe(Color.green);
        zStatus = "Grün";
    }
}