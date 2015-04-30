package com.hhcache.core

/**
 * Created by huhong on 15/4/30.
 */
package object serialization {

  case class Serialize[T](value: T)

  case class DeSerialize[T](value: T)

}
