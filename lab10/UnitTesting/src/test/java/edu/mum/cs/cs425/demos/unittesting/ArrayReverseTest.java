package edu.mum.cs.cs425.demos.unittesting;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;


import edu.mum.cs.cs425.demos.unittesting.Service.ArrayFlattenerService;


public class ArrayReverseTest {

	@InjectMocks
	private ArrayReverse arrayReverse;
	
	@Mock
	private ArrayFlattenerService arrayFlattenerService;
	
	@Before
	public void setUp() throws Exception {
		this.arrayReverse = new ArrayReverse();
		arrayFlattenerService=mock(ArrayFlattenerService.class);
	}

	@After
	public void tearDown() throws Exception {
		this.arrayReverse = null;
	}

	@Test
	public final void testReverseArray1() {
		int[][] input= {{1,3},{0},{4,5,9}};
		int[] flatten= {1,3,0,4,5,9};
		when(arrayFlattenerService.flattenArray(input)).thenReturn(flatten);
		int[] actual = arrayReverse.reverseArray(input);
		int[] expected = {9,5,4,0,3,1};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public final void testReverseArray2() {
		int[][] input= null;
		int[] flatten= null;
		when(arrayFlattenerService.flattenArray(input)).thenReturn(flatten);
		int[] actual = arrayReverse.reverseArray(input);
		int[] expected = null;
		assertEquals(expected, actual);
	}
}
