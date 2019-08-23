import java.util.*;
class Naive{
	public static void main(String args[]){
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the text :");
			String text=s.nextLine();
			System.out.print("\n");
			System.out.println("Enter the pattern :");
			String pattern=s.nextLine();
			System.out.print("\n");
			Naive n=new Naive();
			n.matching(pattern,text);
	}
	
	void matching(String p,String t){
		char pat[]=p.toCharArray();
		char txt[]=t.toCharArray();
		int m=pat.length;
		int n=txt.length;
		
		for(int i=0;i<=(n-m);i++){

			int k=0;
			for(int j=0;j<m;j++){
				if(pat[j]==txt[i+j]){
					k++;
				}
			}

			if(k==m){
				System.out.println("Pattern found at "+i);
			}
		}
	}
	
}