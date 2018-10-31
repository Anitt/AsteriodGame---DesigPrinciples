# AsteriodGame---DesigPrinciples
This project is small Game which is purely developed using different design patterns in JAVA , the requirement of the game is given in ReadME

This Project is developed end to end with following design pattern module wise,

![alt text](https://github.com/Anitt/AsteriodGame---DesigPrinciples/blob/master/Pattern1.PNG)
![alt text](https://github.com/Anitt/AsteriodGame---DesigPrinciples/blob/master/Pattern2.PNG)

The  main  program  takes  as  input  a  text  file  name.    In  the  text  file  are  commands  for  the  game   to  execute.    There  is  one  command  on  each  line  in  the  file.    You  do  not  need  to  parse  the  file,   that  work  is  already  done.    You  do  need  to  add  to  the  factory  though  to  make  some  new   commands  that  you  need  to  support.     Commands  can  have  arguments,  arguments  are  separated  from  the  command  by  spaces,  you   don’t  need  to  parse  those  either,  they  will  be  passed  to  any  new  Command  objects  you   create  assuming  you  connect  them  to  the  factory  properly.     The  syntax  for  commands  is  as  follows  (arguments  are  defined  in  <>’s  but  <>’s  do  not  appear  in   the  file):     INIT  <width  of  game  board>  <height  of  game  board>   -­‐   Sets  up  the  game  board  to  be  <width>  Squares  across,  <height>  high.    Width  is  the  X   axis,  height  is  the  Y  axis.     SPAWN_BUILDING  <X  index>  <Y  index>   -­‐   Creates  a  Building  component  and  adds  it  to  the  Square  composite  at  position  X,Y  on   the  board.     SPAWN_ASTEROID  <X  index>  <Y  index>  <height>  
-­‐   Creates  an  asteroid  component  and  adds  it  to  the  Square  composite  at  position  X,Y  on   the  board  with  the  given  initial  height.  
   SPAWN_SHIELD  <X  index>  <Y  index>   -­‐   Creates  a  shield  Decorator,  and  attempts  to  decorate  the  Square  object  at  position  X,Y   (if  there  is  one  there).     START_GAME   -­‐   Changes  the  game  state  to  GameState,  meaning  the  game  is  over  when  the  building   count  hits  0.     TICK  <Number  of  ticks  to  execute>   -­‐   Executes  one  turn  of  the  game,  causing  Asteroids  to  fall  one  level  and  potentially  impact   their  Square.    When  impact  happens  all  buildings  /  shields  are  reduced  in  health.    
  
Logic and Requirements:

1.SPAWN_BUILDING CLASS AND SPAWN ASTERIOD CLASS work on the same logic and principle - Both has a Make command method in the factory and when Building  objects  are  created  the  GameBoard.IncrementBuildingCount()  is called to increment the count.

2.SPAWN_SHEILD

* Shield  class  that  has  2  health.
*Decorator  pattern  is used  to  decorate  Square  objects  with  the   Shield  class  (replace  them  in  the  composite  hierarchy  in  their  grid  position  with   your  decorator  object).   
 *When  the  Shield’s  health  drops  to  0  it  should  no  longer  decorate  its  Square.  The   Square  should  be  returned  to  its  position  in  the  composite  hierarchy.  
 * When  Shields  are  decorating  Squares,  asteroid  impacts  in  that  Square  do  not   hurt  the  buildings  in  the  Square,  the  Shield  blocks  the  Asteroid  while  its  health   lasts.
 *SpawnShieldCommand  class is attached to  the  MakeCommand  method  in   the  factory.    This  should  do  the  work  of  decorating  the  correct  Square  object   with  the  Shield  decorator.
 
 #Observer design pattern
 
 * Defined  a  subject  interface  that  BoardComponent  objects  can  attach  themselves   to
 * Defined  a  concrete  subject  class  for  Asteroid  impacts.
 * An  instance  of  the  concrete  subject  class  somewhere  that  all  members  of  the   board  composite  hierarchy  can  get  to  so  they  can  attach  themselves  to  the   subject  and  get  updated  when  the  subject  object  is  notified  of  an  asteroid   impact. 
 * Implemented  the  Update()  in  the  Building  class  and  Shield  classes  so  they  take  1   point  of  damage  if  they  are  impacted  by  an  asteroid.    If  a  Shield  hits  0  health  it  is   removed  as  a  decorator  from  the  Square  object  it  is  decorating.    If  a  Building  hits   0  health  it  is  destroyed,  and  removed  from  its  parent  Square  object.    Make  sure   you  call  GameBoard.DecrementBuildingCount()  when  this  happens.
 
