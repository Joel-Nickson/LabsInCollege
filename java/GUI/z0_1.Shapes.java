public class Shapes{
	void area(int r){
		System.out.println("Area of the Circle with radius "+r+" : "+(3.1415*r*r));
	}
	void area(int b,int h){
		System.out.println("Area of the Rectangle with breadth "+b+" and height "+h+" : "+(b*h));
	}
	void area(int a,int b,int c){
		double s=((a*a)+(b*b)+(c*c)),ans=0.0;
		ans=Math.sqrt(s*(s-a)*(s-b)*(s-c));
		System.out.println("Area of the Triangle : "+ans);
	}
	public static void main(String args[]){
		Shape obj=new Shape();
		obj.area(3);
		obj.area(10,20);
		obj.area(2,2,2);
	}
}
