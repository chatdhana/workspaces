package mine.test;

public class Test {

    public static void main(String[] args) {

        Service<String> service = new ServiceImpl2();
        service.execute("String Input...");
    }

}

interface Service<T> {

    void execute(T input);
}

class ServiceImpl1<T> implements Service<T> {

    private Class<T> reqClazz;
    private Class<T> resClazz;

    public ServiceImpl1(Class<T> clazz1, Class<T> clazz2) {
        this.reqClazz = clazz1;
        this.resClazz = clazz2;
    }

    @Override
    public void execute(T input) {
        System.out.println("Execute.." + input.toString()+":"+resClazz.getName());
    }

}

class ServiceImpl2 extends ServiceImpl1<String> {
    ServiceImpl2() {
        super(String.class, String.class);
    }
}