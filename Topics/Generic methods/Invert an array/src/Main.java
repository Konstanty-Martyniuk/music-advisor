// do not remove imports
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.Arrays;
import java.util.Collections;

class ArrayUtils {
    public static <T> T[] invert(T[] array) {
        Collections.reverse(Arrays.asList(array));
        return array;
    }
}