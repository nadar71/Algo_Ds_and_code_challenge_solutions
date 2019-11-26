



local n = -9
local square = n
local i = n

--[[
if (math.ceil(n)-n) >0 and (math.ceil(n)-n) < 1 then     -- floating point number
   square = square/(1/square)
else                             -- integer
 while i > 1 do
   square = square -(-n)
   i = i - 1
 end
end
]]


-- or, easely, as below. Is good for negative number too
if ( square ~= 0)   then
   square = square/(1/square)
else
   square = 0
end


print(square)
