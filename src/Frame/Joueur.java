package Frame;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Joueur{
    BufferedImage img;
    Random cd = new Random();
    private int a=cd.nextInt(5);
    private int b=cd.nextInt(6);
    int c=cd.nextInt(5);
    int x=200+a*100;
    int y=200+b*80;
    int w=80;
    int h=80;
    int i;
    int j;
    int cadre;
    int getCapacite;
    int gagneAirCle=0;
    int gagneEauCle=0;
    int gagneFeuCle=0;
    int gagneTerreCle=0;
    int capaciteIngenieur=0;
    boolean utiliseCapaciteIngenieur=false;
    int restcapaciteIngenieur=2;
    int  capaciteExplorateur=1;
    int  capaciteNavigateur=2;
    int capacitePlongeur=3;
    int capaciteMessager=4;
    Boolean enleverEau=false;
    Boolean obtenirCle=false;
    int d,f;
    int k,m;

    Boolean Atoi;
    int nombreCapacite;
    int restAction=3;
    int joueurPlace[][]=new int[5][6];
    boolean peutdeplace[][]=new boolean[5][6];
    public Joueur(int m){
        this.m=getCapacite;
        img=App.getImg("/Img/J"+m+".png");
        i=(x-200)/100;
        j=(y-200)/80;

        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 5; j++) {
                joueurPlace[i][j]=0;
            }
        }

        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 5; j++) {
                peutdeplace[i][j] = true;
            }
        }

    }
    public  void action(int Ex,int Ey) {
        i=(x-200)/100;
         j=(y-200)/80;

        if(Math.abs(Ex-(x+50))<50&& Math.abs(Ey-(y+40))<40&&joueurPlace[i][j] == 0) {
            joueurPlace[i][j] = 1;
            System.out.println( joueurPlace[i][j] +"baba");
        }else  if ( Math.abs(Ex-(x+50))>50&&Math.abs(Ex-(x+50))<150&& Math.abs(Ey-(y+40))<40 && joueurPlace[i][j] == 1
                ||Math.abs(Ex-(x+50))<50 && Math.abs(Ey-(y+40))<120 &&Math.abs(Ey-(y+40))>40&& joueurPlace[i][j] == 1 ){
           joueurPlace[i][j]=0;
            this.x=Ex;
            this.y=Ey;
            i=(x-200)/100;
            j=(y-200)/80;
            this.x=200+i*100;
            this.y=200+j*80;
            restAction--;
            System.out.println("fois"+restAction);
        }else if(Math.abs(Ex-(x+50))<50&& Math.abs(Ey-(y+40))<40&&joueurPlace[i][j] ==1){
            this.d=Ex;
            this.f=Ey;
            this.k=(d-200)/100;
            this.m=(f-200)/80;
            this.enleverEau=true;
            joueurPlace[i][j]=0;
            System.out.print(x);
        }else if(Math.abs(Ex-(x+50))<150&& Math.abs(Ey-(y+40))<40 && joueurPlace[i][j] == 0 ||Math.abs(Ex-(x+50))<50 && Math.abs(Ey-(y+40))<120 && joueurPlace[i][j] == 0 ){
            this.d=Ex;
            this.f=Ey;
            this.k=(d-200)/100;
            this.m=(f-200)/80;
            this.enleverEau=true;
        }
    }


    public void actionExplorateur(int Ex,int Ey){
        if(Math.abs(Ex-(x+50))<50&& Math.abs(Ey-(y+40))<40&&joueurPlace[i][j] == 0) {
            joueurPlace[i][j] = 1;
            System.out.println( joueurPlace[i][j] +"baba");
        }else  if (Math.abs(Ex-(x+50))<150 && Math.abs(Ey-(y+40))<120 && joueurPlace[i][j] == 1){
            joueurPlace[i][j]=0;
            this.x=Ex;
            this.y=Ey;
            i=(x-200)/100;
            j=(y-200)/80;
            this.x=200+i*100;
            this.y=200+j*80;
            restAction--;
            System.out.println("fois"+restAction);
        }else if(Math.abs(Ex-(x+50))<50&& Math.abs(Ey-(y+40))<40&&joueurPlace[i][j] ==1){
            this.d=Ex;
            this.f=Ey;
            this.k=(d-200)/100;
            this.m=(f-200)/80;
            this.enleverEau=true;
            joueurPlace[i][j]=0;
            System.out.print(x);
        }else if(Math.abs(Ex-(x+50))<150&& Math.abs(Ey-(y+40))<40 && joueurPlace[i][j] == 0 ||Math.abs(Ex-(x+50))<50 && Math.abs(Ey-(y+40))<120 && joueurPlace[i][j] == 0 ){
            this.d=Ex;
            this.f=Ey;
            this.k=(d-200)/100;
            this.m=(f-200)/80;
            this.enleverEau=true;
        }
    }


    public void recuper(int Ex,int Ey){
        if(Ex >= 740 && Ex <= 820 && Ey   >= 490 && Ey <= 520){
            this.obtenirCle=true;
            System.out.print(100);
        }
    }

    public void usecapaciteIngenieur(int Ex,int Ey){
        this.d=Ex;
        this.f=Ey;
        this.k=(d-200)/100;
        this.m=(f-200)/80;
        utiliseCapaciteIngenieur=true;
    }

}
