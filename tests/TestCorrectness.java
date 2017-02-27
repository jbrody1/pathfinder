import org.junit.*;
import java.util.*;

public class TestCorrectness
{
	Pathfinder pathfinder = new Pathfinder();
	Validation validation = new Validation();

	@Test
	public void example1()
	{
		List<Integer> list = Arrays.asList(1, 2, 0);
		int pos = 0;
		List<Integer> result = pathfinder.findPath(list, pos);
		validation.validateResult(list, pos, result);
	}

	@Test
	public void example2()
	{
		List<Integer> list = Arrays.asList(2, 3, 0, 2, 2);
		int pos = 0;
		List<Integer> result = pathfinder.findPath(list, pos);
		validation.validateResult(list, pos, result);
	}

	@Test
	public void example3()
	{
		List<Integer> list = Arrays.asList(2, 1, 0);
		int pos = 0;
		List<Integer> result = pathfinder.findPath(list, pos);
		validation.validateResult(list, pos, result, -1);
	}
}
