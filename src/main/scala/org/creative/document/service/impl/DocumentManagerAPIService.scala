package org.creative.document.service

import java.util.UUID

import org.creative.document.entity.QueryType.QueryType
import org.creative.document.entity.{Customer, Document, DocumentSearchCriteria}

trait DocumentManagerAPIService {

  def createDocument(document: Document, queryType: QueryType): Unit

  def searchDocuments(searchCriteria: DocumentSearchCriteria): Seq[Document]

  def createCustomer(customer: Customer, queryType: QueryType): Unit

  def searchCustomers(customerId: UUID, queryType: QueryType): Unit

}