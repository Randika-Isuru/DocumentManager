package org.creative.document.database

import com.outworkers.phantom.connectors.{CassandraConnection, ContactPoints}
import com.outworkers.phantom.dsl._
import org.creative.document.model.{Customers, Documents}

object Defaults {
  val connector = ContactPoints(Seq("localhost")).keySpace("documentmanager")
}

class PhantomDBConnection(val keyspace: CassandraConnection) extends Database[PhantomDBConnection](keyspace) {
  object customer extends Customers with Connector
  object document extends Documents with Connector
}

object phantomDBConnection extends PhantomDBConnection(Defaults.connector)