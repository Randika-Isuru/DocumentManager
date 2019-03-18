package org.creative.document.entity

import java.util.UUID

import org.creative.document.entity.QueryType.QueryType

case class CustomerSearchCriteria(customerId: UUID,
                                  customerName: String,
                                  customerAddress: String,
                                  vatNo: String,
                                  taxNo: String,
                                  country: String,
                                  countryCode: String,
                                  queryType: QueryType)
