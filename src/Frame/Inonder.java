package Frame;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Inonder extends Carte{
    BufferedImage img;
    int i,k;
    int nombreInonder=0;
    public Inonder(String inonder){
        img=App.getImg("/Img/Inonder.png");
        this.x=200;
        this.y=240;
        this.h=40;
        this.name=inonder;
        this.niveauEau=1;

    }

    Random cd = new Random();

    public void inonde(){
        Random cd = new Random();
            i = cd.nextInt(3);
            k = cd.nextInt(5);
    }
}
