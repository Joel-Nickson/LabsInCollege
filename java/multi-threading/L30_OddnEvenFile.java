import java.io.*;

public class Main
{
    public static void main(String[] args) {
        try{
            FileInputStream fin=new FileInputStream("file.txt");
            FileOutputStream fout =new FileOutputStream("f2.txt");
            int odd[],even[],ee,oo;
            odd=new int[10];
            even=new int[10];
            ee=oo=0;
            byte b[];
            
            for(int i=fin.read();(i!=-1);i=fin.read()) {
                if(Character.isDigit(i)){
                    if(i%2==0){
                        even[ee]=i;
                        ee++;
                    }
                    else if(i%2==1){
                        odd[oo]=i;
                        oo++;
                    }
                }
            }
            
            b="even :".getBytes();
            fout.write(b);
            fout.write(even[0]);
            for(int j=1;j<ee;j++){
                fout.write(',');
                fout.write(even[j]);
            }
            
            b="\nodd :".getBytes();
            fout.write(b);
            fout.write(odd[0]);
            for(int j=1;j<oo;j++){
                fout.write(',');
                fout.write(odd[j]);
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
        catch(Exception e){
            System.out.println("Error :"+e);
        }
    }
}