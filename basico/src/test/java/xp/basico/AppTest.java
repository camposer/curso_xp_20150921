package xp.basico;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AppTest {
	
	@Before
	public void before() {
		System.out.println("Antes");
	}
	
	@Test
	public void sumar() {
		Assert.assertEquals(4, 2 + 2);
	}

	@Test
	public void restar() {
		Assert.assertEquals(1, 3 - 2);
	}

	@After
	public void after() {
		System.out.println("Después");
	}
}