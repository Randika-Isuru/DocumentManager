package org.creative.document.entity

import java.util.UUID

import org.creative.document.entity.QueryType.QueryType
import org.joda.time.DateTime

case class DocumentSearchCriteria(customerId: UUID,
                                  documentId: UUID,
                                  documentFromDate: DateTime,
                                  documentToDate: DateTime,
                                  deliveryFromDate: DateTime,
                                  deliveryToDate: DateTime,
                                  documentIdentifier: String,
                                  totalPrice: Double,
                                  vatAmount: Double,
                                  taxAmount: Double,
                                  sellerName: String,
                                  buyerName: String,
                                  senderName: String,
                                  senderId: String,
                                  receiverName: String,
                                  receiverId: String,
                                  queryType: QueryType)