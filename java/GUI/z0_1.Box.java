public class Box{
	int l,b,h;
	//default constrctor
	Box(){
		l=b=h=10;
	}
	//parametrised constructor
	Box(int length ,int breadth ,int height){
		l=length;
		b=breadth;
		h=height;
	}
	void printVol(){
		int vol=l*b*h;
		System.out.println(vol);
		
	}
	public static void main(String args[]){
		System.out.println("Default Constructor vol : ");
		Box obj=new Box();
		obj.printVol();
		System.out.println("Parametrised Constructor vol : ");
		Box obj1=new Box(5,5,2);
		obj1.printVol();
		
	}
}