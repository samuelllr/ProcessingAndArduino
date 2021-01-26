import processing.serial.*;

Serial port;
int num;

//var's quandrado
int x = 0;
int y = 0;

void setup(){

   size( 500 , 500 ); //tamanho de janela
   background(255);   //Cor de fundo da janela
   
   port = new Serial( this , "COM21" , 9600 );
                           //^^^^^^^ MUDE AQUI SE SEU ARDUINO NÃO ESTA NESTA PORTA

}void draw(){
  
  background(255); //Limpa a tela

  num = port.read(); //Lê a porta Serial/USB
  
  if( num == '1'){ x+=5; } // desclementa ou inclementa 5 dependendo do valor retornado pelo Arduino.
  if( num == '2'){ y+=5; }
  if( num == '0'){ x-=5; }
  if( num == '3'){ y-=5; }
  
  // Desenha uma quadrado de preenchimento preto.
  fill(0);
  rect( x , y ,100,100);
  
}