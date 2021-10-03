

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class BubbleSort {
	static Map<String,int[]> interMediateResults=new TreeMap<String,int[]>();
	
    static Map<String,int[]> bubbleSortMethod(int[] arr) {
    	System.out.println("Array Length : "+arr.length);
    	for(int i=0;i<arr.length;i++)
    	{    
    		if(i>=10&&i%10==0)
    		{   int[] result=new int[arr.length];
    		for(int k=0;k<arr.length;k++) {
    			result[k]=arr[k];
    		}
    			interMediateResults.put(Integer.toString(i),result);
    		
    			
    		}
    		
    		for(int j=1;j<arr.length-i;j++) {
    			if(arr[j-1]>arr[j]) {
    				arr[j-1]=arr[j-1]+arr[j];
    				arr[j]=arr[j-1]-arr[j];
    				arr[j-1]=arr[j-1]-arr[j];
    			}
    		}
    	}
    	
    	return interMediateResults;
    }
	
	
	
	public static void main(String[] args) {
		
		
		Map<String,int[]> interMediateResults=new HashMap<String,int[]>();
		int arr[]= {3,60,35,2,45,320,5,5,23,47,98,78,42,345,678,908,123,786,34,87,7665,986,2,1,3,4,5,6,2,8,9,0,1,2,5,3,12,32,21,34,45,11,66,99,00,16,77,33,44,55,99,00};
		
		System.out.println("Array before bubble Sorting");
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
			
		}
		System.out.println();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - --  -- - - - - - - - - - - - - - - - - - - -- - - ");
		
		// bubble sorting method
		interMediateResults=bubbleSortMethod(arr);
		System.out.println("Array after bubble Sorting");
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
			
		}
		System.out.println();
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - --  -- - - - - - - - - - - - - - - - - - - -- - - ");
		
		System.out.println("Intermediate Results");
		
		for(Map.Entry<String,int[]> entry:interMediateResults.entrySet()) {
			
			System.out.println("results for i : "+entry.getKey());
			for(int x:entry.getValue())
				System.out.print(x+" ");
				
				System.out.println();
		}
		
	}
	
	
	
}
