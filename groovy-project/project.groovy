// project.groovy

@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.6')

import static groovyx.net.http.ContentType.TEXT

def host = 'http://api.openweathermap.org'
def path = 'data/2.5/weather'
def zipCodes = ['84062','81001','90210'] 
def apiKey = 'c07c1b72ab12ab07a08c159e2794df8a'
def units = 'imperial'

for (zipCode in zipCodes) {
    def httpRequest = "${host}/${path}?zip=${zipCode}&appid=${apiKey}&units=${units}"
    def client = new groovyx.net.http.HTTPBuilder(httpRequest)
        client.setHeaders(Accept: 'application/json')
    def json = client.get(contentType: TEXT)
    def response = new groovy.json.JsonSlurper().parse(json) 
    
    println ''
    println 'City:      ' + response.name
    println 'Temp(F):   ' + response.main.temp
    println ''
}