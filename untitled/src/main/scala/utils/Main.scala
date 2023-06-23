package utils

import Defense._
import Data._
import scala.util.{Try, Success, Failure}

object Main {
  def main(args: Array[String]): Unit = {

    var option: Int = 0

    //TODO переделать на проперти и конфиги
    println("Данное приложение рассчитывает категории и конкретные меры защиты информации для указанной Угрозы Безопасности Информации")
    println("Возможные опции:\n1) Прочитать HELP\n2) Начать работу")

    while (option != 1 || option != 2) {
      Try {
        scala.io.StdIn.readLine("Выберите опцию: ").toInt
      } match {
        case Success(x) => option = x
        case Failure(x) => _
      }
    }

    option match {
      case 1 => //TODO сюда выводить хелп
      case 2 => println("Начинаем работу...")
    }

    var flag = 0
    while (flag == 0) {

      var threatsSource: Int = inner.length + outer.length + 1
      var methodNum: Int = methods.length + 1
      var threatType: Int = 0
      var threatAfter: Int = 0
      var tmpThreats: Seq[String] = Seq.empty[String]

      println("Внутренние")
      for (i <- inner.indices) {
        println(s"$i ${inner(i)}")
      }
      println("\nВнешние")
      for (i <- outer.indices) {
        println(s"${i + inner.length} ${outer(i)}")
      }

      while (threatsSource > inner.length + outer.length) {
        Try {
          scala.io.StdIn.readLine("Выберите номер источника угроза безопасности из списка выше: ").toInt
        } match {
          case Success(x) => threatsSource = x
          case Failure(x) => _
        }
      }

      val obj = scala.io.StdIn.readLine("Введите объект воздействия: ").toInt

      println("Способы реализации")
      for (i <- methods.indices) {
        println(s"$i ${methods(i)}")
      }

      while (methodNum > methods.length) {
        Try {
          scala.io.StdIn.readLine("Выберите номер способа реализации угрозы безопасности из списка выше: ").toInt
        } match {
          case Success(x) => methodNum = x
          case Failure(x) => _
        }
      }

      while (threatType != 1 || threatType != 2 || threatType != 3) {
        Try {
          scala.io.StdIn.readLine("Введите номер вида риска (ущерба): ").toInt
        } match {
          case Success(x) => threatType = x
          case Failure(x) => _
        }
      }

      println("Негативные последствия")
      threatType match {
        case 1 => {for (i <- negative_impact_1.indices) {
          println(s"$i ${negative_impact_1(i)}")}
          tmpThreats = negative_impact_1
        }

        case 2 => {for (i <- negative_impact_2.indices) {
          println(s"$i ${negative_impact_2(i)}")}
          tmpThreats = negative_impact_2
        }
        case 3 => {for (i <- negative_impact_3.indices) {
          println(s"$i ${negative_impact_3(i)}")}
          tmpThreats = negative_impact_3
        }
      }

      while (threatAfter > tmpThreats.length) {
        Try {
          scala.io.StdIn.readLine("Выберите номер возможных типовых негативных последствий: ").toInt
        } match {
          case Success(x) => threatsSource = x
          case Failure(x) => _
        }
      }
    }
  }
}
