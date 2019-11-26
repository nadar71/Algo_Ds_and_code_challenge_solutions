
-- too much time
local function isPrime(n)

	if n<0 then return false end
	if n == 2 then return true end

	local m = math.sqrt(n)
    print("Num sqrt : "..m)

	local i = math.ceil(m)
	print("Rounded : "..i)
	local maxFactor = 0
	while i < n do
       if n%i == 0 then
	      print("Analyzing factor : "..i)
		  if i > maxFactor then maxFactor = i end
	   end
	   i = i + 2
	end

	return maxFactor
end


local  function main(num)
   print("The maxFactor of number "..num.." is  "..tostring(isPrime(num)))
end



main(600851475143)
