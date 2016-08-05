public class Test2 {

	public static void main(String[] args) {
		covariantArray();
		coinvariantGenerics();

		/*
		 * List<String>[] listArray1 = new ArrayList[1]; List<? extends String>[] listArray2 = new ArrayList<? extends String>[1];
		 * 
		 * listArray[0] = new ArrayList<String>(); listArray[0].add("One"); listArray[0].add("Two");
		 * 
		 * System.out.println(Arrays.toString(listArray));
		 */
	}

	static void covariantArray() {
		Super[] superArr = new Sub[10]; // Covariant support (Assigning array of subtype into array of supertype declaration)

		String[] strArray = new String[10];
		Object[] objArray = strArray;
		objArray[0] = 10; // throws java.lang.ArrayStoreException
	}

	static void coinvariantGenerics() {
		// List<Super> list = new ArrayList<Sub>(); // Compile time error
	}

	static void mixingOfCovariantAndCoinvariant() {
	}

	static int i = 0;

	private static class Super {

		static class NestedSuper {

			void m() {
				abstract class IfaceInsideRun {

				}
				new Runnable() {

					@Override
					public void run() {
						final int y = 0;
						new Runnable() {

							@Override
							public void run() {
								final int x = 0;
								class InsideRun {
									void m() {
										System.out.println(x + y + i);
									}
								}
							}

						};
					}

				};
			}
		}
	}

	class Sub extends Super {

	}

}
