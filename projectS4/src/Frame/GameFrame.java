package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GameFrame extends JFrame{
    public GameFrame(){
        setTitle("L'Ile Interdite");
        setSize(1000,915);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        GameFrame frame=new GameFrame();
        GamePanel panel= new GamePanel();
        panel.action();
        JButton recuperer=new JButton("récupérer");
        JButton fin=new JButton("fin du tour");
        JButton pasuse=new JButton("pause");
        JButton décollage=new JButton("décollage");
        JPanel control= new JPanel();
        control.setLayout(null);
        control.setPreferredSize(new Dimension(105,100));
        fin.setBounds(5,300,100,40);
        pasuse.setBounds(5,350,100,40);
        recuperer.setBounds(5,400,100,40);
        décollage.setBounds(5,450,100,40);

        control.setSize(50, 100);
        control.add(recuperer);
        control.add(fin);
        control.add(décollage);
        control.add(pasuse);
        décollage.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (panel.Joueurs.get(0).x==panel.Joueurs.get(1).x&&panel.Joueurs.get(1).x==panel.Joueurs.get(2).x&&panel.Joueurs.get(2).x==panel.Joueurs.get(3).x
                    &&panel.Joueurs.get(0).y==panel.Joueurs.get(1).y&&panel.Joueurs.get(1).y==panel.Joueurs.get(2).y&&panel.Joueurs.get(2).y==panel.Joueurs.get(3).y){
                JOptionPane.showMessageDialog(panel, "win");
                }else{JOptionPane.showMessageDialog(panel, "pas encore gagner");}
            }


            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        pasuse.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int l = 0; l < panel.Joueurs.size(); l++) {
                    if (panel.Joueurs.get(l).Atoi && l < panel.Joueurs.size() - 1) {
                        panel.Joueurs.get(l).restAction = 0;
                        panel.Joueurs.get(l).Atoi = false;
                        panel.Joueurs.get(l + 1).restAction = 3;
                        panel.Joueurs.get(l + 1).Atoi = true;
                        System.out.println("1");
                        break;

                    } else if (panel.Joueurs.get(l).Atoi && l == panel.Joueurs.size() - 1){
                        panel.Joueurs.get(l).restAction = 0;
                        panel.Joueurs.get(l).Atoi = false;
                        panel.Joueurs.get(0).Atoi = true;
                        System.out.println("2");

                    }
                    else { System.out.println("skip");}
                }panel.repaint();
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        fin.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                Random cd = new Random();
                for (int i = 0; i <= 2; i++) {
                    panel.setQ(cd.nextInt(4));
                    panel.setW(cd.nextInt(6));
                    if (panel.niveauEAU[panel.getQ()][panel.getW()] < 1) {
                        panel.carteID[panel.getQ()][panel.getW()] = 2;
                        panel.niveauEAU[panel.getQ()][panel.getW()]++;
                    } else if (panel.niveauEAU[panel.getQ()][panel.getW()] == 1) {
                        panel.carteID[panel.getQ()][panel.getW()] = 3;
                        panel.niveauEAU[panel.getQ()][panel.getW()]++;
                    } else if (panel.niveauEAU[panel.getQ()][panel.getW()] == 2) {
                        i--;
                    }

                }
                panel.Ouvre=true;
                for(int o=0;o<panel.Joueurs.size();o++){
                    panel.Joueurs.get(o).restAction=3;
                }

                panel.repaint();
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {}
            @Override
            public void mouseReleased(MouseEvent mouseEvent) {}
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {}
            @Override
            public void mouseExited(MouseEvent mouseEvent) {}
        });
        recuperer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int l = 0; l < panel.Joueurs.size(); l++) {
                    System.out.print(l);
                    if (panel.Joueurs.get(l).restAction > 0 && panel.Joueurs.get(l).Atoi) {
                        panel.Joueurs.get(l).obtenirCle=true;
                        System.out.print(e.getX());
                        System.out.print(panel.Joueurs.get(l).Atoi);
                        if (panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j].equals(panel.air.name) && panel.carteID[panel.Joueurs.get(l).k][panel.Joueurs.get(l).m] != 3 && panel.Joueurs.get(l).obtenirCle
                                || panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j].equals(panel.eau.name) && panel.carteID[panel.Joueurs.get(l).k][panel.Joueurs.get(l).m] != 3 && panel.Joueurs.get(l).obtenirCle
                                || panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j].equals(panel.feu.name) && panel.carteID[panel.Joueurs.get(l).k][panel.Joueurs.get(l).m] != 3 && panel.Joueurs.get(l).obtenirCle
                                || panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j].equals(panel.terre.name) && panel.Joueurs.get(l).obtenirCle && panel.carteID[panel.Joueurs.get(l).k][panel.Joueurs.get(l).m] != 3) {
                            panel.Joueurs.get(l).obtenirCle = false;
                            panel.Joueurs.get(l).restAction--;
                            panel.aqui = l;
                            System.out.print(panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j]);
                            if (panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j] == panel.air.name) {
                                panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j] = "Videplace";
                                panel.air.recuperCle++;
                                panel.Joueurs.get(l).gagneAirCle++;
                                panel.air.numcarte--;
                            } else if (panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j] == panel.eau.name) {
                                panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j] = "Videplace";
                                panel.eau.recuperCle++;
                                panel.Joueurs.get(l).gagneEauCle++;
                                panel.eau.numcarte--;
                            } else if (panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j] == panel.feu.name) {
                                panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j] = "Videplace";
                                panel.feu.recuperCle++;
                                panel.Joueurs.get(l).gagneFeuCle++;
                                panel.feu.numcarte--;
                            } else if (panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j] == panel.terre.name) {
                                panel.cartename[panel.Joueurs.get(l).i][panel.Joueurs.get(l).j] = "Videplace";
                                panel.terre.recuperCle++;
                                panel.Joueurs.get(l).gagneTerreCle++;
                                panel.terre.numcarte--;
                            }
                        }
                    }if (panel.Joueurs.get(panel.aqui).restAction == 0 && panel.aqui <= panel.Joueurs.size() - 2) {
                        panel.Joueurs.get(panel.aqui + 1).Atoi = true;
                        panel.Joueurs.get(panel.aqui).Atoi = false;
                    } else if (panel.Joueurs.get(panel.aqui).restAction == 0 && panel.aqui == panel.Joueurs.size() - 1) {
                        panel.Joueurs.get(0).Atoi = true;
                        panel.Joueurs.get(panel.aqui).Atoi = false;
                    }
                }
                panel.repaint();
            }
            @Override
            public void mousePressed(MouseEvent e) { }
            @Override
            public void mouseReleased(MouseEvent e) { }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        control.setBackground(Color.lightGray);
        frame.add(control,BorderLayout.EAST);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
