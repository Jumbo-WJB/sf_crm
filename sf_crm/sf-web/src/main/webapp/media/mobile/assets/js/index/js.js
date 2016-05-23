// JavaScript Document




var curPane="tip1";
var fstRun = 0;
/*function show(switchSysBar)
{
if(fstRun==1)
{
if(switchSysBar==curPane){return;}
}
document.getElementById(curPane).style.display="none";
document.getElementById(switchSysBar).style.display="block";
fstRun==1;
curPane=switchSysBar;
}*/

function show(switchSysBar)
{
if(document.getElementById(switchSysBar).style.display=="block")
document.getElementById(switchSysBar).style.display = "none"; 
else
document.getElementById(switchSysBar).style.display = "block";
}