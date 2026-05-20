// T : enqueue : O(1)
//     dequeue : O(1) - O(n)    
       peek :    O(1) - O(n)
// S : O(n)


class Queue<T>(){
    val queueStack: ArrayList<T> = ArrayList<T>()
    val dequeueStack: ArrayList<T> = ArrayList<T>()
    
    fun enqueue(item: T){
        queueStack.add(item)
    }

    fun dequeue(): T?{
        if (isQueueEmpty()) return null 

        val last = dequeueStack.size - 1
        val popped = dequeueStack.get(last)
        dequeueStack.removeAt(last)
        return popped               
    }
    
    fun peek(): T?{
        if (isQueueEmpty()) return null
        val last = dequeueStack.size - 1
        return dequeueStack.get(last)
        
    }

    fun fillDequeueStack(){ 
        while(!queueStack.isEmpty()){
            val last = queueStack.size - 1
            val popped = queueStack.get(last)
            queueStack.removeAt(last)
            dequeueStack.add(popped)
        }
   		println(queueStack)
		println(dequeueStack)
    }

    fun queueStackIsEmpty(): Boolean{
        if (queueStack.isEmpty()) {
            println("Queue Stack empty")
            return true
        }
        return false
    }  
    
    
    fun isQueueEmpty(): Boolean{
        if (dequeueStackIsEmpty()) 
			if (queueStackIsEmpty()) {
               println("Queue is empty, fill it before dequeue")
               return true 
            } else {
				println("filling the deque...")
                fillDequeueStack()
            }
		return false
    }

    fun dequeueStackIsEmpty(): Boolean{
        if (dequeueStack.isEmpty()) {
            println("Dequeue Stack empty, fill it before from enqueue stack")
            return true
        }
        return false
    }
    
    
    
    
}


fun main() {
    var item: Int?

    val queue = Queue<Int>()
	item = queue.dequeue()
    
    queue.enqueue(1)
    item = queue.peek()
    println("peek: $item")
    
    
    queue.enqueue(2)
    item = queue.peek()
    println("peek: $item")
    
    
    queue.enqueue(3)
    item = queue.peek()
    println("peek: $item")


    item = queue.dequeue()
    println("dequeue: $item")
    
    
    item = queue.dequeue()
    println("dequeue: $item")
       

    item = queue.dequeue()
    println("dequeue: $item")
       
}
