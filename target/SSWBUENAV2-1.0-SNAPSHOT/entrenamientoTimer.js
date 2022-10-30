/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function countdown(duration){
    var totalTime = duration;
    var time = totalTime;
    updateTime(time,totalTime);
    var played = false;
    var x = setInterval(function(){
        if(time > 0){
            time-=1;
            updateTime(time,totalTime);
        }
        if(time<1){
            if(!played){
                played = true;
                var audio = new Audio('./audio/finish.mp3');
                audio.play();
            }
        }
    }, 1000);
}
    
function updateTime(time,totalTime){
    var mm = Math.floor(time/60);
    var ss = time%60;
    if(mm < 10) mm = "0"+mm;
    if(ss < 10) ss = "0"+ss;
    document.getElementById("time").innerHTML = mm+":"+ss;
    var pBar = document.getElementById("progressBar");
    pBar.setAttribute("style","width:"+((totalTime-time)/totalTime*100)+"%;");
}

