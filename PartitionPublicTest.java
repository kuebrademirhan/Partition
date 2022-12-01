import static org.junit.Assert.*;
import java.lang.reflect.*;
import java.util.*;
import org.junit.*;

public class PartitionPublicTest {
	// ========== SYSTEM ==========
	protected static final String EX_NAME_Partition = "Partition.partition";
	protected static final String CLASS_NAME_Partition = "Partition";
	protected static final String METHOD_NAME_partition = "partition";
	protected static final String METHOD_NAME_helper = "helper";
	protected static final String CLASS_METHOD_NAME_PartitionChecker_allEqual = "PartitionChecker.allEqual";
	// --------------------

	// ========== TEST-DATA ==========
	private static final Random RND = new Random(4711_0815_666L);

	// ========== CHECK INTESTINES ==========
	@Test(timeout = 666)
	public void pubTest__Intestines__IF_THIS_VERY_IMPORTANT_TEST_FAILS_THEN_YOU_WILL_GET_NO_POINTS_AT_ALL() {
		check__Intestines();
	}

	// ========== PUBLIC TEST ==========
	@Test(timeout = 11666)
	public void pubTest__exerciseSheetExample1_and_random1() {
		PartitionPublicTest.check(new long[]{2, 1, 4, 5, 6}, 3, true);
		runRandomTestWithSolution();
		runRandomTestWithoutSolution();
	}

	@Test(timeout = 11666)
	public void pubTest__exerciseSheetExample2_and_random2() {
		PartitionPublicTest.check(new long[]{2, 1, 5, 5, 6}, 3, false);
		runRandomTestWithSolution();
		runRandomTestWithoutSolution();
	}

	@Test(timeout = 11666)
	public void pubTest__anotherExample_and_random3() {
		PartitionPublicTest.check(new long[]{3, 1, 1, 6, 4, 7, 5, 2, 5, 1}, 5, true);
		runRandomTestWithSolution();
		runRandomTestWithoutSolution();
	}

	@Test(timeout = 11666)
	public void pubTest__random4() {
		runRandomTestWithSolution();
		runRandomTestWithoutSolution();
	}

	@Test(timeout = 11666)
	public void pubTest__random5() {
		runRandomTestWithSolution();
		runRandomTestWithoutSolution();
	}

	// ========== HELPER: Intestines ==========
	// @AuD-STUDENT: DO NOT USE REFLECTION IN YOUR OWN SUBMISSION!
	private static Class<?>[] getDeclaredClasses(Class<?> clazz) {
		java.util.List<Class<?>> declaredClasses = new java.util.ArrayList<>();
		for (Class<?> c : clazz.getDeclaredClasses()) {
			if (!c.isSynthetic()) {
				declaredClasses.add(c);
			}
		}
		return declaredClasses.toArray(new Class[0]);
	}

	private static Field[] getDeclaredFields(Class<?> clazz) {
		java.util.List<Field> declaredFields = new java.util.ArrayList<>();
		for (Field f : clazz.getDeclaredFields()) {
			if (!f.isSynthetic()) {
				declaredFields.add(f);
			}
		}
		return declaredFields.toArray(new Field[0]);
	}

	private static Constructor<?>[] getDeclaredConstructors(Class<?> clazz) {
		java.util.List<Constructor<?>> declaredConstructors = new java.util.ArrayList<>();
		for (Constructor<?> c : clazz.getDeclaredConstructors()) {
			if (!c.isSynthetic()) {
				declaredConstructors.add(c);
			}
		}
		return declaredConstructors.toArray(new Constructor[0]);
	}

	private static Method[] getDeclaredMethods(Class<?> clazz) {
		java.util.List<Method> declaredMethods = new java.util.ArrayList<>();
		for (Method m : clazz.getDeclaredMethods()) {
			if (!m.isBridge() && !m.isSynthetic()) {
				declaredMethods.add(m);
			}
		}
		return declaredMethods.toArray(new Method[0]);
	}

	private void check__Intestines() {
		Class<Partition> clazz = Partition.class;
		assertTrue(clazz + " must be public!", Modifier.isPublic(clazz.getModifiers()));
		assertFalse(clazz + " must not be abstract!", Modifier.isAbstract(clazz.getModifiers()));
		assertFalse(clazz + " must not be an annotation!", clazz.isAnnotation());
		assertFalse(clazz + " must not be an enumeration!", clazz.isEnum());
		assertFalse(clazz + " must not be an interface!", clazz.isInterface());
		assertSame(clazz + " must extend a certain super-class!", Object.class, clazz.getSuperclass());
		assertEquals(clazz + " must implement a certain number of interfaces!", 0, clazz.getInterfaces().length);
		assertSame(clazz + " must implement a certain number of interfaces!", 0, clazz.getInterfaces().length);
		assertEquals(clazz + " must declare a certain number of inner annotations!", 0, clazz.getDeclaredAnnotations().length);
		assertEquals(clazz + " must declare a certain number of inner classes!", 0, getDeclaredClasses(clazz).length);
		Field[] fields = getDeclaredFields(clazz);
		assertEquals(clazz + " must declare a certain number of fields!", 0, fields.length);
		Constructor<?>[] constructors = getDeclaredConstructors(clazz);
		assertEquals(clazz + " must declare a certain number of constructors (possibly including default constructor)!", 1, constructors.length);
		for (Constructor<?> constructor : constructors) {
			assertTrue(constructor + " - constructor must be public!", Modifier.isPublic(constructor.getModifiers()));
			assertEquals(constructor + " - constructor must have a certain number of parameters!", 0, constructors[0].getParameterTypes().length);
		}
		Method[] methods = getDeclaredMethods(clazz);
		assertEquals(clazz + " must declare a certain number of methods!", 2, methods.length);
	}

