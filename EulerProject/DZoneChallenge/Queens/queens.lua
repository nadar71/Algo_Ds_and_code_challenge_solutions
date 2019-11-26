


--[[
NOTES:

Diagonal neighbours of an element , array nxm:

    aij : 1: a(i-1)(j-1)   ....a(1)(1)
          2: a(i-1)(j+1)   ....a(1)(m)
          3: a(i+1)(j-1)   ....a(n)(1)
          4: a(i+1)(j+1)   ....a(n)(m)


DATA STRUCTURE
chess array mxn : used to set the position of each queen (unnecessary, could be eliminated if needs)


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



local rowNum = #chessboard           -- rows
local colNum = #chessboard[1]        -- columns

local boardRowsStatus={false,false,false,false,false,false,false,false}   -- true if row host a  queen in correct position



-- stampa scacchiera
local function printChessBoard(chessboard)
  for r=1,#chessboard do
	for c=1,#chessboard[r] do
	    io.write(chessboard[r][c].."  ")
	end
	print("\n")
  end
end

-- TODO : WRITE SOLUTIONS ON A FILE


-- reset chess board
local function printChessBoard(chessboard)
  for r=1,#chessboard do
	for c=1,#chessboard[r] do
	    chessboard[r][c] = 0
	end
  end
end



-- put a queen in the chessboard
local function setQueen(r,c)
  chessboard[r][c] = 1
end



-- get queen position
local function getQueenPosition(r)
   for i=1,#chessboard[r] do
       if chessboard[r][i] == 1 then
	      return i
	   else
		  return -1
	   end
   end
end




-- check collision with other queens in position upper left/right
local function checkCollision(chessboard,r,c)
  local collisionFlag = false
  local endCheckLeft  = false
  local endCheckRight = false

  while endCheckLeft do
    r = r - 1; c = c - 1;               -- select the upper left previous position
    if r>0 and c>0 then
	   if chessboard[r][c] == 1 then    -- if there are already a queen, break and return
	      collisionFlag = true
		  break
	   end
	else
	   endCheckLeft = true              -- search ended, no queen in this diagonal
	end
  end

  while endCheckRight do
    r = r + 1; c = c + 1;               -- select the upper right next position
    if r>0 and c>0 then
	   if chessboard[r][c] == 1 then    -- if there are already a queen, break and return
	      collisionFlag = true
		  break
	   end
	else
	   endCheckLeft = true              -- search ended, no queen in this diagonal
	end
  end

  return collisionFlag
end







-- set 1st try
chessboard[1][1] = 1
queens[1] = 1

-- start iteration
local done      = false
local queens    = {0,0,0,0,0,0,0,0}
-- local queensCol = {1,0,0,0,0,0,0,0}
local pos    = 0
local hasSolution = false

while not done do

  -------------------------------- row 1
  pos = getQueenPosition(1)          -- TODO : eliminate this func, mem the position and increment it, using queensCol
  if queens[1] == 0 then             -- queen not set, then set (queens 1 avoid 1st iteration , is already positioned)
     if  pos >= rowNum then
	     print("No solutions ! ")
	     done =  true;
	 else
	     chessboard[1][pos] = 0
	     chessboard[1][pos+1] = 1
	 end
  end


  -------------------------------- row 2
  pos = getQueenPosition(2)          -- TODO : eliminate this func, mem the position and increment it, using queensCol
  if queens[2] == 0 then             -- queen not set, then set
	 local positioningOK = false
     if  pos >= rowNum then
	     queens[1] == 0              -- end of row reached, re-position the previous queen
	 else
	    local endTry = false

	    while not endTry do          --
		    pos = pos + 1            -- couldn'be the limit, already checked in previous if
	        chessboard[2][pos] = 1
		    if checkCollision(chessboard,2,pos) == false then     -- collision
			   chessboard[2][pos] = 0
			   endTry = true
			   positioningOK = true
			else

			end
		end



	 end
  end

  -- ......
  -- ......

  -- end of an iteration
  print("Done? "..done)
  printChessBoard(chessboard)
end -- end while not done do


print("This is the final configuration of the solution : ")
printChessBoard(chessboard)

