package org.creative.document.model

import java.util.UUID

import com.outworkers.phantom.dsl._
import org.creative.document.entity.Customer

import scala.concurrent.Future

abstract class Customers extends CassandraTable[Customers, Customer] with RootConnector{

  object customerid extends UUIDColumn(this) with PartitionKey
  object customername extends StringColumn(this)
  object customeraddress extends StringColumn(this)
  object vatno extends StringColumn(this)
  object taxno extends StringColumn(this)
  object country extends StringColumn(this)
  object countrycode extends StringColumn(this)

  def store(customer: Customer): Future[ResultSet] = {
    insert.value(_.customerid, customer.customerId)
      .value(_.customername, customer.customerName)
      .value(_.customeraddress, customer.customerAddress)
      .value(_.vatno, customer.vatNo)
      .value(_.taxno, customer.taxNo)
      .value(_.country, customer.country)
      .value(_.countrycode, customer.countryCode)
      .future()
  }

  def getById(id: UUID): Future[Option[Customer]] = {
    select.where(_.customerid eqs id).one()
  }

  def getLimit(limit: Int): Future[ResultSet] = {
    select.limit(limit).future()
  }


}
