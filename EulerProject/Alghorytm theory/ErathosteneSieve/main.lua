--[[

public boolean[] sieve(int n)
{
   boolean[] prime=new boolean[n+1];
   Arrays.fill(prime,true);
   prime[0]=false;
   prime[1]=false;
   int m=Math.sqrt(n);

   for (int i=2; i<=m; i++)
      if (prime[i])
         for (int k=i*i; k<=n; k+=i)
            prime[k]=false;

   return prime;
}

]]


-- 600851475143


local prime = {}
local function sieve(n)
  prime[1] = false
  for i=1,n do
      prime[#prime+1] = true
  end

  local m = math.sqrt(n)

  for j=2,m do
      if prime[j] then
	     for w=j*j,n,j do
		     prime[w] = false
		 end
	  end

  end

  print(#prime)
  return prime
end


sieve(600851475143)



