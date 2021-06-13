import java.lang.reflect.Method;

class MethodFinder {

    public static String findMethod(String methodName, String[] classNames) throws ClassNotFoundException {
        for (String className: classNames) {
            for (Method method: Class.forName(className).getMethods()) {
                if (method.getName().equals(methodName)) {
                    return Class.forName(className).getName();
                }
            }
        }
        return "";
    }
}