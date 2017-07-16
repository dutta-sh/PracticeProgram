package cs570;

public class PracProg4 {
	private static int[]x = new int[]{50, 100, 30, 80, 70, 40, 60, 20,90, 10};
	public static boolean swapped = true;
	public static void main(String[] args){
		sortArray();
		print();
	}

	
	private static void sortArray(){
		int pass = 0;
		while(swapped){
			swapped =false;
			if(pass%2==0)
				fwdPass();
			if(pass%2==1)
				bkwdPass();
			pass++;
		}
	}
	
	public static void fwdPass(){
		// forward pass
		for(int i=1;i<x.length;i++){
			int temp;
			if(x[i-1]>x[i]){
				temp=x[i-1];
				x[i-1]=x[i];
				x[i]=temp;
				swapped=true;
			}
		}
	}
	
	public static void bkwdPass(){	
	// backward pass
		for(int i=x.length-1; i>0; i--){
			int temp;
			if(x[i-1]>x[i]){
				temp=x[i-1];
				x[i-1]=x[i];
				x[i]=temp;
				swapped=true;
			}
		}
	}
	
	public static void print(){
		for(int elem:x){
			System.out.println(elem);
		}
	}
}
