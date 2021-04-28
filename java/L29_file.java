import java.io.*;

public class File
{
	public static void main(String[] args)  throws FileNotFoundException,IOException{
		FileInputStream fin=new FileInputStream("file.txt");
		FileOutputStream fout =new FileOutputStream("f2.txt");
		
		int i=fin.read();
		while(i!=-1){
			fout.write((char)i);
			i=fin.read();
		}
		System.out.println("\n file is read from \'file.txt\' and written to \'f2.txt\' ! ");
		fin.close();
		fout.close();
	}
}


/*
import java.io.*;

public class File
{
	public static void main(String[] args) {
	    try{
	        FileInputStream fin=new FileInputStream("file.txt");
	        FileOutputStream fout =new FileOutputStream("f2.txt");
	    
    	    int i=fin.read();
    	    while(i!=-1){
    	        fout.write((char)i);
    	        i=fin.read();
    	    }
    		System.out.println("\n file is read from \'file.txt\' and written to \'f2.txt\' ! ");
    		fin.close();
    		fout.close();
	    }
	    catch(FileNotFoundException e){
	        System.out.println("File was not created");
	    }
	    catch(IOException e){
	        System.out.println("Sorry, wrong method :(");
	    }
	}
}
*/