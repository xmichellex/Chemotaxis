 //declare bacteria variables here   
Bacteria [] colony; 
 void setup()   
 {     
   background(0); 
   size(600, 600);
   colony = new Bacteria[200]; 
   for (int i = 0; i < colony.length; i++) {
   	 colony[i] = new Bacteria(); 


   }
 }   
 void draw()   
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

   void move() { 
     myX = myX + (int)(Math.random() * 9) - 4; 
     myY = myY + (int)(Math.random() * 9) - 4; 



   }

   void show() { 
     fill(0); 
     stroke(bacteriaColor, 250);
     rect(myX, myY, 20, 20, 5); 
     



   }
 }   