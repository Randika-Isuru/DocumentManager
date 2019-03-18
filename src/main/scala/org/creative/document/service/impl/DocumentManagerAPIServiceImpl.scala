package org.creative.document.service.impl

import java.util.UUID

import com.outworkers.phantom.connectors.KeySpace
import org.creative.document.dao.impl.{CustomerDaoImpl, DocumentDaoImpl}
import org.creative.document.database.phantomDBConnection
import org.creative.document.entity.QueryType.QueryType
import org.creative.document.entity.{Customer, Document, DocumentSearchCriteria, QueryType}
import org.creative.document.service.DocumentManagerAPIService

import scala.concurrent.ExecutionContext


class DocumentManagerAPIServiceImpl extends DocumentManagerAPIService {

  implicit val ex = ExecutionContext.Implicits.global
  implicit val session = phantomDBConnection.session
  implicit val keySpace = KeySpace(phantomDBConnection.keyspace.name)

  def createDocument(document: Document, queryType: QueryType): Unit = {

    if(queryType.equals(QueryType.Native)){
      DocumentDaoImpl.createDocument(document)
    }else if(queryType.equals(QueryType.Elasticsearch)){

    }else{
      phantomDBConnection.create()
      phantomDBConnection.document.store(document)
    }
  }

  def searchDocuments(searchCriteria: DocumentSearchCriteria): Seq[Document] = {
    val queryType = searchCriteria.queryType
    if(queryType.equals(QueryType.Native)){

    }else if(queryType.equals(QueryType.Elasticsearch)){

    }else{
      phantomDBConnection.create()
      phantomDBConnection.document.getByCustomerId(customerId)
    }
  }

  def createCustomer(customer: Customer, queryType: QueryType): Unit = {

    if(queryType.equals(QueryType.Native)){
      CustomerDaoImpl.createCustomer(customer)
    }else if(queryType.equals(QueryType.Elasticsearch)){

    }else{
      phantomDBConnection.create()
      phantomDBConnection.customer.store(customer)
    }
  }

  def searchCustomerByCustomerId(customerId: UUID, queryType: QueryType): Unit = {
    if(queryType.equals(QueryType.Native)){
      //CustomerDaoImpl.createCustomer(customer)
    }else if(queryType.equals(QueryType.Elasticsearch)){

    }else{
      phantomDBConnection.create()
      phantomDBConnection.customer.getById(customerId)
    }
  }

}