package org.creative.document.dao.impl

import com.datastax.driver.core.{Cluster, Session}
import org.creative.document.database.DBConnection
import org.creative.document.entity.Customer

object CustomerDaoImpl {

  def createCustomer(customer: Customer): Unit={
    val cluster: Cluster = DBConnection.getConnection()
    val session: Session = cluster.connect()

    val createCustomerCQL = "INSERT INTO documentmanager.customers (customerid, customername, customeraddress, vatno, taxno, country, countrycode) " +
      "VALUES ("+customer.customerId+", '"+customer.customerName+"', '"+customer.customerAddress+"','"+customer.vatNo+"', '"+customer.taxNo+"', '"+customer.country+"', '"+customer.countryCode+"');"

    session.execute(createCustomerCQL)
    cluster.close()
    session.close()
  }

}
