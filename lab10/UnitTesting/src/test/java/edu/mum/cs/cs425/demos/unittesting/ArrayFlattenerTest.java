package edu.mum.cs.cs425.demos.unittesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ArrayFlattenerTest {

	private ArrayFlattener arrayflat=null;	
	
	@Before
	public void setUp() throws Exception {
		this.arrayflat = new ArrayFlattener();
	}

	@After
	public void tearDown() throws Exception {
		this.arrayflat = null;
	}

	
	@Test
	public void test1() {
		int[][] input= {{1,3},{0},{4,5,9}};
		int[] expected = {1,3,0,4,5,9} ;
		int[] actual = arrayflat.flattenArray(input);
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void test2() {
		int[][] input= null;
		int[] expected = null ;
		int[] actual = arrayflat.flattenArray(input);
		assertEquals(expected, actual);
	}

}
