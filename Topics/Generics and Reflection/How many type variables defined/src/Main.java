// Do not remove imports
import java.util.Scanner;

class TypeVariablesInspector {
    public void printTypeVariablesCount(TestClass obj, String methodName) throws Exception {
        System.out.println(obj.getClass().getMethod(methodName).getTypeParameters().length);
    }
}