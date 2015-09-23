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

 //declare Cube variables here   
Cube [] friends; 
 public void setup()   
 {     
   background(255, 255, 153); 
   size(600, 600);
   friends = new Cube[30]; 
   for (int i = 0; i < friends.length; i++) {
   	 friends[i] = new Cube(); 


   }
 }   
 public void draw()   
 { 
   background(255, 255, 153); 
  for(int i = 0; i < friends.length; i++) 
{
   friends[i].show();  
   friends[i].move();
}
 }  
 class Cube    
 {     
   int myX, myY, cubeColor; 
   Cube()
   { 
     myX = (int)(Math.random() * 500); 
     myY = (int)(Math.random() * 500); 
     int colorX = (int)(Math.random() * 256); 
     int colorY = (int)(Math.random() * 256); 
     int colorZ = (int)(Math.random() * 256); 
     cubeColor = color(colorX, colorY, colorZ); 
   }   

   public void move() { 
   	frameRate(120);  
   	if((mouseX - 50) < myX && (mouseY + 40) < myY) {
   		//move left and up
   		myX = myX - (int)(Math.random() * 5); 
   		myY = myY - (int)(Math.random() * 5); 
   	} else if((mouseX - 50) > myX && (mouseY + 40) < myY) {
   		//move right and up 
   		myX = myX + (int)(Math.random() * 5); 
   		myY = myY - (int)(Math.random() * 5); 
   	} else if((mouseX - 50) < myX && (mouseY + 40) > myY) {
   		//move left and down 
   		myX = myX - (int)(Math.random() * 5); 
   		myY = myY + (int)(Math.random() * 5); 
   	} else if((mouseX - 50) > myX && (mouseY + 40) > myY) {
   		//move right and down 
   		myX = myX + (int)(Math.random() * 5); 
   		myY = myY + (int)(Math.random() * 5); 
   	} else {
   		myX = myX + (int)(Math.random() * 5) - 2; 
   		myY = myY + (int)(Math.random() * 5) - 2;
   	}

  
   


   }

   public void show() {
     strokeWeight(2);  
   	 stroke(0); 
     fill(cubeColor);
     rect(myX, myY, 30, 30, 10);
     //eyes 
     fill(0);
     ellipse(myX + 10, myY + 10, 1, 1); 
     ellipse(myX + 20, myY + 10, 1, 1);
     //smile
     noFill();
     arc(myX + 15, myY + 13, 15, 15, PI/8, 7*PI/8);
     // top 
     rect(myX + 10, myY - 6, 10, 6, 3);
     girl(); 
   }
   public void girl() {
   	 fill(229, 204, 255);
   	 noStroke(); 
   	 ellipse(mouseX, mouseY - 15, 30, 30); 
   	 triangle(mouseX - 35, mouseY + 70, mouseX, mouseY, mouseX + 35, mouseY + 70);
   	 stroke(229, 204, 255);
   	 strokeWeight(4);  
   	 //eft arm 
   	 line(mouseX - 15, mouseY + 30, mouseX - 40, mouseY + 40);
   	 // right arm 
   	 line(mouseX + 10, mouseY + 30, mouseX + 35, mouseY + 40);  
   	 // left leg
   	 line(mouseX - 10, mouseY + 70, mouseX - 10, mouseY + 90);
   	 //right leg 
   	 line(mouseX + 10, mouseY + 70, mouseX + 10, mouseY + 90);
   	 

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
