package com.groovyexamples.json


import groovy.json.JsonSlurper


def jsonText = "https://restcountries.eu/rest/v2/region/europe?fields=name;capital;currencies;population".toURL().text

JsonSlurper slurper = new JsonSlurper()
String[] jsonResult = slurper.parseText(jsonText)

jsonResult.each { println it }





