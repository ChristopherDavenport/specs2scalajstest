package io.chrisdavenport.specs2jstest

import org.specs2._
import org.specs2.concurrent.ExecutionEnv
import scala.concurrent.Future

class SeemsToWorkSpec extends mutable.Specification {
  import scala.concurrent.ExecutionContext.Implicits.global

  "Seems to work with the global Execution Context" should {
    "match a future using scalajs" in {
      Future(ok)
    }
  }

}

class FailsToInitialize(implicit ee: ExecutionEnv) extends mutable.Specification {
  "Seems to fail" should {
    "match a future using scalajs" in {
      Future(ok)
    }
  }
}