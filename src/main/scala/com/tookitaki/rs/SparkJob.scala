package com.tookitaki.rs

import java.io.File

import com.typesafe.config.{Config, ConfigFactory}
import org.apache.spark.sql.SparkSession

trait SparkJob {
  def main(args: Array[String]): Unit = {
    val sparkSession: SparkSession = new SparkSession
      .Builder()
      .enableHiveSupport()
      .getOrCreate()
    sparkSession.conf.set("spark.sql.cbo.enabled", "true")

    val confFilePath = args(0)
    val config: Config = ConfigFactory.parseFile(new File(confFilePath))
    val reconConfFilePath = args(1)
    val reconConfig: Config = ConfigFactory.parseFile(new File(reconConfFilePath))

    run(sparkSession, config, reconConfig, new Storage(sparkSession))

    sparkSession.stop()
  } // End of Main Class

  def run(spark: SparkSession, config: Config, reconConfig: Config, storage: Storage)
}
