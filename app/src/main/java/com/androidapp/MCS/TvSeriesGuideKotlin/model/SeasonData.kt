package com.androidapp.MCS.TvSeriesGuideKotlin.model

class SeasonData {
    companion object {
        lateinit var seasonsList: List<Seasons>
        lateinit var seasonsMap:Map<String, Seasons>

    }

    init {
        seasonsList = java.util.ArrayList()
        seasonsMap = java.util.HashMap()
       addItem(Seasons("1"))
       addItem(Seasons("2"))
       addItem(Seasons("3"))
       addItem(Seasons("4"))
       addItem(Seasons("5"))
       addItem(Seasons("6"))
       addItem(Seasons("7"))
       addItem(Seasons("8"))
       addItem(Seasons("9"))
       addItem(Seasons("10"))
   }


     fun addItem(item: Seasons) {
//        seasonsList.add(item)
//        seasonsMap.put(item.itemId,item)

    }
}