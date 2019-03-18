package org.creative.document.dao.impl

import java.util.UUID

import com.datastax.driver.core.{Cluster, LocalDate, Session}
import org.creative.document.database.DBConnection
import org.creative.document.entity.Document

object DocumentDaoImpl {

  def createDocument(document: Document): Unit = {

    val cluster: Cluster = DBConnection.getConnection()

    implicit val session: Session = cluster.connect()

    val insertDocumentCql = "INSERT INTO creativedocument.document(customer_id, document_id, document_date, delivery_date, document_identifier, total_price, vat_amount, tax_amount, seller_name, buyer_name, sender_name, sender_id, receiver_name, receiver_id) " +
      "VALUES ("+document.customerId+", "+document.documentId+", '"+document.documentDate+"', '"+document.deliveryDate+"', '"+document.documentIdentifier+"', "+document.totalPrice+","+document.vatAmount+","+document.taxAmount+",'"+document.sellerName+"','"+document.buyerName+"','"+document.senderName+"','"+document.senderId+"','"+document.receiverName+"','"+document.receiverId+"');"

    session.execute(insertDocumentCql)

    cluster.close()
    session.close()

  }

  /*def searchDocumentByDocumentId(documentId: UUID): List[Document] = {

    val cluster: Cluster = CreateDBConnection.getConnection()

    implicit val session: Session = cluster.connect()

    val selectDocument = "SELECT * FROM creativedocument.document WHERE document_id = "+documentId+";"


    session.execute(selectDocument).all()

    cluster.close()
    session.close()

  }*/

}
