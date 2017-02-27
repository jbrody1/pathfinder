import org.junit.*;
import java.util.*;

public class TestOptimality
{
	Pathfinder pathfinder = new Pathfinder();
	Validation validation = new Validation();

	@Test
	public void shortestPath1()
	{
		List<Integer> list = Arrays.asList(4, 1, 1, 4, 1, 1, 3, 1, 1, 2, 1);
		int pos = 0;
		List<Integer> result = pathfinder.findPath(list, pos);
		validation.validateResult(list, pos, result, 4);
	}

	@Test
	public void shortestPath2()
	{
		List<Integer> list = Arrays.asList(1, 7, 2, 2, -4, 1, 1, 4, -2, 1, 1);
		int pos = 2;
		List<Integer> result = pathfinder.findPath(list, pos);
		validation.validateResult(list, pos, result, 4);
	}

	@Test
	public void shortestPath3()
	{
		List<Integer> list = Arrays.asList(2, 0, 2, 2, 0, 2, 2, 0, 1);
		int pos = 0;
		List<Integer> result = pathfinder.findPath(list, pos);
		validation.validateResult(list, pos, result, 6);
	}
}
