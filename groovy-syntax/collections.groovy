// collections.groovy

def professors = [
    "Dr. Merservy",
    "Dr. Dean",
    "Dr. Keith",
    "Dr. Liddle",
    "Dr. B. Anderson",
    "Dr. G. Anderson",
    "Dr. Allen",
    "Dr. Gaskin",
    "Dr. Vance"
]

for (professor in professors) {
    def greetingText = " is the best!"
    
    println "$professor" + "$greetingText"
}