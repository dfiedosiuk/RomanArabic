import MyPropt.{Config, parser1}
import scopt.OParser

import scala.sys.exit

object Main extends App {
  val converter = Converter

  val myConfig = OParser.parse(parser1, args, Config()).getOrElse{
    println("Hey error ")
    exit(-1)}

    val resultAtoR = converter.arabicToRoman(myConfig.arabic)
    println(s"${myConfig.arabic} ---> ${resultAtoR}")

    val resultRtoA = converter.romanToArabic(myConfig.roman,0)
    println(s"${myConfig.roman} ---> ${resultRtoA}")
}

