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

public class ControlRect extends PApplet {



Serial port;
int num;

//var quandrado
int x = 0;
int y = 0;

public void setup(){

   
   background(255);
   
   port = new Serial( this , "COM21" , 9600 );

}public void draw(){
  
  background(255);

  num = port.read();
  
  if( num == '1'){ x+=5; }
  if( num == '2'){ y+=5; }
  if( num == '0'){ x-=5; }
  if( num == '3'){ y-=5; }
  
  fill(0);
  rect( x , y ,100,100);
  
}
  public void settings() {  size( 500 , 500 ); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "ControlRect" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
