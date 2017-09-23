import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

public class MatrixMultiplication{
	public static void main(String[] args) throws Exception{
		// [type] [m] [p] [n] A.txt B.txt
		int
			m=Integer.valueOf(args[1]),
			p=Integer.valueOf(args[2]),
			n=Integer.valueOf(args[3]);

		ReadMatrix a=new ReadMatrix(args[4]);
		ReadMatrix b=new ReadMatrix(args[5]);
		
		if(args[0].equals("int")){
			int[][] A=a.readInt(m,p);
			int[][] B=b.readInt(p,n);
			printMat(A,m,p);
			System.out.println();
			printMat(B,p,n);
		}else if(args[0].equals("double")){
			double[][] A=a.readDouble(m,p);
			double[][] B=b.readDouble(p,n);
		}else if(args[0].equals("float")){
			float[][] A=a.readFloat(m,p);
			float[][] B=b.readFloat(p,n);
		}
	}

	public static void printMat(int[][] mat,int rows,int cols){
		for(int row=0;row<rows;row++){
			for(int col=0;col<cols;col++){
				System.out.print(mat[row][col]+" ");
			}System.out.println();
		}
	}
}

class ReadMatrix{
	BufferedReader br=null;
    FileReader fr=null;
    String currentRecord;

	public ReadMatrix(String filename){
		filename=ReadMatrix.class.getProtectionDomain().
        	getCodeSource().getLocation().getPath().replace("%20"," ")+"/"+filename;
        try{
            fr=new FileReader(filename);
            br=new BufferedReader(fr);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
	}
	public int[][] readInt(int rows,int cols) throws Exception{
		int[][] mat=new int[rows][cols];
		int row=0,col=0;
		while((currentRecord=br.readLine())!=null){
            for(String s:currentRecord.split(" ")){
            	mat[row][col]=Integer.valueOf(s);
            	col++;
            }
            col=0;
            row++;
        }
        return mat;
	}
	public double[][] readDouble(int rows,int cols) throws Exception{
		double[][] mat=new double[rows][cols];
		int row=0,col=0;
		while((currentRecord=br.readLine())!=null){
            for(String s:currentRecord.split(" ")){
            	mat[row][col]=Double.valueOf(s);
            	col++;
            }
            row++;
        }
        return mat;
	}
	public float[][] readFloat(int rows,int cols) throws Exception{
		float[][] mat=new float[rows][cols];
		int row=0,col=0;
		while((currentRecord=br.readLine())!=null){
            for(String s:currentRecord.split(" ")){
            	mat[row][col]=Float.valueOf(s);
            	col++;
            }
            row++;
        }
        return mat;
	}
}