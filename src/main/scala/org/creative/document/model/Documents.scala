package org.creative.document.model

import java.util.UUID

import com.outworkers.phantom.dsl._
import org.creative.document.entity.Document

import scala.concurrent.Future

abstract class Documents extends CassandraTable[Documents, Document] with RootConnector{

  object customerid extends UUIDColumn(this) with PartitionKey
  object documentid extends UUIDColumn(this) with ClusteringOrder
  object documentdate extends DateTimeColumn(this)
  object deliverydate extends DateTimeColumn(this)
  object documentidentifier extends StringColumn(this)
  object totalprice extends DoubleColumn(this)
  object vatamount extends DoubleColumn(this)
  object taxamount extends DoubleColumn(this)
  object sellername extends StringColumn(this)
  object buyername extends StringColumn(this)
  object sendername extends StringColumn(this)
  object senderid extends StringColumn(this)
  object receivername extends StringColumn(this)
  object receiverid extends StringColumn(this)


  def store(document: Document): Future[ResultSet] = {
    insert.value(_.customerid, document.customerId)
      .value(_.documentid, document.documentId)
      .value(_.documentdate, document.documentDate)
      .value(_.deliverydate, document.deliveryDate)
      .value(_.documentidentifier, document.documentIdentifier)
      .value(_.totalprice, document.totalPrice)
      .value(_.vatamount, document.vatAmount)
      .value(_.taxamount, document.taxAmount)
      .value(_.sellername, document.sellerName)
      .value(_.buyername, document.buyerName)
      .value(_.sendername, document.senderName)
      .value(_.senderid, document.senderId)
      .value(_.receivername, document.receiverName)
      .value(_.receiverid, document.receiverId)
      .future()
  }

  def getByCustomerId(customerId: UUID): Future[Option[Document]] = {
    select.where(_.customerid eqs customerId).one()
  }

  def getByDocumentId(documentId: UUID): Future[Option[Document]] = {
    select.where(_.documentid eqs documentId).one()
  }

  def getLimit(limit: Int): Future[ResultSet] = {
    select.limit(limit).future()
  }

    
}
