class Solution {
    fun addTwoNumbers(list1: ListNode?, list2: ListNode?): ListNode? {
        var remainder = 0
        var longerList:ListNode? = null
        var shorterList:ListNode? = null
        var resultHead: ListNode? = null


        if (list1 == null) return list2
        else if (list2 == null) return list1
        else if (list1.size() >= list2.size()) {
            longerList = list1
            shorterList = list2
        } else if (list1.size() < list2.size()){
            longerList = list2
            shorterList = list1
        }


        var shorterPtr: ListNode? = shorterList
        var longerPtr: ListNode?  = longerList

        while(shorterPtr != null){
            var parzRes = shorterPtr.`val` + longerPtr!!.`val` + remainder
            remainder = 0
            if (parzRes >= 10) {
                parzRes = parzRes - 10
                remainder = 1
            }

            val newResItem = ListNode(parzRes)

            if (resultHead == null) {
                resultHead = newResItem
            } else {
                resultHead.appendItem(newResItem)
            }
            // resultHead.printList("resultHead")

            if (shorterPtr.next != null) {
                shorterPtr = shorterPtr.next
                longerPtr = longerPtr.next
            }
            else {
                longerPtr = longerPtr.next
                break
            }

        }

        // set the remainder part for longerList
        while(longerPtr != null){
            var parzRes = longerPtr.`val` + remainder
            remainder = 0
            if (parzRes >= 10) {
                parzRes = parzRes - 10
                remainder = 1
            }
            val newItem = ListNode(parzRes)
            resultHead.appendItem(newItem)
            longerPtr = longerPtr.next
            
        }
        
        // in case of last digit was >= 10
        if (remainder > 0){
                val newItem = ListNode(remainder)
                resultHead.appendItem(newItem)
            }
        return resultHead
    }
    
    
}


fun ListNode.size(): Int{
    var count = 0

    var tmpList = this

    while(tmpList.next != null){
        tmpList = tmpList.next!!
        count++
    }

    return count
}


fun ListNode.printList(name: String) {
    println("Stampa lista : $name")
    if (this != null) {println(this.`val`) } // 1st element

    var ptr = this
    while(ptr.next != null){
        println(ptr.next?.`val`)
        ptr = ptr.next!!
    }
}


fun ListNode?.appendItem( newNode: ListNode? ){
    var varHeader = this

    if (varHeader == null){
        varHeader = newNode!!
        return
    }


    while(varHeader!!.next != null){
        varHeader = varHeader.next!!
    }

    varHeader.next = newNode
}