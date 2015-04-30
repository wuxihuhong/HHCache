package com.hhcache.core

import java.util.UUID
import java.util.concurrent.TimeUnit

import akka.actor.ActorRef
import akka.util.Timeout
import akka.util.Timeout._

import scala.concurrent.Await
import scala.concurrent.duration._
import akka.pattern.ask

/**
 * Created by huhong on 15/4/30.
 */
trait CacheEntity[T] extends Serializable {

  val id: String
  val timeout: Duration

  implicit val serializationDuration = Option(cacheConfig.getLong("serialization.timeout") milliseconds).getOrElse(1500 milliseconds)

  implicit val serializationTime: Timeout = serializationDuration

  @transient
  def keys: Seq[Key] = Nil

  @transient
  def idToBytes(implicit actorRef: ActorRef): Array[Byte] = {
    val f = actorRef ? id

    Await.result(f.mapTo[Array[Byte]], serializationDuration)
  }

  @transient
  def keysToBytes(implicit actorRef: ActorRef): Seq[Array[Byte]] = {
    val f = actorRef ? keys


    Await.result(f.mapTo[Array[Byte]], serializationDuration).asInstanceOf[Seq[Array[Byte]]]
  }

}


class SimpleCacheEntity(val id: String, val data: Serializable, val timeout: Duration = 0 milliseconds, val createdBy: Long = System.currentTimeMillis()) extends CacheEntity[Serializable] {

}


class UUIDCacheEntity(data: Serializable, timeout: Duration = 0 milliseconds, createdBy: Long = System.currentTimeMillis()) extends SimpleCacheEntity(UUID.randomUUID().toString, data, timeout, createdBy)

