import processing.serial.*;

Serial port;
int mousex,mousey;
int OnOffLed = 0;

void setup(){

   // define o tamanho de tela e a cor de fundo dela.
   size( 500 , 500 );
   background(255);
   
   // diz qual porta o Arduino esta sendo usado
   port = new Serial( this , "COM21" , 9600 ); 
                            //^^^^^ mude aqui se seu arduino esta em outra porta USB.

}void draw(){

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
void mouseClicked(){
    
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