
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegogoku;
import java.util.*;
import bpc.daw.consola.*;
import com.sun.glass.events.KeyEvent;
import java.awt.*;
import java.io.*;

import java.time.Instant;
import javax.imageio.*;
//import bpc.daw.reproductor.*;
public class JuegoGoku {

    public static void main(String[] args) {
//        PlayList listaCanciones=new PlayList();
//        
//        ArchivoMP3 cancion=
//             new ArchivoMP3
//            ("uno.mp3");
//        ArchivoMP3 cancion2= new ArchivoMP3
//            ("dos.mp3");
//        listaCanciones.añadir(cancion);
//        listaCanciones.añadir(cancion2);
//        Reproductor reproductor=new Reproductor(listaCanciones, false,false);
//        
        
        
        
        Consola c=new Consola();
        CapaSprites cS=c.getCapaSprites();
        CapaFondo fondo=c.getCapaFondo();
        CapaTexto texto=c.getCapaTexto();
        CapaCanvas cC=c.getCapaCanvas();
        Teclado t=c.getTeclado();
        Graphics g=cC.getGraphics();
        t.setTipoCursor(Teclado.CURSOR_NULO );
        
        FondoColorSolido fondoColor=new FondoColorSolido(34,212,220);
        fondo.setFondo(fondoColor);
        texto.setColorTexto(Color.red);
        texto.setTamTexto(30);
        File ruta=new File
        ("letra2.ttf");
        Font tipoLetra=null;
        try{
            tipoLetra=Font.createFont(Font.TRUETYPE_FONT,ruta);
        }catch(IOException | FontFormatException e){
            texto.print("eeror");
        }
        texto.setFont(tipoLetra);
       Image imaGoku=null;
        Image imaGoku2=null;
        Image imaSuelo=null;
        Image imaSuper=null;
        Image imaRana=null;
        Image imaFondo=null;
        Image imaBolas=null;
        Image imaNoche=null;
        Image imaBarra=null;
        Image imaAve=null;
        Image imaInicio=null;
        Image imaCell=null;
        Image imaNube=null;
        Image imaPlanetas=null;
        Image imaNivel2=null;
//        Image imaConsejo=null;
//        Image imaConsejo2=null;
//        Image imaConsejo3=null;
//        Image imaConsejo4=null;

        try{
//            imaConsejo=ImageIO.read(new File("consejo11.png"));
//            imaConsejo2=ImageIO.read(new File("consejo2.png"));
//            imaConsejo3=ImageIO.read(new File("consejo3.png"));
//           imaConsejo4=ImageIO.read(new File("consejo4.png"));
            imaNube=ImageIO.read(new File("nubes.gif"));
            imaGoku=ImageIO.read(new File("goku2.gif"));
            imaGoku2=ImageIO.read(new File("goku22.gif"));
            imaCell=ImageIO.read(new File("cell.gif"));
            imaSuper=ImageIO.read(new File("gokuSuper.png"));
            imaRana=ImageIO.read(new File("rana.gif"));
            imaFondo=ImageIO.read(new File("fondo.gif"));
            imaBolas=ImageIO.read(new File("bolas.gif"));
            imaNoche=ImageIO.read(new File("noche1.gif"));
            imaBarra=ImageIO.read(new File("barras.gif"));
            imaAve=ImageIO.read(new File("ave.gif"));
            imaInicio=ImageIO.read(new File("inicio.gif"));
            imaPlanetas=ImageIO.read(new File("planetas.gif"));
            
        }catch(IOException error){
            g.drawString("error "+error.getMessage(), 200,200);
        }
        Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();
        double ancho=dimension.getWidth();//1366
        double alto=dimension.getHeight();//768
        
//                                                                     LISTA DE RECTANGULOS PARA COODENADAS       
//---------------------------------------------------------------------------------------------------------------------------------------------------        
        
        Rectangle[] fondoInicio={
            new Rectangle(10,4,988,251),
            new Rectangle(75,347,799,99)
        };
        
        Rectangle[] fondoPlataforma={
            new Rectangle(244,18,76,30),
            new Rectangle(5,350,583,128),
            new Rectangle(496,98,352,175),//ARBOLES
            new Rectangle(13,200,580,120),
            new Rectangle(17,26,575,139),
            new Rectangle(530,291,200,50),//SETOS
            new Rectangle(510,28,50,50)
        };
        Rectangle[] suelo={
            new Rectangle(196,40,1700,1),
            new Rectangle(196,40,583,1),
            new Rectangle(196,40,480,1)
        };
        
        
                
        Rectangle posicionNoNULL=new Rectangle(382,593,1,1);
        
        Rectangle disparoSuperD=new Rectangle(382,593,119,63);
        Rectangle disparoSuperI=new Rectangle(374,278,120,66);
        Rectangle gokuParado=new Rectangle(11,149,26,41);
        Rectangle gokuDispararD=new Rectangle(3,563,30,35);
        Rectangle gokuDispararI=new Rectangle(794,559,33,37);
        
        
        
        Rectangle consejo=new Rectangle(56,85,324,341);
        
        Rectangle[][] decoracionFondo={
            {
                new Rectangle(365,9,205,94),
                new Rectangle(347,7,447,98),
                new Rectangle(393,200,152,88)
            },{ 
                new Rectangle(800,0,116,116),
                new Rectangle(365,9,205,94),
                new Rectangle(393,200,152,88),
            },{ 
                new Rectangle(800,0,116,116),
                new Rectangle(365,9,205,94),
                new Rectangle(393,200,152,88),
            }  
                
       };
    
        Rectangle[] explosion={
        
            new Rectangle(639,619,110,81),
            new Rectangle(639,619,110,81),
            new Rectangle(639,619,110,81),
            new Rectangle(639,619,110,81),
            new Rectangle(639,619,110,81),
            new Rectangle(510,589,120,112),
            new Rectangle(510,589,120,112),
            new Rectangle(510,589,120,112),
            new Rectangle(510,589,120,112),
            new Rectangle(510,589,120,112),
            new Rectangle(325,544,165,153),
            new Rectangle(325,544,165,153),
            new Rectangle(325,544,165,153),
            new Rectangle(48,492,247,208),
            new Rectangle(48,492,247,208),
            new Rectangle(639,619,110,81),
            new Rectangle(639,619,110,81),
            new Rectangle(639,619,110,81),
            new Rectangle(639,619,110,81),
            new Rectangle(639,619,110,81),
            new Rectangle(510,589,120,112),
            new Rectangle(510,589,120,112),
            new Rectangle(510,589,120,112),
            new Rectangle(510,589,120,112),
            new Rectangle(510,589,120,112),
            new Rectangle(325,544,165,153),
            new Rectangle(325,544,165,153),
            new Rectangle(325,544,165,153),
            new Rectangle(48,492,247,208),
            new Rectangle(48,492,247,208),
            
            
        };
        Rectangle[] bolaSuper={
            new Rectangle(510,594,67,63),
            new Rectangle(510,594,67,63),
            new Rectangle(510,594,67,63),
            new Rectangle(510,594,67,63),
            new Rectangle(510,594,67,63),
            new Rectangle(510,594,67,63),
            new Rectangle(510,594,67,63),
            new Rectangle(510,594,67,63),
            new Rectangle(510,594,67,63),
            new Rectangle(510,594,67,63),
            new Rectangle(510,594,67,63),
            
            
         };
        Rectangle[] bolaFuego={
            new Rectangle(173,604,22,21),
            new Rectangle(173,604,22,21),
            new Rectangle(173,604,22,21),
            new Rectangle(173,604,22,21),
            new Rectangle(173,604,22,21),
            new Rectangle(173,604,22,21),
            new Rectangle(173,604,22,21),
            new Rectangle(173,604,22,21),
            new Rectangle(173,604,22,21),
            new Rectangle(173,604,22,21),
            new Rectangle(173,604,22,21),
        };
    
        
        
       Rectangle[] bolas={
           new Rectangle(87,66,63,61),
           new Rectangle(156,38,58,61),
           new Rectangle(155,113,59,59),
           new Rectangle(90,128,60,65),
           new Rectangle(18,115,63,59),
           new Rectangle(17,37,65,62),
           new Rectangle(83,2,61,57)
       };
        Rectangle[][]gokuSaltar={
            {
            new Rectangle(9,285,43,48),
            new Rectangle(741,287,37,43),
            },
            { 
             new Rectangle(636,21,60,56),
             new Rectangle(719,36,53,60),
              
              
            }
     
        };
        Rectangle[] gokuMuere={
            new Rectangle(154,333,41,45),
            new Rectangle(154,333,41,45),
            new Rectangle(154,333,41,45),
            new Rectangle(154,333,41,45),
            new Rectangle(454,330,40,45)
        };
        
        Rectangle[][] GokuCorrer={
            {
                new Rectangle(9,196,29,41),
                new Rectangle(49,196,25,39),
                new Rectangle(79,196,29,37),
                new Rectangle(114,196,27,37),
                new Rectangle(145,194,27,41),
                new Rectangle(175,196,27,39),
                new Rectangle(208,196,26,38),
                new Rectangle(243,196,29,38)}
            ,{   
                new Rectangle(802,145,29,41),
                new Rectangle(767,194,25,39),
                new Rectangle(734,196,29,37),
                new Rectangle(703,196,27,37),
                new Rectangle(671,194,27,41),
                new Rectangle(642,196,27,39),
                new Rectangle(607,196,26,38),
                new Rectangle(572,195,29,38)
            }
        };
        Rectangle[]superVelocidad={
                new Rectangle(38,400,41,34),
                new Rectangle(549,626,32,55),
                new Rectangle(380,400,41,34),
                new Rectangle(549,626,32,55),
                new Rectangle(380,400,41,34),
                
         };
        Rectangle[][] gokuSuper={
            {
                new Rectangle(467,379,66,60),
                new Rectangle(533,382,66,60),
                new Rectangle(606,382,66,60),
        
            },
            {
                new Rectangle(357,77,48,48),
                new Rectangle(279,70,68,56),
                new Rectangle(208,68,69,56)
            }
        };
        Rectangle[][] aveMover={
            {new Rectangle(20,338,129,154),
            new Rectangle(219,315,148,83),
            new Rectangle(421,290,155,104),
            new Rectangle(630,234,132,144)
            },
            {new Rectangle(36,2,136,144),
            new Rectangle(234,58,144,87),
            new Rectangle(441,86,147,74),
            new Rectangle(652,93,133,142)
            }
            
        };
        Rectangle[] noche={
            new Rectangle(360,367,80,74),
            new Rectangle(357,200,82,81)
        };
        Rectangle[][] ranaMover={
            {
                new Rectangle(7,86,62,54),
                new Rectangle(76,90,64,49),
                new Rectangle(146,85,67,55),
                new Rectangle(220,83,71,58),
                new Rectangle(296,82,76,59),
                new Rectangle(375,85,71,56),
                new Rectangle(453,85,71,59),
                new Rectangle(213,162,71,55),//empieza ataque rana
                new Rectangle(285,160,97,58),
                new Rectangle(383,160,105,58),
                new Rectangle(490,159,110,60),
                new Rectangle(607,157,70,61),
            },
            {
                new Rectangle(16,314,71,55),
                new Rectangle(89,314,71,55),
                new Rectangle(174,314,71,55),
                new Rectangle(248,314,71,55),
                new Rectangle(314,314,71,55),
                new Rectangle(390,314,71,55),
                new Rectangle(459,314,71,55),
                new Rectangle(540,314,71,55),
                new Rectangle(610,314,71,55),
                new Rectangle(689,314,71,55),
                new Rectangle(760,314,71,55),
                new Rectangle(832,314,71,55),
            }
        };
        Rectangle[] planetas={
            new Rectangle(659,358,319,242),
            new Rectangle(235,189,185,187),
            new Rectangle(173,12,151,141),
            new Rectangle(6,8,168,155)
        };
         Rectangle[][] cell={{
            new Rectangle(1150,160,102,148),//recto
         
            new Rectangle(994,361,121,110),//avanzando volando
          
            new Rectangle(986,615,145,126),//disparando
         },{
             new Rectangle(1141,931,131,131),
             new Rectangle(983,943,131,121),
             new Rectangle(790,940,170,129),
             new Rectangle(653,919,117,152),
             new Rectangle(463,922,160,150),
             new Rectangle(313,920,122,150),
             new Rectangle(172,968,131,101),
         },{
             new Rectangle(1163,627,118,112),
             new Rectangle(1163,627,118,112),
             new Rectangle(1163,627,118,112),
             new Rectangle(987,614,148,128),
             new Rectangle(987,614,148,128),
             new Rectangle(987,614,148,128),
             new Rectangle(987,614,148,128),
         }
            
        };
         Rectangle[][] disparoCell={
             {
                 new Rectangle(116,1256,77,42),
                 new Rectangle(236,1256,48,44)},
             {
                 new Rectangle(843,535,310,41),
                 new Rectangle(512,534,311,41)
                 
             }
         
         };
        Color[] listaColor={
            new Color(34,212,220),
            new Color(25,53,192),
            new Color(192,98,25)
        };                                    //VARIABLES 
 //-------------------------------------------------------------------------------------------------------------------------------   
 
        boolean volarCell=false;
        boolean permitirVolar=true;
        boolean activarExplosion=false;
        int desactivarExplo=0;
        int vueltasExpl=0;
        int posXexplo=0;
        int posYexpo=0;
 
        int colorFondo=0;
         
        int jugarNivel=0;          
        int nivel=1;
        
        int posicionSuelo=0;
        int vuelta=0;
        int sprite=0;
        
        int posicionXfondo=0;
        int posicionX=200;
        int posicionY=0;
        int sentido=0;
        
        int sentidoAve=1;
        int sentidoSpriteAve=0;
        int sentidoSpriteAve2=1;
        
        int sentidoSpriteRana2=1;
        int sentidoSpriteRana=0;
        int spriteRana=0;
        
      
        int sentidoRana=1;
        int vidaEnemigo1=10;
        int vidaEnemigo2=10;
        int vidaEnemigo3=10;
        
        int sueloY3=300;
        int sueloY4=500;
        int sueloY1=600;
        int sueloY2=350;
                                                    //  PLATAFORMAS
        int inicioSuelo3=1600;
        int inicioSuelo4=2500;
        int inicioSuelo2=800;
        int inicioSuelo1=100;
        
        int posRanaX=inicioSuelo2;
        int posRanaY=0;
        int posRanaX2=inicioSuelo3+500;
        int posRanaY2=0; 
        
        int posRanaX3=inicioSuelo4;
        int posRanaY3=0; 
                              //                        RANAS
        int INICIOranaY=posRanaY;
        int INICIOranaY2=posRanaY2;
        int INICIOranaY3=posRanaY3;
        
        int posAveX=700;
        int posAveY=200;
        int posAveX2=1400;                      //      AVES
        int posAveY2=500; 
        
        int posAveX3=2100;
        int posAveY3=600; 
        
        int gokuNivel=0;
        
        int vidaAve=10;
        int spriteAve=0;
      
        int vidaCell=100;
        int posXcell=1100;
        int posYcell=500;                //  CELL
        int vuelta1Cell=0;
        int vuelta2Cell=0;
        int vuelta3Cell=0;
        int spriteCell=0;
        int sentidoCell=1;
        int sentidoCellY=1;
        int spriteDisparo=0;
        int spriteMovDisparoCell=0;
        int vueltaCellPresentacion=0;
        int spriteSecuenciaCell=0;
        
        int posYdisparocell=posYcell;
        int posXdisparoCell=posXcell;
        
        int spriteVolar=0;
        int spriteSuper=0;
        int spritePegar=0;
        
        int victoria=7;
        int vidaGoku=5;
        
        
        int sentidoBola=0;
        int bolasChicas=100;
        int spriteBola=0;
        int contador=0;
        int posicionBola=posicionX+(15*1);
        int vueltasBola=0;
        boolean desactivarKameha=false;
        
        int spriteExplosion=0;
        
        
        int direccion=1;
        
        int posXnube=700;
        
        int inicioConsejo=100;
        int sentidoConsejo=1;
        int vueltasConsejo=0;
        
 //                                                MENU DE INICIO
 //---------------------------------------------------------------------------------------------------------------------------------------
//       reproductor.play();
        boolean iniciar=true;
        while(iniciar){
            
            Random r=new Random();
            int B=900;
            int b1=100+r.nextInt(B);
            int b2=posRanaX+200;
            int b3=b2+r.nextInt(B);
            int b4=posRanaX2+200;
            int b5=b3+r.nextInt(B);
            int b6=b5+r.nextInt(B);
            int b7=posRanaX3+200;
            int C=500;
            int c1=100+r.nextInt(C);//     posicion de las bolas de dragon
            int c2=posRanaY;
            int c3=100+r.nextInt(C);
            int c4=posRanaY2;
            int c5=100+r.nextInt(C);
            int c6=100+r.nextInt(C);
            int c7=posRanaY3;
            fondoColor=new FondoColorSolido(listaColor[colorFondo]);
            fondo.setFondo(fondoColor);
            Sprite DBZ=null;
            Sprite DBZ2=null;
            Sprite DBZ3=null;
            Sprite kameha=cS.crearSprite(imaGoku, posicionNoNULL, -1000, -1000);
            Sprite explo=cS.crearSprite(imaCell, posicionNoNULL,-1000, -1500);
            Sprite nubeUNO=cS.crearSprite(imaGoku, posicionNoNULL,0, 200);
            Sprite nubeDOS=cS.crearSprite(imaGoku, posicionNoNULL,0, 500);
            Sprite nubeTRES=cS.crearSprite(imaGoku, posicionNoNULL,0, 400);
                
                
            Sprite bolaDragon=cS.crearSprite(imaGoku, posicionNoNULL,0,c1);
            Sprite bolaDragon2=cS.crearSprite(imaGoku, posicionNoNULL,0,c2);
            Sprite bolaDragon3=cS.crearSprite(imaGoku, posicionNoNULL,0,c3);
            Sprite bolaDragon4=cS.crearSprite(imaGoku, posicionNoNULL,0,c4);
            Sprite bolaDragon5=cS.crearSprite(imaGoku, posicionNoNULL, 0,c5);
            Sprite bolaDragon6=cS.crearSprite(imaGoku, posicionNoNULL,0,c6);
            Sprite bolaDragon7=cS.crearSprite(imaGoku, posicionNoNULL,0,c7);
               
    
            Sprite bloque3=cS.crearSprite(imaGoku, posicionNoNULL, 0,sueloY3);
            Sprite bloque4=cS.crearSprite(imaGoku, posicionNoNULL,0, sueloY4);
            Sprite bloque2=cS.crearSprite(imaGoku, posicionNoNULL, 0, sueloY2);
            Sprite bloque1=cS.crearSprite(imaGoku, posicionNoNULL, 0, sueloY1);
            
            Sprite enemigo1=cS.crearSprite(imaAve,posicionNoNULL , -200, c1);
            Sprite enemigo2=cS.crearSprite(imaAve,posicionNoNULL , -200, c1);; 
            Sprite enemigo3=cS.crearSprite(imaAve,posicionNoNULL , -200, c1);;
            Sprite enemigoCELL=cS.crearSprite(imaAve,posicionNoNULL , -200, c1);;
               // Sprite bloque5=cS.crearSprite(imaBarra, fondoPlataforma[1],2*inicioSuelo3+posicionXfondo, posicionPlataforma1-200);
              
               
            Sprite plataforma11=cS.crearSprite(imaGoku, posicionNoNULL,0,sueloY3-5);// 3
            plataforma11.setVisible(false);
            Sprite plataforma22=cS.crearSprite(imaGoku, posicionNoNULL,0,sueloY4-5);//  4
            plataforma22.setVisible(false);
            Sprite plataforma33=cS.crearSprite(imaGoku, posicionNoNULL,0,sueloY2-5);//2
            plataforma33.setVisible(false);
            Sprite plataforma44=cS.crearSprite(imaGoku, posicionNoNULL,0,sueloY1-5);//1
            plataforma44.setVisible(false);
               // Sprite plataforma55=cS.crearSprite(imaSuelo, suelo[1],2*inicioSuelo3-40+posicionXfondo,(posicionPlataforma1-5)-200);
              //  plataforma55.setVisible(false);

            Sprite arboles=cS.crearSprite(imaGoku, posicionNoNULL,0, sueloY3-170);
            Sprite arboles1=cS.crearSprite(imaGoku, posicionNoNULL,0, sueloY4-170);
            Sprite setos=cS.crearSprite(imaGoku, posicionNoNULL,0, sueloY2-43);
            Sprite setos1=cS.crearSprite(imaGoku, posicionNoNULL,0, sueloY1-43);
            Sprite caja=cS.crearSprite(imaGoku, posicionNoNULL,0, sueloY1-45);
           
            
            for(int i=-200;i<300;i++){
                DBZ=cS.crearSprite(imaInicio,fondoInicio[0],i,100);
                try{
                    Thread.sleep(1);                                            //FOR PARA IMAGEN INICIO
                }catch(Exception e){
                }
                cS.eliminarSprite(DBZ);
            }
            for(int i=0;i<100;i++){
                DBZ2=cS.crearSprite(imaInicio,fondoInicio[0],300-i,100);
                try{
                    Thread.sleep(3);
                }catch(Exception e){
                }
                cS.eliminarSprite(DBZ2);
            }
            DBZ2=cS.crearSprite(imaInicio,fondoInicio[0],200,100);
            for(int i=0;i<1000;i++){
                DBZ3=cS.crearSprite(imaInicio,fondoInicio[1],1300-i,400);
                try{
                    Thread.sleep(1);
                }catch(Exception e){
                }
                cS.eliminarSprite(DBZ3);
            }
            DBZ3=cS.crearSprite(imaInicio,fondoInicio[1],300,400);
            //----------------------------------------------------------------- OPCIONES DISPONIBLES
            texto.setColorTexto(Color.RED);
            texto.print(13,5,"  LA GRAN AVENTURA  PULSA   <ESPACIO>");
            texto.setColorTexto(Color.BLACK);
            texto.print(14,5,"  VER LOS CONTROLES PULSA   <   O   > ");
            texto.setColorTexto(Color.RED);
            texto.print(15,5,"  DESACTIVAR LA MUSICA      <   D   > ");
            texto.setColorTexto(Color.BLACK);
            texto.print(16,5,"  NIVELES                   <1,2,3,4>" );
            texto.setColorTexto(Color.RED);
            texto.print(17,5,"  SALIR                     <  ESC  > ");
            char letra=t.leerCaracter();
            texto.cls();
            cS.eliminarSprite(DBZ);
            cS.eliminarSprite(DBZ2);
            cS.eliminarSprite(DBZ3);
 //                                         OPCION N
 //-------------------------------------------------------------------------------
            boolean repetir=false;
           
            if(t.teclaPulsada(KeyEvent.VK_1)){
                    nivel=1;
                   
                }
                if(t.teclaPulsada(KeyEvent.VK_2)){
                    nivel=2;
                   
                }
                if(t.teclaPulsada(KeyEvent.VK_3)){
                    nivel=3;
                   
                }
                if(t.teclaPulsada(KeyEvent.VK_4)){
                    nivel=4;
                    
                }
                
            //   OPCION O
            if(t.teclaPulsada(KeyEvent.VK_O)){
            
              texto.print(10,10,"ESPACIO:       SUPER VELOCIDAD");
              texto.print(11,10,"M:             KAMEHA");
              texto.print(12,10,"K:             SUPER KAMEHA");
             
              texto.print(9,10,"W:             VOLAR");
              texto.print(7,10,"D:             DERECHA");
              texto.print(6,10,"A:             IZQUIERDA");
              texto.print(8,10,"S:             VOLAR");
              
              t.leerCaracter();
              texto.cls();
            
            }
            //  OPOCION ESCAPE
            if(t.teclaPulsada(KeyEvent.VK_ESCAPE)){
                iniciar=false;
            }
            if(t.teclaPulsada(KeyEvent.VK_D)){
            // reproductor.stop();
            }
            
            
            // OPCION ESPACIO EMPEZAR
             if(t.teclaPulsada(KeyEvent.VK_SPACE)){
                repetir=true;
             //   reproductor.siguienteCancion();
            }
               
              
            //                                          COMIENZA LA PARTIDA
//----------------------------------------------------------------------------------------------------------------------------------------            
            while(repetir){
             
                if(sentido==0){
                    direccion=1;
                }
                if(sentido==1){
                    direccion=-1;
                }
                
                cS.crearSprite(imaGoku, new Rectangle(1,1,184,98),10,10);//imagen de goku menu            
                Sprite goku=cS.crearSprite(imaGoku, gokuParado, posicionX, posicionY);//goku parado
                posXnube--;//movimiento del fondo
                
                vuelta++;
                if((nivel==1||nivel==2)&&vuelta==4){
                    spriteAve++;
                    spriteAve=spriteAve%4;
                    posAveX+=10*sentidoAve;
                    posAveX2+=10*(-sentidoAve);//CAMBIAMOS SENTIDO
                    posAveX3+=10*sentidoAve;
                    
                    spriteRana++;
                    spriteRana=spriteRana%12;
                    posRanaX+=5*sentidoRana;
                    posRanaX2+=5*(-sentidoRana);//CAMBIAMOS EL SENTIDO DEL ENEMIGO
                    posRanaX3+=5*sentidoRana;
                    vuelta=0;
                }
                 // ---------------------MOVIMIENTO DE CELL  "ME COSTO BASTANTE SACAR ALGO DECENTE"
                 //                     JUGANDO CON LAS VUELTAS Y LAS POSICIONES PODEMOS SACAR UNA SECUENCIA CHULA DE MOVIMIENTO
            
                if(nivel==1){
                    enemigo1=cS.crearSprite(imaRana, ranaMover[sentidoSpriteRana][spriteRana], posRanaX+posicionXfondo, posRanaY);
                    enemigo2=cS.crearSprite(imaRana, ranaMover[sentidoSpriteRana2][spriteRana], posRanaX2+posicionXfondo, posRanaY2);
                    enemigo3=cS.crearSprite(imaRana, ranaMover[sentidoSpriteRana][spriteRana], posRanaX3+posicionXfondo, posRanaY3);
                        
                    nubeUNO=cS.crearSprite(imaNube, decoracionFondo[colorFondo][0], posXnube, 200);
                    nubeDOS=cS.crearSprite(imaNube, decoracionFondo[colorFondo][1], posXnube+300, 500);
                    nubeTRES=cS.crearSprite(imaNube, decoracionFondo[colorFondo][2], posXnube-300, 400);


                    bolaDragon=cS.crearSprite(imaBolas, bolas[0],b1+posicionXfondo,c1);
                    bolaDragon2=cS.crearSprite(imaBolas, bolas[1],b2+posicionXfondo,c2);
                    bolaDragon3=cS.crearSprite(imaBolas, bolas[2],b3+posicionXfondo,c3);
                    bolaDragon4=cS.crearSprite(imaBolas, bolas[3],b4+posicionXfondo,c4);
                    bolaDragon5=cS.crearSprite(imaBolas, bolas[4],b5+posicionXfondo,c5);
                    bolaDragon6=cS.crearSprite(imaBolas, bolas[5],b6+posicionXfondo,c6);
                    bolaDragon7=cS.crearSprite(imaBolas, bolas[6],b7+posicionXfondo,c7);

                    bloque3=cS.crearSprite(imaBarra, fondoPlataforma[1], inicioSuelo3+posicionXfondo,sueloY3);
                    bloque4=cS.crearSprite(imaBarra, fondoPlataforma[1],inicioSuelo4+posicionXfondo, sueloY4);
                    bloque2=cS.crearSprite(imaBarra, fondoPlataforma[3], inicioSuelo2+posicionXfondo, sueloY2);
                    bloque1=cS.crearSprite(imaBarra, fondoPlataforma[3], inicioSuelo1+posicionXfondo, sueloY1);
        
                    plataforma11=cS.crearSprite(imaSuelo, suelo[1],inicioSuelo3+posicionXfondo,sueloY3-5);// 3
                    plataforma11.setVisible(false);
                    plataforma22=cS.crearSprite(imaSuelo, suelo[1],inicioSuelo4+posicionXfondo,sueloY4-5);//  4
                    plataforma22.setVisible(false);
                    plataforma33=cS.crearSprite(imaSuelo, suelo[2],50+inicioSuelo2+posicionXfondo,sueloY2-5);//2
                    plataforma33.setVisible(false);
                    plataforma44=cS.crearSprite(imaSuelo, suelo[2],50+inicioSuelo1+posicionXfondo,sueloY1-5);//1
                    plataforma44.setVisible(false);
  
                    arboles=cS.crearSprite(imaFondo, fondoPlataforma[2], inicioSuelo3+posicionXfondo+200, sueloY3-170);
                    arboles1=cS.crearSprite(imaFondo, fondoPlataforma[2], inicioSuelo4+posicionXfondo+10, sueloY4-170);
                    setos=cS.crearSprite(imaFondo, fondoPlataforma[5], 300+inicioSuelo2+posicionXfondo, sueloY2-43);
                    setos1=cS.crearSprite(imaFondo, fondoPlataforma[5], 100+inicioSuelo1+posicionXfondo, sueloY1-43);
                    caja=cS.crearSprite(imaFondo, fondoPlataforma[6], 300+inicioSuelo1+posicionXfondo, sueloY1-45);
                   
//                  
                }
                
                if(nivel==2){
                    if(INICIOranaY>posAveY){
                        posAveY+=10;
                    }
                    if(INICIOranaY2>posAveY2){
                        posAveY2+=10;             //PARA QUE VUELVAN A APARECER AL MATARLAS
                    }
                    if(INICIOranaY3>posAveY3){
                        posAveY3+=10;
                    }  
                       nubeUNO=cS.crearSprite(imaNube, decoracionFondo[colorFondo][0], posXnube, 200);
                       nubeDOS=cS.crearSprite(imaNube, decoracionFondo[colorFondo][1], posXnube+300, 500);
                       nubeTRES=cS.crearSprite(imaNube, decoracionFondo[colorFondo][2], posXnube-300, 400);
                       bolaDragon=cS.crearSprite(imaBolas, bolas[0],b1+posicionXfondo,c1);
                       bolaDragon2=cS.crearSprite(imaBolas, bolas[1],b2+posicionXfondo,c2);
                       bolaDragon3=cS.crearSprite(imaBolas, bolas[2],b3+posicionXfondo,c3);
                       bolaDragon4=cS.crearSprite(imaBolas, bolas[3],b4+posicionXfondo,c4);
                       bolaDragon5=cS.crearSprite(imaBolas, bolas[4],b5+posicionXfondo,c5);
                       bolaDragon6=cS.crearSprite(imaBolas, bolas[5],b6+posicionXfondo,c6);
                       bolaDragon7=cS.crearSprite(imaBolas, bolas[6],b7+posicionXfondo,c7);
                       enemigo1=cS.crearSprite(imaAve, aveMover[sentidoSpriteAve][spriteAve],posAveX+posicionXfondo, posAveY);
                       enemigo2=cS.crearSprite(imaAve, aveMover[sentidoSpriteAve2][spriteAve],posAveX2+posicionXfondo,posAveY2);
                       enemigo3=cS.crearSprite(imaAve, aveMover[sentidoSpriteAve][spriteAve],posAveX3+posicionXfondo,posAveY3);
                       bloque2=cS.crearSprite(imaAve, aveMover[sentidoSpriteAve2][spriteAve],posAveX2+1000+posicionXfondo,posAveY2-300);
                       bloque3=cS.crearSprite(imaAve, aveMover[sentidoSpriteAve][spriteAve],posAveX+1000+posicionXfondo, posAveY);
                       bloque4=cS.crearSprite(imaAve, aveMover[sentidoSpriteAve][spriteAve],posAveX3+800+posicionXfondo,posAveY3-300);
                       colorFondo=1;              
                       gokuNivel=1;
                       desactivarKameha=true;
                       
                }if(nivel==3){
                       nubeUNO=cS.crearSprite(imaNube, decoracionFondo[colorFondo][0], posXnube, 200);
                       nubeDOS=cS.crearSprite(imaNube, decoracionFondo[colorFondo][1], posXnube+300, 500);
                       nubeTRES=cS.crearSprite(imaNube, decoracionFondo[colorFondo][2], posXnube-300, 400);
                       bolaDragon=cS.crearSprite(imaBolas, bolas[0],b1+posicionXfondo,c1);
                       bolaDragon2=cS.crearSprite(imaBolas, bolas[1],b2+posicionXfondo,c2);
                       bolaDragon3=cS.crearSprite(imaBolas, bolas[2],b3+posicionXfondo,c3);
                       bolaDragon4=cS.crearSprite(imaBolas, bolas[3],b4+posicionXfondo,c4);
                       bolaDragon5=cS.crearSprite(imaBolas, bolas[4],b5+posicionXfondo,c5);
                       bolaDragon6=cS.crearSprite(imaBolas, bolas[5],b6+posicionXfondo,c6);
                       bolaDragon7=cS.crearSprite(imaBolas, bolas[6],b7+posicionXfondo,c7);
                       enemigo1=cS.crearSprite(imaNoche, noche[0],posAveX+posicionXfondo, posRanaY);
                       enemigo2=cS.crearSprite(imaNoche, noche[1],posAveX2+posicionXfondo,posRanaY2);
                       enemigo3=cS.crearSprite(imaNoche, noche[0],posAveX3+posicionXfondo,posRanaY3);
                       bloque2=cS.crearSprite(imaNoche, noche[1],posAveX2+400+posicionXfondo,posRanaY2);
                       bloque3=cS.crearSprite(imaNoche, noche[0],posAveX+600+posicionXfondo, posRanaY);
                       bloque4=cS.crearSprite(imaNoche, noche[1],posAveX3-1700+posicionXfondo,posRanaY3);
                       arboles=cS.crearSprite(imaNoche, noche[0],posAveX+800+posicionXfondo, posRanaY);
                       setos1=cS.crearSprite(imaNoche, noche[1],posAveX2+900+posicionXfondo,posRanaY2);
                       arboles1=cS.crearSprite(imaNoche, noche[0],posAveX3+100+posicionXfondo,posRanaY3);
                       colorFondo=2;              
                       gokuNivel=1;
                       desactivarKameha=true;          
                       
                }
                  vuelta1Cell++;
                if(nivel==4){
                      
                     nubeUNO=cS.crearSprite(imaPlanetas, planetas[0], 600, 100);
                     nubeDOS=cS.crearSprite(imaPlanetas, planetas[2], 100, 300);
                     nubeTRES=cS.crearSprite(imaPlanetas, planetas[3], 800, 550);
                     bloque2=cS.crearSprite(imaBarra, fondoPlataforma[3], inicioSuelo1+posicionXfondo+600, sueloY1);
                     bloque1=cS.crearSprite(imaBarra, fondoPlataforma[3], inicioSuelo1+posicionXfondo, sueloY1);
                     plataforma33=cS.crearSprite(imaSuelo, suelo[2],50+inicioSuelo1+posicionXfondo+600,sueloY1-5);//2
                     plataforma44=cS.crearSprite(imaSuelo, suelo[2],50+inicioSuelo1+posicionXfondo,sueloY1-5);//1
                     enemigoCELL=cS.crearSprite(imaCell, cell[spriteSecuenciaCell][spriteCell], posXcell,posYcell);
                     colorFondo=2;
                     gokuNivel=0;
                     vueltaCellPresentacion++;
                    if(vueltaCellPresentacion==2){
                        for(int i=0;i<cell[1].length;i++){
                            cS.eliminarSprite(enemigoCELL);
                            posXcell-=20;
                            enemigoCELL=cS.crearSprite(imaCell, cell[1][i],posXcell,posYcell);
                            try{
                             Thread.sleep(300);
                            }catch(Exception e){
                                
                            }
                        }
                        vuelta2Cell++;
                        if(vuelta2Cell>30&&nivel==4){  //cuando supere las 30 vuelas empieza a disparar 
                            cS.eliminarSprite(enemigo2);
                            cS.eliminarSprite(enemigo3);
                            vuelta3Cell++;
                            posXdisparoCell-=10;
                            spriteDisparo=0;
                            if(vuelta3Cell==50){ //CUANDO HACEMOS 50 VUELTAS "DISTANCIA QUE RECORRE " SALIMOS Y REINICIAMOS

                                spriteDisparo=0;
                            }
                            if(vuelta3Cell>200&&vuelta3Cell<250){ //CUANDO HACEMOS 50 VUELTAS "DISTANCIA QUE RECORRE " SALIMOS Y REINICIAMOS
                                spriteSecuenciaCell=spriteMovDisparoCell&cell[2].length;
                                spriteDisparo=1;
                            }
                            if(vuelta3Cell==350){ //CUANDO HACEMOS 50 VUELTAS "DISTANCIA QUE RECORRE " SALIMOS Y REINICIAMOS
                                vuelta2Cell=0;
                                vuelta3Cell=0;
                                spriteDisparo=1;
                            }
                            enemigo2=cS.crearSprite(imaCell, disparoCell[spriteSecuenciaCell][spriteDisparo],posXdisparoCell,posYcell);
                            enemigo3=cS.crearSprite(imaCell, disparoCell[spriteSecuenciaCell][spriteDisparo],posXdisparoCell,posYcell-200);
                        }else{
                            posXdisparoCell=posXcell;
                        }   
                    }
                    if(vuelta1Cell==3){ 
              
                       vuelta1Cell=0;
                       if(posXcell==1100){ 
                            sentidoCell=-1;
                            spriteCell=1;
                       }if(posXcell==800){
                           sentidoCell=1;
                            spriteCell=0;
                       }
                       if(posYcell==500){ 
                            sentidoCellY=-1;
                            
                       }if(posYcell==150){
                           sentidoCellY=1;
                           
                       }
                       
                       posYcell+=10*sentidoCellY;
                       posXcell+=10*sentidoCell;
                      
                }
                
                        
                }
               
                fondoColor=new FondoColorSolido(listaColor[colorFondo]);
                fondo.setFondo(fondoColor);
                texto.setColorTexto(Color.black);
                
                    if(inicioConsejo==300){
                        sentidoConsejo=-1;
                    }
                    if(inicioConsejo==10){
                        sentidoConsejo=1;
                    }
                    inicioConsejo+=5*sentidoConsejo;
                
//---------------------------------------------------------DISPAROS DE CELL MUY CHULO!!!                
                
                             vuelta2Cell++;
                if(vuelta2Cell>30&&nivel==4){  //cuando supere las 30 vuelas empieza a disparar 
                    cS.eliminarSprite(enemigo2);
                    cS.eliminarSprite(enemigo3);
                    vuelta3Cell++;
                    posXdisparoCell-=10;
                    spriteDisparo=0;
                    if(vuelta3Cell==80){ //CUANDO HACEMOS 50 VUELTAS "DISTANCIA QUE RECORRE " SALIMOS Y REINICIAMOS
                        vuelta3Cell=0;
                        vuelta2Cell=0;
                        
                    }
                    
                    enemigo2=cS.crearSprite(imaCell, disparoCell[spriteDisparo][0],posXdisparoCell,posYcell);
                    enemigo3=cS.crearSprite(imaCell, disparoCell[spriteDisparo][0],posXdisparoCell,posYcell-200);
                }else{
                    posXdisparoCell=posXcell;
                }
                
                
               
                
                
                
                
                if(posRanaX<inicioSuelo2){
                       sentidoRana=1;
                       sentidoSpriteRana=0;
                       sentidoSpriteRana2=1;
                }
                if(posRanaX>inicioSuelo2+500){
                       sentidoRana=-1;
                       sentidoSpriteRana=1;
                       sentidoSpriteRana2=0;
                }
                
                
                if(posAveX<700){
                    sentidoAve=1;
                    sentidoSpriteAve=0;     
                    sentidoSpriteAve2=1;
                }                             //LOS SPRITES DE LOS ENEMIGOS 
                if(posAveX>1000){
                    sentidoAve=-1;
                    sentidoSpriteAve=1;
                    sentidoSpriteAve2=0;
                }
                
                
               //------------------------------CORRER------------------------------------------------------------------------------------------
                
                if(t.teclaPulsada(KeyEvent.VK_D)
                        ||t.teclaPulsada(KeyEvent.VK_A)
                        &&!t.teclaPulsada(KeyEvent.VK_M)
                        &&!t.teclaPulsada(KeyEvent.VK_K)){
                    cS.eliminarSprite(goku);
                    if(t.teclaPulsada(KeyEvent.VK_D)){
                        sentido=0; 
                        
                    }
                    if(t.teclaPulsada(KeyEvent.VK_A)){
                        sentido=1;
                    }
                    if(posicionX>ancho/2&&nivel!=4){

                            posicionXfondo-=5*direccion;
                        }else{
                            posicionX+=5*direccion;
                        }
                    sprite=sprite%8;
                    goku=cS.crearSprite(imaGoku2, GokuCorrer[sentido][sprite], posicionX, posicionY);
                    sprite++;
                }
                //   --------------------------------  -------  VOLAR -----------------------------------------------------
                
                if(t.teclaPulsada(KeyEvent.VK_W)&&permitirVolar){
                    cS.eliminarSprite(goku);
                    posicionY-=20;
                    goku=cS.crearSprite(imaGoku2, gokuSaltar[gokuNivel][sentido], posicionX, posicionY);
                }
                
                //  ------------------SUPER VELOCIDAD---------------
                
                
                if(t.teclaPulsada(KeyEvent.VK_SPACE)){
                    cS.eliminarSprite(goku);
                    spritePegar=spritePegar%4;
                    spritePegar++;
                    if(posicionX>ancho/2&&nivel!=4){
                            posicionXfondo-=7*direccion;
                    }else{
                            posicionX+=7*direccion;
                    }
                    goku=cS.crearSprite(imaGoku, superVelocidad[spritePegar], posicionX, posicionY);

                }
                
                //  -----------         DISPARAR BOLA DE FUEGO-------------------------------------------------------
               
                if(t.teclaPulsada(KeyEvent.VK_M)||t.teclaPulsada(KeyEvent.VK_K)){
                    cS.eliminarSprite(kameha);
                    cS.eliminarSprite(goku);
                    if(sentido==1){
                        goku=cS.crearSprite(imaGoku2, gokuDispararI, posicionX, posicionY+10);
                        sentidoBola=-1;
                    }
                    if(sentido==0){
                        goku=cS.crearSprite(imaGoku, gokuDispararD, posicionX, posicionY+10);
                        sentidoBola=1;
                    }
                    if(posicionBola>posicionX+250||posicionBola<posicionX-250){
                         posicionBola=posicionX+(5*sentidoBola);
                         bolasChicas--;
                    }
                        spriteBola=spriteBola%10;
                        posicionBola+=(15*sentidoBola);
                       
                    if(t.teclaPulsada(KeyEvent.VK_K)&&!t.teclaPulsada(KeyEvent.VK_M)){
                         kameha=cS.crearSprite(imaGoku, bolaFuego[spriteBola], posicionBola+5, posicionY+15);
                    }
                    if(t.teclaPulsada(KeyEvent.VK_M)&&!t.teclaPulsada(KeyEvent.VK_K)){
                         kameha=cS.crearSprite(imaSuper, bolaSuper[spriteBola], posicionBola, posicionY-10);
                    }
                }else{
                    posicionBola=posicionX;
                }
                
                if(t.teclaPulsada(KeyEvent.VK_M)){//SUPER SAYAN

                    cS.eliminarSprite(goku);
                    spriteSuper++;
                    spriteSuper=spriteSuper%2;
                    goku=cS.crearSprite(imaSuper, gokuSuper[sentido][spriteSuper], posicionX, posicionY-12);
                }
//-------------------------------------------------  SIMULACION GRAVEDAD ---------------------------------------------
                if(
                    (goku.comprobarColision(bloque2)
                    ||goku.comprobarColision(bloque3)
                    ||goku.comprobarColision(bloque4)
                    ||goku.comprobarColision(arboles)
                    ||goku.comprobarColision(setos))&&(nivel==3||nivel==2) )
                {
                    
                    cS.eliminarSprite(goku);
                    vidaGoku--;
                    Sprite gokuMuerto=null;
                    for (int i=0;i<50;i++){
                        cS.eliminarSprite(gokuMuerto);
                        gokuMuerto=cS.crearSprite(imaGoku, gokuMuere[i/10],posicionX-i,posicionY+5);
                        try{
                            Thread.sleep(20);
                        }catch(Exception e){            //ESTA PARTE DE CODIGO LA TENGO QUE REPETIR IGUAL MAS ABAJO
                                                        //POR QUE REUTILIZO OBJETOS QUE ME AFECTARIAN EN OTROS NIVELES
                        }
                        cS.eliminarSprite(gokuMuerto);
                    }
                    texto.setColorTexto(Color.black);
                    texto.print(17,10,"OHH HAS MUERTO"+" TE QUEDAN "+vidaGoku+" vidas");
                    try{
                      Thread.sleep(2000);
                    }catch(Exception e){

                    }
                    posicionX=0;
                    
                }
                if(
                    goku.comprobarColision(plataforma11)
                    ||goku.comprobarColision(plataforma22)   
                    ||goku.comprobarColision(plataforma33)  
                    ||goku.comprobarColision(plataforma44)
                    ){
               
                }else{
                    cS.eliminarSprite(goku);
                    posicionY+=7;
                           
                    goku=cS.crearSprite(imaGoku2, gokuSaltar[gokuNivel][sentido], posicionX, posicionY);
                    
                }        
                if(enemigo1.comprobarColision(plataforma33)){
                    
                }else{
                    posRanaY+=15;
                }
                if(enemigo2.comprobarColision(plataforma11)){
                }else{
                    posRanaY2+=10;
                }
                if(enemigo3.comprobarColision(plataforma22)||enemigoCELL.comprobarColision(plataforma33)){
                    
                }else{
                    posRanaY3+=5;
                    
                }

                 //   las ranas reaparecen de nuevo al morir
                if(posRanaY>700){
                    posRanaY=-500;
                }
                if(posRanaY2>700){
                    posRanaY2=-100;
                }
                if(posRanaY3>700){
                    posRanaY3=-200;
                }
                
//----------------------------------------------------------------------------------------------------------------------

                 if(posicionX<5){  //hay que comprobar funcionalidad
                    posicionX=5;
                }

                if(goku.comprobarColision(bolaDragon)){//------------------BOLAS DE DRAGO

                    cS.eliminarSprite(bolaDragon);
                    Sprite b=cS.crearSprite(imaBolas, bolas[0],0,100);
                    victoria--; 
                    c1=5000;
                }
                if(goku.comprobarColision(bolaDragon2)){

                    cS.eliminarSprite(bolaDragon2);
                    Sprite b=cS.crearSprite(imaBolas, bolas[1],30,100);
                    victoria--; 
                    c2=5000;
                }
                if(goku.comprobarColision(bolaDragon3)){

                    cS.eliminarSprite(bolaDragon3);
                    Sprite b=cS.crearSprite(imaBolas, bolas[1],60,100);
                    victoria--;
                    c3=5000;
                }
                if(goku.comprobarColision(bolaDragon4)){

                    cS.eliminarSprite(bolaDragon4);
                    Sprite b=cS.crearSprite(imaBolas, bolas[1],90,100);
                    victoria--; 
                    c4=5000;
                }
                if(goku.comprobarColision(bolaDragon5)){

                    cS.eliminarSprite(bolaDragon5);
                    Sprite b=cS.crearSprite(imaBolas, bolas[1],120,100);
                    victoria--; 
                    c5=5000;
                }
                if(goku.comprobarColision(bolaDragon6)){

                    cS.eliminarSprite(bolaDragon6);
                    Sprite b=cS.crearSprite(imaBolas, bolas[1],150,100);
                    victoria--; 
                    c6=5000;
                }
                if(goku.comprobarColision(bolaDragon7)){

                    cS.eliminarSprite(bolaDragon7);
                    Sprite b=cS.crearSprite(imaBolas, bolas[1],180,100);
                    victoria--; 
                    c7=5000;
                }


                if(kameha.comprobarColision(enemigoCELL)){
                    vuelta++;
                    if(vuelta>5){
                    enemigoCELL.setVisible(false);
                    vidaCell--;                           //PARPADEO DE CELL AL DAÑARLO
                    vuelta=0;
                    }
                }else{
                    enemigoCELL.setVisible(true);
                }
                if(kameha.comprobarColision(enemigo1)){
                    vidaEnemigo1--;
                    activarExplosion=true;
                    posYexpo=posRanaY;
                    posXexplo=posRanaX;
                }
                if(kameha.comprobarColision(enemigo2)){
                    vidaEnemigo2--;
                    activarExplosion=true;
                    posYexpo=posRanaY2;
                    posXexplo=posRanaX2;
                }
                if(kameha.comprobarColision(enemigo3)){
                    vidaEnemigo3--;
                    activarExplosion=true;
                    posYexpo=posRanaY3;
                    posXexplo=posRanaX3;
                }
                
              
            
               if(vidaEnemigo1==0){
                    posRanaY=-2000;
                    vidaEnemigo1=50;
                    posAveY=-2000;
                    
                    
                   
                }
                if(vidaEnemigo2==0){
                    posRanaY2=-2000;
                    vidaEnemigo2=50;
                    posAveY2=-2000;
                    
                   
                }
                if(vidaEnemigo3==0){
                    posRanaY3=-2000;
                    vidaEnemigo3=50;
                    posAveY3=-2000;
                    
                }
                if(activarExplosion){
                    cS.eliminarSprite(explo);
                    desactivarExplo++;
                    spriteExplosion++;
                    spriteExplosion=spriteExplosion%30;
                    explo=cS.crearSprite(imaCell, explosion[spriteExplosion], posicionX+(100*direccion), posicionY-100);
                    
                    }  
                    if(desactivarExplo==1){
                        activarExplosion=false;
                        desactivarExplo=0;
                    }
              

                if(goku.comprobarColision(enemigo2)
                        ||goku.comprobarColision(enemigo1)
                        ||goku.comprobarColision(enemigo3)
                        ||goku.comprobarColision(enemigoCELL)&&nivel!=3){
                    cS.eliminarSprite(goku);
                    vidaGoku--;
                    Sprite gokuMuerto=null;
                    for (int i=0;i<50;i++){
                        cS.eliminarSprite(gokuMuerto);
                        gokuMuerto=cS.crearSprite(imaGoku, gokuMuere[i/10],posicionX-i,posicionY+5);
                        try{
                            Thread.sleep(20);
                        }catch(Exception e){
                        
                        }
                        
                    }
                    texto.setColorTexto(Color.black);
                    texto.print(1,10,"OHH HAS MUERTO"+" TE QUEDAN "+vidaGoku+" vidas");
                    try{
                      Thread.sleep(2000);
                    }catch(Exception e){

                    }
                    cS.eliminarSprite(gokuMuerto);
                    posicionX=50;
                    posicionY=posicionSuelo;
                }
                if(vidaGoku==0){
                    posicionX=0;
                    posicionY=0;
                    posicionXfondo=0;
                    repetir=false;
                    texto.print(1,20,"OHH HAS MUERTO");
                    try{
                        Thread.sleep(2000);
                    }catch(Exception e){

                    }
                }

                if(victoria==0){
                    texto.print(1,20,"OLEE HAS GANADO");
                   repetir=false;
                   nivel++;
                   victoria=7;
                   posicionY=0;
                   posicionXfondo=0;
                   posicionX=100;
                   posXnube=700;
                   vuelta1Cell=0;
                   vueltasExpl=0;
                   
                    try{
                        Thread.sleep(2000);
                    }catch(Exception e){

                    }

                }
                if(vidaCell==0){
                    
                    texto.print(1,20,"HAS SALVADO AL MUNDO");
                   repetir=false;
                   nivel++;
                   victoria=7;
                   posicionXfondo=0;
                   posicionX=100;
                   posXnube=700;
                   nivel=0;
                    try{
                        Thread.sleep(2000);
                    }catch(Exception e){

                    }

                }
                if(posicionY>1000){
                    posicionY=0;
                }
                if(t.teclaPulsada(KeyEvent.VK_ESCAPE)){
                    posicionXfondo=0;
                    posicionX=0;
                    
                    repetir=false;
                   // reproductor.siguienteCancion();
                }
                c.esperarSiguienteFrame();
                cS.eliminarSprite(enemigo2);
                cS.eliminarSprite(goku);
                cS.eliminarSprite(bloque3);
                cS.eliminarSprite(bloque1);
                cS.eliminarSprite(arboles);
                cS.eliminarSprite(bloque2);
                cS.eliminarSprite(bloque4);
      //          cS.eliminarSprite(bloque5);
                cS.eliminarSprite(enemigo2);
                cS.eliminarSprite(arboles1);
                cS.eliminarSprite(setos);
                cS.eliminarSprite(setos1);
                cS.eliminarSprite(caja);
                cS.eliminarSprite(bolaDragon);
                cS.eliminarSprite(bolaDragon2);
                cS.eliminarSprite(bolaDragon3);
                cS.eliminarSprite(bolaDragon4);
                cS.eliminarSprite(bolaDragon5);
                cS.eliminarSprite(bolaDragon6);
                cS.eliminarSprite(bolaDragon7);
                cS.eliminarSprite(kameha);
                cS.eliminarSprite(enemigo1);
                cS.eliminarSprite(enemigo3);
//                cS.eliminarSprite(explo);
                cS.eliminarSprite(nubeUNO);
                cS.eliminarSprite(nubeDOS);
                cS.eliminarSprite(nubeTRES);
                cS.eliminarSprite(explo);
                cS.eliminarSprite(enemigoCELL);
             
                texto.cls();
            }

        
         }
    }
    
    
}
