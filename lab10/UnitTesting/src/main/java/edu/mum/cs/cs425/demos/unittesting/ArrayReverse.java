package edu.mum.cs.cs425.demos.unittesting;


import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cs.cs425.demos.unittesting.Service.ArrayFlattenerService;

public class ArrayReverse {
	
	ArrayFlattenerService arrayFlattenerService;
	
	@Autowired
	public ArrayReverse() {
		// TODO Auto-generated constructor stub
		arrayFlattenerService=new ArrayFlattenerService();
	}
	
	public int[] reverseArray(int[][] arr) {
		if(arr==null)
			return null;
		int[] flatten=arrayFlattenerService.flattenArray(arr);
		for(int i=0; i<flatten.length/2; i++){ 
			int temp = flatten[i]; 
			flatten[i] = flatten[flatten.length -i -1]; 
			flatten[flatten.length -i -1] = temp; 
		}
		return flatten;
	}
}
