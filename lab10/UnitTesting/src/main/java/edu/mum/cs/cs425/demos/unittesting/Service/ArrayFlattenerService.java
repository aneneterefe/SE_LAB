package edu.mum.cs.cs425.demos.unittesting.Service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class ArrayFlattenerService {

	public int[] flattenArray(int[][] arr) {
		
		if(arr==null)
			return null;
		int[] result=Arrays.stream(arr).flatMapToInt(Arrays::stream).toArray();
		return result;
		
	}
}
