package com.tookitaki.rs

import com.typesafe.config.Config
import org.apache.log4j.{LogManager, Logger}
import org.apache.spark.sql._

import scala.util.{Failure, Success, Try}

/**
  * Main class that takes in parameters and calls the table creation logic
  *
  */
object RecADriver extends SparkJob with entities {
  @transient lazy val logger: Logger = LogManager.getLogger(this.asInstanceOf[Any].getClass)

  /**
    * This function only does I/O, no logic
    *
    * @param sparkSession - A unified entry point for manipulating data with Spark
    * @param config       - Config object
    * @param reconConfig  - Config object
    * @param storage      - Storage object
    */
  override def run(sparkSession: SparkSession, config: Config, reconConfig: Config, storage: Storage): Unit = {
    val fe = Try {
      // STEP 0: Perform I/O
      logger.info("Performing I/O")
      val tableNameA: String = config.getString("RS.application_config.tableinfo.sourceDatabaseA") + "." + config.getString("RS.application_config.tableinfo.sourceTableA")
      val sourceDF = sparkSession.emptyDataFrame

      // STEP 1: Execute logic
      logger.info("Executing logic")
      val destDF: DataFrame = transform(sparkSession, sourceDF)

      // STEP 2: Save output data to destination
      logger.info("Saving output data to destination")
      // todo
    }

    fe match {
      case Failure(e) =>
        logger.error("RS RecA FAILURE", e)
      case Success(_) =>
        logger.info("RS RecA SUCCESS")
    }
  }

  /**
    * Any application logic is implemented here. No side effects
    *
    * @param sparkSession - A unified entry point for manipulating data with Spark
    * @param sourceDF     - Source DataFrame
    * @return - Destination DataFrame
    */
  def transform(sparkSession: SparkSession, sourceDF: DataFrame): DataFrame = {
    sparkSession.emptyDataFrame
  }
}