
-- For huge number (ex. : 123456789) it goes out of memory



local digits = {}

local number

local limit

print("Do you want to check if a number is an armstrong number (1) or check all the number till a  limit (2)?")

local input = io.read()



local start

if input=="2" then

  print("Insert the limit : ")
  limit = io.read()
  start = os.time()

  for i=1,limit do
    local i_s = tostring(i)
    local length  = tonumber((i_s):len())  -- length of current number
	local sum = 0
	for j=1,length do                          -- get the single digit
	    digits[#digits+1] = i_s:sub(j,j)
		sum = sum + math.pow(digits[#digits],length)
	    -- print(" j: "..j.." digit : "..digits[#digits])
	end
	-- print(" i : "..i.." Sum :  "..sum)
	if i == sum then
	   print("The number "..i.." is an Armstrong number.")
	end
  end

elseif input == "1" then

    print("Insert the number : ")
    number = io.read()
    start = os.time()


    local length  = tonumber((number):len())  -- length of current number
	local sum = 0
	for j=1,length do                          -- get the single digit
	    digits[#digits+1] = number:sub(j,j)
		sum = sum + math.pow(digits[#digits],length)
	    -- print(" j: "..j.." digit : "..digits[#digits])
	end
	-- print(" i : "..i.." Sum :  "..sum)
	if tonumber((number)) == sum then
	   print("The number "..number.." IS an Armstrong number.")
	else print("The number "..number.." IS NOT an Armstrong number.")
	end

end

local endTime = os.time()

print(" Start : "..start.." End : "..endTime.." Duration : "..(endTime-start))


