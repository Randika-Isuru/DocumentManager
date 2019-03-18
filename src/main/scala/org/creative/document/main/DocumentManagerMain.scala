package org.creative.document.main

import java.util.UUID
import java.util.UUID.randomUUID

import org.creative.document.entity.{Customer, Document, QueryType}
import org.creative.document.service.impl.DocumentManagerAPIServiceImpl
import org.joda.time.DateTime


object DocumentManagerMain {

  def main(args: Array[String]): Unit = {

    val customerId: UUID = randomUUID()
    val documentId: UUID = randomUUID()
    val documentDate: DateTime = new DateTime()
    val deliveryDate: DateTime = new DateTime()

    val customer =  Customer(customerId, "Randika", "11 6 Purana Vihara Road Colombo 06", "vat1234567", "tax1234567", "Sri lanka", "+94")

    val document = Document(customerId, documentId, documentDate, deliveryDate, "This is test", 1000, 200, 100, "Randika", "Isuru", "Vijayanga", "sen1234567", "chamindri", "rec1234567")


    new DocumentManagerAPIServiceImpl().createCustomer(customer, QueryType.Phantom)

    new DocumentManagerAPIServiceImpl().createDocument(document, QueryType.Phantom)

  }
}
