/*
 * Curtis Lynn
 */
public interface StackI<T> {
	public void Push(T data);//adds to head element
	public T Pop();//removes head element and returns data
	public T Peek();//views data of head element without removing
	public void Print();//prints all values
	public int Size();//number of elements in list
}
