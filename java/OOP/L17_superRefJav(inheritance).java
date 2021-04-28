// Dynamic Method Dispatch

class fig{
	protected double val1 ,val2;
	fig(double a ,double b){
		val1=a;
		val2=b;
	}
	double area(){
		return 0.0;
	}
}


class rect extends fig{
	rect(double a ,double b){
		super(a,b);
	}
	double area(){
		return val1*val2;
	}
}

class tri extends fig{
	tri(double a ,double b){
		super(a,b);
	}
	double area(){
		return val1*val2/2;
	}
}


class superRefJav {
  public static void main(String args[]) {
    fig f = new fig(10, 10);
    rect r = new rect(9, 5);
    tri t = new tri(10, 8);
    fig ref ;
    ref = r ;
    System.out.println("Area of rectangle is " + ref.area()) ;
    ref = t ;
    System.out.println("Area of triangle is " + ref.area()) ;
    ref = f ;
    System.out.println("Area of super class is " + ref.area()) ;
  }
}