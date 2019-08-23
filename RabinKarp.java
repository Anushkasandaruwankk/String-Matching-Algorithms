import java.util.*;
class RabinKarp{
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Text :");
		char txt[]=s.nextLine().toCharArray();
		System.out.print("\n");
		System.out.println("Enter the Pattern :");
		char pat[]=s.nextLine().toCharArray();
		System.out.print("\n");
		System.out.println("Enter the prime number :");
		int x=s.nextInt();
		System.out.print("\n");
		RabinKarp r=new RabinKarp();
		r.rabin(pat,txt,x);
	}
	
	void rabin(char pat[],char txt[],int q){
		int n=txt.length;
		int m=pat.length;
		int d=256;
		int h=1;
		for(int i=0;i<(m-1);i++){
			h=(h*d)%q;
		}
		int t=0;
		int p=0;
		for(int i=0;i<m;i++){
			t=(t*d+txt[i])%q;
			p=(p*d+pat[i])%q;
		}
		
		for(int i=0;i<=(n-m);i++){
			if(p==t){
				int j;
				for(j=0;j<m;j++){
					if(txt[i+j]!=pat[j])
						break;
				}
				if(j==m){
					System.out.println("Pattern found at "+i);
				}
			}
			if(i<(n-m)){
				t=(d*(t-txt[i]*h)+txt[i+m])%q;
				if(t<0)
					t+=q;
			}
		}
		
	}
}

