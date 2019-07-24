import java.util.*;

class PlayFair{
	public static void main(String a[]){
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter Plain Text in even numbers:");
		String plainText = s.nextLine();
		
		System.out.println("Enter Key:");
		String key = s.nextLine();
		
		char matrix[][] = new char[5][5];
		char ab;
		int count=0;
		int l = key.length();
		char keyChar[] = new char[l];
		for(int i=0;i<l;i++)
		{
			if(key.charAt(i)=='j'){
				keyChar[i]='i';
			}
			else{
				keyChar[i]=key.charAt(i);
			}
		}
		int p=0;
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(count<key.length())
				{
					matrix[i][j]=keyChar[count];
					count++;
				}
			}
		}
		System.out.println("\n");
		int i=0;
		int j=0;
		l=key.length();
		ab='a';
		i=l/5;
		int q=l%5;
		for(p=i;p<5;p++)
		{
			while(q<5)
			{
				if(ab=='j'){
					ab++;
				}
				if(key.indexOf(ab)==-1)
				{
					matrix[p][q]=ab;
					q++;
				}
				ab++;	
			}
			q=0;
		}
		for (int m =0 ; m < 5  ; m++ ) {
			for (int k = 0 ; k < 5  ; k++ ) {
				System.out.print(matrix[m][k]);
			}
			System.out.println(" ");
		}
		
		String cipherText = encrypt(matrix,plainText);
		System.out.println("Cipher Text is: "+cipherText);
		
		
		
	}
	public static String encrypt(char matrix[][], String plainText){
		
		String ct = "";
		int k,l,m,n;
		k=l=m=n=0;
		int length = plainText.length();
		for(int p=0; p<length; p = p+2){
			for(int i=0;i<5;i++){
				for(int j=0;j<5;j++){
					if(plainText.charAt(p) == matrix[i][j]){
						l=i;
						k=j;
					}
					if(plainText.charAt(p+1) == matrix[i][j]){
						m=i;
						n=j;
					}
				}
			}
			if(l==m){
				ct = matrix[l][(k+1)%5]+matrix[l][(n+1)%5];
			}
			else if(k==n){
				ct = matrix[(l+1)%5][k]+matrix[(m+1)%5][k];
			}
			else{
				ct = matrix[l][n]+matrix[m][k];
			}
		}
		return ct;
	}
	/*public static String decrypt(char matrix[][], String cipherText){
	
			

	}*/
}