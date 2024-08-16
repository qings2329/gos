import com.fasterxml.jackson.core.type.TypeReference;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class GetFunctionGenericType {


    public static void main(String[] args) {
        GetFunctionGenericType instance = new GetFunctionGenericType();
        List<String> params = Arrays.asList("123", "1");
        instance.test(params);
    }

    // 获取到的参数类型总是 TypeVariableImpl
    public <OUT, IN> OUT test(List<IN> parasms) {

        try {
            Method[] methods = this.getClass().getMethods();
            for (Method method : methods) {
                if (method.getName().equals("test")) {
                    Type[] genericParameterTypes = method.getGenericParameterTypes();
                    for (Type genericParameterType : genericParameterTypes) {
                        if (genericParameterType instanceof ParameterizedType) {
//                            System.out.println("泛型方法参数的类型: " + ((ParameterizedType) genericParameterType).getActualTypeArguments()[0]);
                            Class<IN> genericType = (Class<IN>) ((ParameterizedType) genericParameterType).getActualTypeArguments()[0];
                            System.out.println(genericType.getSimpleName());
                        }
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        Class clasz = new TypeReference<IN>() {}.getType().getClass();
//        System.out.println(clasz.getSimpleName());
//
//        TypeClass type = new TypeClass<IN>();
//        type.getGenericType();


        System.out.println(parasms);
        return null;
    }

}
