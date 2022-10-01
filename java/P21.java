//Reference: https://www.youtube.com/watch?v=k9RQh21KrH8&t=135s (for approach 2)

import java.util.*;
class P21
{
	/*
	
	Approach 1:
	
	public static int countInversions(int a[])	//T.C.=O(n2)
	{
		int i,j,count=0,n=a.length;
		for(i=0;i<n-1;i++)
		{
			for(j=i+1;j<n;j++)
			{
				if(a[j]<a[i])
				{
					count++;
				}
			}
		}
		return count;
	}
	
	*/
	
	// Approach 2: Enhanced Merge Sort
	
	public static int countInversionsAndMergeSort(int a[],int l,int u)	//T.C.=O(nlogn)
	{
		int count=0;
		if(l<u)
		{
			int mid=(l+u)/2;
			count+=countInversionsAndMergeSort(a,l,mid);
			count+=countInversionsAndMergeSort(a,mid+1,u);
			count+=countInversionsAndMerge(a,l,mid,u);
		}
		return count;
	}
	
	public static int countInversionsAndMerge(int a[],int l,int mid,int u)
	{
		int left[]=Arrays.copyOfRange(a,l,mid+1);	//last index is excluded
		int right[]=Arrays.copyOfRange(a,mid+1,u+1);	//last index is excluded
		int i=0,j=0,k=l,count=0;
		while(i<left.length && j<right.length)
		{
			if(left[i]<=right[j])
			{
				a[k++]=left[i++];
			}
			else 		// left[i]>right[j]
			{
				a[k++]=right[j++];
				count+=mid-l+1-i; // mid-l+1 is the size of left subarray
								  // all elements on right of i will be greater than element at index i
			}
		}
		
		while(i<left.length)
		{
			a[k++]=left[i++];
		}
		
		while(j<right.length)
		{
			a[k++]=right[j++];
		}
		
		return count;
	}
	
	public static void main(String args[])throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter array size:");
		int n=sc.nextInt();
		int a[]=new int[n];
		System.out.println("Enter array elements:");
		int i;
		for(i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
		}
		System.out.println("Original Array:");
		for(i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}
		System.out.println("Inversions: "+countInversionsAndMergeSort(a,0,n-1));
		//final array will be merge sorted
	}
}