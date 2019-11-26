
local total = 0
for i=1,999 do
  if i%3 == 0  or i%5==0 then total = total + i end
end
print(total)
