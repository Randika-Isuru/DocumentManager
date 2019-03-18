package org.creative.document.entity

import java.util.UUID

import org.joda.time.DateTime

case class Document(customerId: UUID,
                    documentId: UUID,
                    documentDate: DateTime,
                    deliveryDate: DateTime,
                    documentIdentifier: String,
                    totalPrice: Double,
                    vatAmount: Double,
                    taxAmount: Double,
                    sellerName: String,
                    buyerName: String,
                    senderName: String,
                    senderId: String,
                    receiverName: String,
                    receiverId: String)