package com.JavaAnnotations;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {
    @Override
    @MethodInfo(author = "Nishu", comments = "Main Method", date = "Aug 20 2021", revision = 1)
    public String toString() {
        return "Overridden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "Deprecated Method", date = "August 20 2021")
    public static void oldMethod() {
        System.out.println("Old method , don't use it!");
    }

    public static void main(String[] args) {
        try {
            for (Method method : AnnotationExample.class.getMethods()) {
                // checks if methodInfo annotation present for method or not
                if (method.isAnnotationPresent(MethodInfo.class)) {
                    try {
                        // iterates all annotations available in method
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method " + method + " :" + anno);
                        }
                        MethodInfo methodAnno = method.getDeclaredAnnotation(MethodInfo.class);
                        if (methodAnno.revision() == 1) {
                            System.out.println("Method with Revision no 1 = " + method);
                        }
                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}