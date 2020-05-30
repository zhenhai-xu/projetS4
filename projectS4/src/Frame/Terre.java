package Frame;

import java.awt.image.BufferedImage;

public class Terre extends Carte{
    BufferedImage img;
    BufferedImage artefact;
    public Terre(String terre){
        img=App.getImg("/Img/A2.jpg");
        artefact=App.getImg("/Img/ArtefactTerre.png");
        this.x=200;
        this.y=200;
        this.name=terre;
        this.numcarte=2;
    }
}
