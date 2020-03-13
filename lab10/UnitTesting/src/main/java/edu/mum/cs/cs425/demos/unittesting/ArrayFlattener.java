package edu.mum.cs.cs425.demos.unittesting;

import java.util.Arrays;

public class ArrayFlattener {

	public int[] flattenArray(int[][] arr) {
		
		if(arr==null)
			return null;
		int[] result=Arrays.stream(arr).flatMapToInt(Arrays::stream).toArray();
		return result;
		
	}
}
