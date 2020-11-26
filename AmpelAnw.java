public class AmpelAnw
{
    private FrmZeichnen hZf;
    private Ampel hAmpel;
    
    public AmpelAnw()
    {
        zeichenfensterErzeugen();
    }
    
    public void ampelErzeugen(int zX, int zY, int zB)
    {
        hAmpel = new Ampel(hZf, zX, zY, zB);
        hAmpel.zeichnen();
    }
    
    public void ampelZyklus()
    {   
        for(int x = 10; x < 12; x = x + 1)
        {
            hAmpel.ampelRot();
            status();
            wait(10000);
            hAmpel.ampelRotGelb();
            status();
            wait(2000);
            hAmpel.ampelGruen();
            status();
            wait(10000);
            hAmpel.ampelGelb();
            status();
            wait(2000);
        }
    }
    
    public void ampelnAus()
    {
        hAmpel.ampelAus();
        status();
    }
    
    public void status()
    {
        System.out.println();
        System.out.println("Statusabrage erfolgreich. Ergebnis: " + hAmpel.statusAbfragen());
    }
    
    public void zeichenfensterErzeugen()
    {
        hZf = new FrmZeichnen();
        hZf.setVisible(true);
        hZf.setSize(500, 500);
        hZf.setTitle("Ampel");
    }
    
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}