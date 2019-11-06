package com.tioeun.a20191106_01_listviewpractice.datas

import java.io.Serializable

class NoticeData(intputTitle:String, content:String, writeDate:String) :Serializable {

    var title = intputTitle
    var content = content
    var date = writeDate
}