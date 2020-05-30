package Frame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class App{
    public static BufferedImage getImg(String path){
        try{
            BufferedImage Img = ImageIO.read(App.class.getResource(path));
            return    Img;
        }  catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
