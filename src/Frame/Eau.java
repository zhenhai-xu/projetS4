package Frame;

import java.awt.image.BufferedImage;

public class Eau extends Carte{
    BufferedImage img;
    BufferedImage artecfact;
    public Eau(String eau){
        img=App.getImg("/Img/A3.jpg");
        artecfact=App.getImg("/Img/ArtefactEau.png");
        this.x=200;
        this.y=200;
        this.name=eau;
        this.numcarte=2;
    }
}
