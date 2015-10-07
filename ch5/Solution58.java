package ch5.cbc.xuewei.ece.cmu;

public class Solution58 {

	public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
		/*
		 * because the organization of bits are bytes, it's much easier to
		 * modify the number in bytes than in bits. So we find the full bytes
		 * between x1 and x2, set the bytes as 0xFF. And we use mask to set the
		 * rest bits beyond the full bytes' range
		 */

		// exception cases
		if (x1 > x2 || screen.length < (width * y + x2) / 8 || width == 0) {
			System.out.println("Exception!");
			return;
		}

		// find the start position
		int startInByte = x1 % 8;
		int indexFirstByte = x1 / 8;
		// make sure that the index is the next full byte after x1
		if (startInByte != 0) {
			indexFirstByte++;
		}

		// find the end position
		int endInByte = x2 % 8;
		int indexLastByte = x2 / 8;
		// make sure that the index is the previous full byte after x2
		if (endInByte != 7) {
			indexLastByte--;
		}
		System.out.println(indexFirstByte + ", " + indexLastByte);

		// set bytes
		for (int i = indexFirstByte; i <= indexLastByte; i++) {
			screen[(width / 8) * y + i] = (byte) 0xFF;
		}

		// use masks to set the rest bits
		byte mask1 = (byte) (0xFF >>> startInByte);
		byte mask2 = (byte) ~(0xFF >>> (endInByte + 1));
		// note that cannot use indexFirstByte and indexLastByte to compare here
		// because they are index of full bytes, and this situation doesn't have
		// even one full byte
		if (x1 / 8 == x2 / 8) {
			// the line is in the same byte
			byte mask = (byte) (mask1 & mask2);
			screen[(width * y + x1) / 8] |= mask;
		} else {
			if (startInByte != 0) {
				int index = (width / 8) * y + indexFirstByte - 1;
				screen[index] |= mask1;
				System.out.println(screen[index]);
			}
			if (endInByte != 7) {
				int index = (width / 8) * y + indexLastByte + 1;
				screen[index] |= mask2;
			}
		}

	}

	/*
	 * test function
	 */
	public static void test(byte[] screen, int width, int x1, int x2, int y) {
		int len = screen.length;
		Solution58.drawLine(screen, width, x1, x2, y);
		for (int i = 0; i < len * 8 / width; i++) {
			for (int j = 0; j < width / 8; j++) {
				System.out.print(String
						.format("%8s",
								Integer.toBinaryString((screen[i * width / 8
										+ j]) & 0xFF)).replace(' ', '0'));
				// System.out.print((screen[i*width/8 + j]));
				System.out.print('\t');
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}

	public static void main(String[] args) {
		byte[] screen = new byte[25];
		int width = 5 * 8;
		int x1 = 1;
		int x2 = 3;
		int y = 1;
		Solution58.test(screen, width, x1, x2, y);

		screen = new byte[25];
		x1 = 27;
		x2 = 38;
		Solution58.test(screen, width, x1, x2, y);

	}

}
