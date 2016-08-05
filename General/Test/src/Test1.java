import java.io.Closeable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

strictfp public class Test1 {

	/**
	 * @param args
	 */
	strictfp public static void main(String[] args) {
		byte x = 12;
		byte y = 20;
		long x1 = 0l;
		double y1 = 0.0d;
		double z11 = x + y + x1 + y1;
		byte z1 = (byte) (x + y);
		System.out.println(z11);

		byte bb2 = 127;
		byte bb3 = 2;
		byte bb1 = (byte)(bb2 + bb3);
		System.out.println(bb1);
		System.out.println(Integer.toBinaryString(-128));
		System.out.println(Integer.toBinaryString(127));
		System.out.println(Integer.toBinaryString(128));

		int i1 = 2147483647 + 3;
		System.out.println(1000000 * 1000000);
		System.out.println(0 / 0.0); // Float.NaN

		// An example of overflow:
		double d = 1e308;
		System.out.print("overflow produces infinity: ");
		System.out.println(d + "*10==" + d * 10);
		// An example of gradual underflow:
		d = 1e-306 * Math.PI;
		System.out.print("gradual underflow: " + d + "\n");
		for (int i = 0; i < 6; i++)
			System.out.print(" " + (d /= 100000));
		System.out.println();
		// An example of NaN:
		System.out.print("0.0/0.0 is Not-a-Number: ");
		d = 0.0 / 0.0;
		System.out.println(d);
		// An example of inexact results and rounding:
		System.out.print("inexact results with float:");
		for (int i = 0; i < 100; i++) {
			
			float z = 1.0f / i;
			System.out.println(z*i);
			if (z * i != 1.0f)
				System.out.print(" " + i);
		}
		System.out.println();
		// Another example of inexact results and rounding:
		System.out.print("inexact results with double:");
		for (int i = 0; i < 200; i++) {
			double z = 1.0d / i;
			if (z * i != 1.0d)
				System.out.print(" " + i);
		}
		System.out.println();
		// An example of cast to integer rounding:
		System.out.print("cast to int rounds toward 0: ");
		d = 12345.6;
		System.out.println((int) d + " " + (int) (-d));
		System.out.println((1.0 / 49) * 49);
		System.out.println((1.0 / 50) * 50);
		System.out.println((true | true));
		int xxx = 0;
		if (xxx == 0 == true) {

		}
		if (new Boolean(false) != null == true) {
			System.out.println(";true;");
		}

		int[] cc = { 1, 2 };
		System.out.println(cc.getClass());
		System.out.println(cc.toString());
		System.out.println(cc.clone().toString());

		double d1 = 1230098878873738882233.08928928779d;
		int i2 = (int) d1;
		System.out.println("i2:" + i2);

		byte b1 = 46;
		short s1 = -23767;
		char c1 = 65;
		char c2 = '\u0061';
		System.out.println("x:" + (char) b1);
		System.out.println("c2:" + c2);
		System.out.println(new Byte(b1).byteValue());
		System.out.println(new Short(s1).shortValue());

		Object obj = new int[10];
		char c3 = '\u0001';
		System.out.println(((int[]) obj)[c3]);

		int leftOper = 1;
		int shiftDist = -8;
		System.out.println(Integer.toBinaryString(leftOper) + ">>"
				+ Integer.toBinaryString(shiftDist) + "="
				+ (leftOper >> shiftDist));
		System.out.println(Integer.toBinaryString(leftOper) + "<<"
				+ Integer.toBinaryString(shiftDist) + "="
				+ (leftOper << shiftDist));
		System.out.println(Integer.toBinaryString(leftOper) + ">>>"
				+ Integer.toBinaryString(shiftDist) + "="
				+ (leftOper >>> shiftDist));
	}

}