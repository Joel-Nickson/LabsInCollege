package AdMath;

public class PackageFact{
	public int fval=1;
	public int fact(int n){
		for(int i=1;i<=n ;i++)
			fval*=i;
		return fval;
	}
}