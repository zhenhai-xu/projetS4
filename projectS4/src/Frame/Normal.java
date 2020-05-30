package Frame;

import java.awt.image.BufferedImage;

public class Normal extends Carte {
    BufferedImage img;
    public Normal(String  normal){
        img=App.getImg("/Img/A6.jpg");
        this.x=200;
        this.y=200;
        this.name=normal;
    }
}
