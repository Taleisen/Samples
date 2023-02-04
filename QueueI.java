/*
 *Written by Curtis Lynn 
 */
public interface QueueI<T> 
{
	public void Enqueue(T data);
	public T Dequeue();
	public T Peek();
	public void Print();
}
