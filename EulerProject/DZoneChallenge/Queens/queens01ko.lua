


--[[
NOTES:

Diagonal neighbours of an element , array nxm:

    aij : 1: a(i-1)(j-1)   ....a(1)(1)
          2: a(i-1)(j+1)   ....a(1)(m)
          3: a(i+1)(j-1)   ....a(n)(1)
          4: a(i+1)(j+1)   ....a(n)(m)


DATA STRUCTURE
chess array mxn : used to set the position of each queen (unnecessary, could be eliminated if needs)
queen array 8x2 : used to store the queens' coordinates  for rapid access ;
                  coordinates are in row, column starting from top left side of the chess array, (1,1)
				  a non positioned queens have coords : (0,0)

ALGHORYTM:
1 set the queen in row in in position im , starting from row 1 position 1
2 check collision
  2.1 check vertical/horizontal collision : scan queen array for queen with the same column , or same row
  2.2 check oblique collision :
       scan queen array for queen with the  column - 1..column - i : (i >0), column + 1..column + i : (i >= m)
       scan queen array for queen with the  row - 1..row - i : (i >0), row + 1..row + i : (i >= n)
  2.3 if collision 2.1 and collision 2.2 false, then pass to new queens
	  else repeat  from point 1 , left row in and only incrementing im + 1 :
	       if im >= m , then decrement in - 1 , set there im + 1 , and search a new position

]]

local queens = {
				{m=0,n=1,ok=false},
				{m=0,n=2,ok=false},
				{m=0,n=3,ok=false},
				{m=0,n=4,ok=false},
				{m=0,n=5,ok=false},
				{m=0,n=6,ok=false},
				{m=0,n=7,ok=false},
				{m=0,n=8,ok=false},
                }

local chessboard={
                  {0,0,0,0,0,0,0,0},
                  {0,0,0,0,0,0,0,0},
                  {0,0,0,0,0,0,0,0},
                  {0,0,0,0,0,0,0,0},
                  {0,0,0,0,0,0,0,0},
                  {0,0,0,0,0,0,0,0},
                  {0,0,0,0,0,0,0,0},
                  {0,0,0,0,0,0,0,0},
				 }
local n = #chessboard           -- rows
local m = #chessboard[1]        -- columns

local boardRowsStatus={false,false,false,false,false,false,false,false}   -- true if row host a  queen in correct position



-- stampa scacchiera
local function printChessBoard(chessboard)
  for i=1,#chessboard do
	for j=1,#chessboard[i] do
	    io.write(chessboard[i][j].."  ")
	end
	print("\n")
  end
end

printChessBoard(chessboard)


--[[ controllo collisione obliqua
local function obliqueColl(x,y,chessboard)

  -- 1: a(i-1)(j-1)   ....a(1)(1)
  -- 2: a(i-1)(j+1)   ....a(1)(m)
  for i=x,1,-1 do
      for j=1,m do
	   if chessboard(i,j) == 1 then return false end
	  end
  end

  -- 3: a(i+1)(j-1)   ....a(n)(1)
  -- 4: a(i+1)(j+1)   ....a(n)(m)
  for i=x,n do
      for j=1,1,-1 do
	   if chessboard(i,j) == 1 then return false end
	  end
  end

  return true
end
]]





-- set a q in the 1st row
-- set 2nd queen in 2nd row
local done =  false
while not done do
  if queens[1].ok == false then
     if queens[1].m < m  then
	    queens[1].m  = queens[1].m + 1    -- try setting the 1st queen
		queens[1].ok = true               -- in position
	 end
  end

  if queens[2].ok == false then
     if queens[2].m < m  then
	    queens[2].m  = queens[2].m + 1

		local currentM = 2
		local currentN = 2
		local noCollision  = true          -- check for collision
		local scancomplete_left_top   = false
		local scancomplete_left_btom  = false

		local indx_l_t = 0
		local indx_l_b = 0




		while (scancomplete_left_top   == false) and
              (scancomplete_left_btom  == false)
		do

		    if scancomplete_left_top   == false then
			   if queens[1].m-1 > 0 and  queens[2].n-1 > 0 then
			      if queens[currentM - 1][currentN - 1]
			   end
			end

		end

		end
		if noCollision == true then queens[2].ok = true
		else

		end
	 end
  end





end -- end while not done do
