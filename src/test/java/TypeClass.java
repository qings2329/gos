import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TypeClass<T> extends AbstractTypeClass<T> {

    public Class<T> getGenericType() {
        return genericType;
    }

    private Class<T> genericType;

    public TypeClass() {
        // 为什么在idea 看不到 types
//        Type[] types = getClass().getGenericInterfaces();
//        for (Type type : types) {
//            if (type instanceof ParameterizedType) {
//                ParameterizedType parameterizedType = (ParameterizedType) type;
//                java.lang.reflect.Type[] typeArgs = parameterizedType.getActualTypeArguments();
//                if (typeArgs.length > 0) {
//                    this.genericType = (Class<T>) typeArgs[0];
//                    System.out.println(this.genericType.getSimpleName());
//                }
//            }
//        }

        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) superClass;
            java.lang.reflect.Type[] typeArgs = parameterizedType.getActualTypeArguments();
            if (typeArgs.length > 0) {
                this.genericType = (Class<T>) typeArgs[0];
                System.out.println(this.genericType.getSimpleName());
            }
        }

    }
}
