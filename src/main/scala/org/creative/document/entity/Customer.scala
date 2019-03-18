package org.creative.document.entity

import java.util.UUID

case class Customer (  customerId: UUID,
                       customerName: String,
                       customerAddress: String,
                       vatNo: String,
                       taxNo: String,
                       country: String,
                       countryCode: String)