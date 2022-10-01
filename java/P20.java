//Reference: https://www.youtube.com/watch?v=LuLCLgMElus&t=180s

import java.util.*;
class P20
{
	public static int findDecreasing(int arr[]) //used to find first index from right where decreasing
	{
		int n=arr.length,i=n-1,index1;
		while(i>=1)
		{
			if(arr[i-1]<arr[i])
			{
				index1=(i-1);
				return index1;
			}
			i--;
		}
		index1=-1;
		return index1;
	}
	
	public static int findJustGreater(int arr[],int index1) //used to find index having value just greater than value at index 1
	{
		int index2=index1+1,i,n=arr.length,sub,diff=Integer.MAX_VALUE;
		for(i=index1+1;i<n;i++)
		{
			sub=arr[i]-arr[index1];
			if(sub>0 && sub<=diff)
			{
				diff=sub;
				index2=i;
			}
		}
		return index2;
	}
	
	public static void swap(int arr[],int index1, int index2)
	{
		int temp;
		temp=arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=temp;
	}
	
	public static void reverse(int arr[],int index1)
	{
		int i,l=index1+1,u=arr.length-1;
		while(l<u)
		{
			swap(arr,l,u);
			l++;
			u--;
		}
	}
	
	public static int[] nextPermutation(int arr[])
	{
		int index1,index2;
		index1=findDecreasing(arr);
		if(index1==-1)		//final permutation, so just reverse arr
		{
			int l=0,u=arr.length-1,temp;
			while(l<u)
			{
				swap(arr,l,u);
				l++;
				u--;
			}
			return arr;
		}
		index2=findJustGreater(arr,index1);
		swap(arr,index1,index2);
		reverse(arr,index1);	//reverse arr from index index1+1 to end
		return arr;
	}
	
	public static void main(String args[])throws Exception
	{
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer> a=new ArrayList<>();
		System.out.println("Enter array elements:");
		int i,arr[],ans[];
		String s=sc.nextLine(); 		// single line int numbers separated by space
		String num[]=s.split("\\s+");   // all white space considered as delimiter
		for(i=0;i<num.length;i++)
		{
			a.add(Integer.parseInt(num[i]));
		}
		arr=new int[a.size()];
		ans=new int[a.size()];
		for(i=0;i<a.size();i++)
		{
			arr[i]=a.get(i);
		}
		System.out.println("Original Permutation:");
		for(i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		ans=nextPermutation(arr);
		System.out.println("Next Permutation:");
		for(i=0;i<ans.length;i++)
		{
			System.out.println(ans[i]);
		}
	}
}