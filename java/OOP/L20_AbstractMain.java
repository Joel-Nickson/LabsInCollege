abstract class Shape{
	public abstract void noOfSides();
	//double area();//no need to override
}


class Rectangle extends Shape{
    public void noOfSides(){
        System.out.println("No of Sides of Rectangle: 4");
    }
}

class Triangle extends Shape{
    public void noOfSides(){
        System.out.println("No of Sides of Triangle: 3");
    }
}

class Hexagon extends Shape{
    public void noOfSides(){
        System.out.println("No of Sides of Hexagon: 6");
    }
}

public class AbstractMain {
  public static void main(String args[]) {
    Triangle t= new Triangle();
    Rectangle r=new Rectangle();
    Hexagon h=new Hexagon();
    
    Shape s=t;
    s.noOfSides();
    s=r;
    s.noOfSides();
    s=h;
    s.noOfSides();
    
  }
}