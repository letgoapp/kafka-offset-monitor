package com.quantifind.kafka.offsetapp.mysql

import com.quantifind.kafka.OffsetGetter.OffsetInfo
import com.quantifind.kafka.offsetapp.{OWArgs, OffsetDB, OffsetInfoReporter}

class MysqlOffsetInfoReporter(db: OffsetDB, args: OWArgs) extends OffsetInfoReporter {

  override def report(info: IndexedSeq[OffsetInfo]): Unit = {
    db.insertAll(info)
  }

  override def cleanupOldData() {
    db.emptyOld(System.currentTimeMillis - args.retain.toMillis)
  }

}
