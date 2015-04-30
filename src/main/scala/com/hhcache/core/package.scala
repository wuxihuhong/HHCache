package com.hhcache

import com.typesafe.config.{ConfigFactory, Config}

/**
 * Created by huhong on 15/4/30.
 */
package object core {
  private[hhcache] val rootConfig = ConfigFactory.load()


  private[hhcache] val cacheConfig = rootConfig.getConfig("cache_system")
}
