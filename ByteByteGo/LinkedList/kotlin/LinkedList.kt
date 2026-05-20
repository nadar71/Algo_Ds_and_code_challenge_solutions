// Linked list creation and print

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
}
