package datatypes

import io.circe.{Decoder, Encoder}

object implicits {
  implicit val decodeContents: Decoder[Contents] =
    Decoder.forProduct3("text", "type", "language")(Contents.apply)

  implicit val encodeContents: Encoder[Contents] =
    Encoder.forProduct3("text", "type", "language")(x => (x.text, x.typeId, x.language))


  implicit val decodeTestAlerts: Decoder[TestAlerts] =
    Decoder.forProduct4("id", "contents", "date", "inputType")(TestAlerts.apply)

  implicit val encodeTestAlerts: Encoder[TestAlerts] =
    Encoder.forProduct4("id", "contents", "date", "inputType")(x => (x.id, x.contents, x.date, x.inputType))


  implicit val decodeTestQueryTerm: Decoder[TestQueryTerm] =
    Decoder.forProduct5("id", "target", "text", "language", "keepOrder")(TestQueryTerm.apply)

  implicit val encodeTestQueryTerm: Encoder[TestQueryTerm] =
    Encoder.forProduct5("id", "target", "text", "language", "keepOrder")(x => (x.id, x.target, x.text, x.language, x.keepOrder))
}
