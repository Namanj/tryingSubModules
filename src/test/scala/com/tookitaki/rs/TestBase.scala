package com.tookitaki.rs

import org.scalatest._

abstract class TestBase extends FlatSpec with BeforeAndAfterAll with SparkSessionTestWrapper {

  override protected def beforeAll(): Unit = {
    super.beforeAll()
  }

  override protected def afterAll(): Unit = {
    try {
      sparkSession.stop()
    } finally {
      super.afterAll()
    }
  }
}
