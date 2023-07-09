package functions

import sttp.client.quick.backend
import sttp.client.{Identity, Response, UriContext, basicRequest}

class testQueryTerm(key: String) {
  def get: Response[Either[String, String]] = basicRequest
    .get(uri"https://services.prewave.ai/adminInterface/api/testQueryTerm?key=$key").send()
}
