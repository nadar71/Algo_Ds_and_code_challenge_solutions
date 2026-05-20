data class QueueNode<T>(
    var value: T,
    var next: QueueNode<T>? = null
)


data class Queue<T>(
    var head: QueueNode<T>? = null,
    var tail: QueueNode<T>? = null,
    var length: Int = 0
    
){
    
    // t: O(N): add at the end
    fun enqueue(node: QueueNode<T>?){
        if (node == null ) return println("Node null")
        if (head == null ) return println("List empty")
        var ptr = head
        while (ptr?.next != null){   // reach last item in list: last.next == null
            ptr = ptr.next
        }
        ptr?.next = node
        tail = node
        length++
    }
    
    // t: O(1) : using tail pointer
    fun enqueueFast(node: QueueNode<T>?){
        if (node == null) return println("Node null")
        if (head == null) return println("List empty")
        if (tail != null) tail?.next = node
        tail = tail?.next
        length++
    }
             
    // t: O(1) 
    fun dequeue(): QueueNode<T>?{
        if (head == null ) {println("List empty"); return null}
        
        val item = head
        head = head?.next
        length--
        return item       
    }
    
    // t: O(1)
    fun peek(): QueueNode<T>?{
        if (head == null ) {println("List empty"); return null}        
        return head       
    }
             
    fun isEmpty(): Boolean{
        if (head == null ) return true 
        return false
    }
            
    
}



fun printQueueList(head: QueueNode<Int>?){
    if (head == null) return println("[]")
    var curr = head
    while(curr != null){
        print("${curr.value},")
        curr = curr.next
    }
    println()
}


fun main() {
    
    var queue_01 = Queue(QueueNode<Int>(value = 27))
    queue_01.enqueue(QueueNode<Int>(value = 5))
    queue_01.enqueue(QueueNode<Int>(value = 43))
    queue_01.enqueue(QueueNode<Int>(value = 12))
    queue_01.enqueueFast(QueueNode<Int>(value = 59))
    queue_01.enqueueFast(QueueNode<Int>(value = 90))
    queue_01.enqueueFast(QueueNode<Int>(value = 4))
    queue_01.enqueue(QueueNode<Int>(value = 888))
    queue_01.enqueue(QueueNode<Int>(value = 21))
    println("print new queue_01:")
    printQueueList(queue_01.head)
    
    println()
    println("deque queue_01 item :")        
    println(queue_01.dequeue()?.value)
    printQueueList(queue_01.head)
    
    println()   
    println("deque queue_01 item :")
    println(queue_01.dequeue()?.value)
    printQueueList(queue_01.head)
    
    println()
    println("peek queue_01 item :")
    println(queue_01.peek()?.value)     
    printQueueList(queue_01.head)        
           
}

/*
print new queue_01:
27,5,43,12,59,90,4,888,21,

deque queue_01 item :
27
5,43,12,59,90,4,888,21,

deque queue_01 item :
5
43,12,59,90,4,888,21,

peek queue_01 item :
43
43,12,59,90,4,888,21,
*/