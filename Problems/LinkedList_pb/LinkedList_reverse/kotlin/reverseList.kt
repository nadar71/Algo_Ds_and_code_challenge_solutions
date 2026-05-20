// Revert list iterative and not

class ListNode<T>(
    var value: T,
    var next: ListNode<T>? = null
)

fun createLinkedListOfInt(size: Int): ListNode<Int>?{
    if (size == 0) return null
    var counter = 1
    val start = ListNode<Int>(value = counter)
    var curr = start
    while(counter < size){
       counter++        
       curr.next = ListNode(value = counter)
       curr = curr.next!!
    }
    return start
}


// Iterative: t: O(N), s: O(1)
fun revertedLinkedList(head: ListNode<Int>?): ListNode<Int>?{
    if (head == null ) {println("List empty"); return null}
    var curr = head
    var prev: ListNode<Int>? = null
    var next: ListNode<Int>? = null
    while (curr != null){
        next = curr.next
        curr.next = prev
        prev = curr
        curr = next        
    }
    return prev
}



// Recursive: t: O(N), s: O(N)
fun revertedLinkedListRec(head: ListNode<Int>?): ListNode<Int>?{
    if (head == null || head?.next == null) {println("Coming back");return head  }
    
    var newHead = revertedLinkedListRec(head.next) // Recursively reverse the sublist starting at the next node.
    head.next?.next = head // Connect the reversed sublist to the head node to fully reverse the entire linked list.
    head.next = null
    return newHead  
}



fun printLinkedList(head: ListNode<Int>?){
    if (head == null) return println("[]")
    var curr = head
    while(curr != null){
        print("${curr.value},")
        curr = curr.next
    }
    println()
}

fun main() {
    var list_01 = createLinkedListOfInt(10)
    printLinkedList(list_01)     
    // println("revert list_01 empty:")  
    // printLinkedList(revertedLinkedList(list_01)) 
    
    println("revert list_01 again recursively:")  
    printLinkedList(revertedLinkedListRec(list_01)) 
}
