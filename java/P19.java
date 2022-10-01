//Rference: https://leetcode.com/problems/merge-intervals/discuss/1644169/Java-oror-simple-Steps-explained-oror-simple-sort

import java.util.*;
class P19
{
	public static int[][] merge(int a[][])
	{
		int i,start,end,s,e;
		Arrays.sort(a,(o1,o2)->o1[0]-o2[0]); //sort ascendingly according to interval start time
		ArrayList<int[]> ans=new ArrayList<>();
		//taking 1st interval as initial range 
		start=a[0][0];	
		end=a[0][1];
		for(i=1;i<a.length;i++)
		{
			s=a[i][0];
			e=a[i][1];
			// s will be greater than start because it is sorted
			if(s<=end)	// so timeline (start s end e) or (start s e end), hence, merge both intervals
			{
				end=Math.max(e,end);
			}
			else	//merge is not possible, so insert previous interval into array list
			{
				ans.add(new int[]{start,end});
				start=s;
				end=e;
			}
		}
		ans.add(new int[]{start,end});
		System.out.println("After merging we get "+ans.size()+" interval(s)");
		return ans.toArray(new int[0][]);
	}
	
	public static void main(String args[])throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of intervals:");
		int n=sc.nextInt();
		int a[][]=new int[n][2],ans[][];
		System.out.println("Enter interval elements:");
		int i,j;
		for(i=0;i<n;i++)
		{
			for(j=0;j<2;j++)
			{
				a[i][j]=sc.nextInt();
			}
		}
		System.out.println("Original Array:");
		for(i=0;i<n;i++)
		{
			for(j=0;j<2;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		ans=merge(a);
		for(i=0;i<ans.length;i++)
		{
			for(j=0;j<ans[0].length;j++)
			{
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
}