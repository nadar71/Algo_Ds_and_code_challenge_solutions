
local first  = 0
local second = 1
local tmp    = 0
local sum    = 0


while true do
    tmp     = second
    second  = first + second
	first   = tmp
	if second >= 4000000 then break end
	if second%2==0 then sum = sum + second end
end

print(sum)
