import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 //declare bacteria variables here   
Bacteria [] colony; 
 public void setup()   
 {     
   background(0); 
   size(600, 600);
   colony = new Bacteria[200]; 
   for (int i = 0; i < colony.length; i++) {
   	 colony[i] = new Bacteria(); 


   }
 }   
 public void draw()   
 { 
   background(0); 
  for(int i = 0; i < colony.length; i++) 
{
   colony[i].show();  
   colony[i].move();
}
 }  
 class Bacteria    
 {     
   int myX, myY, bacteriaColor; 
   Bacteria()
   { 
     myX = (int)(Math.random() * 500); 
     myY = (int)(Math.random() * 500); 
     int colorX = (int)(Math.random() * 256); 
     int colorY = (int)(Math.random() * 256); 
     int colorZ = (int)(Math.random() * 256); 
     bacteriaColor = color(colorX, colorY, colorZ); 
   }   

   public void move() { 
     myX = myX + (int)(Math.random() * 9) - 4; 
     myY = myY + (int)(Math.random() * 9) - 4; 



   }

   public void show() { 
     fill(0); 
     stroke(bacteriaColor, 250);
     rect(myX, myY, 20, 20, 5); 
     



   }
 }   
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
