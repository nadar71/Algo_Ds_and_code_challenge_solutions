


local function isPrime(n)
  if n<=1  or n%2 == 0  then return false end

  if n==2               then return true end

  local m = math.sqrt(n)

  for  i=3,m,2 do
    if n%i then return false end
  end

  return true
end



print(tostring(isPrime(5)))
