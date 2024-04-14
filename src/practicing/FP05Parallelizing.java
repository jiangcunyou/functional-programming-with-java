package practicing;

import java.util.stream.LongStream;

public class FP05Parallelizing {
	
	public static void main(String[] args) {

		// 0, 10000000000
		long time = System.currentTimeMillis();
		System.out.println(LongStream.range(0, 1000000000).parallel().sum());

		System.out.println(System.currentTimeMillis() - time);
	}
}
