package org.creative.document.dao.impl

import com.outworkers.phantom.connectors.{CassandraConnection, ContactPoints}
import com.typesafe.config.ConfigFactory

import scala.collection.JavaConverters._

object PhantomConnectorExample {

  /*val default: CassandraConnection = ContactPoint.local
    .withClusterBuilder(_.withSocketOptions(
      new SocketOptions()
        .setConnectTimeoutMillis(20000)
        .setReadTimeoutMillis(20000)
      )
    ).noHeartbeat().keySpace(
    KeySpace("createdocument").ifNotExists().`with`(
      replication eqs SimpleStrategy.replication_factor(1)
    )
  )*/

  private val config = ConfigFactory.load()

  private val hosts = config.getStringList("cassandra.host").asScala
  private val keyspace = config.getString("cassandra.keyspace")


  lazy val connector: CassandraConnection = ContactPoints(hosts).keySpace(keyspace)

}
