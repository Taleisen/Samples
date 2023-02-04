/*
 *Written by Curtis Lynn 
 */
public class ProcessScheduler 
{
	private LLQueue processes = new LLQueue();
	private Process currentProcess;
	
	public Process getCurrentProcess() 
	{
		return this.currentProcess;
	}
	
	public void addProcess(Process addition) //add process to the end of the list
	{
		processes.Enqueue(addition);
		if(currentProcess == null) //head has not been established
		{
			currentProcess = (Process)processes.Dequeue();
		}
	}
	
	public void runNextProcess() //advance queue
	{
		currentProcess = (Process)processes.Dequeue();
	}
	
	public void cancelCurrentProcess() //cancel current process and proceed to next process
	{
		currentProcess = (Process)processes.Dequeue();
	}
	
	public void printProcessQueue() //print queue
	{
		if(currentProcess != null)
			processes.Print();
	}
}
