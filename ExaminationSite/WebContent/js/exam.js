var minutes = 1; 
var seconds = 0;
var timer;

function startTimer() {
    timer = setInterval(updateTimer, 1000); 
}

function updateTimer() {
    var timerDisplay = document.getElementById("timer");

    if (minutes == 0 && seconds == 0) {
        clearInterval(timer);
        document.getElementById("examForm").submit();
        alert("Time's up! Your exam has been submitted.");
    } else {
        if (seconds == 0) {
            minutes--;
            seconds = 59;
        } else {
            seconds--;
        }
        timerDisplay.innerHTML = minutes.toString().padStart(2, "0") + ":" + seconds.toString().padStart(2, "0");
    }
}

window.onload = startTimer;