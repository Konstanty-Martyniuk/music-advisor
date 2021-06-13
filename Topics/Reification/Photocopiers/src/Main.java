/**
 * Class to work with
 */
class Multiplicator {

	public static <T extends Copy<T>> Folder<T>[] multiply(Folder<T> folder, int arraySize) {
		Folder<T>[] array = new Folder[arraySize];
		T item = folder.get();

		for (int i = 0; i < arraySize; i++) {
		    array[i] = new Folder<>();
		    array[i].put(item.copy());
        }
		return array;
	}

}

// Don't change the code below
interface Copy<T> {
	T copy();
}

class Folder<T> {

    private T item;

    public void put(T item) {
    	this.item = item;
    }

    public T get() {
        return this.item;
    }
}