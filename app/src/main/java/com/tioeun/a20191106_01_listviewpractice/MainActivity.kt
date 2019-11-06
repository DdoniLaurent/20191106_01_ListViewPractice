package com.tioeun.a20191106_01_listviewpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tioeun.a20191106_01_listviewpractice.Adapter.NoticeAdapter
import com.tioeun.a20191106_01_listviewpractice.datas.NoticeData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var noticeList = ArrayList<NoticeData>()
    var noticeAdapter:NoticeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setUpEvent()
        setValues()


    }

    fun setValues(){
        addNoties()

        noticeAdapter = NoticeAdapter(this, noticeList)
        noticeListView.adapter = noticeAdapter
    }

    fun setUpEvent(){
        addNoticeBtn.setOnClickListener {
            noticeList.add(NoticeData("새 공지사항", "내용도 적어봅니다.", "2019-11-06"))

//            데이터 변경사항 => 리스트뷰에 반영
            noticeAdapter?.notifyDataSetChanged()

//            10칸 => 9반. 150칸 => 149
            noticeListView.smoothScrollToPosition(noticeList.size-1)
        }


        noticeListView.setOnItemClickListener { parent, view, position, id ->
            //            Toast.makeText(this, "${position} 번째 줄 클릭", Toast.LENGTH_LONG).show()
            var noticeData = noticeList.get(position)
            var intent = Intent(this, NoticeDetailActivity::class.java)
            intent.putExtra("noticeData", noticeData)

            startActivity(intent)
        }

        noticeListView.setOnItemLongClickListener { parent, view, position, id ->
            Toast.makeText(this, "${position} 번째 길게 줄 클릭", Toast.LENGTH_LONG).show()
            return@setOnItemLongClickListener true
        }
    }

    fun addNoties(){
        noticeList.add(NoticeData("1번 공지", "1번 내용입니다.", "2019-01-01"))
        noticeList.add(NoticeData("2번 공지", "2번 내용입니다.", "2019-02-05"))
        noticeList.add(NoticeData("3번 공지", "3번 내용입니다.", "2019-03-07"))
        noticeList.add(NoticeData("4번 공지", "4번 내용입니다.", "2019-04-15"))
        noticeList.add(NoticeData("5번 공지", "5번 내용입니다.", "2019-05-05"))
        noticeList.add(NoticeData("6번 공지", "6번 내용입니다.", "2019-06-13"))
        noticeList.add(NoticeData("7번 공지", "7번 내용입니다.", "2019-07-31"))
        noticeList.add(NoticeData("8번 공지", "8번 내용입니다.", "2019-8-16"))
        noticeList.add(NoticeData("9번 공지", "9번 내용입니다.", "2019-09-26"))
        noticeList.add(NoticeData("10번 공지", "10번 내용입니다.", "2019-01-01"))
    }
}
