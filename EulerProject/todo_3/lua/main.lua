local function isPrime(n)

	if n<0 then return false end
	if n == 2 then return true end

	local m = math.sqrt(n)
    print("Num sqrt : "..m)

	local i = 3
	while i < m do
       if n%i == 0 then
	      print("Number " ..n.." is Not prime , first divisor : "..i)
		  return false
	   end
	   i = i + 2
	end
	return true
end


local  function main(num)
   print("The  number  is prime ? "..tostring(isPrime(num)))
end



main(600851475143)
