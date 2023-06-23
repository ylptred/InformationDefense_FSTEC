package utils

import akka.actor.ActorSystem
import akka.stream.Materializer
import io.cequence.openaiscala.service.OpenAIServiceFactory

import scala.concurrent.ExecutionContext

object Defense {
  def calculDefenseImpr(): Unit = {
    implicit val ec = ExecutionContext.global
    implicit val materializer = Materializer(ActorSystem())
    val service = OpenAIServiceFactory(
      apiKey = "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"
    )

    val text = "Предложи меры защиты информации для следующей Угрозы Безопасности Информации: источник угрозы - авторизованный пользователь систем и сетей; объект воздействия - сервер; способ реализации - желание самореализации; негативные последствия - потеря конкуретного преимущества"

    service.createCompletion(text).map(completion =>
      println(completion.choices.head.text)
    )
  }
}
