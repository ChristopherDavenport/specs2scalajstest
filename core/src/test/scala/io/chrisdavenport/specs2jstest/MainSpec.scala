package io.chrisdavenport.specs2jstest

import org.specs2._
import org.specs2.matcher.FutureMatchers
import org.specs2.concurrent.ExecutionEnv
import scala.concurrent.Future
import scala.concurrent.duration._

class SeemsToWorkSpec extends mutable.Specification with FutureMatchers {
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

class LinkingErrorClass(implicit ee: ExecutionEnv) extends mutable.Specification {
  "Fails on await" in {
    futureAsResult(Future(ok)).awaitFor(1.second)
  }
}

// What I want is given an IO[Result]. Have some way to evaluate that with specs2 on scalajs.
// Any ideas to that end appreciated.
// https://github.com/djspiewak/cats-effect-testing/pull/70/files