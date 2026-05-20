


class  Stack<T>(){
    val stack: ArrayList<T> = ArrayList<T>()
    
    fun push(value: T){
        stack.add(value) // added at the end
    }

    fun pop(): T?{
        if (isEmpty()) return null
        val last = stack.size-1
        val item = stack.get(last)
        stack.removeAt(last)
        return item
    }

    fun peek(): T?{
        if (isEmpty()) return null
        val last = stack.size-1
		return stack.get(last)
    }
    
    fun isEmpty(): Boolean{
        if (stack.isEmpty()) {
            println("Stack empty")
            return true
        }
        return false
    }
}


fun main() {
    var item: Int?

    val stack_01 = Stack<Int>()
    item = stack_01.pop()
    
    stack_01.push(1)
    item = stack_01.peek()
    println("peek: $item")

    
    stack_01.push(2)
    item = stack_01.peek()
    println("peek: $item")

    stack_01.push(3)
    item = stack_01.peek()
    println("peek: $item")

    item = stack_01.pop()
    println("pop: $item")


    stack_01.push(5)
    item = stack_01.peek()
    println("peek: $item")


    item = stack_01.pop()
    println("pop: $item")
       
}