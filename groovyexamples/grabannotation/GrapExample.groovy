package com.groovyexamples.grabannotation



@Grab(group="org.apache.commons", module="commons-lang3", version= "3.4")


import org.apache.commons.lang3.text.WordUtils

WordUtils utils = new WordUtils()

def name = "Carlos Eduardo Souza Santiago"

println utils.initials(name)

