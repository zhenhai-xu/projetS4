package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class GamePanel extends JPanel implements MouseListener{
    BufferedImage pg;
    String cartename[][] = new String[5][6];
    int carteID[][] = new int[5][6];
    int niveauEAU[][] = new int[5][6];
    Air air = new Air("air");
    Feu feu = new Feu("feu");
    Terre terre = new Terre("terre");
    Eau eau = new Eau("eau");
    Normal normal = new Normal("normal");
    Helicoptere helicoptere = new Helicoptere("helicoptere");
    Inonder inonder = new Inonder("inonder");
    Boolean Ouvre=false;
    int aqui;

    int a = -100, b = 0;
    private int q, w;
    List<Joueur> Joueurs = new ArrayList<Joueur>();


    public GamePanel() {
        setBackground(Color.pink);
        pg = App.getImg("/Img/Blackground.jpg");
        this.addMouseListener(this);
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 5; j++) {
                niveauEAU[i][j] = 0;
            }
        }
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 5; j++) {
                carteID[i][j] = 1;
            }
        }


    }


    public void action() {
        new Thread(() -> {
            List<Integer>list =new ArrayList<>(Arrays.asList(0,1,2,3,4));
            Collections.shuffle(list);
            for (int i = 0; i < 4; i++) {
                Joueur joueur = new Joueur(list.get(i));
                Joueurs.add(joueur);
                Joueurs.get(i).getCapacite=list.get(i);
                Joueurs.get(i).cadre=i;
                System.out.print( Joueurs.get(i).getCapacite);
                if(i==0){
                    joueur.Atoi=true;
                }else{
                    joueur.Atoi=false;
                }
            }
        }).start();
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(pg, 0, 0, null);

        Random cd = new Random();


        for (int j = 0; j <= 1; j++) {
             int i = cd.nextInt(5);
             int  k = cd.nextInt(6);
            if (cartename[i][k] != terre.name && cartename[i][k] != feu.name && cartename[i][k] != eau.name && cartename[i][k] != helicoptere.name && cartename[i][k] != "normal"&&cartename[i][k]!="Videplace") {
                cartename[i][k] = air.name;
            } else if(air.numcarte==2){
                j--;
            }
        }
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 5; j++) {
                if (cartename[i][j] == air.name) {
                    g.drawImage(air.img, air.x + i * 100, air.y + j * 80, air.w, air.h, null);
                }
            }
        }

        for (int j = 0; j <= 1; j++) {
             int i = cd.nextInt(5);
           int k = cd.nextInt(6);
            if (cartename[i][k] != terre.name && cartename[i][k] != air.name && cartename[i][k] != eau.name && cartename[i][k] != helicoptere.name && cartename[i][k] != "normal"&&cartename[i][k]!="Videplace") {
                cartename[i][k] = feu.name;
            } else if(feu.numcarte==2){
                j--;
            }
        }
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 5; j++) {
                if (cartename[i][j] == feu.name) {
                    g.drawImage(feu.img, feu.x + i * 100, feu.y + j * 80, feu.w, feu.h, null);
                }
            }
        }


        for (int j = 0; j <= 1; j++) {
            int i = cd.nextInt(5);
           int k = cd.nextInt(6);
            if (cartename[i][k] != terre.name && cartename[i][k] != feu.name && cartename[i][k] != air.name && cartename[i][k] != helicoptere.name && cartename[i][k] != "normal"&&cartename[i][k]!="Videplace") {
                cartename[i][k] = eau.name;

            } else if(eau.numcarte==2){
                j--;
            }
        }
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 5; j++) {
                if (cartename[i][j] == eau.name) {
                    g.drawImage(eau.img, eau.x + i * 100, eau.y + j * 80, eau.w, eau.h, null);
                }
            }
        }


        for (int j = 0; j <= 1; j++) {
           int i = cd.nextInt(5);
           int k = cd.nextInt(6);
            if (cartename[i][k] != air.name && cartename[i][k] != feu.name && cartename[i][k] != eau.name && cartename[i][k] != helicoptere.name && cartename[i][k] != "normal"&&cartename[i][k]!="Videplace") {
                cartename[i][k] = terre.name;
            } else if(terre.numcarte==2){
                j--;
            }
        }
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 5; j++) {
                if (cartename[i][j] == terre.name) {
                    g.drawImage(terre.img, terre.x + i * 100, terre.y + j * 80, terre.w, terre.h, null);
                }
            }
        }


        for (int j = 0; j < 1; j++) {
          int i = cd.nextInt(5);
             int k = cd.nextInt(6);
            if (cartename[i][k] != terre.name && cartename[i][k] != feu.name && cartename[i][k] != eau.name && cartename[i][k] != air.name && cartename[i][k] != "normal"&&cartename[i][k]!="Videplace") {
                cartename[i][k] = helicoptere.name;
            } else {
                j--;
            }
        }
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 5; j++) {
                if (cartename[i][j] == helicoptere.name) {
                    g.drawImage(helicoptere.img, helicoptere.x + i * 100, helicoptere.y + j * 80, helicoptere.w, helicoptere.h, null);
                }
            }
        }


        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 5; j++) {
                if (cartename[i][j] != terre.name && cartename[i][j] != feu.name && cartename[i][j] != eau.name && cartename[i][j] != air.name && cartename[i][j] != helicoptere.name) {
                    cartename[i][j] = "normal";
                    g.drawImage(normal.img, normal.x + i * 100, normal.y + j * 80, normal.w, normal.h, null);
                }
            }
        }
        if (Ouvre==true) {
            for (int i = 0; i <= 4; i++) {
                for (int j = 0; j <= 5; j++) {
                    if (carteID[i][j] == 2) {
                        g.drawImage(inonder.img, inonder.x + i * 100, inonder.y + j * 80, inonder.w, inonder.h, null);
                    } else if (carteID[i][j] == 3) {
                        g.setColor(Color.blue);
                        g.fillRect(200 + i * 100, 200 + j * 80, 100, 80);
                        for (int l = 0; l < Joueurs.size(); l++) {
                            if(Joueurs.get(l).i==i&&Joueurs.get(l).j==j&&Joueurs.get(l).getCapacite!=3){
                                JOptionPane.showMessageDialog(this, "game over");
                            }else if(cartename[i][j]!="normal"){
                                JOptionPane.showMessageDialog(this, "Perdue artefact"+cartename[i][j]+ "  game over");
                            }
                        }

                    }
                }
            }
        }

        g.setColor(Color.yellow);
        int fontSize = 15;
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        g.drawString("AirCle :"+air.recuperCle, 200, 700);
        for (int i = 0; i < Joueurs.size(); i++) {
            if (Joueurs.get(i).gagneAirCle == 2) {
                g.drawImage(air.artefact, 200, 720, 100, 70, null);
            }
        }



        g.setColor(Color.red);
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        g.drawString("FeuCle :"+feu.recuperCle, 300, 700);
        for (int i = 0; i < Joueurs.size(); i++) {
            if (Joueurs.get(i).gagneFeuCle == 2) {
                g.drawImage(feu.artefact, 300, 720, 100, 70, null);
            }
        }

        g.setColor(Color.blue);
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        g.drawString("EauCle :"+eau.recuperCle, 400, 700);
        for (int i = 0; i < Joueurs.size(); i++) {
            if (Joueurs.get(i).gagneEauCle== 2) {
                g.drawImage(eau.artecfact, 400, 720, 100, 70, null);
            }
        }

        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        g.drawString("TerreCle :"+terre.recuperCle, 500, 700);
        for (int i = 0; i < Joueurs.size(); i++) {
            if (Joueurs.get(i).gagneTerreCle == 2) {
                g.drawImage(terre.artefact, 500, 720, 100, 70, null);
            }
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        for (int i = 0; i < Joueurs.size(); i++) {
            if(Joueurs.get(i).getCapacite==0) {
                g.drawString("Batman est J0 .", 350, 20);
                g.drawString("BatmanCleTerre :" + Joueurs.get(i).gagneTerreCle, 350, 140);
                g.drawString("BatmanCleEau :" + Joueurs.get(i).gagneEauCle, 350, 50);
                g.drawString("BatmanCleFeu :" + Joueurs.get(i).gagneFeuCle, 350, 80);
                g.drawString("BatmanCleAir :" + Joueurs.get(i).gagneAirCle, 350, 110);
                g.drawString("QuiDeplacer :" + Joueurs.get(i).Atoi, 350, 170);
                g.drawString("restActions :" + Joueurs.get(i).restAction, 350, 190);

            }
        }

        g.setColor(Color.blue);
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        for (int i = 0; i < Joueurs.size(); i++) {
            if(Joueurs.get(i).getCapacite==1) {
                g.drawString("CaptainAmerica est J1 .", 650, 20);
                g.drawString("CaptainAmericaCleTerre :" + Joueurs.get(i).gagneTerreCle, 650, 140);
                g.drawString("CaptainAmericaCleEau :" + Joueurs.get(i).gagneEauCle, 650, 50);
                g.drawString("CaptainAmericaCleFeu :" + Joueurs.get(i).gagneFeuCle, 650, 80);
                g.drawString("CaptainAmericaCleAir :" + Joueurs.get(i).gagneAirCle, 650, 110);
                g.drawString("QuiDeplacer :" + Joueurs.get(i).Atoi, 650, 170);
                g.drawString("restActions :" + Joueurs.get(i).restAction, 650, 190);
            }
        }
        g.setColor(Color.green);
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        for (int i = 0; i < Joueurs.size(); i++) {
            if(Joueurs.get(i).getCapacite==2) {
                g.drawString("TitanVert est J2 .", 200, 20);
                g.drawString("TitanVertCleTerre :" + Joueurs.get(i).gagneTerreCle, 200, 140);
                g.drawString("TitanVertCleEau :" + Joueurs.get(i).gagneEauCle, 200, 50);
                g.drawString("TitanVertCleFeu :" + Joueurs.get(i).gagneFeuCle, 200, 80);
                g.drawString("TitanVertCleAir :" + Joueurs.get(i).gagneAirCle, 200, 110);
                g.drawString("QuiDeplacer :" + Joueurs.get(i).Atoi, 200, 170);
                g.drawString("restActions :" + Joueurs.get(i).restAction, 200, 190);
            }
        }
        g.setColor(Color.red);
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        for (int i = 0; i < Joueurs.size(); i++) {
            if(Joueurs.get(i).getCapacite==3) {
                g.drawString("Supermen est J3 .", 500, 20);
                g.drawString("SupermenCleTerre :" + Joueurs.get(i).gagneTerreCle, 500, 140);
                g.drawString("SupermenCleEau :" + Joueurs.get(i).gagneEauCle, 500, 50);
                g.drawString("SupermenCleFeu :" + Joueurs.get(i).gagneFeuCle, 500, 80);
                g.drawString("SupermenCleAir :" + Joueurs.get(i).gagneAirCle, 500, 110);
                g.drawString("QuiDeplacer :" + Joueurs.get(i).Atoi, 500, 170);
                g.drawString("restActions :" + Joueurs.get(i).restAction, 500, 190);
            }
        }
        g.setColor(Color.orange);
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        for (int i = 0; i < Joueurs.size(); i++) {
            if(Joueurs.get(i).getCapacite==4) {
                g.drawString("Tyran est J4 .", 10, 20);
                g.drawString("TyranTerre :" + Joueurs.get(i).gagneTerreCle, 10, 140);
                g.drawString("TyranCleEau :" + Joueurs.get(i).gagneEauCle, 10, 50);
                g.drawString("TyranCleFeu :" + Joueurs.get(i).gagneFeuCle, 10, 80);
                g.drawString("TyranCleAir :" + Joueurs.get(i).gagneAirCle, 10, 110);
                g.drawString("QuiDeplacer :" + Joueurs.get(i).Atoi, 10, 170);
                g.drawString("restActions :" + Joueurs.get(i).restAction, 10, 190);

            }
        }



        for (int i = 0; i < Joueurs.size(); i++) {
            Joueur joueur = Joueurs.get(i);
            g.drawImage(joueur.img, joueur.x, joueur.y, joueur.w, joueur.h, null);
        }

        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        g.drawString("DonneCle", 750, 610);
        g.drawRect(740, 590, 80, 30);

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int c = e.getButton();
        if (c == MouseEvent.BUTTON1) {

            int i = e.getX();
            int j = e.getY();
            int mouseplaceX = (i - 200) / 100;
            int mouseplaceY = (j - 200) / 80;

            if (i < 200 || i > 700 && i < 740 || i > 820 || j < 200 || j > 680) {
                JOptionPane.showMessageDialog(this, "Ne peut pas deplacer");
            } else if (i >= 200 && i <= 700 && j >= 200 && j <= 680 ) {
                for (int l = 0; l < Joueurs.size(); l++) {
                    if (Joueurs.get(l).restAction > 0 && Joueurs.get(l).Atoi && carteID[mouseplaceX][mouseplaceY] !=3 &&Joueurs.get(l).getCapacite==0) {//Ingenieur
                        Joueurs.get(l).action(e.getX(), e.getY());
                        if (Joueurs.get(l).restAction == 0 && l <= Joueurs.size() - 2) {
                            Joueurs.get(l + 1).Atoi = true;
                            Joueurs.get(l).Atoi = false;
                        } else if (Joueurs.get(l).restAction == 0 && l == Joueurs.size() - 1) {
                            Joueurs.get(0).Atoi = true;
                            Joueurs.get(l).Atoi = false;
                        } else if (Joueurs.get(l).enleverEau && carteID[Joueurs.get(l).k][Joueurs.get(l).m] == 2 && Joueurs.get(l).restAction > 0) {
                            carteID[Joueurs.get(l).k][Joueurs.get(l).m] = 1;
                            niveauEAU[Joueurs.get(l).k][Joueurs.get(l).m]--;
                            Joueurs.get(l).restAction--;
                            System.out.println(Joueurs.get(l).restAction + "fois");
                            if (Joueurs.get(l).restAction == 0 && l <= Joueurs.size() - 2) {
                                Joueurs.get(l + 1).Atoi = true;
                                Joueurs.get(l).Atoi = false;
                            } else if (Joueurs.get(l).restAction == 0 && l == Joueurs.size() - 1) {
                                Joueurs.get(0).Atoi = true;
                                Joueurs.get(l).Atoi = false;
                            }
                        } else if (Joueurs.get(l).restAction > 0 && Joueurs.get(l).Atoi && carteID[mouseplaceX][mouseplaceY] == 3) {
                            JOptionPane.showMessageDialog(this, "Cette place est la mer,pls change l'itineaire");
                        }
                    }else if(Joueurs.get(l).restAction > 0 && Joueurs.get(l).Atoi && carteID[mouseplaceX][mouseplaceY] !=3 &&Joueurs.get(l).getCapacite==1){//Joueur explorateur
                        Joueurs.get(l).actionExplorateur(e.getX(), e.getY());
                        if (e.getX() >= 740 && e.getX() <= 820 && e.getY() >= 590 && e.getY() <= 620) {
                            for (int h = 0; h < Joueurs.size(); h++) {//Si quelqu'un a le meme cle,Messager lui donne la cle.
                                if (Joueurs.get(h).gagneTerreCle == 1 && Joueurs.get(l).gagneTerreCle == 1
                                        &&h!=l &&Joueurs.get(h).x==Joueurs.get(l).x &&Joueurs.get(h).y==Joueurs.get(l).y) {
                                    Joueurs.get(h).gagneTerreCle++;
                                    Joueurs.get(l).gagneTerreCle--;
                                    Joueurs.get(l).restAction--;
                                } else if (Joueurs.get(h).gagneAirCle == 1 && Joueurs.get(l).gagneAirCle == 1
                                        &&h!=l &&Joueurs.get(h).x==Joueurs.get(l).x &&Joueurs.get(h).y==Joueurs.get(l).y) {
                                    Joueurs.get(h).gagneAirCle++;
                                    Joueurs.get(l).gagneAirCle--;
                                    Joueurs.get(l).restAction--;
                                } else if (Joueurs.get(h).gagneEauCle == 1 && Joueurs.get(l).gagneEauCle == 1
                                        &&h!=l &&Joueurs.get(h).x==Joueurs.get(l).x &&Joueurs.get(h).y==Joueurs.get(l).y) {
                                    Joueurs.get(h).gagneEauCle++;
                                    Joueurs.get(l).gagneEauCle--;
                                    Joueurs.get(l).restAction--;
                                } else if (Joueurs.get(h).gagneFeuCle == 1 && Joueurs.get(l).gagneFeuCle == 1
                                        &&h!=l &&Joueurs.get(h).x==Joueurs.get(l).x &&Joueurs.get(h).y==Joueurs.get(l).y) {
                                    Joueurs.get(h).gagneFeuCle++;
                                    Joueurs.get(l).gagneFeuCle--;
                                    Joueurs.get(l).restAction--;
                                }
                            }
                        }
                        if (Joueurs.get(l).restAction == 0 && l <= Joueurs.size() - 2) {
                            Joueurs.get(l + 1).Atoi = true;
                            Joueurs.get(l).Atoi = false;
                        } else if (Joueurs.get(l).restAction == 0 && l == Joueurs.size() - 1) {
                            Joueurs.get(0).Atoi = true;
                            Joueurs.get(l).Atoi = false;
                        } else if (Joueurs.get(l).enleverEau && carteID[Joueurs.get(l).k][Joueurs.get(l).m] == 2 && Joueurs.get(l).restAction > 0) {
                            carteID[Joueurs.get(l).k][Joueurs.get(l).m] = 1;
                            niveauEAU[Joueurs.get(l).k][Joueurs.get(l).m]--;
                            Joueurs.get(l).restAction--;
                            System.out.println(Joueurs.get(l).restAction + "fois");
                            if (Joueurs.get(l).restAction == 0 && l <= Joueurs.size() - 2) {
                                Joueurs.get(l + 1).Atoi = true;
                                Joueurs.get(l).Atoi = false;
                            } else if (Joueurs.get(l).restAction == 0 && l == Joueurs.size() - 1) {
                                Joueurs.get(0).Atoi = true;
                                Joueurs.get(l).Atoi = false;
                            }
                        } else if (Joueurs.get(l).restAction > 0 && Joueurs.get(l).Atoi && carteID[mouseplaceX][mouseplaceY] == 3) {
                            JOptionPane.showMessageDialog(this, "Cette place est la mer,pls change l'itineaire");
                        }
                    }else if(Joueurs.get(l).restAction > 0 && Joueurs.get(l).Atoi  &&Joueurs.get(l).getCapacite==3){//joueur plongeur
                        Joueurs.get(l).action(e.getX(), e.getY());
                        if (Joueurs.get(l).restAction == 0 && l <= Joueurs.size() - 2) {
                            Joueurs.get(l + 1).Atoi = true;
                            Joueurs.get(l).Atoi = false;
                        } else if (Joueurs.get(l).restAction == 0 && l == Joueurs.size() - 1) {
                            Joueurs.get(0).Atoi = true;
                            Joueurs.get(l).Atoi = false;
                        } else if (Joueurs.get(l).enleverEau && carteID[Joueurs.get(l).k][Joueurs.get(l).m] == 2 && Joueurs.get(l).restAction > 0) {
                            carteID[Joueurs.get(l).k][Joueurs.get(l).m] = 1;
                            niveauEAU[Joueurs.get(l).k][Joueurs.get(l).m]--;
                            Joueurs.get(l).restAction--;
                            System.out.println(Joueurs.get(l).restAction + "fois");
                            if (Joueurs.get(l).restAction == 0 && l <= Joueurs.size() - 2) {
                                Joueurs.get(l + 1).Atoi = true;
                                Joueurs.get(l).Atoi = false;
                            } else if (Joueurs.get(l).restAction == 0 && l == Joueurs.size() - 1) {
                                Joueurs.get(0).Atoi = true;
                                Joueurs.get(l).Atoi = false;
                            }
                        }

                    }else if(Joueurs.get(l).restAction > 0 && Joueurs.get(l).Atoi  &&Joueurs.get(l).getCapacite==2){//joueur navigateur
                        Joueurs.get(l).action(e.getX(), e.getY());
                        if (e.getX() >= 740 && e.getX() <= 820 && e.getY() >= 590 && e.getY() <= 620) {
                            for (int h = 0; h < Joueurs.size(); h++) {//Si quelqu'un a le meme cle,Messager lui donne la cle.
                                if (Joueurs.get(h).gagneTerreCle == 1 && Joueurs.get(l).gagneTerreCle == 1
                                        &&h!=l &&Joueurs.get(h).x==Joueurs.get(l).x &&Joueurs.get(h).y==Joueurs.get(l).y) {
                                    Joueurs.get(h).gagneTerreCle++;
                                    Joueurs.get(l).gagneTerreCle--;
                                    Joueurs.get(l).restAction--;
                                } else if (Joueurs.get(h).gagneAirCle == 1 && Joueurs.get(l).gagneAirCle == 1
                                        &&h!=l &&Joueurs.get(h).x==Joueurs.get(l).x &&Joueurs.get(h).y==Joueurs.get(l).y) {
                                    Joueurs.get(h).gagneAirCle++;
                                    Joueurs.get(l).gagneAirCle--;
                                    Joueurs.get(l).restAction--;
                                } else if (Joueurs.get(h).gagneEauCle == 1 && Joueurs.get(l).gagneEauCle == 1
                                        &&h!=l &&Joueurs.get(h).x==Joueurs.get(l).x &&Joueurs.get(h).y==Joueurs.get(l).y) {
                                    Joueurs.get(h).gagneEauCle++;
                                    Joueurs.get(l).gagneEauCle--;
                                    Joueurs.get(l).restAction--;
                                } else if (Joueurs.get(h).gagneFeuCle == 1 && Joueurs.get(l).gagneFeuCle == 1
                                        &&h!=l &&Joueurs.get(h).x==Joueurs.get(l).x &&Joueurs.get(h).y==Joueurs.get(l).y) {
                                    Joueurs.get(h).gagneFeuCle++;
                                    Joueurs.get(l).gagneFeuCle--;
                                    Joueurs.get(l).restAction--;
                                }
                            }
                        }
                        for (int h = 0; h < Joueurs.size(); h++) {
                            if(h!=l &&Joueurs.get(h).x!=Joueurs.get(l).x&&Joueurs.get(h).y!=Joueurs.get(l).y
                                    &&mouseplaceX==Joueurs.get(h).i&&mouseplaceY==Joueurs.get(h).j
                                    &&Joueurs.get(l).joueurPlace[Joueurs.get(l).i][Joueurs.get(l).j] == 1){
                                Joueurs.get(l).x=Joueurs.get(h).x;
                                Joueurs.get(l).y=Joueurs.get(h).y;
                                Joueurs.get(l).restAction--;
                                System.out.print(Joueurs.get(l).restAction+"restfois");
                            }
                        }
                        if (Joueurs.get(l).restAction == 0 && l <= Joueurs.size() - 2) {
                            Joueurs.get(l + 1).Atoi = true;
                            Joueurs.get(l).Atoi = false;
                        } else if (Joueurs.get(l).restAction == 0 && l == Joueurs.size() - 1) {
                            Joueurs.get(0).Atoi = true;
                            Joueurs.get(l).Atoi = false;
                        } else if (Joueurs.get(l).enleverEau && carteID[Joueurs.get(l).k][Joueurs.get(l).m] == 2 && Joueurs.get(l).restAction > 0) {
                            carteID[Joueurs.get(l).k][Joueurs.get(l).m] = 1;
                            niveauEAU[Joueurs.get(l).k][Joueurs.get(l).m]--;
                            Joueurs.get(l).restAction--;
                            System.out.println(Joueurs.get(l).restAction + "fois");
                            if (Joueurs.get(l).restAction == 0 && l <= Joueurs.size() - 2) {
                                Joueurs.get(l + 1).Atoi = true;
                                Joueurs.get(l).Atoi = false;
                            } else if (Joueurs.get(l).restAction == 0 && l == Joueurs.size() - 1) {
                                Joueurs.get(0).Atoi = true;
                                Joueurs.get(l).Atoi = false;
                            }
                        }

                    }else if(Joueurs.get(l).restAction > 0 && Joueurs.get(l).Atoi  &&Joueurs.get(l).getCapacite==4) {//joueur Messager
                        Joueurs.get(l).action(e.getX(), e.getY());
                        System.out.print("bababababbababa");
                        if (Joueurs.get(l).restAction == 0 && l <= Joueurs.size() - 2) {
                            Joueurs.get(l + 1).Atoi = true;
                            Joueurs.get(l).Atoi = false;
                        } else if (Joueurs.get(l).restAction == 0 && l == Joueurs.size() - 1) {
                            Joueurs.get(0).Atoi = true;
                            Joueurs.get(l).Atoi = false;
                        } else if (Joueurs.get(l).enleverEau && carteID[Joueurs.get(l).k][Joueurs.get(l).m] == 2 && Joueurs.get(l).restAction > 0) {
                            carteID[Joueurs.get(l).k][Joueurs.get(l).m] = 1;
                            niveauEAU[Joueurs.get(l).k][Joueurs.get(l).m]--;
                            Joueurs.get(l).restAction--;
                            System.out.println(Joueurs.get(l).restAction + "fois");
                            if (Joueurs.get(l).restAction == 0 && l <= Joueurs.size() - 2) {
                                Joueurs.get(l + 1).Atoi = true;
                                Joueurs.get(l).Atoi = false;
                            } else if (Joueurs.get(l).restAction == 0 && l == Joueurs.size() - 1) {
                                Joueurs.get(0).Atoi = true;
                                Joueurs.get(l).Atoi = false;
                            }
                        }

                    }
                }
                repaint();
            }else if(e.getX() >= 740 && e.getX() <= 820 && e.getY() >= 590 && e.getY() <= 620){
                    System.out.print("iloveu");
                for (int l = 0; l < Joueurs.size(); l++) {
                    if (Joueurs.get(l).restAction > 0 && Joueurs.get(l).Atoi && Joueurs.get(l).getCapacite != 4) {
                        for (int h = 0; h < Joueurs.size(); h++) {//Si quelqu'un a le meme cle,Messager lui donne la cle.
                            if (Joueurs.get(h).gagneTerreCle == 1 && Joueurs.get(l).gagneTerreCle == 1
                                    && h != l && Joueurs.get(h).x == Joueurs.get(l).x && Joueurs.get(h).y == Joueurs.get(l).y) {
                                Joueurs.get(h).gagneTerreCle++;
                                Joueurs.get(l).gagneTerreCle--;
                                Joueurs.get(l).restAction--;
                            } else if (Joueurs.get(h).gagneAirCle == 1 && Joueurs.get(l).gagneAirCle == 1
                                    && h != l && Joueurs.get(h).x == Joueurs.get(l).x && Joueurs.get(h).y == Joueurs.get(l).y) {
                                Joueurs.get(h).gagneAirCle++;
                                Joueurs.get(l).gagneAirCle--;
                                Joueurs.get(l).restAction--;
                            } else if (Joueurs.get(h).gagneEauCle == 1 && Joueurs.get(l).gagneEauCle == 1
                                    && h != l && Joueurs.get(h).x == Joueurs.get(l).x && Joueurs.get(h).y == Joueurs.get(l).y) {
                                Joueurs.get(h).gagneEauCle++;
                                Joueurs.get(l).gagneEauCle--;
                                Joueurs.get(l).restAction--;
                            } else if (Joueurs.get(h).gagneFeuCle == 1 && Joueurs.get(l).gagneFeuCle == 1
                                    && h != l && Joueurs.get(h).x == Joueurs.get(l).x && Joueurs.get(h).y == Joueurs.get(l).y) {
                                Joueurs.get(h).gagneFeuCle++;
                                Joueurs.get(l).gagneFeuCle--;
                                Joueurs.get(l).restAction--;
                            }
                        }
                        if (Joueurs.get(l).restAction == 0 && l <= Joueurs.size() - 2) {
                            Joueurs.get(l + 1).Atoi = true;
                            Joueurs.get(l).Atoi = false;
                        } else if (Joueurs.get(l).restAction == 0 && l == Joueurs.size() - 1) {
                            Joueurs.get(0).Atoi = true;
                            Joueurs.get(l).Atoi = false;
                        } else if (Joueurs.get(l).enleverEau && carteID[Joueurs.get(l).k][Joueurs.get(l).m] == 2 && Joueurs.get(l).restAction > 0) {
                            carteID[Joueurs.get(l).k][Joueurs.get(l).m] = 1;
                            niveauEAU[Joueurs.get(l).k][Joueurs.get(l).m]--;
                            Joueurs.get(l).restAction--;
                            System.out.println(Joueurs.get(l).restAction + "fois");
                            if (Joueurs.get(l).restAction == 0 && l <= Joueurs.size() - 2) {
                                Joueurs.get(l + 1).Atoi = true;
                                Joueurs.get(l).Atoi = false;
                            } else if (Joueurs.get(l).restAction == 0 && l == Joueurs.size() - 1) {
                                Joueurs.get(0).Atoi = true;
                                Joueurs.get(l).Atoi = false;
                            }
                        }
                    }
                }repaint();
            }else if(e.getX() >= 740 && e.getX() <= 820 && e.getY() >= 590 && e.getY() <= 620) {
                for (int l = 0; l < Joueurs.size(); l++) {
                    if (Joueurs.get(l).restAction > 0 && Joueurs.get(l).Atoi && Joueurs.get(l).getCapacite == 4) {//joueur Messager
                            for (int h = 0; h < Joueurs.size(); h++) {//Si quelqu'un a le meme cle,Messager lui donne la cle.
                                if (Joueurs.get(h).gagneTerreCle == 1 && Joueurs.get(l).gagneTerreCle == 1) {
                                    Joueurs.get(h).gagneTerreCle++;
                                    Joueurs.get(l).gagneTerreCle--;
                                } else if (Joueurs.get(h).gagneAirCle == 1 && Joueurs.get(l).gagneAirCle == 1) {
                                    Joueurs.get(h).gagneAirCle++;
                                    Joueurs.get(l).gagneAirCle--;
                                } else if (Joueurs.get(h).gagneEauCle == 1 && Joueurs.get(l).gagneEauCle == 1) {
                                    Joueurs.get(h).gagneEauCle++;
                                    Joueurs.get(l).gagneEauCle--;
                                } else if (Joueurs.get(h).gagneFeuCle == 1 && Joueurs.get(l).gagneFeuCle == 1) {
                                    Joueurs.get(h).gagneFeuCle++;
                                    Joueurs.get(l).gagneFeuCle--;
                                }
                            }
                        if (Joueurs.get(l).restAction == 0 && l <= Joueurs.size() - 2) {
                            Joueurs.get(l + 1).Atoi = true;
                            Joueurs.get(l).Atoi = false;
                        } else if (Joueurs.get(l).restAction == 0 && l == Joueurs.size() - 1) {
                            Joueurs.get(0).Atoi = true;
                            Joueurs.get(l).Atoi = false;
                        } else if (Joueurs.get(l).enleverEau && carteID[Joueurs.get(l).k][Joueurs.get(l).m] == 2 && Joueurs.get(l).restAction > 0) {
                            carteID[Joueurs.get(l).k][Joueurs.get(l).m] = 1;
                            niveauEAU[Joueurs.get(l).k][Joueurs.get(l).m]--;
                            Joueurs.get(l).restAction--;
                            System.out.println(Joueurs.get(l).restAction + "fois");
                            if (Joueurs.get(l).restAction == 0 && l <= Joueurs.size() - 2) {
                                Joueurs.get(l + 1).Atoi = true;
                                Joueurs.get(l).Atoi = false;
                            } else if (Joueurs.get(l).restAction == 0 && l == Joueurs.size() - 1) {
                                Joueurs.get(0).Atoi = true;
                                Joueurs.get(l).Atoi = false;
                            }
                        }

                    }repaint();
                }
            }






        } else if (c == MouseEvent.BUTTON3) {//Joueur ingenieur;
            for (int l = 0; l < Joueurs.size(); l++) {
                if (Joueurs.get(l).getCapacite == 0 && Joueurs.get(l).restcapaciteIngenieur!=0 && Joueurs.get(l).Atoi) {
                    Joueurs.get(l).usecapaciteIngenieur (e.getX(), e.getY());
                    if(carteID[Joueurs.get(l).k][Joueurs.get(l).m]==2){
                        carteID[Joueurs.get(l).k][Joueurs.get(l).m]=1;
                        niveauEAU[Joueurs.get(l).k][Joueurs.get(l).m]--;
                        Joueurs.get(l).restcapaciteIngenieur--;
                    }
                }
            }
            repaint();
        }
    }
        @Override
        public void mousePressed (MouseEvent mouseEvent){

        }

        @Override
        public void mouseReleased (MouseEvent mouseEvent){

        }

        @Override
        public void mouseEntered (MouseEvent mouseEvent){

        }

        @Override
        public void mouseExited (MouseEvent mouseEvent){

        }

    int getQ(){return q;}
    int getW(){return w;}
    void setQ(int i){this.q=i;}
    void setW(int i){this.w=i;}
    }
