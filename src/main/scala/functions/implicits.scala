package functions

import datatypes.{TestAlerts, TestQueryTerm}
import datatypes.implicits.{decodeTestAlerts, decodeTestQueryTerm}
import io.circe.parser.decode

object implicits {
  implicit class ListJsonDecoder(input: String) {
    def testAlertsAsList: List[TestAlerts] = decode[List[TestAlerts]](input) match {
      case Left(_) => List.empty
      case Right(value) => value
    }

    def testQueryTermsAsList: List[TestQueryTerm] = decode[List[TestQueryTerm]](input) match {
      case Left(_) => List.empty
      case Right(value) => value
    }
  }
}
