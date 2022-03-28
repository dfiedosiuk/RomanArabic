case class Converter() {

}

object Converter {
  def arabicToRoman(digits: Int): String = {
    val haundreds = Map("0" -> "", "1" -> "C", "2" -> "CC", "3" -> "CCC", "4" -> "CD", "5" -> "D", "6" -> "DC", "7" -> "DCC", "8" -> "DCCC", "9" -> "CM")
    val tens = Map("0" -> "", "1" -> "X", "2" -> "XX", "3" -> "XXX", "4" -> "XL", "5" -> "L", "6" -> "LX", "7" -> "LXX", "8" -> "LXXX", "9" -> "XC")
    val units = Map("0" -> "", "1" -> "I", "2" -> "II", "3" -> "III", "4" -> "IV", "5" -> "V", "6" -> "VI", "7" -> "VII", "8" -> "VIII", "9" -> "IX")
    val digitsIdx = digits.toString.zipWithIndex
    val converted = digitsIdx.map { case (digit, idx) =>
      idx match {
        case 0 => (haundreds(digit.toString), idx)
        case 1 => (tens(digit.toString), idx)
        case 2 => (units(digit.toString), idx)
      }
    }
    val score = converted.reverse.foldLeft("")((result, n) =>
    n._1 ++ result
    )
    score
  }
//  var sumStart = 0
//  var result = 0

  def romanToArabic(letters: String, sum: Int): Int = {
    val specialNumbers = Map("IV"->4,"IX"->9,"XL"->40,"XC"->90,"CD"->400,"CM"->900)
    val numbers = Map("I"-> 1,"V"-> 5,"X"-> 10,"L"-> 50,"C"-> 100,"D"-> 500,"M"-> 1000)
//    numbers.foldLeft(List.empty[])
//    letters.startsWith(specialNumbers) match {
//      case true => {
//        sumStart = sum + specialNumbers(letters.take(2))
//        romanToArabic(letters.drop(2),sumStart)
//      }
//      case false => {
//        sumStart = sum + numbers(letters.head.toString)
//        romanToArabic(letters.tail, sumStart)
//      }
//      case _ => result = sum
//    }

    if (specialNumbers.contains(letters.take(2)) && letters.nonEmpty) {
      val nextSum = sum + specialNumbers(letters.take(2))
      romanToArabic(letters.drop(2),nextSum)}
    else if (!(letters.startsWith(specialNumbers)) && letters.nonEmpty){
      val nextSum = sum + numbers(letters.head.toString)
      romanToArabic(letters.tail, nextSum)}
    else if (letters.isEmpty) sum
    else 999

  }

}