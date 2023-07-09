import functions.implicits._
import better.files._
import datatypes.{TestAlerts, TestQueryTerm}
import functions.{testAlerts, testQueryTerm}

object prewaveChallenge {
  def query(queryTerms: List[TestQueryTerm], alerts: List[TestAlerts]): List[(String, List[Int])] = alerts
    .map { alert =>
      val ids = alert.contents.flatMap { content =>
        queryTerms.filter { term =>
          if (term.keepOrder) content.text.contains(term)
          else term.text.split(" ").map(content.text.contains).reduce(_ & _)
        }
      }.map(_.id)

      (alert.id, ids)
    }

  def main(args: Array[String]): Unit = {
    val key = "ali:92b2ccb1365a2ee85edd3eb76fb576835d3d3460458b6c98a3543b335fee0cf0"

    val queryTerms: List[TestQueryTerm] = new testQueryTerm(key).get.body match {
      case Left(_) => List.empty
      case Right(value) => value.testQueryTermsAsList
    }

    (1 to 100).foreach { x =>
      val alerts: List[TestAlerts] = new testAlerts(key).get.body match {
        case Left(_) => List.empty
        case Right(value) => value.testAlertsAsList
      }

      println(query(queryTerms, alerts)) // printing final answer here
    }
  }
}
