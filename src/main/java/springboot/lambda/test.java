package springboot.lambda;

public class test {
    public static void main(String[] args) {
        MyFunction<Desk,Object> f = new MyFunction<Desk, Object>() {
            @Override
            public Object apply(Desk desk) {
                return null;
            }
        };
        Object apply = f.apply(new Desk());
    }
}
//模拟lambda函数
@FunctionalInterface
interface MyFunction<T,R> {
    R apply(T t);
    default void ok(){
        System.out.println("default,ok");
    }
}

class Desk{
    private String name = "哈哈";
    public String getName(){
        return name;
    }
}