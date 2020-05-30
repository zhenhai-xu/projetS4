package Frame;

import java.awt.image.BufferedImage;

public class Helicoptere extends Carte{
    BufferedImage img;
    public Helicoptere(String helico){
        img=App.getImg("/Img/A7.jpg");
        this.x=200;
        this.y=200;
        this.name=helico;
    }
}
