@Grapes( @Grab('org.ccil.cowan.tagsoup:tagsoup:1.2') )
def url = "http://www.electricityinfo.co.nz/comitFta/ftapage.main"
def PARSER = new XmlSlurper(new org.ccil.cowan.tagsoup.Parser())  // tags soup provides a parser relaxed enough to parse html (i.e. not strict xml)
new URL(url).withReader ("UTF-8") { reader ->
  def document = PARSER.parse(reader)
  document.'**'.find{ it['@class'] == 'price hay2201'}.each { println it.text() }
}
