data class QueueNode<T>(
    var value: T,
    var next: QueueNode<T>? = null
)


class Queue<T>(){
    val queue = mutableListOf<QueueNode<T>>()
    
    // t: O(N): add at the end
    fun enqueue(node: QueueNode<T>?){
        if (node == null)   return println("Node null")
        queue.add(node)
    }
      
             
    // t: O(1) 
    fun dequeue(): QueueNode<T>?{
        if (queue.isEmpty()) {println("List empty"); return null} 
        val item = queue.get(0)
        queue.removeAt(0)
        return item       
    }
    
    // t: O(1)
    fun peek(): QueueNode<T>?{
        if (queue.isEmpty()) {println("List empty"); return null}        
        return queue.get(0)       
    }
             
    fun isEmpty(): Boolean{
        if (queue.size <= 0  ) return true 
        return false
    }
    
    fun print(){
        for(item in queue) print("${item.value},")                  
    }
            
    
}



fun main() {
    
    var queue_01 = Queue<Int>()
    queue_01.enqueue(QueueNode<Int>(value = 27))    
    queue_01.enqueue(QueueNode<Int>(value = 5))
    queue_01.enqueue(QueueNode<Int>(value = 43))
    queue_01.enqueue(QueueNode<Int>(value = 12))
    queue_01.enqueue(QueueNode<Int>(value = 59))
    queue_01.enqueue(QueueNode<Int>(value = 90))
    queue_01.enqueue(QueueNode<Int>(value = 4))
    queue_01.enqueue(QueueNode<Int>(value = 888))
    queue_01.enqueue(QueueNode<Int>(value = 21))
    println("print new queue_01:")
    queue_01.print()
    
    println()
    println("deque queue_01 item :")        
    println(queue_01.dequeue()?.value)
    queue_01.print()
    
    println()   
    println("deque queue_01 item :")
    println(queue_01.dequeue()?.value)
    queue_01.print()
    
    println()
    println("peek queue_01 item :")
    println(queue_01.peek()?.value)     
    queue_01.print()       
           
}