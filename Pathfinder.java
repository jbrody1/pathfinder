import java.util.*;

public class Pathfinder
{
    public static void main(String[] args)
    {
        // set up some test inputs
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int pos = 0;
        List<Integer> expectedOutput = Arrays.asList(1, 2, 2);

        // call findPath
        List<Integer> actualOutput = findPath(list, pos);

        // did the expected output match the actual?
        System.out.println("match? " + expectedOutput.equals(actualOutput));
    }

    private static List<Integer> findPath(List<Integer> list, int pos)
    {
        // TODO implement
        return null;
    }
}

