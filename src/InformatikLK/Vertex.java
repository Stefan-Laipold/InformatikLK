/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package name.stefan.laipold.animationGame;
/**
 *
 * @author Stefan
 */

public class Vertex{
    
public double x;
public double y;

public Vertex(double xx,double yy){
x=xx;
y=yy;
}

public static void main(String[] args){
    
Vertex v1 = new Vertex(9,4);
Vertex v2 = new Vertex(36,0);
Vertex vv = new Vertex(0,0);

System.out.println("v1.x = "+v1.x);
System.out.println("v2.y = "+v2.y);
System.out.println("v1.y = "+v1.y);

v1.y= 2*v1.y;
System.out.println("v1.y = "+v1.y);
System.out.println(v1.length());
System.out.println(v1);
}

@Override
public String toString(){return "("+x+","+y+")";}
public double length(){ return Math.sqrt(x*x+y*y);}
public Vertex skalarMult(double s){return new Vertex(x*s,y*s);} 

public void skalarMultMod(double s){
x=s*x;
y=s*y;
}

public Vertex add(Vertex v2){return new Vertex(x+v2.x,y+v2.y);} 

public void addMod(Vertex v2){
 x=x+v2.x;
 y=y+v2.y;
}

public void setzeX(double xx){x=xx;}
public void setX(double x){this.x = x;}
public void setY(double y){this.y = y;}

public double getX(){return x;}
public double getY(){return y;}

@Override
public boolean equals(Object thatObject){
if (thatObject instanceof Vertex){


Vertex that = (Vertex)thatObject;
return this.x==that.x && this.y == that.y;
 
        }
    return false;
    }
}

