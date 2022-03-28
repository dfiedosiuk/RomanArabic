import Main.args

import scala.sys.exit

object MyPropt {

  case class Config(
                     arabic: Int = -1,
                     roman: String = "ZERO")

  import scopt.OParser

  val DanielsBuilder = OParser.builder[Config]

  val parser1 = {
    import DanielsBuilder._

    OParser.sequence(
      opt[String]('r', "roman")
        .action((x, conf) => conf.copy(roman = x))
        .text("Name property"),
      opt[Int]('a', "arabic")
        .action((n,conf) => conf.copy(arabic = n))
        .text("ID property")
    )
  }



}
