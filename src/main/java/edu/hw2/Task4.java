package edu.hw2;

public class Task4 {

    public static CallingInfo callingInfo() throws Exception {
        try {
            throw new Exception();
        } catch (Exception exception) {
            var stackTraceElements = exception.getStackTrace();

            if (stackTraceElements.length > 1) {
                return new CallingInfo(stackTraceElements[1].getClassName(), stackTraceElements[1].getMethodName());
            }
        }

        throw new Exception("Stack is empty(?)");
    }

    public record CallingInfo(String className, String methodName) {}
}
