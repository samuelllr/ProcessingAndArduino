import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.serial.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class LigaLed extends PApplet {



Serial port;
int mousex,mousey;
int OnOffLed = 0;

public void setup(){

   // define o tamanho de tela e a cor de fundo dela.
   
   background(255);
   
   // diz qual porta o Arduino esta sendo usado
   port = new Serial( this , "COM21" , 9600 ); 
                            //^^^^^ mude aqui se seu arduino esta em outra porta USB.

}public void draw(){

  // desenha na tela um quadrado branco e um texto.
  fill(0);
  text( "clique no quadrado" , 200 , 200 );
  fill(255);
  rect( 225 , 225 , 50 , 50 );
  
  //observa as coordenadas do mouse
  mousex = mouseX;
  mousey = mouseY;
  
  //Apenas imprime um quadrado vermelho ao colocar o mause em cima.
  if( mousex >= 225 && mousex <= 275 && mousey >= 225 && mousey <= 275 ){
  
    fill( 255,0,0 );
    rect( 225 , 225 , 50 , 50 );
 
  }
  
}

// indentifica a posição do mouse e se ele clicou.
public void mouseClicked(){
    
   if( mousex >= 225 && mousex <= 275 && mousey >= 225 && mousey <= 275 ){
      
      // SE sim ... envia 1 para ligar o led ou 0 para desligar
      if ( OnOffLed == 0 ) { 
          port.write( "1" ); // envia 1
          OnOffLed = 1; // esta variavel controla para ser enviado 1 ou 0.
        }else{ 
          port.write( "0" ); //envia 0
          OnOffLed = 0; 
        }
   }
    
}
  public void settings() {  size( 500 , 500 ); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "LigaLed" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
