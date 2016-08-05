package mine.interfaces;

public interface GenericAbstractMethod {

	<T> void myGenerciMethod1(T typeVariable);

	<T> void myGenerciMethod2(T typeVariable);

	<K> void myGenerciMethod3(K typeVariable);
}
