package org.creative.document.entity

object QueryType extends Enumeration {

  type QueryType = Value

  val Native      = Value("Native")//cql make all enumerations capital
  val Elasticsearch  = Value("Elasticsearch")
  val Phantom       = Value("Phantom")

}
