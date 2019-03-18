package org.creative.document.database

import com.datastax.driver.core.Cluster

object DBConnection {

  val port: Int = 9042
  val host: String = "127.0.0.1"

  def getConnection():Cluster={
    new Cluster.Builder().addContactPoint(host).withPort(port).build()
  }

}
