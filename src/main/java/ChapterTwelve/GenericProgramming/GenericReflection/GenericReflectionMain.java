package ChapterTwelve.GenericProgramming.GenericReflection;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Scanner;

public class GenericReflectionMain {
    public static void main(String[] args) {
        String name;
        if (args.length > 0)
            name = args[0];
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter class name (e.g. java.util.Collections): ");
            name = in.next();
        }
        try {
            Class<?> cl = Class.forName(name);
            printClass(cl);
            for (Method method : cl.getDeclaredMethods())
                printMethod(method);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printClass(Class<?> cl) {
        System.out.print(cl);
        printTypes(cl.getTypeParameters(), "<", ", ", ">", true);
        Type sc = cl.getGenericSuperclass();
        if (sc != null) {
            System.out.print(" extends ");
            printType(sc, false);
        }
        printTypes(cl.getGenericInterfaces(),
                " implements ", ", ", "", false);
        System.out.println();
    }

    public static void printMethod(Method method) {
        String name = method.getName();
        System.out.print(Modifier.toString(method.getModifiers()));
        System.out.print(" ");
        printTypes(method.getTypeParameters(), "<", ", ", "> ", true);

        printType(method.getGenericReturnType(), false);
        System.out.print(" ");
        System.out.print(name);
        System.out.print("(");
        printTypes(method.getGenericParameterTypes(), "", ", ", "", false);
        System.out.println(")");
    }

    public static void printTypes(Type[] types, String pre,
                                  String sep, String suf, boolean isDefinition) {
        if (pre.equals(" extends ") && Arrays.equals(types, new Type[]{Object.class}))
            return;
        if (types.length > 0)
            System.out.print(pre);
        for (int i = 0; i < types.length; i++) {
            if (i > 0)
                System.out.print(sep);
            printType(types[i], isDefinition);
        }
        if (types.length > 0)
            System.out.print(suf);
    }

    public static void printType(Type type, boolean isDefinition) {
        if (type instanceof Class) {
            Class<?> t = (Class<?>) type;
            System.out.print(t.getName());
        } else if (type instanceof TypeVariable) {
            TypeVariable<?> typeVariable = (TypeVariable<?>) type;
            System.out.print(typeVariable.getName());
            if (isDefinition)
                printTypes(typeVariable.getBounds(), " extends ", " & ", "", false);
        } else if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            System.out.print("?");
            printTypes(wildcardType.getUpperBounds(), " extends ", " & ", "", false);
            printTypes(wildcardType.getLowerBounds(), " super ", " & ", "", false);
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type owner = parameterizedType.getOwnerType();
            if (owner != null) {
                printType(owner, false);
                System.out.print(".");
            }
            printType(parameterizedType.getRawType(), false);
            printTypes(parameterizedType.getActualTypeArguments(), "<", ", ", ">", false);
        } else if (type instanceof GenericArrayType) {
            GenericArrayType genericArrayType = (GenericArrayType) type;
            System.out.print("");
            printType(genericArrayType.getGenericComponentType(), isDefinition);
            System.out.print("[]");
        }
    }
}
