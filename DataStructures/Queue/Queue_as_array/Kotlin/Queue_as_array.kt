class Queue<T>(){
    val queue: ArrayList<T> = ArrayList<T>()
    
    fun enqueue(item: T){
        queue.add(item) 
    }

    fun dequeue(): T?{
        if (isQueueEmpty()) return null 

        val popped = queue.get(0)
        queue.removeAt(0)
        return popped               
    }
    
    fun peek(): T?{
        if (isQueueEmpty()) return null
        return queue.get(0)        
    }
    
    fun isQueueEmpty(): Boolean{
        if (queue.isEmpty()){
               println("Queue is empty")
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