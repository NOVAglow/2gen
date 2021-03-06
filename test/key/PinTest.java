package key;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import supply.NumberLib;


public class PinTest {
	private Pin myPin1;
	private Pin myPin2;
    String file01 = "samples/pinlist1.txt";
    String file02 = "samples/pinlist2.txt";
    String file03 = "samples/pinlist3.txt";
    String file04 = "samples/pinlist4.txt";  // This file contains all pins from 1000 to 9999, except 4242

	@Before
	public void setUp() {

		String[] fileList1 = {file01, file02, file03};
		String[] fileList2 = {file04};
		myPin1 = new Pin(4, fileList1);
		myPin2 = new Pin(4, fileList2);
	}

	@Test
	public void test() {
		// TODO: Pick a random line from the exception file (which is a pin) and it's ok if the generated pin isn't the same
		try {
			for (int trial = 0; trial < 200; trial++) {
				assertTrue(myPin1.value !=
					Files.readAllLines(Paths.get(file01))
					.get(NumberLib.randomNumber(0, NumberLib.numberOfLines(file01) - 2)));
			}
			for (int trial = 0; trial < 200; trial++) {
				assertTrue(myPin1.value !=
						Files.readAllLines(Paths.get(file02))
								.get(NumberLib.randomNumber(0, NumberLib.numberOfLines(file02) - 2)));
			}
            for (int trial = 0; trial < 200; trial++) {
                assertTrue(myPin1.value !=
                        Files.readAllLines(Paths.get(file03))
                                .get(NumberLib.randomNumber(0, NumberLib.numberOfLines(file03) - 2)));
            }
		    assertTrue(myPin2.value.equals("4242"));
			assertFalse(myPin2.value.equals("1000"));
		} 
		catch (Exception e) {
            e.printStackTrace();
        }
	}

}
