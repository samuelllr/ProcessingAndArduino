void setup(){

  Serial.begin( 9600 );

  pinMode( 2 , INPUT_PULLUP );
  pinMode( 3 , INPUT_PULLUP );
  pinMode( 4 , INPUT_PULLUP );
  pinMode( 5 , INPUT_PULLUP );
  
}void loop(){

  if( digitalRead( 2 ) == 0) Serial.write( '2' ); // Envia dados conforme o botão pressionado.
  if( digitalRead( 3 ) == 0) Serial.write( '3' );
  if( digitalRead( 4 ) == 0) Serial.write( '1' );
  if( digitalRead( 5 ) == 0) Serial.write( '0' );
  delay(50); // Serve para não ficar muito rápido
}