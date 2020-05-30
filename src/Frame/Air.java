package Frame;

import java.awt.image.BufferedImage;

public class Air extends Carte{
    //init
    BufferedImage img;
    BufferedImage artefact;
    public Air(String air){
        img=App.getImg("/Img/A1.jpg");
        artefact=App.getImg("/Img/ArtefactAir.png");
        this.x=200;
        this.y=200;
        this.name=air;
        this.numcarte=2;
    }
}
