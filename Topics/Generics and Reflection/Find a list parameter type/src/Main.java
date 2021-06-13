// Do not remove imports
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

class ListParameterInspector {
    // Do not change the method
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fieldName = scanner.next();

        ListParameterInspector inspector = new ListParameterInspector();
        inspector.printParameterType(new TestClass(), fieldName);
    }

    public void printParameterType(TestClass obj, String fieldName) throws Exception {
        Field field = obj.getClass().getField(fieldName);
        ParameterizedType type = (ParameterizedType) field.getGenericType();
        Type[] reflect = type.getActualTypeArguments();
        System.out.println(reflect[0].toString().split("\\s+")[1]);
    }
}