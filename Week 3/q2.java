public class q2
{
	public static void main(String[] args)
	{
		int a = Integer.parseInt(args[0]); 
		int b = Integer.parseInt(args[1]); 
		int c; 
		if (a>0) { 
			if (a<b) 
				c=b-a; 
			else 
				c=a-b; 
			} 
		else 
			c=0; 
		c=c*c; 
		System.out.print(c);
	}
}	