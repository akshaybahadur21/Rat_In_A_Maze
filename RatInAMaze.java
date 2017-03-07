import java.io.*;
import java.lang.*;
class RatInAMaze
{
	public static void main(String args[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter MXM");
		int n=Integer.parseInt(br.readLine());
		int a[][]=new int[n][n];
		int sol[][]=new int[n][n];
		int i,j;
		for( i=0;i<n;i++)
		{
			for( j=0;j<n;j++)
			{
				a[i][j]=Integer.parseInt(br.readLine());
				sol[i][j]=0;
			}
		}
		i=j=0;
		SolveMaze(a,sol,i,j,n);
		
			
	}
	public static int isSafe(int a[][],int n, int i, int j)
	{
		if(i>=0&&i<n&&j>=0&&j<n&&a[i][j]==1)
			return 1;
		return -1;
	}
	public static int SolveMaze(int a[][],int sol[][],int i,int j,int n)
	{
		if(i==n-1&&j==n-1)
		{
			sol[i][j]=1;
			printMaze(sol,n);
		}
		if(isSafe(a,n,i,j)==1)
		{
			sol[i][j]=1;
		if(SolveMaze(a,sol, i+1,j,n)==1)
			return 1;
		if(SolveMaze(a,sol, i,j+1,n)==1)
			return 1;
		sol[i][j]=0;
		return -1;
		}
		return -1;
	}
	public static void printMaze(int sol[][],int n)
	{
		System.out.println();
		for( int i=0;i<n;i++)
		{
			for( int j=0;j<n;j++)
			{
				System.out.print(sol[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.exit(0);
	}
}