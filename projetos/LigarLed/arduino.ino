int dados;
void setup(){

  Serial.begin( 9600 );
  pinMode( 13 , OUTPUT );
  
}void loop(){

  dados = Serial.read(); // ler porta USB/Serial

  if( dados == '1' ) digitalWrite( 13 , 1 ); 
  else if ( dados == '0' ) digitalWrite( 13 , 0 ); 
  
}