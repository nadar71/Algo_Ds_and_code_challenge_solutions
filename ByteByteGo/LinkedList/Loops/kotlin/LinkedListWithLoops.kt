// Create linked list loops, delayed and perfect
// detect loops
// detect linked list midpoint, both 1st and 2nd in case of even node number linked list


fun main() {
    val list_01 = createLinkedListOfInt(10)
    printLinkedList("Original list: ", list_01)
    printLinkedListAtPos("Print at pos 7: ",list_01,7)
    println("list_01 has loop? ${detectLoop(list_01!!)}\n")
    loopLinkedListAt(3,list_01!!)
    printLinkedListAtPos("Print looped list at pos 7: ",list_01,17) 
    println("list_01 now has loop? ${detectLoop(list_01!!)}\n")

    
    val list_02 = createLinkedListOfInt(10)
    printLinkedList("Original list: ", list_02)
    println("list_02 has loop? ${detectLoop(list_02!!)}\n" )  
    perfectLoopLinkedListAt(list_02!!)
    printLinkedListAtPos("Print perfect looped list at pos 15: ",list_02,15) 
    println("list_02 now has loop? ${detectLoop(list_02!!)}\n")
    
    val list_03 = createLinkedListOfInt(11)
    printLinkedList("Original list: ", list_03)
    var middle = detectLinkedListMiddleItem(list_03!!)
    println("Midnode for odd list : ${middle?.value}\n")
    
    
    val list_04 = createLinkedListOfInt(10)
    printLinkedList("Original list: ", list_04)    
    middle = detectLinkedListMiddleItem_2nd(list_04!!)
    println("Midnode for even list (2nd from left) : ${middle?.value}\n")
        
    middle = detectLinkedListMiddleItem_1st(list_04!!)
    println("Midnode for even list (1st from left) : ${middle?.value}\n")
    
       
}

class ListNode<T>(
    var value: T,
    var next: ListNode<T>? = null
)


// delayed linked list loop ( linear node before loop)
fun loopLinkedListAt(position: Int, head: ListNode<Int>){
    // count moving along the list till position
    // save node in a ptr: loop_node
    // move till the last node
    // set last_node.next = loop_node
    
    var count = 1
    var curr_node = head
    var loop_junc: ListNode<Int>? = null
    
    while (curr_node.next != null){
        if (count == position){
            loop_junc = curr_node!!
        }
        curr_node = curr_node.next!!
        count++
    }
    
    curr_node.next = loop_junc           
    // return curr_node
}


// perfect loop
fun perfectLoopLinkedListAt(head: ListNode<Int>){
    // count moving along the list till last node
    // set last_node.next = head
    
    var count = 1
    var curr_node = head
    
    while (curr_node.next != null){       
        curr_node = curr_node.next!!
    }
    
    curr_node.next = head  
}

// detect any kind of loop
// t: O(n)
// s: O(1)
fun detectLoop(head: ListNode<Int>):Boolean{
    // slow and fast ptr start together
    // while loop until fast or fast.next null: check if fast == slow : return true
    // return false
    var slow: ListNode<Int>? = head
    var fast: ListNode<Int>? = head
    while(fast != null && fast?.next != null ){
        slow = slow?.next
        fast = fast?.next?.next
        if (fast == slow) return true
    }
    return false
}


// Return its middle node. If there are two middle nodes (even nodes number linked list), return the 2nd one.
// When the fast pointer reaches the end of the list (fast.next), the slow pointer will be at the midpoint of the linked list.
// t: O(n)
// s: O(1)
fun detectLinkedListMiddleItem(head: ListNode<Int>):ListNode<Int>?{
    // slow ptr start at head, fast ptr at 2nd node
    // while loop until fast or fast.next null: 
    // return slow 
    if (head == null) return null
    var slow: ListNode<Int>? = head
    var fast: ListNode<Int>? = head
    
    while(fast != null && fast?.next != null){
        slow = slow?.next
        fast = fast?.next?.next
    } 
    return slow  
}

// detect midpoint, 2nd in case of even nodes linked list
// t: O(n)
// s: O(1)
fun detectLinkedListMiddleItem_2nd(head: ListNode<Int>):ListNode<Int>?{
    // slow ptr start at head, fast ptr at 2nd node
    // while loop until fast or fast.next null: 
    // return slow 
    if (head == null) return null
    var slow: ListNode<Int>? = head
    var fast: ListNode<Int>? = head
    
    while(fast != null && fast?.next != null){
        slow = slow?.next
        fast = fast?.next?.next
    } 
    return slow  
}

// detect midpoint, 1st in case of even nodes linked list
// t: O(n)
// s: O(1)
fun detectLinkedListMiddleItem_1st(head: ListNode<Int>):ListNode<Int>?{
    // slow ptr start at head, fast ptr at 2nd node
    // while loop until fast or fast.next null: 
    // return slow 
    if (head == null) return null
    var slow: ListNode<Int>? = head
    var fast: ListNode<Int>? = head
    
    while(fast != null && fast?.next?.next != null){
        slow = slow?.next
        fast = fast?.next?.next
    } 
    return slow  
}


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

fun printLinkedList(msg: String = "", head: ListNode<Int>?){
    if (head == null) return println("[]")
    print(msg)
    var curr = head
    while(curr != null){
        print("${curr.value},")
        curr = curr.next
    }
    println()
}


fun printLinkedListAtPos(msg: String = "", head: ListNode<Int>?, tillPos: Int){
    if (head == null) return println("[]")
    print(msg)
    var count = 1
    var curr = head
    while(curr != null && count <= tillPos){
        print("${curr.value},")
        count++
        curr = curr.next
    }
    println()
}


/*
Original list: 1,2,3,4,5,6,7,8,9,10,
Print at pos 7: 1,2,3,4,5,6,7,
list_01 has loop? false

Print looped list at pos 7: 1,2,3,4,5,6,7,8,9,10,3,4,5,6,7,8,9,
list_01 now has loop? true

Original list: 1,2,3,4,5,6,7,8,9,10,
list_02 has loop? false

Print perfect looped list at pos 15: 1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,
list_02 now has loop? true

Original list: 1,2,3,4,5,6,7,8,9,10,11,
Midnode for odd list : 6

Original list: 1,2,3,4,5,6,7,8,9,10,
Midnode for even list (2nd from left) : 6

Midnode for even list (1st from left) : 5
*/
