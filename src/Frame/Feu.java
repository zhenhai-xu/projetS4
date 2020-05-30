package Frame;

import java.awt.image.BufferedImage;

public class Feu extends Carte{
        BufferedImage img;
    BufferedImage artefact;
    public Feu(String feu){
        img=App.getImg("/Img/A4.jpg");
        artefact=App.getImg("/Img/ArtefactFeu.png");
        this.x=200;
        this.y=200;
        this.name=feu;
        this.numcarte=2;
    }
}
