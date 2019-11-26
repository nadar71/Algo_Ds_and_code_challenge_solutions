

--[[
use the sqrt method
]]

local function isPrime(n)

	if n<0 then return false end
	if n == 2 then return true end

	local m = math.sqrt(n)

	local i = 3
	while i <= m do
       if n%i == 0 then
	      print("Number " ..n.." is Not prime , first divisor : "..i)
	      return false
	   end
	   i = i + 2
	end
	return true
end


local function maxPrimeDiv(greater,smaller)
   local m = math.sqrt(greater)
   local i = 2
   while i<=m do
      if greater%i==0 then
	     greater = greater / i
         if (isPrime(greater)) then
		    print("Find the maxprime div is :"..i)
			return i
		 else
		    print("Start from "..i.."Checking "..greater)
		    maxPrimeDiv(greater,smaller)
		 end
	  end
   end

end


local  function main(greater,smaller)
   local result = maxPrimeDiv(greater,smaller)
   print("The maxnumber  prime divisor of "..num.." is : "..tostring(result))
end


main(600851475143,1)  -- too big, doesn't work !
