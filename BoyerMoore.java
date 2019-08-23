import java.util.*;

class BoyerMoore{
	public static void main(String args[]){
			Scanner s=new Scanner(System.in);
			String pat,txt;
			char patChar[];
			char txtChar[];
			System.out.println("Enter the Text :");
			txt=s.nextLine();
			System.out.print("\n");
			txtChar=txt.toCharArray();
			System.out.println("Enter the Pattern :");
			pat=s.nextLine();
			System.out.print("\n");
			patChar=pat.toCharArray();
			BoyerMoore b=new BoyerMoore();
			b.boyermoore(patChar,txtChar);
	}
	
	int[] preprocessor(char patChar[]){
		int bad_char=256;
		int bad_array[]=new int[256];
		for(int i=0;i<256;i++){
			bad_array[i]=-1;
		}
		
		for(int i=0;i<patChar.length;i++){
			bad_array[patChar[i]]=i;
		}
		return bad_array;
		
	}
	void boyermoore(char pat[],char txt[]){
		
		BoyerMoore b=new BoyerMoore();
		
		int prepro[]=b.preprocessor(pat);
		
		int m=pat.length;
		int n=txt.length;
	
		for(int i=0;i<=(n-m);i++){
			int j;
			for(j=m-1;j>=0;j--){
				if(pat[j]!=txt[i+j]){
					break;
				}	
			}
			if(j<0){
				System.out.println("Pattern found at "+i);
				i++;
			}
			else{ 
				if((j-prepro[txt[i+j]])>1){
				i+=j-prepro[(int)txt[i+j]];

			}
			else{
				i++;
			}
			}
			i--;
		}
		
	}

}