import processing.serial.*;

Serial port;
int num;

//var quandrado
int x = 0;
int y = 0;

void setup(){

   size( 500 , 500 );
   background(255);
   
   port = new Serial( this , "COM21" , 9600 );

}void draw(){
  
  background(255);

  num = port.read();
  
  if( num == '1'){ x+=5; }
  if( num == '2'){ y+=5; }
  if( num == '0'){ x-=5; }
  if( num == '3'){ y-=5; }
  
  fill(0);
  rect( x , y ,100,100);
  
}
