import java.util.*;

import org.junit.Test;

public class TestRobustness
{
	Pathfinder pathfinder = new Pathfinder();
	Validation validation = new Validation();

	@Test
	public void nullList()
	{
		List<Integer> list = null;
		int pos = 0;
		List<Integer> result = pathfinder.findPath(list, pos);
		validation.validateResult(list, pos, result);
	}

	@Test
	public void emptyList()
	{
		List<Integer> list = Arrays.asList();
		int pos = 0;
		List<Integer> result = pathfinder.findPath(list, pos);
		validation.validateResult(list, pos, result);
	}

	@Test
	public void invalidStartingPosition()
	{
		List<Integer> list = Arrays.asList(1, 2, 0);
		int pos = 7;
		List<Integer> result = pathfinder.findPath(list, pos);
		validation.validateResult(list, pos, result, -1);
	}

	@Test
	public void negativeStartingPosition()
	{
		List<Integer> list = Arrays.asList(1, 2, 0);
		int pos = -1;
		List<Integer> result = pathfinder.findPath(list, pos);
		validation.validateResult(list, pos, result, -1);
	}

	@Test
	public void startInTheMiddle()
	{
		List<Integer> list = Arrays.asList(0, 1, 2, 0, 1);
		int pos = 2;
		List<Integer> result = pathfinder.findPath(list, pos);
		validation.validateResult(list, pos, result);
	}

	@Test
	public void nullValuesInList()
	{
		List<Integer> list = Arrays.asList(1, 3, null, 2, null);
		int pos = 1;
		List<Integer> result = pathfinder.findPath(list, pos);
		validation.validateResult(list, pos, result);
	}

	@Test
	public void negativeJump()
	{
		List<Integer> list = Arrays.asList(0, 2, -2, 2, 1);
		int pos = 2;
		List<Integer> result = pathfinder.findPath(list, pos);
		validation.validateResult(list, pos, result);
	}

	@Test
	public void avoidCycles()
	{
		List<Integer> list = Arrays.asList(4, -1, 4, 1, -1, 2, -2);
		int pos = 1;
		List<Integer> result = pathfinder.findPath(list, pos);
		validation.validateResult(list, pos, result);
	}
}