	// ========== HELPER ==========
	private void runRandomTestWithSolution() {
		for (int pass = 0; pass < 7; pass++) {
			int k = 1 + RND.nextInt(5);
			int s = 42 + RND.nextInt(42);
			List<Long> aList = new LinkedList<>();
			for (int i = 0; i < k; i++) {
				int rest = s;
				while (rest > 7) {
					long part = 7 + RND.nextInt(rest - 7);
					aList.add(part);
					rest -= part;
				}
				if (rest > 0) {
					aList.add((long) rest);
				}
			}
			Collections.shuffle(aList);
			long[] a = new long[aList.size()];
			for (int i = 0; i < a.length; i++) {
				a[i] = aList.get(i);
			}
			PartitionPublicTest.check(a, k, true);
		}
	}

	private void runRandomTestWithoutSolution() {
		for (int pass = 0; pass < 7; pass++) {
			int k = 1 + RND.nextInt(10);
			long[] a = new long[42 + RND.nextInt(42)];
			long s = 0;
			for (int i = 0; i < a.length; i++) {
				a[i] = 42 + RND.nextInt(42);
				s += a[i];
			}
			if (s % k == 0) {
				a[RND.nextInt(a.length)]++;
			}
			PartitionPublicTest.check(a, k, false);
		}
	}

	protected static void check(long[] a, int k, boolean hasSol) {
		String msg = PartitionPublicTest.CLASS_NAME_Partition + "." + PartitionPublicTest.METHOD_NAME_partition + " failed: ";
		long[] aClone = Arrays.copyOf(a, a.length);
		PartitionPublicTest.BigBrother pc = new PartitionPublicTest.BigBrother();
		int[] actual = Partition.partition(pc, aClone, k);
		assertArrayEquals(msg + "input modified illegally.", a, aClone);
		if (actual != null) {
			assertEquals(msg + "wrong recursion depth (min).", a.length + 1, pc.getMinStackTraceDepth());
			assertEquals(msg + "wrong recursion depth (max).", a.length + 1, pc.getMaxStackTraceDepth());
			assertEquals(msg + "illegal result length", a.length, actual.length);
			long[] ss = new long[k];
			for (int i = 0; i < a.length; i++) {
				assertTrue(msg + "illegal bucket index", 0 <= actual[i] && actual[i] < k);
				ss[actual[i]] += a[i];
			}
			for (int b = 1; b < k; b++) {
				assertEquals(msg + "sums of resulting subsets differ.", ss[b - 1], ss[b]);
			}
		} else if (hasSol) {
			fail(msg + "returned null, although a solution is known.");
		} else {
			assertEquals(msg + "wrong recursion depth (min).", 0, pc.getMinStackTraceDepth());
			assertEquals(msg + "wrong recursion depth (max).", 0, pc.getMaxStackTraceDepth());
			assertEquals(msg + "wrong number of calls to " + PartitionPublicTest.CLASS_METHOD_NAME_PartitionChecker_allEqual, 0, pc.getNumberOfCalls());
		}
	}

	// ========== Big Brother ==========
	private static final class BigBrother implements PartitionChecker {
		private final LinkedList<Integer> stackTraceLog = new LinkedList<>();

		@Override
		public boolean allEqual(long[] array) {
			int stackDepth = 0;
			StackTraceElement[] st = Thread.currentThread().getStackTrace();
			for (StackTraceElement ste : st) {
				if (ste.getClassName().equals(CLASS_NAME_Partition)) {
					if (ste.getMethodName().equals(METHOD_NAME_helper)) {
						stackDepth++;
					}
				}
			}
			stackTraceLog.add(stackDepth);
			for (int i = 1; array != null && i < array.length; i++) {
				if (array[i - 1] != array[i]) {
					return false;
				}
			}
			return true;
		}

		private int getNumberOfCalls() {
			return stackTraceLog.size();
		}

		private int getMinStackTraceDepth() {
			boolean first = true;
			int min = 0;
			for (Integer i : stackTraceLog) {
				min = (first || i < min) ? i : min;
				first = false;
			}
			return min;
		}

		private int getMaxStackTraceDepth() {
			boolean first = true;
			int max = 0;
			for (Integer i : stackTraceLog) {
				max = (first || i > max) ? i : max;
				first = false;
			}
			return max;
		}
	}
}