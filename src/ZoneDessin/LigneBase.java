package ZoneDessin;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class LigneBase extends FormeGeo{
    ArrayList<Line2D> mikajTsipika = new ArrayList<>();

    public LigneBase(int x, int y, int taille, Color cColor,String typeForme) {
        super(x, y,  taille,  cColor, typeForme);
        AddPoint(x , y);
    }
    
    public void AddPoint(double X, double Y){
        mikajTsipika.add(new Line2D.Double(x, y, X, Y));
        x = X;
        y = Y;
    }

    public ArrayList<Line2D> getMikajTsipika() {
        return mikajTsipika;
    }
    
}
