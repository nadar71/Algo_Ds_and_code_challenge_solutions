local num=1254687971


local i=1

local tStart = os.time()
local divisors = {}
while i <=  math.sqrt(num) do
  if (num%i)==0 then
     print("Divisor : "..i)
	 print("Divisor : "..num/i)
	 divisors[#divisors + 1] = i
	 divisors[#divisors + 1] = num/i
  end
  i = i + 1
end
local tEnd = os.time()
print("Time : "..(tEnd - tStart))
print("Number of divisors : "..#divisors)

