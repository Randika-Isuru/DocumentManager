package org.creative.document.entity

object QueryType extends Enumeration {

  type QueryType = Value

  val NATIVE      = Value("Native")//cql make all enumerations capital
  val ELASTICSEARCH  = Value("Elasticsearch")
  val PHANTOM       = Value("Phantom")

}
