



class ListNode<T>(
    var value: T,
    var next: ListNode<T>? = null
)


class LinkedList<T>(
    var head: ListNode<T>? = null,
    var length: Int = 0
    
){
    
    // to simplify, add tail attribute for ponting to last node
    // t: O(N)
    fun append(node: ListNode<T>?){
        if (node == null ) return println("Node null")
        if (head == null ) return println("List empty")
        var ptr = head
		while (ptr?.next != null){ // reach last item in list: last.next == null
            ptr = ptr.next
        }
		ptr?.next = node
    }
    
    // t: O(1)
    fun insertHead(node: ListNode<T>?){
        if (node == null ) return println("Node null")
        if (head != null) {
            node.next = head
            head = node
        }
        else head = node
    }


    // t: O(N) --> speed up adding a tail pointer updated in append ops
    fun deleteTail(): Boolean{
        if (head == null ) {println("List empty"); return false}
        
        var ptr = head
        if (head?.next == null){  // head is the only list item
            head = null           // empty list
            return true
        }
        while (ptr?.next != null){          
            val nextNode = ptr.next!!    // punto al nodo successivo
            if (nextNode.next == null){  // check that it is the tail: next point to null, so ptr is last but one node
                ptr.next = null          // change last but one node's next pointer 
                return true
            }
            ptr = ptr.next               
        }
              
        return false
    }

    
    // t: O(N) worst case
    fun deleteNode(node: ListNode<T>?): Boolean{
        if (node == null ) {println("Node null"); return false}
        if (head == null ) {println("List empty"); return false}
        var ptr = head
        if (head?.value == node.value  && head?.next == null){ // head is the item to delete and it's the only list item
            head = null // empty list
            return true
        }
        while (ptr?.next != null){
            if (ptr.value == node.value ){ // change head
               head = ptr.next
               return true 
            }
            val nextNode = ptr.next!! 
            if (nextNode.value == node.value){
                ptr.next = nextNode.next
                return true
            }
            ptr = ptr.next
        }
              
        return false
    }
    
}


fun createLinkedListOfInt(size: Int): ListNode<Int>?{
    if (size == 0) return null
    var counter = 1
    val start = ListNode<Int>(value = counter)
    var curr = start
    while(counter <= 10){
       curr.next = ListNode(value = ++counter)
       curr = curr.next!!
    }
    return start
}



fun printLinkedList(node: ListNode<Int>?){
    if (node == null) return println("[]")
    var curr = node
    while(curr != null){
        print("${curr.value},")
        curr = curr.next
    }
    println()
}

fun main() {
    printLinkedList(createLinkedListOfInt(10))  
    println("Create new list_01 appending items")
    
    var list_01 = LinkedList(ListNode<Int>(value = 27))
    list_01.append(ListNode<Int>(value = 5))
    list_01.append(ListNode<Int>(value = 43))
    list_01.append(ListNode<Int>(value = 12))
    list_01.append(ListNode<Int>(value = 59))
    list_01.append(ListNode<Int>(value = 90))
    list_01.append(ListNode<Int>(value = 4))
    list_01.append(ListNode<Int>(value = 888))
    list_01.append(ListNode<Int>(value = 21))
    println("print new list_01:")
    printLinkedList(list_01.head)
    
    println("delete list_01 item in the middle:")
    list_01.deleteNode(ListNode<Int>(12))
    printLinkedList(list_01.head)

    println("delete list_01 item tail:")
    list_01.deleteNode(ListNode<Int>(21))
    printLinkedList(list_01.head)

    println("delete list_01 item tail with deleteTail:")
    list_01.deleteTail()
    printLinkedList(list_01.head)

    println("delete list_01 item head:")
    list_01.deleteNode(ListNode<Int>(27))
    printLinkedList(list_01.head)
    
    println("create new list_02:")    
    var list_02 = LinkedList(ListNode<Int>(23))
    printLinkedList(list_02.head)

    println("change list_02 head:")
    list_02.insertHead(ListNode<Int>(55))
    printLinkedList(list_02.head)
    
    println("delete list_02 all items:")
    list_02.deleteNode(ListNode<Int>(23))
    list_02.deleteNode(ListNode<Int>(55))
    printLinkedList(list_02.head)

    println("delete item from list_02 empty:")
    list_02.deleteNode(ListNode<Int>(19))
    
    println("add first item (header) to list_02 empty:")
    list_02.append(ListNode<Int>(71))
    printLinkedList(list_02.head)
	list_02.insertHead(ListNode<Int>(71))
    printLinkedList(list_02.head)
    
}