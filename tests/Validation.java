import static org.junit.Assert.*;
import java.util.*;

class Validation
{
	public void validateResult(List<Integer> list, int pos, List<Integer> path)
	{
		validateResult(list, pos, path, list != null ? list.size() : -1);
	}

	public void validateResult(List<Integer> list, int pos, List<Integer> path, int threshold)
	{
		if (path == null)
		{
			if (threshold >= 0)
			{
				fail("null value returned when valid path exists");
			}
		}
		else if (threshold < 0)
		{
			fail("non-null value returned when no valid path exists");
		}
		else
		{
			validatePath(list, pos, path);
			
			if (path.size() > threshold)
			{
				fail("path of length " + path.size() + " provided, but shorter path of length " + threshold + " exists");
			}
		}
	}

	private static void validatePath(List<Integer> list, int pos, List<Integer> path)
	{
		// check inputs
		if (list == null || path == null || pos < 0 || pos > list.size())
		{
			throw new IllegalArgumentException("unexpected input: " + pos + " " + list + " " + path);
		}

		String invalid = "invalid jump at position " + pos + ": ";

		if (pos == list.size() && path.isEmpty())
		{
			// success!
			return;
		}
		else if (pos == list.size() && !path.isEmpty())
		{
			// jump when at end of list
			fail(invalid + path.get(0));
		}
		else if (path.isEmpty())
		{
			// no jump when not at end of list
			fail("path ends at position " + pos);
		}
		else
		{
			Integer jump = path.get(0);
			Integer value = list.get(pos);

			if (jump == null)
			{
				// null value in path
				fail(invalid + "null");
			}
			else if (value == null)
			{
				// jump when value is null
				fail(invalid + "value is null");
			}
			else if (jump == 0)
			{
				// jump of 0
				fail(invalid + "0");
			}
			else if (value > 0 && jump > value)
			{
				// jump greater than positive value
				fail(invalid + jump + " > " + value);
			}
			else if (value >= 0 && jump < 0)
			{
				// jump less than zero for positive value
				fail(invalid + jump + " < 0");
			}
			else if (value < 0 && jump < value)
			{
				// jump less than negative value
				fail(invalid + jump + " < " + value);
			}
			else if (value <= 0 && jump > 0)
			{
				// jump greater than zero for negative value
				fail(invalid + jump + " > 0");
			}
			else if (pos + jump > list.size() || pos + jump < 0)
			{
				// jump to invalid position
				fail(invalid + "jump of " + jump + " leads to invalid position " + (pos + jump));
			}
			else
			{
				// valid jump, continue
				validatePath(list, pos + jump, path.subList(1, path.size()));
			}
		}
	}
}
