public interface PartitionChecker {
	/**
	 * @param array the values to be checked for equality
	 * @return true, iff all entries in the given {@code array} are equal
	 */
	boolean allEqual(long[] array);
}